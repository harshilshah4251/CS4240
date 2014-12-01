package cs4240_team1;

public enum Op {
	ASSIGNVAR,
	ASSIGNARR,
	ASSIGNLIT,
	ADD,
	SUB,
	MULT,
	DIV,
	AND,
	OR,
	GOTO,
	BREQ,
	BRNEQ,
	BRLT,
	BRGT,
	BRGEQ,
	BRLEQ,
	RETURN,
	ARRAYSTORE,
	ARRAYLOAD,
	CALL,
	CALLR,
	LABEL;

	@Override
	public String toString() {
		if (this == Op.ASSIGNVAR || this == Op.ASSIGNARR || this == ASSIGNLIT) {
			return "assign";
		} else if (this == Op.ARRAYSTORE) {
			return "array_store";
		} else if (this == Op.ARRAYLOAD) {
			return "array_load";
		}
		return super.toString().toLowerCase();
	}
}
