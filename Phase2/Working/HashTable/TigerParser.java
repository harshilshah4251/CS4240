// $ANTLR 3.5.2 Tiger.g 2014-11-12 01:17:34

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
			SymbolTable temp = stack.removeFirst();
			if(level > 0) level--;
			return temp;
		}

		// It will get the top SymbolTable of the stack
		// which means get the SymbolTable of current scope
		public SymbolTable getTopTable() {
			return stack.getFirst();
		}

		// TODO : Make a method that saves all the SymbolTables into a file
		//		-> should include It's level too

		public void printSymbol() {
			for(int i = 0; i < tableList.size(); i++) {
				if(tableList.get(i).size() != 0){
					System.out.println("Symbol table " + i +": \n" + tableList.get(i) + "\n");}
			}
		}

		public void addToList(SymbolTable s) {
			tableList.add(s);
		}

		public Var getValue(String name) {
			boolean found = false;
			for(int i = 0; i < stack.size(); i++) {
				if(stack.get(i).containsKey(name)) {
	//				System.out.println("Symbol Found : "+ name + " "+ stack.get(i).get(name));
					return stack.get(i).get(name);
				}
			}

			System.out.println(name + ": Symbol not found in SymbolTable!\n");
			//return new Var();
			return null;
		}

		public void addSTL() {
			SymbolTable top = getTopTable();
			ArrayList<Id> paramList = new ArrayList();
			paramList.add(new Id("s", Type.String));
			top.put("print", new Function("print", Type.Void, paramList));

			paramList = new ArrayList();
			paramList.add(new Id("i", Type.Int));
			top.put("printi", new Function("printi", Type.Void, paramList));

			paramList = new ArrayList();
			top.put("flush", new Function("flush", Type.Void, paramList));

			paramList = new ArrayList();
			top.put("getchar", new Function("getchar", Type.String, paramList));

			paramList = new ArrayList();
			paramList.add(new Id("s", Type.String));
			top.put("ord", new Function("ord", Type.Int, paramList));
			
			paramList = new ArrayList();
			paramList.add(new Id("i", Type.Int));
			top.put("chr", new Function("chr", Type.String, paramList));

			paramList = new ArrayList();
			paramList.add(new Id("s", Type.String));
			top.put("size", new Function("size", Type.Int, paramList));
			
			paramList = new ArrayList();
			paramList.add(new Id("s", Type.String));
			paramList.add(new Id("f", Type.Int));
			paramList.add(new Id("n", Type.Int));
			top.put("substring", new Function("substring", Type.String, paramList));
		
			paramList = new ArrayList();
			paramList.add(new Id("s1", Type.String));
			paramList.add(new Id("s2", Type.String));
			top.put("concat", new Function("concat", Type.String, paramList));
		
			paramList = new ArrayList();
			paramList.add(new Id("i", Type.Int));
			top.put("not", new Function("not", Type.Int, paramList));

			paramList = new ArrayList();
			paramList.add(new Id("i", Type.Int));
			top.put("exit", new Function("exit", Type.Void, paramList));
		}


		// The function check if a function is used properly
		// Properly means (same parameter number, parameter types and order)
		// parameters should be initialized previously
		public void checkFuncParam(String funcName, ArrayList<String> pList) {

	System.out.println("looking for : " + funcName);
			Var func = getValue(funcName);
			if (func == null) {
				System.out.println(funcName + " function not found!");
			} else if(!(func instanceof Function)) {
				System.out.println(funcName + " is supposed to be Function type!\n");
			} else {

				ArrayList<Id> fpList = ((Function)func).getParamList();
	System.out.println(funcName + "/The parameters from symbol table are : " + fpList);
	System.out.println(funcName + "/The used parameters are : " + pList);
				// checking if the function doesn't have paramter
				// it's wrong even when either one is null
				if(fpList != null && pList != null) {
				if(pList.size() != fpList.size()) { 
					System.out.println(funcName + " has wrong number of parameter!\n");
				} else {
					for(int i = 0; i < pList.size(); i++) {
						Var id = getValue(pList.get(i));
						if(!(id instanceof Id)) {
							System.out.println(funcName + " function has wrong parameter!\n");
						} else if(!fpList.get(i).type.equals(((Id)id).type)) {
							System.out.println(funcName + " function has wrong parameter type!\n");
						} else if(((Id)id).init) {
							System.out.println(funcName + " a parameter is not initialized before use!\n");
						}
					}
				}
				}
			}
		}


	public static class tiger_program_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "tiger_program"
	// Tiger.g:303:1: tiger_program : type_declaration_list funct_declaration_list_then_main EOF -> ^( PROGRAM type_declaration_list funct_declaration_list_then_main ) ;
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

		try {
			// Tiger.g:304:5: ( type_declaration_list funct_declaration_list_then_main EOF -> ^( PROGRAM type_declaration_list funct_declaration_list_then_main ) )
			// Tiger.g:305:2: type_declaration_list funct_declaration_list_then_main EOF
			{
				
					// This new SymbolTable will be the global SymbolTable
					level = 0;
					enterNewScope(new SymbolTable(level));
					// Add Standard Library Functions into Global Symbol Table
					addSTL();
				
			pushFollow(FOLLOW_type_declaration_list_in_tiger_program1033);
			type_declaration_list1=type_declaration_list();
			state._fsp--;

			stream_type_declaration_list.add(type_declaration_list1.getTree());
			pushFollow(FOLLOW_funct_declaration_list_then_main_in_tiger_program1035);
			funct_declaration_list_then_main2=funct_declaration_list_then_main();
			state._fsp--;

			stream_funct_declaration_list_then_main.add(funct_declaration_list_then_main2.getTree());
			EOF3=(Token)match(input,EOF,FOLLOW_EOF_in_tiger_program1041);  
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
			// 316:2: -> ^( PROGRAM type_declaration_list funct_declaration_list_then_main )
			{
				// Tiger.g:316:5: ^( PROGRAM type_declaration_list funct_declaration_list_then_main )
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
	// Tiger.g:320:1: funct_declaration_list_then_main : (myRet= VOID ! ( funct_declaration_tail[$myRet, $myRet.text] funct_declaration_list_then_main | main_function_tail ) | (myRet= ID |myRet= INT |myRet= FIXEDPT ) funct_declaration_tail[$myRet, $myRet.text] funct_declaration_list_then_main );
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
			// Tiger.g:321:5: (myRet= VOID ! ( funct_declaration_tail[$myRet, $myRet.text] funct_declaration_list_then_main | main_function_tail ) | (myRet= ID |myRet= INT |myRet= FIXEDPT ) funct_declaration_tail[$myRet, $myRet.text] funct_declaration_list_then_main )
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
					// Tiger.g:321:7: myRet= VOID ! ( funct_declaration_tail[$myRet, $myRet.text] funct_declaration_list_then_main | main_function_tail )
					{
					root_0 = (Object)adaptor.nil();


					myRet=(Token)match(input,VOID,FOLLOW_VOID_in_funct_declaration_list_then_main1069); 
					// Tiger.g:321:19: ( funct_declaration_tail[$myRet, $myRet.text] funct_declaration_list_then_main | main_function_tail )
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
							// Tiger.g:321:20: funct_declaration_tail[$myRet, $myRet.text] funct_declaration_list_then_main
							{
							pushFollow(FOLLOW_funct_declaration_tail_in_funct_declaration_list_then_main1073);
							funct_declaration_tail4=funct_declaration_tail(myRet, (myRet!=null?myRet.getText():null));
							state._fsp--;

							adaptor.addChild(root_0, funct_declaration_tail4.getTree());

							pushFollow(FOLLOW_funct_declaration_list_then_main_in_funct_declaration_list_then_main1076);
							funct_declaration_list_then_main5=funct_declaration_list_then_main();
							state._fsp--;

							adaptor.addChild(root_0, funct_declaration_list_then_main5.getTree());

							}
							break;
						case 2 :
							// Tiger.g:321:99: main_function_tail
							{
							pushFollow(FOLLOW_main_function_tail_in_funct_declaration_list_then_main1080);
							main_function_tail6=main_function_tail();
							state._fsp--;

							adaptor.addChild(root_0, main_function_tail6.getTree());

							}
							break;

					}

					}
					break;
				case 2 :
					// Tiger.g:323:7: (myRet= ID |myRet= INT |myRet= FIXEDPT ) funct_declaration_tail[$myRet, $myRet.text] funct_declaration_list_then_main
					{
					root_0 = (Object)adaptor.nil();


					// Tiger.g:323:7: (myRet= ID |myRet= INT |myRet= FIXEDPT )
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
							// Tiger.g:323:8: myRet= ID
							{
							myRet=(Token)match(input,ID,FOLLOW_ID_in_funct_declaration_list_then_main1093); 
							myRet_tree = (Object)adaptor.create(myRet);
							adaptor.addChild(root_0, myRet_tree);

							}
							break;
						case 2 :
							// Tiger.g:323:17: myRet= INT
							{
							myRet=(Token)match(input,INT,FOLLOW_INT_in_funct_declaration_list_then_main1097); 
							myRet_tree = (Object)adaptor.create(myRet);
							adaptor.addChild(root_0, myRet_tree);

							}
							break;
						case 3 :
							// Tiger.g:323:27: myRet= FIXEDPT
							{
							myRet=(Token)match(input,FIXEDPT,FOLLOW_FIXEDPT_in_funct_declaration_list_then_main1101); 
							myRet_tree = (Object)adaptor.create(myRet);
							adaptor.addChild(root_0, myRet_tree);

							}
							break;

					}

					pushFollow(FOLLOW_funct_declaration_tail_in_funct_declaration_list_then_main1104);
					funct_declaration_tail7=funct_declaration_tail(myRet, (myRet!=null?myRet.getText():null));
					state._fsp--;

					adaptor.addChild(root_0, funct_declaration_tail7.getTree());

					pushFollow(FOLLOW_funct_declaration_list_then_main_in_funct_declaration_list_then_main1107);
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
	// Tiger.g:326:1: funct_declaration_tail[Token retType, String returnType] : FUNCTION ID '(' param_list ')' BEGIN block_list END ';' -> ^( FUNCTION ID param_list block_list ) ;
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
		RewriteRuleTokenStream stream_FUNCTION=new RewriteRuleTokenStream(adaptor,"token FUNCTION");
		RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_END=new RewriteRuleTokenStream(adaptor,"token END");
		RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
		RewriteRuleTokenStream stream_BEGIN=new RewriteRuleTokenStream(adaptor,"token BEGIN");
		RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
		RewriteRuleSubtreeStream stream_block_list=new RewriteRuleSubtreeStream(adaptor,"rule block_list");
		RewriteRuleSubtreeStream stream_param_list=new RewriteRuleSubtreeStream(adaptor,"rule param_list");

		try {
			// Tiger.g:327:5: ( FUNCTION ID '(' param_list ')' BEGIN block_list END ';' -> ^( FUNCTION ID param_list block_list ) )
			// Tiger.g:327:7: FUNCTION ID '(' param_list ')' BEGIN block_list END ';'
			{
			Type type = new Type(returnType);
			FUNCTION9=(Token)match(input,FUNCTION,FOLLOW_FUNCTION_in_funct_declaration_tail1135);  
			stream_FUNCTION.add(FUNCTION9);

			ID10=(Token)match(input,ID,FOLLOW_ID_in_funct_declaration_tail1137);  
			stream_ID.add(ID10);

			char_literal11=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_funct_declaration_tail1139);  
			stream_LPAREN.add(char_literal11);

			pushFollow(FOLLOW_param_list_in_funct_declaration_tail1141);
			param_list12=param_list();
			state._fsp--;

			stream_param_list.add(param_list12.getTree());
			char_literal13=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_funct_declaration_tail1143);  
			stream_RPAREN.add(char_literal13);


					getTopTable().put((ID10!=null?ID10.getText():null), new Function((ID10!=null?ID10.getText():null), type, (param_list12!=null?((TigerParser.param_list_return)param_list12).paramList:null)));

					enterNewScope(new SymbolTable(level));

					for(int i = 0; i < (param_list12!=null?((TigerParser.param_list_return)param_list12).paramList:null).size(); i++) {

						getTopTable().put((param_list12!=null?((TigerParser.param_list_return)param_list12).paramList:null).get(i).getName(), 
								new Id((param_list12!=null?((TigerParser.param_list_return)param_list12).paramList:null).get(i).getName(), (param_list12!=null?((TigerParser.param_list_return)param_list12).paramList:null).get(i).getType(),true));
					}

					exitScope();
				
			BEGIN14=(Token)match(input,BEGIN,FOLLOW_BEGIN_in_funct_declaration_tail1151);  
			stream_BEGIN.add(BEGIN14);

			pushFollow(FOLLOW_block_list_in_funct_declaration_tail1153);
			block_list15=block_list();
			state._fsp--;

			stream_block_list.add(block_list15.getTree());
			END16=(Token)match(input,END,FOLLOW_END_in_funct_declaration_tail1155);  
			stream_END.add(END16);

			char_literal17=(Token)match(input,SEMI,FOLLOW_SEMI_in_funct_declaration_tail1157);  
			stream_SEMI.add(char_literal17);

			// AST REWRITE
			// elements: ID, param_list, block_list, FUNCTION
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 345:2: -> ^( FUNCTION ID param_list block_list )
			{
				// Tiger.g:345:5: ^( FUNCTION ID param_list block_list )
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
	// Tiger.g:348:1: main_function_tail : MAIN '(' ')' BEGIN block_list END ';' -> ^( MAINSCOPE block_list ) ;
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

		try {
			// Tiger.g:349:5: ( MAIN '(' ')' BEGIN block_list END ';' -> ^( MAINSCOPE block_list ) )
			// Tiger.g:349:7: MAIN '(' ')' BEGIN block_list END ';'
			{
			MAIN18=(Token)match(input,MAIN,FOLLOW_MAIN_in_main_function_tail1192);  
			stream_MAIN.add(MAIN18);

			char_literal19=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_main_function_tail1194);  
			stream_LPAREN.add(char_literal19);

			char_literal20=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_main_function_tail1196);  
			stream_RPAREN.add(char_literal20);

			BEGIN21=(Token)match(input,BEGIN,FOLLOW_BEGIN_in_main_function_tail1198);  
			stream_BEGIN.add(BEGIN21);

			pushFollow(FOLLOW_block_list_in_main_function_tail1200);
			block_list22=block_list();
			state._fsp--;

			stream_block_list.add(block_list22.getTree());
			END23=(Token)match(input,END,FOLLOW_END_in_main_function_tail1202);  
			stream_END.add(END23);

			char_literal24=(Token)match(input,SEMI,FOLLOW_SEMI_in_main_function_tail1204);  
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
			// 350:2: -> ^( MAINSCOPE block_list )
			{
				// Tiger.g:350:5: ^( MAINSCOPE block_list )
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
	// Tiger.g:352:1: param_list returns [ArrayList<Id> paramList] : (par1= param ( ',' par2= param )* )? -> ^( PARAMLIST ( param )* ) ;
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
			// Tiger.g:353:5: ( (par1= param ( ',' par2= param )* )? -> ^( PARAMLIST ( param )* ) )
			// Tiger.g:353:7: (par1= param ( ',' par2= param )* )?
			{
			retval.paramList = new ArrayList<Id>();
			// Tiger.g:354:5: (par1= param ( ',' par2= param )* )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==ID) ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// Tiger.g:354:6: par1= param ( ',' par2= param )*
					{
					pushFollow(FOLLOW_param_in_param_list1238);
					par1=param();
					state._fsp--;

					stream_param.add(par1.getTree());
					retval.paramList.add((par1!=null?((TigerParser.param_return)par1).param:null));
					// Tiger.g:355:2: ( ',' par2= param )*
					loop4:
					while (true) {
						int alt4=2;
						int LA4_0 = input.LA(1);
						if ( (LA4_0==COMMA) ) {
							alt4=1;
						}

						switch (alt4) {
						case 1 :
							// Tiger.g:355:4: ',' par2= param
							{
							char_literal25=(Token)match(input,COMMA,FOLLOW_COMMA_in_param_list1246);  
							stream_COMMA.add(char_literal25);

							pushFollow(FOLLOW_param_in_param_list1250);
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
			// 357:2: -> ^( PARAMLIST ( param )* )
			{
				// Tiger.g:357:5: ^( PARAMLIST ( param )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PARAMLIST, "PARAMLIST"), root_1);
				// Tiger.g:357:17: ( param )*
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
	// Tiger.g:360:1: param returns [Id param] : ID ':' type_id ;
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
			// Tiger.g:361:2: ( ID ':' type_id )
			// Tiger.g:361:4: ID ':' type_id
			{
			root_0 = (Object)adaptor.nil();


			ID26=(Token)match(input,ID,FOLLOW_ID_in_param1285); 
			ID26_tree = (Object)adaptor.create(ID26);
			adaptor.addChild(root_0, ID26_tree);

			char_literal27=(Token)match(input,COLON,FOLLOW_COLON_in_param1287); 
			char_literal27_tree = (Object)adaptor.create(char_literal27);
			adaptor.addChild(root_0, char_literal27_tree);

			pushFollow(FOLLOW_type_id_in_param1289);
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
	// Tiger.g:366:1: block_list : ( block )+ -> ^( BLOCKLIST ( block )+ ) ;
	public final TigerParser.block_list_return block_list() throws RecognitionException {
		TigerParser.block_list_return retval = new TigerParser.block_list_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope block29 =null;

		RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");

		try {
			// Tiger.g:367:5: ( ( block )+ -> ^( BLOCKLIST ( block )+ ) )
			// Tiger.g:367:7: ( block )+
			{
			// Tiger.g:367:7: ( block )+
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
					// Tiger.g:367:7: block
					{
					pushFollow(FOLLOW_block_in_block_list1317);
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
			// 367:14: -> ^( BLOCKLIST ( block )+ )
			{
				// Tiger.g:367:17: ^( BLOCKLIST ( block )+ )
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
	// Tiger.g:369:1: block : BEGIN declaration_segment stat_seq END ';' -> ^( BLOCKSCOPE declaration_segment stat_seq ) ;
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
		RewriteRuleTokenStream stream_END=new RewriteRuleTokenStream(adaptor,"token END");
		RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
		RewriteRuleTokenStream stream_BEGIN=new RewriteRuleTokenStream(adaptor,"token BEGIN");
		RewriteRuleSubtreeStream stream_declaration_segment=new RewriteRuleSubtreeStream(adaptor,"rule declaration_segment");
		RewriteRuleSubtreeStream stream_stat_seq=new RewriteRuleSubtreeStream(adaptor,"rule stat_seq");

		try {
			// Tiger.g:370:2: ( BEGIN declaration_segment stat_seq END ';' -> ^( BLOCKSCOPE declaration_segment stat_seq ) )
			// Tiger.g:370:4: BEGIN declaration_segment stat_seq END ';'
			{
			BEGIN30=(Token)match(input,BEGIN,FOLLOW_BEGIN_in_block1337);  
			stream_BEGIN.add(BEGIN30);

			enterNewScope(new SymbolTable(level));
			pushFollow(FOLLOW_declaration_segment_in_block1346);
			declaration_segment31=declaration_segment();
			state._fsp--;

			stream_declaration_segment.add(declaration_segment31.getTree());
			pushFollow(FOLLOW_stat_seq_in_block1348);
			stat_seq32=stat_seq();
			state._fsp--;

			stream_stat_seq.add(stat_seq32.getTree());
			END33=(Token)match(input,END,FOLLOW_END_in_block1350);  
			stream_END.add(END33);

			char_literal34=(Token)match(input,SEMI,FOLLOW_SEMI_in_block1352);  
			stream_SEMI.add(char_literal34);

			exitScope();
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
			// 376:2: -> ^( BLOCKSCOPE declaration_segment stat_seq )
			{
				// Tiger.g:376:5: ^( BLOCKSCOPE declaration_segment stat_seq )
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
	// Tiger.g:378:1: declaration_segment : type_declaration_list var_declaration_list ;
	public final TigerParser.declaration_segment_return declaration_segment() throws RecognitionException {
		TigerParser.declaration_segment_return retval = new TigerParser.declaration_segment_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope type_declaration_list35 =null;
		ParserRuleReturnScope var_declaration_list36 =null;


		try {
			// Tiger.g:379:5: ( type_declaration_list var_declaration_list )
			// Tiger.g:379:7: type_declaration_list var_declaration_list
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_type_declaration_list_in_declaration_segment1383);
			type_declaration_list35=type_declaration_list();
			state._fsp--;

			adaptor.addChild(root_0, type_declaration_list35.getTree());

			pushFollow(FOLLOW_var_declaration_list_in_declaration_segment1385);
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
	// Tiger.g:381:1: type_declaration_list : ( type_declaration )* -> ^( TYPEDECLLIST ( type_declaration )* ) ;
	public final TigerParser.type_declaration_list_return type_declaration_list() throws RecognitionException {
		TigerParser.type_declaration_list_return retval = new TigerParser.type_declaration_list_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope type_declaration37 =null;

		RewriteRuleSubtreeStream stream_type_declaration=new RewriteRuleSubtreeStream(adaptor,"rule type_declaration");

		try {
			// Tiger.g:382:5: ( ( type_declaration )* -> ^( TYPEDECLLIST ( type_declaration )* ) )
			// Tiger.g:382:7: ( type_declaration )*
			{
			// Tiger.g:382:7: ( type_declaration )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==TYPE) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// Tiger.g:382:7: type_declaration
					{
					pushFollow(FOLLOW_type_declaration_in_type_declaration_list1398);
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
			// 383:2: -> ^( TYPEDECLLIST ( type_declaration )* )
			{
				// Tiger.g:383:5: ^( TYPEDECLLIST ( type_declaration )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(TYPEDECLLIST, "TYPEDECLLIST"), root_1);
				// Tiger.g:383:20: ( type_declaration )*
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
	// Tiger.g:386:1: var_declaration_list : ( var_declaration )* -> ^( VARDECLLIST ( var_declaration )* ) ;
	public final TigerParser.var_declaration_list_return var_declaration_list() throws RecognitionException {
		TigerParser.var_declaration_list_return retval = new TigerParser.var_declaration_list_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope var_declaration38 =null;

		RewriteRuleSubtreeStream stream_var_declaration=new RewriteRuleSubtreeStream(adaptor,"rule var_declaration");

		try {
			// Tiger.g:387:5: ( ( var_declaration )* -> ^( VARDECLLIST ( var_declaration )* ) )
			// Tiger.g:387:7: ( var_declaration )*
			{
			// Tiger.g:387:7: ( var_declaration )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==VAR) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// Tiger.g:387:7: var_declaration
					{
					pushFollow(FOLLOW_var_declaration_in_var_declaration_list1431);
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
			// 388:2: -> ^( VARDECLLIST ( var_declaration )* )
			{
				// Tiger.g:388:5: ^( VARDECLLIST ( var_declaration )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(VARDECLLIST, "VARDECLLIST"), root_1);
				// Tiger.g:388:19: ( var_declaration )*
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
	// Tiger.g:391:1: type_declaration : TYPE ID '=' type ';' -> ^( TYPEDECL ID type ) ;
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
		RewriteRuleTokenStream stream_EQ=new RewriteRuleTokenStream(adaptor,"token EQ");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
		RewriteRuleTokenStream stream_TYPE=new RewriteRuleTokenStream(adaptor,"token TYPE");
		RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");

		try {
			// Tiger.g:392:5: ( TYPE ID '=' type ';' -> ^( TYPEDECL ID type ) )
			// Tiger.g:392:7: TYPE ID '=' type ';'
			{
			TYPE39=(Token)match(input,TYPE,FOLLOW_TYPE_in_type_declaration1461);  
			stream_TYPE.add(TYPE39);

			ID40=(Token)match(input,ID,FOLLOW_ID_in_type_declaration1463);  
			stream_ID.add(ID40);

			char_literal41=(Token)match(input,EQ,FOLLOW_EQ_in_type_declaration1465);  
			stream_EQ.add(char_literal41);

			pushFollow(FOLLOW_type_in_type_declaration1467);
			type42=type();
			state._fsp--;

			stream_type.add(type42.getTree());
			char_literal43=(Token)match(input,SEMI,FOLLOW_SEMI_in_type_declaration1469);  
			stream_SEMI.add(char_literal43);


					if((type42!=null?((TigerParser.type_return)type42).w:0) == 0) {
						getTopTable().put((ID40!=null?ID40.getText():null), new UserType((ID40!=null?ID40.getText():null), new Type((type42!=null?((TigerParser.type_return)type42).e:null).name)));
					} else if ((type42!=null?((TigerParser.type_return)type42).h:0)==0) {
						getTopTable().put((ID40!=null?ID40.getText():null), new UserType((ID40!=null?ID40.getText():null), new Array((type42!=null?((TigerParser.type_return)type42).e:null).name, (type42!=null?((TigerParser.type_return)type42).w:0), (type42!=null?((TigerParser.type_return)type42).e:null))));
					} else {
						getTopTable().put((ID40!=null?ID40.getText():null), new UserType((ID40!=null?ID40.getText():null), new TwoDArray((type42!=null?((TigerParser.type_return)type42).e:null).name, (type42!=null?((TigerParser.type_return)type42).w:0), (type42!=null?((TigerParser.type_return)type42).h:0), (type42!=null?((TigerParser.type_return)type42).e:null))));
					}
				
			// AST REWRITE
			// elements: type, ID
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 404:2: -> ^( TYPEDECL ID type )
			{
				// Tiger.g:404:5: ^( TYPEDECL ID type )
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
		public int w;
		public int h;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "type"
	// Tiger.g:406:1: type returns [Type e, int w, int h] : ( base_type | ARRAY '[' init1= INTLIT ']' ( '[' init2= INTLIT ']' )? OF base_type -> ^( ARRAY base_type ( INTLIT )+ ) );
	public final TigerParser.type_return type() throws RecognitionException {
		TigerParser.type_return retval = new TigerParser.type_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token init1=null;
		Token init2=null;
		Token ARRAY45=null;
		Token char_literal46=null;
		Token char_literal47=null;
		Token char_literal48=null;
		Token char_literal49=null;
		Token OF50=null;
		ParserRuleReturnScope base_type44 =null;
		ParserRuleReturnScope base_type51 =null;

		Object init1_tree=null;
		Object init2_tree=null;
		Object ARRAY45_tree=null;
		Object char_literal46_tree=null;
		Object char_literal47_tree=null;
		Object char_literal48_tree=null;
		Object char_literal49_tree=null;
		Object OF50_tree=null;
		RewriteRuleTokenStream stream_RBRACK=new RewriteRuleTokenStream(adaptor,"token RBRACK");
		RewriteRuleTokenStream stream_LBRACK=new RewriteRuleTokenStream(adaptor,"token LBRACK");
		RewriteRuleTokenStream stream_INTLIT=new RewriteRuleTokenStream(adaptor,"token INTLIT");
		RewriteRuleTokenStream stream_OF=new RewriteRuleTokenStream(adaptor,"token OF");
		RewriteRuleTokenStream stream_ARRAY=new RewriteRuleTokenStream(adaptor,"token ARRAY");
		RewriteRuleSubtreeStream stream_base_type=new RewriteRuleSubtreeStream(adaptor,"rule base_type");

		try {
			// Tiger.g:407:5: ( base_type | ARRAY '[' init1= INTLIT ']' ( '[' init2= INTLIT ']' )? OF base_type -> ^( ARRAY base_type ( INTLIT )+ ) )
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
					// Tiger.g:407:7: base_type
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_base_type_in_type1501);
					base_type44=base_type();
					state._fsp--;

					adaptor.addChild(root_0, base_type44.getTree());

					retval.e = (base_type44!=null?((TigerParser.base_type_return)base_type44).e:null);
					}
					break;
				case 2 :
					// Tiger.g:408:7: ARRAY '[' init1= INTLIT ']' ( '[' init2= INTLIT ']' )? OF base_type
					{
					int i = 0;retval.w =0;retval.h =0;
					ARRAY45=(Token)match(input,ARRAY,FOLLOW_ARRAY_in_type1513);  
					stream_ARRAY.add(ARRAY45);

					char_literal46=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_type1515);  
					stream_LBRACK.add(char_literal46);

					init1=(Token)match(input,INTLIT,FOLLOW_INTLIT_in_type1519);  
					stream_INTLIT.add(init1);

					char_literal47=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_type1521);  
					stream_RBRACK.add(char_literal47);

					// Tiger.g:408:57: ( '[' init2= INTLIT ']' )?
					int alt9=2;
					int LA9_0 = input.LA(1);
					if ( (LA9_0==LBRACK) ) {
						alt9=1;
					}
					switch (alt9) {
						case 1 :
							// Tiger.g:408:58: '[' init2= INTLIT ']'
							{
							char_literal48=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_type1524);  
							stream_LBRACK.add(char_literal48);

							init2=(Token)match(input,INTLIT,FOLLOW_INTLIT_in_type1528);  
							stream_INTLIT.add(init2);

							char_literal49=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_type1530);  
							stream_RBRACK.add(char_literal49);

							i++;
							}
							break;

					}

					OF50=(Token)match(input,OF,FOLLOW_OF_in_type1535);  
					stream_OF.add(OF50);

					pushFollow(FOLLOW_base_type_in_type1537);
					base_type51=base_type();
					state._fsp--;

					stream_base_type.add(base_type51.getTree());
					if(i == 0) {
							retval.w = Integer.parseInt((init1!=null?init1.getText():null));
							retval.h = 0;
							retval.e = (base_type51!=null?((TigerParser.base_type_return)base_type51).e:null);
						} else {
							retval.w = Integer.parseInt((init1!=null?init1.getText():null));
							retval.h = Integer.parseInt((init2!=null?init2.getText():null));
							retval.e = (base_type51!=null?((TigerParser.base_type_return)base_type51).e:null);
						}
						
					// AST REWRITE
					// elements: ARRAY, base_type, INTLIT
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 419:2: -> ^( ARRAY base_type ( INTLIT )+ )
					{
						// Tiger.g:419:5: ^( ARRAY base_type ( INTLIT )+ )
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
	// Tiger.g:422:1: type_id returns [Type e] : ( base_type |id= ID );
	public final TigerParser.type_id_return type_id() throws RecognitionException {
		TigerParser.type_id_return retval = new TigerParser.type_id_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token id=null;
		ParserRuleReturnScope base_type52 =null;

		Object id_tree=null;

		try {
			// Tiger.g:424:5: ( base_type |id= ID )
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
					// Tiger.g:424:7: base_type
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_base_type_in_type_id1575);
					base_type52=base_type();
					state._fsp--;

					adaptor.addChild(root_0, base_type52.getTree());

					retval.e = (base_type52!=null?((TigerParser.base_type_return)base_type52).e:null);
					}
					break;
				case 2 :
					// Tiger.g:428:7: id= ID
					{
					root_0 = (Object)adaptor.nil();


					id=(Token)match(input,ID,FOLLOW_ID_in_type_id1592); 
					id_tree = (Object)adaptor.create(id);
					adaptor.addChild(root_0, id_tree);

					retval.e = new Type((id!=null?id.getText():null));
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
	// Tiger.g:432:1: base_type returns [Type e] : ( INT | FIXEDPT );
	public final TigerParser.base_type_return base_type() throws RecognitionException {
		TigerParser.base_type_return retval = new TigerParser.base_type_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token INT53=null;
		Token FIXEDPT54=null;

		Object INT53_tree=null;
		Object FIXEDPT54_tree=null;

		try {
			// Tiger.g:433:5: ( INT | FIXEDPT )
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
					// Tiger.g:433:7: INT
					{
					root_0 = (Object)adaptor.nil();


					INT53=(Token)match(input,INT,FOLLOW_INT_in_base_type1616); 
					INT53_tree = (Object)adaptor.create(INT53);
					adaptor.addChild(root_0, INT53_tree);

					retval.e = Type.Int;
					}
					break;
				case 2 :
					// Tiger.g:434:7: FIXEDPT
					{
					root_0 = (Object)adaptor.nil();


					FIXEDPT54=(Token)match(input,FIXEDPT,FOLLOW_FIXEDPT_in_base_type1627); 
					FIXEDPT54_tree = (Object)adaptor.create(FIXEDPT54);
					adaptor.addChild(root_0, FIXEDPT54_tree);

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
	// Tiger.g:437:1: var_declaration : VAR id_list ':' type_id optional_init ';' -> ^( VAR type_id id_list ( optional_init )? ) ;
	public final TigerParser.var_declaration_return var_declaration() throws RecognitionException {
		TigerParser.var_declaration_return retval = new TigerParser.var_declaration_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token VAR55=null;
		Token char_literal57=null;
		Token char_literal60=null;
		ParserRuleReturnScope id_list56 =null;
		ParserRuleReturnScope type_id58 =null;
		ParserRuleReturnScope optional_init59 =null;

		Object VAR55_tree=null;
		Object char_literal57_tree=null;
		Object char_literal60_tree=null;
		RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
		RewriteRuleTokenStream stream_VAR=new RewriteRuleTokenStream(adaptor,"token VAR");
		RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
		RewriteRuleSubtreeStream stream_optional_init=new RewriteRuleSubtreeStream(adaptor,"rule optional_init");
		RewriteRuleSubtreeStream stream_type_id=new RewriteRuleSubtreeStream(adaptor,"rule type_id");
		RewriteRuleSubtreeStream stream_id_list=new RewriteRuleSubtreeStream(adaptor,"rule id_list");

		try {
			// Tiger.g:438:5: ( VAR id_list ':' type_id optional_init ';' -> ^( VAR type_id id_list ( optional_init )? ) )
			// Tiger.g:441:2: VAR id_list ':' type_id optional_init ';'
			{
			VAR55=(Token)match(input,VAR,FOLLOW_VAR_in_var_declaration1652);  
			stream_VAR.add(VAR55);

			pushFollow(FOLLOW_id_list_in_var_declaration1654);
			id_list56=id_list();
			state._fsp--;

			stream_id_list.add(id_list56.getTree());
			char_literal57=(Token)match(input,COLON,FOLLOW_COLON_in_var_declaration1656);  
			stream_COLON.add(char_literal57);

			pushFollow(FOLLOW_type_id_in_var_declaration1658);
			type_id58=type_id();
			state._fsp--;

			stream_type_id.add(type_id58.getTree());
			pushFollow(FOLLOW_optional_init_in_var_declaration1660);
			optional_init59=optional_init();
			state._fsp--;

			stream_optional_init.add(optional_init59.getTree());
			char_literal60=(Token)match(input,SEMI,FOLLOW_SEMI_in_var_declaration1662);  
			stream_SEMI.add(char_literal60);


						for(int i = 0; i < (id_list56!=null?((TigerParser.id_list_return)id_list56).list:null).size(); i++) {
							getTopTable().put((id_list56!=null?((TigerParser.id_list_return)id_list56).list:null).get(i), new Id((id_list56!=null?((TigerParser.id_list_return)id_list56).list:null).get(i), (type_id58!=null?((TigerParser.type_id_return)type_id58).e:null), (optional_init59!=null?((TigerParser.optional_init_return)optional_init59).b:false)));
						}
					
			// AST REWRITE
			// elements: VAR, optional_init, id_list, type_id
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 448:2: -> ^( VAR type_id id_list ( optional_init )? )
			{
				// Tiger.g:448:5: ^( VAR type_id id_list ( optional_init )? )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot(stream_VAR.nextNode(), root_1);
				adaptor.addChild(root_1, stream_type_id.nextTree());
				adaptor.addChild(root_1, stream_id_list.nextTree());
				// Tiger.g:448:27: ( optional_init )?
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
	// Tiger.g:452:1: id_list returns [ArrayList<String> list] :i= ID ( ',' j= ID )* -> ^( IDLIST ( ID )+ ) ;
	public final TigerParser.id_list_return id_list() throws RecognitionException {
		TigerParser.id_list_return retval = new TigerParser.id_list_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token i=null;
		Token j=null;
		Token char_literal61=null;

		Object i_tree=null;
		Object j_tree=null;
		Object char_literal61_tree=null;
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");

		try {
			// Tiger.g:453:5: (i= ID ( ',' j= ID )* -> ^( IDLIST ( ID )+ ) )
			// Tiger.g:453:6: i= ID ( ',' j= ID )*
			{
			retval.list = new ArrayList();
			i=(Token)match(input,ID,FOLLOW_ID_in_id_list1704);  
			stream_ID.add(i);

			retval.list.add((i!=null?i.getText():null));
			// Tiger.g:454:28: ( ',' j= ID )*
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0==COMMA) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// Tiger.g:454:29: ',' j= ID
					{
					char_literal61=(Token)match(input,COMMA,FOLLOW_COMMA_in_id_list1708);  
					stream_COMMA.add(char_literal61);

					j=(Token)match(input,ID,FOLLOW_ID_in_id_list1712);  
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
			// 456:3: -> ^( IDLIST ( ID )+ )
			{
				// Tiger.g:456:6: ^( IDLIST ( ID )+ )
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
	// Tiger.g:459:1: optional_init returns [boolean b] : ( ':=' literal |);
	public final TigerParser.optional_init_return optional_init() throws RecognitionException {
		TigerParser.optional_init_return retval = new TigerParser.optional_init_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal62=null;
		ParserRuleReturnScope literal63 =null;

		Object string_literal62_tree=null;

		try {
			// Tiger.g:462:5: ( ':=' literal |)
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
					// Tiger.g:462:7: ':=' literal
					{
					root_0 = (Object)adaptor.nil();


					retval.b = true;
					string_literal62=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_optional_init1753); 
					string_literal62_tree = (Object)adaptor.create(string_literal62);
					adaptor.addChild(root_0, string_literal62_tree);

					pushFollow(FOLLOW_literal_in_optional_init1755);
					literal63=literal();
					state._fsp--;

					adaptor.addChild(root_0, literal63.getTree());

					}
					break;
				case 2 :
					// Tiger.g:463:7: 
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
	// Tiger.g:466:1: stat_seq : ( stat )+ ;
	public final TigerParser.stat_seq_return stat_seq() throws RecognitionException {
		TigerParser.stat_seq_return retval = new TigerParser.stat_seq_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope stat64 =null;


		try {
			// Tiger.g:467:5: ( ( stat )+ )
			// Tiger.g:467:7: ( stat )+
			{
			root_0 = (Object)adaptor.nil();


			// Tiger.g:467:7: ( stat )+
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
					// Tiger.g:467:7: stat
					{
					pushFollow(FOLLOW_stat_in_stat_seq1781);
					stat64=stat();
					state._fsp--;

					adaptor.addChild(root_0, stat64.getTree());

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
	// Tiger.g:470:1: stat : ( function_call_or_assignment | IF expr THEN seq1= stat_seq ( ELSE seq2= stat_seq ENDIF -> ^( IF expr ^( THEN_STATS $seq1) ^( ELSE_STATS $seq2) ) | ENDIF -> ^( IF expr ^( THEN_STATS $seq1) ) ) ';' | WHILE expr DO stat_seq ENDDO ';' -> ^( WHILE expr stat_seq ) | FOR ID ':=' index_expr TO index_expr DO stat_seq ENDDO ';' -> ^( FOR ID index_expr index_expr stat_seq ) | BREAK ';' !| RETURN expr ';' -> ^( RETURN expr ) | block );
	public final TigerParser.stat_return stat() throws RecognitionException {
		TigerParser.stat_return retval = new TigerParser.stat_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token IF66=null;
		Token THEN68=null;
		Token ELSE69=null;
		Token ENDIF70=null;
		Token ENDIF71=null;
		Token char_literal72=null;
		Token WHILE73=null;
		Token DO75=null;
		Token ENDDO77=null;
		Token char_literal78=null;
		Token FOR79=null;
		Token ID80=null;
		Token string_literal81=null;
		Token TO83=null;
		Token DO85=null;
		Token ENDDO87=null;
		Token char_literal88=null;
		Token BREAK89=null;
		Token char_literal90=null;
		Token RETURN91=null;
		Token char_literal93=null;
		ParserRuleReturnScope seq1 =null;
		ParserRuleReturnScope seq2 =null;
		ParserRuleReturnScope function_call_or_assignment65 =null;
		ParserRuleReturnScope expr67 =null;
		ParserRuleReturnScope expr74 =null;
		ParserRuleReturnScope stat_seq76 =null;
		ParserRuleReturnScope index_expr82 =null;
		ParserRuleReturnScope index_expr84 =null;
		ParserRuleReturnScope stat_seq86 =null;
		ParserRuleReturnScope expr92 =null;
		ParserRuleReturnScope block94 =null;

		Object IF66_tree=null;
		Object THEN68_tree=null;
		Object ELSE69_tree=null;
		Object ENDIF70_tree=null;
		Object ENDIF71_tree=null;
		Object char_literal72_tree=null;
		Object WHILE73_tree=null;
		Object DO75_tree=null;
		Object ENDDO77_tree=null;
		Object char_literal78_tree=null;
		Object FOR79_tree=null;
		Object ID80_tree=null;
		Object string_literal81_tree=null;
		Object TO83_tree=null;
		Object DO85_tree=null;
		Object ENDDO87_tree=null;
		Object char_literal88_tree=null;
		Object BREAK89_tree=null;
		Object char_literal90_tree=null;
		Object RETURN91_tree=null;
		Object char_literal93_tree=null;
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

		try {
			// Tiger.g:471:5: ( function_call_or_assignment | IF expr THEN seq1= stat_seq ( ELSE seq2= stat_seq ENDIF -> ^( IF expr ^( THEN_STATS $seq1) ^( ELSE_STATS $seq2) ) | ENDIF -> ^( IF expr ^( THEN_STATS $seq1) ) ) ';' | WHILE expr DO stat_seq ENDDO ';' -> ^( WHILE expr stat_seq ) | FOR ID ':=' index_expr TO index_expr DO stat_seq ENDDO ';' -> ^( FOR ID index_expr index_expr stat_seq ) | BREAK ';' !| RETURN expr ';' -> ^( RETURN expr ) | block )
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
					// Tiger.g:471:7: function_call_or_assignment
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_function_call_or_assignment_in_stat1799);
					function_call_or_assignment65=function_call_or_assignment();
					state._fsp--;

					adaptor.addChild(root_0, function_call_or_assignment65.getTree());

					}
					break;
				case 2 :
					// Tiger.g:472:7: IF expr THEN seq1= stat_seq ( ELSE seq2= stat_seq ENDIF -> ^( IF expr ^( THEN_STATS $seq1) ^( ELSE_STATS $seq2) ) | ENDIF -> ^( IF expr ^( THEN_STATS $seq1) ) ) ';'
					{
					IF66=(Token)match(input,IF,FOLLOW_IF_in_stat1807);  
					stream_IF.add(IF66);

					pushFollow(FOLLOW_expr_in_stat1809);
					expr67=expr();
					state._fsp--;

					stream_expr.add(expr67.getTree());
					THEN68=(Token)match(input,THEN,FOLLOW_THEN_in_stat1811);  
					stream_THEN.add(THEN68);

					pushFollow(FOLLOW_stat_seq_in_stat1815);
					seq1=stat_seq();
					state._fsp--;

					stream_stat_seq.add(seq1.getTree());
					// Tiger.g:473:9: ( ELSE seq2= stat_seq ENDIF -> ^( IF expr ^( THEN_STATS $seq1) ^( ELSE_STATS $seq2) ) | ENDIF -> ^( IF expr ^( THEN_STATS $seq1) ) )
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
							// Tiger.g:473:11: ELSE seq2= stat_seq ENDIF
							{
							ELSE69=(Token)match(input,ELSE,FOLLOW_ELSE_in_stat1828);  
							stream_ELSE.add(ELSE69);

							pushFollow(FOLLOW_stat_seq_in_stat1832);
							seq2=stat_seq();
							state._fsp--;

							stream_stat_seq.add(seq2.getTree());
							ENDIF70=(Token)match(input,ENDIF,FOLLOW_ENDIF_in_stat1834);  
							stream_ENDIF.add(ENDIF70);

							// AST REWRITE
							// elements: seq1, IF, seq2, expr
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
							// 474:13: -> ^( IF expr ^( THEN_STATS $seq1) ^( ELSE_STATS $seq2) )
							{
								// Tiger.g:474:16: ^( IF expr ^( THEN_STATS $seq1) ^( ELSE_STATS $seq2) )
								{
								Object root_1 = (Object)adaptor.nil();
								root_1 = (Object)adaptor.becomeRoot(stream_IF.nextNode(), root_1);
								adaptor.addChild(root_1, stream_expr.nextTree());
								// Tiger.g:474:26: ^( THEN_STATS $seq1)
								{
								Object root_2 = (Object)adaptor.nil();
								root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(THEN_STATS, "THEN_STATS"), root_2);
								adaptor.addChild(root_2, stream_seq1.nextTree());
								adaptor.addChild(root_1, root_2);
								}

								// Tiger.g:474:46: ^( ELSE_STATS $seq2)
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
							// Tiger.g:475:11: ENDIF
							{
							ENDIF71=(Token)match(input,ENDIF,FOLLOW_ENDIF_in_stat1880);  
							stream_ENDIF.add(ENDIF71);

							// AST REWRITE
							// elements: expr, seq1, IF
							// token labels: 
							// rule labels: retval, seq1
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);
							RewriteRuleSubtreeStream stream_seq1=new RewriteRuleSubtreeStream(adaptor,"rule seq1",seq1!=null?seq1.getTree():null);

							root_0 = (Object)adaptor.nil();
							// 476:13: -> ^( IF expr ^( THEN_STATS $seq1) )
							{
								// Tiger.g:476:16: ^( IF expr ^( THEN_STATS $seq1) )
								{
								Object root_1 = (Object)adaptor.nil();
								root_1 = (Object)adaptor.becomeRoot(stream_IF.nextNode(), root_1);
								adaptor.addChild(root_1, stream_expr.nextTree());
								// Tiger.g:476:26: ^( THEN_STATS $seq1)
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

					char_literal72=(Token)match(input,SEMI,FOLLOW_SEMI_in_stat1919);  
					stream_SEMI.add(char_literal72);

					}
					break;
				case 3 :
					// Tiger.g:478:7: WHILE expr DO stat_seq ENDDO ';'
					{
					WHILE73=(Token)match(input,WHILE,FOLLOW_WHILE_in_stat1927);  
					stream_WHILE.add(WHILE73);

					pushFollow(FOLLOW_expr_in_stat1929);
					expr74=expr();
					state._fsp--;

					stream_expr.add(expr74.getTree());
					DO75=(Token)match(input,DO,FOLLOW_DO_in_stat1931);  
					stream_DO.add(DO75);

					pushFollow(FOLLOW_stat_seq_in_stat1933);
					stat_seq76=stat_seq();
					state._fsp--;

					stream_stat_seq.add(stat_seq76.getTree());
					ENDDO77=(Token)match(input,ENDDO,FOLLOW_ENDDO_in_stat1935);  
					stream_ENDDO.add(ENDDO77);

					char_literal78=(Token)match(input,SEMI,FOLLOW_SEMI_in_stat1937);  
					stream_SEMI.add(char_literal78);

					// AST REWRITE
					// elements: stat_seq, WHILE, expr
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 479:9: -> ^( WHILE expr stat_seq )
					{
						// Tiger.g:479:12: ^( WHILE expr stat_seq )
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
					// Tiger.g:480:7: FOR ID ':=' index_expr TO index_expr DO stat_seq ENDDO ';'
					{
					FOR79=(Token)match(input,FOR,FOLLOW_FOR_in_stat1963);  
					stream_FOR.add(FOR79);

					ID80=(Token)match(input,ID,FOLLOW_ID_in_stat1965);  
					stream_ID.add(ID80);

					string_literal81=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_stat1967);  
					stream_ASSIGN.add(string_literal81);

					pushFollow(FOLLOW_index_expr_in_stat1969);
					index_expr82=index_expr();
					state._fsp--;

					stream_index_expr.add(index_expr82.getTree());
					TO83=(Token)match(input,TO,FOLLOW_TO_in_stat1971);  
					stream_TO.add(TO83);

					pushFollow(FOLLOW_index_expr_in_stat1973);
					index_expr84=index_expr();
					state._fsp--;

					stream_index_expr.add(index_expr84.getTree());
					DO85=(Token)match(input,DO,FOLLOW_DO_in_stat1975);  
					stream_DO.add(DO85);

					pushFollow(FOLLOW_stat_seq_in_stat1977);
					stat_seq86=stat_seq();
					state._fsp--;

					stream_stat_seq.add(stat_seq86.getTree());
					ENDDO87=(Token)match(input,ENDDO,FOLLOW_ENDDO_in_stat1979);  
					stream_ENDDO.add(ENDDO87);

					char_literal88=(Token)match(input,SEMI,FOLLOW_SEMI_in_stat1981);  
					stream_SEMI.add(char_literal88);

					// AST REWRITE
					// elements: ID, FOR, stat_seq, index_expr, index_expr
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 481:9: -> ^( FOR ID index_expr index_expr stat_seq )
					{
						// Tiger.g:481:12: ^( FOR ID index_expr index_expr stat_seq )
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
					// Tiger.g:482:7: BREAK ';' !
					{
					root_0 = (Object)adaptor.nil();


					BREAK89=(Token)match(input,BREAK,FOLLOW_BREAK_in_stat2011); 
					BREAK89_tree = (Object)adaptor.create(BREAK89);
					adaptor.addChild(root_0, BREAK89_tree);

					char_literal90=(Token)match(input,SEMI,FOLLOW_SEMI_in_stat2013); 
					}
					break;
				case 6 :
					// Tiger.g:483:7: RETURN expr ';'
					{
					RETURN91=(Token)match(input,RETURN,FOLLOW_RETURN_in_stat2022);  
					stream_RETURN.add(RETURN91);

					pushFollow(FOLLOW_expr_in_stat2024);
					expr92=expr();
					state._fsp--;

					stream_expr.add(expr92.getTree());
					char_literal93=(Token)match(input,SEMI,FOLLOW_SEMI_in_stat2026);  
					stream_SEMI.add(char_literal93);

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
					// 484:9: -> ^( RETURN expr )
					{
						// Tiger.g:484:12: ^( RETURN expr )
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
					// Tiger.g:485:7: block
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_block_in_stat2050);
					block94=block();
					state._fsp--;

					adaptor.addChild(root_0, block94.getTree());

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
		public ArrayList<String> pList;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "function_args"
	// Tiger.g:489:1: function_args returns [ArrayList<String> pList] : '(' expr_list ')' -> ( expr_list )? ;
	public final TigerParser.function_args_return function_args() throws RecognitionException {
		TigerParser.function_args_return retval = new TigerParser.function_args_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal95=null;
		Token char_literal97=null;
		ParserRuleReturnScope expr_list96 =null;

		Object char_literal95_tree=null;
		Object char_literal97_tree=null;
		RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
		RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
		RewriteRuleSubtreeStream stream_expr_list=new RewriteRuleSubtreeStream(adaptor,"rule expr_list");

		try {
			// Tiger.g:490:5: ( '(' expr_list ')' -> ( expr_list )? )
			// Tiger.g:490:7: '(' expr_list ')'
			{
			char_literal95=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_function_args2071);  
			stream_LPAREN.add(char_literal95);

			pushFollow(FOLLOW_expr_list_in_function_args2073);
			expr_list96=expr_list();
			state._fsp--;

			stream_expr_list.add(expr_list96.getTree());
			char_literal97=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_function_args2075);  
			stream_RPAREN.add(char_literal97);

			retval.pList = (expr_list96!=null?((TigerParser.expr_list_return)expr_list96).list:null);
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
			// 492:9: -> ( expr_list )?
			{
				// Tiger.g:492:12: ( expr_list )?
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
	// Tiger.g:495:1: function_call_or_assignment : ID ( function_args -> ^( FUNCTION_CALL ID ( function_args )? ) | value_tail ':=' expr_or_function_call -> ^( ':=' ^( ID ( value_tail )? ) expr_or_function_call ) ) ';' ;
	public final TigerParser.function_call_or_assignment_return function_call_or_assignment() throws RecognitionException {
		TigerParser.function_call_or_assignment_return retval = new TigerParser.function_call_or_assignment_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ID98=null;
		Token string_literal101=null;
		Token char_literal103=null;
		ParserRuleReturnScope function_args99 =null;
		ParserRuleReturnScope value_tail100 =null;
		ParserRuleReturnScope expr_or_function_call102 =null;

		Object ID98_tree=null;
		Object string_literal101_tree=null;
		Object char_literal103_tree=null;
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
		RewriteRuleTokenStream stream_ASSIGN=new RewriteRuleTokenStream(adaptor,"token ASSIGN");
		RewriteRuleSubtreeStream stream_expr_or_function_call=new RewriteRuleSubtreeStream(adaptor,"rule expr_or_function_call");
		RewriteRuleSubtreeStream stream_function_args=new RewriteRuleSubtreeStream(adaptor,"rule function_args");
		RewriteRuleSubtreeStream stream_value_tail=new RewriteRuleSubtreeStream(adaptor,"rule value_tail");

		try {
			// Tiger.g:496:5: ( ID ( function_args -> ^( FUNCTION_CALL ID ( function_args )? ) | value_tail ':=' expr_or_function_call -> ^( ':=' ^( ID ( value_tail )? ) expr_or_function_call ) ) ';' )
			// Tiger.g:496:7: ID ( function_args -> ^( FUNCTION_CALL ID ( function_args )? ) | value_tail ':=' expr_or_function_call -> ^( ':=' ^( ID ( value_tail )? ) expr_or_function_call ) ) ';'
			{
			ID98=(Token)match(input,ID,FOLLOW_ID_in_function_call_or_assignment2108);  
			stream_ID.add(ID98);

			// Tiger.g:497:9: ( function_args -> ^( FUNCTION_CALL ID ( function_args )? ) | value_tail ':=' expr_or_function_call -> ^( ':=' ^( ID ( value_tail )? ) expr_or_function_call ) )
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
					// Tiger.g:497:10: function_args
					{
					pushFollow(FOLLOW_function_args_in_function_call_or_assignment2120);
					function_args99=function_args();
					state._fsp--;

					stream_function_args.add(function_args99.getTree());

								checkFuncParam((ID98!=null?ID98.getText():null), (function_args99!=null?((TigerParser.function_args_return)function_args99).pList:null));
							
					// AST REWRITE
					// elements: ID, function_args
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 504:13: -> ^( FUNCTION_CALL ID ( function_args )? )
					{
						// Tiger.g:504:16: ^( FUNCTION_CALL ID ( function_args )? )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNCTION_CALL, "FUNCTION_CALL"), root_1);
						adaptor.addChild(root_1, stream_ID.nextNode());
						// Tiger.g:504:35: ( function_args )?
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
					// Tiger.g:506:11: value_tail ':=' expr_or_function_call
					{
					pushFollow(FOLLOW_value_tail_in_function_call_or_assignment2169);
					value_tail100=value_tail();
					state._fsp--;

					stream_value_tail.add(value_tail100.getTree());
					string_literal101=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_function_call_or_assignment2171);  
					stream_ASSIGN.add(string_literal101);

					pushFollow(FOLLOW_expr_or_function_call_in_function_call_or_assignment2173);
					expr_or_function_call102=expr_or_function_call();
					state._fsp--;

					stream_expr_or_function_call.add(expr_or_function_call102.getTree());

								Var v = getValue((ID98!=null?ID98.getText():null));
								Type t = (expr_or_function_call102!=null?((TigerParser.expr_or_function_call_return)expr_or_function_call102).t:null);
								if(v == null || t == null) {
									System.out.println((ID98!=null?ID98.getText():null) + " function_call_or_assignment NULL!");
								} else if(!((Id)v).type.name.equals(t.name)) {
									System.out.println((ID98!=null?ID98.getText():null) + "=> Assignment Type doesn't match!" + " " + ((Id)v).type.name + "/ "+ t.name);
								} else {
									((Id)v).initId();
								}
							
					// AST REWRITE
					// elements: value_tail, ID, expr_or_function_call, ASSIGN
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 521:13: -> ^( ':=' ^( ID ( value_tail )? ) expr_or_function_call )
					{
						// Tiger.g:521:16: ^( ':=' ^( ID ( value_tail )? ) expr_or_function_call )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot(stream_ASSIGN.nextNode(), root_1);
						// Tiger.g:521:23: ^( ID ( value_tail )? )
						{
						Object root_2 = (Object)adaptor.nil();
						root_2 = (Object)adaptor.becomeRoot(stream_ID.nextNode(), root_2);
						// Tiger.g:521:28: ( value_tail )?
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

			char_literal103=(Token)match(input,SEMI,FOLLOW_SEMI_in_function_call_or_assignment2225);  
			stream_SEMI.add(char_literal103);

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
		public Type t;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expr_or_function_call"
	// Tiger.g:527:1: expr_or_function_call returns [Type t] : ( ID ( expr_with_start_id[$ID, $ID.text] -> ^( EXPR_WITH_START_ID ( expr_with_start_id )? ) | ( ( function_args ) -> ^( FUNCTION_CALL ID ( function_args )? ) ) ) | ( expr_no_start_id ) );
	public final TigerParser.expr_or_function_call_return expr_or_function_call() throws RecognitionException {
		TigerParser.expr_or_function_call_return retval = new TigerParser.expr_or_function_call_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ID104=null;
		ParserRuleReturnScope expr_with_start_id105 =null;
		ParserRuleReturnScope function_args106 =null;
		ParserRuleReturnScope expr_no_start_id107 =null;

		Object ID104_tree=null;
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleSubtreeStream stream_function_args=new RewriteRuleSubtreeStream(adaptor,"rule function_args");
		RewriteRuleSubtreeStream stream_expr_with_start_id=new RewriteRuleSubtreeStream(adaptor,"rule expr_with_start_id");

		try {
			// Tiger.g:528:5: ( ID ( expr_with_start_id[$ID, $ID.text] -> ^( EXPR_WITH_START_ID ( expr_with_start_id )? ) | ( ( function_args ) -> ^( FUNCTION_CALL ID ( function_args )? ) ) ) | ( expr_no_start_id ) )
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
					// Tiger.g:528:7: ID ( expr_with_start_id[$ID, $ID.text] -> ^( EXPR_WITH_START_ID ( expr_with_start_id )? ) | ( ( function_args ) -> ^( FUNCTION_CALL ID ( function_args )? ) ) )
					{
					ID104=(Token)match(input,ID,FOLLOW_ID_in_expr_or_function_call2247);  
					stream_ID.add(ID104);

					// Tiger.g:529:9: ( expr_with_start_id[$ID, $ID.text] -> ^( EXPR_WITH_START_ID ( expr_with_start_id )? ) | ( ( function_args ) -> ^( FUNCTION_CALL ID ( function_args )? ) ) )
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
							// Tiger.g:529:10: expr_with_start_id[$ID, $ID.text]
							{
							pushFollow(FOLLOW_expr_with_start_id_in_expr_or_function_call2259);
							expr_with_start_id105=expr_with_start_id(ID104, (ID104!=null?ID104.getText():null));
							state._fsp--;

							stream_expr_with_start_id.add(expr_with_start_id105.getTree());
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
							// 532:3: -> ^( EXPR_WITH_START_ID ( expr_with_start_id )? )
							{
								// Tiger.g:532:6: ^( EXPR_WITH_START_ID ( expr_with_start_id )? )
								{
								Object root_1 = (Object)adaptor.nil();
								root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EXPR_WITH_START_ID, "EXPR_WITH_START_ID"), root_1);
								// Tiger.g:532:27: ( expr_with_start_id )?
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
							// Tiger.g:533:11: ( ( function_args ) -> ^( FUNCTION_CALL ID ( function_args )? ) )
							{
							// Tiger.g:533:11: ( ( function_args ) -> ^( FUNCTION_CALL ID ( function_args )? ) )
							// Tiger.g:533:12: ( function_args )
							{
							// Tiger.g:533:12: ( function_args )
							// Tiger.g:533:13: function_args
							{
							pushFollow(FOLLOW_function_args_in_expr_or_function_call2288);
							function_args106=function_args();
							state._fsp--;

							stream_function_args.add(function_args106.getTree());

										checkFuncParam((ID104!=null?ID104.getText():null), (function_args106!=null?((TigerParser.function_args_return)function_args106).pList:null));
										Var fun = getValue((ID104!=null?ID104.getText():null));
										if (fun == null) {
											System.out.println((ID104!=null?ID104.getText():null) + " Function not found in Symbol Table!");
										} else {
											retval.t = ((Function)fun).funcReturn();
										}
									
							}

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
							// 543:13: -> ^( FUNCTION_CALL ID ( function_args )? )
							{
								// Tiger.g:543:16: ^( FUNCTION_CALL ID ( function_args )? )
								{
								Object root_1 = (Object)adaptor.nil();
								root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNCTION_CALL, "FUNCTION_CALL"), root_1);
								adaptor.addChild(root_1, stream_ID.nextNode());
								// Tiger.g:543:35: ( function_args )?
								if ( stream_function_args.hasNext() ) {
									adaptor.addChild(root_1, stream_function_args.nextTree());
								}
								stream_function_args.reset();

								adaptor.addChild(root_0, root_1);
								}

							}


							retval.tree = root_0;

							}

							}
							break;

					}

					}
					break;
				case 2 :
					// Tiger.g:545:7: ( expr_no_start_id )
					{
					root_0 = (Object)adaptor.nil();


					// Tiger.g:545:7: ( expr_no_start_id )
					// Tiger.g:545:8: expr_no_start_id
					{
					pushFollow(FOLLOW_expr_no_start_id_in_expr_or_function_call2337);
					expr_no_start_id107=expr_no_start_id();
					state._fsp--;

					adaptor.addChild(root_0, expr_no_start_id107.getTree());

					}

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
		public Expr e;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expr"
	// Tiger.g:554:1: expr returns [Expr e] :t1= term4 ( and_operator ^t2= term4 )* ;
	public final TigerParser.expr_return expr() throws RecognitionException {
		TigerParser.expr_return retval = new TigerParser.expr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope t1 =null;
		ParserRuleReturnScope t2 =null;
		ParserRuleReturnScope and_operator108 =null;


		try {
			// Tiger.g:555:5: (t1= term4 ( and_operator ^t2= term4 )* )
			// Tiger.g:555:7: t1= term4 ( and_operator ^t2= term4 )*
			{
			root_0 = (Object)adaptor.nil();


			int i = 0;
			pushFollow(FOLLOW_term4_in_expr2370);
			t1=term4();
			state._fsp--;

			adaptor.addChild(root_0, t1.getTree());

			// Tiger.g:555:28: ( and_operator ^t2= term4 )*
			loop21:
			while (true) {
				int alt21=2;
				int LA21_0 = input.LA(1);
				if ( (LA21_0==AND||LA21_0==OR) ) {
					alt21=1;
				}

				switch (alt21) {
				case 1 :
					// Tiger.g:555:29: and_operator ^t2= term4
					{
					pushFollow(FOLLOW_and_operator_in_expr2373);
					and_operator108=and_operator();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(and_operator108.getTree(), root_0);
					pushFollow(FOLLOW_term4_in_expr2378);
					t2=term4();
					state._fsp--;

					adaptor.addChild(root_0, t2.getTree());


					                if (Logical.typeCheckPassed((t1!=null?((TigerParser.term4_return)t1).e:null), (t2!=null?((TigerParser.term4_return)t2).e:null))) {
					                    retval.e = new Expr("bool", Type.Bool);
					                }
					                i++;
					            
					}
					break;

				default :
					break loop21;
				}
			}


			          if (i == 0) {
			              retval.e = (t1!=null?((TigerParser.term4_return)t1).e:null); // if there is no second operand, term1's type should be returned
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
		public Expr e;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "term4"
	// Tiger.g:569:1: term4 returns [Expr e] :t1= term3 ( compare_operator ^t2= term3 )* ;
	public final TigerParser.term4_return term4() throws RecognitionException {
		TigerParser.term4_return retval = new TigerParser.term4_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope t1 =null;
		ParserRuleReturnScope t2 =null;
		ParserRuleReturnScope compare_operator109 =null;


		try {
			// Tiger.g:570:5: (t1= term3 ( compare_operator ^t2= term3 )* )
			// Tiger.g:570:7: t1= term3 ( compare_operator ^t2= term3 )*
			{
			root_0 = (Object)adaptor.nil();


			int i = 0;
			pushFollow(FOLLOW_term3_in_term42421);
			t1=term3();
			state._fsp--;

			adaptor.addChild(root_0, t1.getTree());

			// Tiger.g:570:28: ( compare_operator ^t2= term3 )*
			loop22:
			while (true) {
				int alt22=2;
				int LA22_0 = input.LA(1);
				if ( (LA22_0==EQ||(LA22_0 >= GREATER && LA22_0 <= GREATEREQ)||(LA22_0 >= LESSER && LA22_0 <= LESSEREQ)||LA22_0==NEQ) ) {
					alt22=1;
				}

				switch (alt22) {
				case 1 :
					// Tiger.g:570:29: compare_operator ^t2= term3
					{
					pushFollow(FOLLOW_compare_operator_in_term42424);
					compare_operator109=compare_operator();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(compare_operator109.getTree(), root_0);
					pushFollow(FOLLOW_term3_in_term42429);
					t2=term3();
					state._fsp--;

					adaptor.addChild(root_0, t2.getTree());


					                if (Arith.typeCheckPassed((t1!=null?((TigerParser.term3_return)t1).e:null), (t2!=null?((TigerParser.term3_return)t2).e:null))) {
					                     retval.e = new Expr("bool", Type.Bool);   
						// if both terms' types are correct, a boolean value should be returned 
					                    }
					                    i++;
					            
					}
					break;

				default :
					break loop22;
				}
			}


					if(i == 0) {
						retval.e = (t1!=null?((TigerParser.term3_return)t1).e:null); // if there is no second operand, term1's type should be returned
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
		public Expr e;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "term3"
	// Tiger.g:584:1: term3 returns [Expr e] :t1= term2 ( add_operator ^t2= term2 )* ;
	public final TigerParser.term3_return term3() throws RecognitionException {
		TigerParser.term3_return retval = new TigerParser.term3_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope t1 =null;
		ParserRuleReturnScope t2 =null;
		ParserRuleReturnScope add_operator110 =null;


		try {
			// Tiger.g:585:5: (t1= term2 ( add_operator ^t2= term2 )* )
			// Tiger.g:585:7: t1= term2 ( add_operator ^t2= term2 )*
			{
			root_0 = (Object)adaptor.nil();


			int i = 0;
			pushFollow(FOLLOW_term2_in_term32474);
			t1=term2();
			state._fsp--;

			adaptor.addChild(root_0, t1.getTree());

			// Tiger.g:585:28: ( add_operator ^t2= term2 )*
			loop23:
			while (true) {
				int alt23=2;
				int LA23_0 = input.LA(1);
				if ( (LA23_0==MINUS||LA23_0==PLUS) ) {
					alt23=1;
				}

				switch (alt23) {
				case 1 :
					// Tiger.g:585:29: add_operator ^t2= term2
					{
					pushFollow(FOLLOW_add_operator_in_term32477);
					add_operator110=add_operator();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(add_operator110.getTree(), root_0);
					pushFollow(FOLLOW_term2_in_term32482);
					t2=term2();
					state._fsp--;

					adaptor.addChild(root_0, t2.getTree());


							if (Arith.typeCheckPassed((t1!=null?((TigerParser.term2_return)t1).e:null), (t2!=null?((TigerParser.term2_return)t2).e:null))) {
								retval.e = Arith.getFinalType((t1!=null?((TigerParser.term2_return)t1).e:null), (t2!=null?((TigerParser.term2_return)t2).e:null));
							}
							i++;
						
					}
					break;

				default :
					break loop23;
				}
			}


					if(i==0) {
						retval.e = (t1!=null?((TigerParser.term2_return)t1).e:null);
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
		public Expr e;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "term2"
	// Tiger.g:598:1: term2 returns [Expr e] :t1= term1 ( mult_operator ^t2= term1 )* ;
	public final TigerParser.term2_return term2() throws RecognitionException {
		TigerParser.term2_return retval = new TigerParser.term2_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope t1 =null;
		ParserRuleReturnScope t2 =null;
		ParserRuleReturnScope mult_operator111 =null;


		try {
			// Tiger.g:599:5: (t1= term1 ( mult_operator ^t2= term1 )* )
			// Tiger.g:599:7: t1= term1 ( mult_operator ^t2= term1 )*
			{
			root_0 = (Object)adaptor.nil();


			int i = 0;
			pushFollow(FOLLOW_term1_in_term22510);
			t1=term1();
			state._fsp--;

			adaptor.addChild(root_0, t1.getTree());

			// Tiger.g:599:28: ( mult_operator ^t2= term1 )*
			loop24:
			while (true) {
				int alt24=2;
				int LA24_0 = input.LA(1);
				if ( (LA24_0==DIV||LA24_0==MULT) ) {
					alt24=1;
				}

				switch (alt24) {
				case 1 :
					// Tiger.g:599:29: mult_operator ^t2= term1
					{
					pushFollow(FOLLOW_mult_operator_in_term22513);
					mult_operator111=mult_operator();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(mult_operator111.getTree(), root_0);
					pushFollow(FOLLOW_term1_in_term22518);
					t2=term1();
					state._fsp--;

					adaptor.addChild(root_0, t2.getTree());


							if(Arith.typeCheckPassed((t1!=null?((TigerParser.term1_return)t1).e:null), (t2!=null?((TigerParser.term1_return)t2).e:null))) {
								retval.e = Arith.getFinalType((t1!=null?((TigerParser.term1_return)t1).e:null), (t2!=null?((TigerParser.term1_return)t2).e:null));
							}
					            	i++;

						
					}
					break;

				default :
					break loop24;
				}
			}


			            if(i == 0) {
			                retval.e = (t1!=null?((TigerParser.term1_return)t1).e:null);
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
		public Expr e;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "term1"
	// Tiger.g:613:1: term1 returns [Expr e] : ( literal | value | '(' expr ')' -> expr );
	public final TigerParser.term1_return term1() throws RecognitionException {
		TigerParser.term1_return retval = new TigerParser.term1_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal114=null;
		Token char_literal116=null;
		ParserRuleReturnScope literal112 =null;
		ParserRuleReturnScope value113 =null;
		ParserRuleReturnScope expr115 =null;

		Object char_literal114_tree=null;
		Object char_literal116_tree=null;
		RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
		RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// Tiger.g:614:5: ( literal | value | '(' expr ')' -> expr )
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
					// Tiger.g:614:7: literal
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_literal_in_term12541);
					literal112=literal();
					state._fsp--;

					adaptor.addChild(root_0, literal112.getTree());

					retval.e = (literal112!=null?((TigerParser.literal_return)literal112).e:null);
					}
					break;
				case 2 :
					// Tiger.g:615:7: value
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_value_in_term12551);
					value113=value();
					state._fsp--;

					adaptor.addChild(root_0, value113.getTree());

					retval.e = (value113!=null?((TigerParser.value_return)value113).e:null);
					}
					break;
				case 3 :
					// Tiger.g:616:7: '(' expr ')'
					{
					char_literal114=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_term12561);  
					stream_LPAREN.add(char_literal114);

					pushFollow(FOLLOW_expr_in_term12563);
					expr115=expr();
					state._fsp--;

					stream_expr.add(expr115.getTree());
					char_literal116=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_term12565);  
					stream_RPAREN.add(char_literal116);

					retval.e = (expr115!=null?((TigerParser.expr_return)expr115).e:null);
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
					// 617:9: -> expr
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
		public Expr e;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expr_no_start_id"
	// Tiger.g:620:1: expr_no_start_id returns [Expr e] :t1= term4_no_start_id ( and_operator ^t2= term4 )* ;
	public final TigerParser.expr_no_start_id_return expr_no_start_id() throws RecognitionException {
		TigerParser.expr_no_start_id_return retval = new TigerParser.expr_no_start_id_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope t1 =null;
		ParserRuleReturnScope t2 =null;
		ParserRuleReturnScope and_operator117 =null;


		try {
			// Tiger.g:621:5: (t1= term4_no_start_id ( and_operator ^t2= term4 )* )
			// Tiger.g:621:7: t1= term4_no_start_id ( and_operator ^t2= term4 )*
			{
			root_0 = (Object)adaptor.nil();


			int i = 0;
			pushFollow(FOLLOW_term4_no_start_id_in_expr_no_start_id2602);
			t1=term4_no_start_id();
			state._fsp--;

			adaptor.addChild(root_0, t1.getTree());

			// Tiger.g:621:40: ( and_operator ^t2= term4 )*
			loop26:
			while (true) {
				int alt26=2;
				int LA26_0 = input.LA(1);
				if ( (LA26_0==AND||LA26_0==OR) ) {
					alt26=1;
				}

				switch (alt26) {
				case 1 :
					// Tiger.g:621:41: and_operator ^t2= term4
					{
					pushFollow(FOLLOW_and_operator_in_expr_no_start_id2605);
					and_operator117=and_operator();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(and_operator117.getTree(), root_0);
					pushFollow(FOLLOW_term4_in_expr_no_start_id2610);
					t2=term4();
					state._fsp--;

					adaptor.addChild(root_0, t2.getTree());


					                if (Logical.typeCheckPassed((t1!=null?((TigerParser.term4_no_start_id_return)t1).e:null), (t2!=null?((TigerParser.term4_return)t2).e:null))) {
					                    retval.e = new Expr("bool", Type.Bool);
					                }
					                i++;
					            
					}
					break;

				default :
					break loop26;
				}
			}


			          if (i == 0) {
			              retval.e = (t1!=null?((TigerParser.term4_no_start_id_return)t1).e:null); // if there is no second operand, term1's type should be returned
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
		public Expr e;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "term4_no_start_id"
	// Tiger.g:635:1: term4_no_start_id returns [Expr e] :t1= term3_no_start_id ( compare_operator ^t2= term3 )* ;
	public final TigerParser.term4_no_start_id_return term4_no_start_id() throws RecognitionException {
		TigerParser.term4_no_start_id_return retval = new TigerParser.term4_no_start_id_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope t1 =null;
		ParserRuleReturnScope t2 =null;
		ParserRuleReturnScope compare_operator118 =null;


		try {
			// Tiger.g:636:5: (t1= term3_no_start_id ( compare_operator ^t2= term3 )* )
			// Tiger.g:636:7: t1= term3_no_start_id ( compare_operator ^t2= term3 )*
			{
			root_0 = (Object)adaptor.nil();


			int i = 0;
			pushFollow(FOLLOW_term3_no_start_id_in_term4_no_start_id2653);
			t1=term3_no_start_id();
			state._fsp--;

			adaptor.addChild(root_0, t1.getTree());

			// Tiger.g:636:40: ( compare_operator ^t2= term3 )*
			loop27:
			while (true) {
				int alt27=2;
				int LA27_0 = input.LA(1);
				if ( (LA27_0==EQ||(LA27_0 >= GREATER && LA27_0 <= GREATEREQ)||(LA27_0 >= LESSER && LA27_0 <= LESSEREQ)||LA27_0==NEQ) ) {
					alt27=1;
				}

				switch (alt27) {
				case 1 :
					// Tiger.g:636:41: compare_operator ^t2= term3
					{
					pushFollow(FOLLOW_compare_operator_in_term4_no_start_id2656);
					compare_operator118=compare_operator();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(compare_operator118.getTree(), root_0);
					pushFollow(FOLLOW_term3_in_term4_no_start_id2661);
					t2=term3();
					state._fsp--;

					adaptor.addChild(root_0, t2.getTree());


					                if (Arith.typeCheckPassed((t1!=null?((TigerParser.term3_no_start_id_return)t1).e:null), (t2!=null?((TigerParser.term3_return)t2).e:null))) {
					                     retval.e = new Expr("bool", Type.Bool);   
						// if both terms' types are correct, a boolean value should be returned 
					                    }
					                    i++;
					            
					}
					break;

				default :
					break loop27;
				}
			}


					if(i == 0) {
						retval.e = (t1!=null?((TigerParser.term3_no_start_id_return)t1).e:null); // if there is no second operand, term1's type should be returned
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
		public Expr e;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "term3_no_start_id"
	// Tiger.g:651:1: term3_no_start_id returns [Expr e] :t1= term2_no_start_id ( add_operator ^t2= term2 )* ;
	public final TigerParser.term3_no_start_id_return term3_no_start_id() throws RecognitionException {
		TigerParser.term3_no_start_id_return retval = new TigerParser.term3_no_start_id_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope t1 =null;
		ParserRuleReturnScope t2 =null;
		ParserRuleReturnScope add_operator119 =null;


		try {
			// Tiger.g:652:5: (t1= term2_no_start_id ( add_operator ^t2= term2 )* )
			// Tiger.g:652:7: t1= term2_no_start_id ( add_operator ^t2= term2 )*
			{
			root_0 = (Object)adaptor.nil();


			int i = 0;
			pushFollow(FOLLOW_term2_no_start_id_in_term3_no_start_id2704);
			t1=term2_no_start_id();
			state._fsp--;

			adaptor.addChild(root_0, t1.getTree());

			// Tiger.g:652:40: ( add_operator ^t2= term2 )*
			loop28:
			while (true) {
				int alt28=2;
				int LA28_0 = input.LA(1);
				if ( (LA28_0==MINUS||LA28_0==PLUS) ) {
					alt28=1;
				}

				switch (alt28) {
				case 1 :
					// Tiger.g:652:41: add_operator ^t2= term2
					{
					pushFollow(FOLLOW_add_operator_in_term3_no_start_id2707);
					add_operator119=add_operator();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(add_operator119.getTree(), root_0);
					pushFollow(FOLLOW_term2_in_term3_no_start_id2712);
					t2=term2();
					state._fsp--;

					adaptor.addChild(root_0, t2.getTree());


							if (Arith.typeCheckPassed((t1!=null?((TigerParser.term2_no_start_id_return)t1).e:null), (t2!=null?((TigerParser.term2_return)t2).e:null))) {
								retval.e = Arith.getFinalType((t1!=null?((TigerParser.term2_no_start_id_return)t1).e:null), (t2!=null?((TigerParser.term2_return)t2).e:null));
							}
							i++;
						
					}
					break;

				default :
					break loop28;
				}
			}


					if(i==0) {
						retval.e = (t1!=null?((TigerParser.term2_no_start_id_return)t1).e:null);
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
		public Expr e;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "term2_no_start_id"
	// Tiger.g:665:1: term2_no_start_id returns [Expr e] :t1= term1_no_start_id ( mult_operator ^t2= term1 )* ;
	public final TigerParser.term2_no_start_id_return term2_no_start_id() throws RecognitionException {
		TigerParser.term2_no_start_id_return retval = new TigerParser.term2_no_start_id_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope t1 =null;
		ParserRuleReturnScope t2 =null;
		ParserRuleReturnScope mult_operator120 =null;


		try {
			// Tiger.g:666:5: (t1= term1_no_start_id ( mult_operator ^t2= term1 )* )
			// Tiger.g:666:7: t1= term1_no_start_id ( mult_operator ^t2= term1 )*
			{
			root_0 = (Object)adaptor.nil();


			int i = 0;
			pushFollow(FOLLOW_term1_no_start_id_in_term2_no_start_id2739);
			t1=term1_no_start_id();
			state._fsp--;

			adaptor.addChild(root_0, t1.getTree());

			// Tiger.g:666:40: ( mult_operator ^t2= term1 )*
			loop29:
			while (true) {
				int alt29=2;
				int LA29_0 = input.LA(1);
				if ( (LA29_0==DIV||LA29_0==MULT) ) {
					alt29=1;
				}

				switch (alt29) {
				case 1 :
					// Tiger.g:666:41: mult_operator ^t2= term1
					{
					pushFollow(FOLLOW_mult_operator_in_term2_no_start_id2742);
					mult_operator120=mult_operator();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(mult_operator120.getTree(), root_0);
					pushFollow(FOLLOW_term1_in_term2_no_start_id2747);
					t2=term1();
					state._fsp--;

					adaptor.addChild(root_0, t2.getTree());


							if(Arith.typeCheckPassed((t1!=null?((TigerParser.term1_no_start_id_return)t1).e:null), (t2!=null?((TigerParser.term1_return)t2).e:null))) {
								retval.e = Arith.getFinalType((t1!=null?((TigerParser.term1_no_start_id_return)t1).e:null), (t2!=null?((TigerParser.term1_return)t2).e:null));
							}
					            	i++;

						
					}
					break;

				default :
					break loop29;
				}
			}


			            if(i == 0) {
			                retval.e = (t1!=null?((TigerParser.term1_no_start_id_return)t1).e:null);
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
		public Expr e;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "term1_no_start_id"
	// Tiger.g:681:1: term1_no_start_id returns [Expr e] : ( literal | '(' expr ')' -> expr );
	public final TigerParser.term1_no_start_id_return term1_no_start_id() throws RecognitionException {
		TigerParser.term1_no_start_id_return retval = new TigerParser.term1_no_start_id_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal122=null;
		Token char_literal124=null;
		ParserRuleReturnScope literal121 =null;
		ParserRuleReturnScope expr123 =null;

		Object char_literal122_tree=null;
		Object char_literal124_tree=null;
		RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
		RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// Tiger.g:682:5: ( literal | '(' expr ')' -> expr )
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
					// Tiger.g:682:7: literal
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_literal_in_term1_no_start_id2771);
					literal121=literal();
					state._fsp--;

					adaptor.addChild(root_0, literal121.getTree());

					retval.e = (literal121!=null?((TigerParser.literal_return)literal121).e:null);
					}
					break;
				case 2 :
					// Tiger.g:683:7: '(' expr ')'
					{
					char_literal122=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_term1_no_start_id2781);  
					stream_LPAREN.add(char_literal122);

					pushFollow(FOLLOW_expr_in_term1_no_start_id2783);
					expr123=expr();
					state._fsp--;

					stream_expr.add(expr123.getTree());
					char_literal124=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_term1_no_start_id2785);  
					stream_RPAREN.add(char_literal124);

					retval.e = (expr123!=null?((TigerParser.expr_return)expr123).e:null);
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
					// 684:9: -> expr
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
		public Expr e;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expr_with_start_id"
	// Tiger.g:687:1: expr_with_start_id[Token startId, String s] returns [Expr e] :t1= term4_with_start_id[$startId, $s] ( and_operator ^t2= term4 )* ;
	public final TigerParser.expr_with_start_id_return expr_with_start_id(Token startId, String s) throws RecognitionException {
		TigerParser.expr_with_start_id_return retval = new TigerParser.expr_with_start_id_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope t1 =null;
		ParserRuleReturnScope t2 =null;
		ParserRuleReturnScope and_operator125 =null;


		try {
			// Tiger.g:688:5: (t1= term4_with_start_id[$startId, $s] ( and_operator ^t2= term4 )* )
			// Tiger.g:688:7: t1= term4_with_start_id[$startId, $s] ( and_operator ^t2= term4 )*
			{
			root_0 = (Object)adaptor.nil();


			int i = 0;
			pushFollow(FOLLOW_term4_with_start_id_in_expr_with_start_id2826);
			t1=term4_with_start_id(startId, s);
			state._fsp--;

			adaptor.addChild(root_0, t1.getTree());

			// Tiger.g:688:57: ( and_operator ^t2= term4 )*
			loop31:
			while (true) {
				int alt31=2;
				int LA31_0 = input.LA(1);
				if ( (LA31_0==AND||LA31_0==OR) ) {
					alt31=1;
				}

				switch (alt31) {
				case 1 :
					// Tiger.g:688:58: and_operator ^t2= term4
					{
					pushFollow(FOLLOW_and_operator_in_expr_with_start_id2830);
					and_operator125=and_operator();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(and_operator125.getTree(), root_0);
					pushFollow(FOLLOW_term4_in_expr_with_start_id2835);
					t2=term4();
					state._fsp--;

					adaptor.addChild(root_0, t2.getTree());


					                if (Logical.typeCheckPassed((t1!=null?((TigerParser.term4_with_start_id_return)t1).e:null), (t2!=null?((TigerParser.term4_return)t2).e:null))) {
					                    retval.e = new Expr("bool", Type.Bool);
					                }
					                i++;
					            
					}
					break;

				default :
					break loop31;
				}
			}


			          if (i == 0) {
			              retval.e = (t1!=null?((TigerParser.term4_with_start_id_return)t1).e:null); // if there is no second operand, term1's type should be returned
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
		public Expr e;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "term4_with_start_id"
	// Tiger.g:702:1: term4_with_start_id[Token startId, String s] returns [Expr e] :t1= term3_with_start_id[$startId, $s] ( compare_operator ^t2= term3 )* ;
	public final TigerParser.term4_with_start_id_return term4_with_start_id(Token startId, String s) throws RecognitionException {
		TigerParser.term4_with_start_id_return retval = new TigerParser.term4_with_start_id_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope t1 =null;
		ParserRuleReturnScope t2 =null;
		ParserRuleReturnScope compare_operator126 =null;


		try {
			// Tiger.g:703:5: (t1= term3_with_start_id[$startId, $s] ( compare_operator ^t2= term3 )* )
			// Tiger.g:703:7: t1= term3_with_start_id[$startId, $s] ( compare_operator ^t2= term3 )*
			{
			root_0 = (Object)adaptor.nil();


			int i = 0;
			pushFollow(FOLLOW_term3_with_start_id_in_term4_with_start_id2870);
			t1=term3_with_start_id(startId, s);
			state._fsp--;

			adaptor.addChild(root_0, t1.getTree());

			// Tiger.g:703:57: ( compare_operator ^t2= term3 )*
			loop32:
			while (true) {
				int alt32=2;
				int LA32_0 = input.LA(1);
				if ( (LA32_0==EQ||(LA32_0 >= GREATER && LA32_0 <= GREATEREQ)||(LA32_0 >= LESSER && LA32_0 <= LESSEREQ)||LA32_0==NEQ) ) {
					alt32=1;
				}

				switch (alt32) {
				case 1 :
					// Tiger.g:703:58: compare_operator ^t2= term3
					{
					pushFollow(FOLLOW_compare_operator_in_term4_with_start_id2874);
					compare_operator126=compare_operator();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(compare_operator126.getTree(), root_0);
					pushFollow(FOLLOW_term3_in_term4_with_start_id2879);
					t2=term3();
					state._fsp--;

					adaptor.addChild(root_0, t2.getTree());


					                if (Arith.typeCheckPassed((t1!=null?((TigerParser.term3_with_start_id_return)t1).e:null), (t2!=null?((TigerParser.term3_return)t2).e:null))) {
					                     retval.e = new Expr("bool", Type.Bool);   
						// if both terms' types are correct, a boolean value should be returned 
					                    }
					                    i++;
					            
					}
					break;

				default :
					break loop32;
				}
			}


					if(i == 0) {
						retval.e = (t1!=null?((TigerParser.term3_with_start_id_return)t1).e:null); // if there is no second operand, term1's type should be returned
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
		public Expr e;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "term3_with_start_id"
	// Tiger.g:718:1: term3_with_start_id[Token startId, String s] returns [Expr e] :t1= term2_with_start_id[$startId, $s] ( add_operator ^t2= term2 )* ;
	public final TigerParser.term3_with_start_id_return term3_with_start_id(Token startId, String s) throws RecognitionException {
		TigerParser.term3_with_start_id_return retval = new TigerParser.term3_with_start_id_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope t1 =null;
		ParserRuleReturnScope t2 =null;
		ParserRuleReturnScope add_operator127 =null;


		try {
			// Tiger.g:719:5: (t1= term2_with_start_id[$startId, $s] ( add_operator ^t2= term2 )* )
			// Tiger.g:719:7: t1= term2_with_start_id[$startId, $s] ( add_operator ^t2= term2 )*
			{
			root_0 = (Object)adaptor.nil();


			int i = 0;
			pushFollow(FOLLOW_term2_with_start_id_in_term3_with_start_id2925);
			t1=term2_with_start_id(startId, s);
			state._fsp--;

			adaptor.addChild(root_0, t1.getTree());

			// Tiger.g:719:57: ( add_operator ^t2= term2 )*
			loop33:
			while (true) {
				int alt33=2;
				int LA33_0 = input.LA(1);
				if ( (LA33_0==MINUS||LA33_0==PLUS) ) {
					alt33=1;
				}

				switch (alt33) {
				case 1 :
					// Tiger.g:719:58: add_operator ^t2= term2
					{
					pushFollow(FOLLOW_add_operator_in_term3_with_start_id2929);
					add_operator127=add_operator();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(add_operator127.getTree(), root_0);
					pushFollow(FOLLOW_term2_in_term3_with_start_id2934);
					t2=term2();
					state._fsp--;

					adaptor.addChild(root_0, t2.getTree());


							if (Arith.typeCheckPassed((t1!=null?((TigerParser.term2_with_start_id_return)t1).e:null), (t2!=null?((TigerParser.term2_return)t2).e:null))) {
								retval.e = Arith.getFinalType((t1!=null?((TigerParser.term2_with_start_id_return)t1).e:null), (t2!=null?((TigerParser.term2_return)t2).e:null));
							}
							i++;
						
					}
					break;

				default :
					break loop33;
				}
			}


					if(i==0) {
						retval.e = (t1!=null?((TigerParser.term2_with_start_id_return)t1).e:null);
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
		public Expr e;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "term2_with_start_id"
	// Tiger.g:733:1: term2_with_start_id[Token startId, String s] returns [Expr e] :t1= term1_with_start_id[$startId, $s] ( mult_operator ^t2= term1 )* ;
	public final TigerParser.term2_with_start_id_return term2_with_start_id(Token startId, String s) throws RecognitionException {
		TigerParser.term2_with_start_id_return retval = new TigerParser.term2_with_start_id_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope t1 =null;
		ParserRuleReturnScope t2 =null;
		ParserRuleReturnScope mult_operator128 =null;


		try {
			// Tiger.g:734:5: (t1= term1_with_start_id[$startId, $s] ( mult_operator ^t2= term1 )* )
			// Tiger.g:734:7: t1= term1_with_start_id[$startId, $s] ( mult_operator ^t2= term1 )*
			{
			root_0 = (Object)adaptor.nil();


			int i = 0;
			pushFollow(FOLLOW_term1_with_start_id_in_term2_with_start_id2965);
			t1=term1_with_start_id(startId, s);
			state._fsp--;

			adaptor.addChild(root_0, t1.getTree());

			// Tiger.g:734:57: ( mult_operator ^t2= term1 )*
			loop34:
			while (true) {
				int alt34=2;
				int LA34_0 = input.LA(1);
				if ( (LA34_0==DIV||LA34_0==MULT) ) {
					alt34=1;
				}

				switch (alt34) {
				case 1 :
					// Tiger.g:734:58: mult_operator ^t2= term1
					{
					pushFollow(FOLLOW_mult_operator_in_term2_with_start_id2969);
					mult_operator128=mult_operator();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(mult_operator128.getTree(), root_0);
					pushFollow(FOLLOW_term1_in_term2_with_start_id2974);
					t2=term1();
					state._fsp--;

					adaptor.addChild(root_0, t2.getTree());


							if(Arith.typeCheckPassed((t1!=null?((TigerParser.term1_with_start_id_return)t1).e:null), (t2!=null?((TigerParser.term1_return)t2).e:null))) {
								retval.e = Arith.getFinalType((t1!=null?((TigerParser.term1_with_start_id_return)t1).e:null), (t2!=null?((TigerParser.term1_return)t2).e:null));
							}
					            	i++;

						
					}
					break;

				default :
					break loop34;
				}
			}


			            if(i == 0) {
			                retval.e = (t1!=null?((TigerParser.term1_with_start_id_return)t1).e:null);
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
		public Expr e;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "term1_with_start_id"
	// Tiger.g:750:1: term1_with_start_id[Token startId, String s] returns [Expr e] : value_tail -> ^( ( value_tail )? ) ;
	public final TigerParser.term1_with_start_id_return term1_with_start_id(Token startId, String s) throws RecognitionException {
		TigerParser.term1_with_start_id_return retval = new TigerParser.term1_with_start_id_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope value_tail129 =null;

		RewriteRuleSubtreeStream stream_value_tail=new RewriteRuleSubtreeStream(adaptor,"rule value_tail");

		try {
			// Tiger.g:751:5: ( value_tail -> ^( ( value_tail )? ) )
			// Tiger.g:751:7: value_tail
			{
			pushFollow(FOLLOW_value_tail_in_term1_with_start_id3000);
			value_tail129=value_tail();
			state._fsp--;

			stream_value_tail.add(value_tail129.getTree());

					Var v = getValue(s);
					if(v == null) {
						System.out.println(s + " Symbol not found! / term1_with_start_id");
					} else if(!(v instanceof Id)) {
						System.out.println(s + " is not Id! / term1_with_start_id");
					} else {
						retval.e = ((Expr)v);
					}
				
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
			// 762:2: -> ^( ( value_tail )? )
			{
				// Tiger.g:762:5: ^( ( value_tail )? )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot(new CommonTree(startId), root_1);
				// Tiger.g:762:34: ( value_tail )?
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
		public ArrayList<String> list;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expr_list"
	// Tiger.g:766:1: expr_list returns [ArrayList<String> list] : (e1= expr ( ',' e2= expr )* -> ^( EXPRLIST ( expr )+ ) |);
	public final TigerParser.expr_list_return expr_list() throws RecognitionException {
		TigerParser.expr_list_return retval = new TigerParser.expr_list_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal130=null;
		ParserRuleReturnScope e1 =null;
		ParserRuleReturnScope e2 =null;

		Object char_literal130_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// Tiger.g:767:5: (e1= expr ( ',' e2= expr )* -> ^( EXPRLIST ( expr )+ ) |)
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
					// Tiger.g:767:7: e1= expr ( ',' e2= expr )*
					{
					retval.list = new ArrayList();
					pushFollow(FOLLOW_expr_in_expr_list3038);
					e1=expr();
					state._fsp--;

					stream_expr.add(e1.getTree());
					retval.list.add((e1!=null?input.toString(e1.start,e1.stop):null));
					// Tiger.g:768:2: ( ',' e2= expr )*
					loop35:
					while (true) {
						int alt35=2;
						int LA35_0 = input.LA(1);
						if ( (LA35_0==COMMA) ) {
							alt35=1;
						}

						switch (alt35) {
						case 1 :
							// Tiger.g:768:4: ',' e2= expr
							{
							char_literal130=(Token)match(input,COMMA,FOLLOW_COMMA_in_expr_list3046);  
							stream_COMMA.add(char_literal130);

							pushFollow(FOLLOW_expr_in_expr_list3050);
							e2=expr();
							state._fsp--;

							stream_expr.add(e2.getTree());
							retval.list.add((e2!=null?input.toString(e2.start,e2.stop):null));
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
					// 768:41: -> ^( EXPRLIST ( expr )+ )
					{
						// Tiger.g:768:44: ^( EXPRLIST ( expr )+ )
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
					// Tiger.g:770:5: 
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
	// Tiger.g:772:1: mult_operator : ( '*' | '/' );
	public final TigerParser.mult_operator_return mult_operator() throws RecognitionException {
		TigerParser.mult_operator_return retval = new TigerParser.mult_operator_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set131=null;

		Object set131_tree=null;

		try {
			// Tiger.g:773:5: ( '*' | '/' )
			// Tiger.g:
			{
			root_0 = (Object)adaptor.nil();


			set131=input.LT(1);
			if ( input.LA(1)==DIV||input.LA(1)==MULT ) {
				input.consume();
				adaptor.addChild(root_0, (Object)adaptor.create(set131));
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
	// Tiger.g:775:1: add_operator : ( '+' | '-' );
	public final TigerParser.add_operator_return add_operator() throws RecognitionException {
		TigerParser.add_operator_return retval = new TigerParser.add_operator_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set132=null;

		Object set132_tree=null;

		try {
			// Tiger.g:776:5: ( '+' | '-' )
			// Tiger.g:
			{
			root_0 = (Object)adaptor.nil();


			set132=input.LT(1);
			if ( input.LA(1)==MINUS||input.LA(1)==PLUS ) {
				input.consume();
				adaptor.addChild(root_0, (Object)adaptor.create(set132));
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
	// Tiger.g:778:1: compare_operator : ( '=' | '<>' | '<' | '>' | '<=' | '>=' );
	public final TigerParser.compare_operator_return compare_operator() throws RecognitionException {
		TigerParser.compare_operator_return retval = new TigerParser.compare_operator_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set133=null;

		Object set133_tree=null;

		try {
			// Tiger.g:779:5: ( '=' | '<>' | '<' | '>' | '<=' | '>=' )
			// Tiger.g:
			{
			root_0 = (Object)adaptor.nil();


			set133=input.LT(1);
			if ( input.LA(1)==EQ||(input.LA(1) >= GREATER && input.LA(1) <= GREATEREQ)||(input.LA(1) >= LESSER && input.LA(1) <= LESSEREQ)||input.LA(1)==NEQ ) {
				input.consume();
				adaptor.addChild(root_0, (Object)adaptor.create(set133));
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
	// Tiger.g:781:1: and_operator : ( '&' | '|' );
	public final TigerParser.and_operator_return and_operator() throws RecognitionException {
		TigerParser.and_operator_return retval = new TigerParser.and_operator_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set134=null;

		Object set134_tree=null;

		try {
			// Tiger.g:782:5: ( '&' | '|' )
			// Tiger.g:
			{
			root_0 = (Object)adaptor.nil();


			set134=input.LT(1);
			if ( input.LA(1)==AND||input.LA(1)==OR ) {
				input.consume();
				adaptor.addChild(root_0, (Object)adaptor.create(set134));
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
		public Expr e;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "value"
	// Tiger.g:784:1: value returns [Expr e] : ID value_tail -> ^( ID ( value_tail )? ) ;
	public final TigerParser.value_return value() throws RecognitionException {
		TigerParser.value_return retval = new TigerParser.value_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ID135=null;
		ParserRuleReturnScope value_tail136 =null;

		Object ID135_tree=null;
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleSubtreeStream stream_value_tail=new RewriteRuleSubtreeStream(adaptor,"rule value_tail");

		try {
			// Tiger.g:785:5: ( ID value_tail -> ^( ID ( value_tail )? ) )
			// Tiger.g:785:7: ID value_tail
			{
			ID135=(Token)match(input,ID,FOLLOW_ID_in_value3177);  
			stream_ID.add(ID135);

			pushFollow(FOLLOW_value_tail_in_value3179);
			value_tail136=value_tail();
			state._fsp--;

			stream_value_tail.add(value_tail136.getTree());

					Var v = getValue((ID135!=null?ID135.getText():null));
					if (!(v instanceof Id)) {
						System.out.println((ID135!=null?ID135.getText():null) + " is not Id value Type!");
					} else if(!((Id)v).init) {
						System.out.println((ID135!=null?ID135.getText():null) + " is not initialized before use!");
					} else {
						retval.e = ((Id)v);
					}
				
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
			// 797:21: -> ^( ID ( value_tail )? )
			{
				// Tiger.g:797:4: ^( ID ( value_tail )? )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot(stream_ID.nextNode(), root_1);
				// Tiger.g:797:9: ( value_tail )?
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
		public Expr e;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "literal"
	// Tiger.g:799:1: literal returns [Expr e] : ( INTLIT | FIXEDPTLIT );
	public final TigerParser.literal_return literal() throws RecognitionException {
		TigerParser.literal_return retval = new TigerParser.literal_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token INTLIT137=null;
		Token FIXEDPTLIT138=null;

		Object INTLIT137_tree=null;
		Object FIXEDPTLIT138_tree=null;

		try {
			// Tiger.g:800:5: ( INTLIT | FIXEDPTLIT )
			int alt37=2;
			int LA37_0 = input.LA(1);
			if ( (LA37_0==INTLIT) ) {
				alt37=1;
			}
			else if ( (LA37_0==FIXEDPTLIT) ) {
				alt37=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 37, 0, input);
				throw nvae;
			}

			switch (alt37) {
				case 1 :
					// Tiger.g:800:7: INTLIT
					{
					root_0 = (Object)adaptor.nil();


					INTLIT137=(Token)match(input,INTLIT,FOLLOW_INTLIT_in_literal3208); 
					INTLIT137_tree = (Object)adaptor.create(INTLIT137);
					adaptor.addChild(root_0, INTLIT137_tree);

					retval.e = new Constant((INTLIT137!=null?INTLIT137.getText():null), Type.Int);
					}
					break;
				case 2 :
					// Tiger.g:801:7: FIXEDPTLIT
					{
					root_0 = (Object)adaptor.nil();


					FIXEDPTLIT138=(Token)match(input,FIXEDPTLIT,FOLLOW_FIXEDPTLIT_in_literal3218); 
					FIXEDPTLIT138_tree = (Object)adaptor.create(FIXEDPTLIT138);
					adaptor.addChild(root_0, FIXEDPTLIT138_tree);

					retval.e = new Constant((FIXEDPTLIT138!=null?FIXEDPTLIT138.getText():null), Type.Float);
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
	// $ANTLR end "literal"


	public static class value_tail_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "value_tail"
	// Tiger.g:804:1: value_tail : ( '[' index_expr ']' ( '[' index_expr ']' )? -> ( index_expr )+ |);
	public final TigerParser.value_tail_return value_tail() throws RecognitionException {
		TigerParser.value_tail_return retval = new TigerParser.value_tail_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal139=null;
		Token char_literal141=null;
		Token char_literal142=null;
		Token char_literal144=null;
		ParserRuleReturnScope index_expr140 =null;
		ParserRuleReturnScope index_expr143 =null;

		Object char_literal139_tree=null;
		Object char_literal141_tree=null;
		Object char_literal142_tree=null;
		Object char_literal144_tree=null;
		RewriteRuleTokenStream stream_RBRACK=new RewriteRuleTokenStream(adaptor,"token RBRACK");
		RewriteRuleTokenStream stream_LBRACK=new RewriteRuleTokenStream(adaptor,"token LBRACK");
		RewriteRuleSubtreeStream stream_index_expr=new RewriteRuleSubtreeStream(adaptor,"rule index_expr");

		try {
			// Tiger.g:805:5: ( '[' index_expr ']' ( '[' index_expr ']' )? -> ( index_expr )+ |)
			int alt39=2;
			int LA39_0 = input.LA(1);
			if ( (LA39_0==LBRACK) ) {
				alt39=1;
			}
			else if ( (LA39_0==AND||LA39_0==ASSIGN||LA39_0==COMMA||(LA39_0 >= DIV && LA39_0 <= DO)||LA39_0==EQ||(LA39_0 >= GREATER && LA39_0 <= GREATEREQ)||(LA39_0 >= LESSER && LA39_0 <= LESSEREQ)||(LA39_0 >= MINUS && LA39_0 <= NEQ)||LA39_0==OR||LA39_0==PLUS||(LA39_0 >= RPAREN && LA39_0 <= THEN)) ) {
				alt39=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 39, 0, input);
				throw nvae;
			}

			switch (alt39) {
				case 1 :
					// Tiger.g:805:7: '[' index_expr ']' ( '[' index_expr ']' )?
					{
					char_literal139=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_value_tail3238);  
					stream_LBRACK.add(char_literal139);

					pushFollow(FOLLOW_index_expr_in_value_tail3240);
					index_expr140=index_expr();
					state._fsp--;

					stream_index_expr.add(index_expr140.getTree());
					char_literal141=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_value_tail3242);  
					stream_RBRACK.add(char_literal141);

					// Tiger.g:805:26: ( '[' index_expr ']' )?
					int alt38=2;
					int LA38_0 = input.LA(1);
					if ( (LA38_0==LBRACK) ) {
						alt38=1;
					}
					switch (alt38) {
						case 1 :
							// Tiger.g:805:27: '[' index_expr ']'
							{
							char_literal142=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_value_tail3245);  
							stream_LBRACK.add(char_literal142);

							pushFollow(FOLLOW_index_expr_in_value_tail3247);
							index_expr143=index_expr();
							state._fsp--;

							stream_index_expr.add(index_expr143.getTree());
							char_literal144=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_value_tail3249);  
							stream_RBRACK.add(char_literal144);

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
					// 806:13: -> ( index_expr )+
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
					// Tiger.g:808:5: 
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
	// Tiger.g:811:1: index_expr : index_term ( add_operator ^ index_term )* ;
	public final TigerParser.index_expr_return index_expr() throws RecognitionException {
		TigerParser.index_expr_return retval = new TigerParser.index_expr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope index_term145 =null;
		ParserRuleReturnScope add_operator146 =null;
		ParserRuleReturnScope index_term147 =null;


		try {
			// Tiger.g:812:5: ( index_term ( add_operator ^ index_term )* )
			// Tiger.g:812:7: index_term ( add_operator ^ index_term )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_index_term_in_index_expr3296);
			index_term145=index_term();
			state._fsp--;

			adaptor.addChild(root_0, index_term145.getTree());

			// Tiger.g:812:18: ( add_operator ^ index_term )*
			loop40:
			while (true) {
				int alt40=2;
				int LA40_0 = input.LA(1);
				if ( (LA40_0==MINUS||LA40_0==PLUS) ) {
					alt40=1;
				}

				switch (alt40) {
				case 1 :
					// Tiger.g:812:19: add_operator ^ index_term
					{
					pushFollow(FOLLOW_add_operator_in_index_expr3299);
					add_operator146=add_operator();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(add_operator146.getTree(), root_0);
					pushFollow(FOLLOW_index_term_in_index_expr3302);
					index_term147=index_term();
					state._fsp--;

					adaptor.addChild(root_0, index_term147.getTree());

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
	// $ANTLR end "index_expr"


	public static class index_term_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "index_term"
	// Tiger.g:814:1: index_term : index_factor ( '*' ^ index_factor )* ;
	public final TigerParser.index_term_return index_term() throws RecognitionException {
		TigerParser.index_term_return retval = new TigerParser.index_term_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal149=null;
		ParserRuleReturnScope index_factor148 =null;
		ParserRuleReturnScope index_factor150 =null;

		Object char_literal149_tree=null;

		try {
			// Tiger.g:815:5: ( index_factor ( '*' ^ index_factor )* )
			// Tiger.g:815:7: index_factor ( '*' ^ index_factor )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_index_factor_in_index_term3318);
			index_factor148=index_factor();
			state._fsp--;

			adaptor.addChild(root_0, index_factor148.getTree());

			// Tiger.g:815:20: ( '*' ^ index_factor )*
			loop41:
			while (true) {
				int alt41=2;
				int LA41_0 = input.LA(1);
				if ( (LA41_0==MULT) ) {
					alt41=1;
				}

				switch (alt41) {
				case 1 :
					// Tiger.g:815:21: '*' ^ index_factor
					{
					char_literal149=(Token)match(input,MULT,FOLLOW_MULT_in_index_term3321); 
					char_literal149_tree = (Object)adaptor.create(char_literal149);
					root_0 = (Object)adaptor.becomeRoot(char_literal149_tree, root_0);

					pushFollow(FOLLOW_index_factor_in_index_term3324);
					index_factor150=index_factor();
					state._fsp--;

					adaptor.addChild(root_0, index_factor150.getTree());

					}
					break;

				default :
					break loop41;
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
	// Tiger.g:817:1: index_factor : ( INTLIT | ID );
	public final TigerParser.index_factor_return index_factor() throws RecognitionException {
		TigerParser.index_factor_return retval = new TigerParser.index_factor_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set151=null;

		Object set151_tree=null;

		try {
			// Tiger.g:818:5: ( INTLIT | ID )
			// Tiger.g:
			{
			root_0 = (Object)adaptor.nil();


			set151=input.LT(1);
			if ( input.LA(1)==ID||input.LA(1)==INTLIT ) {
				input.consume();
				adaptor.addChild(root_0, (Object)adaptor.create(set151));
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



	public static final BitSet FOLLOW_type_declaration_list_in_tiger_program1033 = new BitSet(new long[]{0x0000004202000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_funct_declaration_list_then_main_in_tiger_program1035 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_tiger_program1041 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VOID_in_funct_declaration_list_then_main1069 = new BitSet(new long[]{0x0001000020000000L});
	public static final BitSet FOLLOW_funct_declaration_tail_in_funct_declaration_list_then_main1073 = new BitSet(new long[]{0x0000004202000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_funct_declaration_list_then_main_in_funct_declaration_list_then_main1076 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_main_function_tail_in_funct_declaration_list_then_main1080 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_funct_declaration_list_then_main1093 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_INT_in_funct_declaration_list_then_main1097 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_FIXEDPT_in_funct_declaration_list_then_main1101 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_funct_declaration_tail_in_funct_declaration_list_then_main1104 = new BitSet(new long[]{0x0000004202000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_funct_declaration_list_then_main_in_funct_declaration_list_then_main1107 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FUNCTION_in_funct_declaration_tail1135 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_ID_in_funct_declaration_tail1137 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_LPAREN_in_funct_declaration_tail1139 = new BitSet(new long[]{0x1000000200000000L});
	public static final BitSet FOLLOW_param_list_in_funct_declaration_tail1141 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_funct_declaration_tail1143 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_BEGIN_in_funct_declaration_tail1151 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_block_list_in_funct_declaration_tail1153 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_END_in_funct_declaration_tail1155 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_SEMI_in_funct_declaration_tail1157 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MAIN_in_main_function_tail1192 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_LPAREN_in_main_function_tail1194 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_main_function_tail1196 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_BEGIN_in_main_function_tail1198 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_block_list_in_main_function_tail1200 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_END_in_main_function_tail1202 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_SEMI_in_main_function_tail1204 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_param_in_param_list1238 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_COMMA_in_param_list1246 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_param_in_param_list1250 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_ID_in_param1285 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_COLON_in_param1287 = new BitSet(new long[]{0x0000004202000000L});
	public static final BitSet FOLLOW_type_id_in_param1289 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_block_list1317 = new BitSet(new long[]{0x0000000000000082L});
	public static final BitSet FOLLOW_BEGIN_in_block1337 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000022L});
	public static final BitSet FOLLOW_declaration_segment_in_block1346 = new BitSet(new long[]{0x0800000A08000480L,0x0000000000000200L});
	public static final BitSet FOLLOW_stat_seq_in_block1348 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_END_in_block1350 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_SEMI_in_block1352 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_declaration_list_in_declaration_segment1383 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_var_declaration_list_in_declaration_segment1385 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_declaration_in_type_declaration_list1398 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
	public static final BitSet FOLLOW_var_declaration_in_var_declaration_list1431 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000020L});
	public static final BitSet FOLLOW_TYPE_in_type_declaration1461 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_ID_in_type_declaration1463 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_EQ_in_type_declaration1465 = new BitSet(new long[]{0x0000004002000020L});
	public static final BitSet FOLLOW_type_in_type_declaration1467 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_SEMI_in_type_declaration1469 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_base_type_in_type1501 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARRAY_in_type1513 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_LBRACK_in_type1515 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_INTLIT_in_type1519 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_RBRACK_in_type1521 = new BitSet(new long[]{0x0020080000000000L});
	public static final BitSet FOLLOW_LBRACK_in_type1524 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_INTLIT_in_type1528 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_RBRACK_in_type1530 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_OF_in_type1535 = new BitSet(new long[]{0x0000004002000000L});
	public static final BitSet FOLLOW_base_type_in_type1537 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_base_type_in_type_id1575 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_type_id1592 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_base_type1616 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FIXEDPT_in_base_type1627 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_var_declaration1652 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_id_list_in_var_declaration1654 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_COLON_in_var_declaration1656 = new BitSet(new long[]{0x0000004202000000L});
	public static final BitSet FOLLOW_type_id_in_var_declaration1658 = new BitSet(new long[]{0x2000000000000040L});
	public static final BitSet FOLLOW_optional_init_in_var_declaration1660 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_SEMI_in_var_declaration1662 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_id_list1704 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_COMMA_in_id_list1708 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_ID_in_id_list1712 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_ASSIGN_in_optional_init1753 = new BitSet(new long[]{0x0000008004000000L});
	public static final BitSet FOLLOW_literal_in_optional_init1755 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_stat_in_stat_seq1781 = new BitSet(new long[]{0x0800000A08000482L,0x0000000000000200L});
	public static final BitSet FOLLOW_function_call_or_assignment_in_stat1799 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_stat1807 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_expr_in_stat1809 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_THEN_in_stat1811 = new BitSet(new long[]{0x0800000A08000480L,0x0000000000000200L});
	public static final BitSet FOLLOW_stat_seq_in_stat1815 = new BitSet(new long[]{0x0000000000220000L});
	public static final BitSet FOLLOW_ELSE_in_stat1828 = new BitSet(new long[]{0x0800000A08000480L,0x0000000000000200L});
	public static final BitSet FOLLOW_stat_seq_in_stat1832 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_ENDIF_in_stat1834 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_ENDIF_in_stat1880 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat1919 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WHILE_in_stat1927 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_expr_in_stat1929 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_DO_in_stat1931 = new BitSet(new long[]{0x0800000A08000480L,0x0000000000000200L});
	public static final BitSet FOLLOW_stat_seq_in_stat1933 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ENDDO_in_stat1935 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat1937 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FOR_in_stat1963 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_ID_in_stat1965 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASSIGN_in_stat1967 = new BitSet(new long[]{0x0000008200000000L});
	public static final BitSet FOLLOW_index_expr_in_stat1969 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_TO_in_stat1971 = new BitSet(new long[]{0x0000008200000000L});
	public static final BitSet FOLLOW_index_expr_in_stat1973 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_DO_in_stat1975 = new BitSet(new long[]{0x0800000A08000480L,0x0000000000000200L});
	public static final BitSet FOLLOW_stat_seq_in_stat1977 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ENDDO_in_stat1979 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat1981 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BREAK_in_stat2011 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat2013 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RETURN_in_stat2022 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_expr_in_stat2024 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat2026 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_stat2050 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_function_args2071 = new BitSet(new long[]{0x1000808204000000L});
	public static final BitSet FOLLOW_expr_list_in_function_args2073 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_function_args2075 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_function_call_or_assignment2108 = new BitSet(new long[]{0x0000880000000040L});
	public static final BitSet FOLLOW_function_args_in_function_call_or_assignment2120 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_value_tail_in_function_call_or_assignment2169 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASSIGN_in_function_call_or_assignment2171 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_expr_or_function_call_in_function_call_or_assignment2173 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_SEMI_in_function_call_or_assignment2225 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_expr_or_function_call2247 = new BitSet(new long[]{0x0000880000000000L});
	public static final BitSet FOLLOW_expr_with_start_id_in_expr_or_function_call2259 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_args_in_expr_or_function_call2288 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_no_start_id_in_expr_or_function_call2337 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term4_in_expr2370 = new BitSet(new long[]{0x0040000000000012L});
	public static final BitSet FOLLOW_and_operator_in_expr2373 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_term4_in_expr2378 = new BitSet(new long[]{0x0040000000000012L});
	public static final BitSet FOLLOW_term3_in_term42421 = new BitSet(new long[]{0x0010300180400002L});
	public static final BitSet FOLLOW_compare_operator_in_term42424 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_term3_in_term42429 = new BitSet(new long[]{0x0010300180400002L});
	public static final BitSet FOLLOW_term2_in_term32474 = new BitSet(new long[]{0x0104000000000002L});
	public static final BitSet FOLLOW_add_operator_in_term32477 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_term2_in_term32482 = new BitSet(new long[]{0x0104000000000002L});
	public static final BitSet FOLLOW_term1_in_term22510 = new BitSet(new long[]{0x0008000000008002L});
	public static final BitSet FOLLOW_mult_operator_in_term22513 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_term1_in_term22518 = new BitSet(new long[]{0x0008000000008002L});
	public static final BitSet FOLLOW_literal_in_term12541 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_in_term12551 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_term12561 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_expr_in_term12563 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_term12565 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term4_no_start_id_in_expr_no_start_id2602 = new BitSet(new long[]{0x0040000000000012L});
	public static final BitSet FOLLOW_and_operator_in_expr_no_start_id2605 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_term4_in_expr_no_start_id2610 = new BitSet(new long[]{0x0040000000000012L});
	public static final BitSet FOLLOW_term3_no_start_id_in_term4_no_start_id2653 = new BitSet(new long[]{0x0010300180400002L});
	public static final BitSet FOLLOW_compare_operator_in_term4_no_start_id2656 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_term3_in_term4_no_start_id2661 = new BitSet(new long[]{0x0010300180400002L});
	public static final BitSet FOLLOW_term2_no_start_id_in_term3_no_start_id2704 = new BitSet(new long[]{0x0104000000000002L});
	public static final BitSet FOLLOW_add_operator_in_term3_no_start_id2707 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_term2_in_term3_no_start_id2712 = new BitSet(new long[]{0x0104000000000002L});
	public static final BitSet FOLLOW_term1_no_start_id_in_term2_no_start_id2739 = new BitSet(new long[]{0x0008000000008002L});
	public static final BitSet FOLLOW_mult_operator_in_term2_no_start_id2742 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_term1_in_term2_no_start_id2747 = new BitSet(new long[]{0x0008000000008002L});
	public static final BitSet FOLLOW_literal_in_term1_no_start_id2771 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_term1_no_start_id2781 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_expr_in_term1_no_start_id2783 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_term1_no_start_id2785 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term4_with_start_id_in_expr_with_start_id2826 = new BitSet(new long[]{0x0040000000000012L});
	public static final BitSet FOLLOW_and_operator_in_expr_with_start_id2830 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_term4_in_expr_with_start_id2835 = new BitSet(new long[]{0x0040000000000012L});
	public static final BitSet FOLLOW_term3_with_start_id_in_term4_with_start_id2870 = new BitSet(new long[]{0x0010300180400002L});
	public static final BitSet FOLLOW_compare_operator_in_term4_with_start_id2874 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_term3_in_term4_with_start_id2879 = new BitSet(new long[]{0x0010300180400002L});
	public static final BitSet FOLLOW_term2_with_start_id_in_term3_with_start_id2925 = new BitSet(new long[]{0x0104000000000002L});
	public static final BitSet FOLLOW_add_operator_in_term3_with_start_id2929 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_term2_in_term3_with_start_id2934 = new BitSet(new long[]{0x0104000000000002L});
	public static final BitSet FOLLOW_term1_with_start_id_in_term2_with_start_id2965 = new BitSet(new long[]{0x0008000000008002L});
	public static final BitSet FOLLOW_mult_operator_in_term2_with_start_id2969 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_term1_in_term2_with_start_id2974 = new BitSet(new long[]{0x0008000000008002L});
	public static final BitSet FOLLOW_value_tail_in_term1_with_start_id3000 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_expr_list3038 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_COMMA_in_expr_list3046 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_expr_in_expr_list3050 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_ID_in_value3177 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_value_tail_in_value3179 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTLIT_in_literal3208 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FIXEDPTLIT_in_literal3218 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LBRACK_in_value_tail3238 = new BitSet(new long[]{0x0000008200000000L});
	public static final BitSet FOLLOW_index_expr_in_value_tail3240 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_RBRACK_in_value_tail3242 = new BitSet(new long[]{0x0000080000000002L});
	public static final BitSet FOLLOW_LBRACK_in_value_tail3245 = new BitSet(new long[]{0x0000008200000000L});
	public static final BitSet FOLLOW_index_expr_in_value_tail3247 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_RBRACK_in_value_tail3249 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_index_term_in_index_expr3296 = new BitSet(new long[]{0x0104000000000002L});
	public static final BitSet FOLLOW_add_operator_in_index_expr3299 = new BitSet(new long[]{0x0000008200000000L});
	public static final BitSet FOLLOW_index_term_in_index_expr3302 = new BitSet(new long[]{0x0104000000000002L});
	public static final BitSet FOLLOW_index_factor_in_index_term3318 = new BitSet(new long[]{0x0008000000000002L});
	public static final BitSet FOLLOW_MULT_in_index_term3321 = new BitSet(new long[]{0x0000008200000000L});
	public static final BitSet FOLLOW_index_factor_in_index_term3324 = new BitSet(new long[]{0x0008000000000002L});
}
