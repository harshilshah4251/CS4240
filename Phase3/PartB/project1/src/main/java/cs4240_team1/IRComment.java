package cs4240_team1;

public class IRComment extends IRInstruction {
	private String text;

	public IRComment(String text) {
		this.text = text;
	}
	
	public String toString() {
		return "/* " + text + " */";
	}

}
