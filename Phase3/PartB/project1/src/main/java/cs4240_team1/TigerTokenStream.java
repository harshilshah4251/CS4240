package cs4240_team1;

import org.antlr.runtime.Token;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.MismatchedTokenException;
import org.antlr.runtime.UnwantedTokenException;
import org.antlr.runtime.MismatchedSetException;
import java.util.ArrayList;

/**
 * As tokens are consumed by parser, it updates the parser's list of tokens in the current line.
 */
public class TigerTokenStream extends CommonTokenStream {

    private ArrayList<Token> lineTokens;
    private int lineNumber;

    public TigerTokenStream(TigerLexer lexer) {
        super(lexer);
        lineTokens = new ArrayList<Token>();
        lineNumber = 0;  /* first line of text is line #1 */
    }

    @Override
    /** As tokens are consumed, keeps an updated list of tokens in the current line  */
    public void consume() {
        Token consumedToken = tokens.get(p);
        int tokenLineNumber = consumedToken.getLine();

        if (tokenLineNumber != lineNumber) {
            lineNumber = tokenLineNumber;
            lineTokens.clear();
        }

        lineTokens.add(consumedToken);

        super.consume();
    }

    /**
     * Returns an indented, two-line error message like so:
     * 
     *     list of token text prefixing the error_token
     *                                      ^
     */
    public String getCurrentLineForError(RecognitionException e) {
        StringBuilder errorString = new StringBuilder();
        int indexOfErrorToken = 0;

        errorString.append('\t');

        /* if no prefix tokens, then we will just print the error token and return */
        if (lineTokens.size() == 0 || e.token.getLine() != lineNumber) {
            errorString.append(e.token.getText());
            errorString.append("\n\t^");
            return errorString.toString();
        }

        /* build the line prefix  --  all tokens before error token */
        for (int i = 0; i < lineTokens.size() - 1; i++) {
            Token token = lineTokens.get(i);
            String tokenText = token.getText();
            
            errorString.append(tokenText);
            errorString.append(' ');

            indexOfErrorToken += tokenText.length() + 1;
        }


        Token lastConsumedToken = lineTokens.get(lineTokens.size() - 1);
        errorString.append(lastConsumedToken.getText());

        /* on NoViableAltException, the token is consumed after the error message is displayed
         * lineTokens, then, contained all prefix tokens
         * so we still need to add the error token and add it in our string
         */
        if (e instanceof NoViableAltException 
                || (e instanceof MismatchedTokenException && !(e instanceof UnwantedTokenException))
                || (e instanceof MismatchedSetException)) {
            errorString.append(' ');
            indexOfErrorToken += lastConsumedToken.getText().length() + 1;
            errorString.append(e.token.getText());
        }

        /* create line 2:  "          ^" */
        errorString.append("\n\t");
        for (int j = 0; j < indexOfErrorToken; j++) {
            errorString.append(' ');
        }
        errorString.append('^');

        return errorString.toString();
    }
}
