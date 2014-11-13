// $ANTLR 3.5.2 Tiger.g 2014-11-13 04:04:59

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class TigerLexer extends Lexer {
	public static final int EOF=-1;
	public static final int AND=4;
	public static final int ARRAY=5;
	public static final int ASSIGN=6;
	public static final int BEGIN=7;
	public static final int BLOCKLIST=8;
	public static final int BLOCKSCOPE=9;
	public static final int BREAK=10;
	public static final int COLON=11;
	public static final int COMMA=12;
	public static final int COMMENT=13;
	public static final int DIGIT=14;
	public static final int DIV=15;
	public static final int DO=16;
	public static final int ELSE=17;
	public static final int ELSE_STATS=18;
	public static final int END=19;
	public static final int ENDDO=20;
	public static final int ENDIF=21;
	public static final int EQ=22;
	public static final int EXPRLIST=23;
	public static final int EXPR_WITH_START_ID=24;
	public static final int FIXEDPT=25;
	public static final int FIXEDPTLIT=26;
	public static final int FOR=27;
	public static final int FUNCDECL=28;
	public static final int FUNCTION=29;
	public static final int FUNCTION_CALL=30;
	public static final int GREATER=31;
	public static final int GREATEREQ=32;
	public static final int ID=33;
	public static final int IDLIST=34;
	public static final int IF=35;
	public static final int IF_THEN=36;
	public static final int IF_THEN_ELSE=37;
	public static final int INT=38;
	public static final int INTLIT=39;
	public static final int INVALID_CHAR=40;
	public static final int INVALID_FIXEDPTLIT=41;
	public static final int INVALID_INTLIT=42;
	public static final int LBRACK=43;
	public static final int LESSER=44;
	public static final int LESSEREQ=45;
	public static final int LOWER=46;
	public static final int LPAREN=47;
	public static final int MAIN=48;
	public static final int MAINSCOPE=49;
	public static final int MINUS=50;
	public static final int MULT=51;
	public static final int NEQ=52;
	public static final int OF=53;
	public static final int OR=54;
	public static final int PARAMLIST=55;
	public static final int PLUS=56;
	public static final int PROGRAM=57;
	public static final int RBRACK=58;
	public static final int RETURN=59;
	public static final int RPAREN=60;
	public static final int SEMI=61;
	public static final int THEN=62;
	public static final int THEN_STATS=63;
	public static final int TO=64;
	public static final int TYPE=65;
	public static final int TYPEDECL=66;
	public static final int TYPEDECLLIST=67;
	public static final int UPPER=68;
	public static final int VAR=69;
	public static final int VARDECL=70;
	public static final int VARDECLLIST=71;
	public static final int VOID=72;
	public static final int WHILE=73;
	public static final int WHITESPACE=74;

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
	@Override public String getGrammarFileName() { return "Tiger.g"; }

	// $ANTLR start "AND"
	public final void mAND() throws RecognitionException {
		try {
			int _type = AND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:2:5: ( '&' )
			// Tiger.g:2:7: '&'
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

	// $ANTLR start "ARRAY"
	public final void mARRAY() throws RecognitionException {
		try {
			int _type = ARRAY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:3:7: ( 'array' )
			// Tiger.g:3:9: 'array'
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
	// $ANTLR end "ARRAY"

	// $ANTLR start "ASSIGN"
	public final void mASSIGN() throws RecognitionException {
		try {
			int _type = ASSIGN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:4:8: ( ':=' )
			// Tiger.g:4:10: ':='
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

	// $ANTLR start "BEGIN"
	public final void mBEGIN() throws RecognitionException {
		try {
			int _type = BEGIN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:5:7: ( 'begin' )
			// Tiger.g:5:9: 'begin'
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
	// $ANTLR end "BEGIN"

	// $ANTLR start "BREAK"
	public final void mBREAK() throws RecognitionException {
		try {
			int _type = BREAK;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:6:7: ( 'break' )
			// Tiger.g:6:9: 'break'
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
	// $ANTLR end "BREAK"

	// $ANTLR start "COLON"
	public final void mCOLON() throws RecognitionException {
		try {
			int _type = COLON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:7:7: ( ':' )
			// Tiger.g:7:9: ':'
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

	// $ANTLR start "COMMA"
	public final void mCOMMA() throws RecognitionException {
		try {
			int _type = COMMA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:8:7: ( ',' )
			// Tiger.g:8:9: ','
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

	// $ANTLR start "DIV"
	public final void mDIV() throws RecognitionException {
		try {
			int _type = DIV;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:9:5: ( '/' )
			// Tiger.g:9:7: '/'
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

	// $ANTLR start "DO"
	public final void mDO() throws RecognitionException {
		try {
			int _type = DO;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:10:4: ( 'do' )
			// Tiger.g:10:6: 'do'
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
	// $ANTLR end "DO"

	// $ANTLR start "ELSE"
	public final void mELSE() throws RecognitionException {
		try {
			int _type = ELSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:11:6: ( 'else' )
			// Tiger.g:11:8: 'else'
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
	// $ANTLR end "ELSE"

	// $ANTLR start "END"
	public final void mEND() throws RecognitionException {
		try {
			int _type = END;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:12:5: ( 'end' )
			// Tiger.g:12:7: 'end'
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
	// $ANTLR end "END"

	// $ANTLR start "ENDDO"
	public final void mENDDO() throws RecognitionException {
		try {
			int _type = ENDDO;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:13:7: ( 'enddo' )
			// Tiger.g:13:9: 'enddo'
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
	// $ANTLR end "ENDDO"

	// $ANTLR start "ENDIF"
	public final void mENDIF() throws RecognitionException {
		try {
			int _type = ENDIF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:14:7: ( 'endif' )
			// Tiger.g:14:9: 'endif'
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
	// $ANTLR end "ENDIF"

	// $ANTLR start "EQ"
	public final void mEQ() throws RecognitionException {
		try {
			int _type = EQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:15:4: ( '=' )
			// Tiger.g:15:6: '='
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

	// $ANTLR start "FIXEDPT"
	public final void mFIXEDPT() throws RecognitionException {
		try {
			int _type = FIXEDPT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:16:9: ( 'fixedpt' )
			// Tiger.g:16:11: 'fixedpt'
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
	// $ANTLR end "FIXEDPT"

	// $ANTLR start "FOR"
	public final void mFOR() throws RecognitionException {
		try {
			int _type = FOR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:17:5: ( 'for' )
			// Tiger.g:17:7: 'for'
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
	// $ANTLR end "FOR"

	// $ANTLR start "FUNCTION"
	public final void mFUNCTION() throws RecognitionException {
		try {
			int _type = FUNCTION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:18:10: ( 'function' )
			// Tiger.g:18:12: 'function'
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
	// $ANTLR end "FUNCTION"

	// $ANTLR start "GREATER"
	public final void mGREATER() throws RecognitionException {
		try {
			int _type = GREATER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:19:9: ( '>' )
			// Tiger.g:19:11: '>'
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
			// Tiger.g:20:11: ( '>=' )
			// Tiger.g:20:13: '>='
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

	// $ANTLR start "IF"
	public final void mIF() throws RecognitionException {
		try {
			int _type = IF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:21:4: ( 'if' )
			// Tiger.g:21:6: 'if'
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
	// $ANTLR end "IF"

	// $ANTLR start "INT"
	public final void mINT() throws RecognitionException {
		try {
			int _type = INT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:22:5: ( 'int' )
			// Tiger.g:22:7: 'int'
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
	// $ANTLR end "INT"

	// $ANTLR start "LBRACK"
	public final void mLBRACK() throws RecognitionException {
		try {
			int _type = LBRACK;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:23:8: ( '[' )
			// Tiger.g:23:10: '['
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

	// $ANTLR start "LESSER"
	public final void mLESSER() throws RecognitionException {
		try {
			int _type = LESSER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:24:8: ( '<' )
			// Tiger.g:24:10: '<'
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
			// Tiger.g:25:10: ( '<=' )
			// Tiger.g:25:12: '<='
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

	// $ANTLR start "LPAREN"
	public final void mLPAREN() throws RecognitionException {
		try {
			int _type = LPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:26:8: ( '(' )
			// Tiger.g:26:10: '('
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

	// $ANTLR start "MAIN"
	public final void mMAIN() throws RecognitionException {
		try {
			int _type = MAIN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:27:6: ( 'main' )
			// Tiger.g:27:8: 'main'
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
	// $ANTLR end "MAIN"

	// $ANTLR start "MINUS"
	public final void mMINUS() throws RecognitionException {
		try {
			int _type = MINUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:28:7: ( '-' )
			// Tiger.g:28:9: '-'
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
			// Tiger.g:29:6: ( '*' )
			// Tiger.g:29:8: '*'
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

	// $ANTLR start "NEQ"
	public final void mNEQ() throws RecognitionException {
		try {
			int _type = NEQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:30:5: ( '<>' )
			// Tiger.g:30:7: '<>'
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

	// $ANTLR start "OF"
	public final void mOF() throws RecognitionException {
		try {
			int _type = OF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:31:4: ( 'of' )
			// Tiger.g:31:6: 'of'
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
	// $ANTLR end "OF"

	// $ANTLR start "OR"
	public final void mOR() throws RecognitionException {
		try {
			int _type = OR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:32:4: ( '|' )
			// Tiger.g:32:6: '|'
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

	// $ANTLR start "PLUS"
	public final void mPLUS() throws RecognitionException {
		try {
			int _type = PLUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:33:6: ( '+' )
			// Tiger.g:33:8: '+'
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

	// $ANTLR start "RBRACK"
	public final void mRBRACK() throws RecognitionException {
		try {
			int _type = RBRACK;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:34:8: ( ']' )
			// Tiger.g:34:10: ']'
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

	// $ANTLR start "RETURN"
	public final void mRETURN() throws RecognitionException {
		try {
			int _type = RETURN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:35:8: ( 'return' )
			// Tiger.g:35:10: 'return'
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
	// $ANTLR end "RETURN"

	// $ANTLR start "RPAREN"
	public final void mRPAREN() throws RecognitionException {
		try {
			int _type = RPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:36:8: ( ')' )
			// Tiger.g:36:10: ')'
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

	// $ANTLR start "SEMI"
	public final void mSEMI() throws RecognitionException {
		try {
			int _type = SEMI;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:37:6: ( ';' )
			// Tiger.g:37:8: ';'
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

	// $ANTLR start "THEN"
	public final void mTHEN() throws RecognitionException {
		try {
			int _type = THEN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:38:6: ( 'then' )
			// Tiger.g:38:8: 'then'
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
	// $ANTLR end "THEN"

	// $ANTLR start "TO"
	public final void mTO() throws RecognitionException {
		try {
			int _type = TO;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:39:4: ( 'to' )
			// Tiger.g:39:6: 'to'
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
	// $ANTLR end "TO"

	// $ANTLR start "TYPE"
	public final void mTYPE() throws RecognitionException {
		try {
			int _type = TYPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:40:6: ( 'type' )
			// Tiger.g:40:8: 'type'
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
	// $ANTLR end "TYPE"

	// $ANTLR start "VAR"
	public final void mVAR() throws RecognitionException {
		try {
			int _type = VAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:41:5: ( 'var' )
			// Tiger.g:41:7: 'var'
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
	// $ANTLR end "VAR"

	// $ANTLR start "VOID"
	public final void mVOID() throws RecognitionException {
		try {
			int _type = VOID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:42:6: ( 'void' )
			// Tiger.g:42:8: 'void'
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
	// $ANTLR end "VOID"

	// $ANTLR start "WHILE"
	public final void mWHILE() throws RecognitionException {
		try {
			int _type = WHILE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:43:7: ( 'while' )
			// Tiger.g:43:9: 'while'
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
	// $ANTLR end "WHILE"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			int _type = ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:291:5: ( ( LOWER | UPPER ) ( LOWER | UPPER | DIGIT | '_' )* )
			// Tiger.g:291:9: ( LOWER | UPPER ) ( LOWER | UPPER | DIGIT | '_' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// Tiger.g:291:22: ( LOWER | UPPER | DIGIT | '_' )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// Tiger.g:
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

	// $ANTLR start "WHITESPACE"
	public final void mWHITESPACE() throws RecognitionException {
		try {
			int _type = WHITESPACE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:295:5: ( ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+ )
			// Tiger.g:295:9: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
			{
			// Tiger.g:295:9: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
			int cnt2=0;
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= '\t' && LA2_0 <= '\n')||(LA2_0 >= '\f' && LA2_0 <= '\r')||LA2_0==' ') ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// Tiger.g:
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
					if ( cnt2 >= 1 ) break loop2;
					EarlyExitException eee = new EarlyExitException(2, input);
					throw eee;
				}
				cnt2++;
			}

			_channel=HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WHITESPACE"

	// $ANTLR start "COMMENT"
	public final void mCOMMENT() throws RecognitionException {
		try {
			int _type = COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:299:5: ( '/*' ( options {greedy=false; } : . )* '*/' )
			// Tiger.g:299:9: '/*' ( options {greedy=false; } : . )* '*/'
			{
			match("/*"); 

			// Tiger.g:299:14: ( options {greedy=false; } : . )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0=='*') ) {
					int LA3_1 = input.LA(2);
					if ( (LA3_1=='/') ) {
						alt3=2;
					}
					else if ( ((LA3_1 >= '\u0000' && LA3_1 <= '.')||(LA3_1 >= '0' && LA3_1 <= '\uFFFF')) ) {
						alt3=1;
					}

				}
				else if ( ((LA3_0 >= '\u0000' && LA3_0 <= ')')||(LA3_0 >= '+' && LA3_0 <= '\uFFFF')) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// Tiger.g:299:42: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop3;
				}
			}

			match("*/"); 

			_channel=HIDDEN;
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
			// Tiger.g:303:5: ( '0' | '1' .. '9' ( DIGIT )* )
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0=='0') ) {
				alt5=1;
			}
			else if ( ((LA5_0 >= '1' && LA5_0 <= '9')) ) {
				alt5=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}

			switch (alt5) {
				case 1 :
					// Tiger.g:303:9: '0'
					{
					match('0'); 
					}
					break;
				case 2 :
					// Tiger.g:304:9: '1' .. '9' ( DIGIT )*
					{
					matchRange('1','9'); 
					// Tiger.g:304:18: ( DIGIT )*
					loop4:
					while (true) {
						int alt4=2;
						int LA4_0 = input.LA(1);
						if ( ((LA4_0 >= '0' && LA4_0 <= '9')) ) {
							alt4=1;
						}

						switch (alt4) {
						case 1 :
							// Tiger.g:
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
							break loop4;
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
			// Tiger.g:308:5: ( INTLIT '.' ( DIGIT | DIGIT DIGIT | DIGIT DIGIT DIGIT ) )
			// Tiger.g:308:9: INTLIT '.' ( DIGIT | DIGIT DIGIT | DIGIT DIGIT DIGIT )
			{
			mINTLIT(); 

			match('.'); 
			// Tiger.g:308:20: ( DIGIT | DIGIT DIGIT | DIGIT DIGIT DIGIT )
			int alt6=3;
			int LA6_0 = input.LA(1);
			if ( ((LA6_0 >= '0' && LA6_0 <= '9')) ) {
				int LA6_1 = input.LA(2);
				if ( ((LA6_1 >= '0' && LA6_1 <= '9')) ) {
					int LA6_3 = input.LA(3);
					if ( ((LA6_3 >= '0' && LA6_3 <= '9')) ) {
						alt6=3;
					}

					else {
						alt6=2;
					}

				}

				else {
					alt6=1;
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}

			switch (alt6) {
				case 1 :
					// Tiger.g:308:21: DIGIT
					{
					mDIGIT(); 

					}
					break;
				case 2 :
					// Tiger.g:308:29: DIGIT DIGIT
					{
					mDIGIT(); 

					mDIGIT(); 

					}
					break;
				case 3 :
					// Tiger.g:308:43: DIGIT DIGIT DIGIT
					{
					mDIGIT(); 

					mDIGIT(); 

					mDIGIT(); 

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

	// $ANTLR start "INVALID_INTLIT"
	public final void mINVALID_INTLIT() throws RecognitionException {
		try {
			int _type = INVALID_INTLIT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:312:5: ( '0' ( DIGIT )+ )
			// Tiger.g:312:9: '0' ( DIGIT )+
			{
			match('0'); 
			// Tiger.g:312:13: ( DIGIT )+
			int cnt7=0;
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( ((LA7_0 >= '0' && LA7_0 <= '9')) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// Tiger.g:
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
					if ( cnt7 >= 1 ) break loop7;
					EarlyExitException eee = new EarlyExitException(7, input);
					throw eee;
				}
				cnt7++;
			}

			_type=Token.INVALID_TOKEN_TYPE;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INVALID_INTLIT"

	// $ANTLR start "INVALID_FIXEDPTLIT"
	public final void mINVALID_FIXEDPTLIT() throws RecognitionException {
		try {
			int _type = INVALID_FIXEDPTLIT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:316:5: ( INVALID_INTLIT '.' ( DIGIT | DIGIT DIGIT | DIGIT DIGIT DIGIT )? | INTLIT '.' ( DIGIT DIGIT DIGIT ( DIGIT )+ )? )
			int alt11=2;
			int LA11_0 = input.LA(1);
			if ( (LA11_0=='0') ) {
				int LA11_1 = input.LA(2);
				if ( ((LA11_1 >= '0' && LA11_1 <= '9')) ) {
					alt11=1;
				}
				else if ( (LA11_1=='.') ) {
					alt11=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 11, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( ((LA11_0 >= '1' && LA11_0 <= '9')) ) {
				alt11=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}

			switch (alt11) {
				case 1 :
					// Tiger.g:316:9: INVALID_INTLIT '.' ( DIGIT | DIGIT DIGIT | DIGIT DIGIT DIGIT )?
					{
					mINVALID_INTLIT(); 

					match('.'); 
					// Tiger.g:316:28: ( DIGIT | DIGIT DIGIT | DIGIT DIGIT DIGIT )?
					int alt8=4;
					int LA8_0 = input.LA(1);
					if ( ((LA8_0 >= '0' && LA8_0 <= '9')) ) {
						int LA8_1 = input.LA(2);
						if ( ((LA8_1 >= '0' && LA8_1 <= '9')) ) {
							int LA8_4 = input.LA(3);
							if ( ((LA8_4 >= '0' && LA8_4 <= '9')) ) {
								alt8=3;
							}
						}
					}
					switch (alt8) {
						case 1 :
							// Tiger.g:316:29: DIGIT
							{
							mDIGIT(); 

							}
							break;
						case 2 :
							// Tiger.g:316:37: DIGIT DIGIT
							{
							mDIGIT(); 

							mDIGIT(); 

							}
							break;
						case 3 :
							// Tiger.g:316:51: DIGIT DIGIT DIGIT
							{
							mDIGIT(); 

							mDIGIT(); 

							mDIGIT(); 

							}
							break;

					}

					_type=Token.INVALID_TOKEN_TYPE;
					}
					break;
				case 2 :
					// Tiger.g:317:9: INTLIT '.' ( DIGIT DIGIT DIGIT ( DIGIT )+ )?
					{
					mINTLIT(); 

					match('.'); 
					// Tiger.g:317:20: ( DIGIT DIGIT DIGIT ( DIGIT )+ )?
					int alt10=2;
					int LA10_0 = input.LA(1);
					if ( ((LA10_0 >= '0' && LA10_0 <= '9')) ) {
						alt10=1;
					}
					switch (alt10) {
						case 1 :
							// Tiger.g:317:21: DIGIT DIGIT DIGIT ( DIGIT )+
							{
							mDIGIT(); 

							mDIGIT(); 

							mDIGIT(); 

							// Tiger.g:317:39: ( DIGIT )+
							int cnt9=0;
							loop9:
							while (true) {
								int alt9=2;
								int LA9_0 = input.LA(1);
								if ( ((LA9_0 >= '0' && LA9_0 <= '9')) ) {
									alt9=1;
								}

								switch (alt9) {
								case 1 :
									// Tiger.g:
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
									if ( cnt9 >= 1 ) break loop9;
									EarlyExitException eee = new EarlyExitException(9, input);
									throw eee;
								}
								cnt9++;
							}

							}
							break;

					}

					_type=Token.INVALID_TOKEN_TYPE;
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
	// $ANTLR end "INVALID_FIXEDPTLIT"

	// $ANTLR start "INVALID_CHAR"
	public final void mINVALID_CHAR() throws RecognitionException {
		try {
			int _type = INVALID_CHAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:324:5: ( . )
			// Tiger.g:324:9: .
			{
			matchAny(); 
			_type=Token.INVALID_TOKEN_TYPE;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INVALID_CHAR"

	// $ANTLR start "LOWER"
	public final void mLOWER() throws RecognitionException {
		try {
			// Tiger.g:327:15: ( 'a' .. 'z' )
			// Tiger.g:
			{
			if ( (input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LOWER"

	// $ANTLR start "UPPER"
	public final void mUPPER() throws RecognitionException {
		try {
			// Tiger.g:328:15: ( 'A' .. 'Z' )
			// Tiger.g:
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UPPER"

	// $ANTLR start "DIGIT"
	public final void mDIGIT() throws RecognitionException {
		try {
			// Tiger.g:329:15: ( '0' .. '9' )
			// Tiger.g:
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

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DIGIT"

	@Override
	public void mTokens() throws RecognitionException {
		// Tiger.g:1:8: ( AND | ARRAY | ASSIGN | BEGIN | BREAK | COLON | COMMA | DIV | DO | ELSE | END | ENDDO | ENDIF | EQ | FIXEDPT | FOR | FUNCTION | GREATER | GREATEREQ | IF | INT | LBRACK | LESSER | LESSEREQ | LPAREN | MAIN | MINUS | MULT | NEQ | OF | OR | PLUS | RBRACK | RETURN | RPAREN | SEMI | THEN | TO | TYPE | VAR | VOID | WHILE | ID | WHITESPACE | COMMENT | INTLIT | FIXEDPTLIT | INVALID_INTLIT | INVALID_FIXEDPTLIT | INVALID_CHAR )
		int alt12=50;
		alt12 = dfa12.predict(input);
		switch (alt12) {
			case 1 :
				// Tiger.g:1:10: AND
				{
				mAND(); 

				}
				break;
			case 2 :
				// Tiger.g:1:14: ARRAY
				{
				mARRAY(); 

				}
				break;
			case 3 :
				// Tiger.g:1:20: ASSIGN
				{
				mASSIGN(); 

				}
				break;
			case 4 :
				// Tiger.g:1:27: BEGIN
				{
				mBEGIN(); 

				}
				break;
			case 5 :
				// Tiger.g:1:33: BREAK
				{
				mBREAK(); 

				}
				break;
			case 6 :
				// Tiger.g:1:39: COLON
				{
				mCOLON(); 

				}
				break;
			case 7 :
				// Tiger.g:1:45: COMMA
				{
				mCOMMA(); 

				}
				break;
			case 8 :
				// Tiger.g:1:51: DIV
				{
				mDIV(); 

				}
				break;
			case 9 :
				// Tiger.g:1:55: DO
				{
				mDO(); 

				}
				break;
			case 10 :
				// Tiger.g:1:58: ELSE
				{
				mELSE(); 

				}
				break;
			case 11 :
				// Tiger.g:1:63: END
				{
				mEND(); 

				}
				break;
			case 12 :
				// Tiger.g:1:67: ENDDO
				{
				mENDDO(); 

				}
				break;
			case 13 :
				// Tiger.g:1:73: ENDIF
				{
				mENDIF(); 

				}
				break;
			case 14 :
				// Tiger.g:1:79: EQ
				{
				mEQ(); 

				}
				break;
			case 15 :
				// Tiger.g:1:82: FIXEDPT
				{
				mFIXEDPT(); 

				}
				break;
			case 16 :
				// Tiger.g:1:90: FOR
				{
				mFOR(); 

				}
				break;
			case 17 :
				// Tiger.g:1:94: FUNCTION
				{
				mFUNCTION(); 

				}
				break;
			case 18 :
				// Tiger.g:1:103: GREATER
				{
				mGREATER(); 

				}
				break;
			case 19 :
				// Tiger.g:1:111: GREATEREQ
				{
				mGREATEREQ(); 

				}
				break;
			case 20 :
				// Tiger.g:1:121: IF
				{
				mIF(); 

				}
				break;
			case 21 :
				// Tiger.g:1:124: INT
				{
				mINT(); 

				}
				break;
			case 22 :
				// Tiger.g:1:128: LBRACK
				{
				mLBRACK(); 

				}
				break;
			case 23 :
				// Tiger.g:1:135: LESSER
				{
				mLESSER(); 

				}
				break;
			case 24 :
				// Tiger.g:1:142: LESSEREQ
				{
				mLESSEREQ(); 

				}
				break;
			case 25 :
				// Tiger.g:1:151: LPAREN
				{
				mLPAREN(); 

				}
				break;
			case 26 :
				// Tiger.g:1:158: MAIN
				{
				mMAIN(); 

				}
				break;
			case 27 :
				// Tiger.g:1:163: MINUS
				{
				mMINUS(); 

				}
				break;
			case 28 :
				// Tiger.g:1:169: MULT
				{
				mMULT(); 

				}
				break;
			case 29 :
				// Tiger.g:1:174: NEQ
				{
				mNEQ(); 

				}
				break;
			case 30 :
				// Tiger.g:1:178: OF
				{
				mOF(); 

				}
				break;
			case 31 :
				// Tiger.g:1:181: OR
				{
				mOR(); 

				}
				break;
			case 32 :
				// Tiger.g:1:184: PLUS
				{
				mPLUS(); 

				}
				break;
			case 33 :
				// Tiger.g:1:189: RBRACK
				{
				mRBRACK(); 

				}
				break;
			case 34 :
				// Tiger.g:1:196: RETURN
				{
				mRETURN(); 

				}
				break;
			case 35 :
				// Tiger.g:1:203: RPAREN
				{
				mRPAREN(); 

				}
				break;
			case 36 :
				// Tiger.g:1:210: SEMI
				{
				mSEMI(); 

				}
				break;
			case 37 :
				// Tiger.g:1:215: THEN
				{
				mTHEN(); 

				}
				break;
			case 38 :
				// Tiger.g:1:220: TO
				{
				mTO(); 

				}
				break;
			case 39 :
				// Tiger.g:1:223: TYPE
				{
				mTYPE(); 

				}
				break;
			case 40 :
				// Tiger.g:1:228: VAR
				{
				mVAR(); 

				}
				break;
			case 41 :
				// Tiger.g:1:232: VOID
				{
				mVOID(); 

				}
				break;
			case 42 :
				// Tiger.g:1:237: WHILE
				{
				mWHILE(); 

				}
				break;
			case 43 :
				// Tiger.g:1:243: ID
				{
				mID(); 

				}
				break;
			case 44 :
				// Tiger.g:1:246: WHITESPACE
				{
				mWHITESPACE(); 

				}
				break;
			case 45 :
				// Tiger.g:1:257: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 46 :
				// Tiger.g:1:265: INTLIT
				{
				mINTLIT(); 

				}
				break;
			case 47 :
				// Tiger.g:1:272: FIXEDPTLIT
				{
				mFIXEDPTLIT(); 

				}
				break;
			case 48 :
				// Tiger.g:1:283: INVALID_INTLIT
				{
				mINVALID_INTLIT(); 

				}
				break;
			case 49 :
				// Tiger.g:1:298: INVALID_FIXEDPTLIT
				{
				mINVALID_FIXEDPTLIT(); 

				}
				break;
			case 50 :
				// Tiger.g:1:317: INVALID_CHAR
				{
				mINVALID_CHAR(); 

				}
				break;

		}
	}


	protected DFA12 dfa12 = new DFA12(this);
	static final String DFA12_eotS =
		"\2\uffff\1\44\1\46\1\44\1\uffff\1\53\2\44\1\uffff\1\44\1\64\1\44\1\uffff"+
		"\1\72\1\uffff\1\44\2\uffff\1\44\3\uffff\1\44\2\uffff\3\44\2\uffff\2\115"+
		"\2\uffff\1\44\3\uffff\2\44\3\uffff\1\124\2\44\1\uffff\3\44\2\uffff\1\132"+
		"\1\44\5\uffff\1\44\2\uffff\1\135\3\uffff\1\44\2\uffff\1\44\1\140\4\44"+
		"\2\uffff\1\146\1\147\1\115\3\44\1\uffff\1\44\1\156\1\44\1\160\1\44\1\uffff"+
		"\1\162\1\44\1\uffff\2\44\1\uffff\1\44\1\167\2\44\1\172\2\uffff\3\44\1"+
		"\177\2\44\1\uffff\1\44\1\uffff\1\44\1\uffff\1\u0084\1\44\1\u0086\1\u0087"+
		"\1\uffff\1\u0088\1\44\1\uffff\1\172\1\u008b\1\u008c\1\u008d\1\uffff\1"+
		"\u008e\1\u008f\2\44\1\uffff\1\44\3\uffff\1\u0093\1\172\5\uffff\2\44\1"+
		"\u0096\1\uffff\1\u0097\1\44\2\uffff\1\u0099\1\uffff";
	static final String DFA12_eofS =
		"\u009a\uffff";
	static final String DFA12_minS =
		"\1\0\1\uffff\1\162\1\75\1\145\1\uffff\1\52\1\157\1\154\1\uffff\1\151\1"+
		"\75\1\146\1\uffff\1\75\1\uffff\1\141\2\uffff\1\146\3\uffff\1\145\2\uffff"+
		"\1\150\1\141\1\150\2\uffff\2\56\2\uffff\1\162\3\uffff\1\147\1\145\3\uffff"+
		"\1\60\1\163\1\144\1\uffff\1\170\1\162\1\156\2\uffff\1\60\1\164\5\uffff"+
		"\1\151\2\uffff\1\60\3\uffff\1\164\2\uffff\1\145\1\60\1\160\1\162\2\151"+
		"\2\uffff\1\60\2\56\1\141\1\151\1\141\1\uffff\1\145\1\60\1\145\1\60\1\143"+
		"\1\uffff\1\60\1\156\1\uffff\1\165\1\156\1\uffff\1\145\1\60\1\144\1\154"+
		"\1\60\2\uffff\1\171\1\156\1\153\1\60\1\157\1\146\1\uffff\1\144\1\uffff"+
		"\1\164\1\uffff\1\60\1\162\2\60\1\uffff\1\60\1\145\1\uffff\4\60\1\uffff"+
		"\2\60\1\160\1\151\1\uffff\1\156\3\uffff\2\60\5\uffff\1\164\1\157\1\60"+
		"\1\uffff\1\60\1\156\2\uffff\1\60\1\uffff";
	static final String DFA12_maxS =
		"\1\uffff\1\uffff\1\162\1\75\1\162\1\uffff\1\52\1\157\1\156\1\uffff\1\165"+
		"\1\75\1\156\1\uffff\1\76\1\uffff\1\141\2\uffff\1\146\3\uffff\1\145\2\uffff"+
		"\1\171\1\157\1\150\2\uffff\2\71\2\uffff\1\162\3\uffff\1\147\1\145\3\uffff"+
		"\1\172\1\163\1\144\1\uffff\1\170\1\162\1\156\2\uffff\1\172\1\164\5\uffff"+
		"\1\151\2\uffff\1\172\3\uffff\1\164\2\uffff\1\145\1\172\1\160\1\162\2\151"+
		"\2\uffff\3\71\1\141\1\151\1\141\1\uffff\1\145\1\172\1\145\1\172\1\143"+
		"\1\uffff\1\172\1\156\1\uffff\1\165\1\156\1\uffff\1\145\1\172\1\144\1\154"+
		"\1\71\2\uffff\1\171\1\156\1\153\1\172\1\157\1\146\1\uffff\1\144\1\uffff"+
		"\1\164\1\uffff\1\172\1\162\2\172\1\uffff\1\172\1\145\1\uffff\1\71\3\172"+
		"\1\uffff\2\172\1\160\1\151\1\uffff\1\156\3\uffff\1\172\1\71\5\uffff\1"+
		"\164\1\157\1\172\1\uffff\1\172\1\156\2\uffff\1\172\1\uffff";
	static final String DFA12_acceptS =
		"\1\uffff\1\1\3\uffff\1\7\3\uffff\1\16\3\uffff\1\26\1\uffff\1\31\1\uffff"+
		"\1\33\1\34\1\uffff\1\37\1\40\1\41\1\uffff\1\43\1\44\3\uffff\1\53\1\54"+
		"\2\uffff\1\62\1\1\1\uffff\1\53\1\3\1\6\2\uffff\1\7\1\55\1\10\3\uffff\1"+
		"\16\3\uffff\1\23\1\22\2\uffff\1\26\1\30\1\35\1\27\1\31\1\uffff\1\33\1"+
		"\34\1\uffff\1\37\1\40\1\41\1\uffff\1\43\1\44\6\uffff\1\54\1\56\6\uffff"+
		"\1\11\5\uffff\1\24\2\uffff\1\36\2\uffff\1\46\5\uffff\1\61\1\60\6\uffff"+
		"\1\13\1\uffff\1\20\1\uffff\1\25\4\uffff\1\50\2\uffff\1\57\4\uffff\1\12"+
		"\4\uffff\1\32\1\uffff\1\45\1\47\1\51\2\uffff\1\2\1\4\1\5\1\14\1\15\3\uffff"+
		"\1\52\2\uffff\1\42\1\17\1\uffff\1\21";
	static final String DFA12_specialS =
		"\1\0\u0099\uffff}>";
	static final String[] DFA12_transitionS = {
			"\11\41\2\36\1\41\2\36\22\41\1\36\5\41\1\1\1\41\1\17\1\30\1\22\1\25\1"+
			"\5\1\21\1\41\1\6\1\37\11\40\1\3\1\31\1\16\1\11\1\13\2\41\32\35\1\15\1"+
			"\41\1\26\3\41\1\2\1\4\1\35\1\7\1\10\1\12\2\35\1\14\3\35\1\20\1\35\1\23"+
			"\2\35\1\27\1\35\1\32\1\35\1\33\1\34\3\35\1\41\1\24\uff83\41",
			"",
			"\1\43",
			"\1\45",
			"\1\47\14\uffff\1\50",
			"",
			"\1\52",
			"\1\54",
			"\1\55\1\uffff\1\56",
			"",
			"\1\60\5\uffff\1\61\5\uffff\1\62",
			"\1\63",
			"\1\65\7\uffff\1\66",
			"",
			"\1\70\1\71",
			"",
			"\1\74",
			"",
			"",
			"\1\77",
			"",
			"",
			"",
			"\1\103",
			"",
			"",
			"\1\106\6\uffff\1\107\11\uffff\1\110",
			"\1\111\15\uffff\1\112",
			"\1\113",
			"",
			"",
			"\1\116\1\uffff\12\117",
			"\1\116\1\uffff\12\120",
			"",
			"",
			"\1\121",
			"",
			"",
			"",
			"\1\122",
			"\1\123",
			"",
			"",
			"",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\125",
			"\1\126",
			"",
			"\1\127",
			"\1\130",
			"\1\131",
			"",
			"",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\133",
			"",
			"",
			"",
			"",
			"",
			"\1\134",
			"",
			"",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"",
			"",
			"",
			"\1\136",
			"",
			"",
			"\1\137",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\141",
			"\1\142",
			"\1\143",
			"\1\144",
			"",
			"",
			"\12\145",
			"\1\146\1\uffff\12\117",
			"\1\116\1\uffff\12\120",
			"\1\150",
			"\1\151",
			"\1\152",
			"",
			"\1\153",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\3\44\1\154\4\44\1\155\21\44",
			"\1\157",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\161",
			"",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\163",
			"",
			"\1\164",
			"\1\165",
			"",
			"\1\166",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\170",
			"\1\171",
			"\12\173",
			"",
			"",
			"\1\174",
			"\1\175",
			"\1\176",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\u0080",
			"\1\u0081",
			"",
			"\1\u0082",
			"",
			"\1\u0083",
			"",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\u0085",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\u0089",
			"",
			"\12\u008a",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\u0090",
			"\1\u0091",
			"",
			"\1\u0092",
			"",
			"",
			"",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\12\146",
			"",
			"",
			"",
			"",
			"",
			"\1\u0094",
			"\1\u0095",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\u0098",
			"",
			"",
			"\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			""
	};

	static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
	static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
	static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
	static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
	static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
	static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
	static final short[][] DFA12_transition;

	static {
		int numStates = DFA12_transitionS.length;
		DFA12_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
		}
	}

	protected class DFA12 extends DFA {

		public DFA12(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 12;
			this.eot = DFA12_eot;
			this.eof = DFA12_eof;
			this.min = DFA12_min;
			this.max = DFA12_max;
			this.accept = DFA12_accept;
			this.special = DFA12_special;
			this.transition = DFA12_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( AND | ARRAY | ASSIGN | BEGIN | BREAK | COLON | COMMA | DIV | DO | ELSE | END | ENDDO | ENDIF | EQ | FIXEDPT | FOR | FUNCTION | GREATER | GREATEREQ | IF | INT | LBRACK | LESSER | LESSEREQ | LPAREN | MAIN | MINUS | MULT | NEQ | OF | OR | PLUS | RBRACK | RETURN | RPAREN | SEMI | THEN | TO | TYPE | VAR | VOID | WHILE | ID | WHITESPACE | COMMENT | INTLIT | FIXEDPTLIT | INVALID_INTLIT | INVALID_FIXEDPTLIT | INVALID_CHAR );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA12_0 = input.LA(1);
						s = -1;
						if ( (LA12_0=='&') ) {s = 1;}
						else if ( (LA12_0=='a') ) {s = 2;}
						else if ( (LA12_0==':') ) {s = 3;}
						else if ( (LA12_0=='b') ) {s = 4;}
						else if ( (LA12_0==',') ) {s = 5;}
						else if ( (LA12_0=='/') ) {s = 6;}
						else if ( (LA12_0=='d') ) {s = 7;}
						else if ( (LA12_0=='e') ) {s = 8;}
						else if ( (LA12_0=='=') ) {s = 9;}
						else if ( (LA12_0=='f') ) {s = 10;}
						else if ( (LA12_0=='>') ) {s = 11;}
						else if ( (LA12_0=='i') ) {s = 12;}
						else if ( (LA12_0=='[') ) {s = 13;}
						else if ( (LA12_0=='<') ) {s = 14;}
						else if ( (LA12_0=='(') ) {s = 15;}
						else if ( (LA12_0=='m') ) {s = 16;}
						else if ( (LA12_0=='-') ) {s = 17;}
						else if ( (LA12_0=='*') ) {s = 18;}
						else if ( (LA12_0=='o') ) {s = 19;}
						else if ( (LA12_0=='|') ) {s = 20;}
						else if ( (LA12_0=='+') ) {s = 21;}
						else if ( (LA12_0==']') ) {s = 22;}
						else if ( (LA12_0=='r') ) {s = 23;}
						else if ( (LA12_0==')') ) {s = 24;}
						else if ( (LA12_0==';') ) {s = 25;}
						else if ( (LA12_0=='t') ) {s = 26;}
						else if ( (LA12_0=='v') ) {s = 27;}
						else if ( (LA12_0=='w') ) {s = 28;}
						else if ( ((LA12_0 >= 'A' && LA12_0 <= 'Z')||LA12_0=='c'||(LA12_0 >= 'g' && LA12_0 <= 'h')||(LA12_0 >= 'j' && LA12_0 <= 'l')||LA12_0=='n'||(LA12_0 >= 'p' && LA12_0 <= 'q')||LA12_0=='s'||LA12_0=='u'||(LA12_0 >= 'x' && LA12_0 <= 'z')) ) {s = 29;}
						else if ( ((LA12_0 >= '\t' && LA12_0 <= '\n')||(LA12_0 >= '\f' && LA12_0 <= '\r')||LA12_0==' ') ) {s = 30;}
						else if ( (LA12_0=='0') ) {s = 31;}
						else if ( ((LA12_0 >= '1' && LA12_0 <= '9')) ) {s = 32;}
						else if ( ((LA12_0 >= '\u0000' && LA12_0 <= '\b')||LA12_0=='\u000B'||(LA12_0 >= '\u000E' && LA12_0 <= '\u001F')||(LA12_0 >= '!' && LA12_0 <= '%')||LA12_0=='\''||LA12_0=='.'||(LA12_0 >= '?' && LA12_0 <= '@')||LA12_0=='\\'||(LA12_0 >= '^' && LA12_0 <= '`')||LA12_0=='{'||(LA12_0 >= '}' && LA12_0 <= '\uFFFF')) ) {s = 33;}
						if ( s>=0 ) return s;
						break;
			}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 12, _s, input);
			error(nvae);
			throw nvae;
		}
	}

}
