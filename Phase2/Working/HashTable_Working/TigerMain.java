import org.antlr.runtime.*;
import org.antlr.runtime.debug.DebugParser;

/**
 * Driver class for our Tiger Lexer/Parser
 */
public class TigerMain {
    public static void main(String[] args) {
        ANTLRInputStream input = null;
        TigerLexer lexer = null;
        TigerTokenStream tokens = null;
        TigerParser parser = null;
        boolean debugFlag = false;

        if (args.length != 0) {
            if (args.length == 1 && ("--debug".equals(args[0]) || "-d".equals(args[0]))) {
                debugFlag = true;
            } else {
                printInvalidArgsMessage();
                System.out.println("\nterminating...");
                System.exit(0);
            }
        }

        System.out.println("\n=========================");
        System.out.println("Reading input from stdin (to read from file, redirect stdin)...");
        
        try {
            input = new ANTLRInputStream(System.in);
        } catch (Exception e) {
            System.err.println("error: unable to use stdin as ANTLRInputStream\nterminating...");
            System.exit(0);
        }


        lexer = new TigerLexer(input);
        tokens = debugFlag ? new TigerDebugTokenStream(lexer) : new TigerTokenStream(lexer);
        parser = new TigerParser(tokens);

        /* for formatting purposes, add a line break between token names and error message in debug mode */
        if (debugFlag) {
            parser.errorPrefix = "\n\n";
        }

        System.out.printf("%sParsing input...%s\n\n",
                debugFlag ? "Running in debug mode (tokens will be printed as parser consumes them)...\n" : "",
                debugFlag ? "\n\nTokens consumed by parser:" : "");

        try {
            parser.tiger_program();
        } catch (RecognitionException e) {
            System.err.println("error: parser threw RecognitionException while parsing input");
            e.printStackTrace();
            System.err.println("\nterminating...");
            System.exit(0);
        }
        
        if (parser.getNumberOfSyntaxErrors() == 0 && lexer.getNumberOfSyntaxErrors() == 0) {
            System.out.println("\n\nSuccessful parse!");
        } else {
            System.out.println("\n\nUnsuccessful parse");
        }
        System.out.println("=========================\n");
    }

    private static void printInvalidArgsMessage() {
        System.out.println("invalid command line argument(s)");
        System.out.println("\nthere is only one valid, optional argument:");
        System.out.println("    --debug, -d        turns debug flag on to print token names");
        System.out.println("\nTo parse input from file path/foo.tig, redirect stdin to foo by running the following command:");
        System.out.println("    java TigerMain < path/foo.tig");
        System.out.println("\nTo parse input from path/foo.tig with debugging turned on, run:");
        System.out.println("    java TigerMain --debug < path/foo.tig");
    }
}
