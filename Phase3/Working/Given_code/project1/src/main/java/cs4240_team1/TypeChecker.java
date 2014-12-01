package cs4240_team1;

import java.util.List;
import org.antlr.runtime.Token;

public class TypeChecker {

	/** Returns null if arguments are not compatible for logical operators. */
	public static TigerType getTypeAfterLogical(TigerType type1, TigerType type2) {
		/* only booleans are valid in logical */
		if (type1.isValidInLogical() && type2.isValidInLogical()) {
			return TigerType.BOOLEAN_TYPE;
		}
		return null;
	}

	/** Returns null if arguments are not compatible for comparison operators. */
	public static TigerType getTypeAfterComparison(TigerType type1, TigerType type2) {
		if (type1.isValidInComparison()	&& type2.isValidInComparison()) {

			/* obeys same rules as arithmetic, but result is always boolean */
			return (getTypeAfterArithmetic(type1, type2) != null)
				? TigerType.BOOLEAN_TYPE  
				: null;
		}
		return null;
	}

	/** Returns null if types are incompaitble for arithmetic operations. */
	public static TigerType getTypeAfterArithmetic(TigerType type1, TigerType type2) {
		if (!type1.isValidInArithmetic() || !type2.isValidInArithmetic()) {
			return null;
		}

		switch (type1.typeClass) {

		case LITERAL_INT:
		case BASE_INT:
			switch (type2.typeClass) {
				case LITERAL_INT:
				case BASE_INT:
					return TigerType.BASE_INT_TYPE;

				/* promote 'int' to 'fixedpt' */
				case LITERAL_FIXEDPT:
				case BASE_FIXEDPT:
					return TigerType.BASE_FIXEDPT_TYPE;

				default:
					return null;
			}

		case LITERAL_FIXEDPT:
		case BASE_FIXEDPT:
			switch (type2.typeClass) {
				/* promote 'int' to 'fixedpt' */
				case LITERAL_INT:
				case BASE_INT:
					return TigerType.BASE_FIXEDPT_TYPE;

				case LITERAL_FIXEDPT:
				case BASE_FIXEDPT: 
					return type2;

				default:
					return null;
			}

		case DERIVED_INT:
		case DERIVED_FIXEDPT:
			return type1.isEquivalentTo(type2) ? type1 : null;

		default:
			return null;
		}
	}

	/** Use this for checking compatibility with return type. */
	public static boolean exprTypeIsReturnable(TigerType exprType, TigerType returnType) {
		/* CASE 1:  returnType is void */
		if (returnType.isVoid()) {
			return false;
		}

		/* CASE 2:  returnType is non-void -- use same rule as assigns! */
		return returnType.isAssignableFrom(exprType);
	}

	public static boolean isBaseTypeId(String typeId) {
		return "int".equals(typeId) || "fixedpt".equals(typeId);
	}

	public static boolean isDerivedTypeId(String typeId, SymbolTable symTable) {
		return symTable.lookupType(typeId) != null;
	}

	public static boolean isNonVoidTypeId(String typeId, SymbolTable symTable) {
		return isBaseTypeId(typeId) || isDerivedTypeId(typeId, symTable);
	}

}
