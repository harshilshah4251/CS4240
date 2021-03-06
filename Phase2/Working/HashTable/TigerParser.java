// $ANTLR 3.5.2 Tiger.g 2014-11-13 05:00:10

// Not sure if we need this
	import java.util.Map;
	import java.util.TreeMap;
	import java.util.ArrayList;
	import java.util.Stack;
	import java.util.LinkedList;
	import java.io.*;


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

		public Function currFunc;

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
			FileOutputStream out = null;
			File file;
			try {
				file = new File("SymbolTable.txt");
				out = new FileOutputStream(file);
				if (!file.exists()) {
					file.createNewFile();
				}

				for(int i = 0; i < tableList.size(); i++) {
					if(tableList.get(i).size() != 0){
						String content = "Symbol table " + i +": \n" + tableList.get(i) + "\n\n";
							byte[] contentInBytes = content.getBytes();
				out.write(contentInBytes);
				out.flush();
				}

			}
			out.close();
	 
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (out != null) {
						out.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

		public void addToList(SymbolTable s) {
			tableList.add(s);
		}

		public Var getValue(String name) {
			boolean found = false;
			for(int i = 0; i < stack.size(); i++) {
				if(stack.get(i).containsKey(name)) {
					return stack.get(i).get(name);
				}
			}

	//		if (currFunc == null) {
	//			System.out.println("ERROR in \"" + currFunc.funcName + "\" " +"In Global level, " + name + ": Symbol not found in SymbolTable!\n");
	//		} else {
				System.out.println("[ERROR] In function \"" + currFunc.funcName + "\": " +"In Function " + currFunc.funcName + " " + name + ": Symbol not found in SymbolTable!\n");
	//		}
			//return new Var();
			return new Var();
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
		public void checkFuncParam(String funcName, ArrayList<Expr> pList) {
	        System.out.println("[Note] In function \"" + currFunc.funcName + "\": " +"looking into function: \"" + funcName + "\"...");
			Var func = getValue(funcName);
			if (func == null) {
				System.out.println("ERROR in \"" + currFunc.funcName + "\": function symbol \"" +funcName + "\" not found!");
			} else if(!(func instanceof Function)) {
				System.out.println("ERROR in \"" + currFunc.funcName + "\" " +funcName + " is supposed to be Function type!\n");
			} else {
				ArrayList<Id> fpList = ((Function)func).getParamList();
	            System.out.println("[Note] In function \"" + funcName + "\": the parameters from symbol table are : " + fpList);
	            System.out.println("[Note] In function \"" + funcName + "\": the used parameters are : " + pList);
				// checking if the function doesn't have paramter
				// it's wrong even when either one is null
				if(fpList != null && pList != null) {
				    if(pList.size() != fpList.size()) { 
					    System.out.println("[ERROR] In \"" + currFunc.funcName + "\" " +funcName + " has wrong number of parameters!\n");
				    } else {
					for(int i = 0; i < pList.size(); i++) {
						if(pList.get(i) == null) {
							System.out.println("[ERROR] In function \"" + currFunc.funcName + "\": function \"" + funcName + "\" Wrong kind of parameter is given!\n");
						} else if(!fpList.get(i).type.name.equals(pList.get(i).type.name)) {
							System.out.println("[ERROR] In function \"" + currFunc.funcName + "\": function \"" + funcName + "\" has wrong parameter type!\n");
						} else if((pList.get(i) instanceof Id) && ((Id)pList.get(i)).init) {
							System.out.println("[ERROR] In function \"" + currFunc.funcName + "\": function \"" + funcName + "\" a parameter is not initialized before use!\n");
						}
					}
				}
				} else if (pList == null && fpList.size() != 0) {
					System.out.println("ERROR in \"" + currFunc.funcName + "\" " + funcName + " Wrong numbers of parameger!\n");
				}
			}
		}


		Expr checkArrayType(Var v, int a) {
			Type tempType = ((UserType)((Id)v).type).of;
			Expr e = new Expr("temp", Type.Int);
				//Constructor without parameters shouldn't be used
			if(a == 0 && (!(tempType instanceof Array) || !(tempType instanceof TwoDArray))) {
				System.out.println("ERROR in \"" + currFunc.funcName + "\" " + ((Id)v).s + " Whole Array cannot be used like this!\n");
			}else if(a == 1 && (tempType instanceof Array)){ 
				System.out.println("TYPE1: " + ((UserType)((Id)v).type));
				e = new Expr("UserTypeExpr", ((Array)tempType).of);
			}else if(a ==2 && (tempType instanceof TwoDArray)) {
				System.out.println("TYPE2: " + ((UserType)((Id)v).type));
				e = new Expr("UserTypeExpr", ((TwoDArray)tempType).of);
			} else if(a == 1 || a == 2){
				System.out.println("ERROR in \"" + currFunc.funcName + "\" " + ((Id)v).s + " Wrong way to use Array!\n");
			}
			return e;
		}




	public static class tiger_program_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "tiger_program"
	// Tiger.g:358:1: tiger_program : type_declaration_list funct_declaration_list_then_main EOF -> ^( PROGRAM type_declaration_list funct_declaration_list_then_main ) ;
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
			// Tiger.g:359:5: ( type_declaration_list funct_declaration_list_then_main EOF -> ^( PROGRAM type_declaration_list funct_declaration_list_then_main ) )
			// Tiger.g:360:2: type_declaration_list funct_declaration_list_then_main EOF
			{
				
					// This new SymbolTable will be the global SymbolTable
					level = 0;
					enterNewScope(new SymbolTable(level));
					// Add Standard Library Functions into Global Symbol Table
					addSTL();
				
			pushFollow(FOLLOW_type_declaration_list_in_tiger_program1034);
			type_declaration_list1=type_declaration_list();
			state._fsp--;

			stream_type_declaration_list.add(type_declaration_list1.getTree());
			pushFollow(FOLLOW_funct_declaration_list_then_main_in_tiger_program1036);
			funct_declaration_list_then_main2=funct_declaration_list_then_main();
			state._fsp--;

			stream_funct_declaration_list_then_main.add(funct_declaration_list_then_main2.getTree());
			printSymbol();
			EOF3=(Token)match(input,EOF,FOLLOW_EOF_in_tiger_program1045);  
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
			// 371:2: -> ^( PROGRAM type_declaration_list funct_declaration_list_then_main )
			{
				// Tiger.g:371:5: ^( PROGRAM type_declaration_list funct_declaration_list_then_main )
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
	// Tiger.g:375:1: funct_declaration_list_then_main : (myRet= VOID ! ( funct_declaration_tail[$myRet, $myRet.text] funct_declaration_list_then_main | main_function_tail ) | (myRet= ID |myRet= INT |myRet= FIXEDPT ) funct_declaration_tail[$myRet, $myRet.text] funct_declaration_list_then_main );
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
			// Tiger.g:376:5: (myRet= VOID ! ( funct_declaration_tail[$myRet, $myRet.text] funct_declaration_list_then_main | main_function_tail ) | (myRet= ID |myRet= INT |myRet= FIXEDPT ) funct_declaration_tail[$myRet, $myRet.text] funct_declaration_list_then_main )
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
					// Tiger.g:376:7: myRet= VOID ! ( funct_declaration_tail[$myRet, $myRet.text] funct_declaration_list_then_main | main_function_tail )
					{
					root_0 = (Object)adaptor.nil();


					myRet=(Token)match(input,VOID,FOLLOW_VOID_in_funct_declaration_list_then_main1073); 
					// Tiger.g:376:19: ( funct_declaration_tail[$myRet, $myRet.text] funct_declaration_list_then_main | main_function_tail )
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
							// Tiger.g:376:20: funct_declaration_tail[$myRet, $myRet.text] funct_declaration_list_then_main
							{
							pushFollow(FOLLOW_funct_declaration_tail_in_funct_declaration_list_then_main1077);
							funct_declaration_tail4=funct_declaration_tail(myRet, (myRet!=null?myRet.getText():null));
							state._fsp--;

							adaptor.addChild(root_0, funct_declaration_tail4.getTree());

							pushFollow(FOLLOW_funct_declaration_list_then_main_in_funct_declaration_list_then_main1080);
							funct_declaration_list_then_main5=funct_declaration_list_then_main();
							state._fsp--;

							adaptor.addChild(root_0, funct_declaration_list_then_main5.getTree());

							}
							break;
						case 2 :
							// Tiger.g:376:99: main_function_tail
							{
							pushFollow(FOLLOW_main_function_tail_in_funct_declaration_list_then_main1084);
							main_function_tail6=main_function_tail();
							state._fsp--;

							adaptor.addChild(root_0, main_function_tail6.getTree());

							}
							break;

					}

					}
					break;
				case 2 :
					// Tiger.g:378:7: (myRet= ID |myRet= INT |myRet= FIXEDPT ) funct_declaration_tail[$myRet, $myRet.text] funct_declaration_list_then_main
					{
					root_0 = (Object)adaptor.nil();


					// Tiger.g:378:7: (myRet= ID |myRet= INT |myRet= FIXEDPT )
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
							// Tiger.g:378:8: myRet= ID
							{
							myRet=(Token)match(input,ID,FOLLOW_ID_in_funct_declaration_list_then_main1097); 
							myRet_tree = (Object)adaptor.create(myRet);
							adaptor.addChild(root_0, myRet_tree);

							}
							break;
						case 2 :
							// Tiger.g:378:17: myRet= INT
							{
							myRet=(Token)match(input,INT,FOLLOW_INT_in_funct_declaration_list_then_main1101); 
							myRet_tree = (Object)adaptor.create(myRet);
							adaptor.addChild(root_0, myRet_tree);

							}
							break;
						case 3 :
							// Tiger.g:378:27: myRet= FIXEDPT
							{
							myRet=(Token)match(input,FIXEDPT,FOLLOW_FIXEDPT_in_funct_declaration_list_then_main1105); 
							myRet_tree = (Object)adaptor.create(myRet);
							adaptor.addChild(root_0, myRet_tree);

							}
							break;

					}

					pushFollow(FOLLOW_funct_declaration_tail_in_funct_declaration_list_then_main1108);
					funct_declaration_tail7=funct_declaration_tail(myRet, (myRet!=null?myRet.getText():null));
					state._fsp--;

					adaptor.addChild(root_0, funct_declaration_tail7.getTree());

					pushFollow(FOLLOW_funct_declaration_list_then_main_in_funct_declaration_list_then_main1111);
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
	// Tiger.g:381:1: funct_declaration_tail[Token retType, String returnType] : FUNCTION ID '(' param_list ')' BEGIN block_list END ';' -> ^( FUNCTION ID param_list block_list ) ;
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
			// Tiger.g:382:5: ( FUNCTION ID '(' param_list ')' BEGIN block_list END ';' -> ^( FUNCTION ID param_list block_list ) )
			// Tiger.g:382:7: FUNCTION ID '(' param_list ')' BEGIN block_list END ';'
			{
			Type type = new Type(returnType);
			FUNCTION9=(Token)match(input,FUNCTION,FOLLOW_FUNCTION_in_funct_declaration_tail1139);  
			stream_FUNCTION.add(FUNCTION9);

			ID10=(Token)match(input,ID,FOLLOW_ID_in_funct_declaration_tail1141);  
			stream_ID.add(ID10);

			char_literal11=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_funct_declaration_tail1143);  
			stream_LPAREN.add(char_literal11);

			pushFollow(FOLLOW_param_list_in_funct_declaration_tail1145);
			param_list12=param_list();
			state._fsp--;

			stream_param_list.add(param_list12.getTree());
			char_literal13=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_funct_declaration_tail1147);  
			stream_RPAREN.add(char_literal13);


					Function newFunc = new Function((ID10!=null?ID10.getText():null), type, (param_list12!=null?((TigerParser.param_list_return)param_list12).paramList:null));
					getTopTable().put((ID10!=null?ID10.getText():null), newFunc);

			//new Function((ID10!=null?ID10.getText():null), type, (param_list12!=null?((TigerParser.param_list_return)param_list12).paramList:null)));
					currFunc = newFunc;
			        System.out.println("[Note] Entering function: \"" + currFunc.funcName + "\"...");
					enterNewScope(new SymbolTable(level));

					for(int i = 0; i < (param_list12!=null?((TigerParser.param_list_return)param_list12).paramList:null).size(); i++) {

						getTopTable().put((param_list12!=null?((TigerParser.param_list_return)param_list12).paramList:null).get(i).getName(), 
								new Id((param_list12!=null?((TigerParser.param_list_return)param_list12).paramList:null).get(i).getName(), (param_list12!=null?((TigerParser.param_list_return)param_list12).paramList:null).get(i).getType(),true));
					}

				
			BEGIN14=(Token)match(input,BEGIN,FOLLOW_BEGIN_in_funct_declaration_tail1162);  
			stream_BEGIN.add(BEGIN14);

			pushFollow(FOLLOW_block_list_in_funct_declaration_tail1164);
			block_list15=block_list();
			state._fsp--;

			stream_block_list.add(block_list15.getTree());
			END16=(Token)match(input,END,FOLLOW_END_in_funct_declaration_tail1166);  
			stream_END.add(END16);

			char_literal17=(Token)match(input,SEMI,FOLLOW_SEMI_in_funct_declaration_tail1168);  
			stream_SEMI.add(char_literal17);


					exitScope();
			        System.out.println("[Note] Leaving function: \"" + currFunc.funcName + "\"...");
					currFunc = new Function("Global level", Type.Int, new ArrayList());
				
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
			// 408:2: -> ^( FUNCTION ID param_list block_list )
			{
				// Tiger.g:408:5: ^( FUNCTION ID param_list block_list )
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
	// Tiger.g:411:1: main_function_tail : MAIN '(' ')' BEGIN block_list END ';' -> ^( MAINSCOPE block_list ) ;
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
			// Tiger.g:412:5: ( MAIN '(' ')' BEGIN block_list END ';' -> ^( MAINSCOPE block_list ) )
			// Tiger.g:412:7: MAIN '(' ')' BEGIN block_list END ';'
			{
			MAIN18=(Token)match(input,MAIN,FOLLOW_MAIN_in_main_function_tail1206);  
			stream_MAIN.add(MAIN18);

			char_literal19=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_main_function_tail1208);  
			stream_LPAREN.add(char_literal19);

			char_literal20=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_main_function_tail1210);  
			stream_RPAREN.add(char_literal20);


				currFunc = new Function("Main Function", Type.Void, new ArrayList());
			    System.out.println("[Note] Entering Main...");
				
			BEGIN21=(Token)match(input,BEGIN,FOLLOW_BEGIN_in_main_function_tail1215);  
			stream_BEGIN.add(BEGIN21);

			pushFollow(FOLLOW_block_list_in_main_function_tail1217);
			block_list22=block_list();
			state._fsp--;

			stream_block_list.add(block_list22.getTree());
			END23=(Token)match(input,END,FOLLOW_END_in_main_function_tail1219);  
			stream_END.add(END23);

			char_literal24=(Token)match(input,SEMI,FOLLOW_SEMI_in_main_function_tail1221);  
			stream_SEMI.add(char_literal24);

			System.out.println("[Note] Leaving Main...");
			    currFunc = new Function("Global level", Type.Int, new ArrayList());
				
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
			// 420:2: -> ^( MAINSCOPE block_list )
			{
				// Tiger.g:420:5: ^( MAINSCOPE block_list )
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
	// Tiger.g:422:1: param_list returns [ArrayList<Id> paramList] : (par1= param ( ',' par2= param )* )? -> ^( PARAMLIST ( param )* ) ;
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
			// Tiger.g:423:5: ( (par1= param ( ',' par2= param )* )? -> ^( PARAMLIST ( param )* ) )
			// Tiger.g:423:7: (par1= param ( ',' par2= param )* )?
			{
			retval.paramList = new ArrayList<Id>();
			// Tiger.g:424:5: (par1= param ( ',' par2= param )* )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==ID) ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// Tiger.g:424:6: par1= param ( ',' par2= param )*
					{
					pushFollow(FOLLOW_param_in_param_list1258);
					par1=param();
					state._fsp--;

					stream_param.add(par1.getTree());
					retval.paramList.add((par1!=null?((TigerParser.param_return)par1).param:null));
					// Tiger.g:425:2: ( ',' par2= param )*
					loop4:
					while (true) {
						int alt4=2;
						int LA4_0 = input.LA(1);
						if ( (LA4_0==COMMA) ) {
							alt4=1;
						}

						switch (alt4) {
						case 1 :
							// Tiger.g:425:4: ',' par2= param
							{
							char_literal25=(Token)match(input,COMMA,FOLLOW_COMMA_in_param_list1266);  
							stream_COMMA.add(char_literal25);

							pushFollow(FOLLOW_param_in_param_list1270);
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
			// 427:2: -> ^( PARAMLIST ( param )* )
			{
				// Tiger.g:427:5: ^( PARAMLIST ( param )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PARAMLIST, "PARAMLIST"), root_1);
				// Tiger.g:427:17: ( param )*
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
	// Tiger.g:430:1: param returns [Id param] : ID ':' type_id ;
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
			// Tiger.g:431:2: ( ID ':' type_id )
			// Tiger.g:431:4: ID ':' type_id
			{
			root_0 = (Object)adaptor.nil();


			ID26=(Token)match(input,ID,FOLLOW_ID_in_param1305); 
			ID26_tree = (Object)adaptor.create(ID26);
			adaptor.addChild(root_0, ID26_tree);

			char_literal27=(Token)match(input,COLON,FOLLOW_COLON_in_param1307); 
			char_literal27_tree = (Object)adaptor.create(char_literal27);
			adaptor.addChild(root_0, char_literal27_tree);

			pushFollow(FOLLOW_type_id_in_param1309);
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
	// Tiger.g:436:1: block_list : ( block )+ -> ^( BLOCKLIST ( block )+ ) ;
	public final TigerParser.block_list_return block_list() throws RecognitionException {
		TigerParser.block_list_return retval = new TigerParser.block_list_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope block29 =null;

		RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");

		try {
			// Tiger.g:437:5: ( ( block )+ -> ^( BLOCKLIST ( block )+ ) )
			// Tiger.g:437:7: ( block )+
			{
			// Tiger.g:437:7: ( block )+
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
					// Tiger.g:437:7: block
					{
					pushFollow(FOLLOW_block_in_block_list1337);
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
			// 437:14: -> ^( BLOCKLIST ( block )+ )
			{
				// Tiger.g:437:17: ^( BLOCKLIST ( block )+ )
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
	// Tiger.g:439:1: block : BEGIN declaration_segment stat_seq END ';' -> ^( BLOCKSCOPE declaration_segment stat_seq ) ;
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
			// Tiger.g:440:2: ( BEGIN declaration_segment stat_seq END ';' -> ^( BLOCKSCOPE declaration_segment stat_seq ) )
			// Tiger.g:440:4: BEGIN declaration_segment stat_seq END ';'
			{
			BEGIN30=(Token)match(input,BEGIN,FOLLOW_BEGIN_in_block1357);  
			stream_BEGIN.add(BEGIN30);

			enterNewScope(new SymbolTable(level));
			pushFollow(FOLLOW_declaration_segment_in_block1366);
			declaration_segment31=declaration_segment();
			state._fsp--;

			stream_declaration_segment.add(declaration_segment31.getTree());
			pushFollow(FOLLOW_stat_seq_in_block1368);
			stat_seq32=stat_seq();
			state._fsp--;

			stream_stat_seq.add(stat_seq32.getTree());
			END33=(Token)match(input,END,FOLLOW_END_in_block1370);  
			stream_END.add(END33);

			char_literal34=(Token)match(input,SEMI,FOLLOW_SEMI_in_block1372);  
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
			// 446:2: -> ^( BLOCKSCOPE declaration_segment stat_seq )
			{
				// Tiger.g:446:5: ^( BLOCKSCOPE declaration_segment stat_seq )
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
	// Tiger.g:448:1: declaration_segment : type_declaration_list var_declaration_list ;
	public final TigerParser.declaration_segment_return declaration_segment() throws RecognitionException {
		TigerParser.declaration_segment_return retval = new TigerParser.declaration_segment_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope type_declaration_list35 =null;
		ParserRuleReturnScope var_declaration_list36 =null;


		try {
			// Tiger.g:449:5: ( type_declaration_list var_declaration_list )
			// Tiger.g:449:7: type_declaration_list var_declaration_list
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_type_declaration_list_in_declaration_segment1403);
			type_declaration_list35=type_declaration_list();
			state._fsp--;

			adaptor.addChild(root_0, type_declaration_list35.getTree());

			pushFollow(FOLLOW_var_declaration_list_in_declaration_segment1405);
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
	// Tiger.g:451:1: type_declaration_list : ( type_declaration )* -> ^( TYPEDECLLIST ( type_declaration )* ) ;
	public final TigerParser.type_declaration_list_return type_declaration_list() throws RecognitionException {
		TigerParser.type_declaration_list_return retval = new TigerParser.type_declaration_list_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope type_declaration37 =null;

		RewriteRuleSubtreeStream stream_type_declaration=new RewriteRuleSubtreeStream(adaptor,"rule type_declaration");

		try {
			// Tiger.g:452:5: ( ( type_declaration )* -> ^( TYPEDECLLIST ( type_declaration )* ) )
			// Tiger.g:452:7: ( type_declaration )*
			{
			// Tiger.g:452:7: ( type_declaration )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==TYPE) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// Tiger.g:452:7: type_declaration
					{
					pushFollow(FOLLOW_type_declaration_in_type_declaration_list1418);
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
			// 453:2: -> ^( TYPEDECLLIST ( type_declaration )* )
			{
				// Tiger.g:453:5: ^( TYPEDECLLIST ( type_declaration )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(TYPEDECLLIST, "TYPEDECLLIST"), root_1);
				// Tiger.g:453:20: ( type_declaration )*
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
	// Tiger.g:456:1: var_declaration_list : ( var_declaration )* -> ^( VARDECLLIST ( var_declaration )* ) ;
	public final TigerParser.var_declaration_list_return var_declaration_list() throws RecognitionException {
		TigerParser.var_declaration_list_return retval = new TigerParser.var_declaration_list_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope var_declaration38 =null;

		RewriteRuleSubtreeStream stream_var_declaration=new RewriteRuleSubtreeStream(adaptor,"rule var_declaration");

		try {
			// Tiger.g:457:5: ( ( var_declaration )* -> ^( VARDECLLIST ( var_declaration )* ) )
			// Tiger.g:457:7: ( var_declaration )*
			{
			// Tiger.g:457:7: ( var_declaration )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==VAR) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// Tiger.g:457:7: var_declaration
					{
					pushFollow(FOLLOW_var_declaration_in_var_declaration_list1451);
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
			// 458:2: -> ^( VARDECLLIST ( var_declaration )* )
			{
				// Tiger.g:458:5: ^( VARDECLLIST ( var_declaration )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(VARDECLLIST, "VARDECLLIST"), root_1);
				// Tiger.g:458:19: ( var_declaration )*
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
	// Tiger.g:461:1: type_declaration : TYPE ID '=' type ';' -> ^( TYPEDECL ID type ) ;
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
			// Tiger.g:462:5: ( TYPE ID '=' type ';' -> ^( TYPEDECL ID type ) )
			// Tiger.g:462:7: TYPE ID '=' type ';'
			{
			TYPE39=(Token)match(input,TYPE,FOLLOW_TYPE_in_type_declaration1481);  
			stream_TYPE.add(TYPE39);

			ID40=(Token)match(input,ID,FOLLOW_ID_in_type_declaration1483);  
			stream_ID.add(ID40);

			char_literal41=(Token)match(input,EQ,FOLLOW_EQ_in_type_declaration1485);  
			stream_EQ.add(char_literal41);

			pushFollow(FOLLOW_type_in_type_declaration1487);
			type42=type();
			state._fsp--;

			stream_type.add(type42.getTree());
			char_literal43=(Token)match(input,SEMI,FOLLOW_SEMI_in_type_declaration1489);  
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
			// 474:2: -> ^( TYPEDECL ID type )
			{
				// Tiger.g:474:5: ^( TYPEDECL ID type )
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
	// Tiger.g:476:1: type returns [Type e, int w, int h] : ( base_type | ARRAY '[' init1= INTLIT ']' ( '[' init2= INTLIT ']' )? OF base_type -> ^( ARRAY base_type ( INTLIT )+ ) );
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
			// Tiger.g:477:5: ( base_type | ARRAY '[' init1= INTLIT ']' ( '[' init2= INTLIT ']' )? OF base_type -> ^( ARRAY base_type ( INTLIT )+ ) )
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
					// Tiger.g:477:7: base_type
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_base_type_in_type1521);
					base_type44=base_type();
					state._fsp--;

					adaptor.addChild(root_0, base_type44.getTree());

					retval.e = (base_type44!=null?((TigerParser.base_type_return)base_type44).e:null);
					}
					break;
				case 2 :
					// Tiger.g:478:7: ARRAY '[' init1= INTLIT ']' ( '[' init2= INTLIT ']' )? OF base_type
					{
					int i = 0;retval.w =0;retval.h =0;
					ARRAY45=(Token)match(input,ARRAY,FOLLOW_ARRAY_in_type1533);  
					stream_ARRAY.add(ARRAY45);

					char_literal46=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_type1535);  
					stream_LBRACK.add(char_literal46);

					init1=(Token)match(input,INTLIT,FOLLOW_INTLIT_in_type1539);  
					stream_INTLIT.add(init1);

					char_literal47=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_type1541);  
					stream_RBRACK.add(char_literal47);

					// Tiger.g:478:57: ( '[' init2= INTLIT ']' )?
					int alt9=2;
					int LA9_0 = input.LA(1);
					if ( (LA9_0==LBRACK) ) {
						alt9=1;
					}
					switch (alt9) {
						case 1 :
							// Tiger.g:478:58: '[' init2= INTLIT ']'
							{
							char_literal48=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_type1544);  
							stream_LBRACK.add(char_literal48);

							init2=(Token)match(input,INTLIT,FOLLOW_INTLIT_in_type1548);  
							stream_INTLIT.add(init2);

							char_literal49=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_type1550);  
							stream_RBRACK.add(char_literal49);

							i++;
							}
							break;

					}

					OF50=(Token)match(input,OF,FOLLOW_OF_in_type1555);  
					stream_OF.add(OF50);

					pushFollow(FOLLOW_base_type_in_type1557);
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
					// 489:2: -> ^( ARRAY base_type ( INTLIT )+ )
					{
						// Tiger.g:489:5: ^( ARRAY base_type ( INTLIT )+ )
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
	// Tiger.g:492:1: type_id returns [Type e] : ( base_type |id= ID );
	public final TigerParser.type_id_return type_id() throws RecognitionException {
		TigerParser.type_id_return retval = new TigerParser.type_id_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token id=null;
		ParserRuleReturnScope base_type52 =null;

		Object id_tree=null;

		try {
			// Tiger.g:494:5: ( base_type |id= ID )
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
					// Tiger.g:494:7: base_type
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_base_type_in_type_id1595);
					base_type52=base_type();
					state._fsp--;

					adaptor.addChild(root_0, base_type52.getTree());

					retval.e = (base_type52!=null?((TigerParser.base_type_return)base_type52).e:null);
					}
					break;
				case 2 :
					// Tiger.g:498:7: id= ID
					{
					root_0 = (Object)adaptor.nil();


					id=(Token)match(input,ID,FOLLOW_ID_in_type_id1612); 
					id_tree = (Object)adaptor.create(id);
					adaptor.addChild(root_0, id_tree);

					retval.e = ((UserType)getValue((id!=null?id.getText():null)));
					System.out.println((id!=null?id.getText():null) + " "+ retval.e);
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
	// Tiger.g:504:1: base_type returns [Type e] : ( INT | FIXEDPT );
	public final TigerParser.base_type_return base_type() throws RecognitionException {
		TigerParser.base_type_return retval = new TigerParser.base_type_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token INT53=null;
		Token FIXEDPT54=null;

		Object INT53_tree=null;
		Object FIXEDPT54_tree=null;

		try {
			// Tiger.g:505:5: ( INT | FIXEDPT )
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
					// Tiger.g:505:7: INT
					{
					root_0 = (Object)adaptor.nil();


					INT53=(Token)match(input,INT,FOLLOW_INT_in_base_type1638); 
					INT53_tree = (Object)adaptor.create(INT53);
					adaptor.addChild(root_0, INT53_tree);

					retval.e = Type.Int;
					}
					break;
				case 2 :
					// Tiger.g:506:7: FIXEDPT
					{
					root_0 = (Object)adaptor.nil();


					FIXEDPT54=(Token)match(input,FIXEDPT,FOLLOW_FIXEDPT_in_base_type1649); 
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
	// Tiger.g:509:1: var_declaration : VAR id_list ':' type_id optional_init ';' -> ^( VAR type_id id_list ( optional_init )? ) ;
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
			// Tiger.g:510:5: ( VAR id_list ':' type_id optional_init ';' -> ^( VAR type_id id_list ( optional_init )? ) )
			// Tiger.g:513:2: VAR id_list ':' type_id optional_init ';'
			{
			VAR55=(Token)match(input,VAR,FOLLOW_VAR_in_var_declaration1674);  
			stream_VAR.add(VAR55);

			pushFollow(FOLLOW_id_list_in_var_declaration1676);
			id_list56=id_list();
			state._fsp--;

			stream_id_list.add(id_list56.getTree());
			char_literal57=(Token)match(input,COLON,FOLLOW_COLON_in_var_declaration1678);  
			stream_COLON.add(char_literal57);

			pushFollow(FOLLOW_type_id_in_var_declaration1680);
			type_id58=type_id();
			state._fsp--;

			stream_type_id.add(type_id58.getTree());
			pushFollow(FOLLOW_optional_init_in_var_declaration1682);
			optional_init59=optional_init();
			state._fsp--;

			stream_optional_init.add(optional_init59.getTree());
			char_literal60=(Token)match(input,SEMI,FOLLOW_SEMI_in_var_declaration1684);  
			stream_SEMI.add(char_literal60);


						for(int i = 0; i < (id_list56!=null?((TigerParser.id_list_return)id_list56).list:null).size(); i++) {
							getTopTable().put((id_list56!=null?((TigerParser.id_list_return)id_list56).list:null).get(i), new Id((id_list56!=null?((TigerParser.id_list_return)id_list56).list:null).get(i), (type_id58!=null?((TigerParser.type_id_return)type_id58).e:null), (optional_init59!=null?((TigerParser.optional_init_return)optional_init59).b:false)));
			//System.out.println("DECLARE Var " + (id_list56!=null?((TigerParser.id_list_return)id_list56).list:null).get(i));
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
			// 521:2: -> ^( VAR type_id id_list ( optional_init )? )
			{
				// Tiger.g:521:5: ^( VAR type_id id_list ( optional_init )? )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot(stream_VAR.nextNode(), root_1);
				adaptor.addChild(root_1, stream_type_id.nextTree());
				adaptor.addChild(root_1, stream_id_list.nextTree());
				// Tiger.g:521:27: ( optional_init )?
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
	// Tiger.g:525:1: id_list returns [ArrayList<String> list] :i= ID ( ',' j= ID )* -> ^( IDLIST ( ID )+ ) ;
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
			// Tiger.g:526:5: (i= ID ( ',' j= ID )* -> ^( IDLIST ( ID )+ ) )
			// Tiger.g:526:6: i= ID ( ',' j= ID )*
			{
			retval.list = new ArrayList();
			i=(Token)match(input,ID,FOLLOW_ID_in_id_list1726);  
			stream_ID.add(i);

			retval.list.add((i!=null?i.getText():null));
			// Tiger.g:527:28: ( ',' j= ID )*
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0==COMMA) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// Tiger.g:527:29: ',' j= ID
					{
					char_literal61=(Token)match(input,COMMA,FOLLOW_COMMA_in_id_list1730);  
					stream_COMMA.add(char_literal61);

					j=(Token)match(input,ID,FOLLOW_ID_in_id_list1734);  
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
			// 529:3: -> ^( IDLIST ( ID )+ )
			{
				// Tiger.g:529:6: ^( IDLIST ( ID )+ )
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
	// Tiger.g:532:1: optional_init returns [boolean b] : ( ':=' literal |);
	public final TigerParser.optional_init_return optional_init() throws RecognitionException {
		TigerParser.optional_init_return retval = new TigerParser.optional_init_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal62=null;
		ParserRuleReturnScope literal63 =null;

		Object string_literal62_tree=null;

		try {
			// Tiger.g:535:5: ( ':=' literal |)
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
					// Tiger.g:535:7: ':=' literal
					{
					root_0 = (Object)adaptor.nil();


					retval.b = true;
					string_literal62=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_optional_init1775); 
					string_literal62_tree = (Object)adaptor.create(string_literal62);
					adaptor.addChild(root_0, string_literal62_tree);

					pushFollow(FOLLOW_literal_in_optional_init1777);
					literal63=literal();
					state._fsp--;

					adaptor.addChild(root_0, literal63.getTree());

					}
					break;
				case 2 :
					// Tiger.g:536:7: 
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
	// Tiger.g:539:1: stat_seq : ( stat )+ ;
	public final TigerParser.stat_seq_return stat_seq() throws RecognitionException {
		TigerParser.stat_seq_return retval = new TigerParser.stat_seq_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope stat64 =null;


		try {
			// Tiger.g:540:5: ( ( stat )+ )
			// Tiger.g:540:7: ( stat )+
			{
			root_0 = (Object)adaptor.nil();


			// Tiger.g:540:7: ( stat )+
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
					// Tiger.g:540:7: stat
					{
					pushFollow(FOLLOW_stat_in_stat_seq1803);
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
	// Tiger.g:543:1: stat : ( function_call_or_assignment | IF expr THEN seq1= stat_seq ( ELSE seq2= stat_seq ENDIF -> ^( IF expr ^( THEN_STATS $seq1) ^( ELSE_STATS $seq2) ) | ENDIF -> ^( IF expr ^( THEN_STATS $seq1) ) ) ';' | WHILE expr DO stat_seq ENDDO ';' -> ^( WHILE expr stat_seq ) | FOR ID ':=' index_expr TO index_expr DO stat_seq ENDDO ';' -> ^( FOR ID index_expr index_expr stat_seq ) | BREAK ';' !| RETURN expr ';' -> ^( RETURN expr ) | block );
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
			// Tiger.g:544:5: ( function_call_or_assignment | IF expr THEN seq1= stat_seq ( ELSE seq2= stat_seq ENDIF -> ^( IF expr ^( THEN_STATS $seq1) ^( ELSE_STATS $seq2) ) | ENDIF -> ^( IF expr ^( THEN_STATS $seq1) ) ) ';' | WHILE expr DO stat_seq ENDDO ';' -> ^( WHILE expr stat_seq ) | FOR ID ':=' index_expr TO index_expr DO stat_seq ENDDO ';' -> ^( FOR ID index_expr index_expr stat_seq ) | BREAK ';' !| RETURN expr ';' -> ^( RETURN expr ) | block )
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
					// Tiger.g:544:7: function_call_or_assignment
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_function_call_or_assignment_in_stat1821);
					function_call_or_assignment65=function_call_or_assignment();
					state._fsp--;

					adaptor.addChild(root_0, function_call_or_assignment65.getTree());

					}
					break;
				case 2 :
					// Tiger.g:545:7: IF expr THEN seq1= stat_seq ( ELSE seq2= stat_seq ENDIF -> ^( IF expr ^( THEN_STATS $seq1) ^( ELSE_STATS $seq2) ) | ENDIF -> ^( IF expr ^( THEN_STATS $seq1) ) ) ';'
					{
					IF66=(Token)match(input,IF,FOLLOW_IF_in_stat1829);  
					stream_IF.add(IF66);

					pushFollow(FOLLOW_expr_in_stat1831);
					expr67=expr();
					state._fsp--;

					stream_expr.add(expr67.getTree());
					 
						if((expr67!=null?((TigerParser.expr_return)expr67).e:null) == null || (expr67!=null?((TigerParser.expr_return)expr67).e:null).type.name == null) {
							System.out.println("ERROR in \"" + currFunc.funcName + "\" " + " IF NULL pointer ERROR!");
						} else if(!(expr67!=null?((TigerParser.expr_return)expr67).e:null).type.name.equals("boolean")) {
					            System.out.println("ERROR in \"" + currFunc.funcName + "\" " + " expr after IF statement has to be boolean!!!");}
						
					THEN68=(Token)match(input,THEN,FOLLOW_THEN_in_stat1835);  
					stream_THEN.add(THEN68);

					pushFollow(FOLLOW_stat_seq_in_stat1839);
					seq1=stat_seq();
					state._fsp--;

					stream_stat_seq.add(seq1.getTree());
					// Tiger.g:551:9: ( ELSE seq2= stat_seq ENDIF -> ^( IF expr ^( THEN_STATS $seq1) ^( ELSE_STATS $seq2) ) | ENDIF -> ^( IF expr ^( THEN_STATS $seq1) ) )
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
							// Tiger.g:551:11: ELSE seq2= stat_seq ENDIF
							{
							ELSE69=(Token)match(input,ELSE,FOLLOW_ELSE_in_stat1852);  
							stream_ELSE.add(ELSE69);

							pushFollow(FOLLOW_stat_seq_in_stat1856);
							seq2=stat_seq();
							state._fsp--;

							stream_stat_seq.add(seq2.getTree());
							ENDIF70=(Token)match(input,ENDIF,FOLLOW_ENDIF_in_stat1858);  
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
							// 552:13: -> ^( IF expr ^( THEN_STATS $seq1) ^( ELSE_STATS $seq2) )
							{
								// Tiger.g:552:16: ^( IF expr ^( THEN_STATS $seq1) ^( ELSE_STATS $seq2) )
								{
								Object root_1 = (Object)adaptor.nil();
								root_1 = (Object)adaptor.becomeRoot(stream_IF.nextNode(), root_1);
								adaptor.addChild(root_1, stream_expr.nextTree());
								// Tiger.g:552:26: ^( THEN_STATS $seq1)
								{
								Object root_2 = (Object)adaptor.nil();
								root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(THEN_STATS, "THEN_STATS"), root_2);
								adaptor.addChild(root_2, stream_seq1.nextTree());
								adaptor.addChild(root_1, root_2);
								}

								// Tiger.g:552:46: ^( ELSE_STATS $seq2)
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
							// Tiger.g:553:11: ENDIF
							{
							ENDIF71=(Token)match(input,ENDIF,FOLLOW_ENDIF_in_stat1904);  
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
							// 554:13: -> ^( IF expr ^( THEN_STATS $seq1) )
							{
								// Tiger.g:554:16: ^( IF expr ^( THEN_STATS $seq1) )
								{
								Object root_1 = (Object)adaptor.nil();
								root_1 = (Object)adaptor.becomeRoot(stream_IF.nextNode(), root_1);
								adaptor.addChild(root_1, stream_expr.nextTree());
								// Tiger.g:554:26: ^( THEN_STATS $seq1)
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

					char_literal72=(Token)match(input,SEMI,FOLLOW_SEMI_in_stat1943);  
					stream_SEMI.add(char_literal72);

					}
					break;
				case 3 :
					// Tiger.g:556:7: WHILE expr DO stat_seq ENDDO ';'
					{
					WHILE73=(Token)match(input,WHILE,FOLLOW_WHILE_in_stat1951);  
					stream_WHILE.add(WHILE73);

					pushFollow(FOLLOW_expr_in_stat1953);
					expr74=expr();
					state._fsp--;

					stream_expr.add(expr74.getTree());

						if((expr74!=null?((TigerParser.expr_return)expr74).e:null) == null || (expr74!=null?((TigerParser.expr_return)expr74).e:null).type.name == null) {
							System.out.println("ERROR in \"" + currFunc.funcName + "\" " + " WHILE NULL pointer ERROR!");
						}
						else if (!(expr74!=null?((TigerParser.expr_return)expr74).e:null).type.name.equals("boolean")) {
					        System.out.println("ERROR in \"" + currFunc.funcName + "\" " + " expr after WHILE statement has to be boolean!!!");}
						
					DO75=(Token)match(input,DO,FOLLOW_DO_in_stat1957);  
					stream_DO.add(DO75);

					pushFollow(FOLLOW_stat_seq_in_stat1959);
					stat_seq76=stat_seq();
					state._fsp--;

					stream_stat_seq.add(stat_seq76.getTree());
					ENDDO77=(Token)match(input,ENDDO,FOLLOW_ENDDO_in_stat1961);  
					stream_ENDDO.add(ENDDO77);

					char_literal78=(Token)match(input,SEMI,FOLLOW_SEMI_in_stat1963);  
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
					// 564:9: -> ^( WHILE expr stat_seq )
					{
						// Tiger.g:564:12: ^( WHILE expr stat_seq )
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
					// Tiger.g:565:7: FOR ID ':=' index_expr TO index_expr DO stat_seq ENDDO ';'
					{
					FOR79=(Token)match(input,FOR,FOLLOW_FOR_in_stat1990);  
					stream_FOR.add(FOR79);

					ID80=(Token)match(input,ID,FOLLOW_ID_in_stat1992);  
					stream_ID.add(ID80);

					string_literal81=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_stat1994);  
					stream_ASSIGN.add(string_literal81);

					pushFollow(FOLLOW_index_expr_in_stat1996);
					index_expr82=index_expr();
					state._fsp--;

					stream_index_expr.add(index_expr82.getTree());
					TO83=(Token)match(input,TO,FOLLOW_TO_in_stat1998);  
					stream_TO.add(TO83);

					pushFollow(FOLLOW_index_expr_in_stat2000);
					index_expr84=index_expr();
					state._fsp--;

					stream_index_expr.add(index_expr84.getTree());
					DO85=(Token)match(input,DO,FOLLOW_DO_in_stat2002);  
					stream_DO.add(DO85);

					pushFollow(FOLLOW_stat_seq_in_stat2004);
					stat_seq86=stat_seq();
					state._fsp--;

					stream_stat_seq.add(stat_seq86.getTree());
					ENDDO87=(Token)match(input,ENDDO,FOLLOW_ENDDO_in_stat2006);  
					stream_ENDDO.add(ENDDO87);

					char_literal88=(Token)match(input,SEMI,FOLLOW_SEMI_in_stat2008);  
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
					// 566:9: -> ^( FOR ID index_expr index_expr stat_seq )
					{
						// Tiger.g:566:12: ^( FOR ID index_expr index_expr stat_seq )
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
					// Tiger.g:567:7: BREAK ';' !
					{
					root_0 = (Object)adaptor.nil();


					BREAK89=(Token)match(input,BREAK,FOLLOW_BREAK_in_stat2038); 
					BREAK89_tree = (Object)adaptor.create(BREAK89);
					adaptor.addChild(root_0, BREAK89_tree);

					char_literal90=(Token)match(input,SEMI,FOLLOW_SEMI_in_stat2040); 
					}
					break;
				case 6 :
					// Tiger.g:568:7: RETURN expr ';'
					{
					RETURN91=(Token)match(input,RETURN,FOLLOW_RETURN_in_stat2049);  
					stream_RETURN.add(RETURN91);

					pushFollow(FOLLOW_expr_in_stat2051);
					expr92=expr();
					state._fsp--;

					stream_expr.add(expr92.getTree());
					char_literal93=(Token)match(input,SEMI,FOLLOW_SEMI_in_stat2053);  
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
					// 580:9: -> ^( RETURN expr )
					{
						// Tiger.g:580:12: ^( RETURN expr )
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
					// Tiger.g:581:7: block
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_block_in_stat2080);
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
		public ArrayList<Expr> pList;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "function_args"
	// Tiger.g:587:1: function_args returns [ArrayList<Expr> pList] : '(' expr_list ')' -> ( expr_list )? ;
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
			// Tiger.g:588:5: ( '(' expr_list ')' -> ( expr_list )? )
			// Tiger.g:588:7: '(' expr_list ')'
			{
			char_literal95=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_function_args2103);  
			stream_LPAREN.add(char_literal95);

			pushFollow(FOLLOW_expr_list_in_function_args2105);
			expr_list96=expr_list();
			state._fsp--;

			stream_expr_list.add(expr_list96.getTree());
			char_literal97=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_function_args2107);  
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
			// 590:9: -> ( expr_list )?
			{
				// Tiger.g:590:12: ( expr_list )?
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
	// Tiger.g:593:1: function_call_or_assignment : ID ( function_args -> ^( FUNCTION_CALL ID ( function_args )? ) | value_tail ':=' expr_or_function_call -> ^( ':=' ^( ID ( value_tail )? ) expr_or_function_call ) ) ';' ;
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
			// Tiger.g:594:5: ( ID ( function_args -> ^( FUNCTION_CALL ID ( function_args )? ) | value_tail ':=' expr_or_function_call -> ^( ':=' ^( ID ( value_tail )? ) expr_or_function_call ) ) ';' )
			// Tiger.g:594:7: ID ( function_args -> ^( FUNCTION_CALL ID ( function_args )? ) | value_tail ':=' expr_or_function_call -> ^( ':=' ^( ID ( value_tail )? ) expr_or_function_call ) ) ';'
			{
			ID98=(Token)match(input,ID,FOLLOW_ID_in_function_call_or_assignment2140);  
			stream_ID.add(ID98);

			// Tiger.g:595:9: ( function_args -> ^( FUNCTION_CALL ID ( function_args )? ) | value_tail ':=' expr_or_function_call -> ^( ':=' ^( ID ( value_tail )? ) expr_or_function_call ) )
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
					// Tiger.g:595:10: function_args
					{
					pushFollow(FOLLOW_function_args_in_function_call_or_assignment2152);
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
					// 602:13: -> ^( FUNCTION_CALL ID ( function_args )? )
					{
						// Tiger.g:602:16: ^( FUNCTION_CALL ID ( function_args )? )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNCTION_CALL, "FUNCTION_CALL"), root_1);
						adaptor.addChild(root_1, stream_ID.nextNode());
						// Tiger.g:602:35: ( function_args )?
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
					// Tiger.g:604:11: value_tail ':=' expr_or_function_call
					{
					pushFollow(FOLLOW_value_tail_in_function_call_or_assignment2201);
					value_tail100=value_tail();
					state._fsp--;

					stream_value_tail.add(value_tail100.getTree());
					string_literal101=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_function_call_or_assignment2203);  
					stream_ASSIGN.add(string_literal101);

					pushFollow(FOLLOW_expr_or_function_call_in_function_call_or_assignment2205);
					expr_or_function_call102=expr_or_function_call();
					state._fsp--;

					stream_expr_or_function_call.add(expr_or_function_call102.getTree());

								Var v = getValue((ID98!=null?ID98.getText():null));
								Type t = (expr_or_function_call102!=null?((TigerParser.expr_or_function_call_return)expr_or_function_call102).t:null);
								if(v == null || t == null) {
									System.out.println("ERROR in \"" + currFunc.funcName + "\" " +(ID98!=null?ID98.getText():null) + " function_call_or_assignment NULL!"  + v + " " + t);
								} else if(((Id)v).type instanceof UserType) {
									if(!((UserType)(((Id)v).type)).userTypeName.equals(t.name)) {
										System.out.println("ERROR in \"" + currFunc.funcName + "\" " +(ID98!=null?ID98.getText():null) + "=> Assignment Type doesn't match!" + " " + ((UserType)((Id)v).type).userTypeName + "/ "+ t.name);
									}
								} else if(!((Id)v).type.name.equals(t.name)) {
									System.out.println("ERROR in \"" + currFunc.funcName + "\" " +(ID98!=null?ID98.getText():null) + "=> Assignment Type doesn't match!" + " " + ((Id)v).type.name + "/ "+ t.name);// + ";;" + ((UserType)(((Id)v).type).)userTypeName);
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
					// 623:13: -> ^( ':=' ^( ID ( value_tail )? ) expr_or_function_call )
					{
						// Tiger.g:623:16: ^( ':=' ^( ID ( value_tail )? ) expr_or_function_call )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot(stream_ASSIGN.nextNode(), root_1);
						// Tiger.g:623:23: ^( ID ( value_tail )? )
						{
						Object root_2 = (Object)adaptor.nil();
						root_2 = (Object)adaptor.becomeRoot(stream_ID.nextNode(), root_2);
						// Tiger.g:623:28: ( value_tail )?
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

			char_literal103=(Token)match(input,SEMI,FOLLOW_SEMI_in_function_call_or_assignment2257);  
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
	// Tiger.g:629:1: expr_or_function_call returns [Type t] : ( ID ( expr_with_start_id[$ID, $ID.text] -> ^( EXPR_WITH_START_ID ( expr_with_start_id )? ) | ( ( function_args ) -> ^( FUNCTION_CALL ID ( function_args )? ) ) ) | ( expr_no_start_id ) );
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
			// Tiger.g:630:5: ( ID ( expr_with_start_id[$ID, $ID.text] -> ^( EXPR_WITH_START_ID ( expr_with_start_id )? ) | ( ( function_args ) -> ^( FUNCTION_CALL ID ( function_args )? ) ) ) | ( expr_no_start_id ) )
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
					// Tiger.g:630:7: ID ( expr_with_start_id[$ID, $ID.text] -> ^( EXPR_WITH_START_ID ( expr_with_start_id )? ) | ( ( function_args ) -> ^( FUNCTION_CALL ID ( function_args )? ) ) )
					{
					ID104=(Token)match(input,ID,FOLLOW_ID_in_expr_or_function_call2279);  
					stream_ID.add(ID104);

					// Tiger.g:631:9: ( expr_with_start_id[$ID, $ID.text] -> ^( EXPR_WITH_START_ID ( expr_with_start_id )? ) | ( ( function_args ) -> ^( FUNCTION_CALL ID ( function_args )? ) ) )
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
							// Tiger.g:631:10: expr_with_start_id[$ID, $ID.text]
							{
							pushFollow(FOLLOW_expr_with_start_id_in_expr_or_function_call2291);
							expr_with_start_id105=expr_with_start_id(ID104, (ID104!=null?ID104.getText():null));
							state._fsp--;

							stream_expr_with_start_id.add(expr_with_start_id105.getTree());

									if((expr_with_start_id105!=null?((TigerParser.expr_with_start_id_return)expr_with_start_id105).e:null) == null) {
										System.out.println("ERROR in \"" + currFunc.funcName + "\" " +(ID104!=null?ID104.getText():null) + " Has wrong type!");
									} else { 
										retval.t = new Type((expr_with_start_id105!=null?((TigerParser.expr_with_start_id_return)expr_with_start_id105).e:null).type.name);
									}
							            
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
							// 640:3: -> ^( EXPR_WITH_START_ID ( expr_with_start_id )? )
							{
								// Tiger.g:640:6: ^( EXPR_WITH_START_ID ( expr_with_start_id )? )
								{
								Object root_1 = (Object)adaptor.nil();
								root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EXPR_WITH_START_ID, "EXPR_WITH_START_ID"), root_1);
								// Tiger.g:640:27: ( expr_with_start_id )?
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
							// Tiger.g:641:11: ( ( function_args ) -> ^( FUNCTION_CALL ID ( function_args )? ) )
							{
							// Tiger.g:641:11: ( ( function_args ) -> ^( FUNCTION_CALL ID ( function_args )? ) )
							// Tiger.g:641:12: ( function_args )
							{
							// Tiger.g:641:12: ( function_args )
							// Tiger.g:641:13: function_args
							{
							pushFollow(FOLLOW_function_args_in_expr_or_function_call2333);
							function_args106=function_args();
							state._fsp--;

							stream_function_args.add(function_args106.getTree());

										checkFuncParam((ID104!=null?ID104.getText():null), (function_args106!=null?((TigerParser.function_args_return)function_args106).pList:null));
										Var fun = getValue((ID104!=null?ID104.getText():null));
										if (fun == null) {
											System.out.println("ERROR in \"" + currFunc.funcName + "\" " +(ID104!=null?ID104.getText():null) + " Function not found in Symbol Table!");
										} else if(!(fun instanceof Function)) {
											System.out.println("ERROR in \"" + currFunc.funcName + "\" " +(ID104!=null?ID104.getText():null) + " is Not Function!");
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
							// 653:13: -> ^( FUNCTION_CALL ID ( function_args )? )
							{
								// Tiger.g:653:16: ^( FUNCTION_CALL ID ( function_args )? )
								{
								Object root_1 = (Object)adaptor.nil();
								root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNCTION_CALL, "FUNCTION_CALL"), root_1);
								adaptor.addChild(root_1, stream_ID.nextNode());
								// Tiger.g:653:35: ( function_args )?
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
					// Tiger.g:655:7: ( expr_no_start_id )
					{
					root_0 = (Object)adaptor.nil();


					// Tiger.g:655:7: ( expr_no_start_id )
					// Tiger.g:655:8: expr_no_start_id
					{
					pushFollow(FOLLOW_expr_no_start_id_in_expr_or_function_call2382);
					expr_no_start_id107=expr_no_start_id();
					state._fsp--;

					adaptor.addChild(root_0, expr_no_start_id107.getTree());


							if((expr_no_start_id107!=null?((TigerParser.expr_no_start_id_return)expr_no_start_id107).e:null) == null) {
								System.out.println("ERROR in \"" + currFunc.funcName + "\" " + " an Expression has wrong type!");
							} else { 
								retval.t = new Type((expr_no_start_id107!=null?((TigerParser.expr_no_start_id_return)expr_no_start_id107).e:null).type.name);
							}

					//    System.out.println("Type returned in expr_or_function_call is: " + retval.t);

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
	// Tiger.g:673:1: expr returns [Expr e] :t1= term4 ( and_operator ^t2= term4 )* ;
	public final TigerParser.expr_return expr() throws RecognitionException {
		TigerParser.expr_return retval = new TigerParser.expr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope t1 =null;
		ParserRuleReturnScope t2 =null;
		ParserRuleReturnScope and_operator108 =null;


		try {
			// Tiger.g:674:5: (t1= term4 ( and_operator ^t2= term4 )* )
			// Tiger.g:674:7: t1= term4 ( and_operator ^t2= term4 )*
			{
			root_0 = (Object)adaptor.nil();


			int i = 0;
			pushFollow(FOLLOW_term4_in_expr2417);
			t1=term4();
			state._fsp--;

			adaptor.addChild(root_0, t1.getTree());

			// Tiger.g:674:28: ( and_operator ^t2= term4 )*
			loop21:
			while (true) {
				int alt21=2;
				int LA21_0 = input.LA(1);
				if ( (LA21_0==AND||LA21_0==OR) ) {
					alt21=1;
				}

				switch (alt21) {
				case 1 :
					// Tiger.g:674:29: and_operator ^t2= term4
					{
					pushFollow(FOLLOW_and_operator_in_expr2420);
					and_operator108=and_operator();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(and_operator108.getTree(), root_0);
					pushFollow(FOLLOW_term4_in_expr2425);
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
	// Tiger.g:688:1: term4 returns [Expr e] :t1= term3 ( compare_operator ^t2= term3 )* ;
	public final TigerParser.term4_return term4() throws RecognitionException {
		TigerParser.term4_return retval = new TigerParser.term4_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope t1 =null;
		ParserRuleReturnScope t2 =null;
		ParserRuleReturnScope compare_operator109 =null;


		try {
			// Tiger.g:689:5: (t1= term3 ( compare_operator ^t2= term3 )* )
			// Tiger.g:689:7: t1= term3 ( compare_operator ^t2= term3 )*
			{
			root_0 = (Object)adaptor.nil();


			int i = 0;
			pushFollow(FOLLOW_term3_in_term42468);
			t1=term3();
			state._fsp--;

			adaptor.addChild(root_0, t1.getTree());

			// Tiger.g:689:28: ( compare_operator ^t2= term3 )*
			loop22:
			while (true) {
				int alt22=2;
				int LA22_0 = input.LA(1);
				if ( (LA22_0==EQ||(LA22_0 >= GREATER && LA22_0 <= GREATEREQ)||(LA22_0 >= LESSER && LA22_0 <= LESSEREQ)||LA22_0==NEQ) ) {
					alt22=1;
				}

				switch (alt22) {
				case 1 :
					// Tiger.g:689:29: compare_operator ^t2= term3
					{
					pushFollow(FOLLOW_compare_operator_in_term42471);
					compare_operator109=compare_operator();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(compare_operator109.getTree(), root_0);
					pushFollow(FOLLOW_term3_in_term42476);
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
	// Tiger.g:703:1: term3 returns [Expr e] :t1= term2 ( add_operator ^t2= term2 )* ;
	public final TigerParser.term3_return term3() throws RecognitionException {
		TigerParser.term3_return retval = new TigerParser.term3_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope t1 =null;
		ParserRuleReturnScope t2 =null;
		ParserRuleReturnScope add_operator110 =null;


		try {
			// Tiger.g:704:5: (t1= term2 ( add_operator ^t2= term2 )* )
			// Tiger.g:704:7: t1= term2 ( add_operator ^t2= term2 )*
			{
			root_0 = (Object)adaptor.nil();


			int i = 0;
			pushFollow(FOLLOW_term2_in_term32521);
			t1=term2();
			state._fsp--;

			adaptor.addChild(root_0, t1.getTree());

			// Tiger.g:704:28: ( add_operator ^t2= term2 )*
			loop23:
			while (true) {
				int alt23=2;
				int LA23_0 = input.LA(1);
				if ( (LA23_0==MINUS||LA23_0==PLUS) ) {
					alt23=1;
				}

				switch (alt23) {
				case 1 :
					// Tiger.g:704:29: add_operator ^t2= term2
					{
					pushFollow(FOLLOW_add_operator_in_term32524);
					add_operator110=add_operator();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(add_operator110.getTree(), root_0);
					pushFollow(FOLLOW_term2_in_term32529);
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
	// Tiger.g:717:1: term2 returns [Expr e] :t1= term1 ( mult_operator ^t2= term1 )* ;
	public final TigerParser.term2_return term2() throws RecognitionException {
		TigerParser.term2_return retval = new TigerParser.term2_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope t1 =null;
		ParserRuleReturnScope t2 =null;
		ParserRuleReturnScope mult_operator111 =null;


		try {
			// Tiger.g:718:5: (t1= term1 ( mult_operator ^t2= term1 )* )
			// Tiger.g:718:7: t1= term1 ( mult_operator ^t2= term1 )*
			{
			root_0 = (Object)adaptor.nil();


			int i = 0;
			pushFollow(FOLLOW_term1_in_term22557);
			t1=term1();
			state._fsp--;

			adaptor.addChild(root_0, t1.getTree());

			// Tiger.g:718:28: ( mult_operator ^t2= term1 )*
			loop24:
			while (true) {
				int alt24=2;
				int LA24_0 = input.LA(1);
				if ( (LA24_0==DIV||LA24_0==MULT) ) {
					alt24=1;
				}

				switch (alt24) {
				case 1 :
					// Tiger.g:718:29: mult_operator ^t2= term1
					{
					pushFollow(FOLLOW_mult_operator_in_term22560);
					mult_operator111=mult_operator();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(mult_operator111.getTree(), root_0);
					pushFollow(FOLLOW_term1_in_term22565);
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
	// Tiger.g:732:1: term1 returns [Expr e] : ( literal | value | '(' expr ')' -> expr );
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
			// Tiger.g:733:5: ( literal | value | '(' expr ')' -> expr )
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
					// Tiger.g:733:7: literal
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_literal_in_term12588);
					literal112=literal();
					state._fsp--;

					adaptor.addChild(root_0, literal112.getTree());

					retval.e = (literal112!=null?((TigerParser.literal_return)literal112).e:null);
					}
					break;
				case 2 :
					// Tiger.g:734:7: value
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_value_in_term12598);
					value113=value();
					state._fsp--;

					adaptor.addChild(root_0, value113.getTree());

					retval.e = (value113!=null?((TigerParser.value_return)value113).e:null);
					}
					break;
				case 3 :
					// Tiger.g:735:7: '(' expr ')'
					{
					char_literal114=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_term12608);  
					stream_LPAREN.add(char_literal114);

					pushFollow(FOLLOW_expr_in_term12610);
					expr115=expr();
					state._fsp--;

					stream_expr.add(expr115.getTree());
					char_literal116=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_term12612);  
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
					// 736:9: -> expr
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
	// Tiger.g:739:1: expr_no_start_id returns [Expr e] :t1= term4_no_start_id ( and_operator ^t2= term4 )* ;
	public final TigerParser.expr_no_start_id_return expr_no_start_id() throws RecognitionException {
		TigerParser.expr_no_start_id_return retval = new TigerParser.expr_no_start_id_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope t1 =null;
		ParserRuleReturnScope t2 =null;
		ParserRuleReturnScope and_operator117 =null;


		try {
			// Tiger.g:740:5: (t1= term4_no_start_id ( and_operator ^t2= term4 )* )
			// Tiger.g:740:7: t1= term4_no_start_id ( and_operator ^t2= term4 )*
			{
			root_0 = (Object)adaptor.nil();


			int i = 0;
			pushFollow(FOLLOW_term4_no_start_id_in_expr_no_start_id2649);
			t1=term4_no_start_id();
			state._fsp--;

			adaptor.addChild(root_0, t1.getTree());

			// Tiger.g:740:40: ( and_operator ^t2= term4 )*
			loop26:
			while (true) {
				int alt26=2;
				int LA26_0 = input.LA(1);
				if ( (LA26_0==AND||LA26_0==OR) ) {
					alt26=1;
				}

				switch (alt26) {
				case 1 :
					// Tiger.g:740:41: and_operator ^t2= term4
					{
					pushFollow(FOLLOW_and_operator_in_expr_no_start_id2652);
					and_operator117=and_operator();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(and_operator117.getTree(), root_0);
					pushFollow(FOLLOW_term4_in_expr_no_start_id2657);
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
			//              System.out.println("Type returned is: " + retval.e.type);
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
	// Tiger.g:755:1: term4_no_start_id returns [Expr e] :t1= term3_no_start_id ( compare_operator ^t2= term3 )* ;
	public final TigerParser.term4_no_start_id_return term4_no_start_id() throws RecognitionException {
		TigerParser.term4_no_start_id_return retval = new TigerParser.term4_no_start_id_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope t1 =null;
		ParserRuleReturnScope t2 =null;
		ParserRuleReturnScope compare_operator118 =null;


		try {
			// Tiger.g:756:5: (t1= term3_no_start_id ( compare_operator ^t2= term3 )* )
			// Tiger.g:756:7: t1= term3_no_start_id ( compare_operator ^t2= term3 )*
			{
			root_0 = (Object)adaptor.nil();


			int i = 0;
			pushFollow(FOLLOW_term3_no_start_id_in_term4_no_start_id2700);
			t1=term3_no_start_id();
			state._fsp--;

			adaptor.addChild(root_0, t1.getTree());

			// Tiger.g:756:40: ( compare_operator ^t2= term3 )*
			loop27:
			while (true) {
				int alt27=2;
				int LA27_0 = input.LA(1);
				if ( (LA27_0==EQ||(LA27_0 >= GREATER && LA27_0 <= GREATEREQ)||(LA27_0 >= LESSER && LA27_0 <= LESSEREQ)||LA27_0==NEQ) ) {
					alt27=1;
				}

				switch (alt27) {
				case 1 :
					// Tiger.g:756:41: compare_operator ^t2= term3
					{
					pushFollow(FOLLOW_compare_operator_in_term4_no_start_id2703);
					compare_operator118=compare_operator();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(compare_operator118.getTree(), root_0);
					pushFollow(FOLLOW_term3_in_term4_no_start_id2708);
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
	// Tiger.g:771:1: term3_no_start_id returns [Expr e] :t1= term2_no_start_id ( add_operator ^t2= term2 )* ;
	public final TigerParser.term3_no_start_id_return term3_no_start_id() throws RecognitionException {
		TigerParser.term3_no_start_id_return retval = new TigerParser.term3_no_start_id_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope t1 =null;
		ParserRuleReturnScope t2 =null;
		ParserRuleReturnScope add_operator119 =null;


		try {
			// Tiger.g:772:5: (t1= term2_no_start_id ( add_operator ^t2= term2 )* )
			// Tiger.g:772:7: t1= term2_no_start_id ( add_operator ^t2= term2 )*
			{
			root_0 = (Object)adaptor.nil();


			int i = 0;
			pushFollow(FOLLOW_term2_no_start_id_in_term3_no_start_id2751);
			t1=term2_no_start_id();
			state._fsp--;

			adaptor.addChild(root_0, t1.getTree());

			// Tiger.g:772:40: ( add_operator ^t2= term2 )*
			loop28:
			while (true) {
				int alt28=2;
				int LA28_0 = input.LA(1);
				if ( (LA28_0==MINUS||LA28_0==PLUS) ) {
					alt28=1;
				}

				switch (alt28) {
				case 1 :
					// Tiger.g:772:41: add_operator ^t2= term2
					{
					pushFollow(FOLLOW_add_operator_in_term3_no_start_id2754);
					add_operator119=add_operator();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(add_operator119.getTree(), root_0);
					pushFollow(FOLLOW_term2_in_term3_no_start_id2759);
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
	// Tiger.g:785:1: term2_no_start_id returns [Expr e] :t1= term1_no_start_id ( mult_operator ^t2= term1 )* ;
	public final TigerParser.term2_no_start_id_return term2_no_start_id() throws RecognitionException {
		TigerParser.term2_no_start_id_return retval = new TigerParser.term2_no_start_id_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope t1 =null;
		ParserRuleReturnScope t2 =null;
		ParserRuleReturnScope mult_operator120 =null;


		try {
			// Tiger.g:786:5: (t1= term1_no_start_id ( mult_operator ^t2= term1 )* )
			// Tiger.g:786:7: t1= term1_no_start_id ( mult_operator ^t2= term1 )*
			{
			root_0 = (Object)adaptor.nil();


			int i = 0;
			pushFollow(FOLLOW_term1_no_start_id_in_term2_no_start_id2786);
			t1=term1_no_start_id();
			state._fsp--;

			adaptor.addChild(root_0, t1.getTree());

			// Tiger.g:786:40: ( mult_operator ^t2= term1 )*
			loop29:
			while (true) {
				int alt29=2;
				int LA29_0 = input.LA(1);
				if ( (LA29_0==DIV||LA29_0==MULT) ) {
					alt29=1;
				}

				switch (alt29) {
				case 1 :
					// Tiger.g:786:41: mult_operator ^t2= term1
					{
					pushFollow(FOLLOW_mult_operator_in_term2_no_start_id2789);
					mult_operator120=mult_operator();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(mult_operator120.getTree(), root_0);
					pushFollow(FOLLOW_term1_in_term2_no_start_id2794);
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
	// Tiger.g:801:1: term1_no_start_id returns [Expr e] : ( literal | '(' expr ')' -> expr );
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
			// Tiger.g:802:5: ( literal | '(' expr ')' -> expr )
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
					// Tiger.g:802:7: literal
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_literal_in_term1_no_start_id2818);
					literal121=literal();
					state._fsp--;

					adaptor.addChild(root_0, literal121.getTree());

					retval.e = (literal121!=null?((TigerParser.literal_return)literal121).e:null);
					}
					break;
				case 2 :
					// Tiger.g:803:7: '(' expr ')'
					{
					char_literal122=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_term1_no_start_id2828);  
					stream_LPAREN.add(char_literal122);

					pushFollow(FOLLOW_expr_in_term1_no_start_id2830);
					expr123=expr();
					state._fsp--;

					stream_expr.add(expr123.getTree());
					char_literal124=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_term1_no_start_id2832);  
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
					// 804:9: -> expr
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
	// Tiger.g:807:1: expr_with_start_id[Token startId, String s] returns [Expr e] :t1= term4_with_start_id[$startId, $s] ( and_operator ^t2= term4 )* ;
	public final TigerParser.expr_with_start_id_return expr_with_start_id(Token startId, String s) throws RecognitionException {
		TigerParser.expr_with_start_id_return retval = new TigerParser.expr_with_start_id_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope t1 =null;
		ParserRuleReturnScope t2 =null;
		ParserRuleReturnScope and_operator125 =null;


		try {
			// Tiger.g:808:5: (t1= term4_with_start_id[$startId, $s] ( and_operator ^t2= term4 )* )
			// Tiger.g:808:7: t1= term4_with_start_id[$startId, $s] ( and_operator ^t2= term4 )*
			{
			root_0 = (Object)adaptor.nil();


			int i = 0;
			pushFollow(FOLLOW_term4_with_start_id_in_expr_with_start_id2873);
			t1=term4_with_start_id(startId, s);
			state._fsp--;

			adaptor.addChild(root_0, t1.getTree());

			// Tiger.g:808:57: ( and_operator ^t2= term4 )*
			loop31:
			while (true) {
				int alt31=2;
				int LA31_0 = input.LA(1);
				if ( (LA31_0==AND||LA31_0==OR) ) {
					alt31=1;
				}

				switch (alt31) {
				case 1 :
					// Tiger.g:808:58: and_operator ^t2= term4
					{
					pushFollow(FOLLOW_and_operator_in_expr_with_start_id2877);
					and_operator125=and_operator();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(and_operator125.getTree(), root_0);
					pushFollow(FOLLOW_term4_in_expr_with_start_id2882);
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
	// Tiger.g:822:1: term4_with_start_id[Token startId, String s] returns [Expr e] :t1= term3_with_start_id[$startId, $s] ( compare_operator ^t2= term3 )* ;
	public final TigerParser.term4_with_start_id_return term4_with_start_id(Token startId, String s) throws RecognitionException {
		TigerParser.term4_with_start_id_return retval = new TigerParser.term4_with_start_id_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope t1 =null;
		ParserRuleReturnScope t2 =null;
		ParserRuleReturnScope compare_operator126 =null;


		try {
			// Tiger.g:823:5: (t1= term3_with_start_id[$startId, $s] ( compare_operator ^t2= term3 )* )
			// Tiger.g:823:7: t1= term3_with_start_id[$startId, $s] ( compare_operator ^t2= term3 )*
			{
			root_0 = (Object)adaptor.nil();


			int i = 0;
			pushFollow(FOLLOW_term3_with_start_id_in_term4_with_start_id2917);
			t1=term3_with_start_id(startId, s);
			state._fsp--;

			adaptor.addChild(root_0, t1.getTree());

			// Tiger.g:823:57: ( compare_operator ^t2= term3 )*
			loop32:
			while (true) {
				int alt32=2;
				int LA32_0 = input.LA(1);
				if ( (LA32_0==EQ||(LA32_0 >= GREATER && LA32_0 <= GREATEREQ)||(LA32_0 >= LESSER && LA32_0 <= LESSEREQ)||LA32_0==NEQ) ) {
					alt32=1;
				}

				switch (alt32) {
				case 1 :
					// Tiger.g:823:58: compare_operator ^t2= term3
					{
					pushFollow(FOLLOW_compare_operator_in_term4_with_start_id2921);
					compare_operator126=compare_operator();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(compare_operator126.getTree(), root_0);
					pushFollow(FOLLOW_term3_in_term4_with_start_id2926);
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
			//            System.out.println("Type returned from term4_with_start_id is: " + retval.e);
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
	// Tiger.g:839:1: term3_with_start_id[Token startId, String s] returns [Expr e] :t1= term2_with_start_id[$startId, $s] ( add_operator ^t2= term2 )* ;
	public final TigerParser.term3_with_start_id_return term3_with_start_id(Token startId, String s) throws RecognitionException {
		TigerParser.term3_with_start_id_return retval = new TigerParser.term3_with_start_id_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope t1 =null;
		ParserRuleReturnScope t2 =null;
		ParserRuleReturnScope add_operator127 =null;


		try {
			// Tiger.g:840:5: (t1= term2_with_start_id[$startId, $s] ( add_operator ^t2= term2 )* )
			// Tiger.g:840:7: t1= term2_with_start_id[$startId, $s] ( add_operator ^t2= term2 )*
			{
			root_0 = (Object)adaptor.nil();


			int i = 0;
			pushFollow(FOLLOW_term2_with_start_id_in_term3_with_start_id2972);
			t1=term2_with_start_id(startId, s);
			state._fsp--;

			adaptor.addChild(root_0, t1.getTree());

			// Tiger.g:840:57: ( add_operator ^t2= term2 )*
			loop33:
			while (true) {
				int alt33=2;
				int LA33_0 = input.LA(1);
				if ( (LA33_0==MINUS||LA33_0==PLUS) ) {
					alt33=1;
				}

				switch (alt33) {
				case 1 :
					// Tiger.g:840:58: add_operator ^t2= term2
					{
					pushFollow(FOLLOW_add_operator_in_term3_with_start_id2976);
					add_operator127=add_operator();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(add_operator127.getTree(), root_0);
					pushFollow(FOLLOW_term2_in_term3_with_start_id2981);
					t2=term2();
					state._fsp--;

					adaptor.addChild(root_0, t2.getTree());

					 System.out.println("Entered term3_with_start_id!!");
					      if ((t1!=null?((TigerParser.term2_with_start_id_return)t1).e:null).type != null)
					          System.out.println("first term type is: " + (t1!=null?((TigerParser.term2_with_start_id_return)t1).e:null).type);
					      if ((t2!=null?((TigerParser.term2_return)t2).e:null).type != null)
					          System.out.println("second term type is: " + (t2!=null?((TigerParser.term2_return)t2).e:null).type);
					      if (Arith.typeCheckPassed((t1!=null?((TigerParser.term2_with_start_id_return)t1).e:null), (t2!=null?((TigerParser.term2_return)t2).e:null))) {
					            System.out.println("type check passed!!");
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
	// Tiger.g:859:1: term2_with_start_id[Token startId, String s] returns [Expr e] :t1= term1_with_start_id[$startId, $s] ( mult_operator ^t2= term1 )* ;
	public final TigerParser.term2_with_start_id_return term2_with_start_id(Token startId, String s) throws RecognitionException {
		TigerParser.term2_with_start_id_return retval = new TigerParser.term2_with_start_id_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope t1 =null;
		ParserRuleReturnScope t2 =null;
		ParserRuleReturnScope mult_operator128 =null;


		try {
			// Tiger.g:860:5: (t1= term1_with_start_id[$startId, $s] ( mult_operator ^t2= term1 )* )
			// Tiger.g:860:7: t1= term1_with_start_id[$startId, $s] ( mult_operator ^t2= term1 )*
			{
			root_0 = (Object)adaptor.nil();


			int i = 0;
			pushFollow(FOLLOW_term1_with_start_id_in_term2_with_start_id3012);
			t1=term1_with_start_id(startId, s);
			state._fsp--;

			adaptor.addChild(root_0, t1.getTree());

			// Tiger.g:860:57: ( mult_operator ^t2= term1 )*
			loop34:
			while (true) {
				int alt34=2;
				int LA34_0 = input.LA(1);
				if ( (LA34_0==DIV||LA34_0==MULT) ) {
					alt34=1;
				}

				switch (alt34) {
				case 1 :
					// Tiger.g:860:58: mult_operator ^t2= term1
					{
					pushFollow(FOLLOW_mult_operator_in_term2_with_start_id3016);
					mult_operator128=mult_operator();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(mult_operator128.getTree(), root_0);
					pushFollow(FOLLOW_term1_in_term2_with_start_id3021);
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
	// Tiger.g:876:1: term1_with_start_id[Token startId, String s] returns [Expr e] : value_tail -> ^( ( value_tail )? ) ;
	public final TigerParser.term1_with_start_id_return term1_with_start_id(Token startId, String s) throws RecognitionException {
		TigerParser.term1_with_start_id_return retval = new TigerParser.term1_with_start_id_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope value_tail129 =null;

		RewriteRuleSubtreeStream stream_value_tail=new RewriteRuleSubtreeStream(adaptor,"rule value_tail");

		try {
			// Tiger.g:877:5: ( value_tail -> ^( ( value_tail )? ) )
			// Tiger.g:877:7: value_tail
			{
			pushFollow(FOLLOW_value_tail_in_term1_with_start_id3047);
			value_tail129=value_tail();
			state._fsp--;

			stream_value_tail.add(value_tail129.getTree());

					Var v = getValue(s);
					if(v == null) {
						System.out.println("ERROR in \"" + currFunc.funcName + "\" " +s + " Symbol not found! / term1_with_start_id");
					} else if(!(v instanceof Id)) {
						System.out.println("ERROR in \"" + currFunc.funcName + "\" " +s + " is not Id! / term1_with_start_id");
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
			// 888:2: -> ^( ( value_tail )? )
			{
				// Tiger.g:888:5: ^( ( value_tail )? )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot(new CommonTree(startId), root_1);
				// Tiger.g:888:34: ( value_tail )?
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
		public ArrayList<Expr> list;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expr_list"
	// Tiger.g:892:1: expr_list returns [ArrayList<Expr> list] : (e1= expr ( ',' e2= expr )* -> ^( EXPRLIST ( expr )+ ) |);
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
			// Tiger.g:893:5: (e1= expr ( ',' e2= expr )* -> ^( EXPRLIST ( expr )+ ) |)
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
					// Tiger.g:893:7: e1= expr ( ',' e2= expr )*
					{
					retval.list = new ArrayList();
					pushFollow(FOLLOW_expr_in_expr_list3085);
					e1=expr();
					state._fsp--;

					stream_expr.add(e1.getTree());
					retval.list.add((e1!=null?((TigerParser.expr_return)e1).e:null));
					// Tiger.g:894:2: ( ',' e2= expr )*
					loop35:
					while (true) {
						int alt35=2;
						int LA35_0 = input.LA(1);
						if ( (LA35_0==COMMA) ) {
							alt35=1;
						}

						switch (alt35) {
						case 1 :
							// Tiger.g:894:4: ',' e2= expr
							{
							char_literal130=(Token)match(input,COMMA,FOLLOW_COMMA_in_expr_list3093);  
							stream_COMMA.add(char_literal130);

							pushFollow(FOLLOW_expr_in_expr_list3097);
							e2=expr();
							state._fsp--;

							stream_expr.add(e2.getTree());
							retval.list.add((e2!=null?((TigerParser.expr_return)e2).e:null));
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
					// 894:38: -> ^( EXPRLIST ( expr )+ )
					{
						// Tiger.g:894:41: ^( EXPRLIST ( expr )+ )
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
					// Tiger.g:896:5: 
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
	// Tiger.g:898:1: mult_operator : ( '*' | '/' );
	public final TigerParser.mult_operator_return mult_operator() throws RecognitionException {
		TigerParser.mult_operator_return retval = new TigerParser.mult_operator_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set131=null;

		Object set131_tree=null;

		try {
			// Tiger.g:899:5: ( '*' | '/' )
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
	// Tiger.g:901:1: add_operator : ( '+' | '-' );
	public final TigerParser.add_operator_return add_operator() throws RecognitionException {
		TigerParser.add_operator_return retval = new TigerParser.add_operator_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set132=null;

		Object set132_tree=null;

		try {
			// Tiger.g:902:5: ( '+' | '-' )
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
	// Tiger.g:904:1: compare_operator : ( '=' | '<>' | '<' | '>' | '<=' | '>=' );
	public final TigerParser.compare_operator_return compare_operator() throws RecognitionException {
		TigerParser.compare_operator_return retval = new TigerParser.compare_operator_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set133=null;

		Object set133_tree=null;

		try {
			// Tiger.g:905:5: ( '=' | '<>' | '<' | '>' | '<=' | '>=' )
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
	// Tiger.g:907:1: and_operator : ( '&' | '|' );
	public final TigerParser.and_operator_return and_operator() throws RecognitionException {
		TigerParser.and_operator_return retval = new TigerParser.and_operator_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set134=null;

		Object set134_tree=null;

		try {
			// Tiger.g:908:5: ( '&' | '|' )
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
	// Tiger.g:910:1: value returns [Expr e] : ID value_tail -> ^( ID ( value_tail )? ) ;
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
			// Tiger.g:911:5: ( ID value_tail -> ^( ID ( value_tail )? ) )
			// Tiger.g:911:7: ID value_tail
			{
			ID135=(Token)match(input,ID,FOLLOW_ID_in_value3224);  
			stream_ID.add(ID135);

			pushFollow(FOLLOW_value_tail_in_value3226);
			value_tail136=value_tail();
			state._fsp--;

			stream_value_tail.add(value_tail136.getTree());

					int a = (value_tail136!=null?((TigerParser.value_tail_return)value_tail136).a:0);
					Var v = getValue((ID135!=null?ID135.getText():null));
			//System.out.println(((Id)v));
					if (!(v instanceof Id)) {
						System.out.println("ERROR in \"" + currFunc.funcName + "\" " +(ID135!=null?ID135.getText():null) + " is not Id value Type!");
					} else if(!((Id)v).init) {
						System.out.println("ERROR in \"" + currFunc.funcName + "\" " +(ID135!=null?ID135.getText():null) + " is not initialized before use!");
					} else if(((Id)v).type instanceof UserType){//(Arith.isUserType(((Id)v).type)) {
			System.out.println("a : " + (value_tail136!=null?((TigerParser.value_tail_return)value_tail136).a:0));

						retval.e = checkArrayType(v, (value_tail136!=null?((TigerParser.value_tail_return)value_tail136).a:0));
						
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
			// 931:21: -> ^( ID ( value_tail )? )
			{
				// Tiger.g:931:4: ^( ID ( value_tail )? )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot(stream_ID.nextNode(), root_1);
				// Tiger.g:931:9: ( value_tail )?
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
	// Tiger.g:933:1: literal returns [Expr e] : ( INTLIT | FIXEDPTLIT );
	public final TigerParser.literal_return literal() throws RecognitionException {
		TigerParser.literal_return retval = new TigerParser.literal_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token INTLIT137=null;
		Token FIXEDPTLIT138=null;

		Object INTLIT137_tree=null;
		Object FIXEDPTLIT138_tree=null;

		try {
			// Tiger.g:934:5: ( INTLIT | FIXEDPTLIT )
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
					// Tiger.g:934:7: INTLIT
					{
					root_0 = (Object)adaptor.nil();


					INTLIT137=(Token)match(input,INTLIT,FOLLOW_INTLIT_in_literal3256); 
					INTLIT137_tree = (Object)adaptor.create(INTLIT137);
					adaptor.addChild(root_0, INTLIT137_tree);

					retval.e = new Constant((INTLIT137!=null?INTLIT137.getText():null), Type.Int);
					}
					break;
				case 2 :
					// Tiger.g:935:7: FIXEDPTLIT
					{
					root_0 = (Object)adaptor.nil();


					FIXEDPTLIT138=(Token)match(input,FIXEDPTLIT,FOLLOW_FIXEDPTLIT_in_literal3266); 
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
		public int a;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "value_tail"
	// Tiger.g:938:1: value_tail returns [int a] : ( '[' index_expr ']' ( '[' index_expr ']' )? -> ( index_expr )+ |);
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
			// Tiger.g:939:5: ( '[' index_expr ']' ( '[' index_expr ']' )? -> ( index_expr )+ |)
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
					// Tiger.g:939:6: '[' index_expr ']' ( '[' index_expr ']' )?
					{
					retval.a = 0;
					char_literal139=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_value_tail3289);  
					stream_LBRACK.add(char_literal139);

					pushFollow(FOLLOW_index_expr_in_value_tail3291);
					index_expr140=index_expr();
					state._fsp--;

					stream_index_expr.add(index_expr140.getTree());
					char_literal141=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_value_tail3293);  
					stream_RBRACK.add(char_literal141);

					retval.a++;
					// Tiger.g:939:42: ( '[' index_expr ']' )?
					int alt38=2;
					int LA38_0 = input.LA(1);
					if ( (LA38_0==LBRACK) ) {
						alt38=1;
					}
					switch (alt38) {
						case 1 :
							// Tiger.g:939:43: '[' index_expr ']'
							{
							char_literal142=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_value_tail3297);  
							stream_LBRACK.add(char_literal142);

							pushFollow(FOLLOW_index_expr_in_value_tail3299);
							index_expr143=index_expr();
							state._fsp--;

							stream_index_expr.add(index_expr143.getTree());
							char_literal144=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_value_tail3301);  
							stream_RBRACK.add(char_literal144);

							retval.a++;
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
					// 940:13: -> ( index_expr )+
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
					// Tiger.g:941:7: 
					{
					root_0 = (Object)adaptor.nil();


					retval.a = 0;
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
		public Expr e;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "index_expr"
	// Tiger.g:945:1: index_expr returns [Expr e] :t1= index_term ( add_operator ^t2= index_term )* ;
	public final TigerParser.index_expr_return index_expr() throws RecognitionException {
		TigerParser.index_expr_return retval = new TigerParser.index_expr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope t1 =null;
		ParserRuleReturnScope t2 =null;
		ParserRuleReturnScope add_operator145 =null;


		try {
			// Tiger.g:946:5: (t1= index_term ( add_operator ^t2= index_term )* )
			// Tiger.g:946:7: t1= index_term ( add_operator ^t2= index_term )*
			{
			root_0 = (Object)adaptor.nil();


			int i = 0;
			pushFollow(FOLLOW_index_term_in_index_expr3358);
			t1=index_term();
			state._fsp--;

			adaptor.addChild(root_0, t1.getTree());

			// Tiger.g:946:34: ( add_operator ^t2= index_term )*
			loop40:
			while (true) {
				int alt40=2;
				int LA40_0 = input.LA(1);
				if ( (LA40_0==MINUS||LA40_0==PLUS) ) {
					alt40=1;
				}

				switch (alt40) {
				case 1 :
					// Tiger.g:946:35: add_operator ^t2= index_term
					{
					pushFollow(FOLLOW_add_operator_in_index_expr3361);
					add_operator145=add_operator();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(add_operator145.getTree(), root_0);
					pushFollow(FOLLOW_index_term_in_index_expr3366);
					t2=index_term();
					state._fsp--;

					adaptor.addChild(root_0, t2.getTree());


					     if(Arith.typeCheckPassed((t1!=null?((TigerParser.index_term_return)t1).e:null), (t2!=null?((TigerParser.index_term_return)t2).e:null))) {
								retval.e = Arith.getFinalType((t1!=null?((TigerParser.index_term_return)t1).e:null), (t2!=null?((TigerParser.index_term_return)t2).e:null));
							}
					           	i++;
					    
					}
					break;

				default :
					break loop40;
				}
			}


			        if(i == 0) {
			            retval.e = (t1!=null?((TigerParser.index_term_return)t1).e:null);
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
		public Expr e;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "index_term"
	// Tiger.g:960:1: index_term returns [Expr e] :t1= index_factor ( '*' ^t2= index_factor )* ;
	public final TigerParser.index_term_return index_term() throws RecognitionException {
		TigerParser.index_term_return retval = new TigerParser.index_term_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal146=null;
		ParserRuleReturnScope t1 =null;
		ParserRuleReturnScope t2 =null;

		Object char_literal146_tree=null;

		try {
			// Tiger.g:961:5: (t1= index_factor ( '*' ^t2= index_factor )* )
			// Tiger.g:961:7: t1= index_factor ( '*' ^t2= index_factor )*
			{
			root_0 = (Object)adaptor.nil();


			int i = 0;
			pushFollow(FOLLOW_index_factor_in_index_term3402);
			t1=index_factor();
			state._fsp--;

			adaptor.addChild(root_0, t1.getTree());

			// Tiger.g:961:36: ( '*' ^t2= index_factor )*
			loop41:
			while (true) {
				int alt41=2;
				int LA41_0 = input.LA(1);
				if ( (LA41_0==MULT) ) {
					alt41=1;
				}

				switch (alt41) {
				case 1 :
					// Tiger.g:961:37: '*' ^t2= index_factor
					{
					char_literal146=(Token)match(input,MULT,FOLLOW_MULT_in_index_term3405); 
					char_literal146_tree = (Object)adaptor.create(char_literal146);
					root_0 = (Object)adaptor.becomeRoot(char_literal146_tree, root_0);

					pushFollow(FOLLOW_index_factor_in_index_term3410);
					t2=index_factor();
					state._fsp--;

					adaptor.addChild(root_0, t2.getTree());


							if(Arith.typeCheckPassed((t1!=null?((TigerParser.index_factor_return)t1).e:null), (t2!=null?((TigerParser.index_factor_return)t2).e:null))) {
								retval.e = Arith.getFinalType((t1!=null?((TigerParser.index_factor_return)t1).e:null), (t2!=null?((TigerParser.index_factor_return)t2).e:null));
							}
					           	i++;
					    
					}
					break;

				default :
					break loop41;
				}
			}


			        if(i == 0) {
			            retval.e = (t1!=null?((TigerParser.index_factor_return)t1).e:null);
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
		public Expr e;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "index_factor"
	// Tiger.g:975:1: index_factor returns [Expr e] : ( INTLIT | ID );
	public final TigerParser.index_factor_return index_factor() throws RecognitionException {
		TigerParser.index_factor_return retval = new TigerParser.index_factor_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token INTLIT147=null;
		Token ID148=null;

		Object INTLIT147_tree=null;
		Object ID148_tree=null;

		try {
			// Tiger.g:976:5: ( INTLIT | ID )
			int alt42=2;
			int LA42_0 = input.LA(1);
			if ( (LA42_0==INTLIT) ) {
				alt42=1;
			}
			else if ( (LA42_0==ID) ) {
				alt42=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 42, 0, input);
				throw nvae;
			}

			switch (alt42) {
				case 1 :
					// Tiger.g:976:7: INTLIT
					{
					root_0 = (Object)adaptor.nil();


					INTLIT147=(Token)match(input,INTLIT,FOLLOW_INTLIT_in_index_factor3441); 
					INTLIT147_tree = (Object)adaptor.create(INTLIT147);
					adaptor.addChild(root_0, INTLIT147_tree);

					retval.e = new Constant((INTLIT147!=null?INTLIT147.getText():null), Type.Int);
					}
					break;
				case 2 :
					// Tiger.g:977:7: ID
					{
					root_0 = (Object)adaptor.nil();


					ID148=(Token)match(input,ID,FOLLOW_ID_in_index_factor3451); 
					ID148_tree = (Object)adaptor.create(ID148);
					adaptor.addChild(root_0, ID148_tree);

					 
							Var e = getValue((ID148!=null?ID148.getText():null));
					          // ID's type has to be int
					if(currFunc==null) {} else {
							if(e == null) {
								System.out.println("ERROR in \"" + currFunc.funcName + "\" " +(ID148!=null?ID148.getText():null) + " Not found in SymbolTable! Wrong index Type");
							retval.e = new Expr("Index Error!", Type.Int);
							// Return trash Expr object
					            } else if (!(e instanceof Id)) {
								System.out.println("ERROR in \"" + currFunc.funcName + "\" " +(ID148!=null?ID148.getText():null) + " Wrong index Type! Should be Int type");
							}else if (((Id)e).type == null || !("int").equals(((Id)e).type.name)) {
								System.out.println("ERROR in \"" + currFunc.funcName + "\" " +(ID148!=null?ID148.getText():null) + " Wrong index Type! Should be Int type");
							retval.e = (Id)e;
					            }
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
	// $ANTLR end "index_factor"

	// Delegated rules



	public static final BitSet FOLLOW_type_declaration_list_in_tiger_program1034 = new BitSet(new long[]{0x0000004202000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_funct_declaration_list_then_main_in_tiger_program1036 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_tiger_program1045 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VOID_in_funct_declaration_list_then_main1073 = new BitSet(new long[]{0x0001000020000000L});
	public static final BitSet FOLLOW_funct_declaration_tail_in_funct_declaration_list_then_main1077 = new BitSet(new long[]{0x0000004202000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_funct_declaration_list_then_main_in_funct_declaration_list_then_main1080 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_main_function_tail_in_funct_declaration_list_then_main1084 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_funct_declaration_list_then_main1097 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_INT_in_funct_declaration_list_then_main1101 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_FIXEDPT_in_funct_declaration_list_then_main1105 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_funct_declaration_tail_in_funct_declaration_list_then_main1108 = new BitSet(new long[]{0x0000004202000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_funct_declaration_list_then_main_in_funct_declaration_list_then_main1111 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FUNCTION_in_funct_declaration_tail1139 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_ID_in_funct_declaration_tail1141 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_LPAREN_in_funct_declaration_tail1143 = new BitSet(new long[]{0x1000000200000000L});
	public static final BitSet FOLLOW_param_list_in_funct_declaration_tail1145 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_funct_declaration_tail1147 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_BEGIN_in_funct_declaration_tail1162 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_block_list_in_funct_declaration_tail1164 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_END_in_funct_declaration_tail1166 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_SEMI_in_funct_declaration_tail1168 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MAIN_in_main_function_tail1206 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_LPAREN_in_main_function_tail1208 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_main_function_tail1210 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_BEGIN_in_main_function_tail1215 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_block_list_in_main_function_tail1217 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_END_in_main_function_tail1219 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_SEMI_in_main_function_tail1221 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_param_in_param_list1258 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_COMMA_in_param_list1266 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_param_in_param_list1270 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_ID_in_param1305 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_COLON_in_param1307 = new BitSet(new long[]{0x0000004202000000L});
	public static final BitSet FOLLOW_type_id_in_param1309 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_block_list1337 = new BitSet(new long[]{0x0000000000000082L});
	public static final BitSet FOLLOW_BEGIN_in_block1357 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000022L});
	public static final BitSet FOLLOW_declaration_segment_in_block1366 = new BitSet(new long[]{0x0800000A08000480L,0x0000000000000200L});
	public static final BitSet FOLLOW_stat_seq_in_block1368 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_END_in_block1370 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_SEMI_in_block1372 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_declaration_list_in_declaration_segment1403 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_var_declaration_list_in_declaration_segment1405 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_declaration_in_type_declaration_list1418 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
	public static final BitSet FOLLOW_var_declaration_in_var_declaration_list1451 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000020L});
	public static final BitSet FOLLOW_TYPE_in_type_declaration1481 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_ID_in_type_declaration1483 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_EQ_in_type_declaration1485 = new BitSet(new long[]{0x0000004002000020L});
	public static final BitSet FOLLOW_type_in_type_declaration1487 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_SEMI_in_type_declaration1489 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_base_type_in_type1521 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARRAY_in_type1533 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_LBRACK_in_type1535 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_INTLIT_in_type1539 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_RBRACK_in_type1541 = new BitSet(new long[]{0x0020080000000000L});
	public static final BitSet FOLLOW_LBRACK_in_type1544 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_INTLIT_in_type1548 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_RBRACK_in_type1550 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_OF_in_type1555 = new BitSet(new long[]{0x0000004002000000L});
	public static final BitSet FOLLOW_base_type_in_type1557 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_base_type_in_type_id1595 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_type_id1612 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_base_type1638 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FIXEDPT_in_base_type1649 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_var_declaration1674 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_id_list_in_var_declaration1676 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_COLON_in_var_declaration1678 = new BitSet(new long[]{0x0000004202000000L});
	public static final BitSet FOLLOW_type_id_in_var_declaration1680 = new BitSet(new long[]{0x2000000000000040L});
	public static final BitSet FOLLOW_optional_init_in_var_declaration1682 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_SEMI_in_var_declaration1684 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_id_list1726 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_COMMA_in_id_list1730 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_ID_in_id_list1734 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_ASSIGN_in_optional_init1775 = new BitSet(new long[]{0x0000008004000000L});
	public static final BitSet FOLLOW_literal_in_optional_init1777 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_stat_in_stat_seq1803 = new BitSet(new long[]{0x0800000A08000482L,0x0000000000000200L});
	public static final BitSet FOLLOW_function_call_or_assignment_in_stat1821 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_stat1829 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_expr_in_stat1831 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_THEN_in_stat1835 = new BitSet(new long[]{0x0800000A08000480L,0x0000000000000200L});
	public static final BitSet FOLLOW_stat_seq_in_stat1839 = new BitSet(new long[]{0x0000000000220000L});
	public static final BitSet FOLLOW_ELSE_in_stat1852 = new BitSet(new long[]{0x0800000A08000480L,0x0000000000000200L});
	public static final BitSet FOLLOW_stat_seq_in_stat1856 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_ENDIF_in_stat1858 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_ENDIF_in_stat1904 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat1943 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WHILE_in_stat1951 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_expr_in_stat1953 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_DO_in_stat1957 = new BitSet(new long[]{0x0800000A08000480L,0x0000000000000200L});
	public static final BitSet FOLLOW_stat_seq_in_stat1959 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ENDDO_in_stat1961 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat1963 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FOR_in_stat1990 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_ID_in_stat1992 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASSIGN_in_stat1994 = new BitSet(new long[]{0x0000008200000000L});
	public static final BitSet FOLLOW_index_expr_in_stat1996 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_TO_in_stat1998 = new BitSet(new long[]{0x0000008200000000L});
	public static final BitSet FOLLOW_index_expr_in_stat2000 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_DO_in_stat2002 = new BitSet(new long[]{0x0800000A08000480L,0x0000000000000200L});
	public static final BitSet FOLLOW_stat_seq_in_stat2004 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ENDDO_in_stat2006 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat2008 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BREAK_in_stat2038 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat2040 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RETURN_in_stat2049 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_expr_in_stat2051 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat2053 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_stat2080 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_function_args2103 = new BitSet(new long[]{0x1000808204000000L});
	public static final BitSet FOLLOW_expr_list_in_function_args2105 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_function_args2107 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_function_call_or_assignment2140 = new BitSet(new long[]{0x0000880000000040L});
	public static final BitSet FOLLOW_function_args_in_function_call_or_assignment2152 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_value_tail_in_function_call_or_assignment2201 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASSIGN_in_function_call_or_assignment2203 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_expr_or_function_call_in_function_call_or_assignment2205 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_SEMI_in_function_call_or_assignment2257 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_expr_or_function_call2279 = new BitSet(new long[]{0x0000880000000000L});
	public static final BitSet FOLLOW_expr_with_start_id_in_expr_or_function_call2291 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_args_in_expr_or_function_call2333 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_no_start_id_in_expr_or_function_call2382 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term4_in_expr2417 = new BitSet(new long[]{0x0040000000000012L});
	public static final BitSet FOLLOW_and_operator_in_expr2420 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_term4_in_expr2425 = new BitSet(new long[]{0x0040000000000012L});
	public static final BitSet FOLLOW_term3_in_term42468 = new BitSet(new long[]{0x0010300180400002L});
	public static final BitSet FOLLOW_compare_operator_in_term42471 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_term3_in_term42476 = new BitSet(new long[]{0x0010300180400002L});
	public static final BitSet FOLLOW_term2_in_term32521 = new BitSet(new long[]{0x0104000000000002L});
	public static final BitSet FOLLOW_add_operator_in_term32524 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_term2_in_term32529 = new BitSet(new long[]{0x0104000000000002L});
	public static final BitSet FOLLOW_term1_in_term22557 = new BitSet(new long[]{0x0008000000008002L});
	public static final BitSet FOLLOW_mult_operator_in_term22560 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_term1_in_term22565 = new BitSet(new long[]{0x0008000000008002L});
	public static final BitSet FOLLOW_literal_in_term12588 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_in_term12598 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_term12608 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_expr_in_term12610 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_term12612 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term4_no_start_id_in_expr_no_start_id2649 = new BitSet(new long[]{0x0040000000000012L});
	public static final BitSet FOLLOW_and_operator_in_expr_no_start_id2652 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_term4_in_expr_no_start_id2657 = new BitSet(new long[]{0x0040000000000012L});
	public static final BitSet FOLLOW_term3_no_start_id_in_term4_no_start_id2700 = new BitSet(new long[]{0x0010300180400002L});
	public static final BitSet FOLLOW_compare_operator_in_term4_no_start_id2703 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_term3_in_term4_no_start_id2708 = new BitSet(new long[]{0x0010300180400002L});
	public static final BitSet FOLLOW_term2_no_start_id_in_term3_no_start_id2751 = new BitSet(new long[]{0x0104000000000002L});
	public static final BitSet FOLLOW_add_operator_in_term3_no_start_id2754 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_term2_in_term3_no_start_id2759 = new BitSet(new long[]{0x0104000000000002L});
	public static final BitSet FOLLOW_term1_no_start_id_in_term2_no_start_id2786 = new BitSet(new long[]{0x0008000000008002L});
	public static final BitSet FOLLOW_mult_operator_in_term2_no_start_id2789 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_term1_in_term2_no_start_id2794 = new BitSet(new long[]{0x0008000000008002L});
	public static final BitSet FOLLOW_literal_in_term1_no_start_id2818 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_term1_no_start_id2828 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_expr_in_term1_no_start_id2830 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_term1_no_start_id2832 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term4_with_start_id_in_expr_with_start_id2873 = new BitSet(new long[]{0x0040000000000012L});
	public static final BitSet FOLLOW_and_operator_in_expr_with_start_id2877 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_term4_in_expr_with_start_id2882 = new BitSet(new long[]{0x0040000000000012L});
	public static final BitSet FOLLOW_term3_with_start_id_in_term4_with_start_id2917 = new BitSet(new long[]{0x0010300180400002L});
	public static final BitSet FOLLOW_compare_operator_in_term4_with_start_id2921 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_term3_in_term4_with_start_id2926 = new BitSet(new long[]{0x0010300180400002L});
	public static final BitSet FOLLOW_term2_with_start_id_in_term3_with_start_id2972 = new BitSet(new long[]{0x0104000000000002L});
	public static final BitSet FOLLOW_add_operator_in_term3_with_start_id2976 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_term2_in_term3_with_start_id2981 = new BitSet(new long[]{0x0104000000000002L});
	public static final BitSet FOLLOW_term1_with_start_id_in_term2_with_start_id3012 = new BitSet(new long[]{0x0008000000008002L});
	public static final BitSet FOLLOW_mult_operator_in_term2_with_start_id3016 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_term1_in_term2_with_start_id3021 = new BitSet(new long[]{0x0008000000008002L});
	public static final BitSet FOLLOW_value_tail_in_term1_with_start_id3047 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_expr_list3085 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_COMMA_in_expr_list3093 = new BitSet(new long[]{0x0000808204000000L});
	public static final BitSet FOLLOW_expr_in_expr_list3097 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_ID_in_value3224 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_value_tail_in_value3226 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTLIT_in_literal3256 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FIXEDPTLIT_in_literal3266 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LBRACK_in_value_tail3289 = new BitSet(new long[]{0x0000008200000000L});
	public static final BitSet FOLLOW_index_expr_in_value_tail3291 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_RBRACK_in_value_tail3293 = new BitSet(new long[]{0x0000080000000002L});
	public static final BitSet FOLLOW_LBRACK_in_value_tail3297 = new BitSet(new long[]{0x0000008200000000L});
	public static final BitSet FOLLOW_index_expr_in_value_tail3299 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_RBRACK_in_value_tail3301 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_index_term_in_index_expr3358 = new BitSet(new long[]{0x0104000000000002L});
	public static final BitSet FOLLOW_add_operator_in_index_expr3361 = new BitSet(new long[]{0x0000008200000000L});
	public static final BitSet FOLLOW_index_term_in_index_expr3366 = new BitSet(new long[]{0x0104000000000002L});
	public static final BitSet FOLLOW_index_factor_in_index_term3402 = new BitSet(new long[]{0x0008000000000002L});
	public static final BitSet FOLLOW_MULT_in_index_term3405 = new BitSet(new long[]{0x0000008200000000L});
	public static final BitSet FOLLOW_index_factor_in_index_term3410 = new BitSet(new long[]{0x0008000000000002L});
	public static final BitSet FOLLOW_INTLIT_in_index_factor3441 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_index_factor3451 = new BitSet(new long[]{0x0000000000000002L});
}
