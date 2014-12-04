package cs4240_team1;

import java.util.Arrays;
import java.util.List;

import org.antlr.runtime.Token;

/**
 * This class should be used to host static helper functions which
 * implement semantic-checking functionality for SymTableWalker.g
 * 
 * @author vancan1ty
 */
public class SemanticChecks {
	
	public static String[] stdLibraryFunctions = new String[]{
		"print", "printi", "flush", "getchar", "ord",
		"chr", "size", "substring", "concat", "not", "exit"
	};


	/** 
	 * This method will log error messages if there is the new SymTableEntry
	 * has a name collision with a reserved id.
	 * 
	 * Reserved Ids include...
	 *   standard library functions
	 *   "string"  (NOTE: string is not under list of 'keywords' in Tiger spec, so this is a semantic check)
	 *
	 * To be called at beginning of all declaration check functions.
	 *
	 * If true, the declaration check function should immediately
	 * return false (no other actions needed).
	 */
	private static boolean matches_reserved_id(
			Token token,
			SymbolTableEntry entryToInsert,
			List<SemanticError> errors) {

		String errorMessage;
		String errorFormat = String.format("%s '%s' cannot be declared - %s",
				entryToInsert.getCategoryAsString(),
				entryToInsert.tableKey,
				"%s");

		if (Arrays.asList(stdLibraryFunctions).contains(entryToInsert.tableKey)) {
			errorMessage = String.format(errorFormat, "illegal redeclaration of standard library function");
			errors.add(new SemanticError(token, errorMessage));
			return true;
		}

		if ("string".equals(entryToInsert.tableKey)) {
			errorMessage = String.format(errorFormat, "'string' is a reserved word");
			errors.add(new SemanticError(token, errorMessage));
			return true;
		}

		return false;
	}

	/**
	 * This method will log error messages and return true if there is a name
	 * collision with any previously declared id
	 * (including parent scopes - do not use this for var declarations).
	 *
	 * To be called at beginning of function, type declarations.
	 *
	 * If true, the declaration check function should immediately
	 * return false (no other actions needed).
	 */
	private static boolean matches_previous_declared_id(
			Token token,
			SymbolTableEntry entryToInsert,
			SymbolTable symTable,
			List<SemanticError> errors) {
		
		String errorMessage;
		String errorFormat = "%s '%s' cannot be declared - '%s' previously declared as a %s";

		SymbolTableEntry collisionEntry = symTable.lookup(entryToInsert.tableKey);
		if (collisionEntry != null) {
			errorMessage = String.format(
					errorFormat,
					entryToInsert.getCategoryAsString(),
					entryToInsert.tableKey,
					entryToInsert.tableKey,
					collisionEntry.getCategoryAsString());
			errors.add(new SemanticError(token, errorMessage));
			return true;
		}
		return false;
	}

	/**
	 * Returns true if typeIdToCheck is a valid type - use the allowVoidType flag to
	 * toggle whether or not the caller wants to allow "void" as a valid type for their case.
	 *
	 * Note that "void" only applies for function return types.
	 *
	 * Logs errors if needed, so declaration checker caller can immediately return on false return value.
	 */
	private static boolean id_is_valid_type(
			Token token,
			SymbolTableEntry entryToInsert,  /* only used for error message purposes */
			String typeIdToCheck,
			boolean allowVoidType,           /* needed because return types can be void */
			SymbolTable symTable,
			List<SemanticError> errors) {

		String errorMessage;
		String undeclaredErrorFormat = "%s '%s' cannot be declared - type '%s' has not been declared";
		String declaredErrorFormat = "%s '%s' cannot be declared - '%s' is not a declared type";

		if (TypeChecker.isNonVoidTypeId(typeIdToCheck, symTable)) {
			return true;
		} else if (allowVoidType && "void".equals(typeIdToCheck)) {  /* check for "void" if allowed */
			return true;
		} else {
			SymbolTableEntry collisionEntry = symTable.lookup(typeIdToCheck);

			errorMessage = String.format(
					(collisionEntry == null) ? undeclaredErrorFormat : declaredErrorFormat,
					entryToInsert.getCategoryAsString(),
					entryToInsert.tableKey,
					typeIdToCheck);

			errors.add(new SemanticError(token, errorMessage));
			return false;
		}
	}

	/**
	 * Checks that param name is not taken - logs error message if ID is taken.
	 * 
	 * TODO refactor so this is not its own special method
	 */
	private static boolean is_valid_param_id(
			Token token,
			FunctionEntry entryToInsert,  /* only used for error message purposes */
			String paramIdToCheck,
			SymbolTable symTable,  /* this will be global symbol table -- only types and funcs */
			List<SemanticError> errors) {

		String errorMessage;
		String errorFormat = String.format("%s '%s' cannot be declared - parameter has conflict with %s",
				entryToInsert.getCategoryAsString(),
				entryToInsert.tableKey,
				"%s");

		/* first check reserved id's:  std lib and string */
		if (Arrays.asList(stdLibraryFunctions).contains(paramIdToCheck)) {
			errorMessage = String.format(errorFormat, "the standard library function '" + paramIdToCheck + "'");
			errors.add(new SemanticError(token, errorMessage));
			return false;
		}

		if ("string".equals(paramIdToCheck)) {
			errorMessage = String.format(errorFormat, "the reserved word 'string'");
			errors.add(new SemanticError(token, errorMessage));
			return false;
		}

		/* then check if types or funcs have been declared ahead of it */
		SymbolTableEntry collisionEntry = symTable.lookup(paramIdToCheck);
		if (collisionEntry != null) {
			errorMessage = String.format(
					errorFormat,
					"previously-declared " + collisionEntry.getCategoryAsString() + " '" + paramIdToCheck + "'");
			errors.add(new SemanticError(token, errorMessage));
			return false;
		}

		return true;
	}

	/**
	 * Checks whether a TypeEntry can be safely inserted into the table.
	 * 
	 * Performs 2 checks:
	 * 
	 * 1.  Type ID is not taken
	 * 2.  Array types do not have 0 size in either dimension
	 */
	public static boolean check_type_declaration_valid(
			Token token,
			TypeEntry entryToInsert,
			SymbolTable symTable,
			List<SemanticError> errors) {

		String arrayErrorMessage = String.format(
				"type '%s' cannot be declared - cannot have size 0 in array dimensions",
				entryToInsert.typeId);

		/* Check 1 */
		if (matches_reserved_id(token, entryToInsert, errors)) {
			return false;
		}

		if (matches_previous_declared_id(token, entryToInsert, symTable, errors)) {
			return false;
		}

		/* Check 2 */
		if (entryToInsert.isArray1D() && entryToInsert.dimension1 == 0) {
			errors.add(new SemanticError(token, arrayErrorMessage));
			return false;
		}

		if (entryToInsert.isArray2D()
				&& (entryToInsert.dimension1 == 0 || entryToInsert.dimension2 == 0)) {
			errors.add(new SemanticError(token, arrayErrorMessage));
			return false;
		}

		return true;
	}

	/**
	 * Checks whether a FunctionEntry and VarEntry's for its parameters
	 * can be safely inserted into ther respective symbol tables.
	 *
	 * Performs the following checks...
	 *
	 * 1. Function ID not taken
	 * 2. Function return type is valid
	 * 3. Parameter types are valid
	 * 4. Parameter ID not taken
	 */
	public static boolean check_func_declaration_valid(
			Token token,
			FunctionEntry entryToInsert,
			SymbolTable symTable,
			List<SemanticError> errors) {
		
		/* Check 1 */
		if (matches_reserved_id(token, entryToInsert, errors)) {
			return false;
		}

		if (matches_previous_declared_id(token, entryToInsert, symTable, errors)) {
			return false;
		}

		/* Check 2 */
		if (!id_is_valid_type(token, entryToInsert, entryToInsert.returnTypeId, true, symTable, errors)) {
			return false;
		}

		/* Check 3 */
		boolean allParametersValid = true;
		for (Parameter p: entryToInsert.parameters) {
			if (!id_is_valid_type(token, entryToInsert, p.typeId, false, symTable, errors)
					|| !is_valid_param_id(token, entryToInsert, p.paramId, symTable, errors)) {
				allParametersValid = false;
			}
		}

		return allParametersValid;
	}

	/**
	 * checks a declaration for a preexisting conflicting entry.  
	 *
	 * Performs following checks:
	 * 
	 * 1.  Confirms that a symbol is not a redeclaration of a symbol already 
	 *     declared in the current precise scope.  
	 *
	 * 2.  Confirms that a symbol is not an attempt to (illegally) alias a 
	 *     symbol with the same name but different classification declared 
	 *     in an outer scope (F.E. you can't make a variable named pow if
	 *     there is already a function named pow in existence).
	 *
	 * 3.  Confirms that the symbol is not attempting to alias a protected
	 *     symbol.
	 *
	 * 4.  Confirms that var's type is valid
	 *     
	 * if there is an error, then the errors list is modified accordingly.
	 * 
	 * @param tkn the token representing the text we looking to add.
	 * @param entryToAdd the prospective entry to add to the symbol table
	 *        (declare).
	 * @param symTable 
	 * @param errors
	 * @return false if there was a validation error, otherwise true.
	 */
	public static boolean check_var_declaration_valid(
			Token tkn,
			VarEntry entryToInsert,
			SymbolTable symTable, 
			List<SemanticError> errors) {
		
		//check no. 3.
		if (matches_reserved_id(tkn, entryToInsert, errors)) {
			return false;
		}

		//check no. 1.
		if (symTable.getHt().containsKey(tkn.getText())) {
			errors.add(new SemanticError(tkn,"variable '" + tkn.getText() + 
					"' already declared in this scope"));
			return false;
		} 
	
		//check no. 2.
		SymbolTableEntry outerEntry = symTable.lookup(entryToInsert.tableKey); 
		if(outerEntry!=null) { //then we must make sure that the symbol
			                   //to be aliased has the same classification.
			//if the classifications do NOT match, we must add an error.
			if(!outerEntry.getClass().isAssignableFrom(entryToInsert.getClass())) {
				errors.add(new SemanticError(tkn, "'" + tkn.getText()
						+	"' already declared as " + outerEntry.getCategoryAsString()));
				return false;
			}
		}
		

		//check no. 4.
		if (!id_is_valid_type(tkn, entryToInsert, entryToInsert.typeId, false, symTable, errors)) {
			return false;
		}

		return true;
	} 

    /** Check function return type and function return value for agreement.
     * @param token the name
     * @param expression_type
     * @param function_type
     * @param errors
     * @return void*/
    public static void check_function_return(
			Token token,
			TigerType expr_type,
			TigerType function_return_type,
			List<SemanticError> errors) {

        if (!TypeChecker.exprTypeIsReturnable(expr_type, function_return_type)) {
			String errorMessage = (function_return_type.isVoid())
				? "cannot call 'return' inside of void function"
				: String.format(
						"cannot return expression of type '%s' from function with return type '%s'",
						expr_type,
						function_return_type);
            errors.add(new SemanticError(token, errorMessage));
        }
        return;
    }

    /** Check function return type and function return value for agreement.
     * @param token the name
     * @param in_scope
     * @param errors
     * @return void*/
    public static void check_break(Token token, boolean in_scope, List<SemanticError> errors) {

        if (!in_scope) {
            errors.add(new SemanticError(token, "BREAK statement cannot occur outside of loop!"));
        }
        return;
    }

}
