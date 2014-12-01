package cs4240_team1;

import org.antlr.runtime.Token;

/**
 * represents an error caught in the semantic analysis phase.
 * @author vancan1ty
 */
public class SemanticError {

	public int lineNumber;
	public int columnNumber;
	
	/**[CB 11/2/14] at the moment this variable is not used.  In the future it could be
	 * used to capture the problematic piece of the program to display to the user.
	 */
	public String lineContext;

	public String message;

	public SemanticError(Token token, String message) {
		this.lineNumber = token.getLine();
		this.columnNumber = token.getCharPositionInLine();
		this.message = message;
	}
	
	
	public String toString() {
       return lineNumber+":"+columnNumber+":\t" + message;
	}

}
