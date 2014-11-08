// $ANTLR 3.5.2 Tiger.g 2014-11-08 11:37:39

// Not sure if we need this
	import java.util.Map;
	import java.util.TreeMap;
	import java.util.ArrayList;
	import java.util.Stack;
	import java.util.LinkedList;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class TigerParser extends Parser {
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


	public TigerParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public TigerParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return TigerParser.tokenNames; }
	@Override public String getGrammarFileName() { return "Tiger.g"; }



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

		private static void out(Object obj) {
			System.out.print(obj);
		}

		private static void outln(Object obj) {
			System.out.println(obj);
		}


	/////////////////////////////////////////////////////////////////

		// Use LinkedList that works like stack to implement scope
		// Used LinkedList to make search easier
		public LinkedList<SymbolTable> stack = new LinkedList();

		// Use ArrayList to store all the Symbol table we have used
		public ArrayList<SymbolTable> tableList = new ArrayList();

		// Refers level of scope
		// 0: global, 1: function 2: inside of another block etc.
		public int level;

		// When entering new scope, add the SymbolTable into the Stack and List
		public void enterNewScope(SymbolTable table) {
			stack.addFirst(table);
			tableList.add(table);
			level++;
		}

		// When exiting a scpoe, remove the symbol table from the stack
		public SymbolTable exitScope() {
			SymbolTable temp = stack.removeLast();
			if(level > 0) level--;
			return temp;
		}

		// It will get the top SymbolTable of the stack
		// which means get the SymbolTable of current scope
		public SymbolTable getTopTable() {
			return stack.getLast();
		}

		// TODO : Make a method that saves all the SymbolTables into a file
		//		-> should include It's level too

		public void printSymbol() {
			for(int i = 0; i < stack.size(); i++) {
				System.out.println("Symbol table : " + stack.get(i));
				//stack.get(i).keySet();
			}
		}



	public static class tiger_program_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "tiger_program"
	// Tiger.g:200:1: tiger_program : type_declaration_list funct_declaration_list_then_main EOF -> ^( PROGRAM type_declaration_list funct_declaration_list_then_main ) ;
	public final TigerParser.tiger_program_return tiger_program() throws RecognitionException {
		TigerParser.tiger_program_return retval = new TigerParser.tiger_program_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token EOF3=null;
		ParserRuleReturnScope type_declaration_list1 =null;
		ParserRuleReturnScope funct_declaration_list_then_main2 =null;

		Object EOF3_tree=null;
		RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
		RewriteRuleSubtreeStream stream_funct_declaration_list_then_main=new RewriteRuleSubtreeStream(adaptor,"rule funct_declaration_list_then_main");
		RewriteRuleSubtreeStream stream_type_declaration_list=new RewriteRuleSubtreeStream(adaptor,"rule type_declaration_list");

		try {
			// Tiger.g:200:15: ( type_declaration_list funct_declaration_list_then_main EOF -> ^( PROGRAM type_declaration_list funct_declaration_list_then_main ) )
			// Tiger.g:201:2: type_declaration_list funct_declaration_list_then_main EOF
			{
				
					// This new SymbolTable will be the global SymbolTable
					enterNewScope(new SymbolTable());
					level = 0;
				
			pushFollow(FOLLOW_type_declaration_list_in_tiger_program1028);
			type_declaration_list1=type_declaration_list();
			state._fsp--;

			stream_type_declaration_list.add(type_declaration_list1.getTree());
			pushFollow(FOLLOW_funct_declaration_list_then_main_in_tiger_program1030);
			funct_declaration_list_then_main2=funct_declaration_list_then_main();
			state._fsp--;

			stream_funct_declaration_list_then_main.add(funct_declaration_list_then_main2.getTree());
			printSymbol();
			EOF3=(Token)match(input,EOF,FOLLOW_EOF_in_tiger_program1033);  
			stream_EOF.add(EOF3);

			// AST REWRITE
			// elements: funct_declaration_list_then_main, type_declaration_list
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 207:2: -> ^( PROGRAM type_declaration_list funct_declaration_list_then_main )
			{
				// Tiger.g:207:5: ^( PROGRAM type_declaration_list funct_declaration_list_then_main )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PROGRAM, "PROGRAM"), root_1);
				adaptor.addChild(root_1, stream_type_declaration_list.nextTree());
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
		return retval;
	}
	// $ANTLR end "tiger_program"


	public static class funct_declaration_list_then_main_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "funct_declaration_list_then_main"
	// Tiger.g:211:1: funct_declaration_list_then_main : (myRet= VOID ! ( funct_declaration_tail[$myRet, $myRet.text] funct_declaration_list_then_main | main_function_tail ) | (myRet= ID |myRet= INT |myRet= FIXEDPT ) funct_declaration_tail[$myRet, $myRet.text] funct_declaration_list_then_main );
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

		try {
			// Tiger.g:212:5: (myRet= VOID ! ( funct_declaration_tail[$myRet, $myRet.text] funct_declaration_list_then_main | main_function_tail ) | (myRet= ID |myRet= INT |myRet= FIXEDPT ) funct_declaration_tail[$myRet, $myRet.text] funct_declaration_list_then_main )
			int alt3=2;
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
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// Tiger.g:212:7: myRet= VOID ! ( funct_declaration_tail[$myRet, $myRet.text] funct_declaration_list_then_main | main_function_tail )
					{
					root_0 = (Object)adaptor.nil();


					myRet=(Token)match(input,VOID,FOLLOW_VOID_in_funct_declaration_list_then_main1061); 
					// Tiger.g:212:19: ( funct_declaration_tail[$myRet, $myRet.text] funct_declaration_list_then_main | main_function_tail )
					int alt1=2;
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
						throw nvae;
					}

					switch (alt1) {
						case 1 :
							// Tiger.g:212:20: funct_declaration_tail[$myRet, $myRet.text] funct_declaration_list_then_main
							{
							pushFollow(FOLLOW_funct_declaration_tail_in_funct_declaration_list_then_main1065);
							funct_declaration_tail4=funct_declaration_tail(myRet, (myRet!=null?myRet.getText():null));
							state._fsp--;

							adaptor.addChild(root_0, funct_declaration_tail4.getTree());

							pushFollow(FOLLOW_funct_declaration_list_then_main_in_funct_declaration_list_then_main1068);
							funct_declaration_list_then_main5=funct_declaration_list_then_main();
							state._fsp--;

							adaptor.addChild(root_0, funct_declaration_list_then_main5.getTree());

							}
							break;
						case 2 :
							// Tiger.g:212:99: main_function_tail
							{
							pushFollow(FOLLOW_main_function_tail_in_funct_declaration_list_then_main1072);
							main_function_tail6=main_function_tail();
							state._fsp--;

							adaptor.addChild(root_0, main_function_tail6.getTree());

							}
							break;

					}

					}
					break;
				case 2 :
					// Tiger.g:214:7: (myRet= ID |myRet= INT |myRet= FIXEDPT ) funct_declaration_tail[$myRet, $myRet.text] funct_declaration_list_then_main
					{
					root_0 = (Object)adaptor.nil();


					// Tiger.g:214:7: (myRet= ID |myRet= INT |myRet= FIXEDPT )
					int alt2=3;
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
						throw nvae;
					}
					switch (alt2) {
						case 1 :
							// Tiger.g:214:8: myRet= ID
							{
							myRet=(Token)match(input,ID,FOLLOW_ID_in_funct_declaration_list_then_main1085); 
							myRet_tree = (Object)adaptor.create(myRet);
							adaptor.addChild(root_0, myRet_tree);

							}
							break;
						case 2 :
							// Tiger.g:214:17: myRet= INT
							{
							myRet=(Token)match(input,INT,FOLLOW_INT_in_funct_declaration_list_then_main1089); 
							myRet_tree = (Object)adaptor.create(myRet);
							adaptor.addChild(root_0, myRet_tree);

							}
							break;
						case 3 :
							// Tiger.g:214:27: myRet= FIXEDPT
							{
							myRet=(Token)match(input,FIXEDPT,FOLLOW_FIXEDPT_in_funct_declaration_list_then_main1093); 
							myRet_tree = (Object)adaptor.create(myRet);
							adaptor.addChild(root_0, myRet_tree);

							}
							break;

					}

					pushFollow(FOLLOW_funct_declaration_tail_in_funct_declaration_list_then_main1096);
					funct_declaration_tail7=funct_declaration_tail(myRet, (myRet!=null?myRet.getText():null));
					state._fsp--;

					adaptor.addChild(root_0, funct_declaration_tail7.getTree());

					pushFollow(FOLLOW_funct_declaration_list_then_main_in_funct_declaration_list_then_main1099);
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
		return retval;
	}
	// $ANTLR end "funct_declaration_list_then_main"


	public static class funct_declaration_tail_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "funct_declaration_tail"
	// Tiger.g:217:1: funct_declaration_tail[Token retType, String returnType] : FUNCTION ID '(' param_list ')' BEGIN block_list END ';' -> ^( FUNCTION ID param_list block_list ) ;
	public final TigerParser.funct_declaration_tail_return funct_declaration_tail(Token retType, String returnType) throws RecognitionException {
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
		RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
		RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
		RewriteRuleTokenStream stream_END=new RewriteRuleTokenStream(adaptor,"token END");
		RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_BEGIN=new RewriteRuleTokenStream(adaptor,"token BEGIN");
		RewriteRuleTokenStream stream_FUNCTION=new RewriteRuleTokenStream(adaptor,"token FUNCTION");
		RewriteRuleSubtreeStream stream_block_list=new RewriteRuleSubtreeStream(adaptor,"rule block_list");
		RewriteRuleSubtreeStream stream_param_list=new RewriteRuleSubtreeStream(adaptor,"rule param_list");

		try {
			// Tiger.g:218:5: ( FUNCTION ID '(' param_list ')' BEGIN block_list END ';' -> ^( FUNCTION ID param_list block_list ) )
			// Tiger.g:218:7: FUNCTION ID '(' param_list ')' BEGIN block_list END ';'
			{
			Type type = new Type(returnType);
			FUNCTION9=(Token)match(input,FUNCTION,FOLLOW_FUNCTION_in_funct_declaration_tail1127);  
			stream_FUNCTION.add(FUNCTION9);

			ID10=(Token)match(input,ID,FOLLOW_ID_in_funct_declaration_tail1129);  
			stream_ID.add(ID10);

			char_literal11=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_funct_declaration_tail1131);  
			stream_LPAREN.add(char_literal11);

			pushFollow(FOLLOW_param_list_in_funct_declaration_tail1133);
			param_list12=param_list();
			state._fsp--;

			stream_param_list.add(param_list12.getTree());
			char_literal13=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_funct_declaration_tail1135);  
			stream_RPAREN.add(char_literal13);

			BEGIN14=(Token)match(input,BEGIN,FOLLOW_BEGIN_in_funct_declaration_tail1137);  
			stream_BEGIN.add(BEGIN14);

			pushFollow(FOLLOW_block_list_in_funct_declaration_tail1139);
			block_list15=block_list();
			state._fsp--;

			stream_block_list.add(block_list15.getTree());
			END16=(Token)match(input,END,FOLLOW_END_in_funct_declaration_tail1141);  
			stream_END.add(END16);

			char_literal17=(Token)match(input,SEMI,FOLLOW_SEMI_in_funct_declaration_tail1143);  
			stream_SEMI.add(char_literal17);

			getTopTable().put((ID10!=null?ID10.getText():null), new Function((FUNCTION9!=null?FUNCTION9.getText():null), type, (param_list12!=null?((TigerParser.param_list_return)param_list12).paramList:null)));
			// AST REWRITE
			// elements: param_list, ID, block_list, FUNCTION
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 221:2: -> ^( FUNCTION ID param_list block_list )
			{
				// Tiger.g:221:5: ^( FUNCTION ID param_list block_list )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot(stream_FUNCTION.nextNode(), root_1);
				adaptor.addChild(root_1, new CommonTree(retType));
				adaptor.addChild(root_1, stream_ID.nextNode());
				adaptor.addChild(root_1, stream_param_list.nextTree());
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
		return retval;
	}
	// $ANTLR end "funct_declaration_tail"


	public static class main_function_tail_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "main_function_tail"
	// Tiger.g:224:1: main_function_tail : MAIN '(' ')' BEGIN block_list END ';' -> ^( MAINSCOPE block_list ) ;
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
		RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
		RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
		RewriteRuleTokenStream stream_MAIN=new RewriteRuleTokenStream(adaptor,"token MAIN");
		RewriteRuleTokenStream stream_END=new RewriteRuleTokenStream(adaptor,"token END");
		RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
		RewriteRuleTokenStream stream_BEGIN=new RewriteRuleTokenStream(adaptor,"token BEGIN");
		RewriteRuleSubtreeStream stream_block_list=new RewriteRuleSubtreeStream(adaptor,"rule block_list");

		try {
			// Tiger.g:225:5: ( MAIN '(' ')' BEGIN block_list END ';' -> ^( MAINSCOPE block_list ) )
			// Tiger.g:225:7: MAIN '(' ')' BEGIN block_list END ';'
			{
			MAIN18=(Token)match(input,MAIN,FOLLOW_MAIN_in_main_function_tail1187);  
			stream_MAIN.add(MAIN18);

			char_literal19=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_main_function_tail1189);  
			stream_LPAREN.add(char_literal19);

			char_literal20=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_main_function_tail1191);  
			stream_RPAREN.add(char_literal20);

			BEGIN21=(Token)match(input,BEGIN,FOLLOW_BEGIN_in_main_function_tail1193);  
			stream_BEGIN.add(BEGIN21);

			pushFollow(FOLLOW_block_list_in_main_function_tail1195);
			block_list22=block_list();
			state._fsp--;

			stream_block_list.add(block_list22.getTree());
			END23=(Token)match(input,END,FOLLOW_END_in_main_function_tail1197);  
			stream_END.add(END23);

			char_literal24=(Token)match(input,SEMI,FOLLOW_SEMI_in_main_function_tail1199);  
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
			// 226:2: -> ^( MAINSCOPE block_list )
			{
				// Tiger.g:226:5: ^( MAINSCOPE block_list )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(MAINSCOPE, "MAINSCOPE"), root_1);
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
		return retval;
	}
	// $ANTLR end "main_function_tail"


	public static class param_list_return extends ParserRuleReturnScope {
		public ArrayList<Id> paramList;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "param_list"
	// Tiger.g:230:1: param_list returns [ArrayList<Id> paramList] : (par1= param ( ',' par2= param )* )? -> ^( PARAMLIST ( param )* ) ;
	public final TigerParser.param_list_return param_list() throws RecognitionException {
		TigerParser.param_list_return retval = new TigerParser.param_list_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal25=null;
		ParserRuleReturnScope par1 =null;
		ParserRuleReturnScope par2 =null;

		Object char_literal25_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleSubtreeStream stream_param=new RewriteRuleSubtreeStream(adaptor,"rule param");

		try {
			// Tiger.g:231:5: ( (par1= param ( ',' par2= param )* )? -> ^( PARAMLIST ( param )* ) )
			// Tiger.g:231:7: (par1= param ( ',' par2= param )* )?
			{
			retval.paramList = new ArrayList<Id>();
			// Tiger.g:232:5: (par1= param ( ',' par2= param )* )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==ID) ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// Tiger.g:232:6: par1= param ( ',' par2= param )*
					{
					pushFollow(FOLLOW_param_in_param_list1235);
					par1=param();
					state._fsp--;

					stream_param.add(par1.getTree());
					retval.paramList.add((par1!=null?((TigerParser.param_return)par1).param:null));
					// Tiger.g:232:48: ( ',' par2= param )*
					loop4:
					while (true) {
						int alt4=2;
						int LA4_0 = input.LA(1);
						if ( (LA4_0==COMMA) ) {
							alt4=1;
						}

						switch (alt4) {
						case 1 :
							// Tiger.g:232:50: ',' par2= param
							{
							char_literal25=(Token)match(input,COMMA,FOLLOW_COMMA_in_param_list1241);  
							stream_COMMA.add(char_literal25);

							pushFollow(FOLLOW_param_in_param_list1245);
							par2=param();
							state._fsp--;

							stream_param.add(par2.getTree());
							retval.paramList.add((par2!=null?((TigerParser.param_return)par2).param:null));
							}
							break;

						default :
							break loop4;
						}
					}

					}
					break;

			}

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
			// 234:2: -> ^( PARAMLIST ( param )* )
			{
				// Tiger.g:234:5: ^( PARAMLIST ( param )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PARAMLIST, "PARAMLIST"), root_1);
				// Tiger.g:234:17: ( param )*
				while ( stream_param.hasNext() ) {
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
		return retval;
	}
	// $ANTLR end "param_list"


	public static class param_return extends ParserRuleReturnScope {
		public Id param;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "param"
	// Tiger.g:237:1: param returns [Id param] : ID ':' type_id ;
	public final TigerParser.param_return param() throws RecognitionException {
		TigerParser.param_return retval = new TigerParser.param_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ID26=null;
		Token char_literal27=null;
		ParserRuleReturnScope type_id28 =null;

		Object ID26_tree=null;
		Object char_literal27_tree=null;

		try {
			// Tiger.g:238:2: ( ID ':' type_id )
			// Tiger.g:238:4: ID ':' type_id
			{
			root_0 = (Object)adaptor.nil();


			ID26=(Token)match(input,ID,FOLLOW_ID_in_param1280); 
			ID26_tree = (Object)adaptor.create(ID26);
			adaptor.addChild(root_0, ID26_tree);

			char_literal27=(Token)match(input,COLON,FOLLOW_COLON_in_param1282); 
			char_literal27_tree = (Object)adaptor.create(char_literal27);
			adaptor.addChild(root_0, char_literal27_tree);

			pushFollow(FOLLOW_type_id_in_param1284);
			type_id28=type_id();
			state._fsp--;

			adaptor.addChild(root_0, type_id28.getTree());

			retval.param = new Id((ID26!=null?ID26.getText():null), (type_id28!=null?((TigerParser.type_id_return)type_id28).e:null));
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
		return retval;
	}
	// $ANTLR end "param"


	public static class block_list_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "block_list"
	// Tiger.g:243:1: block_list : ( block )+ -> ^( BLOCKLIST ( block )+ ) ;
	public final TigerParser.block_list_return block_list() throws RecognitionException {
		TigerParser.block_list_return retval = new TigerParser.block_list_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope block29 =null;

		RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");

		try {
			// Tiger.g:244:5: ( ( block )+ -> ^( BLOCKLIST ( block )+ ) )
			// Tiger.g:244:7: ( block )+
			{
			// Tiger.g:244:7: ( block )+
			int cnt6=0;
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==BEGIN) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// Tiger.g:244:7: block
					{
					pushFollow(FOLLOW_block_in_block_list1312);
					block29=block();
					state._fsp--;

					stream_block.add(block29.getTree());
					}
					break;

				default :
					if ( cnt6 >= 1 ) break loop6;
					EarlyExitException eee = new EarlyExitException(6, input);
					throw eee;
				}
				cnt6++;
			}

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
			// 244:14: -> ^( BLOCKLIST ( block )+ )
			{
				// Tiger.g:244:17: ^( BLOCKLIST ( block )+ )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(BLOCKLIST, "BLOCKLIST"), root_1);
				if ( !(stream_block.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_block.hasNext() ) {
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
		return retval;
	}
	// $ANTLR end "block_list"


	public static class block_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "block"
	// Tiger.g:246:1: block : BEGIN declaration_segment stat_seq END ';' -> ^( BLOCKSCOPE declaration_segment stat_seq ) ;
	public final TigerParser.block_return block() throws RecognitionException {
		TigerParser.block_return retval = new TigerParser.block_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token BEGIN30=null;
		Token END33=null;
		Token char_literal34=null;
		ParserRuleReturnScope declaration_segment31 =null;
		ParserRuleReturnScope stat_seq32 =null;

		Object BEGIN30_tree=null;
		Object END33_tree=null;
		Object char_literal34_tree=null;
		RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
		RewriteRuleTokenStream stream_END=new RewriteRuleTokenStream(adaptor,"token END");
		RewriteRuleTokenStream stream_BEGIN=new RewriteRuleTokenStream(adaptor,"token BEGIN");
		RewriteRuleSubtreeStream stream_stat_seq=new RewriteRuleSubtreeStream(adaptor,"rule stat_seq");
		RewriteRuleSubtreeStream stream_declaration_segment=new RewriteRuleSubtreeStream(adaptor,"rule declaration_segment");

		try {
			// Tiger.g:247:5: ( BEGIN declaration_segment stat_seq END ';' -> ^( BLOCKSCOPE declaration_segment stat_seq ) )
			// Tiger.g:247:7: BEGIN declaration_segment stat_seq END ';'
			{
			BEGIN30=(Token)match(input,BEGIN,FOLLOW_BEGIN_in_block1335);  
			stream_BEGIN.add(BEGIN30);

			pushFollow(FOLLOW_declaration_segment_in_block1342);
			declaration_segment31=declaration_segment();
			state._fsp--;

			stream_declaration_segment.add(declaration_segment31.getTree());
			pushFollow(FOLLOW_stat_seq_in_block1344);
			stat_seq32=stat_seq();
			state._fsp--;

			stream_stat_seq.add(stat_seq32.getTree());
			END33=(Token)match(input,END,FOLLOW_END_in_block1346);  
			stream_END.add(END33);

			char_literal34=(Token)match(input,SEMI,FOLLOW_SEMI_in_block1348);  
			stream_SEMI.add(char_literal34);

			// AST REWRITE
			// elements: stat_seq, declaration_segment
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 251:2: -> ^( BLOCKSCOPE declaration_segment stat_seq )
			{
				// Tiger.g:251:5: ^( BLOCKSCOPE declaration_segment stat_seq )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(BLOCKSCOPE, "BLOCKSCOPE"), root_1);
				adaptor.addChild(root_1, stream_declaration_segment.nextTree());
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
		return retval;
	}
	// $ANTLR end "block"


	public static class declaration_segment_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "declaration_segment"
	// Tiger.g:253:1: declaration_segment : type_declaration_list var_declaration_list ;
	public final TigerParser.declaration_segment_return declaration_segment() throws RecognitionException {
		TigerParser.declaration_segment_return retval = new TigerParser.declaration_segment_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope type_declaration_list35 =null;
		ParserRuleReturnScope var_declaration_list36 =null;


		try {
			// Tiger.g:254:5: ( type_declaration_list var_declaration_list )
			// Tiger.g:254:7: type_declaration_list var_declaration_list
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_type_declaration_list_in_declaration_segment1373);
			type_declaration_list35=type_declaration_list();
			state._fsp--;

			adaptor.addChild(root_0, type_declaration_list35.getTree());

			pushFollow(FOLLOW_var_declaration_list_in_declaration_segment1375);
			var_declaration_list36=var_declaration_list();
			state._fsp--;

			adaptor.addChild(root_0, var_declaration_list36.getTree());

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
		return retval;
	}
	// $ANTLR end "declaration_segment"


	public static class type_declaration_list_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "type_declaration_list"
	// Tiger.g:256:1: type_declaration_list : ( type_declaration )* -> ^( TYPEDECLLIST ( type_declaration )* ) ;
	public final TigerParser.type_declaration_list_return type_declaration_list() throws RecognitionException {
		TigerParser.type_declaration_list_return retval = new TigerParser.type_declaration_list_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope type_declaration37 =null;

		RewriteRuleSubtreeStream stream_type_declaration=new RewriteRuleSubtreeStream(adaptor,"rule type_declaration");

		try {
			// Tiger.g:257:5: ( ( type_declaration )* -> ^( TYPEDECLLIST ( type_declaration )* ) )
			// Tiger.g:257:7: ( type_declaration )*
			{
			// Tiger.g:257:7: ( type_declaration )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==TYPE) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// Tiger.g:257:7: type_declaration
					{
					pushFollow(FOLLOW_type_declaration_in_type_declaration_list1388);
					type_declaration37=type_declaration();
					state._fsp--;

					stream_type_declaration.add(type_declaration37.getTree());
					}
					break;

				default :
					break loop7;
				}
			}

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
			// 258:2: -> ^( TYPEDECLLIST ( type_declaration )* )
			{
				// Tiger.g:258:5: ^( TYPEDECLLIST ( type_declaration )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(TYPEDECLLIST, "TYPEDECLLIST"), root_1);
				// Tiger.g:258:20: ( type_declaration )*
				while ( stream_type_declaration.hasNext() ) {
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
		return retval;
	}
	// $ANTLR end "type_declaration_list"


	public static class var_declaration_list_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "var_declaration_list"
	// Tiger.g:261:1: var_declaration_list : ( var_declaration )* -> ^( VARDECLLIST ( var_declaration )* ) ;
	public final TigerParser.var_declaration_list_return var_declaration_list() throws RecognitionException {
		TigerParser.var_declaration_list_return retval = new TigerParser.var_declaration_list_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope var_declaration38 =null;

		RewriteRuleSubtreeStream stream_var_declaration=new RewriteRuleSubtreeStream(adaptor,"rule var_declaration");

		try {
			// Tiger.g:262:5: ( ( var_declaration )* -> ^( VARDECLLIST ( var_declaration )* ) )
			// Tiger.g:262:7: ( var_declaration )*
			{
			// Tiger.g:262:7: ( var_declaration )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==VAR) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// Tiger.g:262:7: var_declaration
					{
					pushFollow(FOLLOW_var_declaration_in_var_declaration_list1421);
					var_declaration38=var_declaration();
					state._fsp--;

					stream_var_declaration.add(var_declaration38.getTree());
					}
					break;

				default :
					break loop8;
				}
			}

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
			// 263:2: -> ^( VARDECLLIST ( var_declaration )* )
			{
				// Tiger.g:263:5: ^( VARDECLLIST ( var_declaration )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(VARDECLLIST, "VARDECLLIST"), root_1);
				// Tiger.g:263:19: ( var_declaration )*
				while ( stream_var_declaration.hasNext() ) {
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
		return retval;
	}
	// $ANTLR end "var_declaration_list"


	public static class type_declaration_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "type_declaration"
	// Tiger.g:266:1: type_declaration : TYPE ID '=' type ';' -> ^( TYPEDECL ID type ) ;
	public final TigerParser.type_declaration_return type_declaration() throws RecognitionException {
		TigerParser.type_declaration_return retval = new TigerParser.type_declaration_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token TYPE39=null;
		Token ID40=null;
		Token char_literal41=null;
		Token char_literal43=null;
		ParserRuleReturnScope type42 =null;

		Object TYPE39_tree=null;
		Object ID40_tree=null;
		Object char_literal41_tree=null;
		Object char_literal43_tree=null;
		RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_EQ=new RewriteRuleTokenStream(adaptor,"token EQ");
		RewriteRuleTokenStream stream_TYPE=new RewriteRuleTokenStream(adaptor,"token TYPE");
		RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");

		try {
			// Tiger.g:267:5: ( TYPE ID '=' type ';' -> ^( TYPEDECL ID type ) )
			// Tiger.g:267:7: TYPE ID '=' type ';'
			{
			TYPE39=(Token)match(input,TYPE,FOLLOW_TYPE_in_type_declaration1451);  
			stream_TYPE.add(TYPE39);

			ID40=(Token)match(input,ID,FOLLOW_ID_in_type_declaration1453);  
			stream_ID.add(ID40);

			char_literal41=(Token)match(input,EQ,FOLLOW_EQ_in_type_declaration1455);  
			stream_EQ.add(char_literal41);

			pushFollow(FOLLOW_type_in_type_declaration1457);
			type42=type();
			state._fsp--;

			stream_type.add(type42.getTree());
			char_literal43=(Token)match(input,SEMI,FOLLOW_SEMI_in_type_declaration1459);  
			stream_SEMI.add(char_literal43);

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
			// 269:2: -> ^( TYPEDECL ID type )
			{
				// Tiger.g:269:5: ^( TYPEDECL ID type )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(TYPEDECL, "TYPEDECL"), root_1);
				adaptor.addChild(root_1, stream_ID.nextNode());
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
		return retval;
	}
	// $ANTLR end "type_declaration"


	public static class type_return extends ParserRuleReturnScope {
		public Type e;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "type"
	// Tiger.g:271:1: type returns [Type e] : ( base_type | ARRAY '[' INTLIT ']' ( '[' INTLIT ']' )? OF base_type -> ^( ARRAY base_type ( INTLIT )+ ) );
	public final TigerParser.type_return type() throws RecognitionException {
		TigerParser.type_return retval = new TigerParser.type_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ARRAY45=null;
		Token char_literal46=null;
		Token INTLIT47=null;
		Token char_literal48=null;
		Token char_literal49=null;
		Token INTLIT50=null;
		Token char_literal51=null;
		Token OF52=null;
		ParserRuleReturnScope base_type44 =null;
		ParserRuleReturnScope base_type53 =null;

		Object ARRAY45_tree=null;
		Object char_literal46_tree=null;
		Object INTLIT47_tree=null;
		Object char_literal48_tree=null;
		Object char_literal49_tree=null;
		Object INTLIT50_tree=null;
		Object char_literal51_tree=null;
		Object OF52_tree=null;
		RewriteRuleTokenStream stream_RBRACK=new RewriteRuleTokenStream(adaptor,"token RBRACK");
		RewriteRuleTokenStream stream_ARRAY=new RewriteRuleTokenStream(adaptor,"token ARRAY");
		RewriteRuleTokenStream stream_LBRACK=new RewriteRuleTokenStream(adaptor,"token LBRACK");
		RewriteRuleTokenStream stream_OF=new RewriteRuleTokenStream(adaptor,"token OF");
		RewriteRuleTokenStream stream_INTLIT=new RewriteRuleTokenStream(adaptor,"token INTLIT");
		RewriteRuleSubtreeStream stream_base_type=new RewriteRuleSubtreeStream(adaptor,"rule base_type");

		try {
			// Tiger.g:272:5: ( base_type | ARRAY '[' INTLIT ']' ( '[' INTLIT ']' )? OF base_type -> ^( ARRAY base_type ( INTLIT )+ ) )
			int alt10=2;
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
				throw nvae;
			}

			switch (alt10) {
				case 1 :
					// Tiger.g:272:7: base_type
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_base_type_in_type1487);
					base_type44=base_type();
					state._fsp--;

					adaptor.addChild(root_0, base_type44.getTree());

					retval.e = (base_type44!=null?((TigerParser.base_type_return)base_type44).e:null);
					}
					break;
				case 2 :
					// Tiger.g:273:7: ARRAY '[' INTLIT ']' ( '[' INTLIT ']' )? OF base_type
					{
					ARRAY45=(Token)match(input,ARRAY,FOLLOW_ARRAY_in_type1497);  
					stream_ARRAY.add(ARRAY45);

					char_literal46=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_type1499);  
					stream_LBRACK.add(char_literal46);

					INTLIT47=(Token)match(input,INTLIT,FOLLOW_INTLIT_in_type1501);  
					stream_INTLIT.add(INTLIT47);

					char_literal48=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_type1503);  
					stream_RBRACK.add(char_literal48);

					// Tiger.g:273:28: ( '[' INTLIT ']' )?
					int alt9=2;
					int LA9_0 = input.LA(1);
					if ( (LA9_0==LBRACK) ) {
						alt9=1;
					}
					switch (alt9) {
						case 1 :
							// Tiger.g:273:29: '[' INTLIT ']'
							{
							char_literal49=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_type1506);  
							stream_LBRACK.add(char_literal49);

							INTLIT50=(Token)match(input,INTLIT,FOLLOW_INTLIT_in_type1508);  
							stream_INTLIT.add(INTLIT50);

							char_literal51=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_type1510);  
							stream_RBRACK.add(char_literal51);

							}
							break;

					}

					OF52=(Token)match(input,OF,FOLLOW_OF_in_type1514);  
					stream_OF.add(OF52);

					pushFollow(FOLLOW_base_type_in_type1516);
					base_type53=base_type();
					state._fsp--;

					stream_base_type.add(base_type53.getTree());
					// AST REWRITE
					// elements: base_type, INTLIT, ARRAY
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 274:2: -> ^( ARRAY base_type ( INTLIT )+ )
					{
						// Tiger.g:274:5: ^( ARRAY base_type ( INTLIT )+ )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot(stream_ARRAY.nextNode(), root_1);
						adaptor.addChild(root_1, stream_base_type.nextTree());
						if ( !(stream_INTLIT.hasNext()) ) {
							throw new RewriteEarlyExitException();
						}
						while ( stream_INTLIT.hasNext() ) {
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
		return retval;
	}
	// $ANTLR end "type"


	public static class type_id_return extends ParserRuleReturnScope {
		public Type e;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "type_id"
	// Tiger.g:277:1: type_id returns [Type e] : ( base_type |id= ID );
	public final TigerParser.type_id_return type_id() throws RecognitionException {
		TigerParser.type_id_return retval = new TigerParser.type_id_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token id=null;
		ParserRuleReturnScope base_type54 =null;

		Object id_tree=null;

		try {
			// Tiger.g:279:5: ( base_type |id= ID )
			int alt11=2;
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
				throw nvae;
			}

			switch (alt11) {
				case 1 :
					// Tiger.g:279:7: base_type
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_base_type_in_type_id1551);
					base_type54=base_type();
					state._fsp--;

					adaptor.addChild(root_0, base_type54.getTree());

					retval.e = (base_type54!=null?((TigerParser.base_type_return)base_type54).e:null);
					}
					break;
				case 2 :
					// Tiger.g:283:7: id= ID
					{
					root_0 = (Object)adaptor.nil();


					id=(Token)match(input,ID,FOLLOW_ID_in_type_id1568); 
					id_tree = (Object)adaptor.create(id);
					adaptor.addChild(root_0, id_tree);

					retval.e = new UserType((id!=null?id.getText():null));
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
		return retval;
	}
	// $ANTLR end "type_id"


	public static class base_type_return extends ParserRuleReturnScope {
		public Type e;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "base_type"
	// Tiger.g:287:1: base_type returns [Type e] : ( INT | FIXEDPT );
	public final TigerParser.base_type_return base_type() throws RecognitionException {
		TigerParser.base_type_return retval = new TigerParser.base_type_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token INT55=null;
		Token FIXEDPT56=null;

		Object INT55_tree=null;
		Object FIXEDPT56_tree=null;

		try {
			// Tiger.g:288:5: ( INT | FIXEDPT )
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0==INT) ) {
				alt12=1;
			}
			else if ( (LA12_0==FIXEDPT) ) {
				alt12=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}

			switch (alt12) {
				case 1 :
					// Tiger.g:288:7: INT
					{
					root_0 = (Object)adaptor.nil();


					INT55=(Token)match(input,INT,FOLLOW_INT_in_base_type1592); 
					INT55_tree = (Object)adaptor.create(INT55);
					adaptor.addChild(root_0, INT55_tree);

					retval.e = Type.Int;
					}
					break;
				case 2 :
					// Tiger.g:289:7: FIXEDPT
					{
					root_0 = (Object)adaptor.nil();


					FIXEDPT56=(Token)match(input,FIXEDPT,FOLLOW_FIXEDPT_in_base_type1603); 
					FIXEDPT56_tree = (Object)adaptor.create(FIXEDPT56);
					adaptor.addChild(root_0, FIXEDPT56_tree);

					retval.e = Type.Float;
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
		return retval;
	}
	// $ANTLR end "base_type"


	public static class var_declaration_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "var_declaration"
	// Tiger.g:292:1: var_declaration : VAR id_list ':' type_id optional_init ';' -> ^( VAR type_id id_list ( optional_init )? ) ;
	public final TigerParser.var_declaration_return var_declaration() throws RecognitionException {
		TigerParser.var_declaration_return retval = new TigerParser.var_declaration_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token VAR57=null;
		Token char_literal59=null;
		Token char_literal62=null;
		ParserRuleReturnScope id_list58 =null;
		ParserRuleReturnScope type_id60 =null;
		ParserRuleReturnScope optional_init61 =null;

		Object VAR57_tree=null;
		Object char_literal59_tree=null;
		Object char_literal62_tree=null;
		RewriteRuleTokenStream stream_VAR=new RewriteRuleTokenStream(adaptor,"token VAR");
		RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
		RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
		RewriteRuleSubtreeStream stream_id_list=new RewriteRuleSubtreeStream(adaptor,"rule id_list");
		RewriteRuleSubtreeStream stream_type_id=new RewriteRuleSubtreeStream(adaptor,"rule type_id");
		RewriteRuleSubtreeStream stream_optional_init=new RewriteRuleSubtreeStream(adaptor,"rule optional_init");

		try {
			// Tiger.g:293:5: ( VAR id_list ':' type_id optional_init ';' -> ^( VAR type_id id_list ( optional_init )? ) )
			// Tiger.g:296:2: VAR id_list ':' type_id optional_init ';'
			{
			VAR57=(Token)match(input,VAR,FOLLOW_VAR_in_var_declaration1628);  
			stream_VAR.add(VAR57);

			pushFollow(FOLLOW_id_list_in_var_declaration1630);
			id_list58=id_list();
			state._fsp--;

			stream_id_list.add(id_list58.getTree());
			char_literal59=(Token)match(input,COLON,FOLLOW_COLON_in_var_declaration1632);  
			stream_COLON.add(char_literal59);

			pushFollow(FOLLOW_type_id_in_var_declaration1634);
			type_id60=type_id();
			state._fsp--;

			stream_type_id.add(type_id60.getTree());
			pushFollow(FOLLOW_optional_init_in_var_declaration1636);
			optional_init61=optional_init();
			state._fsp--;

			stream_optional_init.add(optional_init61.getTree());
			char_literal62=(Token)match(input,SEMI,FOLLOW_SEMI_in_var_declaration1638);  
			stream_SEMI.add(char_literal62);


						for(int i = 0; i < (id_list58!=null?((TigerParser.id_list_return)id_list58).list:null).size(); i++) {
							getTopTable().put((id_list58!=null?((TigerParser.id_list_return)id_list58).list:null).get(i), new Id((id_list58!=null?((TigerParser.id_list_return)id_list58).list:null).get(i), (type_id60!=null?((TigerParser.type_id_return)type_id60).e:null), (optional_init61!=null?((TigerParser.optional_init_return)optional_init61).b:false)));
						}
					
			// AST REWRITE
			// elements: id_list, optional_init, VAR, type_id
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 303:2: -> ^( VAR type_id id_list ( optional_init )? )
			{
				// Tiger.g:303:5: ^( VAR type_id id_list ( optional_init )? )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot(stream_VAR.nextNode(), root_1);
				adaptor.addChild(root_1, stream_type_id.nextTree());
				adaptor.addChild(root_1, stream_id_list.nextTree());
				// Tiger.g:303:27: ( optional_init )?
				if ( stream_optional_init.hasNext() ) {
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
		return retval;
	}
	// $ANTLR end "var_declaration"


	public static class id_list_return extends ParserRuleReturnScope {
		public ArrayList<String> list;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "id_list"
	// Tiger.g:307:1: id_list returns [ArrayList<String> list] :i= ID ( ',' j= ID )* -> ^( IDLIST ( ID )+ ) ;
	public final TigerParser.id_list_return id_list() throws RecognitionException {
		TigerParser.id_list_return retval = new TigerParser.id_list_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token i=null;
		Token j=null;
		Token char_literal63=null;

		Object i_tree=null;
		Object j_tree=null;
		Object char_literal63_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");

		try {
			// Tiger.g:308:5: (i= ID ( ',' j= ID )* -> ^( IDLIST ( ID )+ ) )
			// Tiger.g:308:6: i= ID ( ',' j= ID )*
			{
			retval.list = new ArrayList();
			i=(Token)match(input,ID,FOLLOW_ID_in_id_list1680);  
			stream_ID.add(i);

			retval.list.add((i!=null?i.getText():null));
			// Tiger.g:309:28: ( ',' j= ID )*
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0==COMMA) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// Tiger.g:309:29: ',' j= ID
					{
					char_literal63=(Token)match(input,COMMA,FOLLOW_COMMA_in_id_list1684);  
					stream_COMMA.add(char_literal63);

					j=(Token)match(input,ID,FOLLOW_ID_in_id_list1688);  
					stream_ID.add(j);

					retval.list.add((j!=null?j.getText():null));
					}
					break;

				default :
					break loop13;
				}
			}

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
			// 311:3: -> ^( IDLIST ( ID )+ )
			{
				// Tiger.g:311:6: ^( IDLIST ( ID )+ )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(IDLIST, "IDLIST"), root_1);
				if ( !(stream_ID.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_ID.hasNext() ) {
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
		return retval;
	}
	// $ANTLR end "id_list"


	public static class optional_init_return extends ParserRuleReturnScope {
		public boolean b;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "optional_init"
	// Tiger.g:314:1: optional_init returns [boolean b] : ( ':=' literal |);
	public final TigerParser.optional_init_return optional_init() throws RecognitionException {
		TigerParser.optional_init_return retval = new TigerParser.optional_init_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal64=null;
		ParserRuleReturnScope literal65 =null;

		Object string_literal64_tree=null;

		try {
			// Tiger.g:317:5: ( ':=' literal |)
			int alt14=2;
			int LA14_0 = input.LA(1);
			if ( (LA14_0==ASSIGN) ) {
				alt14=1;
			}
			else if ( (LA14_0==SEMI) ) {
				alt14=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 14, 0, input);
				throw nvae;
			}

			switch (alt14) {
				case 1 :
					// Tiger.g:317:7: ':=' literal
					{
					root_0 = (Object)adaptor.nil();


					retval.b = true;
					string_literal64=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_optional_init1729); 
					string_literal64_tree = (Object)adaptor.create(string_literal64);
					adaptor.addChild(root_0, string_literal64_tree);

					pushFollow(FOLLOW_literal_in_optional_init1731);
					literal65=literal();
					state._fsp--;

					adaptor.addChild(root_0, literal65.getTree());

					}
					break;
				case 2 :
					// Tiger.g:318:7: 
					{
					root_0 = (Object)adaptor.nil();


					retval.b = false;
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
		return retval;
	}
	// $ANTLR end "optional_init"


	public static class stat_seq_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "stat_seq"
	// Tiger.g:321:1: stat_seq : ( stat )+ ;
	public final TigerParser.stat_seq_return stat_seq() throws RecognitionException {
		TigerParser.stat_seq_return retval = new TigerParser.stat_seq_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope stat66 =null;


		try {
			// Tiger.g:322:5: ( ( stat )+ )
			// Tiger.g:322:7: ( stat )+
			{
			root_0 = (Object)adaptor.nil();


			// Tiger.g:322:7: ( stat )+
			int cnt15=0;
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( (LA15_0==BEGIN||LA15_0==BREAK||LA15_0==FOR||LA15_0==ID||LA15_0==IF||LA15_0==RETURN||LA15_0==WHILE) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// Tiger.g:322:7: stat
					{
					pushFollow(FOLLOW_stat_in_stat_seq1757);
					stat66=stat();
					state._fsp--;

					adaptor.addChild(root_0, stat66.getTree());

					}
					break;

				default :
					if ( cnt15 >= 1 ) break loop15;
					EarlyExitException eee = new EarlyExitException(15, input);
					throw eee;
				}
				cnt15++;
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
		return retval;
	}
	// $ANTLR end "stat_seq"


	public static class stat_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "stat"
	// Tiger.g:325:1: stat : ( function_call_or_assignment | IF expr THEN seq1= stat_seq ( ELSE seq2= stat_seq ENDIF -> ^( IF expr ^( THEN_STATS $seq1) ^( ELSE_STATS $seq2) ) | ENDIF -> ^( IF expr ^( THEN_STATS $seq1) ) ) ';' | WHILE expr DO stat_seq ENDDO ';' -> ^( WHILE expr stat_seq ) | FOR ID ':=' index_expr TO index_expr DO stat_seq ENDDO ';' -> ^( FOR ID index_expr index_expr stat_seq ) | BREAK ';' !| RETURN expr ';' -> ^( RETURN expr ) | block );
	public final TigerParser.stat_return stat() throws RecognitionException {
		TigerParser.stat_return retval = new TigerParser.stat_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token IF68=null;
		Token THEN70=null;
		Token ELSE71=null;
		Token ENDIF72=null;
		Token ENDIF73=null;
		Token char_literal74=null;
		Token WHILE75=null;
		Token DO77=null;
		Token ENDDO79=null;
		Token char_literal80=null;
		Token FOR81=null;
		Token ID82=null;
		Token string_literal83=null;
		Token TO85=null;
		Token DO87=null;
		Token ENDDO89=null;
		Token char_literal90=null;
		Token BREAK91=null;
		Token char_literal92=null;
		Token RETURN93=null;
		Token char_literal95=null;
		ParserRuleReturnScope seq1 =null;
		ParserRuleReturnScope seq2 =null;
		ParserRuleReturnScope function_call_or_assignment67 =null;
		ParserRuleReturnScope expr69 =null;
		ParserRuleReturnScope expr76 =null;
		ParserRuleReturnScope stat_seq78 =null;
		ParserRuleReturnScope index_expr84 =null;
		ParserRuleReturnScope index_expr86 =null;
		ParserRuleReturnScope stat_seq88 =null;
		ParserRuleReturnScope expr94 =null;
		ParserRuleReturnScope block96 =null;

		Object IF68_tree=null;
		Object THEN70_tree=null;
		Object ELSE71_tree=null;
		Object ENDIF72_tree=null;
		Object ENDIF73_tree=null;
		Object char_literal74_tree=null;
		Object WHILE75_tree=null;
		Object DO77_tree=null;
		Object ENDDO79_tree=null;
		Object char_literal80_tree=null;
		Object FOR81_tree=null;
		Object ID82_tree=null;
		Object string_literal83_tree=null;
		Object TO85_tree=null;
		Object DO87_tree=null;
		Object ENDDO89_tree=null;
		Object char_literal90_tree=null;
		Object BREAK91_tree=null;
		Object char_literal92_tree=null;
		Object RETURN93_tree=null;
		Object char_literal95_tree=null;
		RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
		RewriteRuleTokenStream stream_ENDIF=new RewriteRuleTokenStream(adaptor,"token ENDIF");
		RewriteRuleTokenStream stream_FOR=new RewriteRuleTokenStream(adaptor,"token FOR");
		RewriteRuleTokenStream stream_DO=new RewriteRuleTokenStream(adaptor,"token DO");
		RewriteRuleTokenStream stream_ASSIGN=new RewriteRuleTokenStream(adaptor,"token ASSIGN");
		RewriteRuleTokenStream stream_RETURN=new RewriteRuleTokenStream(adaptor,"token RETURN");
		RewriteRuleTokenStream stream_ENDDO=new RewriteRuleTokenStream(adaptor,"token ENDDO");
		RewriteRuleTokenStream stream_ELSE=new RewriteRuleTokenStream(adaptor,"token ELSE");
		RewriteRuleTokenStream stream_THEN=new RewriteRuleTokenStream(adaptor,"token THEN");
		RewriteRuleTokenStream stream_WHILE=new RewriteRuleTokenStream(adaptor,"token WHILE");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_TO=new RewriteRuleTokenStream(adaptor,"token TO");
		RewriteRuleTokenStream stream_IF=new RewriteRuleTokenStream(adaptor,"token IF");
		RewriteRuleSubtreeStream stream_index_expr=new RewriteRuleSubtreeStream(adaptor,"rule index_expr");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
		RewriteRuleSubtreeStream stream_stat_seq=new RewriteRuleSubtreeStream(adaptor,"rule stat_seq");

		try {
			// Tiger.g:326:5: ( function_call_or_assignment | IF expr THEN seq1= stat_seq ( ELSE seq2= stat_seq ENDIF -> ^( IF expr ^( THEN_STATS $seq1) ^( ELSE_STATS $seq2) ) | ENDIF -> ^( IF expr ^( THEN_STATS $seq1) ) ) ';' | WHILE expr DO stat_seq ENDDO ';' -> ^( WHILE expr stat_seq ) | FOR ID ':=' index_expr TO index_expr DO stat_seq ENDDO ';' -> ^( FOR ID index_expr index_expr stat_seq ) | BREAK ';' !| RETURN expr ';' -> ^( RETURN expr ) | block )
			int alt17=7;
			switch ( input.LA(1) ) {
			case ID:
				{
				alt17=1;
				}
				break;
			case IF:
				{
				alt17=2;
				}
				break;
			case WHILE:
				{
				alt17=3;
				}
				break;
			case FOR:
				{
				alt17=4;
				}
				break;
			case BREAK:
				{
				alt17=5;
				}
				break;
			case RETURN:
				{
				alt17=6;
				}
				break;
			case BEGIN:
				{
				alt17=7;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 17, 0, input);
				throw nvae;
			}
			switch (alt17) {
				case 1 :
					// Tiger.g:326:7: function_call_or_assignment
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_function_call_or_assignment_in_stat1775);
					function_call_or_assignment67=function_call_or_assignment();
					state._fsp--;

					adaptor.addChild(root_0, function_call_or_assignment67.getTree());

					}
					break;
				case 2 :
					// Tiger.g:327:7: IF expr THEN seq1= stat_seq ( ELSE seq2= stat_seq ENDIF -> ^( IF expr ^( THEN_STATS $seq1) ^( ELSE_STATS $seq2) ) | ENDIF -> ^( IF expr ^( THEN_STATS $seq1) ) ) ';'
					{
					IF68=(Token)match(input,IF,FOLLOW_IF_in_stat1783);  
					stream_IF.add(IF68);

					pushFollow(FOLLOW_expr_in_stat1785);
					expr69=expr();
					state._fsp--;

					stream_expr.add(expr69.getTree());
					THEN70=(Token)match(input,THEN,FOLLOW_THEN_in_stat1787);  
					stream_THEN.add(THEN70);

					pushFollow(FOLLOW_stat_seq_in_stat1791);
					seq1=stat_seq();
					state._fsp--;

					stream_stat_seq.add(seq1.getTree());
					// Tiger.g:328:9: ( ELSE seq2= stat_seq ENDIF -> ^( IF expr ^( THEN_STATS $seq1) ^( ELSE_STATS $seq2) ) | ENDIF -> ^( IF expr ^( THEN_STATS $seq1) ) )
					int alt16=2;
					int LA16_0 = input.LA(1);
					if ( (LA16_0==ELSE) ) {
						alt16=1;
					}
					else if ( (LA16_0==ENDIF) ) {
						alt16=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 16, 0, input);
						throw nvae;
					}

					switch (alt16) {
						case 1 :
							// Tiger.g:328:11: ELSE seq2= stat_seq ENDIF
							{
							ELSE71=(Token)match(input,ELSE,FOLLOW_ELSE_in_stat1804);  
							stream_ELSE.add(ELSE71);

							pushFollow(FOLLOW_stat_seq_in_stat1808);
							seq2=stat_seq();
							state._fsp--;

							stream_stat_seq.add(seq2.getTree());
							ENDIF72=(Token)match(input,ENDIF,FOLLOW_ENDIF_in_stat1810);  
							stream_ENDIF.add(ENDIF72);

							// AST REWRITE
							// elements: seq1, expr, IF, seq2
							// token labels: 
							// rule labels: seq2, seq1, retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_seq2=new RewriteRuleSubtreeStream(adaptor,"rule seq2",seq2!=null?seq2.getTree():null);
							RewriteRuleSubtreeStream stream_seq1=new RewriteRuleSubtreeStream(adaptor,"rule seq1",seq1!=null?seq1.getTree():null);
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (Object)adaptor.nil();
							// 329:13: -> ^( IF expr ^( THEN_STATS $seq1) ^( ELSE_STATS $seq2) )
							{
								// Tiger.g:329:16: ^( IF expr ^( THEN_STATS $seq1) ^( ELSE_STATS $seq2) )
								{
								Object root_1 = (Object)adaptor.nil();
								root_1 = (Object)adaptor.becomeRoot(stream_IF.nextNode(), root_1);
								adaptor.addChild(root_1, stream_expr.nextTree());
								// Tiger.g:329:26: ^( THEN_STATS $seq1)
								{
								Object root_2 = (Object)adaptor.nil();
								root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(THEN_STATS, "THEN_STATS"), root_2);
								adaptor.addChild(root_2, stream_seq1.nextTree());
								adaptor.addChild(root_1, root_2);
								}

								// Tiger.g:329:46: ^( ELSE_STATS $seq2)
								{
								Object root_2 = (Object)adaptor.nil();
								root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(ELSE_STATS, "ELSE_STATS"), root_2);
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
							// Tiger.g:330:11: ENDIF
							{
							ENDIF73=(Token)match(input,ENDIF,FOLLOW_ENDIF_in_stat1856);  
							stream_ENDIF.add(ENDIF73);

							// AST REWRITE
							// elements: seq1, expr, IF
							// token labels: 
							// rule labels: seq1, retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_seq1=new RewriteRuleSubtreeStream(adaptor,"rule seq1",seq1!=null?seq1.getTree():null);
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (Object)adaptor.nil();
							// 331:13: -> ^( IF expr ^( THEN_STATS $seq1) )
							{
								// Tiger.g:331:16: ^( IF expr ^( THEN_STATS $seq1) )
								{
								Object root_1 = (Object)adaptor.nil();
								root_1 = (Object)adaptor.becomeRoot(stream_IF.nextNode(), root_1);
								adaptor.addChild(root_1, stream_expr.nextTree());
								// Tiger.g:331:26: ^( THEN_STATS $seq1)
								{
								Object root_2 = (Object)adaptor.nil();
								root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(THEN_STATS, "THEN_STATS"), root_2);
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

					char_literal74=(Token)match(input,SEMI,FOLLOW_SEMI_in_stat1895);  
					stream_SEMI.add(char_literal74);

					}
					break;
				case 3 :
					// Tiger.g:333:7: WHILE expr DO stat_seq ENDDO ';'
					{
					WHILE75=(Token)match(input,WHILE,FOLLOW_WHILE_in_stat1903);  
					stream_WHILE.add(WHILE75);

					pushFollow(FOLLOW_expr_in_stat1905);
					expr76=expr();
					state._fsp--;

					stream_expr.add(expr76.getTree());
					DO77=(Token)match(input,DO,FOLLOW_DO_in_stat1907);  
					stream_DO.add(DO77);

					pushFollow(FOLLOW_stat_seq_in_stat1909);
					stat_seq78=stat_seq();
					state._fsp--;

					stream_stat_seq.add(stat_seq78.getTree());
					ENDDO79=(Token)match(input,ENDDO,FOLLOW_ENDDO_in_stat1911);  
					stream_ENDDO.add(ENDDO79);

					char_literal80=(Token)match(input,SEMI,FOLLOW_SEMI_in_stat1913);  
					stream_SEMI.add(char_literal80);

					// AST REWRITE
					// elements: stat_seq, expr, WHILE
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 334:9: -> ^( WHILE expr stat_seq )
					{
						// Tiger.g:334:12: ^( WHILE expr stat_seq )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot(stream_WHILE.nextNode(), root_1);
						adaptor.addChild(root_1, stream_expr.nextTree());
						adaptor.addChild(root_1, stream_stat_seq.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 4 :
					// Tiger.g:335:7: FOR ID ':=' index_expr TO index_expr DO stat_seq ENDDO ';'
					{
					FOR81=(Token)match(input,FOR,FOLLOW_FOR_in_stat1939);  
					stream_FOR.add(FOR81);

					ID82=(Token)match(input,ID,FOLLOW_ID_in_stat1941);  
					stream_ID.add(ID82);

					string_literal83=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_stat1943);  
					stream_ASSIGN.add(string_literal83);

					pushFollow(FOLLOW_index_expr_in_stat1945);
					index_expr84=index_expr();
					state._fsp--;

					stream_index_expr.add(index_expr84.getTree());
					TO85=(Token)match(input,TO,FOLLOW_TO_in_stat1947);  
					stream_TO.add(TO85);

					pushFollow(FOLLOW_index_expr_in_stat1949);
					index_expr86=index_expr();
					state._fsp--;

					stream_index_expr.add(index_expr86.getTree());
					DO87=(Token)match(input,DO,FOLLOW_DO_in_stat1951);  
					stream_DO.add(DO87);

					pushFollow(FOLLOW_stat_seq_in_stat1953);
					stat_seq88=stat_seq();
					state._fsp--;

					stream_stat_seq.add(stat_seq88.getTree());
					ENDDO89=(Token)match(input,ENDDO,FOLLOW_ENDDO_in_stat1955);  
					stream_ENDDO.add(ENDDO89);

					char_literal90=(Token)match(input,SEMI,FOLLOW_SEMI_in_stat1957);  
					stream_SEMI.add(char_literal90);

					// AST REWRITE
					// elements: stat_seq, index_expr, index_expr, FOR, ID
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 336:9: -> ^( FOR ID index_expr index_expr stat_seq )
					{
						// Tiger.g:336:12: ^( FOR ID index_expr index_expr stat_seq )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot(stream_FOR.nextNode(), root_1);
						adaptor.addChild(root_1, stream_ID.nextNode());
						adaptor.addChild(root_1, stream_index_expr.nextTree());
						adaptor.addChild(root_1, stream_index_expr.nextTree());
						adaptor.addChild(root_1, stream_stat_seq.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 5 :
					// Tiger.g:337:7: BREAK ';' !
					{
					root_0 = (Object)adaptor.nil();


					BREAK91=(Token)match(input,BREAK,FOLLOW_BREAK_in_stat1987); 
					BREAK91_tree = (Object)adaptor.create(BREAK91);
					adaptor.addChild(root_0, BREAK91_tree);

					char_literal92=(Token)match(input,SEMI,FOLLOW_SEMI_in_stat1989); 
					}
					break;
				case 6 :
					// Tiger.g:338:7: RETURN expr ';'
					{
					RETURN93=(Token)match(input,RETURN,FOLLOW_RETURN_in_stat1998);  
					stream_RETURN.add(RETURN93);

					pushFollow(FOLLOW_expr_in_stat2000);
					expr94=expr();
					state._fsp--;

					stream_expr.add(expr94.getTree());
					char_literal95=(Token)match(input,SEMI,FOLLOW_SEMI_in_stat2002);  
					stream_SEMI.add(char_literal95);

					// AST REWRITE
					// elements: expr, RETURN
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 339:9: -> ^( RETURN expr )
					{
						// Tiger.g:339:12: ^( RETURN expr )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot(stream_RETURN.nextNode(), root_1);
						adaptor.addChild(root_1, stream_expr.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 7 :
					// Tiger.g:340:7: block
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_block_in_stat2026);
					block96=block();
					state._fsp--;

					adaptor.addChild(root_0, block96.getTree());

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
		return retval;
	}
	// $ANTLR end "stat"


	public static class function_args_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "function_args"
	// Tiger.g:343:1: function_args : '(' expr_list ')' -> ( expr_list )? ;
	public final TigerParser.function_args_return function_args() throws RecognitionException {
		TigerParser.function_args_return retval = new TigerParser.function_args_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal97=null;
		Token char_literal99=null;
		ParserRuleReturnScope expr_list98 =null;

		Object char_literal97_tree=null;
		Object char_literal99_tree=null;
		RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
		RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
		RewriteRuleSubtreeStream stream_expr_list=new RewriteRuleSubtreeStream(adaptor,"rule expr_list");

		try {
			// Tiger.g:344:5: ( '(' expr_list ')' -> ( expr_list )? )
			// Tiger.g:344:7: '(' expr_list ')'
			{
			char_literal97=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_function_args2043);  
			stream_LPAREN.add(char_literal97);

			pushFollow(FOLLOW_expr_list_in_function_args2045);
			expr_list98=expr_list();
			state._fsp--;

			stream_expr_list.add(expr_list98.getTree());
			char_literal99=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_function_args2047);  
			stream_RPAREN.add(char_literal99);

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
			// 345:9: -> ( expr_list )?
			{
				// Tiger.g:345:12: ( expr_list )?
				if ( stream_expr_list.hasNext() ) {
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
		return retval;
	}
	// $ANTLR end "function_args"


	public static class function_call_or_assignment_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "function_call_or_assignment"
	// Tiger.g:348:1: function_call_or_assignment : ID ( function_args -> ^( FUNCTION_CALL ID ( function_args )? ) | value_tail ':=' expr_or_function_call -> ^( ':=' ^( ID ( value_tail )? ) expr_or_function_call ) ) ';' ;
	public final TigerParser.function_call_or_assignment_return function_call_or_assignment() throws RecognitionException {
		TigerParser.function_call_or_assignment_return retval = new TigerParser.function_call_or_assignment_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ID100=null;
		Token string_literal103=null;
		Token char_literal105=null;
		ParserRuleReturnScope function_args101 =null;
		ParserRuleReturnScope value_tail102 =null;
		ParserRuleReturnScope expr_or_function_call104 =null;

		Object ID100_tree=null;
		Object string_literal103_tree=null;
		Object char_literal105_tree=null;
		RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_ASSIGN=new RewriteRuleTokenStream(adaptor,"token ASSIGN");
		RewriteRuleSubtreeStream stream_expr_or_function_call=new RewriteRuleSubtreeStream(adaptor,"rule expr_or_function_call");
		RewriteRuleSubtreeStream stream_value_tail=new RewriteRuleSubtreeStream(adaptor,"rule value_tail");
		RewriteRuleSubtreeStream stream_function_args=new RewriteRuleSubtreeStream(adaptor,"rule function_args");

		try {
			// Tiger.g:349:5: ( ID ( function_args -> ^( FUNCTION_CALL ID ( function_args )? ) | value_tail ':=' expr_or_function_call -> ^( ':=' ^( ID ( value_tail )? ) expr_or_function_call ) ) ';' )
			// Tiger.g:349:7: ID ( function_args -> ^( FUNCTION_CALL ID ( function_args )? ) | value_tail ':=' expr_or_function_call -> ^( ':=' ^( ID ( value_tail )? ) expr_or_function_call ) ) ';'
			{
			ID100=(Token)match(input,ID,FOLLOW_ID_in_function_call_or_assignment2077);  
			stream_ID.add(ID100);

			// Tiger.g:350:9: ( function_args -> ^( FUNCTION_CALL ID ( function_args )? ) | value_tail ':=' expr_or_function_call -> ^( ':=' ^( ID ( value_tail )? ) expr_or_function_call ) )
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( (LA18_0==LPAREN) ) {
				alt18=1;
			}
			else if ( (LA18_0==AND||LA18_0==ASSIGN||LA18_0==COMMA||(LA18_0 >= DIV && LA18_0 <= DO)||LA18_0==EQ||(LA18_0 >= GREATER && LA18_0 <= GREATEREQ)||(LA18_0 >= LBRACK && LA18_0 <= LESSEREQ)||(LA18_0 >= MINUS && LA18_0 <= NEQ)||LA18_0==OR||LA18_0==PLUS||(LA18_0 >= RPAREN && LA18_0 <= THEN)) ) {
				alt18=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 18, 0, input);
				throw nvae;
			}

			switch (alt18) {
				case 1 :
					// Tiger.g:350:10: function_args
					{
					pushFollow(FOLLOW_function_args_in_function_call_or_assignment2089);
					function_args101=function_args();
					state._fsp--;

					stream_function_args.add(function_args101.getTree());
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
					// 351:13: -> ^( FUNCTION_CALL ID ( function_args )? )
					{
						// Tiger.g:351:16: ^( FUNCTION_CALL ID ( function_args )? )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNCTION_CALL, "FUNCTION_CALL"), root_1);
						adaptor.addChild(root_1, stream_ID.nextNode());
						// Tiger.g:351:35: ( function_args )?
						if ( stream_function_args.hasNext() ) {
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
					// Tiger.g:352:11: value_tail ':=' expr_or_function_call
					{
					pushFollow(FOLLOW_value_tail_in_function_call_or_assignment2124);
					value_tail102=value_tail();
					state._fsp--;

					stream_value_tail.add(value_tail102.getTree());
					string_literal103=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_function_call_or_assignment2126);  
					stream_ASSIGN.add(string_literal103);

					pushFollow(FOLLOW_expr_or_function_call_in_function_call_or_assignment2128);
					expr_or_function_call104=expr_or_function_call();
					state._fsp--;

					stream_expr_or_function_call.add(expr_or_function_call104.getTree());
					// AST REWRITE
					// elements: ASSIGN, expr_or_function_call, value_tail, ID
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 353:13: -> ^( ':=' ^( ID ( value_tail )? ) expr_or_function_call )
					{
						// Tiger.g:353:16: ^( ':=' ^( ID ( value_tail )? ) expr_or_function_call )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot(stream_ASSIGN.nextNode(), root_1);
						// Tiger.g:353:23: ^( ID ( value_tail )? )
						{
						Object root_2 = (Object)adaptor.nil();
						root_2 = (Object)adaptor.becomeRoot(stream_ID.nextNode(), root_2);
						// Tiger.g:353:28: ( value_tail )?
						if ( stream_value_tail.hasNext() ) {
							adaptor.addChild(root_2, stream_value_tail.nextTree());
						}
						stream_value_tail.reset();

						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_1, stream_expr_or_function_call.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;

			}

			char_literal105=(Token)match(input,SEMI,FOLLOW_SEMI_in_function_call_or_assignment2167);  
			stream_SEMI.add(char_literal105);

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
		return retval;
	}
	// $ANTLR end "function_call_or_assignment"


	public static class expr_or_function_call_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expr_or_function_call"
	// Tiger.g:357:1: expr_or_function_call : ( ID ( expr_with_start_id[$ID] -> ^( EXPR_WITH_START_ID ( expr_with_start_id )? ) | function_args -> ^( FUNCTION_CALL ID ( function_args )? ) ) | expr_no_start_id );
	public final TigerParser.expr_or_function_call_return expr_or_function_call() throws RecognitionException {
		TigerParser.expr_or_function_call_return retval = new TigerParser.expr_or_function_call_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ID106=null;
		ParserRuleReturnScope expr_with_start_id107 =null;
		ParserRuleReturnScope function_args108 =null;
		ParserRuleReturnScope expr_no_start_id109 =null;

		Object ID106_tree=null;
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleSubtreeStream stream_expr_with_start_id=new RewriteRuleSubtreeStream(adaptor,"rule expr_with_start_id");
		RewriteRuleSubtreeStream stream_function_args=new RewriteRuleSubtreeStream(adaptor,"rule function_args");

		try {
			// Tiger.g:358:5: ( ID ( expr_with_start_id[$ID] -> ^( EXPR_WITH_START_ID ( expr_with_start_id )? ) | function_args -> ^( FUNCTION_CALL ID ( function_args )? ) ) | expr_no_start_id )
			int alt20=2;
			int LA20_0 = input.LA(1);
			if ( (LA20_0==ID) ) {
				alt20=1;
			}
			else if ( (LA20_0==FIXEDPTLIT||LA20_0==INTLIT||LA20_0==LPAREN) ) {
				alt20=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 20, 0, input);
				throw nvae;
			}

			switch (alt20) {
				case 1 :
					// Tiger.g:358:7: ID ( expr_with_start_id[$ID] -> ^( EXPR_WITH_START_ID ( expr_with_start_id )? ) | function_args -> ^( FUNCTION_CALL ID ( function_args )? ) )
					{
					ID106=(Token)match(input,ID,FOLLOW_ID_in_expr_or_function_call2184);  
					stream_ID.add(ID106);

					// Tiger.g:359:9: ( expr_with_start_id[$ID] -> ^( EXPR_WITH_START_ID ( expr_with_start_id )? ) | function_args -> ^( FUNCTION_CALL ID ( function_args )? ) )
					int alt19=2;
					int LA19_0 = input.LA(1);
					if ( (LA19_0==AND||LA19_0==ASSIGN||LA19_0==COMMA||(LA19_0 >= DIV && LA19_0 <= DO)||LA19_0==EQ||(LA19_0 >= GREATER && LA19_0 <= GREATEREQ)||(LA19_0 >= LBRACK && LA19_0 <= LESSEREQ)||(LA19_0 >= MINUS && LA19_0 <= NEQ)||LA19_0==OR||LA19_0==PLUS||(LA19_0 >= RPAREN && LA19_0 <= THEN)) ) {
						alt19=1;
					}
					else if ( (LA19_0==LPAREN) ) {
						alt19=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 19, 0, input);
						throw nvae;
					}

					switch (alt19) {
						case 1 :
							// Tiger.g:359:10: expr_with_start_id[$ID]
							{
							pushFollow(FOLLOW_expr_with_start_id_in_expr_or_function_call2196);
							expr_with_start_id107=expr_with_start_id(ID106);
							state._fsp--;

							stream_expr_with_start_id.add(expr_with_start_id107.getTree());
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
							// 360:3: -> ^( EXPR_WITH_START_ID ( expr_with_start_id )? )
							{
								// Tiger.g:360:6: ^( EXPR_WITH_START_ID ( expr_with_start_id )? )
								{
								Object root_1 = (Object)adaptor.nil();
								root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EXPR_WITH_START_ID, "EXPR_WITH_START_ID"), root_1);
								// Tiger.g:360:27: ( expr_with_start_id )?
								if ( stream_expr_with_start_id.hasNext() ) {
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
							// Tiger.g:361:11: function_args
							{
							pushFollow(FOLLOW_function_args_in_expr_or_function_call2221);
							function_args108=function_args();
							state._fsp--;

							stream_function_args.add(function_args108.getTree());
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
							// 362:13: -> ^( FUNCTION_CALL ID ( function_args )? )
							{
								// Tiger.g:362:16: ^( FUNCTION_CALL ID ( function_args )? )
								{
								Object root_1 = (Object)adaptor.nil();
								root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNCTION_CALL, "FUNCTION_CALL"), root_1);
								adaptor.addChild(root_1, stream_ID.nextNode());
								// Tiger.g:362:35: ( function_args )?
								if ( stream_function_args.hasNext() ) {
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

					}
					break;
				case 2 :
					// Tiger.g:364:7: expr_no_start_id
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_expr_no_start_id_in_expr_or_function_call2262);
					expr_no_start_id109=expr_no_start_id();
					state._fsp--;

					adaptor.addChild(root_0, expr_no_start_id109.getTree());

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
		return retval;
	}
	// $ANTLR end "expr_or_function_call"


	public static class expr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expr"
	// Tiger.g:368:1: expr : term4 ( and_operator ^ term4 )* ;
	public final TigerParser.expr_return expr() throws RecognitionException {
		TigerParser.expr_return retval = new TigerParser.expr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope term4110 =null;
		ParserRuleReturnScope and_operator111 =null;
		ParserRuleReturnScope term4112 =null;


		try {
			// Tiger.g:369:5: ( term4 ( and_operator ^ term4 )* )
			// Tiger.g:369:7: term4 ( and_operator ^ term4 )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_term4_in_expr2282);
			term4110=term4();
			state._fsp--;

			adaptor.addChild(root_0, term4110.getTree());

			// Tiger.g:369:13: ( and_operator ^ term4 )*
			loop21:
			while (true) {
				int alt21=2;
				int LA21_0 = input.LA(1);
				if ( (LA21_0==AND||LA21_0==OR) ) {
					alt21=1;
				}

				switch (alt21) {
				case 1 :
					// Tiger.g:369:14: and_operator ^ term4
					{
					pushFollow(FOLLOW_and_operator_in_expr2285);
					and_operator111=and_operator();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(and_operator111.getTree(), root_0);
					pushFollow(FOLLOW_term4_in_expr2288);
					term4112=term4();
					state._fsp--;

					adaptor.addChild(root_0, term4112.getTree());

					}
					break;

				default :
					break loop21;
				}
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
		return retval;
	}
	// $ANTLR end "expr"


	public static class term4_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "term4"
	// Tiger.g:370:1: term4 : term3 ( compare_operator ^ term3 )* ;
	public final TigerParser.term4_return term4() throws RecognitionException {
		TigerParser.term4_return retval = new TigerParser.term4_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope term3113 =null;
		ParserRuleReturnScope compare_operator114 =null;
		ParserRuleReturnScope term3115 =null;


		try {
			// Tiger.g:371:5: ( term3 ( compare_operator ^ term3 )* )
			// Tiger.g:371:7: term3 ( compare_operator ^ term3 )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_term3_in_term42303);
			term3113=term3();
			state._fsp--;

			adaptor.addChild(root_0, term3113.getTree());

			// Tiger.g:371:13: ( compare_operator ^ term3 )*
			loop22:
			while (true) {
				int alt22=2;
				int LA22_0 = input.LA(1);
				if ( (LA22_0==EQ||(LA22_0 >= GREATER && LA22_0 <= GREATEREQ)||(LA22_0 >= LESSER && LA22_0 <= LESSEREQ)||LA22_0==NEQ) ) {
					alt22=1;
				}

				switch (alt22) {
				case 1 :
					// Tiger.g:371:14: compare_operator ^ term3
					{
					pushFollow(FOLLOW_compare_operator_in_term42306);
					compare_operator114=compare_operator();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(compare_operator114.getTree(), root_0);
					pushFollow(FOLLOW_term3_in_term42309);
					term3115=term3();
					state._fsp--;

					adaptor.addChild(root_0, term3115.getTree());

					}
					break;

				default :
					break loop22;
				}
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
		return retval;
	}
	// $ANTLR end "term4"


	public static class term3_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "term3"
	// Tiger.g:372:1: term3 : term2 ( add_operator ^ term2 )* ;
	public final TigerParser.term3_return term3() throws RecognitionException {
		TigerParser.term3_return retval = new TigerParser.term3_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope term2116 =null;
		ParserRuleReturnScope add_operator117 =null;
		ParserRuleReturnScope term2118 =null;


		try {
			// Tiger.g:373:5: ( term2 ( add_operator ^ term2 )* )
			// Tiger.g:373:7: term2 ( add_operator ^ term2 )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_term2_in_term32324);
			term2116=term2();
			state._fsp--;

			adaptor.addChild(root_0, term2116.getTree());

			// Tiger.g:373:13: ( add_operator ^ term2 )*
			loop23:
			while (true) {
				int alt23=2;
				int LA23_0 = input.LA(1);
				if ( (LA23_0==MINUS||LA23_0==PLUS) ) {
					alt23=1;
				}

				switch (alt23) {
				case 1 :
					// Tiger.g:373:14: add_operator ^ term2
					{
					pushFollow(FOLLOW_add_operator_in_term32327);
					add_operator117=add_operator();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(add_operator117.getTree(), root_0);
					pushFollow(FOLLOW_term2_in_term32330);
					term2118=term2();
					state._fsp--;

					adaptor.addChild(root_0, term2118.getTree());

					}
					break;

				default :
					break loop23;
				}
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
		return retval;
	}
	// $ANTLR end "term3"


	public static class term2_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "term2"
	// Tiger.g:374:1: term2 : term1 ( mult_operator ^ term1 )* ;
	public final TigerParser.term2_return term2() throws RecognitionException {
		TigerParser.term2_return retval = new TigerParser.term2_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope term1119 =null;
		ParserRuleReturnScope mult_operator120 =null;
		ParserRuleReturnScope term1121 =null;


		try {
			// Tiger.g:375:5: ( term1 ( mult_operator ^ term1 )* )
			// Tiger.g:375:7: term1 ( mult_operator ^ term1 )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_term1_in_term22345);
			term1119=term1();
			state._fsp--;

			adaptor.addChild(root_0, term1119.getTree());

			// Tiger.g:375:13: ( mult_operator ^ term1 )*
			loop24:
			while (true) {
				int alt24=2;
				int LA24_0 = input.LA(1);
				if ( (LA24_0==DIV||LA24_0==MULT) ) {
					alt24=1;
				}

				switch (alt24) {
				case 1 :
					// Tiger.g:375:14: mult_operator ^ term1
					{
					pushFollow(FOLLOW_mult_operator_in_term22348);
					mult_operator120=mult_operator();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(mult_operator120.getTree(), root_0);
					pushFollow(FOLLOW_term1_in_term22351);
					term1121=term1();
					state._fsp--;

					adaptor.addChild(root_0, term1121.getTree());

					}
					break;

				default :
					break loop24;
				}
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
		return retval;
	}
	// $ANTLR end "term2"


	public static class term1_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "term1"
	// Tiger.g:376:1: term1 : ( literal | value | '(' expr ')' -> expr );
	public final TigerParser.term1_return term1() throws RecognitionException {
		TigerParser.term1_return retval = new TigerParser.term1_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal124=null;
		Token char_literal126=null;
		ParserRuleReturnScope literal122 =null;
		ParserRuleReturnScope value123 =null;
		ParserRuleReturnScope expr125 =null;

		Object char_literal124_tree=null;
		Object char_literal126_tree=null;
		RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
		RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// Tiger.g:377:5: ( literal | value | '(' expr ')' -> expr )
			int alt25=3;
			switch ( input.LA(1) ) {
			case FIXEDPTLIT:
			case INTLIT:
				{
				alt25=1;
				}
				break;
			case ID:
				{
				alt25=2;
				}
				break;
			case LPAREN:
				{
				alt25=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 25, 0, input);
				throw nvae;
			}
			switch (alt25) {
				case 1 :
					// Tiger.g:377:7: literal
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_literal_in_term12365);
					literal122=literal();
					state._fsp--;

					adaptor.addChild(root_0, literal122.getTree());

					}
					break;
				case 2 :
					// Tiger.g:378:7: value
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_value_in_term12373);
					value123=value();
					state._fsp--;

					adaptor.addChild(root_0, value123.getTree());

					}
					break;
				case 3 :
					// Tiger.g:379:7: '(' expr ')'
					{
					char_literal124=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_term12381);  
					stream_LPAREN.add(char_literal124);

					pushFollow(FOLLOW_expr_in_term12383);
					expr125=expr();
					state._fsp--;

					stream_expr.add(expr125.getTree());
					char_literal126=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_term12385);  
					stream_RPAREN.add(char_literal126);

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
					// 380:9: -> expr
					{
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
		return retval;
	}
	// $ANTLR end "term1"


	public static class expr_no_start_id_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expr_no_start_id"
	// Tiger.g:383:1: expr_no_start_id : term4_no_start_id ( and_operator ^ term4 )* ;
	public final TigerParser.expr_no_start_id_return expr_no_start_id() throws RecognitionException {
		TigerParser.expr_no_start_id_return retval = new TigerParser.expr_no_start_id_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope term4_no_start_id127 =null;
		ParserRuleReturnScope and_operator128 =null;
		ParserRuleReturnScope term4129 =null;


		try {
			// Tiger.g:384:5: ( term4_no_start_id ( and_operator ^ term4 )* )
			// Tiger.g:384:7: term4_no_start_id ( and_operator ^ term4 )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_term4_no_start_id_in_expr_no_start_id2415);
			term4_no_start_id127=term4_no_start_id();
			state._fsp--;

			adaptor.addChild(root_0, term4_no_start_id127.getTree());

			// Tiger.g:384:25: ( and_operator ^ term4 )*
			loop26:
			while (true) {
				int alt26=2;
				int LA26_0 = input.LA(1);
				if ( (LA26_0==AND||LA26_0==OR) ) {
					alt26=1;
				}

				switch (alt26) {
				case 1 :
					// Tiger.g:384:26: and_operator ^ term4
					{
					pushFollow(FOLLOW_and_operator_in_expr_no_start_id2418);
					and_operator128=and_operator();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(and_operator128.getTree(), root_0);
					pushFollow(FOLLOW_term4_in_expr_no_start_id2421);
					term4129=term4();
					state._fsp--;

					adaptor.addChild(root_0, term4129.getTree());

					}
					break;

				default :
					break loop26;
				}
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
		return retval;
	}
	// $ANTLR end "expr_no_start_id"


	public static class term4_no_start_id_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "term4_no_start_id"
	// Tiger.g:385:1: term4_no_start_id : term3_no_start_id ( compare_operator ^ term3 )* ;
	public final TigerParser.term4_no_start_id_return term4_no_start_id() throws RecognitionException {
		TigerParser.term4_no_start_id_return retval = new TigerParser.term4_no_start_id_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope term3_no_start_id130 =null;
		ParserRuleReturnScope compare_operator131 =null;
		ParserRuleReturnScope term3132 =null;


		try {
			// Tiger.g:386:5: ( term3_no_start_id ( compare_operator ^ term3 )* )
			// Tiger.g:386:7: term3_no_start_id ( compare_operator ^ term3 )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_term3_no_start_id_in_term4_no_start_id2436);
			term3_no_start_id130=term3_no_start_id();
			state._fsp--;

			adaptor.addChild(root_0, term3_no_start_id130.getTree());

			// Tiger.g:386:25: ( compare_operator ^ term3 )*
			loop27:
			while (true) {
				int alt27=2;
				int LA27_0 = input.LA(1);
				if ( (LA27_0==EQ||(LA27_0 >= GREATER && LA27_0 <= GREATEREQ)||(LA27_0 >= LESSER && LA27_0 <= LESSEREQ)||LA27_0==NEQ) ) {
					alt27=1;
				}

				switch (alt27) {
				case 1 :
					// Tiger.g:386:26: compare_operator ^ term3
					{
					pushFollow(FOLLOW_compare_operator_in_term4_no_start_id2439);
					compare_operator131=compare_operator();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(compare_operator131.getTree(), root_0);
					pushFollow(FOLLOW_term3_in_term4_no_start_id2442);
					term3132=term3();
					state._fsp--;

					adaptor.addChild(root_0, term3132.getTree());

					}
					break;

				default :
					break loop27;
				}
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
		return retval;
	}
	// $ANTLR end "term4_no_start_id"


	public static class term3_no_start_id_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "term3_no_start_id"
	// Tiger.g:387:1: term3_no_start_id : term2_no_start_id ( add_operator ^ term2 )* ;
	public final TigerParser.term3_no_start_id_return term3_no_start_id() throws RecognitionException {
		TigerParser.term3_no_start_id_return retval = new TigerParser.term3_no_start_id_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope term2_no_start_id133 =null;
		ParserRuleReturnScope add_operator134 =null;
		ParserRuleReturnScope term2135 =null;


		try {
			// Tiger.g:388:5: ( term2_no_start_id ( add_operator ^ term2 )* )
			// Tiger.g:388:7: term2_no_start_id ( add_operator ^ term2 )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_term2_no_start_id_in_term3_no_start_id2457);
			term2_no_start_id133=term2_no_start_id();
			state._fsp--;

			adaptor.addChild(root_0, term2_no_start_id133.getTree());

			// Tiger.g:388:25: ( add_operator ^ term2 )*
			loop28:
			while (true) {
				int alt28=2;
				int LA28_0 = input.LA(1);
				if ( (LA28_0==MINUS||LA28_0==PLUS) ) {
					alt28=1;
				}

				switch (alt28) {
				case 1 :
					// Tiger.g:388:26: add_operator ^ term2
					{
					pushFollow(FOLLOW_add_operator_in_term3_no_start_id2460);
					add_operator134=add_operator();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(add_operator134.getTree(), root_0);
					pushFollow(FOLLOW_term2_in_term3_no_start_id2463);
					term2135=term2();
					state._fsp--;

					adaptor.addChild(root_0, term2135.getTree());

					}
					break;

				default :
					break loop28;
				}
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
		return retval;
	}
	// $ANTLR end "term3_no_start_id"


	public static class term2_no_start_id_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "term2_no_start_id"
	// Tiger.g:389:1: term2_no_start_id : term1_no_start_id ( mult_operator ^ term1 )* ;
	public final TigerParser.term2_no_start_id_return term2_no_start_id() throws RecognitionException {
		TigerParser.term2_no_start_id_return retval = new TigerParser.term2_no_start_id_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope term1_no_start_id136 =null;
		ParserRuleReturnScope mult_operator137 =null;
		ParserRuleReturnScope term1138 =null;


		try {
			// Tiger.g:390:5: ( term1_no_start_id ( mult_operator ^ term1 )* )
			// Tiger.g:390:7: term1_no_start_id ( mult_operator ^ term1 )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_term1_no_start_id_in_term2_no_start_id2478);
			term1_no_start_id136=term1_no_start_id();
			state._fsp--;

			adaptor.addChild(root_0, term1_no_start_id136.getTree());

			// Tiger.g:390:25: ( mult_operator ^ term1 )*
			loop29:
			while (true) {
				int alt29=2;
				int LA29_0 = input.LA(1);
				if ( (LA29_0==DIV||LA29_0==MULT) ) {
					alt29=1;
				}

				switch (alt29) {
				case 1 :
					// Tiger.g:390:26: mult_operator ^ term1
					{
					pushFollow(FOLLOW_mult_operator_in_term2_no_start_id2481);
					mult_operator137=mult_operator();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(mult_operator137.getTree(), root_0);
					pushFollow(FOLLOW_term1_in_term2_no_start_id2484);
					term1138=term1();
					state._fsp--;

					adaptor.addChild(root_0, term1138.getTree());

					}
					break;

				default :
					break loop29;
				}
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
		return retval;
	}
	// $ANTLR end "term2_no_start_id"


	public static class term1_no_start_id_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "term1_no_start_id"
	// Tiger.g:391:1: term1_no_start_id : ( literal | '(' expr ')' -> expr );
	public final TigerParser.term1_no_start_id_return term1_no_start_id() throws RecognitionException {
		TigerParser.term1_no_start_id_return retval = new TigerParser.term1_no_start_id_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal140=null;
		Token char_literal142=null;
		ParserRuleReturnScope literal139 =null;
		ParserRuleReturnScope expr141 =null;

		Object char_literal140_tree=null;
		Object char_literal142_tree=null;
		RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
		RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// Tiger.g:392:5: ( literal | '(' expr ')' -> expr )
			int alt30=2;
			int LA30_0 = input.LA(1);
			if ( (LA30_0==FIXEDPTLIT||LA30_0==INTLIT) ) {
				alt30=1;
			}
			else if ( (LA30_0==LPAREN) ) {
				alt30=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 30, 0, input);
				throw nvae;
			}

			switch (alt30) {
				case 1 :
					// Tiger.g:392:7: literal
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_literal_in_term1_no_start_id2498);
					literal139=literal();
					state._fsp--;

					adaptor.addChild(root_0, literal139.getTree());

					}
					break;
				case 2 :
					// Tiger.g:393:7: '(' expr ')'
					{
					char_literal140=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_term1_no_start_id2506);  
					stream_LPAREN.add(char_literal140);

					pushFollow(FOLLOW_expr_in_term1_no_start_id2508);
					expr141=expr();
					state._fsp--;

					stream_expr.add(expr141.getTree());
					char_literal142=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_term1_no_start_id2510);  
					stream_RPAREN.add(char_literal142);

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
					// 394:9: -> expr
					{
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
		return retval;
	}
	// $ANTLR end "term1_no_start_id"


	public static class expr_with_start_id_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expr_with_start_id"
	// Tiger.g:397:1: expr_with_start_id[Token startId] : term4_with_start_id[$startId] ( and_operator ^ term4 )* ;
	public final TigerParser.expr_with_start_id_return expr_with_start_id(Token startId) throws RecognitionException {
		TigerParser.expr_with_start_id_return retval = new TigerParser.expr_with_start_id_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope term4_with_start_id143 =null;
		ParserRuleReturnScope and_operator144 =null;
		ParserRuleReturnScope term4145 =null;


		try {
			// Tiger.g:398:5: ( term4_with_start_id[$startId] ( and_operator ^ term4 )* )
			// Tiger.g:398:7: term4_with_start_id[$startId] ( and_operator ^ term4 )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_term4_with_start_id_in_expr_with_start_id2541);
			term4_with_start_id143=term4_with_start_id(startId);
			state._fsp--;

			adaptor.addChild(root_0, term4_with_start_id143.getTree());

			// Tiger.g:398:37: ( and_operator ^ term4 )*
			loop31:
			while (true) {
				int alt31=2;
				int LA31_0 = input.LA(1);
				if ( (LA31_0==AND||LA31_0==OR) ) {
					alt31=1;
				}

				switch (alt31) {
				case 1 :
					// Tiger.g:398:38: and_operator ^ term4
					{
					pushFollow(FOLLOW_and_operator_in_expr_with_start_id2545);
					and_operator144=and_operator();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(and_operator144.getTree(), root_0);
					pushFollow(FOLLOW_term4_in_expr_with_start_id2548);
					term4145=term4();
					state._fsp--;

					adaptor.addChild(root_0, term4145.getTree());

					}
					break;

				default :
					break loop31;
				}
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
		return retval;
	}
	// $ANTLR end "expr_with_start_id"


	public static class term4_with_start_id_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "term4_with_start_id"
	// Tiger.g:399:1: term4_with_start_id[Token startId] : term3_with_start_id[$startId] ( compare_operator ^ term3 )* ;
	public final TigerParser.term4_with_start_id_return term4_with_start_id(Token startId) throws RecognitionException {
		TigerParser.term4_with_start_id_return retval = new TigerParser.term4_with_start_id_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope term3_with_start_id146 =null;
		ParserRuleReturnScope compare_operator147 =null;
		ParserRuleReturnScope term3148 =null;


		try {
			// Tiger.g:400:5: ( term3_with_start_id[$startId] ( compare_operator ^ term3 )* )
			// Tiger.g:400:7: term3_with_start_id[$startId] ( compare_operator ^ term3 )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_term3_with_start_id_in_term4_with_start_id2564);
			term3_with_start_id146=term3_with_start_id(startId);
			state._fsp--;

			adaptor.addChild(root_0, term3_with_start_id146.getTree());

			// Tiger.g:400:37: ( compare_operator ^ term3 )*
			loop32:
			while (true) {
				int alt32=2;
				int LA32_0 = input.LA(1);
				if ( (LA32_0==EQ||(LA32_0 >= GREATER && LA32_0 <= GREATEREQ)||(LA32_0 >= LESSER && LA32_0 <= LESSEREQ)||LA32_0==NEQ) ) {
					alt32=1;
				}

				switch (alt32) {
				case 1 :
					// Tiger.g:400:38: compare_operator ^ term3
					{
					pushFollow(FOLLOW_compare_operator_in_term4_with_start_id2568);
					compare_operator147=compare_operator();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(compare_operator147.getTree(), root_0);
					pushFollow(FOLLOW_term3_in_term4_with_start_id2571);
					term3148=term3();
					state._fsp--;

					adaptor.addChild(root_0, term3148.getTree());

					}
					break;

				default :
					break loop32;
				}
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
		return retval;
	}
	// $ANTLR end "term4_with_start_id"


	public static class term3_with_start_id_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "term3_with_start_id"
	// Tiger.g:401:1: term3_with_start_id[Token startId] : term2_with_start_id[$startId] ( add_operator ^ term2 )* ;
	public final TigerParser.term3_with_start_id_return term3_with_start_id(Token startId) throws RecognitionException {
		TigerParser.term3_with_start_id_return retval = new TigerParser.term3_with_start_id_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope term2_with_start_id149 =null;
		ParserRuleReturnScope add_operator150 =null;
		ParserRuleReturnScope term2151 =null;


		try {
			// Tiger.g:402:5: ( term2_with_start_id[$startId] ( add_operator ^ term2 )* )
			// Tiger.g:402:7: term2_with_start_id[$startId] ( add_operator ^ term2 )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_term2_with_start_id_in_term3_with_start_id2587);
			term2_with_start_id149=term2_with_start_id(startId);
			state._fsp--;

			adaptor.addChild(root_0, term2_with_start_id149.getTree());

			// Tiger.g:402:37: ( add_operator ^ term2 )*
			loop33:
			while (true) {
				int alt33=2;
				int LA33_0 = input.LA(1);
				if ( (LA33_0==MINUS||LA33_0==PLUS) ) {
					alt33=1;
				}

				switch (alt33) {
				case 1 :
					// Tiger.g:402:38: add_operator ^ term2
					{
					pushFollow(FOLLOW_add_operator_in_term3_with_start_id2591);
					add_operator150=add_operator();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(add_operator150.getTree(), root_0);
					pushFollow(FOLLOW_term2_in_term3_with_start_id2594);
					term2151=term2();
					state._fsp--;

					adaptor.addChild(root_0, term2151.getTree());

					}
					break;

				default :
					break loop33;
				}
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
		return retval;
	}
	// $ANTLR end "term3_with_start_id"


	public static class term2_with_start_id_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "term2_with_start_id"
	// Tiger.g:403:1: term2_with_start_id[Token startId] : term1_with_start_id[$startId] ( mult_operator ^ term1 )* ;
	public final TigerParser.term2_with_start_id_return term2_with_start_id(Token startId) throws RecognitionException {
		TigerParser.term2_with_start_id_return retval = new TigerParser.term2_with_start_id_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope term1_with_start_id152 =null;
		ParserRuleReturnScope mult_operator153 =null;
		ParserRuleReturnScope term1154 =null;


		try {
			// Tiger.g:404:5: ( term1_with_start_id[$startId] ( mult_operator ^ term1 )* )
			// Tiger.g:404:7: term1_with_start_id[$startId] ( mult_operator ^ term1 )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_term1_with_start_id_in_term2_with_start_id2610);
			term1_with_start_id152=term1_with_start_id(startId);
			state._fsp--;

			adaptor.addChild(root_0, term1_with_start_id152.getTree());

			// Tiger.g:404:37: ( mult_operator ^ term1 )*
			loop34:
			while (true) {
				int alt34=2;
				int LA34_0 = input.LA(1);
				if ( (LA34_0==DIV||LA34_0==MULT) ) {
					alt34=1;
				}

				switch (alt34) {
				case 1 :
					// Tiger.g:404:38: mult_operator ^ term1
					{
					pushFollow(FOLLOW_mult_operator_in_term2_with_start_id2614);
					mult_operator153=mult_operator();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(mult_operator153.getTree(), root_0);
					pushFollow(FOLLOW_term1_in_term2_with_start_id2617);
					term1154=term1();
					state._fsp--;

					adaptor.addChild(root_0, term1154.getTree());

					}
					break;

				default :
					break loop34;
				}
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
		return retval;
	}
	// $ANTLR end "term2_with_start_id"


	public static class term1_with_start_id_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "term1_with_start_id"
	// Tiger.g:405:1: term1_with_start_id[Token startId] : value_tail -> ^( ( value_tail )? ) ;
	public final TigerParser.term1_with_start_id_return term1_with_start_id(Token startId) throws RecognitionException {
		TigerParser.term1_with_start_id_return retval = new TigerParser.term1_with_start_id_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope value_tail155 =null;

		RewriteRuleSubtreeStream stream_value_tail=new RewriteRuleSubtreeStream(adaptor,"rule value_tail");

		try {
			// Tiger.g:406:5: ( value_tail -> ^( ( value_tail )? ) )
			// Tiger.g:406:7: value_tail
			{
			pushFollow(FOLLOW_value_tail_in_term1_with_start_id2632);
			value_tail155=value_tail();
			state._fsp--;

			stream_value_tail.add(value_tail155.getTree());
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
			// 406:18: -> ^( ( value_tail )? )
			{
				// Tiger.g:406:21: ^( ( value_tail )? )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot(new CommonTree(startId), root_1);
				// Tiger.g:406:50: ( value_tail )?
				if ( stream_value_tail.hasNext() ) {
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
		return retval;
	}
	// $ANTLR end "term1_with_start_id"


	public static class expr_list_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expr_list"
	// Tiger.g:409:1: expr_list : ( expr ( ',' expr )* -> ^( EXPRLIST ( expr )+ ) |);
	public final TigerParser.expr_list_return expr_list() throws RecognitionException {
		TigerParser.expr_list_return retval = new TigerParser.expr_list_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal157=null;
		ParserRuleReturnScope expr156 =null;
		ParserRuleReturnScope expr158 =null;

		Object char_literal157_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// Tiger.g:410:5: ( expr ( ',' expr )* -> ^( EXPRLIST ( expr )+ ) |)
			int alt36=2;
			int LA36_0 = input.LA(1);
			if ( (LA36_0==FIXEDPTLIT||LA36_0==ID||LA36_0==INTLIT||LA36_0==LPAREN) ) {
				alt36=1;
			}
			else if ( (LA36_0==RPAREN) ) {
				alt36=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 36, 0, input);
				throw nvae;
			}

			switch (alt36) {
				case 1 :
					// Tiger.g:410:7: expr ( ',' expr )*
					{
					pushFollow(FOLLOW_expr_in_expr_list2658);
					expr156=expr();
					state._fsp--;

					stream_expr.add(expr156.getTree());
					// Tiger.g:410:12: ( ',' expr )*
					loop35:
					while (true) {
						int alt35=2;
						int LA35_0 = input.LA(1);
						if ( (LA35_0==COMMA) ) {
							alt35=1;
						}

						switch (alt35) {
						case 1 :
							// Tiger.g:410:14: ',' expr
							{
							char_literal157=(Token)match(input,COMMA,FOLLOW_COMMA_in_expr_list2662);  
							stream_COMMA.add(char_literal157);

							pushFollow(FOLLOW_expr_in_expr_list2664);
							expr158=expr();
							state._fsp--;

							stream_expr.add(expr158.getTree());
							}
							break;

						default :
							break loop35;
						}
					}

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
					// 410:26: -> ^( EXPRLIST ( expr )+ )
					{
						// Tiger.g:410:29: ^( EXPRLIST ( expr )+ )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EXPRLIST, "EXPRLIST"), root_1);
						if ( !(stream_expr.hasNext()) ) {
							throw new RewriteEarlyExitException();
						}
						while ( stream_expr.hasNext() ) {
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
					// Tiger.g:412:5: 
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
		return retval;
	}
	// $ANTLR end "expr_list"


	public static class mult_operator_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "mult_operator"
	// Tiger.g:420:1: mult_operator : ( '*' | '/' );
	public final TigerParser.mult_operator_return mult_operator() throws RecognitionException {
		TigerParser.mult_operator_return retval = new TigerParser.mult_operator_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set159=null;

		Object set159_tree=null;

		try {
			// Tiger.g:421:5: ( '*' | '/' )
			// Tiger.g:
			{
			root_0 = (Object)adaptor.nil();


			set159=input.LT(1);
			if ( input.LA(1)==DIV||input.LA(1)==MULT ) {
				input.consume();
				adaptor.addChild(root_0, (Object)adaptor.create(set159));
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
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
		return retval;
	}
	// $ANTLR end "mult_operator"


	public static class add_operator_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "add_operator"
	// Tiger.g:423:1: add_operator : ( '+' | '-' );
	public final TigerParser.add_operator_return add_operator() throws RecognitionException {
		TigerParser.add_operator_return retval = new TigerParser.add_operator_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set160=null;

		Object set160_tree=null;

		try {
			// Tiger.g:424:5: ( '+' | '-' )
			// Tiger.g:
			{
			root_0 = (Object)adaptor.nil();


			set160=input.LT(1);
			if ( input.LA(1)==MINUS||input.LA(1)==PLUS ) {
				input.consume();
				adaptor.addChild(root_0, (Object)adaptor.create(set160));
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
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
		return retval;
	}
	// $ANTLR end "add_operator"


	public static class compare_operator_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "compare_operator"
	// Tiger.g:426:1: compare_operator : ( '=' | '<>' | '<' | '>' | '<=' | '>=' );
	public final TigerParser.compare_operator_return compare_operator() throws RecognitionException {
		TigerParser.compare_operator_return retval = new TigerParser.compare_operator_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set161=null;

		Object set161_tree=null;

		try {
			// Tiger.g:427:5: ( '=' | '<>' | '<' | '>' | '<=' | '>=' )
			// Tiger.g:
			{
			root_0 = (Object)adaptor.nil();


			set161=input.LT(1);
			if ( input.LA(1)==EQ||(input.LA(1) >= GREATER && input.LA(1) <= GREATEREQ)||(input.LA(1) >= LESSER && input.LA(1) <= LESSEREQ)||input.LA(1)==NEQ ) {
				input.consume();
				adaptor.addChild(root_0, (Object)adaptor.create(set161));
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
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
		return retval;
	}
	// $ANTLR end "compare_operator"


	public static class and_operator_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "and_operator"
	// Tiger.g:429:1: and_operator : ( '&' | '|' );
	public final TigerParser.and_operator_return and_operator() throws RecognitionException {
		TigerParser.and_operator_return retval = new TigerParser.and_operator_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set162=null;

		Object set162_tree=null;

		try {
			// Tiger.g:430:5: ( '&' | '|' )
			// Tiger.g:
			{
			root_0 = (Object)adaptor.nil();


			set162=input.LT(1);
			if ( input.LA(1)==AND||input.LA(1)==OR ) {
				input.consume();
				adaptor.addChild(root_0, (Object)adaptor.create(set162));
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
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
		return retval;
	}
	// $ANTLR end "and_operator"


	public static class value_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "value"
	// Tiger.g:432:1: value : ID value_tail -> ^( ID ( value_tail )? ) ;
	public final TigerParser.value_return value() throws RecognitionException {
		TigerParser.value_return retval = new TigerParser.value_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ID163=null;
		ParserRuleReturnScope value_tail164 =null;

		Object ID163_tree=null;
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleSubtreeStream stream_value_tail=new RewriteRuleSubtreeStream(adaptor,"rule value_tail");

		try {
			// Tiger.g:433:5: ( ID value_tail -> ^( ID ( value_tail )? ) )
			// Tiger.g:433:7: ID value_tail
			{
			ID163=(Token)match(input,ID,FOLLOW_ID_in_value2791);  
			stream_ID.add(ID163);

			pushFollow(FOLLOW_value_tail_in_value2793);
			value_tail164=value_tail();
			state._fsp--;

			stream_value_tail.add(value_tail164.getTree());
			// AST REWRITE
			// elements: value_tail, ID
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 433:21: -> ^( ID ( value_tail )? )
			{
				// Tiger.g:433:24: ^( ID ( value_tail )? )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot(stream_ID.nextNode(), root_1);
				// Tiger.g:433:29: ( value_tail )?
				if ( stream_value_tail.hasNext() ) {
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
		return retval;
	}
	// $ANTLR end "value"


	public static class literal_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "literal"
	// Tiger.g:435:1: literal : ( INTLIT | FIXEDPTLIT );
	public final TigerParser.literal_return literal() throws RecognitionException {
		TigerParser.literal_return retval = new TigerParser.literal_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set165=null;

		Object set165_tree=null;

		try {
			// Tiger.g:436:5: ( INTLIT | FIXEDPTLIT )
			// Tiger.g:
			{
			root_0 = (Object)adaptor.nil();


			set165=input.LT(1);
			if ( input.LA(1)==FIXEDPTLIT||input.LA(1)==INTLIT ) {
				input.consume();
				adaptor.addChild(root_0, (Object)adaptor.create(set165));
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
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
		return retval;
	}
	// $ANTLR end "literal"


	public static class value_tail_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "value_tail"
	// Tiger.g:440:1: value_tail : ( '[' index_expr ']' ( '[' index_expr ']' )? -> ( index_expr )+ |);
	public final TigerParser.value_tail_return value_tail() throws RecognitionException {
		TigerParser.value_tail_return retval = new TigerParser.value_tail_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal166=null;
		Token char_literal168=null;
		Token char_literal169=null;
		Token char_literal171=null;
		ParserRuleReturnScope index_expr167 =null;
		ParserRuleReturnScope index_expr170 =null;

		Object char_literal166_tree=null;
		Object char_literal168_tree=null;
		Object char_literal169_tree=null;
		Object char_literal171_tree=null;
		RewriteRuleTokenStream stream_RBRACK=new RewriteRuleTokenStream(adaptor,"token RBRACK");
		RewriteRuleTokenStream stream_LBRACK=new RewriteRuleTokenStream(adaptor,"token LBRACK");
		RewriteRuleSubtreeStream stream_index_expr=new RewriteRuleSubtreeStream(adaptor,"rule index_expr");

		try {
			// Tiger.g:441:5: ( '[' index_expr ']' ( '[' index_expr ']' )? -> ( index_expr )+ |)
			int alt38=2;
			int LA38_0 = input.LA(1);
			if ( (LA38_0==LBRACK) ) {
				alt38=1;
			}
			else if ( (LA38_0==AND||LA38_0==ASSIGN||LA38_0==COMMA||(LA38_0 >= DIV && LA38_0 <= DO)||LA38_0==EQ||(LA38_0 >= GREATER && LA38_0 <= GREATEREQ)||(LA38_0 >= LESSER && LA38_0 <= LESSEREQ)||(LA38_0 >= MINUS && LA38_0 <= NEQ)||LA38_0==OR||LA38_0==PLUS||(LA38_0 >= RPAREN && LA38_0 <= THEN)) ) {
				alt38=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 38, 0, input);
				throw nvae;
			}

			switch (alt38) {
				case 1 :
					// Tiger.g:441:7: '[' index_expr ']' ( '[' index_expr ']' )?
					{
					char_literal166=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_value_tail2840);  
					stream_LBRACK.add(char_literal166);

					pushFollow(FOLLOW_index_expr_in_value_tail2842);
					index_expr167=index_expr();
					state._fsp--;

					stream_index_expr.add(index_expr167.getTree());
					char_literal168=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_value_tail2844);  
					stream_RBRACK.add(char_literal168);

					// Tiger.g:441:26: ( '[' index_expr ']' )?
					int alt37=2;
					int LA37_0 = input.LA(1);
					if ( (LA37_0==LBRACK) ) {
						alt37=1;
					}
					switch (alt37) {
						case 1 :
							// Tiger.g:441:27: '[' index_expr ']'
							{
							char_literal169=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_value_tail2847);  
							stream_LBRACK.add(char_literal169);

							pushFollow(FOLLOW_index_expr_in_value_tail2849);
							index_expr170=index_expr();
							state._fsp--;

							stream_index_expr.add(index_expr170.getTree());
							char_literal171=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_value_tail2851);  
							stream_RBRACK.add(char_literal171);

							}
							break;

					}

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
					// 442:13: -> ( index_expr )+
					{
						if ( !(stream_index_expr.hasNext()) ) {
							throw new RewriteEarlyExitException();
						}
						while ( stream_index_expr.hasNext() ) {
							adaptor.addChild(root_0, stream_index_expr.nextTree());
						}
						stream_index_expr.reset();

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// Tiger.g:444:5: 
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
		return retval;
	}
	// $ANTLR end "value_tail"


	public static class index_expr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "index_expr"
	// Tiger.g:446:1: index_expr : index_term ( add_operator ^ index_term )* ;
	public final TigerParser.index_expr_return index_expr() throws RecognitionException {
		TigerParser.index_expr_return retval = new TigerParser.index_expr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope index_term172 =null;
		ParserRuleReturnScope add_operator173 =null;
		ParserRuleReturnScope index_term174 =null;


		try {
			// Tiger.g:447:5: ( index_term ( add_operator ^ index_term )* )
			// Tiger.g:447:7: index_term ( add_operator ^ index_term )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_index_term_in_index_expr2897);
			index_term172=index_term();
			state._fsp--;

			adaptor.addChild(root_0, index_term172.getTree());

			// Tiger.g:447:18: ( add_operator ^ index_term )*
			loop39:
			while (true) {
				int alt39=2;
				int LA39_0 = input.LA(1);
				if ( (LA39_0==MINUS||LA39_0==PLUS) ) {
					alt39=1;
				}

				switch (alt39) {
				case 1 :
					// Tiger.g:447:19: add_operator ^ index_term
					{
					pushFollow(FOLLOW_add_operator_in_index_expr2900);
					add_operator173=add_operator();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(add_operator173.getTree(), root_0);
					pushFollow(FOLLOW_index_term_in_index_expr2903);
					index_term174=index_term();
					state._fsp--;

					adaptor.addChild(root_0, index_term174.getTree());

					}
					break;

				default :
					break loop39;
				}
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
		return retval;
	}
	// $ANTLR end "index_expr"


	public static class index_term_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "index_term"
	// Tiger.g:449:1: index_term : index_factor ( '*' ^ index_factor )* ;
	public final TigerParser.index_term_return index_term() throws RecognitionException {
		TigerParser.index_term_return retval = new TigerParser.index_term_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal176=null;
		ParserRuleReturnScope index_factor175 =null;
		ParserRuleReturnScope index_factor177 =null;

		Object char_literal176_tree=null;

		try {
			// Tiger.g:450:5: ( index_factor ( '*' ^ index_factor )* )
			// Tiger.g:450:7: index_factor ( '*' ^ index_factor )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_index_factor_in_index_term2919);
			index_factor175=index_factor();
			state._fsp--;

			adaptor.addChild(root_0, index_factor175.getTree());

			// Tiger.g:450:20: ( '*' ^ index_factor )*
			loop40:
			while (true) {
				int alt40=2;
				int LA40_0 = input.LA(1);
				if ( (LA40_0==MULT) ) {
					alt40=1;
				}

				switch (alt40) {
				case 1 :
					// Tiger.g:450:21: '*' ^ index_factor
					{
					char_literal176=(Token)match(input,MULT,FOLLOW_MULT_in_index_term2922); 
					char_literal176_tree = (Object)adaptor.create(char_literal176);
					root_0 = (Object)adaptor.becomeRoot(char_literal176_tree, root_0);

					pushFollow(FOLLOW_index_factor_in_index_term2925);
					index_factor177=index_factor();
					state._fsp--;

					adaptor.addChild(root_0, index_factor177.getTree());

					}
					break;

				default :
					break loop40;
				}
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
		return retval;
	}
	// $ANTLR end "index_term"


	public static class index_factor_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "index_factor"
	// Tiger.g:452:1: index_factor : ( INTLIT | ID );
	public final TigerParser.index_factor_return index_factor() throws RecognitionException {
		TigerParser.index_factor_return retval = new TigerParser.index_factor_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set178=null;

		Object set178_tree=null;

		try {
			// Tiger.g:453:5: ( INTLIT | ID )
			// Tiger.g:
			{
			root_0 = (Object)adaptor.nil();


			set178=input.LT(1);
			if ( input.LA(1)==ID||input.LA(1)==INTLIT ) {
				input.consume();
				adaptor.addChild(root_0, (Object)adaptor.create(set178));
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
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
		return retval;
	}
	// $ANTLR end "index_factor"

	// Delegated rules



	public static final BitSet FOLLOW_type_declaration_list_in_tiger_program1028 = new BitSet(new long[]{0x0000004202000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_funct_declaration_list_then_main_in_tiger_program1030 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_tiger_program1033 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VOID_in_funct_declaration_list_then_main1061 = new BitSet(new long[]{0x0001000020000000L});
	public static final BitSet FOLLOW_funct_declaration_tail_in_funct_declaration_list_then_main1065 = new BitSet(new long[]{0x0000004202000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_funct_declaration_list_then_main_in_funct_declaration_list_then_main1068 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_main_function_tail_in_funct_declaration_list_then_main1072 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_funct_declaration_list_then_main1085 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_INT_in_funct_declaration_list_then_main1089 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_FIXEDPT_in_funct_declaration_list_then_main1093 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_funct_declaration_tail_in_funct_declaration_list_then_main1096 = new BitSet(new long[]{0x0000004202000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_funct_declaration_list_then_main_in_funct_declaration_list_then_main1099 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FUNCTION_in_funct_declaration_tail1127 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_ID_in_funct_declaration_tail1129 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_LPAREN_in_funct_declaration_tail1131 = new BitSet(new long[]{0x1000000200000000L});
	public static final BitSet FOLLOW_param_list_in_funct_declaration_tail1133 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_funct_declaration_tail1135 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_BEGIN_in_funct_declaration_tail1137 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_block_list_in_funct_declaration_tail1139 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_END_in_funct_declaration_tail1141 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_SEMI_in_funct_declaration_tail1143 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MAIN_in_main_function_tail1187 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_LPAREN_in_main_function_tail1189 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_main_function_tail1191 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_BEGIN_in_main_function_tail1193 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_block_list_in_main_function_tail1195 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_END_in_main_function_tail1197 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_SEMI_in_main_function_tail1199 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_param_in_param_list1235 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_COMMA_in_param_list1241 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_param_in_param_list1245 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_ID_in_param1280 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_COLON_in_param1282 = new BitSet(new long[]{0x0000004202000000L});
	public static final BitSet FOLLOW_type_id_in_param1284 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_block_list1312 = new BitSet(new long[]{0x0000000000000082L});
	public static final BitSet FOLLOW_BEGIN_in_block1335 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000022L});
	public static final BitSet FOLLOW_declaration_segment_in_block1342 = new BitSet(new long[]{0x0800000A08000480L,0x0000000000000200L});
	public static final BitSet FOLLOW_stat_seq_in_block1344 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_END_in_block1346 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_SEMI_in_block1348 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_declaration_list_in_declaration_segment1373 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_var_declaration_list_in_declaration_segment1375 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_declaration_in_type_declaration_list1388 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
	public static final BitSet FOLLOW_var_declaration_in_var_declaration_list1421 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000020L});
	public static final BitSet FOLLOW_TYPE_in_type_declaration1451 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_ID_in_type_declaration1453 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_EQ_in_type_declaration1455 = new BitSet(new long[]{0x0000004002000020L});
	public static final BitSet FOLLOW_type_in_type_declaration1457 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_SEMI_in_type_declaration1459 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_base_type_in_type1487 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARRAY_in_type1497 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_LBRACK_in_type1499 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_INTLIT_in_type1501 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_RBRACK_in_type1503 = new BitSet(new long[]{0x0020080000000000L});
	public static final BitSet FOLLOW_LBRACK_in_type1506 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_INTLIT_in_type1508 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_RBRACK_in_type1510 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_OF_in_type1514 = new BitSet(new long[]{0x0000004002000000L});
	public static final BitSet FOLLOW_base_type_in_type1516 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_base_type_in_type_id1551 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_type_id1568 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_base_type1592 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FIXEDPT_in_base_type1603 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_var_declaration1628 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_id_list_in_var_declaration1630 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_COLON_in_var_declaration1632 = new BitSet(new long[]{0x0000004202000000L});
	public static final BitSet FOLLOW_type_id_in_var_declaration1634 = new BitSet(new long[]{0x2000000000000040L});
	public static final BitSet FOLLOW_optional_init_in_var_declaration1636 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_SEMI_in_var_declaration1638 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_id_list1680 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_COMMA_in_id_list1684 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_ID_in_id_list1688 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_ASSIGN_in_optional_init1729 = new BitSet(new long[]{0x0000008004000000L});
	public static final BitSet FOLLOW_literal_in_optional_init1731 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_stat_in_stat_seq1757 = new BitSet(new long[]{0x0800000A08000482L,0x0000000000000200L});
	public static final BitSet FOLLOW_function_call_or_assignment_in_stat1775 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_stat1783 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_expr_in_stat1785 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_THEN_in_stat1787 = new BitSet(new long[]{0x0800000A08000480L,0x0000000000000200L});
	public static final BitSet FOLLOW_stat_seq_in_stat1791 = new BitSet(new long[]{0x0000000000220000L});
	public static final BitSet FOLLOW_ELSE_in_stat1804 = new BitSet(new long[]{0x0800000A08000480L,0x0000000000000200L});
	public static final BitSet FOLLOW_stat_seq_in_stat1808 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_ENDIF_in_stat1810 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_ENDIF_in_stat1856 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat1895 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WHILE_in_stat1903 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_expr_in_stat1905 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_DO_in_stat1907 = new BitSet(new long[]{0x0800000A08000480L,0x0000000000000200L});
	public static final BitSet FOLLOW_stat_seq_in_stat1909 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ENDDO_in_stat1911 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat1913 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FOR_in_stat1939 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_ID_in_stat1941 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASSIGN_in_stat1943 = new BitSet(new long[]{0x0000008200000000L});
	public static final BitSet FOLLOW_index_expr_in_stat1945 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_TO_in_stat1947 = new BitSet(new long[]{0x0000008200000000L});
	public static final BitSet FOLLOW_index_expr_in_stat1949 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_DO_in_stat1951 = new BitSet(new long[]{0x0800000A08000480L,0x0000000000000200L});
	public static final BitSet FOLLOW_stat_seq_in_stat1953 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ENDDO_in_stat1955 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat1957 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BREAK_in_stat1987 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat1989 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RETURN_in_stat1998 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_expr_in_stat2000 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat2002 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_stat2026 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_function_args2043 = new BitSet(new long[]{0x1000808204000000L});
	public static final BitSet FOLLOW_expr_list_in_function_args2045 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_function_args2047 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_function_call_or_assignment2077 = new BitSet(new long[]{0x0000880000000040L});
	public static final BitSet FOLLOW_function_args_in_function_call_or_assignment2089 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_value_tail_in_function_call_or_assignment2124 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASSIGN_in_function_call_or_assignment2126 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_expr_or_function_call_in_function_call_or_assignment2128 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_SEMI_in_function_call_or_assignment2167 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_expr_or_function_call2184 = new BitSet(new long[]{0x0000880000000000L});
	public static final BitSet FOLLOW_expr_with_start_id_in_expr_or_function_call2196 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_args_in_expr_or_function_call2221 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_no_start_id_in_expr_or_function_call2262 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term4_in_expr2282 = new BitSet(new long[]{0x0040000000000012L});
	public static final BitSet FOLLOW_and_operator_in_expr2285 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_term4_in_expr2288 = new BitSet(new long[]{0x0040000000000012L});
	public static final BitSet FOLLOW_term3_in_term42303 = new BitSet(new long[]{0x0010300180400002L});
	public static final BitSet FOLLOW_compare_operator_in_term42306 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_term3_in_term42309 = new BitSet(new long[]{0x0010300180400002L});
	public static final BitSet FOLLOW_term2_in_term32324 = new BitSet(new long[]{0x0104000000000002L});
	public static final BitSet FOLLOW_add_operator_in_term32327 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_term2_in_term32330 = new BitSet(new long[]{0x0104000000000002L});
	public static final BitSet FOLLOW_term1_in_term22345 = new BitSet(new long[]{0x0008000000008002L});
	public static final BitSet FOLLOW_mult_operator_in_term22348 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_term1_in_term22351 = new BitSet(new long[]{0x0008000000008002L});
	public static final BitSet FOLLOW_literal_in_term12365 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_in_term12373 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_term12381 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_expr_in_term12383 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_term12385 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term4_no_start_id_in_expr_no_start_id2415 = new BitSet(new long[]{0x0040000000000012L});
	public static final BitSet FOLLOW_and_operator_in_expr_no_start_id2418 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_term4_in_expr_no_start_id2421 = new BitSet(new long[]{0x0040000000000012L});
	public static final BitSet FOLLOW_term3_no_start_id_in_term4_no_start_id2436 = new BitSet(new long[]{0x0010300180400002L});
	public static final BitSet FOLLOW_compare_operator_in_term4_no_start_id2439 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_term3_in_term4_no_start_id2442 = new BitSet(new long[]{0x0010300180400002L});
	public static final BitSet FOLLOW_term2_no_start_id_in_term3_no_start_id2457 = new BitSet(new long[]{0x0104000000000002L});
	public static final BitSet FOLLOW_add_operator_in_term3_no_start_id2460 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_term2_in_term3_no_start_id2463 = new BitSet(new long[]{0x0104000000000002L});
	public static final BitSet FOLLOW_term1_no_start_id_in_term2_no_start_id2478 = new BitSet(new long[]{0x0008000000008002L});
	public static final BitSet FOLLOW_mult_operator_in_term2_no_start_id2481 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_term1_in_term2_no_start_id2484 = new BitSet(new long[]{0x0008000000008002L});
	public static final BitSet FOLLOW_literal_in_term1_no_start_id2498 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_term1_no_start_id2506 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_expr_in_term1_no_start_id2508 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_term1_no_start_id2510 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term4_with_start_id_in_expr_with_start_id2541 = new BitSet(new long[]{0x0040000000000012L});
	public static final BitSet FOLLOW_and_operator_in_expr_with_start_id2545 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_term4_in_expr_with_start_id2548 = new BitSet(new long[]{0x0040000000000012L});
	public static final BitSet FOLLOW_term3_with_start_id_in_term4_with_start_id2564 = new BitSet(new long[]{0x0010300180400002L});
	public static final BitSet FOLLOW_compare_operator_in_term4_with_start_id2568 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_term3_in_term4_with_start_id2571 = new BitSet(new long[]{0x0010300180400002L});
	public static final BitSet FOLLOW_term2_with_start_id_in_term3_with_start_id2587 = new BitSet(new long[]{0x0104000000000002L});
	public static final BitSet FOLLOW_add_operator_in_term3_with_start_id2591 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_term2_in_term3_with_start_id2594 = new BitSet(new long[]{0x0104000000000002L});
	public static final BitSet FOLLOW_term1_with_start_id_in_term2_with_start_id2610 = new BitSet(new long[]{0x0008000000008002L});
	public static final BitSet FOLLOW_mult_operator_in_term2_with_start_id2614 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_term1_in_term2_with_start_id2617 = new BitSet(new long[]{0x0008000000008002L});
	public static final BitSet FOLLOW_value_tail_in_term1_with_start_id2632 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_expr_list2658 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_COMMA_in_expr_list2662 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_expr_in_expr_list2664 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_ID_in_value2791 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_value_tail_in_value2793 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LBRACK_in_value_tail2840 = new BitSet(new long[]{0x0000008200000000L});
	public static final BitSet FOLLOW_index_expr_in_value_tail2842 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_RBRACK_in_value_tail2844 = new BitSet(new long[]{0x0000080000000002L});
	public static final BitSet FOLLOW_LBRACK_in_value_tail2847 = new BitSet(new long[]{0x0000008200000000L});
	public static final BitSet FOLLOW_index_expr_in_value_tail2849 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_RBRACK_in_value_tail2851 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_index_term_in_index_expr2897 = new BitSet(new long[]{0x0104000000000002L});
	public static final BitSet FOLLOW_add_operator_in_index_expr2900 = new BitSet(new long[]{0x0000008200000000L});
	public static final BitSet FOLLOW_index_term_in_index_expr2903 = new BitSet(new long[]{0x0104000000000002L});
	public static final BitSet FOLLOW_index_factor_in_index_term2919 = new BitSet(new long[]{0x0008000000000002L});
	public static final BitSet FOLLOW_MULT_in_index_term2922 = new BitSet(new long[]{0x0000008200000000L});
	public static final BitSet FOLLOW_index_factor_in_index_term2925 = new BitSet(new long[]{0x0008000000000002L});
}
