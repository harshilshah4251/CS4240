package cs4240_team1;

import org.antlr.runtime.Token;

/**
 * Prints token type names to stdout when consumed.
 */
public class TigerDebugTokenStream extends TigerTokenStream {
    
    /* Protected members in BufferedTokenStream
     *
     * int p
     * This is the index of the next token to consume
     *
     * List<Token> tokens
     * the tokens...
     */

    public TigerDebugTokenStream(TigerLexer lexer) {
        super(lexer);
    }

    @Override
    /**
     * Print token names to stdout as the TigerParser consumes them.
     */
    public void consume() {
        Token consumedToken = tokens.get(p);
        int tokenNamesIndex = consumedToken.getType();

        if (tokenNamesIndex == Token.EOF) {
            System.out.print("<EOF> ");
        } else {
            String tokenType = TigerParser.tokenNames[tokenNamesIndex];
            System.out.print(tokenType + " ");
        }

        super.consume();
    }

}
