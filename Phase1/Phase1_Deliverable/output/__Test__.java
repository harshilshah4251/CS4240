import java.io.*;
import org.antlr.runtime.*;
import org.antlr.runtime.debug.DebugEventSocketProxy;


public class __Test__ {

    public static void main(String args[]) throws Exception {
        TigerLexer lex = new TigerLexer(new ANTLRFileStream("/home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Modified_Tiger.txt", "UTF8"));
        CommonTokenStream tokens = new CommonTokenStream(lex);

        TigerParser g = new TigerParser(tokens, 49100, null);
        try {
            g.tiger_program();
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}