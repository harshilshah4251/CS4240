package cs4240_team1;

public enum TypeClass {
	/* literals differ from base-type variables in the case of assignment */

	/* types to use for INTLIT, FIXEDPTLIT */
	LITERAL_INT,
	LITERAL_FIXEDPT,

	/* types to use for int, fixedpt vars and indexed arrays */
	BASE_INT,
	BASE_FIXEDPT,

	DERIVED_INT,
	DERIVED_FIXEDPT,

	ARRAY_INT,
	ARRAY_FIXEDPT,

	VOID,
	BOOLEAN
}
