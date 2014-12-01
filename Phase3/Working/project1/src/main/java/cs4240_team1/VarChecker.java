package cs4240_team1;

import java.util.List;
import java.util.Arrays;
import org.antlr.runtime.Token;

public class VarChecker {

	/** Returns the type of the variable - null if variable was undeclared (logs errors) */
	public static TigerType getTypeForVar(
			String varId,
			SymbolTable symTable,
			Token token,
			List<SemanticError> errors) {

		String errorMessage;
		SymbolTableEntry entry = symTable.lookup(varId);

		if (entry instanceof VarEntry) {
			return ( (VarEntry) entry ).getType();
		}

		if (entry == null) {
			if (Arrays.asList(SemanticChecks.stdLibraryFunctions).contains(varId)) {
				errorMessage = "attempting to use standard library function '" + varId + "' as a variable";
			} else if ("string".equals(varId)) {
				errorMessage = "attempting to use reserved name 'string' as a variable";
			} else {
				errorMessage = String.format("variable '%s' has not been declared in this scope", varId);
			}
		} else {
			errorMessage = String.format(
					"'%s' declared as %s - cannot use in place of variable",
					entry.getCategoryAsString(),
					entry.tableKey);
		}

		errors.add(new SemanticError(token, errorMessage));
		return null;
	}

}
