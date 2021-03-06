// $ANTLR 3.5.1 /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g 2014-11-12 15:09:52

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.debug.*;
import java.io.IOException;
import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class TigerParser extends DebugParser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND", "ARRAY", "ASSIGN", "BEGIN", 
		"BLOCKLIST", "BLOCKSCOPE", "BREAK", "COLON", "COMMA", "COMMENT", "DIGIT", 
		"DIV", "DO", "ELSE", "ELSE_STATS", "END", "ENDDO", "ENDIF", "EQ", "EXPRLIST", 
		"EXPR_WITH_START_ID", "FIXEDPT", "FIXEDPTLIT", "FOR", "FUNCDECL", "FUNCTION", 
		"FUNCTION_CALL", "GREATER", "GREATEREQ", "ID", "IDLIST", "IF", "IF_THEN", 
		"IF_THEN_ELSE", "INT", "INTLIT", "INVALID_CHAR", "INVALID_FIXEDPTLIT", 
		"INVALID_INTLIT", "LBRACK", "LESSER", "LESSEREQ", "LOWER", "LPAREN", "MAIN", 
		"MAINSCOPE", "MINUS", "MULT", "NEQ", "OF", "OR", "PARAMLIST", "PLUS", 
		"PROGRAM", "RBRACK", "RETURN", "RPAREN", "SEMI", "THEN", "THEN_STATS", 
		"TO", "TYPE", "TYPEDECL", "TYPEDECLLIST", "UPPER", "VAR", "VARDECL", "VARDECLLIST", 
		"VOID", "WHILE", "WHITESPACE"
	};
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
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public static final String[] ruleNames = new String[] {
		"invalidRule", "term2", "declaration_segment", "term4", "expr_or_function_call", 
		"function_call_or_assignment", "expr", "mult_operator", "compare_operator", 
		"and_operator", "term3", "expr_with_start_id", "var_declaration", "main_function_tail", 
		"term2_with_start_id", "funct_declaration_list_then_main", "expr_no_start_id", 
		"literal", "term1", "term4_no_start_id", "index_factor", "type_declaration_list", 
		"block_list", "funct_declaration_tail", "value_tail", "expr_list", "term1_with_start_id", 
		"stat", "type_id", "term3_no_start_id", "var_declaration_list", "tiger_program", 
		"type_declaration", "id_list", "param_list", "param", "base_type", "term3_with_start_id", 
		"function_args", "type", "value", "index_expr", "index_term", "term4_with_start_id", 
		"optional_init", "block", "term1_no_start_id", "add_operator", "term2_no_start_id", 
		"stat_seq"
	};

	public static final boolean[] decisionCanBacktrack = new boolean[] {
		false, // invalid decision
		false, false, false, false, false, false, false, false, false, false, 
		    false, false, false, false, false, false, false, false, false, false, 
		    false, false, false, false, false, false, false, false, false, false, 
		    false, false, false, false, false, false, false, false, false
	};

 
	public int ruleLevel = 0;
	public int getRuleLevel() { return ruleLevel; }
	public void incRuleLevel() { ruleLevel++; }
	public void decRuleLevel() { ruleLevel--; }
	public TigerParser(TokenStream input) {
		this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
	}
	public TigerParser(TokenStream input, int port, RecognizerSharedState state) {
		super(input, state);
		DebugEventSocketProxy proxy =
			new DebugEventSocketProxy(this,port,adaptor);
		setDebugListener(proxy);
		setTokenStream(new DebugTokenStream(input,proxy));
		try {
			proxy.handshake();
		}
		catch (IOException ioe) {
			reportError(ioe);
		}
		TreeAdaptor adap = new CommonTreeAdaptor();
		setTreeAdaptor(adap);
		proxy.setTreeAdaptor(adap);
	}

	public TigerParser(TokenStream input, DebugEventListener dbg) {
		super(input, dbg);
		 
		TreeAdaptor adap = new CommonTreeAdaptor();
		setTreeAdaptor(adap);

	}

	protected boolean evalPredicate(boolean result, String predicate) {
		dbg.semanticPredicate(result, predicate);
		return result;
	}

		protected DebugTreeAdaptor adaptor;
		public void setTreeAdaptor(TreeAdaptor adaptor) {
			this.adaptor = new DebugTreeAdaptor(dbg,adaptor);
		}
		public TreeAdaptor getTreeAdaptor() {
			return adaptor;
		}
	@Override public String[] getTokenNames() { return TigerParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g"; }



	    public String errorPrefix = "";

	    public String getErrorMessage(RecognitionException e, String[] tokenNames) {
	        String msg = super.getErrorMessage(e, tokenNames);
	        msg += "\n" + ((TigerTokenStream)this.getTokenStream()).getCurrentLineForError(e);
	        return msg;
	    }

	    public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
	        System.out.print(errorPrefix);
	        super.displayRecognitionError(tokenNames, e);
	    }


	public static class tiger_program_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "tiger_program"
	// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:136:1: tiger_program : type_declaration_list funct_declaration_list_then_main EOF -> ^( PROGRAM type_declaration_list funct_declaration_list_then_main ) ;
	public final TigerParser.tiger_program_return tiger_program() throws RecognitionException {
		TigerParser.tiger_program_return retval = new TigerParser.tiger_program_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token EOF3=null;
		ParserRuleReturnScope type_declaration_list1 =null;
		ParserRuleReturnScope funct_declaration_list_then_main2 =null;

		Object EOF3_tree=null;
		RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
		RewriteRuleSubtreeStream stream_type_declaration_list=new RewriteRuleSubtreeStream(adaptor,"rule type_declaration_list");
		RewriteRuleSubtreeStream stream_funct_declaration_list_then_main=new RewriteRuleSubtreeStream(adaptor,"rule funct_declaration_list_then_main");

		try { dbg.enterRule(getGrammarFileName(), "tiger_program");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(136, 0);

		try {
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:136:15: ( type_declaration_list funct_declaration_list_then_main EOF -> ^( PROGRAM type_declaration_list funct_declaration_list_then_main ) )
			dbg.enterAlt(1);

			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:136:17: type_declaration_list funct_declaration_list_then_main EOF
			{
			dbg.location(136,17);
			pushFollow(FOLLOW_type_declaration_list_in_tiger_program1015);
			type_declaration_list1=type_declaration_list();
			state._fsp--;

			stream_type_declaration_list.add(type_declaration_list1.getTree());dbg.location(136,39);
			pushFollow(FOLLOW_funct_declaration_list_then_main_in_tiger_program1017);
			funct_declaration_list_then_main2=funct_declaration_list_then_main();
			state._fsp--;

			stream_funct_declaration_list_then_main.add(funct_declaration_list_then_main2.getTree());dbg.location(136,72);
			EOF3=(Token)match(input,EOF,FOLLOW_EOF_in_tiger_program1019);  
			stream_EOF.add(EOF3);

			// AST REWRITE
			// elements: type_declaration_list, funct_declaration_list_then_main
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 136:76: -> ^( PROGRAM type_declaration_list funct_declaration_list_then_main )
			{
				dbg.location(136,79);
				// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:136:79: ^( PROGRAM type_declaration_list funct_declaration_list_then_main )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(136,81);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PROGRAM, "PROGRAM"), root_1);
				dbg.location(136,89);
				adaptor.addChild(root_1, stream_type_declaration_list.nextTree());dbg.location(136,111);
				adaptor.addChild(root_1, stream_funct_declaration_list_then_main.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(136, 143);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "tiger_program");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "tiger_program"


	public static class funct_declaration_list_then_main_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "funct_declaration_list_then_main"
	// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:138:1: funct_declaration_list_then_main : (myRet= VOID ! ( funct_declaration_tail[$myRet] funct_declaration_list_then_main | main_function_tail ) | (myRet= ID |myRet= INT |myRet= FIXEDPT ) funct_declaration_tail[$myRet] funct_declaration_list_then_main );
	public final TigerParser.funct_declaration_list_then_main_return funct_declaration_list_then_main() throws RecognitionException {
		TigerParser.funct_declaration_list_then_main_return retval = new TigerParser.funct_declaration_list_then_main_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token myRet=null;
		ParserRuleReturnScope funct_declaration_tail4 =null;
		ParserRuleReturnScope funct_declaration_list_then_main5 =null;
		ParserRuleReturnScope main_function_tail6 =null;
		ParserRuleReturnScope funct_declaration_tail7 =null;
		ParserRuleReturnScope funct_declaration_list_then_main8 =null;

		Object myRet_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "funct_declaration_list_then_main");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(138, 0);

		try {
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:139:5: (myRet= VOID ! ( funct_declaration_tail[$myRet] funct_declaration_list_then_main | main_function_tail ) | (myRet= ID |myRet= INT |myRet= FIXEDPT ) funct_declaration_tail[$myRet] funct_declaration_list_then_main )
			int alt3=2;
			try { dbg.enterDecision(3, decisionCanBacktrack[3]);

			int LA3_0 = input.LA(1);
			if ( (LA3_0==VOID) ) {
				alt3=1;
			}
			else if ( (LA3_0==FIXEDPT||LA3_0==ID||LA3_0==INT) ) {
				alt3=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(3);}

			switch (alt3) {
				case 1 :
					dbg.enterAlt(1);

					// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:139:7: myRet= VOID ! ( funct_declaration_tail[$myRet] funct_declaration_list_then_main | main_function_tail )
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(139,12);
					myRet=(Token)match(input,VOID,FOLLOW_VOID_in_funct_declaration_list_then_main1043); dbg.location(139,19);
					// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:139:19: ( funct_declaration_tail[$myRet] funct_declaration_list_then_main | main_function_tail )
					int alt1=2;
					try { dbg.enterSubRule(1);
					try { dbg.enterDecision(1, decisionCanBacktrack[1]);

					int LA1_0 = input.LA(1);
					if ( (LA1_0==FUNCTION) ) {
						alt1=1;
					}
					else if ( (LA1_0==MAIN) ) {
						alt1=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 1, 0, input);
						dbg.recognitionException(nvae);
						throw nvae;
					}

					} finally {dbg.exitDecision(1);}

					switch (alt1) {
						case 1 :
							dbg.enterAlt(1);

							// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:139:20: funct_declaration_tail[$myRet] funct_declaration_list_then_main
							{
							dbg.location(139,20);
							pushFollow(FOLLOW_funct_declaration_tail_in_funct_declaration_list_then_main1047);
							funct_declaration_tail4=funct_declaration_tail(myRet);
							state._fsp--;

							adaptor.addChild(root_0, funct_declaration_tail4.getTree());
							dbg.location(139,51);
							pushFollow(FOLLOW_funct_declaration_list_then_main_in_funct_declaration_list_then_main1050);
							funct_declaration_list_then_main5=funct_declaration_list_then_main();
							state._fsp--;

							adaptor.addChild(root_0, funct_declaration_list_then_main5.getTree());

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:139:86: main_function_tail
							{
							dbg.location(139,86);
							pushFollow(FOLLOW_main_function_tail_in_funct_declaration_list_then_main1054);
							main_function_tail6=main_function_tail();
							state._fsp--;

							adaptor.addChild(root_0, main_function_tail6.getTree());

							}
							break;

					}
					} finally {dbg.exitSubRule(1);}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:140:7: (myRet= ID |myRet= INT |myRet= FIXEDPT ) funct_declaration_tail[$myRet] funct_declaration_list_then_main
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(140,7);
					// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:140:7: (myRet= ID |myRet= INT |myRet= FIXEDPT )
					int alt2=3;
					try { dbg.enterSubRule(2);
					try { dbg.enterDecision(2, decisionCanBacktrack[2]);

					switch ( input.LA(1) ) {
					case ID:
						{
						alt2=1;
						}
						break;
					case INT:
						{
						alt2=2;
						}
						break;
					case FIXEDPT:
						{
						alt2=3;
						}
						break;
					default:
						NoViableAltException nvae =
							new NoViableAltException("", 2, 0, input);
						dbg.recognitionException(nvae);
						throw nvae;
					}
					} finally {dbg.exitDecision(2);}

					switch (alt2) {
						case 1 :
							dbg.enterAlt(1);

							// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:140:8: myRet= ID
							{
							dbg.location(140,13);
							myRet=(Token)match(input,ID,FOLLOW_ID_in_funct_declaration_list_then_main1066); 
							myRet_tree = (Object)adaptor.create(myRet);
							adaptor.addChild(root_0, myRet_tree);

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:140:17: myRet= INT
							{
							dbg.location(140,22);
							myRet=(Token)match(input,INT,FOLLOW_INT_in_funct_declaration_list_then_main1070); 
							myRet_tree = (Object)adaptor.create(myRet);
							adaptor.addChild(root_0, myRet_tree);

							}
							break;
						case 3 :
							dbg.enterAlt(3);

							// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:140:27: myRet= FIXEDPT
							{
							dbg.location(140,32);
							myRet=(Token)match(input,FIXEDPT,FOLLOW_FIXEDPT_in_funct_declaration_list_then_main1074); 
							myRet_tree = (Object)adaptor.create(myRet);
							adaptor.addChild(root_0, myRet_tree);

							}
							break;

					}
					} finally {dbg.exitSubRule(2);}
					dbg.location(140,42);
					pushFollow(FOLLOW_funct_declaration_tail_in_funct_declaration_list_then_main1077);
					funct_declaration_tail7=funct_declaration_tail(myRet);
					state._fsp--;

					adaptor.addChild(root_0, funct_declaration_tail7.getTree());
					dbg.location(140,73);
					pushFollow(FOLLOW_funct_declaration_list_then_main_in_funct_declaration_list_then_main1080);
					funct_declaration_list_then_main8=funct_declaration_list_then_main();
					state._fsp--;

					adaptor.addChild(root_0, funct_declaration_list_then_main8.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(141, 4);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "funct_declaration_list_then_main");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "funct_declaration_list_then_main"


	public static class funct_declaration_tail_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "funct_declaration_tail"
	// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:143:1: funct_declaration_tail[Token retType] : FUNCTION ID '(' param_list ')' BEGIN block_list END ';' -> ^( FUNCTION ID param_list block_list ) ;
	public final TigerParser.funct_declaration_tail_return funct_declaration_tail(Token retType) throws RecognitionException {
		TigerParser.funct_declaration_tail_return retval = new TigerParser.funct_declaration_tail_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token FUNCTION9=null;
		Token ID10=null;
		Token char_literal11=null;
		Token char_literal13=null;
		Token BEGIN14=null;
		Token END16=null;
		Token char_literal17=null;
		ParserRuleReturnScope param_list12 =null;
		ParserRuleReturnScope block_list15 =null;

		Object FUNCTION9_tree=null;
		Object ID10_tree=null;
		Object char_literal11_tree=null;
		Object char_literal13_tree=null;
		Object BEGIN14_tree=null;
		Object END16_tree=null;
		Object char_literal17_tree=null;
		RewriteRuleTokenStream stream_FUNCTION=new RewriteRuleTokenStream(adaptor,"token FUNCTION");
		RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_END=new RewriteRuleTokenStream(adaptor,"token END");
		RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
		RewriteRuleTokenStream stream_BEGIN=new RewriteRuleTokenStream(adaptor,"token BEGIN");
		RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
		RewriteRuleSubtreeStream stream_block_list=new RewriteRuleSubtreeStream(adaptor,"rule block_list");
		RewriteRuleSubtreeStream stream_param_list=new RewriteRuleSubtreeStream(adaptor,"rule param_list");

		try { dbg.enterRule(getGrammarFileName(), "funct_declaration_tail");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(143, 0);

		try {
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:144:5: ( FUNCTION ID '(' param_list ')' BEGIN block_list END ';' -> ^( FUNCTION ID param_list block_list ) )
			dbg.enterAlt(1);

			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:144:7: FUNCTION ID '(' param_list ')' BEGIN block_list END ';'
			{
			dbg.location(144,7);
			FUNCTION9=(Token)match(input,FUNCTION,FOLLOW_FUNCTION_in_funct_declaration_tail1098);  
			stream_FUNCTION.add(FUNCTION9);
			dbg.location(144,16);
			ID10=(Token)match(input,ID,FOLLOW_ID_in_funct_declaration_tail1100);  
			stream_ID.add(ID10);
			dbg.location(144,19);
			char_literal11=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_funct_declaration_tail1102);  
			stream_LPAREN.add(char_literal11);
			dbg.location(144,23);
			pushFollow(FOLLOW_param_list_in_funct_declaration_tail1104);
			param_list12=param_list();
			state._fsp--;

			stream_param_list.add(param_list12.getTree());dbg.location(144,34);
			char_literal13=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_funct_declaration_tail1106);  
			stream_RPAREN.add(char_literal13);
			dbg.location(144,38);
			BEGIN14=(Token)match(input,BEGIN,FOLLOW_BEGIN_in_funct_declaration_tail1108);  
			stream_BEGIN.add(BEGIN14);
			dbg.location(144,44);
			pushFollow(FOLLOW_block_list_in_funct_declaration_tail1110);
			block_list15=block_list();
			state._fsp--;

			stream_block_list.add(block_list15.getTree());dbg.location(144,55);
			END16=(Token)match(input,END,FOLLOW_END_in_funct_declaration_tail1112);  
			stream_END.add(END16);
			dbg.location(144,59);
			char_literal17=(Token)match(input,SEMI,FOLLOW_SEMI_in_funct_declaration_tail1114);  
			stream_SEMI.add(char_literal17);

			// AST REWRITE
			// elements: FUNCTION, ID, param_list, block_list
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 144:63: -> ^( FUNCTION ID param_list block_list )
			{
				dbg.location(144,66);
				// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:144:66: ^( FUNCTION ID param_list block_list )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(144,68);
				root_1 = (Object)adaptor.becomeRoot(stream_FUNCTION.nextNode(), root_1);
				dbg.location(144,77);
				adaptor.addChild(root_1, new CommonTree(retType));dbg.location(144,104);
				adaptor.addChild(root_1, stream_ID.nextNode());dbg.location(144,107);
				adaptor.addChild(root_1, stream_param_list.nextTree());dbg.location(144,118);
				adaptor.addChild(root_1, stream_block_list.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(145, 4);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "funct_declaration_tail");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "funct_declaration_tail"


	public static class main_function_tail_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "main_function_tail"
	// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:147:1: main_function_tail : MAIN '(' ')' BEGIN block_list END ';' -> ^( MAINSCOPE block_list ) ;
	public final TigerParser.main_function_tail_return main_function_tail() throws RecognitionException {
		TigerParser.main_function_tail_return retval = new TigerParser.main_function_tail_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token MAIN18=null;
		Token char_literal19=null;
		Token char_literal20=null;
		Token BEGIN21=null;
		Token END23=null;
		Token char_literal24=null;
		ParserRuleReturnScope block_list22 =null;

		Object MAIN18_tree=null;
		Object char_literal19_tree=null;
		Object char_literal20_tree=null;
		Object BEGIN21_tree=null;
		Object END23_tree=null;
		Object char_literal24_tree=null;
		RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
		RewriteRuleTokenStream stream_MAIN=new RewriteRuleTokenStream(adaptor,"token MAIN");
		RewriteRuleTokenStream stream_END=new RewriteRuleTokenStream(adaptor,"token END");
		RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
		RewriteRuleTokenStream stream_BEGIN=new RewriteRuleTokenStream(adaptor,"token BEGIN");
		RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
		RewriteRuleSubtreeStream stream_block_list=new RewriteRuleSubtreeStream(adaptor,"rule block_list");

		try { dbg.enterRule(getGrammarFileName(), "main_function_tail");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(147, 0);

		try {
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:147:20: ( MAIN '(' ')' BEGIN block_list END ';' -> ^( MAINSCOPE block_list ) )
			dbg.enterAlt(1);

			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:147:22: MAIN '(' ')' BEGIN block_list END ';'
			{
			dbg.location(147,22);
			MAIN18=(Token)match(input,MAIN,FOLLOW_MAIN_in_main_function_tail1141);  
			stream_MAIN.add(MAIN18);
			dbg.location(147,27);
			char_literal19=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_main_function_tail1143);  
			stream_LPAREN.add(char_literal19);
			dbg.location(147,31);
			char_literal20=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_main_function_tail1145);  
			stream_RPAREN.add(char_literal20);
			dbg.location(147,35);
			BEGIN21=(Token)match(input,BEGIN,FOLLOW_BEGIN_in_main_function_tail1147);  
			stream_BEGIN.add(BEGIN21);
			dbg.location(147,41);
			pushFollow(FOLLOW_block_list_in_main_function_tail1149);
			block_list22=block_list();
			state._fsp--;

			stream_block_list.add(block_list22.getTree());dbg.location(147,52);
			END23=(Token)match(input,END,FOLLOW_END_in_main_function_tail1151);  
			stream_END.add(END23);
			dbg.location(147,56);
			char_literal24=(Token)match(input,SEMI,FOLLOW_SEMI_in_main_function_tail1153);  
			stream_SEMI.add(char_literal24);

			// AST REWRITE
			// elements: block_list
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 147:60: -> ^( MAINSCOPE block_list )
			{
				dbg.location(147,63);
				// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:147:63: ^( MAINSCOPE block_list )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(147,65);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(MAINSCOPE, "MAINSCOPE"), root_1);
				dbg.location(147,75);
				adaptor.addChild(root_1, stream_block_list.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(147, 85);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "main_function_tail");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "main_function_tail"


	public static class param_list_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "param_list"
	// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:149:1: param_list : ( param ( ',' param )* )? -> ^( PARAMLIST ( param )* ) ;
	public final TigerParser.param_list_return param_list() throws RecognitionException {
		TigerParser.param_list_return retval = new TigerParser.param_list_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal26=null;
		ParserRuleReturnScope param25 =null;
		ParserRuleReturnScope param27 =null;

		Object char_literal26_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleSubtreeStream stream_param=new RewriteRuleSubtreeStream(adaptor,"rule param");

		try { dbg.enterRule(getGrammarFileName(), "param_list");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(149, 0);

		try {
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:150:5: ( ( param ( ',' param )* )? -> ^( PARAMLIST ( param )* ) )
			dbg.enterAlt(1);

			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:150:7: ( param ( ',' param )* )?
			{
			dbg.location(150,7);
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:150:7: ( param ( ',' param )* )?
			int alt5=2;
			try { dbg.enterSubRule(5);
			try { dbg.enterDecision(5, decisionCanBacktrack[5]);

			int LA5_0 = input.LA(1);
			if ( (LA5_0==ID) ) {
				alt5=1;
			}
			} finally {dbg.exitDecision(5);}

			switch (alt5) {
				case 1 :
					dbg.enterAlt(1);

					// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:150:8: param ( ',' param )*
					{
					dbg.location(150,8);
					pushFollow(FOLLOW_param_in_param_list1174);
					param25=param();
					state._fsp--;

					stream_param.add(param25.getTree());dbg.location(150,14);
					// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:150:14: ( ',' param )*
					try { dbg.enterSubRule(4);

					loop4:
					while (true) {
						int alt4=2;
						try { dbg.enterDecision(4, decisionCanBacktrack[4]);

						int LA4_0 = input.LA(1);
						if ( (LA4_0==COMMA) ) {
							alt4=1;
						}

						} finally {dbg.exitDecision(4);}

						switch (alt4) {
						case 1 :
							dbg.enterAlt(1);

							// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:150:16: ',' param
							{
							dbg.location(150,16);
							char_literal26=(Token)match(input,COMMA,FOLLOW_COMMA_in_param_list1178);  
							stream_COMMA.add(char_literal26);
							dbg.location(150,20);
							pushFollow(FOLLOW_param_in_param_list1180);
							param27=param();
							state._fsp--;

							stream_param.add(param27.getTree());
							}
							break;

						default :
							break loop4;
						}
					}
					} finally {dbg.exitSubRule(4);}

					}
					break;

			}
			} finally {dbg.exitSubRule(5);}

			// AST REWRITE
			// elements: param
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 150:31: -> ^( PARAMLIST ( param )* )
			{
				dbg.location(150,34);
				// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:150:34: ^( PARAMLIST ( param )* )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(150,36);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PARAMLIST, "PARAMLIST"), root_1);
				dbg.location(150,46);
				// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:150:46: ( param )*
				while ( stream_param.hasNext() ) {
					dbg.location(150,46);
					adaptor.addChild(root_1, stream_param.nextTree());
				}
				stream_param.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(151, 4);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "param_list");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "param_list"


	public static class param_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "param"
	// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:153:1: param : ID ':' type_id ;
	public final TigerParser.param_return param() throws RecognitionException {
		TigerParser.param_return retval = new TigerParser.param_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ID28=null;
		Token char_literal29=null;
		ParserRuleReturnScope type_id30 =null;

		Object ID28_tree=null;
		Object char_literal29_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "param");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(153, 0);

		try {
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:153:7: ( ID ':' type_id )
			dbg.enterAlt(1);

			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:153:9: ID ':' type_id
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(153,9);
			ID28=(Token)match(input,ID,FOLLOW_ID_in_param1207); 
			ID28_tree = (Object)adaptor.create(ID28);
			adaptor.addChild(root_0, ID28_tree);
			dbg.location(153,12);
			char_literal29=(Token)match(input,COLON,FOLLOW_COLON_in_param1209); 
			char_literal29_tree = (Object)adaptor.create(char_literal29);
			adaptor.addChild(root_0, char_literal29_tree);
			dbg.location(153,16);
			pushFollow(FOLLOW_type_id_in_param1211);
			type_id30=type_id();
			state._fsp--;

			adaptor.addChild(root_0, type_id30.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(153, 22);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "param");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "param"


	public static class block_list_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "block_list"
	// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:155:1: block_list : ( block )+ -> ^( BLOCKLIST ( block )+ ) ;
	public final TigerParser.block_list_return block_list() throws RecognitionException {
		TigerParser.block_list_return retval = new TigerParser.block_list_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope block31 =null;

		RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");

		try { dbg.enterRule(getGrammarFileName(), "block_list");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(155, 0);

		try {
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:155:12: ( ( block )+ -> ^( BLOCKLIST ( block )+ ) )
			dbg.enterAlt(1);

			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:155:14: ( block )+
			{
			dbg.location(155,14);
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:155:14: ( block )+
			int cnt6=0;
			try { dbg.enterSubRule(6);

			loop6:
			while (true) {
				int alt6=2;
				try { dbg.enterDecision(6, decisionCanBacktrack[6]);

				int LA6_0 = input.LA(1);
				if ( (LA6_0==BEGIN) ) {
					alt6=1;
				}

				} finally {dbg.exitDecision(6);}

				switch (alt6) {
				case 1 :
					dbg.enterAlt(1);

					// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:155:14: block
					{
					dbg.location(155,14);
					pushFollow(FOLLOW_block_in_block_list1219);
					block31=block();
					state._fsp--;

					stream_block.add(block31.getTree());
					}
					break;

				default :
					if ( cnt6 >= 1 ) break loop6;
					EarlyExitException eee = new EarlyExitException(6, input);
					dbg.recognitionException(eee);

					throw eee;
				}
				cnt6++;
			}
			} finally {dbg.exitSubRule(6);}

			// AST REWRITE
			// elements: block
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 155:21: -> ^( BLOCKLIST ( block )+ )
			{
				dbg.location(155,24);
				// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:155:24: ^( BLOCKLIST ( block )+ )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(155,26);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(BLOCKLIST, "BLOCKLIST"), root_1);
				dbg.location(155,36);
				if ( !(stream_block.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_block.hasNext() ) {
					dbg.location(155,36);
					adaptor.addChild(root_1, stream_block.nextTree());
				}
				stream_block.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(155, 42);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "block_list");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "block_list"


	public static class block_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "block"
	// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:157:1: block : BEGIN declaration_segment stat_seq END ';' -> ^( BLOCKSCOPE declaration_segment stat_seq ) ;
	public final TigerParser.block_return block() throws RecognitionException {
		TigerParser.block_return retval = new TigerParser.block_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token BEGIN32=null;
		Token END35=null;
		Token char_literal36=null;
		ParserRuleReturnScope declaration_segment33 =null;
		ParserRuleReturnScope stat_seq34 =null;

		Object BEGIN32_tree=null;
		Object END35_tree=null;
		Object char_literal36_tree=null;
		RewriteRuleTokenStream stream_END=new RewriteRuleTokenStream(adaptor,"token END");
		RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
		RewriteRuleTokenStream stream_BEGIN=new RewriteRuleTokenStream(adaptor,"token BEGIN");
		RewriteRuleSubtreeStream stream_declaration_segment=new RewriteRuleSubtreeStream(adaptor,"rule declaration_segment");
		RewriteRuleSubtreeStream stream_stat_seq=new RewriteRuleSubtreeStream(adaptor,"rule stat_seq");

		try { dbg.enterRule(getGrammarFileName(), "block");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(157, 0);

		try {
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:157:7: ( BEGIN declaration_segment stat_seq END ';' -> ^( BLOCKSCOPE declaration_segment stat_seq ) )
			dbg.enterAlt(1);

			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:157:9: BEGIN declaration_segment stat_seq END ';'
			{
			dbg.location(157,9);
			BEGIN32=(Token)match(input,BEGIN,FOLLOW_BEGIN_in_block1237);  
			stream_BEGIN.add(BEGIN32);
			dbg.location(157,15);
			pushFollow(FOLLOW_declaration_segment_in_block1239);
			declaration_segment33=declaration_segment();
			state._fsp--;

			stream_declaration_segment.add(declaration_segment33.getTree());dbg.location(157,35);
			pushFollow(FOLLOW_stat_seq_in_block1241);
			stat_seq34=stat_seq();
			state._fsp--;

			stream_stat_seq.add(stat_seq34.getTree());dbg.location(157,44);
			END35=(Token)match(input,END,FOLLOW_END_in_block1243);  
			stream_END.add(END35);
			dbg.location(157,48);
			char_literal36=(Token)match(input,SEMI,FOLLOW_SEMI_in_block1245);  
			stream_SEMI.add(char_literal36);

			// AST REWRITE
			// elements: declaration_segment, stat_seq
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 157:52: -> ^( BLOCKSCOPE declaration_segment stat_seq )
			{
				dbg.location(157,55);
				// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:157:55: ^( BLOCKSCOPE declaration_segment stat_seq )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(157,57);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(BLOCKSCOPE, "BLOCKSCOPE"), root_1);
				dbg.location(157,68);
				adaptor.addChild(root_1, stream_declaration_segment.nextTree());dbg.location(157,88);
				adaptor.addChild(root_1, stream_stat_seq.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(157, 96);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "block");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "block"


	public static class declaration_segment_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "declaration_segment"
	// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:159:1: declaration_segment : type_declaration_list var_declaration_list ;
	public final TigerParser.declaration_segment_return declaration_segment() throws RecognitionException {
		TigerParser.declaration_segment_return retval = new TigerParser.declaration_segment_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope type_declaration_list37 =null;
		ParserRuleReturnScope var_declaration_list38 =null;


		try { dbg.enterRule(getGrammarFileName(), "declaration_segment");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(159, 0);

		try {
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:159:21: ( type_declaration_list var_declaration_list )
			dbg.enterAlt(1);

			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:159:23: type_declaration_list var_declaration_list
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(159,23);
			pushFollow(FOLLOW_type_declaration_list_in_declaration_segment1263);
			type_declaration_list37=type_declaration_list();
			state._fsp--;

			adaptor.addChild(root_0, type_declaration_list37.getTree());
			dbg.location(159,45);
			pushFollow(FOLLOW_var_declaration_list_in_declaration_segment1265);
			var_declaration_list38=var_declaration_list();
			state._fsp--;

			adaptor.addChild(root_0, var_declaration_list38.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(159, 65);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "declaration_segment");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "declaration_segment"


	public static class type_declaration_list_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "type_declaration_list"
	// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:161:1: type_declaration_list : ( type_declaration )* -> ^( TYPEDECLLIST ( type_declaration )* ) ;
	public final TigerParser.type_declaration_list_return type_declaration_list() throws RecognitionException {
		TigerParser.type_declaration_list_return retval = new TigerParser.type_declaration_list_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope type_declaration39 =null;

		RewriteRuleSubtreeStream stream_type_declaration=new RewriteRuleSubtreeStream(adaptor,"rule type_declaration");

		try { dbg.enterRule(getGrammarFileName(), "type_declaration_list");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(161, 0);

		try {
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:162:5: ( ( type_declaration )* -> ^( TYPEDECLLIST ( type_declaration )* ) )
			dbg.enterAlt(1);

			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:162:7: ( type_declaration )*
			{
			dbg.location(162,7);
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:162:7: ( type_declaration )*
			try { dbg.enterSubRule(7);

			loop7:
			while (true) {
				int alt7=2;
				try { dbg.enterDecision(7, decisionCanBacktrack[7]);

				int LA7_0 = input.LA(1);
				if ( (LA7_0==TYPE) ) {
					alt7=1;
				}

				} finally {dbg.exitDecision(7);}

				switch (alt7) {
				case 1 :
					dbg.enterAlt(1);

					// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:162:7: type_declaration
					{
					dbg.location(162,7);
					pushFollow(FOLLOW_type_declaration_in_type_declaration_list1278);
					type_declaration39=type_declaration();
					state._fsp--;

					stream_type_declaration.add(type_declaration39.getTree());
					}
					break;

				default :
					break loop7;
				}
			}
			} finally {dbg.exitSubRule(7);}

			// AST REWRITE
			// elements: type_declaration
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 162:25: -> ^( TYPEDECLLIST ( type_declaration )* )
			{
				dbg.location(162,28);
				// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:162:28: ^( TYPEDECLLIST ( type_declaration )* )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(162,30);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(TYPEDECLLIST, "TYPEDECLLIST"), root_1);
				dbg.location(162,43);
				// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:162:43: ( type_declaration )*
				while ( stream_type_declaration.hasNext() ) {
					dbg.location(162,43);
					adaptor.addChild(root_1, stream_type_declaration.nextTree());
				}
				stream_type_declaration.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(163, 4);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "type_declaration_list");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "type_declaration_list"


	public static class var_declaration_list_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "var_declaration_list"
	// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:165:1: var_declaration_list : ( var_declaration )* -> ^( VARDECLLIST ( var_declaration )* ) ;
	public final TigerParser.var_declaration_list_return var_declaration_list() throws RecognitionException {
		TigerParser.var_declaration_list_return retval = new TigerParser.var_declaration_list_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope var_declaration40 =null;

		RewriteRuleSubtreeStream stream_var_declaration=new RewriteRuleSubtreeStream(adaptor,"rule var_declaration");

		try { dbg.enterRule(getGrammarFileName(), "var_declaration_list");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(165, 0);

		try {
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:166:5: ( ( var_declaration )* -> ^( VARDECLLIST ( var_declaration )* ) )
			dbg.enterAlt(1);

			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:166:7: ( var_declaration )*
			{
			dbg.location(166,7);
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:166:7: ( var_declaration )*
			try { dbg.enterSubRule(8);

			loop8:
			while (true) {
				int alt8=2;
				try { dbg.enterDecision(8, decisionCanBacktrack[8]);

				int LA8_0 = input.LA(1);
				if ( (LA8_0==VAR) ) {
					alt8=1;
				}

				} finally {dbg.exitDecision(8);}

				switch (alt8) {
				case 1 :
					dbg.enterAlt(1);

					// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:166:7: var_declaration
					{
					dbg.location(166,7);
					pushFollow(FOLLOW_var_declaration_in_var_declaration_list1309);
					var_declaration40=var_declaration();
					state._fsp--;

					stream_var_declaration.add(var_declaration40.getTree());
					}
					break;

				default :
					break loop8;
				}
			}
			} finally {dbg.exitSubRule(8);}

			// AST REWRITE
			// elements: var_declaration
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 166:24: -> ^( VARDECLLIST ( var_declaration )* )
			{
				dbg.location(166,27);
				// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:166:27: ^( VARDECLLIST ( var_declaration )* )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(166,29);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(VARDECLLIST, "VARDECLLIST"), root_1);
				dbg.location(166,41);
				// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:166:41: ( var_declaration )*
				while ( stream_var_declaration.hasNext() ) {
					dbg.location(166,41);
					adaptor.addChild(root_1, stream_var_declaration.nextTree());
				}
				stream_var_declaration.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(167, 4);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "var_declaration_list");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "var_declaration_list"


	public static class type_declaration_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "type_declaration"
	// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:169:1: type_declaration : TYPE ID '=' type ';' -> ^( TYPEDECL ID type ) ;
	public final TigerParser.type_declaration_return type_declaration() throws RecognitionException {
		TigerParser.type_declaration_return retval = new TigerParser.type_declaration_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token TYPE41=null;
		Token ID42=null;
		Token char_literal43=null;
		Token char_literal45=null;
		ParserRuleReturnScope type44 =null;

		Object TYPE41_tree=null;
		Object ID42_tree=null;
		Object char_literal43_tree=null;
		Object char_literal45_tree=null;
		RewriteRuleTokenStream stream_EQ=new RewriteRuleTokenStream(adaptor,"token EQ");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
		RewriteRuleTokenStream stream_TYPE=new RewriteRuleTokenStream(adaptor,"token TYPE");
		RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");

		try { dbg.enterRule(getGrammarFileName(), "type_declaration");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(169, 0);

		try {
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:169:18: ( TYPE ID '=' type ';' -> ^( TYPEDECL ID type ) )
			dbg.enterAlt(1);

			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:169:20: TYPE ID '=' type ';'
			{
			dbg.location(169,20);
			TYPE41=(Token)match(input,TYPE,FOLLOW_TYPE_in_type_declaration1332);  
			stream_TYPE.add(TYPE41);
			dbg.location(169,25);
			ID42=(Token)match(input,ID,FOLLOW_ID_in_type_declaration1334);  
			stream_ID.add(ID42);
			dbg.location(169,28);
			char_literal43=(Token)match(input,EQ,FOLLOW_EQ_in_type_declaration1336);  
			stream_EQ.add(char_literal43);
			dbg.location(169,32);
			pushFollow(FOLLOW_type_in_type_declaration1338);
			type44=type();
			state._fsp--;

			stream_type.add(type44.getTree());dbg.location(169,37);
			char_literal45=(Token)match(input,SEMI,FOLLOW_SEMI_in_type_declaration1340);  
			stream_SEMI.add(char_literal45);

			// AST REWRITE
			// elements: ID, type
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 169:41: -> ^( TYPEDECL ID type )
			{
				dbg.location(169,44);
				// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:169:44: ^( TYPEDECL ID type )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(169,46);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(TYPEDECL, "TYPEDECL"), root_1);
				dbg.location(169,55);
				adaptor.addChild(root_1, stream_ID.nextNode());dbg.location(169,58);
				adaptor.addChild(root_1, stream_type.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(169, 62);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "type_declaration");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "type_declaration"


	public static class type_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "type"
	// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:171:1: type : ( base_type | ARRAY '[' INTLIT ']' ( '[' INTLIT ']' )? OF base_type -> ^( ARRAY base_type ( INTLIT )+ ) );
	public final TigerParser.type_return type() throws RecognitionException {
		TigerParser.type_return retval = new TigerParser.type_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ARRAY47=null;
		Token char_literal48=null;
		Token INTLIT49=null;
		Token char_literal50=null;
		Token char_literal51=null;
		Token INTLIT52=null;
		Token char_literal53=null;
		Token OF54=null;
		ParserRuleReturnScope base_type46 =null;
		ParserRuleReturnScope base_type55 =null;

		Object ARRAY47_tree=null;
		Object char_literal48_tree=null;
		Object INTLIT49_tree=null;
		Object char_literal50_tree=null;
		Object char_literal51_tree=null;
		Object INTLIT52_tree=null;
		Object char_literal53_tree=null;
		Object OF54_tree=null;
		RewriteRuleTokenStream stream_RBRACK=new RewriteRuleTokenStream(adaptor,"token RBRACK");
		RewriteRuleTokenStream stream_LBRACK=new RewriteRuleTokenStream(adaptor,"token LBRACK");
		RewriteRuleTokenStream stream_INTLIT=new RewriteRuleTokenStream(adaptor,"token INTLIT");
		RewriteRuleTokenStream stream_OF=new RewriteRuleTokenStream(adaptor,"token OF");
		RewriteRuleTokenStream stream_ARRAY=new RewriteRuleTokenStream(adaptor,"token ARRAY");
		RewriteRuleSubtreeStream stream_base_type=new RewriteRuleSubtreeStream(adaptor,"rule base_type");

		try { dbg.enterRule(getGrammarFileName(), "type");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(171, 0);

		try {
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:172:5: ( base_type | ARRAY '[' INTLIT ']' ( '[' INTLIT ']' )? OF base_type -> ^( ARRAY base_type ( INTLIT )+ ) )
			int alt10=2;
			try { dbg.enterDecision(10, decisionCanBacktrack[10]);

			int LA10_0 = input.LA(1);
			if ( (LA10_0==FIXEDPT||LA10_0==INT) ) {
				alt10=1;
			}
			else if ( (LA10_0==ARRAY) ) {
				alt10=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(10);}

			switch (alt10) {
				case 1 :
					dbg.enterAlt(1);

					// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:172:7: base_type
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(172,7);
					pushFollow(FOLLOW_base_type_in_type1362);
					base_type46=base_type();
					state._fsp--;

					adaptor.addChild(root_0, base_type46.getTree());

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:173:7: ARRAY '[' INTLIT ']' ( '[' INTLIT ']' )? OF base_type
					{
					dbg.location(173,7);
					ARRAY47=(Token)match(input,ARRAY,FOLLOW_ARRAY_in_type1370);  
					stream_ARRAY.add(ARRAY47);
					dbg.location(173,13);
					char_literal48=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_type1372);  
					stream_LBRACK.add(char_literal48);
					dbg.location(173,17);
					INTLIT49=(Token)match(input,INTLIT,FOLLOW_INTLIT_in_type1374);  
					stream_INTLIT.add(INTLIT49);
					dbg.location(173,24);
					char_literal50=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_type1376);  
					stream_RBRACK.add(char_literal50);
					dbg.location(173,28);
					// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:173:28: ( '[' INTLIT ']' )?
					int alt9=2;
					try { dbg.enterSubRule(9);
					try { dbg.enterDecision(9, decisionCanBacktrack[9]);

					int LA9_0 = input.LA(1);
					if ( (LA9_0==LBRACK) ) {
						alt9=1;
					}
					} finally {dbg.exitDecision(9);}

					switch (alt9) {
						case 1 :
							dbg.enterAlt(1);

							// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:173:29: '[' INTLIT ']'
							{
							dbg.location(173,29);
							char_literal51=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_type1379);  
							stream_LBRACK.add(char_literal51);
							dbg.location(173,33);
							INTLIT52=(Token)match(input,INTLIT,FOLLOW_INTLIT_in_type1381);  
							stream_INTLIT.add(INTLIT52);
							dbg.location(173,40);
							char_literal53=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_type1383);  
							stream_RBRACK.add(char_literal53);

							}
							break;

					}
					} finally {dbg.exitSubRule(9);}
					dbg.location(173,46);
					OF54=(Token)match(input,OF,FOLLOW_OF_in_type1387);  
					stream_OF.add(OF54);
					dbg.location(173,49);
					pushFollow(FOLLOW_base_type_in_type1389);
					base_type55=base_type();
					state._fsp--;

					stream_base_type.add(base_type55.getTree());
					// AST REWRITE
					// elements: base_type, ARRAY, INTLIT
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 173:59: -> ^( ARRAY base_type ( INTLIT )+ )
					{
						dbg.location(173,62);
						// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:173:62: ^( ARRAY base_type ( INTLIT )+ )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(173,64);
						root_1 = (Object)adaptor.becomeRoot(stream_ARRAY.nextNode(), root_1);
						dbg.location(173,70);
						adaptor.addChild(root_1, stream_base_type.nextTree());dbg.location(173,80);
						if ( !(stream_INTLIT.hasNext()) ) {
							throw new RewriteEarlyExitException();
						}
						while ( stream_INTLIT.hasNext() ) {
							dbg.location(173,80);
							adaptor.addChild(root_1, stream_INTLIT.nextNode());
						}
						stream_INTLIT.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(174, 4);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "type");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "type"


	public static class type_id_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "type_id"
	// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:176:1: type_id : ( base_type | ID );
	public final TigerParser.type_id_return type_id() throws RecognitionException {
		TigerParser.type_id_return retval = new TigerParser.type_id_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ID57=null;
		ParserRuleReturnScope base_type56 =null;

		Object ID57_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "type_id");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(176, 0);

		try {
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:177:5: ( base_type | ID )
			int alt11=2;
			try { dbg.enterDecision(11, decisionCanBacktrack[11]);

			int LA11_0 = input.LA(1);
			if ( (LA11_0==FIXEDPT||LA11_0==INT) ) {
				alt11=1;
			}
			else if ( (LA11_0==ID) ) {
				alt11=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(11);}

			switch (alt11) {
				case 1 :
					dbg.enterAlt(1);

					// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:177:7: base_type
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(177,7);
					pushFollow(FOLLOW_base_type_in_type_id1417);
					base_type56=base_type();
					state._fsp--;

					adaptor.addChild(root_0, base_type56.getTree());

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:178:7: ID
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(178,7);
					ID57=(Token)match(input,ID,FOLLOW_ID_in_type_id1425); 
					ID57_tree = (Object)adaptor.create(ID57);
					adaptor.addChild(root_0, ID57_tree);

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(179, 4);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "type_id");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "type_id"


	public static class base_type_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "base_type"
	// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:181:1: base_type : ( INT | FIXEDPT );
	public final TigerParser.base_type_return base_type() throws RecognitionException {
		TigerParser.base_type_return retval = new TigerParser.base_type_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set58=null;

		Object set58_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "base_type");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(181, 0);

		try {
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:182:5: ( INT | FIXEDPT )
			dbg.enterAlt(1);

			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(182,5);
			set58=input.LT(1);
			if ( input.LA(1)==FIXEDPT||input.LA(1)==INT ) {
				input.consume();
				adaptor.addChild(root_0, (Object)adaptor.create(set58));
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				dbg.recognitionException(mse);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(184, 4);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "base_type");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "base_type"


	public static class var_declaration_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "var_declaration"
	// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:186:1: var_declaration : VAR id_list ':' type_id optional_init ';' -> ^( VAR type_id id_list ( optional_init )? ) ;
	public final TigerParser.var_declaration_return var_declaration() throws RecognitionException {
		TigerParser.var_declaration_return retval = new TigerParser.var_declaration_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token VAR59=null;
		Token char_literal61=null;
		Token char_literal64=null;
		ParserRuleReturnScope id_list60 =null;
		ParserRuleReturnScope type_id62 =null;
		ParserRuleReturnScope optional_init63 =null;

		Object VAR59_tree=null;
		Object char_literal61_tree=null;
		Object char_literal64_tree=null;
		RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
		RewriteRuleTokenStream stream_VAR=new RewriteRuleTokenStream(adaptor,"token VAR");
		RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
		RewriteRuleSubtreeStream stream_optional_init=new RewriteRuleSubtreeStream(adaptor,"rule optional_init");
		RewriteRuleSubtreeStream stream_type_id=new RewriteRuleSubtreeStream(adaptor,"rule type_id");
		RewriteRuleSubtreeStream stream_id_list=new RewriteRuleSubtreeStream(adaptor,"rule id_list");

		try { dbg.enterRule(getGrammarFileName(), "var_declaration");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(186, 0);

		try {
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:186:17: ( VAR id_list ':' type_id optional_init ';' -> ^( VAR type_id id_list ( optional_init )? ) )
			dbg.enterAlt(1);

			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:186:19: VAR id_list ':' type_id optional_init ';'
			{
			dbg.location(186,19);
			VAR59=(Token)match(input,VAR,FOLLOW_VAR_in_var_declaration1463);  
			stream_VAR.add(VAR59);
			dbg.location(186,23);
			pushFollow(FOLLOW_id_list_in_var_declaration1465);
			id_list60=id_list();
			state._fsp--;

			stream_id_list.add(id_list60.getTree());dbg.location(186,31);
			char_literal61=(Token)match(input,COLON,FOLLOW_COLON_in_var_declaration1467);  
			stream_COLON.add(char_literal61);
			dbg.location(186,35);
			pushFollow(FOLLOW_type_id_in_var_declaration1469);
			type_id62=type_id();
			state._fsp--;

			stream_type_id.add(type_id62.getTree());dbg.location(186,43);
			pushFollow(FOLLOW_optional_init_in_var_declaration1471);
			optional_init63=optional_init();
			state._fsp--;

			stream_optional_init.add(optional_init63.getTree());dbg.location(186,57);
			char_literal64=(Token)match(input,SEMI,FOLLOW_SEMI_in_var_declaration1473);  
			stream_SEMI.add(char_literal64);

			// AST REWRITE
			// elements: id_list, type_id, VAR, optional_init
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 186:61: -> ^( VAR type_id id_list ( optional_init )? )
			{
				dbg.location(186,64);
				// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:186:64: ^( VAR type_id id_list ( optional_init )? )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(186,66);
				root_1 = (Object)adaptor.becomeRoot(stream_VAR.nextNode(), root_1);
				dbg.location(186,70);
				adaptor.addChild(root_1, stream_type_id.nextTree());dbg.location(186,78);
				adaptor.addChild(root_1, stream_id_list.nextTree());dbg.location(186,86);
				// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:186:86: ( optional_init )?
				if ( stream_optional_init.hasNext() ) {
					dbg.location(186,86);
					adaptor.addChild(root_1, stream_optional_init.nextTree());
				}
				stream_optional_init.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(186, 100);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "var_declaration");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "var_declaration"


	public static class id_list_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "id_list"
	// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:188:1: id_list : ID ( ',' ID )* -> ^( IDLIST ( ID )+ ) ;
	public final TigerParser.id_list_return id_list() throws RecognitionException {
		TigerParser.id_list_return retval = new TigerParser.id_list_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ID65=null;
		Token char_literal66=null;
		Token ID67=null;

		Object ID65_tree=null;
		Object char_literal66_tree=null;
		Object ID67_tree=null;
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");

		try { dbg.enterRule(getGrammarFileName(), "id_list");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(188, 0);

		try {
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:189:5: ( ID ( ',' ID )* -> ^( IDLIST ( ID )+ ) )
			dbg.enterAlt(1);

			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:189:7: ID ( ',' ID )*
			{
			dbg.location(189,7);
			ID65=(Token)match(input,ID,FOLLOW_ID_in_id_list1498);  
			stream_ID.add(ID65);
			dbg.location(189,10);
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:189:10: ( ',' ID )*
			try { dbg.enterSubRule(12);

			loop12:
			while (true) {
				int alt12=2;
				try { dbg.enterDecision(12, decisionCanBacktrack[12]);

				int LA12_0 = input.LA(1);
				if ( (LA12_0==COMMA) ) {
					alt12=1;
				}

				} finally {dbg.exitDecision(12);}

				switch (alt12) {
				case 1 :
					dbg.enterAlt(1);

					// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:189:12: ',' ID
					{
					dbg.location(189,12);
					char_literal66=(Token)match(input,COMMA,FOLLOW_COMMA_in_id_list1502);  
					stream_COMMA.add(char_literal66);
					dbg.location(189,16);
					ID67=(Token)match(input,ID,FOLLOW_ID_in_id_list1504);  
					stream_ID.add(ID67);

					}
					break;

				default :
					break loop12;
				}
			}
			} finally {dbg.exitSubRule(12);}

			// AST REWRITE
			// elements: ID
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 189:22: -> ^( IDLIST ( ID )+ )
			{
				dbg.location(189,25);
				// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:189:25: ^( IDLIST ( ID )+ )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(189,27);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(IDLIST, "IDLIST"), root_1);
				dbg.location(189,34);
				if ( !(stream_ID.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_ID.hasNext() ) {
					dbg.location(189,34);
					adaptor.addChild(root_1, stream_ID.nextNode());
				}
				stream_ID.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(190, 4);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "id_list");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "id_list"


	public static class optional_init_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "optional_init"
	// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:192:1: optional_init : ( ':=' literal |);
	public final TigerParser.optional_init_return optional_init() throws RecognitionException {
		TigerParser.optional_init_return retval = new TigerParser.optional_init_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal68=null;
		ParserRuleReturnScope literal69 =null;

		Object string_literal68_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "optional_init");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(192, 0);

		try {
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:193:5: ( ':=' literal |)
			int alt13=2;
			try { dbg.enterDecision(13, decisionCanBacktrack[13]);

			int LA13_0 = input.LA(1);
			if ( (LA13_0==ASSIGN) ) {
				alt13=1;
			}
			else if ( (LA13_0==SEMI) ) {
				alt13=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(13);}

			switch (alt13) {
				case 1 :
					dbg.enterAlt(1);

					// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:193:7: ':=' literal
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(193,7);
					string_literal68=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_optional_init1533); 
					string_literal68_tree = (Object)adaptor.create(string_literal68);
					adaptor.addChild(root_0, string_literal68_tree);
					dbg.location(193,12);
					pushFollow(FOLLOW_literal_in_optional_init1535);
					literal69=literal();
					state._fsp--;

					adaptor.addChild(root_0, literal69.getTree());

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:195:5: 
					{
					root_0 = (Object)adaptor.nil();


					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(195, 4);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "optional_init");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "optional_init"


	public static class stat_seq_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "stat_seq"
	// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:197:1: stat_seq : ( stat )+ ;
	public final TigerParser.stat_seq_return stat_seq() throws RecognitionException {
		TigerParser.stat_seq_return retval = new TigerParser.stat_seq_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope stat70 =null;


		try { dbg.enterRule(getGrammarFileName(), "stat_seq");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(197, 0);

		try {
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:198:5: ( ( stat )+ )
			dbg.enterAlt(1);

			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:198:7: ( stat )+
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(198,7);
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:198:7: ( stat )+
			int cnt14=0;
			try { dbg.enterSubRule(14);

			loop14:
			while (true) {
				int alt14=2;
				try { dbg.enterDecision(14, decisionCanBacktrack[14]);

				int LA14_0 = input.LA(1);
				if ( (LA14_0==BEGIN||LA14_0==BREAK||LA14_0==FOR||LA14_0==ID||LA14_0==IF||LA14_0==RETURN||LA14_0==WHILE) ) {
					alt14=1;
				}

				} finally {dbg.exitDecision(14);}

				switch (alt14) {
				case 1 :
					dbg.enterAlt(1);

					// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:198:7: stat
					{
					dbg.location(198,7);
					pushFollow(FOLLOW_stat_in_stat_seq1558);
					stat70=stat();
					state._fsp--;

					adaptor.addChild(root_0, stat70.getTree());

					}
					break;

				default :
					if ( cnt14 >= 1 ) break loop14;
					EarlyExitException eee = new EarlyExitException(14, input);
					dbg.recognitionException(eee);

					throw eee;
				}
				cnt14++;
			}
			} finally {dbg.exitSubRule(14);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(199, 4);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "stat_seq");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "stat_seq"


	public static class stat_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "stat"
	// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:201:1: stat : ( function_call_or_assignment | IF expr THEN seq1= stat_seq ( ELSE seq2= stat_seq ENDIF -> ^( IF expr ^( THEN_STATS $seq1) ^( ELSE_STATS $seq2) ) | ENDIF -> ^( IF expr ^( THEN_STATS $seq1) ) ) ';' | WHILE expr DO stat_seq ENDDO ';' -> ^( WHILE expr stat_seq ) | FOR ID ':=' index_expr TO index_expr DO stat_seq ENDDO ';' -> ^( FOR ID index_expr index_expr stat_seq ) | BREAK ';' !| RETURN expr ';' -> ^( RETURN expr ) | block );
	public final TigerParser.stat_return stat() throws RecognitionException {
		TigerParser.stat_return retval = new TigerParser.stat_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token IF72=null;
		Token THEN74=null;
		Token ELSE75=null;
		Token ENDIF76=null;
		Token ENDIF77=null;
		Token char_literal78=null;
		Token WHILE79=null;
		Token DO81=null;
		Token ENDDO83=null;
		Token char_literal84=null;
		Token FOR85=null;
		Token ID86=null;
		Token string_literal87=null;
		Token TO89=null;
		Token DO91=null;
		Token ENDDO93=null;
		Token char_literal94=null;
		Token BREAK95=null;
		Token char_literal96=null;
		Token RETURN97=null;
		Token char_literal99=null;
		ParserRuleReturnScope seq1 =null;
		ParserRuleReturnScope seq2 =null;
		ParserRuleReturnScope function_call_or_assignment71 =null;
		ParserRuleReturnScope expr73 =null;
		ParserRuleReturnScope expr80 =null;
		ParserRuleReturnScope stat_seq82 =null;
		ParserRuleReturnScope index_expr88 =null;
		ParserRuleReturnScope index_expr90 =null;
		ParserRuleReturnScope stat_seq92 =null;
		ParserRuleReturnScope expr98 =null;
		ParserRuleReturnScope block100 =null;

		Object IF72_tree=null;
		Object THEN74_tree=null;
		Object ELSE75_tree=null;
		Object ENDIF76_tree=null;
		Object ENDIF77_tree=null;
		Object char_literal78_tree=null;
		Object WHILE79_tree=null;
		Object DO81_tree=null;
		Object ENDDO83_tree=null;
		Object char_literal84_tree=null;
		Object FOR85_tree=null;
		Object ID86_tree=null;
		Object string_literal87_tree=null;
		Object TO89_tree=null;
		Object DO91_tree=null;
		Object ENDDO93_tree=null;
		Object char_literal94_tree=null;
		Object BREAK95_tree=null;
		Object char_literal96_tree=null;
		Object RETURN97_tree=null;
		Object char_literal99_tree=null;
		RewriteRuleTokenStream stream_THEN=new RewriteRuleTokenStream(adaptor,"token THEN");
		RewriteRuleTokenStream stream_WHILE=new RewriteRuleTokenStream(adaptor,"token WHILE");
		RewriteRuleTokenStream stream_TO=new RewriteRuleTokenStream(adaptor,"token TO");
		RewriteRuleTokenStream stream_ELSE=new RewriteRuleTokenStream(adaptor,"token ELSE");
		RewriteRuleTokenStream stream_ASSIGN=new RewriteRuleTokenStream(adaptor,"token ASSIGN");
		RewriteRuleTokenStream stream_RETURN=new RewriteRuleTokenStream(adaptor,"token RETURN");
		RewriteRuleTokenStream stream_ENDIF=new RewriteRuleTokenStream(adaptor,"token ENDIF");
		RewriteRuleTokenStream stream_DO=new RewriteRuleTokenStream(adaptor,"token DO");
		RewriteRuleTokenStream stream_FOR=new RewriteRuleTokenStream(adaptor,"token FOR");
		RewriteRuleTokenStream stream_ENDDO=new RewriteRuleTokenStream(adaptor,"token ENDDO");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
		RewriteRuleTokenStream stream_IF=new RewriteRuleTokenStream(adaptor,"token IF");
		RewriteRuleSubtreeStream stream_index_expr=new RewriteRuleSubtreeStream(adaptor,"rule index_expr");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
		RewriteRuleSubtreeStream stream_stat_seq=new RewriteRuleSubtreeStream(adaptor,"rule stat_seq");

		try { dbg.enterRule(getGrammarFileName(), "stat");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(201, 0);

		try {
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:202:5: ( function_call_or_assignment | IF expr THEN seq1= stat_seq ( ELSE seq2= stat_seq ENDIF -> ^( IF expr ^( THEN_STATS $seq1) ^( ELSE_STATS $seq2) ) | ENDIF -> ^( IF expr ^( THEN_STATS $seq1) ) ) ';' | WHILE expr DO stat_seq ENDDO ';' -> ^( WHILE expr stat_seq ) | FOR ID ':=' index_expr TO index_expr DO stat_seq ENDDO ';' -> ^( FOR ID index_expr index_expr stat_seq ) | BREAK ';' !| RETURN expr ';' -> ^( RETURN expr ) | block )
			int alt16=7;
			try { dbg.enterDecision(16, decisionCanBacktrack[16]);

			switch ( input.LA(1) ) {
			case ID:
				{
				alt16=1;
				}
				break;
			case IF:
				{
				alt16=2;
				}
				break;
			case WHILE:
				{
				alt16=3;
				}
				break;
			case FOR:
				{
				alt16=4;
				}
				break;
			case BREAK:
				{
				alt16=5;
				}
				break;
			case RETURN:
				{
				alt16=6;
				}
				break;
			case BEGIN:
				{
				alt16=7;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 16, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(16);}

			switch (alt16) {
				case 1 :
					dbg.enterAlt(1);

					// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:202:7: function_call_or_assignment
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(202,7);
					pushFollow(FOLLOW_function_call_or_assignment_in_stat1576);
					function_call_or_assignment71=function_call_or_assignment();
					state._fsp--;

					adaptor.addChild(root_0, function_call_or_assignment71.getTree());

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:203:7: IF expr THEN seq1= stat_seq ( ELSE seq2= stat_seq ENDIF -> ^( IF expr ^( THEN_STATS $seq1) ^( ELSE_STATS $seq2) ) | ENDIF -> ^( IF expr ^( THEN_STATS $seq1) ) ) ';'
					{
					dbg.location(203,7);
					IF72=(Token)match(input,IF,FOLLOW_IF_in_stat1584);  
					stream_IF.add(IF72);
					dbg.location(203,10);
					pushFollow(FOLLOW_expr_in_stat1586);
					expr73=expr();
					state._fsp--;

					stream_expr.add(expr73.getTree());dbg.location(203,15);
					THEN74=(Token)match(input,THEN,FOLLOW_THEN_in_stat1588);  
					stream_THEN.add(THEN74);
					dbg.location(203,24);
					pushFollow(FOLLOW_stat_seq_in_stat1592);
					seq1=stat_seq();
					state._fsp--;

					stream_stat_seq.add(seq1.getTree());dbg.location(204,9);
					// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:204:9: ( ELSE seq2= stat_seq ENDIF -> ^( IF expr ^( THEN_STATS $seq1) ^( ELSE_STATS $seq2) ) | ENDIF -> ^( IF expr ^( THEN_STATS $seq1) ) )
					int alt15=2;
					try { dbg.enterSubRule(15);
					try { dbg.enterDecision(15, decisionCanBacktrack[15]);

					int LA15_0 = input.LA(1);
					if ( (LA15_0==ELSE) ) {
						alt15=1;
					}
					else if ( (LA15_0==ENDIF) ) {
						alt15=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 15, 0, input);
						dbg.recognitionException(nvae);
						throw nvae;
					}

					} finally {dbg.exitDecision(15);}

					switch (alt15) {
						case 1 :
							dbg.enterAlt(1);

							// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:204:11: ELSE seq2= stat_seq ENDIF
							{
							dbg.location(204,11);
							ELSE75=(Token)match(input,ELSE,FOLLOW_ELSE_in_stat1605);  
							stream_ELSE.add(ELSE75);
							dbg.location(204,20);
							pushFollow(FOLLOW_stat_seq_in_stat1609);
							seq2=stat_seq();
							state._fsp--;

							stream_stat_seq.add(seq2.getTree());dbg.location(204,30);
							ENDIF76=(Token)match(input,ENDIF,FOLLOW_ENDIF_in_stat1611);  
							stream_ENDIF.add(ENDIF76);

							// AST REWRITE
							// elements: seq1, seq2, IF, expr
							// token labels: 
							// rule labels: retval, seq1, seq2
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);
							RewriteRuleSubtreeStream stream_seq1=new RewriteRuleSubtreeStream(adaptor,"rule seq1",seq1!=null?seq1.getTree():null);
							RewriteRuleSubtreeStream stream_seq2=new RewriteRuleSubtreeStream(adaptor,"rule seq2",seq2!=null?seq2.getTree():null);

							root_0 = (Object)adaptor.nil();
							// 205:13: -> ^( IF expr ^( THEN_STATS $seq1) ^( ELSE_STATS $seq2) )
							{
								dbg.location(205,16);
								// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:205:16: ^( IF expr ^( THEN_STATS $seq1) ^( ELSE_STATS $seq2) )
								{
								Object root_1 = (Object)adaptor.nil();
								dbg.location(205,18);
								root_1 = (Object)adaptor.becomeRoot(stream_IF.nextNode(), root_1);
								dbg.location(205,21);
								adaptor.addChild(root_1, stream_expr.nextTree());dbg.location(205,26);
								// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:205:26: ^( THEN_STATS $seq1)
								{
								Object root_2 = (Object)adaptor.nil();
								dbg.location(205,28);
								root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(THEN_STATS, "THEN_STATS"), root_2);
								dbg.location(205,40);
								adaptor.addChild(root_2, stream_seq1.nextTree());
								adaptor.addChild(root_1, root_2);
								}
								dbg.location(205,46);
								// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:205:46: ^( ELSE_STATS $seq2)
								{
								Object root_2 = (Object)adaptor.nil();
								dbg.location(205,48);
								root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(ELSE_STATS, "ELSE_STATS"), root_2);
								dbg.location(205,60);
								adaptor.addChild(root_2, stream_seq2.nextTree());
								adaptor.addChild(root_1, root_2);
								}

								adaptor.addChild(root_0, root_1);
								}

							}


							retval.tree = root_0;

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:206:11: ENDIF
							{
							dbg.location(206,11);
							ENDIF77=(Token)match(input,ENDIF,FOLLOW_ENDIF_in_stat1657);  
							stream_ENDIF.add(ENDIF77);

							// AST REWRITE
							// elements: expr, IF, seq1
							// token labels: 
							// rule labels: retval, seq1
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);
							RewriteRuleSubtreeStream stream_seq1=new RewriteRuleSubtreeStream(adaptor,"rule seq1",seq1!=null?seq1.getTree():null);

							root_0 = (Object)adaptor.nil();
							// 207:13: -> ^( IF expr ^( THEN_STATS $seq1) )
							{
								dbg.location(207,16);
								// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:207:16: ^( IF expr ^( THEN_STATS $seq1) )
								{
								Object root_1 = (Object)adaptor.nil();
								dbg.location(207,18);
								root_1 = (Object)adaptor.becomeRoot(stream_IF.nextNode(), root_1);
								dbg.location(207,21);
								adaptor.addChild(root_1, stream_expr.nextTree());dbg.location(207,26);
								// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:207:26: ^( THEN_STATS $seq1)
								{
								Object root_2 = (Object)adaptor.nil();
								dbg.location(207,28);
								root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(THEN_STATS, "THEN_STATS"), root_2);
								dbg.location(207,40);
								adaptor.addChild(root_2, stream_seq1.nextTree());
								adaptor.addChild(root_1, root_2);
								}

								adaptor.addChild(root_0, root_1);
								}

							}


							retval.tree = root_0;

							}
							break;

					}
					} finally {dbg.exitSubRule(15);}
					dbg.location(208,11);
					char_literal78=(Token)match(input,SEMI,FOLLOW_SEMI_in_stat1696);  
					stream_SEMI.add(char_literal78);

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:209:7: WHILE expr DO stat_seq ENDDO ';'
					{
					dbg.location(209,7);
					WHILE79=(Token)match(input,WHILE,FOLLOW_WHILE_in_stat1704);  
					stream_WHILE.add(WHILE79);
					dbg.location(209,13);
					pushFollow(FOLLOW_expr_in_stat1706);
					expr80=expr();
					state._fsp--;

					stream_expr.add(expr80.getTree());dbg.location(209,18);
					DO81=(Token)match(input,DO,FOLLOW_DO_in_stat1708);  
					stream_DO.add(DO81);
					dbg.location(209,21);
					pushFollow(FOLLOW_stat_seq_in_stat1710);
					stat_seq82=stat_seq();
					state._fsp--;

					stream_stat_seq.add(stat_seq82.getTree());dbg.location(209,30);
					ENDDO83=(Token)match(input,ENDDO,FOLLOW_ENDDO_in_stat1712);  
					stream_ENDDO.add(ENDDO83);
					dbg.location(209,36);
					char_literal84=(Token)match(input,SEMI,FOLLOW_SEMI_in_stat1714);  
					stream_SEMI.add(char_literal84);

					// AST REWRITE
					// elements: WHILE, expr, stat_seq
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 210:9: -> ^( WHILE expr stat_seq )
					{
						dbg.location(210,12);
						// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:210:12: ^( WHILE expr stat_seq )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(210,14);
						root_1 = (Object)adaptor.becomeRoot(stream_WHILE.nextNode(), root_1);
						dbg.location(210,20);
						adaptor.addChild(root_1, stream_expr.nextTree());dbg.location(210,25);
						adaptor.addChild(root_1, stream_stat_seq.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:211:7: FOR ID ':=' index_expr TO index_expr DO stat_seq ENDDO ';'
					{
					dbg.location(211,7);
					FOR85=(Token)match(input,FOR,FOLLOW_FOR_in_stat1740);  
					stream_FOR.add(FOR85);
					dbg.location(211,11);
					ID86=(Token)match(input,ID,FOLLOW_ID_in_stat1742);  
					stream_ID.add(ID86);
					dbg.location(211,14);
					string_literal87=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_stat1744);  
					stream_ASSIGN.add(string_literal87);
					dbg.location(211,19);
					pushFollow(FOLLOW_index_expr_in_stat1746);
					index_expr88=index_expr();
					state._fsp--;

					stream_index_expr.add(index_expr88.getTree());dbg.location(211,30);
					TO89=(Token)match(input,TO,FOLLOW_TO_in_stat1748);  
					stream_TO.add(TO89);
					dbg.location(211,33);
					pushFollow(FOLLOW_index_expr_in_stat1750);
					index_expr90=index_expr();
					state._fsp--;

					stream_index_expr.add(index_expr90.getTree());dbg.location(211,44);
					DO91=(Token)match(input,DO,FOLLOW_DO_in_stat1752);  
					stream_DO.add(DO91);
					dbg.location(211,47);
					pushFollow(FOLLOW_stat_seq_in_stat1754);
					stat_seq92=stat_seq();
					state._fsp--;

					stream_stat_seq.add(stat_seq92.getTree());dbg.location(211,56);
					ENDDO93=(Token)match(input,ENDDO,FOLLOW_ENDDO_in_stat1756);  
					stream_ENDDO.add(ENDDO93);
					dbg.location(211,62);
					char_literal94=(Token)match(input,SEMI,FOLLOW_SEMI_in_stat1758);  
					stream_SEMI.add(char_literal94);

					// AST REWRITE
					// elements: index_expr, ID, stat_seq, index_expr, FOR
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 212:9: -> ^( FOR ID index_expr index_expr stat_seq )
					{
						dbg.location(212,12);
						// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:212:12: ^( FOR ID index_expr index_expr stat_seq )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(212,14);
						root_1 = (Object)adaptor.becomeRoot(stream_FOR.nextNode(), root_1);
						dbg.location(212,18);
						adaptor.addChild(root_1, stream_ID.nextNode());dbg.location(212,21);
						adaptor.addChild(root_1, stream_index_expr.nextTree());dbg.location(212,32);
						adaptor.addChild(root_1, stream_index_expr.nextTree());dbg.location(212,43);
						adaptor.addChild(root_1, stream_stat_seq.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 5 :
					dbg.enterAlt(5);

					// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:213:7: BREAK ';' !
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(213,7);
					BREAK95=(Token)match(input,BREAK,FOLLOW_BREAK_in_stat1788); 
					BREAK95_tree = (Object)adaptor.create(BREAK95);
					adaptor.addChild(root_0, BREAK95_tree);
					dbg.location(213,16);
					char_literal96=(Token)match(input,SEMI,FOLLOW_SEMI_in_stat1790); 
					}
					break;
				case 6 :
					dbg.enterAlt(6);

					// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:214:7: RETURN expr ';'
					{
					dbg.location(214,7);
					RETURN97=(Token)match(input,RETURN,FOLLOW_RETURN_in_stat1799);  
					stream_RETURN.add(RETURN97);
					dbg.location(214,14);
					pushFollow(FOLLOW_expr_in_stat1801);
					expr98=expr();
					state._fsp--;

					stream_expr.add(expr98.getTree());dbg.location(214,19);
					char_literal99=(Token)match(input,SEMI,FOLLOW_SEMI_in_stat1803);  
					stream_SEMI.add(char_literal99);

					// AST REWRITE
					// elements: RETURN, expr
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 215:9: -> ^( RETURN expr )
					{
						dbg.location(215,12);
						// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:215:12: ^( RETURN expr )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(215,14);
						root_1 = (Object)adaptor.becomeRoot(stream_RETURN.nextNode(), root_1);
						dbg.location(215,21);
						adaptor.addChild(root_1, stream_expr.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 7 :
					dbg.enterAlt(7);

					// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:216:7: block
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(216,7);
					pushFollow(FOLLOW_block_in_stat1827);
					block100=block();
					state._fsp--;

					adaptor.addChild(root_0, block100.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(217, 4);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "stat");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "stat"


	public static class function_args_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "function_args"
	// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:219:1: function_args : '(' expr_list ')' -> ( expr_list )? ;
	public final TigerParser.function_args_return function_args() throws RecognitionException {
		TigerParser.function_args_return retval = new TigerParser.function_args_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal101=null;
		Token char_literal103=null;
		ParserRuleReturnScope expr_list102 =null;

		Object char_literal101_tree=null;
		Object char_literal103_tree=null;
		RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
		RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
		RewriteRuleSubtreeStream stream_expr_list=new RewriteRuleSubtreeStream(adaptor,"rule expr_list");

		try { dbg.enterRule(getGrammarFileName(), "function_args");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(219, 0);

		try {
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:220:5: ( '(' expr_list ')' -> ( expr_list )? )
			dbg.enterAlt(1);

			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:220:7: '(' expr_list ')'
			{
			dbg.location(220,7);
			char_literal101=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_function_args1844);  
			stream_LPAREN.add(char_literal101);
			dbg.location(220,11);
			pushFollow(FOLLOW_expr_list_in_function_args1846);
			expr_list102=expr_list();
			state._fsp--;

			stream_expr_list.add(expr_list102.getTree());dbg.location(220,21);
			char_literal103=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_function_args1848);  
			stream_RPAREN.add(char_literal103);

			// AST REWRITE
			// elements: expr_list
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 221:9: -> ( expr_list )?
			{
				dbg.location(221,12);
				// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:221:12: ( expr_list )?
				if ( stream_expr_list.hasNext() ) {
					dbg.location(221,12);
					adaptor.addChild(root_0, stream_expr_list.nextTree());
				}
				stream_expr_list.reset();

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(222, 4);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "function_args");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "function_args"


	public static class function_call_or_assignment_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "function_call_or_assignment"
	// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:224:1: function_call_or_assignment : ID ( function_args -> ^( FUNCTION_CALL ID ( function_args )? ) | value_tail ':=' expr_or_function_call -> ^( ':=' ^( ID ( value_tail )? ) expr_or_function_call ) ) ';' ;
	public final TigerParser.function_call_or_assignment_return function_call_or_assignment() throws RecognitionException {
		TigerParser.function_call_or_assignment_return retval = new TigerParser.function_call_or_assignment_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ID104=null;
		Token string_literal107=null;
		Token char_literal109=null;
		ParserRuleReturnScope function_args105 =null;
		ParserRuleReturnScope value_tail106 =null;
		ParserRuleReturnScope expr_or_function_call108 =null;

		Object ID104_tree=null;
		Object string_literal107_tree=null;
		Object char_literal109_tree=null;
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
		RewriteRuleTokenStream stream_ASSIGN=new RewriteRuleTokenStream(adaptor,"token ASSIGN");
		RewriteRuleSubtreeStream stream_expr_or_function_call=new RewriteRuleSubtreeStream(adaptor,"rule expr_or_function_call");
		RewriteRuleSubtreeStream stream_function_args=new RewriteRuleSubtreeStream(adaptor,"rule function_args");
		RewriteRuleSubtreeStream stream_value_tail=new RewriteRuleSubtreeStream(adaptor,"rule value_tail");

		try { dbg.enterRule(getGrammarFileName(), "function_call_or_assignment");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(224, 0);

		try {
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:225:5: ( ID ( function_args -> ^( FUNCTION_CALL ID ( function_args )? ) | value_tail ':=' expr_or_function_call -> ^( ':=' ^( ID ( value_tail )? ) expr_or_function_call ) ) ';' )
			dbg.enterAlt(1);

			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:225:7: ID ( function_args -> ^( FUNCTION_CALL ID ( function_args )? ) | value_tail ':=' expr_or_function_call -> ^( ':=' ^( ID ( value_tail )? ) expr_or_function_call ) ) ';'
			{
			dbg.location(225,7);
			ID104=(Token)match(input,ID,FOLLOW_ID_in_function_call_or_assignment1878);  
			stream_ID.add(ID104);
			dbg.location(226,9);
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:226:9: ( function_args -> ^( FUNCTION_CALL ID ( function_args )? ) | value_tail ':=' expr_or_function_call -> ^( ':=' ^( ID ( value_tail )? ) expr_or_function_call ) )
			int alt17=2;
			try { dbg.enterSubRule(17);
			try { dbg.enterDecision(17, decisionCanBacktrack[17]);

			int LA17_0 = input.LA(1);
			if ( (LA17_0==LPAREN) ) {
				alt17=1;
			}
			else if ( (LA17_0==AND||LA17_0==ASSIGN||LA17_0==COMMA||(LA17_0 >= DIV && LA17_0 <= DO)||LA17_0==EQ||(LA17_0 >= GREATER && LA17_0 <= GREATEREQ)||(LA17_0 >= LBRACK && LA17_0 <= LESSEREQ)||(LA17_0 >= MINUS && LA17_0 <= NEQ)||LA17_0==OR||LA17_0==PLUS||(LA17_0 >= RPAREN && LA17_0 <= THEN)) ) {
				alt17=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 17, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(17);}

			switch (alt17) {
				case 1 :
					dbg.enterAlt(1);

					// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:226:10: function_args
					{
					dbg.location(226,10);
					pushFollow(FOLLOW_function_args_in_function_call_or_assignment1890);
					function_args105=function_args();
					state._fsp--;

					stream_function_args.add(function_args105.getTree());
					// AST REWRITE
					// elements: function_args, ID
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 227:13: -> ^( FUNCTION_CALL ID ( function_args )? )
					{
						dbg.location(227,16);
						// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:227:16: ^( FUNCTION_CALL ID ( function_args )? )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(227,18);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNCTION_CALL, "FUNCTION_CALL"), root_1);
						dbg.location(227,32);
						adaptor.addChild(root_1, stream_ID.nextNode());dbg.location(227,35);
						// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:227:35: ( function_args )?
						if ( stream_function_args.hasNext() ) {
							dbg.location(227,35);
							adaptor.addChild(root_1, stream_function_args.nextTree());
						}
						stream_function_args.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:228:11: value_tail ':=' expr_or_function_call
					{
					dbg.location(228,11);
					pushFollow(FOLLOW_value_tail_in_function_call_or_assignment1925);
					value_tail106=value_tail();
					state._fsp--;

					stream_value_tail.add(value_tail106.getTree());dbg.location(228,22);
					string_literal107=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_function_call_or_assignment1927);  
					stream_ASSIGN.add(string_literal107);
					dbg.location(228,27);
					pushFollow(FOLLOW_expr_or_function_call_in_function_call_or_assignment1929);
					expr_or_function_call108=expr_or_function_call();
					state._fsp--;

					stream_expr_or_function_call.add(expr_or_function_call108.getTree());
					// AST REWRITE
					// elements: expr_or_function_call, ASSIGN, ID, value_tail
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 229:13: -> ^( ':=' ^( ID ( value_tail )? ) expr_or_function_call )
					{
						dbg.location(229,16);
						// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:229:16: ^( ':=' ^( ID ( value_tail )? ) expr_or_function_call )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(229,18);
						root_1 = (Object)adaptor.becomeRoot(stream_ASSIGN.nextNode(), root_1);
						dbg.location(229,23);
						// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:229:23: ^( ID ( value_tail )? )
						{
						Object root_2 = (Object)adaptor.nil();
						dbg.location(229,25);
						root_2 = (Object)adaptor.becomeRoot(stream_ID.nextNode(), root_2);
						dbg.location(229,28);
						// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:229:28: ( value_tail )?
						if ( stream_value_tail.hasNext() ) {
							dbg.location(229,28);
							adaptor.addChild(root_2, stream_value_tail.nextTree());
						}
						stream_value_tail.reset();

						adaptor.addChild(root_1, root_2);
						}
						dbg.location(229,41);
						adaptor.addChild(root_1, stream_expr_or_function_call.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;

			}
			} finally {dbg.exitSubRule(17);}
			dbg.location(230,11);
			char_literal109=(Token)match(input,SEMI,FOLLOW_SEMI_in_function_call_or_assignment1968);  
			stream_SEMI.add(char_literal109);

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(231, 4);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "function_call_or_assignment");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "function_call_or_assignment"


	public static class expr_or_function_call_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expr_or_function_call"
	// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:233:1: expr_or_function_call : ( ID ( expr_with_start_id[$ID] -> ^( EXPR_WITH_START_ID ( expr_with_start_id )? ) | function_args -> ^( FUNCTION_CALL ID ( function_args )? ) ) | expr_no_start_id );
	public final TigerParser.expr_or_function_call_return expr_or_function_call() throws RecognitionException {
		TigerParser.expr_or_function_call_return retval = new TigerParser.expr_or_function_call_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ID110=null;
		ParserRuleReturnScope expr_with_start_id111 =null;
		ParserRuleReturnScope function_args112 =null;
		ParserRuleReturnScope expr_no_start_id113 =null;

		Object ID110_tree=null;
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleSubtreeStream stream_function_args=new RewriteRuleSubtreeStream(adaptor,"rule function_args");
		RewriteRuleSubtreeStream stream_expr_with_start_id=new RewriteRuleSubtreeStream(adaptor,"rule expr_with_start_id");

		try { dbg.enterRule(getGrammarFileName(), "expr_or_function_call");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(233, 0);

		try {
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:234:5: ( ID ( expr_with_start_id[$ID] -> ^( EXPR_WITH_START_ID ( expr_with_start_id )? ) | function_args -> ^( FUNCTION_CALL ID ( function_args )? ) ) | expr_no_start_id )
			int alt19=2;
			try { dbg.enterDecision(19, decisionCanBacktrack[19]);

			int LA19_0 = input.LA(1);
			if ( (LA19_0==ID) ) {
				alt19=1;
			}
			else if ( (LA19_0==FIXEDPTLIT||LA19_0==INTLIT||LA19_0==LPAREN) ) {
				alt19=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 19, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(19);}

			switch (alt19) {
				case 1 :
					dbg.enterAlt(1);

					// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:234:7: ID ( expr_with_start_id[$ID] -> ^( EXPR_WITH_START_ID ( expr_with_start_id )? ) | function_args -> ^( FUNCTION_CALL ID ( function_args )? ) )
					{
					dbg.location(234,7);
					ID110=(Token)match(input,ID,FOLLOW_ID_in_expr_or_function_call1985);  
					stream_ID.add(ID110);
					dbg.location(235,9);
					// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:235:9: ( expr_with_start_id[$ID] -> ^( EXPR_WITH_START_ID ( expr_with_start_id )? ) | function_args -> ^( FUNCTION_CALL ID ( function_args )? ) )
					int alt18=2;
					try { dbg.enterSubRule(18);
					try { dbg.enterDecision(18, decisionCanBacktrack[18]);

					int LA18_0 = input.LA(1);
					if ( (LA18_0==AND||LA18_0==ASSIGN||LA18_0==COMMA||(LA18_0 >= DIV && LA18_0 <= DO)||LA18_0==EQ||(LA18_0 >= GREATER && LA18_0 <= GREATEREQ)||(LA18_0 >= LBRACK && LA18_0 <= LESSEREQ)||(LA18_0 >= MINUS && LA18_0 <= NEQ)||LA18_0==OR||LA18_0==PLUS||(LA18_0 >= RPAREN && LA18_0 <= THEN)) ) {
						alt18=1;
					}
					else if ( (LA18_0==LPAREN) ) {
						alt18=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 18, 0, input);
						dbg.recognitionException(nvae);
						throw nvae;
					}

					} finally {dbg.exitDecision(18);}

					switch (alt18) {
						case 1 :
							dbg.enterAlt(1);

							// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:235:10: expr_with_start_id[$ID]
							{
							dbg.location(235,10);
							pushFollow(FOLLOW_expr_with_start_id_in_expr_or_function_call1997);
							expr_with_start_id111=expr_with_start_id(ID110);
							state._fsp--;

							stream_expr_with_start_id.add(expr_with_start_id111.getTree());
							// AST REWRITE
							// elements: expr_with_start_id
							// token labels: 
							// rule labels: retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (Object)adaptor.nil();
							// 235:34: -> ^( EXPR_WITH_START_ID ( expr_with_start_id )? )
							{
								dbg.location(235,37);
								// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:235:37: ^( EXPR_WITH_START_ID ( expr_with_start_id )? )
								{
								Object root_1 = (Object)adaptor.nil();
								dbg.location(235,39);
								root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EXPR_WITH_START_ID, "EXPR_WITH_START_ID"), root_1);
								dbg.location(235,58);
								// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:235:58: ( expr_with_start_id )?
								if ( stream_expr_with_start_id.hasNext() ) {
									dbg.location(235,58);
									adaptor.addChild(root_1, stream_expr_with_start_id.nextTree());
								}
								stream_expr_with_start_id.reset();

								adaptor.addChild(root_0, root_1);
								}

							}


							retval.tree = root_0;

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:236:11: function_args
							{
							dbg.location(236,11);
							pushFollow(FOLLOW_function_args_in_expr_or_function_call2019);
							function_args112=function_args();
							state._fsp--;

							stream_function_args.add(function_args112.getTree());
							// AST REWRITE
							// elements: function_args, ID
							// token labels: 
							// rule labels: retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (Object)adaptor.nil();
							// 237:13: -> ^( FUNCTION_CALL ID ( function_args )? )
							{
								dbg.location(237,16);
								// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:237:16: ^( FUNCTION_CALL ID ( function_args )? )
								{
								Object root_1 = (Object)adaptor.nil();
								dbg.location(237,18);
								root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNCTION_CALL, "FUNCTION_CALL"), root_1);
								dbg.location(237,32);
								adaptor.addChild(root_1, stream_ID.nextNode());dbg.location(237,35);
								// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:237:35: ( function_args )?
								if ( stream_function_args.hasNext() ) {
									dbg.location(237,35);
									adaptor.addChild(root_1, stream_function_args.nextTree());
								}
								stream_function_args.reset();

								adaptor.addChild(root_0, root_1);
								}

							}


							retval.tree = root_0;

							}
							break;

					}
					} finally {dbg.exitSubRule(18);}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:239:7: expr_no_start_id
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(239,7);
					pushFollow(FOLLOW_expr_no_start_id_in_expr_or_function_call2060);
					expr_no_start_id113=expr_no_start_id();
					state._fsp--;

					adaptor.addChild(root_0, expr_no_start_id113.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(240, 4);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "expr_or_function_call");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "expr_or_function_call"


	public static class expr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expr"
	// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:243:1: expr : term4 ( and_operator ^ term4 )* ;
	public final TigerParser.expr_return expr() throws RecognitionException {
		TigerParser.expr_return retval = new TigerParser.expr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope term4114 =null;
		ParserRuleReturnScope and_operator115 =null;
		ParserRuleReturnScope term4116 =null;


		try { dbg.enterRule(getGrammarFileName(), "expr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(243, 0);

		try {
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:243:6: ( term4 ( and_operator ^ term4 )* )
			dbg.enterAlt(1);

			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:243:8: term4 ( and_operator ^ term4 )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(243,8);
			pushFollow(FOLLOW_term4_in_expr2075);
			term4114=term4();
			state._fsp--;

			adaptor.addChild(root_0, term4114.getTree());
			dbg.location(243,14);
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:243:14: ( and_operator ^ term4 )*
			try { dbg.enterSubRule(20);

			loop20:
			while (true) {
				int alt20=2;
				try { dbg.enterDecision(20, decisionCanBacktrack[20]);

				int LA20_0 = input.LA(1);
				if ( (LA20_0==AND||LA20_0==OR) ) {
					alt20=1;
				}

				} finally {dbg.exitDecision(20);}

				switch (alt20) {
				case 1 :
					dbg.enterAlt(1);

					// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:243:15: and_operator ^ term4
					{
					dbg.location(243,27);
					pushFollow(FOLLOW_and_operator_in_expr2078);
					and_operator115=and_operator();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(and_operator115.getTree(), root_0);dbg.location(243,29);
					pushFollow(FOLLOW_term4_in_expr2081);
					term4116=term4();
					state._fsp--;

					adaptor.addChild(root_0, term4116.getTree());

					}
					break;

				default :
					break loop20;
				}
			}
			} finally {dbg.exitSubRule(20);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(243, 36);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "expr");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "expr"


	public static class term4_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "term4"
	// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:244:1: term4 : term3 ( compare_operator ^ term3 )* ;
	public final TigerParser.term4_return term4() throws RecognitionException {
		TigerParser.term4_return retval = new TigerParser.term4_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope term3117 =null;
		ParserRuleReturnScope compare_operator118 =null;
		ParserRuleReturnScope term3119 =null;


		try { dbg.enterRule(getGrammarFileName(), "term4");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(244, 0);

		try {
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:244:7: ( term3 ( compare_operator ^ term3 )* )
			dbg.enterAlt(1);

			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:244:9: term3 ( compare_operator ^ term3 )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(244,9);
			pushFollow(FOLLOW_term3_in_term42091);
			term3117=term3();
			state._fsp--;

			adaptor.addChild(root_0, term3117.getTree());
			dbg.location(244,15);
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:244:15: ( compare_operator ^ term3 )*
			try { dbg.enterSubRule(21);

			loop21:
			while (true) {
				int alt21=2;
				try { dbg.enterDecision(21, decisionCanBacktrack[21]);

				int LA21_0 = input.LA(1);
				if ( (LA21_0==EQ||(LA21_0 >= GREATER && LA21_0 <= GREATEREQ)||(LA21_0 >= LESSER && LA21_0 <= LESSEREQ)||LA21_0==NEQ) ) {
					alt21=1;
				}

				} finally {dbg.exitDecision(21);}

				switch (alt21) {
				case 1 :
					dbg.enterAlt(1);

					// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:244:16: compare_operator ^ term3
					{
					dbg.location(244,32);
					pushFollow(FOLLOW_compare_operator_in_term42094);
					compare_operator118=compare_operator();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(compare_operator118.getTree(), root_0);dbg.location(244,34);
					pushFollow(FOLLOW_term3_in_term42097);
					term3119=term3();
					state._fsp--;

					adaptor.addChild(root_0, term3119.getTree());

					}
					break;

				default :
					break loop21;
				}
			}
			} finally {dbg.exitSubRule(21);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(244, 41);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "term4");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "term4"


	public static class term3_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "term3"
	// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:245:1: term3 : term2 ( add_operator ^ term2 )* ;
	public final TigerParser.term3_return term3() throws RecognitionException {
		TigerParser.term3_return retval = new TigerParser.term3_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope term2120 =null;
		ParserRuleReturnScope add_operator121 =null;
		ParserRuleReturnScope term2122 =null;


		try { dbg.enterRule(getGrammarFileName(), "term3");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(245, 0);

		try {
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:245:7: ( term2 ( add_operator ^ term2 )* )
			dbg.enterAlt(1);

			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:245:9: term2 ( add_operator ^ term2 )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(245,9);
			pushFollow(FOLLOW_term2_in_term32107);
			term2120=term2();
			state._fsp--;

			adaptor.addChild(root_0, term2120.getTree());
			dbg.location(245,15);
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:245:15: ( add_operator ^ term2 )*
			try { dbg.enterSubRule(22);

			loop22:
			while (true) {
				int alt22=2;
				try { dbg.enterDecision(22, decisionCanBacktrack[22]);

				int LA22_0 = input.LA(1);
				if ( (LA22_0==MINUS||LA22_0==PLUS) ) {
					alt22=1;
				}

				} finally {dbg.exitDecision(22);}

				switch (alt22) {
				case 1 :
					dbg.enterAlt(1);

					// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:245:16: add_operator ^ term2
					{
					dbg.location(245,28);
					pushFollow(FOLLOW_add_operator_in_term32110);
					add_operator121=add_operator();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(add_operator121.getTree(), root_0);dbg.location(245,30);
					pushFollow(FOLLOW_term2_in_term32113);
					term2122=term2();
					state._fsp--;

					adaptor.addChild(root_0, term2122.getTree());

					}
					break;

				default :
					break loop22;
				}
			}
			} finally {dbg.exitSubRule(22);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(245, 37);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "term3");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "term3"


	public static class term2_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "term2"
	// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:246:1: term2 : term1 ( mult_operator ^ term1 )* ;
	public final TigerParser.term2_return term2() throws RecognitionException {
		TigerParser.term2_return retval = new TigerParser.term2_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope term1123 =null;
		ParserRuleReturnScope mult_operator124 =null;
		ParserRuleReturnScope term1125 =null;


		try { dbg.enterRule(getGrammarFileName(), "term2");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(246, 0);

		try {
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:246:7: ( term1 ( mult_operator ^ term1 )* )
			dbg.enterAlt(1);

			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:246:9: term1 ( mult_operator ^ term1 )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(246,9);
			pushFollow(FOLLOW_term1_in_term22123);
			term1123=term1();
			state._fsp--;

			adaptor.addChild(root_0, term1123.getTree());
			dbg.location(246,15);
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:246:15: ( mult_operator ^ term1 )*
			try { dbg.enterSubRule(23);

			loop23:
			while (true) {
				int alt23=2;
				try { dbg.enterDecision(23, decisionCanBacktrack[23]);

				int LA23_0 = input.LA(1);
				if ( (LA23_0==DIV||LA23_0==MULT) ) {
					alt23=1;
				}

				} finally {dbg.exitDecision(23);}

				switch (alt23) {
				case 1 :
					dbg.enterAlt(1);

					// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:246:16: mult_operator ^ term1
					{
					dbg.location(246,29);
					pushFollow(FOLLOW_mult_operator_in_term22126);
					mult_operator124=mult_operator();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(mult_operator124.getTree(), root_0);dbg.location(246,31);
					pushFollow(FOLLOW_term1_in_term22129);
					term1125=term1();
					state._fsp--;

					adaptor.addChild(root_0, term1125.getTree());

					}
					break;

				default :
					break loop23;
				}
			}
			} finally {dbg.exitSubRule(23);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(246, 38);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "term2");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "term2"


	public static class term1_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "term1"
	// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:247:1: term1 : ( literal | value | '(' expr ')' -> expr );
	public final TigerParser.term1_return term1() throws RecognitionException {
		TigerParser.term1_return retval = new TigerParser.term1_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal128=null;
		Token char_literal130=null;
		ParserRuleReturnScope literal126 =null;
		ParserRuleReturnScope value127 =null;
		ParserRuleReturnScope expr129 =null;

		Object char_literal128_tree=null;
		Object char_literal130_tree=null;
		RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
		RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try { dbg.enterRule(getGrammarFileName(), "term1");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(247, 0);

		try {
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:248:5: ( literal | value | '(' expr ')' -> expr )
			int alt24=3;
			try { dbg.enterDecision(24, decisionCanBacktrack[24]);

			switch ( input.LA(1) ) {
			case FIXEDPTLIT:
			case INTLIT:
				{
				alt24=1;
				}
				break;
			case ID:
				{
				alt24=2;
				}
				break;
			case LPAREN:
				{
				alt24=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 24, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(24);}

			switch (alt24) {
				case 1 :
					dbg.enterAlt(1);

					// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:248:7: literal
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(248,7);
					pushFollow(FOLLOW_literal_in_term12143);
					literal126=literal();
					state._fsp--;

					adaptor.addChild(root_0, literal126.getTree());

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:249:7: value
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(249,7);
					pushFollow(FOLLOW_value_in_term12151);
					value127=value();
					state._fsp--;

					adaptor.addChild(root_0, value127.getTree());

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:250:7: '(' expr ')'
					{
					dbg.location(250,7);
					char_literal128=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_term12159);  
					stream_LPAREN.add(char_literal128);
					dbg.location(250,11);
					pushFollow(FOLLOW_expr_in_term12161);
					expr129=expr();
					state._fsp--;

					stream_expr.add(expr129.getTree());dbg.location(250,16);
					char_literal130=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_term12163);  
					stream_RPAREN.add(char_literal130);

					// AST REWRITE
					// elements: expr
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 251:9: -> expr
					{
						dbg.location(251,12);
						adaptor.addChild(root_0, stream_expr.nextTree());
					}


					retval.tree = root_0;

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(252, 4);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "term1");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "term1"


	public static class expr_no_start_id_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expr_no_start_id"
	// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:254:1: expr_no_start_id : term4_no_start_id ( and_operator ^ term4 )* ;
	public final TigerParser.expr_no_start_id_return expr_no_start_id() throws RecognitionException {
		TigerParser.expr_no_start_id_return retval = new TigerParser.expr_no_start_id_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope term4_no_start_id131 =null;
		ParserRuleReturnScope and_operator132 =null;
		ParserRuleReturnScope term4133 =null;


		try { dbg.enterRule(getGrammarFileName(), "expr_no_start_id");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(254, 0);

		try {
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:254:18: ( term4_no_start_id ( and_operator ^ term4 )* )
			dbg.enterAlt(1);

			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:254:20: term4_no_start_id ( and_operator ^ term4 )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(254,20);
			pushFollow(FOLLOW_term4_no_start_id_in_expr_no_start_id2188);
			term4_no_start_id131=term4_no_start_id();
			state._fsp--;

			adaptor.addChild(root_0, term4_no_start_id131.getTree());
			dbg.location(254,38);
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:254:38: ( and_operator ^ term4 )*
			try { dbg.enterSubRule(25);

			loop25:
			while (true) {
				int alt25=2;
				try { dbg.enterDecision(25, decisionCanBacktrack[25]);

				int LA25_0 = input.LA(1);
				if ( (LA25_0==AND||LA25_0==OR) ) {
					alt25=1;
				}

				} finally {dbg.exitDecision(25);}

				switch (alt25) {
				case 1 :
					dbg.enterAlt(1);

					// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:254:39: and_operator ^ term4
					{
					dbg.location(254,51);
					pushFollow(FOLLOW_and_operator_in_expr_no_start_id2191);
					and_operator132=and_operator();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(and_operator132.getTree(), root_0);dbg.location(254,53);
					pushFollow(FOLLOW_term4_in_expr_no_start_id2194);
					term4133=term4();
					state._fsp--;

					adaptor.addChild(root_0, term4133.getTree());

					}
					break;

				default :
					break loop25;
				}
			}
			} finally {dbg.exitSubRule(25);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(254, 60);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "expr_no_start_id");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "expr_no_start_id"


	public static class term4_no_start_id_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "term4_no_start_id"
	// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:255:1: term4_no_start_id : term3_no_start_id ( compare_operator ^ term3 )* ;
	public final TigerParser.term4_no_start_id_return term4_no_start_id() throws RecognitionException {
		TigerParser.term4_no_start_id_return retval = new TigerParser.term4_no_start_id_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope term3_no_start_id134 =null;
		ParserRuleReturnScope compare_operator135 =null;
		ParserRuleReturnScope term3136 =null;


		try { dbg.enterRule(getGrammarFileName(), "term4_no_start_id");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(255, 0);

		try {
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:255:19: ( term3_no_start_id ( compare_operator ^ term3 )* )
			dbg.enterAlt(1);

			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:255:21: term3_no_start_id ( compare_operator ^ term3 )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(255,21);
			pushFollow(FOLLOW_term3_no_start_id_in_term4_no_start_id2204);
			term3_no_start_id134=term3_no_start_id();
			state._fsp--;

			adaptor.addChild(root_0, term3_no_start_id134.getTree());
			dbg.location(255,39);
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:255:39: ( compare_operator ^ term3 )*
			try { dbg.enterSubRule(26);

			loop26:
			while (true) {
				int alt26=2;
				try { dbg.enterDecision(26, decisionCanBacktrack[26]);

				int LA26_0 = input.LA(1);
				if ( (LA26_0==EQ||(LA26_0 >= GREATER && LA26_0 <= GREATEREQ)||(LA26_0 >= LESSER && LA26_0 <= LESSEREQ)||LA26_0==NEQ) ) {
					alt26=1;
				}

				} finally {dbg.exitDecision(26);}

				switch (alt26) {
				case 1 :
					dbg.enterAlt(1);

					// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:255:40: compare_operator ^ term3
					{
					dbg.location(255,56);
					pushFollow(FOLLOW_compare_operator_in_term4_no_start_id2207);
					compare_operator135=compare_operator();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(compare_operator135.getTree(), root_0);dbg.location(255,58);
					pushFollow(FOLLOW_term3_in_term4_no_start_id2210);
					term3136=term3();
					state._fsp--;

					adaptor.addChild(root_0, term3136.getTree());

					}
					break;

				default :
					break loop26;
				}
			}
			} finally {dbg.exitSubRule(26);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(255, 65);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "term4_no_start_id");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "term4_no_start_id"


	public static class term3_no_start_id_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "term3_no_start_id"
	// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:256:1: term3_no_start_id : term2_no_start_id ( add_operator ^ term2 )* ;
	public final TigerParser.term3_no_start_id_return term3_no_start_id() throws RecognitionException {
		TigerParser.term3_no_start_id_return retval = new TigerParser.term3_no_start_id_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope term2_no_start_id137 =null;
		ParserRuleReturnScope add_operator138 =null;
		ParserRuleReturnScope term2139 =null;


		try { dbg.enterRule(getGrammarFileName(), "term3_no_start_id");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(256, 0);

		try {
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:256:19: ( term2_no_start_id ( add_operator ^ term2 )* )
			dbg.enterAlt(1);

			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:256:21: term2_no_start_id ( add_operator ^ term2 )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(256,21);
			pushFollow(FOLLOW_term2_no_start_id_in_term3_no_start_id2220);
			term2_no_start_id137=term2_no_start_id();
			state._fsp--;

			adaptor.addChild(root_0, term2_no_start_id137.getTree());
			dbg.location(256,39);
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:256:39: ( add_operator ^ term2 )*
			try { dbg.enterSubRule(27);

			loop27:
			while (true) {
				int alt27=2;
				try { dbg.enterDecision(27, decisionCanBacktrack[27]);

				int LA27_0 = input.LA(1);
				if ( (LA27_0==MINUS||LA27_0==PLUS) ) {
					alt27=1;
				}

				} finally {dbg.exitDecision(27);}

				switch (alt27) {
				case 1 :
					dbg.enterAlt(1);

					// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:256:40: add_operator ^ term2
					{
					dbg.location(256,52);
					pushFollow(FOLLOW_add_operator_in_term3_no_start_id2223);
					add_operator138=add_operator();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(add_operator138.getTree(), root_0);dbg.location(256,54);
					pushFollow(FOLLOW_term2_in_term3_no_start_id2226);
					term2139=term2();
					state._fsp--;

					adaptor.addChild(root_0, term2139.getTree());

					}
					break;

				default :
					break loop27;
				}
			}
			} finally {dbg.exitSubRule(27);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(256, 61);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "term3_no_start_id");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "term3_no_start_id"


	public static class term2_no_start_id_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "term2_no_start_id"
	// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:257:1: term2_no_start_id : term1_no_start_id ( mult_operator ^ term1 )* ;
	public final TigerParser.term2_no_start_id_return term2_no_start_id() throws RecognitionException {
		TigerParser.term2_no_start_id_return retval = new TigerParser.term2_no_start_id_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope term1_no_start_id140 =null;
		ParserRuleReturnScope mult_operator141 =null;
		ParserRuleReturnScope term1142 =null;


		try { dbg.enterRule(getGrammarFileName(), "term2_no_start_id");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(257, 0);

		try {
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:257:19: ( term1_no_start_id ( mult_operator ^ term1 )* )
			dbg.enterAlt(1);

			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:257:21: term1_no_start_id ( mult_operator ^ term1 )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(257,21);
			pushFollow(FOLLOW_term1_no_start_id_in_term2_no_start_id2236);
			term1_no_start_id140=term1_no_start_id();
			state._fsp--;

			adaptor.addChild(root_0, term1_no_start_id140.getTree());
			dbg.location(257,39);
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:257:39: ( mult_operator ^ term1 )*
			try { dbg.enterSubRule(28);

			loop28:
			while (true) {
				int alt28=2;
				try { dbg.enterDecision(28, decisionCanBacktrack[28]);

				int LA28_0 = input.LA(1);
				if ( (LA28_0==DIV||LA28_0==MULT) ) {
					alt28=1;
				}

				} finally {dbg.exitDecision(28);}

				switch (alt28) {
				case 1 :
					dbg.enterAlt(1);

					// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:257:40: mult_operator ^ term1
					{
					dbg.location(257,53);
					pushFollow(FOLLOW_mult_operator_in_term2_no_start_id2239);
					mult_operator141=mult_operator();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(mult_operator141.getTree(), root_0);dbg.location(257,55);
					pushFollow(FOLLOW_term1_in_term2_no_start_id2242);
					term1142=term1();
					state._fsp--;

					adaptor.addChild(root_0, term1142.getTree());

					}
					break;

				default :
					break loop28;
				}
			}
			} finally {dbg.exitSubRule(28);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(257, 62);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "term2_no_start_id");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "term2_no_start_id"


	public static class term1_no_start_id_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "term1_no_start_id"
	// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:258:1: term1_no_start_id : ( literal | '(' expr ')' -> expr );
	public final TigerParser.term1_no_start_id_return term1_no_start_id() throws RecognitionException {
		TigerParser.term1_no_start_id_return retval = new TigerParser.term1_no_start_id_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal144=null;
		Token char_literal146=null;
		ParserRuleReturnScope literal143 =null;
		ParserRuleReturnScope expr145 =null;

		Object char_literal144_tree=null;
		Object char_literal146_tree=null;
		RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
		RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try { dbg.enterRule(getGrammarFileName(), "term1_no_start_id");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(258, 0);

		try {
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:259:5: ( literal | '(' expr ')' -> expr )
			int alt29=2;
			try { dbg.enterDecision(29, decisionCanBacktrack[29]);

			int LA29_0 = input.LA(1);
			if ( (LA29_0==FIXEDPTLIT||LA29_0==INTLIT) ) {
				alt29=1;
			}
			else if ( (LA29_0==LPAREN) ) {
				alt29=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 29, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(29);}

			switch (alt29) {
				case 1 :
					dbg.enterAlt(1);

					// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:259:7: literal
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(259,7);
					pushFollow(FOLLOW_literal_in_term1_no_start_id2256);
					literal143=literal();
					state._fsp--;

					adaptor.addChild(root_0, literal143.getTree());

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:260:7: '(' expr ')'
					{
					dbg.location(260,7);
					char_literal144=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_term1_no_start_id2264);  
					stream_LPAREN.add(char_literal144);
					dbg.location(260,11);
					pushFollow(FOLLOW_expr_in_term1_no_start_id2266);
					expr145=expr();
					state._fsp--;

					stream_expr.add(expr145.getTree());dbg.location(260,16);
					char_literal146=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_term1_no_start_id2268);  
					stream_RPAREN.add(char_literal146);

					// AST REWRITE
					// elements: expr
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 261:9: -> expr
					{
						dbg.location(261,12);
						adaptor.addChild(root_0, stream_expr.nextTree());
					}


					retval.tree = root_0;

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(262, 4);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "term1_no_start_id");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "term1_no_start_id"


	public static class expr_with_start_id_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expr_with_start_id"
	// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:264:1: expr_with_start_id[Token startId] : term4_with_start_id[$startId] ( and_operator ^ term4 )* ;
	public final TigerParser.expr_with_start_id_return expr_with_start_id(Token startId) throws RecognitionException {
		TigerParser.expr_with_start_id_return retval = new TigerParser.expr_with_start_id_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope term4_with_start_id147 =null;
		ParserRuleReturnScope and_operator148 =null;
		ParserRuleReturnScope term4149 =null;


		try { dbg.enterRule(getGrammarFileName(), "expr_with_start_id");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(264, 0);

		try {
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:264:35: ( term4_with_start_id[$startId] ( and_operator ^ term4 )* )
			dbg.enterAlt(1);

			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:264:37: term4_with_start_id[$startId] ( and_operator ^ term4 )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(264,37);
			pushFollow(FOLLOW_term4_with_start_id_in_expr_with_start_id2294);
			term4_with_start_id147=term4_with_start_id(startId);
			state._fsp--;

			adaptor.addChild(root_0, term4_with_start_id147.getTree());
			dbg.location(264,67);
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:264:67: ( and_operator ^ term4 )*
			try { dbg.enterSubRule(30);

			loop30:
			while (true) {
				int alt30=2;
				try { dbg.enterDecision(30, decisionCanBacktrack[30]);

				int LA30_0 = input.LA(1);
				if ( (LA30_0==AND||LA30_0==OR) ) {
					alt30=1;
				}

				} finally {dbg.exitDecision(30);}

				switch (alt30) {
				case 1 :
					dbg.enterAlt(1);

					// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:264:68: and_operator ^ term4
					{
					dbg.location(264,80);
					pushFollow(FOLLOW_and_operator_in_expr_with_start_id2298);
					and_operator148=and_operator();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(and_operator148.getTree(), root_0);dbg.location(264,82);
					pushFollow(FOLLOW_term4_in_expr_with_start_id2301);
					term4149=term4();
					state._fsp--;

					adaptor.addChild(root_0, term4149.getTree());

					}
					break;

				default :
					break loop30;
				}
			}
			} finally {dbg.exitSubRule(30);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(264, 89);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "expr_with_start_id");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "expr_with_start_id"


	public static class term4_with_start_id_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "term4_with_start_id"
	// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:265:1: term4_with_start_id[Token startId] : term3_with_start_id[$startId] ( compare_operator ^ term3 )* ;
	public final TigerParser.term4_with_start_id_return term4_with_start_id(Token startId) throws RecognitionException {
		TigerParser.term4_with_start_id_return retval = new TigerParser.term4_with_start_id_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope term3_with_start_id150 =null;
		ParserRuleReturnScope compare_operator151 =null;
		ParserRuleReturnScope term3152 =null;


		try { dbg.enterRule(getGrammarFileName(), "term4_with_start_id");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(265, 0);

		try {
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:265:36: ( term3_with_start_id[$startId] ( compare_operator ^ term3 )* )
			dbg.enterAlt(1);

			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:265:38: term3_with_start_id[$startId] ( compare_operator ^ term3 )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(265,38);
			pushFollow(FOLLOW_term3_with_start_id_in_term4_with_start_id2312);
			term3_with_start_id150=term3_with_start_id(startId);
			state._fsp--;

			adaptor.addChild(root_0, term3_with_start_id150.getTree());
			dbg.location(265,68);
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:265:68: ( compare_operator ^ term3 )*
			try { dbg.enterSubRule(31);

			loop31:
			while (true) {
				int alt31=2;
				try { dbg.enterDecision(31, decisionCanBacktrack[31]);

				int LA31_0 = input.LA(1);
				if ( (LA31_0==EQ||(LA31_0 >= GREATER && LA31_0 <= GREATEREQ)||(LA31_0 >= LESSER && LA31_0 <= LESSEREQ)||LA31_0==NEQ) ) {
					alt31=1;
				}

				} finally {dbg.exitDecision(31);}

				switch (alt31) {
				case 1 :
					dbg.enterAlt(1);

					// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:265:69: compare_operator ^ term3
					{
					dbg.location(265,85);
					pushFollow(FOLLOW_compare_operator_in_term4_with_start_id2316);
					compare_operator151=compare_operator();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(compare_operator151.getTree(), root_0);dbg.location(265,87);
					pushFollow(FOLLOW_term3_in_term4_with_start_id2319);
					term3152=term3();
					state._fsp--;

					adaptor.addChild(root_0, term3152.getTree());

					}
					break;

				default :
					break loop31;
				}
			}
			} finally {dbg.exitSubRule(31);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(265, 94);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "term4_with_start_id");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "term4_with_start_id"


	public static class term3_with_start_id_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "term3_with_start_id"
	// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:266:1: term3_with_start_id[Token startId] : term2_with_start_id[$startId] ( add_operator ^ term2 )* ;
	public final TigerParser.term3_with_start_id_return term3_with_start_id(Token startId) throws RecognitionException {
		TigerParser.term3_with_start_id_return retval = new TigerParser.term3_with_start_id_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope term2_with_start_id153 =null;
		ParserRuleReturnScope add_operator154 =null;
		ParserRuleReturnScope term2155 =null;


		try { dbg.enterRule(getGrammarFileName(), "term3_with_start_id");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(266, 0);

		try {
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:266:36: ( term2_with_start_id[$startId] ( add_operator ^ term2 )* )
			dbg.enterAlt(1);

			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:266:38: term2_with_start_id[$startId] ( add_operator ^ term2 )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(266,38);
			pushFollow(FOLLOW_term2_with_start_id_in_term3_with_start_id2330);
			term2_with_start_id153=term2_with_start_id(startId);
			state._fsp--;

			adaptor.addChild(root_0, term2_with_start_id153.getTree());
			dbg.location(266,68);
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:266:68: ( add_operator ^ term2 )*
			try { dbg.enterSubRule(32);

			loop32:
			while (true) {
				int alt32=2;
				try { dbg.enterDecision(32, decisionCanBacktrack[32]);

				int LA32_0 = input.LA(1);
				if ( (LA32_0==MINUS||LA32_0==PLUS) ) {
					alt32=1;
				}

				} finally {dbg.exitDecision(32);}

				switch (alt32) {
				case 1 :
					dbg.enterAlt(1);

					// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:266:69: add_operator ^ term2
					{
					dbg.location(266,81);
					pushFollow(FOLLOW_add_operator_in_term3_with_start_id2334);
					add_operator154=add_operator();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(add_operator154.getTree(), root_0);dbg.location(266,83);
					pushFollow(FOLLOW_term2_in_term3_with_start_id2337);
					term2155=term2();
					state._fsp--;

					adaptor.addChild(root_0, term2155.getTree());

					}
					break;

				default :
					break loop32;
				}
			}
			} finally {dbg.exitSubRule(32);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(266, 90);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "term3_with_start_id");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "term3_with_start_id"


	public static class term2_with_start_id_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "term2_with_start_id"
	// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:267:1: term2_with_start_id[Token startId] : term1_with_start_id[$startId] ( mult_operator ^ term1 )* ;
	public final TigerParser.term2_with_start_id_return term2_with_start_id(Token startId) throws RecognitionException {
		TigerParser.term2_with_start_id_return retval = new TigerParser.term2_with_start_id_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope term1_with_start_id156 =null;
		ParserRuleReturnScope mult_operator157 =null;
		ParserRuleReturnScope term1158 =null;


		try { dbg.enterRule(getGrammarFileName(), "term2_with_start_id");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(267, 0);

		try {
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:267:36: ( term1_with_start_id[$startId] ( mult_operator ^ term1 )* )
			dbg.enterAlt(1);

			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:267:38: term1_with_start_id[$startId] ( mult_operator ^ term1 )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(267,38);
			pushFollow(FOLLOW_term1_with_start_id_in_term2_with_start_id2348);
			term1_with_start_id156=term1_with_start_id(startId);
			state._fsp--;

			adaptor.addChild(root_0, term1_with_start_id156.getTree());
			dbg.location(267,68);
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:267:68: ( mult_operator ^ term1 )*
			try { dbg.enterSubRule(33);

			loop33:
			while (true) {
				int alt33=2;
				try { dbg.enterDecision(33, decisionCanBacktrack[33]);

				int LA33_0 = input.LA(1);
				if ( (LA33_0==DIV||LA33_0==MULT) ) {
					alt33=1;
				}

				} finally {dbg.exitDecision(33);}

				switch (alt33) {
				case 1 :
					dbg.enterAlt(1);

					// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:267:69: mult_operator ^ term1
					{
					dbg.location(267,82);
					pushFollow(FOLLOW_mult_operator_in_term2_with_start_id2352);
					mult_operator157=mult_operator();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(mult_operator157.getTree(), root_0);dbg.location(267,84);
					pushFollow(FOLLOW_term1_in_term2_with_start_id2355);
					term1158=term1();
					state._fsp--;

					adaptor.addChild(root_0, term1158.getTree());

					}
					break;

				default :
					break loop33;
				}
			}
			} finally {dbg.exitSubRule(33);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(267, 91);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "term2_with_start_id");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "term2_with_start_id"


	public static class term1_with_start_id_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "term1_with_start_id"
	// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:268:1: term1_with_start_id[Token startId] : value_tail -> ^( ( value_tail )? ) ;
	public final TigerParser.term1_with_start_id_return term1_with_start_id(Token startId) throws RecognitionException {
		TigerParser.term1_with_start_id_return retval = new TigerParser.term1_with_start_id_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope value_tail159 =null;

		RewriteRuleSubtreeStream stream_value_tail=new RewriteRuleSubtreeStream(adaptor,"rule value_tail");

		try { dbg.enterRule(getGrammarFileName(), "term1_with_start_id");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(268, 0);

		try {
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:269:5: ( value_tail -> ^( ( value_tail )? ) )
			dbg.enterAlt(1);

			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:269:7: value_tail
			{
			dbg.location(269,7);
			pushFollow(FOLLOW_value_tail_in_term1_with_start_id2370);
			value_tail159=value_tail();
			state._fsp--;

			stream_value_tail.add(value_tail159.getTree());
			// AST REWRITE
			// elements: value_tail
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 269:18: -> ^( ( value_tail )? )
			{
				dbg.location(269,21);
				// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:269:21: ^( ( value_tail )? )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(269,23);
				root_1 = (Object)adaptor.becomeRoot(new CommonTree(startId), root_1);
				dbg.location(269,50);
				// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:269:50: ( value_tail )?
				if ( stream_value_tail.hasNext() ) {
					dbg.location(269,50);
					adaptor.addChild(root_1, stream_value_tail.nextTree());
				}
				stream_value_tail.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(270, 4);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "term1_with_start_id");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "term1_with_start_id"


	public static class expr_list_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expr_list"
	// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:272:1: expr_list : ( expr ( ',' expr )* -> ^( EXPRLIST ( expr )+ ) |);
	public final TigerParser.expr_list_return expr_list() throws RecognitionException {
		TigerParser.expr_list_return retval = new TigerParser.expr_list_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal161=null;
		ParserRuleReturnScope expr160 =null;
		ParserRuleReturnScope expr162 =null;

		Object char_literal161_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try { dbg.enterRule(getGrammarFileName(), "expr_list");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(272, 0);

		try {
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:273:5: ( expr ( ',' expr )* -> ^( EXPRLIST ( expr )+ ) |)
			int alt35=2;
			try { dbg.enterDecision(35, decisionCanBacktrack[35]);

			int LA35_0 = input.LA(1);
			if ( (LA35_0==FIXEDPTLIT||LA35_0==ID||LA35_0==INTLIT||LA35_0==LPAREN) ) {
				alt35=1;
			}
			else if ( (LA35_0==RPAREN) ) {
				alt35=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 35, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(35);}

			switch (alt35) {
				case 1 :
					dbg.enterAlt(1);

					// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:273:7: expr ( ',' expr )*
					{
					dbg.location(273,7);
					pushFollow(FOLLOW_expr_in_expr_list2396);
					expr160=expr();
					state._fsp--;

					stream_expr.add(expr160.getTree());dbg.location(273,12);
					// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:273:12: ( ',' expr )*
					try { dbg.enterSubRule(34);

					loop34:
					while (true) {
						int alt34=2;
						try { dbg.enterDecision(34, decisionCanBacktrack[34]);

						int LA34_0 = input.LA(1);
						if ( (LA34_0==COMMA) ) {
							alt34=1;
						}

						} finally {dbg.exitDecision(34);}

						switch (alt34) {
						case 1 :
							dbg.enterAlt(1);

							// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:273:14: ',' expr
							{
							dbg.location(273,14);
							char_literal161=(Token)match(input,COMMA,FOLLOW_COMMA_in_expr_list2400);  
							stream_COMMA.add(char_literal161);
							dbg.location(273,18);
							pushFollow(FOLLOW_expr_in_expr_list2402);
							expr162=expr();
							state._fsp--;

							stream_expr.add(expr162.getTree());
							}
							break;

						default :
							break loop34;
						}
					}
					} finally {dbg.exitSubRule(34);}

					// AST REWRITE
					// elements: expr
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 273:26: -> ^( EXPRLIST ( expr )+ )
					{
						dbg.location(273,29);
						// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:273:29: ^( EXPRLIST ( expr )+ )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(273,31);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EXPRLIST, "EXPRLIST"), root_1);
						dbg.location(273,40);
						if ( !(stream_expr.hasNext()) ) {
							throw new RewriteEarlyExitException();
						}
						while ( stream_expr.hasNext() ) {
							dbg.location(273,40);
							adaptor.addChild(root_1, stream_expr.nextTree());
						}
						stream_expr.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:275:5: 
					{
					root_0 = (Object)adaptor.nil();


					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(275, 4);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "expr_list");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "expr_list"


	public static class mult_operator_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "mult_operator"
	// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:283:1: mult_operator : ( '*' | '/' );
	public final TigerParser.mult_operator_return mult_operator() throws RecognitionException {
		TigerParser.mult_operator_return retval = new TigerParser.mult_operator_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set163=null;

		Object set163_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "mult_operator");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(283, 0);

		try {
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:283:15: ( '*' | '/' )
			dbg.enterAlt(1);

			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(283,15);
			set163=input.LT(1);
			if ( input.LA(1)==DIV||input.LA(1)==MULT ) {
				input.consume();
				adaptor.addChild(root_0, (Object)adaptor.create(set163));
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				dbg.recognitionException(mse);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(283, 26);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "mult_operator");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "mult_operator"


	public static class add_operator_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "add_operator"
	// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:285:1: add_operator : ( '+' | '-' );
	public final TigerParser.add_operator_return add_operator() throws RecognitionException {
		TigerParser.add_operator_return retval = new TigerParser.add_operator_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set164=null;

		Object set164_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "add_operator");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(285, 0);

		try {
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:285:14: ( '+' | '-' )
			dbg.enterAlt(1);

			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(285,14);
			set164=input.LT(1);
			if ( input.LA(1)==MINUS||input.LA(1)==PLUS ) {
				input.consume();
				adaptor.addChild(root_0, (Object)adaptor.create(set164));
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				dbg.recognitionException(mse);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(285, 25);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "add_operator");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "add_operator"


	public static class compare_operator_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "compare_operator"
	// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:287:1: compare_operator : ( '=' | '<>' | '<' | '>' | '<=' | '>=' );
	public final TigerParser.compare_operator_return compare_operator() throws RecognitionException {
		TigerParser.compare_operator_return retval = new TigerParser.compare_operator_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set165=null;

		Object set165_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "compare_operator");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(287, 0);

		try {
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:287:18: ( '=' | '<>' | '<' | '>' | '<=' | '>=' )
			dbg.enterAlt(1);

			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(287,18);
			set165=input.LT(1);
			if ( input.LA(1)==EQ||(input.LA(1) >= GREATER && input.LA(1) <= GREATEREQ)||(input.LA(1) >= LESSER && input.LA(1) <= LESSEREQ)||input.LA(1)==NEQ ) {
				input.consume();
				adaptor.addChild(root_0, (Object)adaptor.create(set165));
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				dbg.recognitionException(mse);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(287, 56);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "compare_operator");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "compare_operator"


	public static class and_operator_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "and_operator"
	// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:289:1: and_operator : ( '&' | '|' );
	public final TigerParser.and_operator_return and_operator() throws RecognitionException {
		TigerParser.and_operator_return retval = new TigerParser.and_operator_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set166=null;

		Object set166_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "and_operator");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(289, 0);

		try {
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:289:14: ( '&' | '|' )
			dbg.enterAlt(1);

			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(289,14);
			set166=input.LT(1);
			if ( input.LA(1)==AND||input.LA(1)==OR ) {
				input.consume();
				adaptor.addChild(root_0, (Object)adaptor.create(set166));
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				dbg.recognitionException(mse);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(289, 25);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "and_operator");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "and_operator"


	public static class value_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "value"
	// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:291:1: value : ID value_tail -> ^( ID ( value_tail )? ) ;
	public final TigerParser.value_return value() throws RecognitionException {
		TigerParser.value_return retval = new TigerParser.value_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ID167=null;
		ParserRuleReturnScope value_tail168 =null;

		Object ID167_tree=null;
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleSubtreeStream stream_value_tail=new RewriteRuleSubtreeStream(adaptor,"rule value_tail");

		try { dbg.enterRule(getGrammarFileName(), "value");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(291, 0);

		try {
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:291:7: ( ID value_tail -> ^( ID ( value_tail )? ) )
			dbg.enterAlt(1);

			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:291:9: ID value_tail
			{
			dbg.location(291,9);
			ID167=(Token)match(input,ID,FOLLOW_ID_in_value2504);  
			stream_ID.add(ID167);
			dbg.location(291,12);
			pushFollow(FOLLOW_value_tail_in_value2506);
			value_tail168=value_tail();
			state._fsp--;

			stream_value_tail.add(value_tail168.getTree());
			// AST REWRITE
			// elements: ID, value_tail
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 291:23: -> ^( ID ( value_tail )? )
			{
				dbg.location(291,26);
				// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:291:26: ^( ID ( value_tail )? )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(291,28);
				root_1 = (Object)adaptor.becomeRoot(stream_ID.nextNode(), root_1);
				dbg.location(291,31);
				// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:291:31: ( value_tail )?
				if ( stream_value_tail.hasNext() ) {
					dbg.location(291,31);
					adaptor.addChild(root_1, stream_value_tail.nextTree());
				}
				stream_value_tail.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(291, 42);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "value");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "value"


	public static class literal_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "literal"
	// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:293:1: literal : ( INTLIT | FIXEDPTLIT );
	public final TigerParser.literal_return literal() throws RecognitionException {
		TigerParser.literal_return retval = new TigerParser.literal_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set169=null;

		Object set169_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "literal");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(293, 0);

		try {
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:294:5: ( INTLIT | FIXEDPTLIT )
			dbg.enterAlt(1);

			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(294,5);
			set169=input.LT(1);
			if ( input.LA(1)==FIXEDPTLIT||input.LA(1)==INTLIT ) {
				input.consume();
				adaptor.addChild(root_0, (Object)adaptor.create(set169));
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				dbg.recognitionException(mse);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(296, 4);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "literal");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "literal"


	public static class value_tail_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "value_tail"
	// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:298:1: value_tail : ( '[' index_expr ']' ( '[' index_expr ']' )? -> ( index_expr )+ |);
	public final TigerParser.value_tail_return value_tail() throws RecognitionException {
		TigerParser.value_tail_return retval = new TigerParser.value_tail_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal170=null;
		Token char_literal172=null;
		Token char_literal173=null;
		Token char_literal175=null;
		ParserRuleReturnScope index_expr171 =null;
		ParserRuleReturnScope index_expr174 =null;

		Object char_literal170_tree=null;
		Object char_literal172_tree=null;
		Object char_literal173_tree=null;
		Object char_literal175_tree=null;
		RewriteRuleTokenStream stream_RBRACK=new RewriteRuleTokenStream(adaptor,"token RBRACK");
		RewriteRuleTokenStream stream_LBRACK=new RewriteRuleTokenStream(adaptor,"token LBRACK");
		RewriteRuleSubtreeStream stream_index_expr=new RewriteRuleSubtreeStream(adaptor,"rule index_expr");

		try { dbg.enterRule(getGrammarFileName(), "value_tail");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(298, 0);

		try {
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:299:5: ( '[' index_expr ']' ( '[' index_expr ']' )? -> ( index_expr )+ |)
			int alt37=2;
			try { dbg.enterDecision(37, decisionCanBacktrack[37]);

			int LA37_0 = input.LA(1);
			if ( (LA37_0==LBRACK) ) {
				alt37=1;
			}
			else if ( (LA37_0==AND||LA37_0==ASSIGN||LA37_0==COMMA||(LA37_0 >= DIV && LA37_0 <= DO)||LA37_0==EQ||(LA37_0 >= GREATER && LA37_0 <= GREATEREQ)||(LA37_0 >= LESSER && LA37_0 <= LESSEREQ)||(LA37_0 >= MINUS && LA37_0 <= NEQ)||LA37_0==OR||LA37_0==PLUS||(LA37_0 >= RPAREN && LA37_0 <= THEN)) ) {
				alt37=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 37, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(37);}

			switch (alt37) {
				case 1 :
					dbg.enterAlt(1);

					// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:299:7: '[' index_expr ']' ( '[' index_expr ']' )?
					{
					dbg.location(299,7);
					char_literal170=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_value_tail2553);  
					stream_LBRACK.add(char_literal170);
					dbg.location(299,11);
					pushFollow(FOLLOW_index_expr_in_value_tail2555);
					index_expr171=index_expr();
					state._fsp--;

					stream_index_expr.add(index_expr171.getTree());dbg.location(299,22);
					char_literal172=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_value_tail2557);  
					stream_RBRACK.add(char_literal172);
					dbg.location(299,26);
					// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:299:26: ( '[' index_expr ']' )?
					int alt36=2;
					try { dbg.enterSubRule(36);
					try { dbg.enterDecision(36, decisionCanBacktrack[36]);

					int LA36_0 = input.LA(1);
					if ( (LA36_0==LBRACK) ) {
						alt36=1;
					}
					} finally {dbg.exitDecision(36);}

					switch (alt36) {
						case 1 :
							dbg.enterAlt(1);

							// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:299:27: '[' index_expr ']'
							{
							dbg.location(299,27);
							char_literal173=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_value_tail2560);  
							stream_LBRACK.add(char_literal173);
							dbg.location(299,31);
							pushFollow(FOLLOW_index_expr_in_value_tail2562);
							index_expr174=index_expr();
							state._fsp--;

							stream_index_expr.add(index_expr174.getTree());dbg.location(299,42);
							char_literal175=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_value_tail2564);  
							stream_RBRACK.add(char_literal175);

							}
							break;

					}
					} finally {dbg.exitSubRule(36);}

					// AST REWRITE
					// elements: index_expr
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 300:13: -> ( index_expr )+
					{
						dbg.location(300,16);
						if ( !(stream_index_expr.hasNext()) ) {
							throw new RewriteEarlyExitException();
						}
						while ( stream_index_expr.hasNext() ) {
							dbg.location(300,16);
							adaptor.addChild(root_0, stream_index_expr.nextTree());
						}
						stream_index_expr.reset();

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:302:5: 
					{
					root_0 = (Object)adaptor.nil();


					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(302, 4);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "value_tail");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "value_tail"


	public static class index_expr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "index_expr"
	// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:304:1: index_expr : index_term ( add_operator ^ index_term )* ;
	public final TigerParser.index_expr_return index_expr() throws RecognitionException {
		TigerParser.index_expr_return retval = new TigerParser.index_expr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope index_term176 =null;
		ParserRuleReturnScope add_operator177 =null;
		ParserRuleReturnScope index_term178 =null;


		try { dbg.enterRule(getGrammarFileName(), "index_expr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(304, 0);

		try {
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:304:12: ( index_term ( add_operator ^ index_term )* )
			dbg.enterAlt(1);

			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:304:14: index_term ( add_operator ^ index_term )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(304,14);
			pushFollow(FOLLOW_index_term_in_index_expr2605);
			index_term176=index_term();
			state._fsp--;

			adaptor.addChild(root_0, index_term176.getTree());
			dbg.location(304,25);
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:304:25: ( add_operator ^ index_term )*
			try { dbg.enterSubRule(38);

			loop38:
			while (true) {
				int alt38=2;
				try { dbg.enterDecision(38, decisionCanBacktrack[38]);

				int LA38_0 = input.LA(1);
				if ( (LA38_0==MINUS||LA38_0==PLUS) ) {
					alt38=1;
				}

				} finally {dbg.exitDecision(38);}

				switch (alt38) {
				case 1 :
					dbg.enterAlt(1);

					// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:304:26: add_operator ^ index_term
					{
					dbg.location(304,38);
					pushFollow(FOLLOW_add_operator_in_index_expr2608);
					add_operator177=add_operator();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(add_operator177.getTree(), root_0);dbg.location(304,40);
					pushFollow(FOLLOW_index_term_in_index_expr2611);
					index_term178=index_term();
					state._fsp--;

					adaptor.addChild(root_0, index_term178.getTree());

					}
					break;

				default :
					break loop38;
				}
			}
			} finally {dbg.exitSubRule(38);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(304, 52);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "index_expr");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "index_expr"


	public static class index_term_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "index_term"
	// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:306:1: index_term : index_factor ( '*' ^ index_factor )* ;
	public final TigerParser.index_term_return index_term() throws RecognitionException {
		TigerParser.index_term_return retval = new TigerParser.index_term_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal180=null;
		ParserRuleReturnScope index_factor179 =null;
		ParserRuleReturnScope index_factor181 =null;

		Object char_literal180_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "index_term");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(306, 0);

		try {
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:306:12: ( index_factor ( '*' ^ index_factor )* )
			dbg.enterAlt(1);

			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:306:14: index_factor ( '*' ^ index_factor )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(306,14);
			pushFollow(FOLLOW_index_factor_in_index_term2622);
			index_factor179=index_factor();
			state._fsp--;

			adaptor.addChild(root_0, index_factor179.getTree());
			dbg.location(306,27);
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:306:27: ( '*' ^ index_factor )*
			try { dbg.enterSubRule(39);

			loop39:
			while (true) {
				int alt39=2;
				try { dbg.enterDecision(39, decisionCanBacktrack[39]);

				int LA39_0 = input.LA(1);
				if ( (LA39_0==MULT) ) {
					alt39=1;
				}

				} finally {dbg.exitDecision(39);}

				switch (alt39) {
				case 1 :
					dbg.enterAlt(1);

					// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:306:28: '*' ^ index_factor
					{
					dbg.location(306,31);
					char_literal180=(Token)match(input,MULT,FOLLOW_MULT_in_index_term2625); 
					char_literal180_tree = (Object)adaptor.create(char_literal180);
					root_0 = (Object)adaptor.becomeRoot(char_literal180_tree, root_0);
					dbg.location(306,33);
					pushFollow(FOLLOW_index_factor_in_index_term2628);
					index_factor181=index_factor();
					state._fsp--;

					adaptor.addChild(root_0, index_factor181.getTree());

					}
					break;

				default :
					break loop39;
				}
			}
			} finally {dbg.exitSubRule(39);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(306, 47);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "index_term");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "index_term"


	public static class index_factor_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "index_factor"
	// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:308:1: index_factor : ( INTLIT | ID );
	public final TigerParser.index_factor_return index_factor() throws RecognitionException {
		TigerParser.index_factor_return retval = new TigerParser.index_factor_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set182=null;

		Object set182_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "index_factor");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(308, 0);

		try {
			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:308:14: ( INTLIT | ID )
			dbg.enterAlt(1);

			// /home/q/Desktop/CS4240/ANTLR/Git/Phase2/Given/Tiger.g:
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(308,14);
			set182=input.LT(1);
			if ( input.LA(1)==ID||input.LA(1)==INTLIT ) {
				input.consume();
				adaptor.addChild(root_0, (Object)adaptor.create(set182));
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				dbg.recognitionException(mse);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(308, 27);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "index_factor");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "index_factor"

	// Delegated rules



	public static final BitSet FOLLOW_type_declaration_list_in_tiger_program1015 = new BitSet(new long[]{0x0000004202000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_funct_declaration_list_then_main_in_tiger_program1017 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_tiger_program1019 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VOID_in_funct_declaration_list_then_main1043 = new BitSet(new long[]{0x0001000020000000L});
	public static final BitSet FOLLOW_funct_declaration_tail_in_funct_declaration_list_then_main1047 = new BitSet(new long[]{0x0000004202000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_funct_declaration_list_then_main_in_funct_declaration_list_then_main1050 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_main_function_tail_in_funct_declaration_list_then_main1054 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_funct_declaration_list_then_main1066 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_INT_in_funct_declaration_list_then_main1070 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_FIXEDPT_in_funct_declaration_list_then_main1074 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_funct_declaration_tail_in_funct_declaration_list_then_main1077 = new BitSet(new long[]{0x0000004202000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_funct_declaration_list_then_main_in_funct_declaration_list_then_main1080 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FUNCTION_in_funct_declaration_tail1098 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_ID_in_funct_declaration_tail1100 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_LPAREN_in_funct_declaration_tail1102 = new BitSet(new long[]{0x1000000200000000L});
	public static final BitSet FOLLOW_param_list_in_funct_declaration_tail1104 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_funct_declaration_tail1106 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_BEGIN_in_funct_declaration_tail1108 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_block_list_in_funct_declaration_tail1110 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_END_in_funct_declaration_tail1112 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_SEMI_in_funct_declaration_tail1114 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MAIN_in_main_function_tail1141 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_LPAREN_in_main_function_tail1143 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_main_function_tail1145 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_BEGIN_in_main_function_tail1147 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_block_list_in_main_function_tail1149 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_END_in_main_function_tail1151 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_SEMI_in_main_function_tail1153 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_param_in_param_list1174 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_COMMA_in_param_list1178 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_param_in_param_list1180 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_ID_in_param1207 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_COLON_in_param1209 = new BitSet(new long[]{0x0000004202000000L});
	public static final BitSet FOLLOW_type_id_in_param1211 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_block_list1219 = new BitSet(new long[]{0x0000000000000082L});
	public static final BitSet FOLLOW_BEGIN_in_block1237 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000022L});
	public static final BitSet FOLLOW_declaration_segment_in_block1239 = new BitSet(new long[]{0x0800000A08000480L,0x0000000000000200L});
	public static final BitSet FOLLOW_stat_seq_in_block1241 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_END_in_block1243 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_SEMI_in_block1245 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_declaration_list_in_declaration_segment1263 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_var_declaration_list_in_declaration_segment1265 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_declaration_in_type_declaration_list1278 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
	public static final BitSet FOLLOW_var_declaration_in_var_declaration_list1309 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000020L});
	public static final BitSet FOLLOW_TYPE_in_type_declaration1332 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_ID_in_type_declaration1334 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_EQ_in_type_declaration1336 = new BitSet(new long[]{0x0000004002000020L});
	public static final BitSet FOLLOW_type_in_type_declaration1338 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_SEMI_in_type_declaration1340 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_base_type_in_type1362 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARRAY_in_type1370 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_LBRACK_in_type1372 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_INTLIT_in_type1374 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_RBRACK_in_type1376 = new BitSet(new long[]{0x0020080000000000L});
	public static final BitSet FOLLOW_LBRACK_in_type1379 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_INTLIT_in_type1381 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_RBRACK_in_type1383 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_OF_in_type1387 = new BitSet(new long[]{0x0000004002000000L});
	public static final BitSet FOLLOW_base_type_in_type1389 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_base_type_in_type_id1417 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_type_id1425 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_var_declaration1463 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_id_list_in_var_declaration1465 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_COLON_in_var_declaration1467 = new BitSet(new long[]{0x0000004202000000L});
	public static final BitSet FOLLOW_type_id_in_var_declaration1469 = new BitSet(new long[]{0x2000000000000040L});
	public static final BitSet FOLLOW_optional_init_in_var_declaration1471 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_SEMI_in_var_declaration1473 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_id_list1498 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_COMMA_in_id_list1502 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_ID_in_id_list1504 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_ASSIGN_in_optional_init1533 = new BitSet(new long[]{0x0000008004000000L});
	public static final BitSet FOLLOW_literal_in_optional_init1535 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_stat_in_stat_seq1558 = new BitSet(new long[]{0x0800000A08000482L,0x0000000000000200L});
	public static final BitSet FOLLOW_function_call_or_assignment_in_stat1576 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_stat1584 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_expr_in_stat1586 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_THEN_in_stat1588 = new BitSet(new long[]{0x0800000A08000480L,0x0000000000000200L});
	public static final BitSet FOLLOW_stat_seq_in_stat1592 = new BitSet(new long[]{0x0000000000220000L});
	public static final BitSet FOLLOW_ELSE_in_stat1605 = new BitSet(new long[]{0x0800000A08000480L,0x0000000000000200L});
	public static final BitSet FOLLOW_stat_seq_in_stat1609 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_ENDIF_in_stat1611 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_ENDIF_in_stat1657 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat1696 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WHILE_in_stat1704 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_expr_in_stat1706 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_DO_in_stat1708 = new BitSet(new long[]{0x0800000A08000480L,0x0000000000000200L});
	public static final BitSet FOLLOW_stat_seq_in_stat1710 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ENDDO_in_stat1712 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat1714 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FOR_in_stat1740 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_ID_in_stat1742 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASSIGN_in_stat1744 = new BitSet(new long[]{0x0000008200000000L});
	public static final BitSet FOLLOW_index_expr_in_stat1746 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_TO_in_stat1748 = new BitSet(new long[]{0x0000008200000000L});
	public static final BitSet FOLLOW_index_expr_in_stat1750 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_DO_in_stat1752 = new BitSet(new long[]{0x0800000A08000480L,0x0000000000000200L});
	public static final BitSet FOLLOW_stat_seq_in_stat1754 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ENDDO_in_stat1756 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat1758 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BREAK_in_stat1788 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat1790 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RETURN_in_stat1799 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_expr_in_stat1801 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat1803 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_stat1827 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_function_args1844 = new BitSet(new long[]{0x1000808204000000L});
	public static final BitSet FOLLOW_expr_list_in_function_args1846 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_function_args1848 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_function_call_or_assignment1878 = new BitSet(new long[]{0x0000880000000040L});
	public static final BitSet FOLLOW_function_args_in_function_call_or_assignment1890 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_value_tail_in_function_call_or_assignment1925 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASSIGN_in_function_call_or_assignment1927 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_expr_or_function_call_in_function_call_or_assignment1929 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_SEMI_in_function_call_or_assignment1968 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_expr_or_function_call1985 = new BitSet(new long[]{0x0000880000000000L});
	public static final BitSet FOLLOW_expr_with_start_id_in_expr_or_function_call1997 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_args_in_expr_or_function_call2019 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_no_start_id_in_expr_or_function_call2060 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term4_in_expr2075 = new BitSet(new long[]{0x0040000000000012L});
	public static final BitSet FOLLOW_and_operator_in_expr2078 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_term4_in_expr2081 = new BitSet(new long[]{0x0040000000000012L});
	public static final BitSet FOLLOW_term3_in_term42091 = new BitSet(new long[]{0x0010300180400002L});
	public static final BitSet FOLLOW_compare_operator_in_term42094 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_term3_in_term42097 = new BitSet(new long[]{0x0010300180400002L});
	public static final BitSet FOLLOW_term2_in_term32107 = new BitSet(new long[]{0x0104000000000002L});
	public static final BitSet FOLLOW_add_operator_in_term32110 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_term2_in_term32113 = new BitSet(new long[]{0x0104000000000002L});
	public static final BitSet FOLLOW_term1_in_term22123 = new BitSet(new long[]{0x0008000000008002L});
	public static final BitSet FOLLOW_mult_operator_in_term22126 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_term1_in_term22129 = new BitSet(new long[]{0x0008000000008002L});
	public static final BitSet FOLLOW_literal_in_term12143 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_in_term12151 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_term12159 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_expr_in_term12161 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_term12163 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term4_no_start_id_in_expr_no_start_id2188 = new BitSet(new long[]{0x0040000000000012L});
	public static final BitSet FOLLOW_and_operator_in_expr_no_start_id2191 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_term4_in_expr_no_start_id2194 = new BitSet(new long[]{0x0040000000000012L});
	public static final BitSet FOLLOW_term3_no_start_id_in_term4_no_start_id2204 = new BitSet(new long[]{0x0010300180400002L});
	public static final BitSet FOLLOW_compare_operator_in_term4_no_start_id2207 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_term3_in_term4_no_start_id2210 = new BitSet(new long[]{0x0010300180400002L});
	public static final BitSet FOLLOW_term2_no_start_id_in_term3_no_start_id2220 = new BitSet(new long[]{0x0104000000000002L});
	public static final BitSet FOLLOW_add_operator_in_term3_no_start_id2223 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_term2_in_term3_no_start_id2226 = new BitSet(new long[]{0x0104000000000002L});
	public static final BitSet FOLLOW_term1_no_start_id_in_term2_no_start_id2236 = new BitSet(new long[]{0x0008000000008002L});
	public static final BitSet FOLLOW_mult_operator_in_term2_no_start_id2239 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_term1_in_term2_no_start_id2242 = new BitSet(new long[]{0x0008000000008002L});
	public static final BitSet FOLLOW_literal_in_term1_no_start_id2256 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_term1_no_start_id2264 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_expr_in_term1_no_start_id2266 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_term1_no_start_id2268 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term4_with_start_id_in_expr_with_start_id2294 = new BitSet(new long[]{0x0040000000000012L});
	public static final BitSet FOLLOW_and_operator_in_expr_with_start_id2298 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_term4_in_expr_with_start_id2301 = new BitSet(new long[]{0x0040000000000012L});
	public static final BitSet FOLLOW_term3_with_start_id_in_term4_with_start_id2312 = new BitSet(new long[]{0x0010300180400002L});
	public static final BitSet FOLLOW_compare_operator_in_term4_with_start_id2316 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_term3_in_term4_with_start_id2319 = new BitSet(new long[]{0x0010300180400002L});
	public static final BitSet FOLLOW_term2_with_start_id_in_term3_with_start_id2330 = new BitSet(new long[]{0x0104000000000002L});
	public static final BitSet FOLLOW_add_operator_in_term3_with_start_id2334 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_term2_in_term3_with_start_id2337 = new BitSet(new long[]{0x0104000000000002L});
	public static final BitSet FOLLOW_term1_with_start_id_in_term2_with_start_id2348 = new BitSet(new long[]{0x0008000000008002L});
	public static final BitSet FOLLOW_mult_operator_in_term2_with_start_id2352 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_term1_in_term2_with_start_id2355 = new BitSet(new long[]{0x0008000000008002L});
	public static final BitSet FOLLOW_value_tail_in_term1_with_start_id2370 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_expr_list2396 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_COMMA_in_expr_list2400 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_expr_in_expr_list2402 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_ID_in_value2504 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_value_tail_in_value2506 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LBRACK_in_value_tail2553 = new BitSet(new long[]{0x0000008200000000L});
	public static final BitSet FOLLOW_index_expr_in_value_tail2555 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_RBRACK_in_value_tail2557 = new BitSet(new long[]{0x0000080000000002L});
	public static final BitSet FOLLOW_LBRACK_in_value_tail2560 = new BitSet(new long[]{0x0000008200000000L});
	public static final BitSet FOLLOW_index_expr_in_value_tail2562 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_RBRACK_in_value_tail2564 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_index_term_in_index_expr2605 = new BitSet(new long[]{0x0104000000000002L});
	public static final BitSet FOLLOW_add_operator_in_index_expr2608 = new BitSet(new long[]{0x0000008200000000L});
	public static final BitSet FOLLOW_index_term_in_index_expr2611 = new BitSet(new long[]{0x0104000000000002L});
	public static final BitSet FOLLOW_index_factor_in_index_term2622 = new BitSet(new long[]{0x0008000000000002L});
	public static final BitSet FOLLOW_MULT_in_index_term2625 = new BitSet(new long[]{0x0000008200000000L});
	public static final BitSet FOLLOW_index_factor_in_index_term2628 = new BitSet(new long[]{0x0008000000000002L});
}
