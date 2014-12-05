package cs4240_team1;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.antlr.runtime.Token;

public class FunctionChecker {

	public static String[] invalidStandardLibraryFunctions = new String[]{
		"print", "getchar", "ord",
		"chr", "size", "substring", "concat"
	};

	public static String[] validStandardLibraryFunctions = new String[] {
		"printi", "flush", "not", "exit"
	};

	/** Returns null if func is not declared (will return standard lib funcs) -- handles error reporting */
	public static FunctionEntry getFunctionEntry(
			Token funcIdToken,
			SymbolTable symTable,
			List<SemanticError> errors) {

		String errorMessage;
		String funcId = funcIdToken.getText();
		SymbolTableEntry entry = symTable.lookup(funcId);

		/* this checks if user-defined function exists */
		if (entry instanceof FunctionEntry) {
			return (FunctionEntry) entry;
		}

		if (entry == null) {
			/* we have one more shot if not user-defined: standard library function */
			FunctionEntry standardLibEntry = symTable.lookupFunctionIncludingStdLib(funcId);
			if (standardLibEntry == null) {
				if ("string".equals(funcId)) {
					errorMessage = "attempting to use reserved name 'string' as a function";
				} else {
					errorMessage = isInvalidStandardLibraryFunction(funcId)
						? String.format("cannot call standard library function '%s' (no string support)", funcId)
						: String.format("attempting to use undeclared function '%s'", funcId);
				}
			} else {
				return standardLibEntry;
			}
		} else {
			errorMessage = String.format(
					"'%s' declared as %s (attempting to use as function)",
					entry.getCategoryAsString(),
					entry.tableKey);
		}
		errors.add(new SemanticError(funcIdToken, errorMessage));
		return null;
	}

	public static List<TigerType> extractParameterTypes(
			List<Parameter> parameters,
			SymbolTable symTable) {

		ArrayList<TigerType> paramTypes = new ArrayList<>();
		for (Parameter p: parameters) {
			TigerType type = symTable.resolveToTigerType(p.typeId);
			paramTypes.add(type);
		}
		return paramTypes;
	}

	public static boolean isInvalidStandardLibraryFunction(String funcId) {
		return Arrays.asList(invalidStandardLibraryFunctions).contains(funcId);
	}

	public static boolean isValidStandardLibraryFunction(String funcId) {
		return Arrays.asList(validStandardLibraryFunctions).contains(funcId);
	}

	/** Returns false iff argTypes are not compatible with paramTypes - will log errors */
	public static boolean checkArgTypes(
			List<TigerType> argTypes,
			List<TigerType> paramTypes,
			Token funcIdToken,
			List<SemanticError> errors) {

		String errorMessage;
		String funcId = funcIdToken.getText();
		
		int paramCount = paramTypes.size();
		int argCount = argTypes.size();

		if (paramCount != argCount) {
			errorMessage = String.format(
					"function '%s' called with %d argument%s (expected %d)",
					funcIdToken.getText(),
					argCount,
					argCount == 1 ? "" : "s",
					paramCount);
			errors.add(new SemanticError(funcIdToken, errorMessage));
			return false;
		}

		/* correct number -- now check that they all match */
		boolean isValid = true;
		for (int i = 0; i < argCount; i++) {
			TigerType argType = argTypes.get(i);
			TigerType paramType = paramTypes.get(i);
			if (!argumentTypeIsCompatible(argType, paramType)) {
				isValid = false;
			}
		}

		if (isValid) {
			return true;
		}

		errorMessage = String.format(
				"function called with incompatible types [expected: %s%s, actual: %s%s]",
				funcId,
				typeListToString(paramTypes),
				funcId,
				typeListToString(argTypes));
		errors.add(new SemanticError(funcIdToken, errorMessage));
		return false;
	}

	private static String typeListToString(List<TigerType> types) {
		String result = "(";
		String delim = "";
		for (TigerType type: types) {
			result += delim + type;
			delim = ", ";
		}
		result += ")";
		return result;
	}

	public static boolean argumentTypeIsCompatible(TigerType argType, TigerType paramType) {
		if (argType == null || paramType == null) {
			return false;
		}
		return paramType.isAssignableFrom(argType);
	}
}
