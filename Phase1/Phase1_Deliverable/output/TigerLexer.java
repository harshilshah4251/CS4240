// $ANTLR 3.5.1 /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g 2014-10-28 00:14:50

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class TigerLexer extends Lexer {
	public static final int EOF=-1;
	public static final int T__51=51;
	public static final int AND=4;
	public static final int ASSIGN=5;
	public static final int Array=6;
	public static final int Begin=7;
	public static final int Break=8;
	public static final int COLON=9;
	public static final int COMMA=10;
	public static final int COMMENT=11;
	public static final int DIV=12;
	public static final int Do=13;
	public static final int EQ=14;
	public static final int Else=15;
	public static final int End=16;
	public static final int Enddo=17;
	public static final int Endif=18;
	public static final int FIXEDPTLIT=19;
	public static final int Fixedpt=20;
	public static final int For=21;
	public static final int Function=22;
	public static final int GREATER=23;
	public static final int GREATEREQ=24;
	public static final int ID=25;
	public static final int INTLIT=26;
	public static final int If=27;
	public static final int Int=28;
	public static final int LBRACK=29;
	public static final int LESSER=30;
	public static final int LESSEREQ=31;
	public static final int LPAREN=32;
	public static final int MINUS=33;
	public static final int MULT=34;
	public static final int Main=35;
	public static final int NEQ=36;
	public static final int OR=37;
	public static final int Of=38;
	public static final int PLUS=39;
	public static final int RBRACK=40;
	public static final int RPAREN=41;
	public static final int Return=42;
	public static final int SEMI=43;
	public static final int Then=44;
	public static final int To=45;
	public static final int Type=46;
	public static final int Var=47;
	public static final int Void=48;
	public static final int WS=49;
	public static final int While=50;

	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public TigerLexer() {} 
	public TigerLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public TigerLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "/home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g"; }

	// $ANTLR start "T__51"
	public final void mT__51() throws RecognitionException {
		try {
			int _type = T__51;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:7:7: ( ' [' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:7:9: ' ['
			{
			match(" ["); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__51"

	// $ANTLR start "Function"
	public final void mFunction() throws RecognitionException {
		try {
			int _type = Function;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:17:10: ( 'function' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:17:12: 'function'
			{
			match("function"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Function"

	// $ANTLR start "Begin"
	public final void mBegin() throws RecognitionException {
		try {
			int _type = Begin;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:18:7: ( 'begin' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:18:9: 'begin'
			{
			match("begin"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Begin"

	// $ANTLR start "End"
	public final void mEnd() throws RecognitionException {
		try {
			int _type = End;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:19:5: ( 'end' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:19:7: 'end'
			{
			match("end"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "End"

	// $ANTLR start "Void"
	public final void mVoid() throws RecognitionException {
		try {
			int _type = Void;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:20:6: ( 'void' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:20:8: 'void'
			{
			match("void"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Void"

	// $ANTLR start "Main"
	public final void mMain() throws RecognitionException {
		try {
			int _type = Main;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:21:6: ( 'main' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:21:8: 'main'
			{
			match("main"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Main"

	// $ANTLR start "Type"
	public final void mType() throws RecognitionException {
		try {
			int _type = Type;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:22:6: ( 'type' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:22:8: 'type'
			{
			match("type"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Type"

	// $ANTLR start "Array"
	public final void mArray() throws RecognitionException {
		try {
			int _type = Array;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:23:7: ( 'array' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:23:9: 'array'
			{
			match("array"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Array"

	// $ANTLR start "Of"
	public final void mOf() throws RecognitionException {
		try {
			int _type = Of;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:24:4: ( 'of' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:24:6: 'of'
			{
			match("of"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Of"

	// $ANTLR start "Int"
	public final void mInt() throws RecognitionException {
		try {
			int _type = Int;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:25:5: ( 'int' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:25:7: 'int'
			{
			match("int"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Int"

	// $ANTLR start "Fixedpt"
	public final void mFixedpt() throws RecognitionException {
		try {
			int _type = Fixedpt;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:26:9: ( 'fixedpt' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:26:11: 'fixedpt'
			{
			match("fixedpt"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Fixedpt"

	// $ANTLR start "Var"
	public final void mVar() throws RecognitionException {
		try {
			int _type = Var;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:27:5: ( 'var' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:27:7: 'var'
			{
			match("var"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Var"

	// $ANTLR start "If"
	public final void mIf() throws RecognitionException {
		try {
			int _type = If;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:28:4: ( 'if' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:28:6: 'if'
			{
			match("if"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "If"

	// $ANTLR start "Then"
	public final void mThen() throws RecognitionException {
		try {
			int _type = Then;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:29:6: ( 'then' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:29:8: 'then'
			{
			match("then"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Then"

	// $ANTLR start "Endif"
	public final void mEndif() throws RecognitionException {
		try {
			int _type = Endif;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:30:7: ( 'endif' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:30:9: 'endif'
			{
			match("endif"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Endif"

	// $ANTLR start "Else"
	public final void mElse() throws RecognitionException {
		try {
			int _type = Else;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:31:6: ( 'else' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:31:8: 'else'
			{
			match("else"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Else"

	// $ANTLR start "While"
	public final void mWhile() throws RecognitionException {
		try {
			int _type = While;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:32:7: ( 'while' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:32:9: 'while'
			{
			match("while"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "While"

	// $ANTLR start "Do"
	public final void mDo() throws RecognitionException {
		try {
			int _type = Do;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:33:4: ( 'do' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:33:6: 'do'
			{
			match("do"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Do"

	// $ANTLR start "Enddo"
	public final void mEnddo() throws RecognitionException {
		try {
			int _type = Enddo;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:34:7: ( 'enddo' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:34:9: 'enddo'
			{
			match("enddo"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Enddo"

	// $ANTLR start "For"
	public final void mFor() throws RecognitionException {
		try {
			int _type = For;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:35:5: ( 'for' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:35:7: 'for'
			{
			match("for"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "For"

	// $ANTLR start "To"
	public final void mTo() throws RecognitionException {
		try {
			int _type = To;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:36:4: ( 'to' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:36:6: 'to'
			{
			match("to"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "To"

	// $ANTLR start "Break"
	public final void mBreak() throws RecognitionException {
		try {
			int _type = Break;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:37:7: ( 'break' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:37:9: 'break'
			{
			match("break"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Break"

	// $ANTLR start "Return"
	public final void mReturn() throws RecognitionException {
		try {
			int _type = Return;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:38:8: ( 'return' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:38:10: 'return'
			{
			match("return"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Return"

	// $ANTLR start "COMMA"
	public final void mCOMMA() throws RecognitionException {
		try {
			int _type = COMMA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:42:7: ( ',' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:42:9: ','
			{
			match(','); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMA"

	// $ANTLR start "COLON"
	public final void mCOLON() throws RecognitionException {
		try {
			int _type = COLON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:43:7: ( ':' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:43:9: ':'
			{
			match(':'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COLON"

	// $ANTLR start "SEMI"
	public final void mSEMI() throws RecognitionException {
		try {
			int _type = SEMI;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:44:6: ( ';' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:44:8: ';'
			{
			match(';'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SEMI"

	// $ANTLR start "LPAREN"
	public final void mLPAREN() throws RecognitionException {
		try {
			int _type = LPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:45:8: ( '(' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:45:10: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LPAREN"

	// $ANTLR start "RPAREN"
	public final void mRPAREN() throws RecognitionException {
		try {
			int _type = RPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:46:8: ( ')' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:46:10: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RPAREN"

	// $ANTLR start "LBRACK"
	public final void mLBRACK() throws RecognitionException {
		try {
			int _type = LBRACK;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:47:8: ( '[' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:47:10: '['
			{
			match('['); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LBRACK"

	// $ANTLR start "RBRACK"
	public final void mRBRACK() throws RecognitionException {
		try {
			int _type = RBRACK;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:48:8: ( ']' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:48:10: ']'
			{
			match(']'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RBRACK"

	// $ANTLR start "PLUS"
	public final void mPLUS() throws RecognitionException {
		try {
			int _type = PLUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:49:6: ( '+' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:49:8: '+'
			{
			match('+'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PLUS"

	// $ANTLR start "MINUS"
	public final void mMINUS() throws RecognitionException {
		try {
			int _type = MINUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:50:7: ( '-' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:50:9: '-'
			{
			match('-'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MINUS"

	// $ANTLR start "MULT"
	public final void mMULT() throws RecognitionException {
		try {
			int _type = MULT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:51:6: ( '*' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:51:8: '*'
			{
			match('*'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MULT"

	// $ANTLR start "DIV"
	public final void mDIV() throws RecognitionException {
		try {
			int _type = DIV;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:52:5: ( '/' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:52:7: '/'
			{
			match('/'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DIV"

	// $ANTLR start "EQ"
	public final void mEQ() throws RecognitionException {
		try {
			int _type = EQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:53:4: ( '=' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:53:6: '='
			{
			match('='); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EQ"

	// $ANTLR start "NEQ"
	public final void mNEQ() throws RecognitionException {
		try {
			int _type = NEQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:54:5: ( '<>' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:54:7: '<>'
			{
			match("<>"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NEQ"

	// $ANTLR start "LESSER"
	public final void mLESSER() throws RecognitionException {
		try {
			int _type = LESSER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:55:8: ( '<' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:55:10: '<'
			{
			match('<'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LESSER"

	// $ANTLR start "LESSEREQ"
	public final void mLESSEREQ() throws RecognitionException {
		try {
			int _type = LESSEREQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:56:10: ( '<=' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:56:12: '<='
			{
			match("<="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LESSEREQ"

	// $ANTLR start "GREATER"
	public final void mGREATER() throws RecognitionException {
		try {
			int _type = GREATER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:57:9: ( '>' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:57:11: '>'
			{
			match('>'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GREATER"

	// $ANTLR start "GREATEREQ"
	public final void mGREATEREQ() throws RecognitionException {
		try {
			int _type = GREATEREQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:58:11: ( '>=' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:58:13: '>='
			{
			match(">="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GREATEREQ"

	// $ANTLR start "AND"
	public final void mAND() throws RecognitionException {
		try {
			int _type = AND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:59:5: ( '&' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:59:7: '&'
			{
			match('&'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AND"

	// $ANTLR start "OR"
	public final void mOR() throws RecognitionException {
		try {
			int _type = OR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:60:4: ( '|' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:60:6: '|'
			{
			match('|'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OR"

	// $ANTLR start "ASSIGN"
	public final void mASSIGN() throws RecognitionException {
		try {
			int _type = ASSIGN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:61:8: ( ':=' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:61:10: ':='
			{
			match(":="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ASSIGN"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			int _type = ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:66:3: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:66:4: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:66:25: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop1;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ID"

	// $ANTLR start "COMMENT"
	public final void mCOMMENT() throws RecognitionException {
		try {
			int _type = COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:67:8: ( '/*' ( options {greedy=false; } : . )* '*/' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:67:10: '/*' ( options {greedy=false; } : . )* '*/'
			{
			match("/*"); 

			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:67:15: ( options {greedy=false; } : . )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0=='*') ) {
					int LA2_1 = input.LA(2);
					if ( (LA2_1=='/') ) {
						alt2=2;
					}
					else if ( ((LA2_1 >= '\u0000' && LA2_1 <= '.')||(LA2_1 >= '0' && LA2_1 <= '\uFFFF')) ) {
						alt2=1;
					}

				}
				else if ( ((LA2_0 >= '\u0000' && LA2_0 <= ')')||(LA2_0 >= '+' && LA2_0 <= '\uFFFF')) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:67:43: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop2;
				}
			}

			match("*/"); 

			_channel = HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMENT"

	// $ANTLR start "INTLIT"
	public final void mINTLIT() throws RecognitionException {
		try {
			int _type = INTLIT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:68:8: ( ( '0' .. '9' ) | ( ( '1' .. '9' ) ( '0' .. '9' )+ ) )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( ((LA4_0 >= '1' && LA4_0 <= '9')) ) {
				int LA4_1 = input.LA(2);
				if ( ((LA4_1 >= '0' && LA4_1 <= '9')) ) {
					alt4=2;
				}

				else {
					alt4=1;
				}

			}
			else if ( (LA4_0=='0') ) {
				alt4=1;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:68:10: ( '0' .. '9' )
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;
				case 2 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:68:23: ( ( '1' .. '9' ) ( '0' .. '9' )+ )
					{
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:68:23: ( ( '1' .. '9' ) ( '0' .. '9' )+ )
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:68:24: ( '1' .. '9' ) ( '0' .. '9' )+
					{
					if ( (input.LA(1) >= '1' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:68:34: ( '0' .. '9' )+
					int cnt3=0;
					loop3:
					while (true) {
						int alt3=2;
						int LA3_0 = input.LA(1);
						if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
							alt3=1;
						}

						switch (alt3) {
						case 1 :
							// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							if ( cnt3 >= 1 ) break loop3;
							EarlyExitException eee = new EarlyExitException(3, input);
							throw eee;
						}
						cnt3++;
					}

					}

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INTLIT"

	// $ANTLR start "FIXEDPTLIT"
	public final void mFIXEDPTLIT() throws RecognitionException {
		try {
			int _type = FIXEDPTLIT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:69:13: ( INTLIT ( '.' ) ( '0' .. '9' ) ( ( '0' .. '9' ) ( '0' .. '9' )? )? )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:69:16: INTLIT ( '.' ) ( '0' .. '9' ) ( ( '0' .. '9' ) ( '0' .. '9' )? )?
			{
			mINTLIT(); 

			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:69:23: ( '.' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:69:24: '.'
			{
			match('.'); 
			}

			if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:69:40: ( ( '0' .. '9' ) ( '0' .. '9' )? )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( ((LA6_0 >= '0' && LA6_0 <= '9')) ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:69:41: ( '0' .. '9' ) ( '0' .. '9' )?
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:69:51: ( '0' .. '9' )?
					int alt5=2;
					int LA5_0 = input.LA(1);
					if ( ((LA5_0 >= '0' && LA5_0 <= '9')) ) {
						alt5=1;
					}
					switch (alt5) {
						case 1 :
							// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

					}

					}
					break;

			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FIXEDPTLIT"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:70:3: ( ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' )+ )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:70:5: ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' )+
			{
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:70:5: ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' )+
			int cnt7=0;
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( ((LA7_0 >= '\t' && LA7_0 <= '\n')||(LA7_0 >= '\f' && LA7_0 <= '\r')||LA7_0==' ') ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:
					{
					if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||(input.LA(1) >= '\f' && input.LA(1) <= '\r')||input.LA(1)==' ' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt7 >= 1 ) break loop7;
					EarlyExitException eee = new EarlyExitException(7, input);
					throw eee;
				}
				cnt7++;
			}

			_channel = HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	@Override
	public void mTokens() throws RecognitionException {
		// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:1:8: ( T__51 | Function | Begin | End | Void | Main | Type | Array | Of | Int | Fixedpt | Var | If | Then | Endif | Else | While | Do | Enddo | For | To | Break | Return | COMMA | COLON | SEMI | LPAREN | RPAREN | LBRACK | RBRACK | PLUS | MINUS | MULT | DIV | EQ | NEQ | LESSER | LESSEREQ | GREATER | GREATEREQ | AND | OR | ASSIGN | ID | COMMENT | INTLIT | FIXEDPTLIT | WS )
		int alt8=48;
		alt8 = dfa8.predict(input);
		switch (alt8) {
			case 1 :
				// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:1:10: T__51
				{
				mT__51(); 

				}
				break;
			case 2 :
				// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:1:16: Function
				{
				mFunction(); 

				}
				break;
			case 3 :
				// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:1:25: Begin
				{
				mBegin(); 

				}
				break;
			case 4 :
				// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:1:31: End
				{
				mEnd(); 

				}
				break;
			case 5 :
				// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:1:35: Void
				{
				mVoid(); 

				}
				break;
			case 6 :
				// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:1:40: Main
				{
				mMain(); 

				}
				break;
			case 7 :
				// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:1:45: Type
				{
				mType(); 

				}
				break;
			case 8 :
				// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:1:50: Array
				{
				mArray(); 

				}
				break;
			case 9 :
				// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:1:56: Of
				{
				mOf(); 

				}
				break;
			case 10 :
				// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:1:59: Int
				{
				mInt(); 

				}
				break;
			case 11 :
				// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:1:63: Fixedpt
				{
				mFixedpt(); 

				}
				break;
			case 12 :
				// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:1:71: Var
				{
				mVar(); 

				}
				break;
			case 13 :
				// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:1:75: If
				{
				mIf(); 

				}
				break;
			case 14 :
				// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:1:78: Then
				{
				mThen(); 

				}
				break;
			case 15 :
				// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:1:83: Endif
				{
				mEndif(); 

				}
				break;
			case 16 :
				// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:1:89: Else
				{
				mElse(); 

				}
				break;
			case 17 :
				// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:1:94: While
				{
				mWhile(); 

				}
				break;
			case 18 :
				// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:1:100: Do
				{
				mDo(); 

				}
				break;
			case 19 :
				// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:1:103: Enddo
				{
				mEnddo(); 

				}
				break;
			case 20 :
				// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:1:109: For
				{
				mFor(); 

				}
				break;
			case 21 :
				// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:1:113: To
				{
				mTo(); 

				}
				break;
			case 22 :
				// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:1:116: Break
				{
				mBreak(); 

				}
				break;
			case 23 :
				// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:1:122: Return
				{
				mReturn(); 

				}
				break;
			case 24 :
				// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:1:129: COMMA
				{
				mCOMMA(); 

				}
				break;
			case 25 :
				// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:1:135: COLON
				{
				mCOLON(); 

				}
				break;
			case 26 :
				// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:1:141: SEMI
				{
				mSEMI(); 

				}
				break;
			case 27 :
				// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:1:146: LPAREN
				{
				mLPAREN(); 

				}
				break;
			case 28 :
				// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:1:153: RPAREN
				{
				mRPAREN(); 

				}
				break;
			case 29 :
				// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:1:160: LBRACK
				{
				mLBRACK(); 

				}
				break;
			case 30 :
				// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:1:167: RBRACK
				{
				mRBRACK(); 

				}
				break;
			case 31 :
				// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:1:174: PLUS
				{
				mPLUS(); 

				}
				break;
			case 32 :
				// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:1:179: MINUS
				{
				mMINUS(); 

				}
				break;
			case 33 :
				// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:1:185: MULT
				{
				mMULT(); 

				}
				break;
			case 34 :
				// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:1:190: DIV
				{
				mDIV(); 

				}
				break;
			case 35 :
				// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:1:194: EQ
				{
				mEQ(); 

				}
				break;
			case 36 :
				// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:1:197: NEQ
				{
				mNEQ(); 

				}
				break;
			case 37 :
				// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:1:201: LESSER
				{
				mLESSER(); 

				}
				break;
			case 38 :
				// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:1:208: LESSEREQ
				{
				mLESSEREQ(); 

				}
				break;
			case 39 :
				// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:1:217: GREATER
				{
				mGREATER(); 

				}
				break;
			case 40 :
				// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:1:225: GREATEREQ
				{
				mGREATEREQ(); 

				}
				break;
			case 41 :
				// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:1:235: AND
				{
				mAND(); 

				}
				break;
			case 42 :
				// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:1:239: OR
				{
				mOR(); 

				}
				break;
			case 43 :
				// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:1:242: ASSIGN
				{
				mASSIGN(); 

				}
				break;
			case 44 :
				// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:1:249: ID
				{
				mID(); 

				}
				break;
			case 45 :
				// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:1:252: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 46 :
				// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:1:260: INTLIT
				{
				mINTLIT(); 

				}
				break;
			case 47 :
				// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:1:267: FIXEDPTLIT
				{
				mFIXEDPTLIT(); 

				}
				break;
			case 48 :
				// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:1:278: WS
				{
				mWS(); 

				}
				break;

		}
	}


	protected DFA8 dfa8 = new DFA8(this);
	static final String DFA8_eotS =
		"\1\uffff\1\41\14\36\1\uffff\1\70\10\uffff\1\72\1\uffff\1\75\1\77\3\uffff"+
		"\2\100\2\uffff\14\36\1\117\1\36\1\121\1\36\1\123\1\36\1\125\1\36\12\uffff"+
		"\1\100\1\uffff\2\36\1\131\2\36\1\136\2\36\1\141\3\36\1\uffff\1\36\1\uffff"+
		"\1\146\1\uffff\1\36\1\uffff\3\36\1\uffff\4\36\1\uffff\1\157\1\160\1\uffff"+
		"\1\161\1\162\1\163\1\36\1\uffff\4\36\1\171\1\172\1\173\1\174\5\uffff\1"+
		"\175\1\176\3\36\6\uffff\1\u0082\1\36\1\u0084\1\uffff\1\u0085\2\uffff";
	static final String DFA8_eofS =
		"\u0086\uffff";
	static final String DFA8_minS =
		"\1\11\1\133\1\151\1\145\1\154\2\141\1\150\1\162\2\146\1\150\1\157\1\145"+
		"\1\uffff\1\75\10\uffff\1\52\1\uffff\2\75\3\uffff\2\56\2\uffff\1\156\1"+
		"\170\1\162\1\147\1\145\1\144\1\163\1\151\1\162\1\151\1\160\1\145\1\60"+
		"\1\162\1\60\1\164\1\60\1\151\1\60\1\164\12\uffff\1\56\1\uffff\1\143\1"+
		"\145\1\60\1\151\1\141\1\60\1\145\1\144\1\60\1\156\1\145\1\156\1\uffff"+
		"\1\141\1\uffff\1\60\1\uffff\1\154\1\uffff\1\165\1\164\1\144\1\uffff\1"+
		"\156\1\153\1\146\1\157\1\uffff\2\60\1\uffff\3\60\1\171\1\uffff\1\145\1"+
		"\162\1\151\1\160\4\60\5\uffff\2\60\1\156\1\157\1\164\6\uffff\1\60\1\156"+
		"\1\60\1\uffff\1\60\2\uffff";
	static final String DFA8_maxS =
		"\1\174\1\133\1\165\1\162\1\156\1\157\1\141\1\171\1\162\1\146\1\156\1\150"+
		"\1\157\1\145\1\uffff\1\75\10\uffff\1\52\1\uffff\1\76\1\75\3\uffff\1\71"+
		"\1\56\2\uffff\1\156\1\170\1\162\1\147\1\145\1\144\1\163\1\151\1\162\1"+
		"\151\1\160\1\145\1\172\1\162\1\172\1\164\1\172\1\151\1\172\1\164\12\uffff"+
		"\1\71\1\uffff\1\143\1\145\1\172\1\151\1\141\1\172\1\145\1\144\1\172\1"+
		"\156\1\145\1\156\1\uffff\1\141\1\uffff\1\172\1\uffff\1\154\1\uffff\1\165"+
		"\1\164\1\144\1\uffff\1\156\1\153\1\146\1\157\1\uffff\2\172\1\uffff\3\172"+
		"\1\171\1\uffff\1\145\1\162\1\151\1\160\4\172\5\uffff\2\172\1\156\1\157"+
		"\1\164\6\uffff\1\172\1\156\1\172\1\uffff\1\172\2\uffff";
	static final String DFA8_acceptS =
		"\16\uffff\1\30\1\uffff\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\uffff"+
		"\1\43\2\uffff\1\51\1\52\1\54\2\uffff\1\60\1\1\24\uffff\1\53\1\31\1\55"+
		"\1\42\1\44\1\46\1\45\1\50\1\47\1\56\1\uffff\1\57\14\uffff\1\25\1\uffff"+
		"\1\11\1\uffff\1\15\1\uffff\1\22\3\uffff\1\24\4\uffff\1\4\2\uffff\1\14"+
		"\4\uffff\1\12\10\uffff\1\20\1\5\1\6\1\7\1\16\5\uffff\1\3\1\26\1\17\1\23"+
		"\1\10\1\21\3\uffff\1\27\1\uffff\1\13\1\2";
	static final String DFA8_specialS =
		"\u0086\uffff}>";
	static final String[] DFA8_transitionS = {
			"\2\41\1\uffff\2\41\22\uffff\1\1\5\uffff\1\34\1\uffff\1\21\1\22\1\27\1"+
			"\25\1\16\1\26\1\uffff\1\30\1\40\11\37\1\17\1\20\1\32\1\31\1\33\2\uffff"+
			"\32\36\1\23\1\uffff\1\24\3\uffff\1\10\1\3\1\36\1\14\1\4\1\2\2\36\1\12"+
			"\3\36\1\6\1\36\1\11\2\36\1\15\1\36\1\7\1\36\1\5\1\13\3\36\1\uffff\1\35",
			"\1\42",
			"\1\44\5\uffff\1\45\5\uffff\1\43",
			"\1\46\14\uffff\1\47",
			"\1\51\1\uffff\1\50",
			"\1\53\15\uffff\1\52",
			"\1\54",
			"\1\56\6\uffff\1\57\11\uffff\1\55",
			"\1\60",
			"\1\61",
			"\1\63\7\uffff\1\62",
			"\1\64",
			"\1\65",
			"\1\66",
			"",
			"\1\67",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\71",
			"",
			"\1\74\1\73",
			"\1\76",
			"",
			"",
			"",
			"\1\102\1\uffff\12\101",
			"\1\102",
			"",
			"",
			"\1\103",
			"\1\104",
			"\1\105",
			"\1\106",
			"\1\107",
			"\1\110",
			"\1\111",
			"\1\112",
			"\1\113",
			"\1\114",
			"\1\115",
			"\1\116",
			"\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
			"\1\120",
			"\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
			"\1\122",
			"\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
			"\1\124",
			"\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
			"\1\126",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\102\1\uffff\12\101",
			"",
			"\1\127",
			"\1\130",
			"\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
			"\1\132",
			"\1\133",
			"\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\3\36\1\135\4\36\1\134\21\36",
			"\1\137",
			"\1\140",
			"\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
			"\1\142",
			"\1\143",
			"\1\144",
			"",
			"\1\145",
			"",
			"\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
			"",
			"\1\147",
			"",
			"\1\150",
			"\1\151",
			"\1\152",
			"",
			"\1\153",
			"\1\154",
			"\1\155",
			"\1\156",
			"",
			"\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
			"\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
			"",
			"\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
			"\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
			"\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
			"\1\164",
			"",
			"\1\165",
			"\1\166",
			"\1\167",
			"\1\170",
			"\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
			"\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
			"\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
			"\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
			"",
			"",
			"",
			"",
			"",
			"\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
			"\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
			"\1\177",
			"\1\u0080",
			"\1\u0081",
			"",
			"",
			"",
			"",
			"",
			"",
			"\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
			"\1\u0083",
			"\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
			"",
			"\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
			"",
			""
	};

	static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
	static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
	static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
	static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
	static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
	static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
	static final short[][] DFA8_transition;

	static {
		int numStates = DFA8_transitionS.length;
		DFA8_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
		}
	}

	protected class DFA8 extends DFA {

		public DFA8(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 8;
			this.eot = DFA8_eot;
			this.eof = DFA8_eof;
			this.min = DFA8_min;
			this.max = DFA8_max;
			this.accept = DFA8_accept;
			this.special = DFA8_special;
			this.transition = DFA8_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( T__51 | Function | Begin | End | Void | Main | Type | Array | Of | Int | Fixedpt | Var | If | Then | Endif | Else | While | Do | Enddo | For | To | Break | Return | COMMA | COLON | SEMI | LPAREN | RPAREN | LBRACK | RBRACK | PLUS | MINUS | MULT | DIV | EQ | NEQ | LESSER | LESSEREQ | GREATER | GREATEREQ | AND | OR | ASSIGN | ID | COMMENT | INTLIT | FIXEDPTLIT | WS );";
		}
	}

}
