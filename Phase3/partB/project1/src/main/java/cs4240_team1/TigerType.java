package cs4240_team1;

/** A class to represent all Tiger types, including "void" and implicit "boolean" */
public class TigerType {

	public final TypeClass typeClass;
	public final String typeId;
	public final Integer dimension1;  /* null if type is not an array */
	public final Integer dimension2;  /* null if type is not a 2D array */

	/*
	 * convenience references for types we will need to create
	 * without using a TypeEntry (for booleans, indexed arrays, and literals)
	 */
	public static final TigerType VOID_TYPE = new TigerType(TypeClass.VOID, "void");
	public static final TigerType BOOLEAN_TYPE = new TigerType(TypeClass.BOOLEAN, "_boolean");
	public static final TigerType LITERAL_INT_TYPE = new TigerType(TypeClass.LITERAL_INT, "int");
	public static final TigerType LITERAL_FIXEDPT_TYPE = new TigerType(TypeClass.LITERAL_FIXEDPT, "fixedpt");
	public static final TigerType BASE_INT_TYPE = new TigerType(TypeClass.BASE_INT, "int");
	public static final TigerType BASE_FIXEDPT_TYPE = new TigerType(TypeClass.BASE_FIXEDPT, "fixedpt");
	
	public TigerType(TypeClass typeClass, String typeId) {
		this(typeClass, typeId, null, null);
	}

	public TigerType(TypeClass typeClass, String typeId, Integer dimension1, Integer dimension2) {
		this.typeClass = typeClass;
		this.typeId = typeId;
		this.dimension1 = dimension1;
		this.dimension2 = dimension2;
	}

	public TigerType(TypeEntry typeEntry) {
		this(extractTypeClass(typeEntry), typeEntry.typeId, typeEntry.dimension1, typeEntry.dimension2);
	}

	/** TODO refactor so we do not have to use the old TypeEntry like this */
	private static TypeClass extractTypeClass(TypeEntry typeEntry) {
		TypeClass typeClass;
		String baseType = typeEntry.derivedId;

		/* NOTE:  a "TypeEntry" will never be a base type -- only aliases and arrays */
		if ("int".equals(baseType)) {
			if (typeEntry.isArray()) {
				return TypeClass.ARRAY_INT;
			} else {
				return TypeClass.DERIVED_INT;
			}
		} else if ("fixedpt".equals(baseType)) {
			if (typeEntry.isArray()) {
				return TypeClass.ARRAY_FIXEDPT;
			} else {
				return TypeClass.DERIVED_FIXEDPT;
			}
		} else {
			throw new RuntimeException("typeEntry has invalid derivedType of " + baseType);
		}
	}

	/** If we have x := y, we want to know if x.isAssignableFrom(y) is true (do not use for opt-init) */
	public boolean isAssignableFrom(TigerType rvalueType) {
		TypeClass rvalueTypeClass = rvalueType.typeClass;

		switch (this.typeClass) {
		case BASE_INT:
			return rvalueTypeClass == TypeClass.BASE_INT
				|| rvalueTypeClass == TypeClass.LITERAL_INT;

		case BASE_FIXEDPT:
			return rvalueTypeClass == TypeClass.LITERAL_INT
				|| rvalueTypeClass == TypeClass.BASE_INT
				|| rvalueTypeClass == TypeClass.LITERAL_FIXEDPT
				|| rvalueTypeClass == TypeClass.BASE_FIXEDPT;

		case DERIVED_INT:
		case DERIVED_FIXEDPT:
		case ARRAY_INT:
		case ARRAY_FIXEDPT:
			return this.isEquivalentTo(rvalueType);

		/* none of the other TypeClasses can be lvalueTypes */
		default:
			return false;
		}
	}

	/** Use this rule for opt-init */
	public boolean isInitializableFrom(TigerType rvalueType) {
		TypeClass rvalueTypeClass = rvalueType.typeClass;

		/* recall: rvalue can only be a literal */
		switch (this.typeClass) {
		case BASE_INT:
		case DERIVED_INT:
		case ARRAY_INT:
			return rvalueTypeClass == TypeClass.LITERAL_INT;

		case BASE_FIXEDPT:
		case ARRAY_FIXEDPT:
			return rvalueTypeClass == TypeClass.LITERAL_INT
				|| rvalueTypeClass == TypeClass.LITERAL_FIXEDPT;

		case DERIVED_FIXEDPT:
			return rvalueTypeClass == TypeClass.LITERAL_FIXEDPT;

		/* none of the other TypeClasses can be lvalueTypes */
		default:
			return false;
		}
	}

	public boolean isVoid() {
		return this.typeClass == TypeClass.VOID;
	}

	/** Refers to logical operators '&amp;' and '|' */
	public boolean isValidInLogical() {
		return this.typeClass == TypeClass.BOOLEAN;
	}

	public boolean isValidInComparison() {
		return isValidInArithmetic();
	}

	public boolean isValidInArithmetic() {
		switch (this.typeClass) {
		case LITERAL_INT:
		case LITERAL_FIXEDPT:
		case BASE_INT:
		case BASE_FIXEDPT:
		case DERIVED_INT:
		case DERIVED_FIXEDPT:
			return true;

		default:
			return false;
		}
	}

	/** To use for both array index checking and for-loop expressions */
	public boolean isValidInIndexArithmetic() {
		return this.typeClass == TypeClass.LITERAL_INT
			|| this.typeClass == TypeClass.BASE_INT;
	}

	/** Operates on name equivalence. */
	public boolean isEquivalentTo(TigerType other) {
		return this.typeClass == other.typeClass && this.typeId.equals(other.typeId);
	}

	public boolean isArray() {
		return this.typeClass == TypeClass.ARRAY_INT
			|| this.typeClass == TypeClass.ARRAY_FIXEDPT;
	}

	public boolean isArray1D() {
		return dimension1 != null && dimension2 == null;
	}

	public boolean isArray2D() {
		return dimension1 != null && dimension2 != null;
	}

	/**
	 * Makes sure the index for a variable is valid.
	 *
	 * It is okay to not index an array, but if there is an index,
	 * it cannot be a partial index.
	 */
	public boolean isValidIndexCount(int indexCount) {
		switch (indexCount) {
		case 0:
			return true;  /* note: it is okay to NOT index an array */

		case 1:
			return this.isArray1D();  /* no partial indexing */

		case 2:
			return this.isArray2D();  /* no partial indexing */

		default:
			return false;  /* invalid indexCount */
		}
	}

	/**
	 * Use this method to convert get type from "value" grammar rule.
	 *
	 * If type is a non-array or non-indexed array, returns the current type.
	 * If type is an indexed array, returns the appropriate base type.
	 *
	 * Returns null if index is invalid
	 */
	public TigerType getTypeAfterIndex(int indexCount) {
		if (!this.isValidIndexCount(indexCount)) {
			return null;
		}

		switch (indexCount) {
		case 0:
			return this;

		case 1:
		case 2:
			if (this.typeClass == TypeClass.ARRAY_INT) {
				return TigerType.BASE_INT_TYPE;
			} else if (this.typeClass == TypeClass.ARRAY_FIXEDPT) {
				return TigerType.BASE_FIXEDPT_TYPE;
			} else {
				return null;
			}

		default:
			return null;
		}
	}

	@Override
	public String toString() {
		return this.typeId;
	}

	public String toStringForSymbolTable() {
		switch (typeClass) {
		case BASE_INT:
			return "int";
		case BASE_FIXEDPT:
			return "fixedpt";
		case DERIVED_INT:
			return typeId + " (int)";
		case DERIVED_FIXEDPT:
			return typeId + " (fixedpt)";
		case ARRAY_INT:
			return typeId + " (int[" + dimension1 + "]" + (isArray2D() ? ("[" + dimension2 + "])") : ")");
		case ARRAY_FIXEDPT:
			return typeId + " (int[" + dimension1 + "]" + (isArray2D() ? ("[" + dimension2 + "])") : ")");
		default:
			return this.typeId;
		}
	}
}
