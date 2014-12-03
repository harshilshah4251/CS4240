// $ANTLR 3.5.2 cs4240_team1/SymTableWalker.g 2014-12-03 04:23:38

    package cs4240_team1;

    import java.util.ArrayList;
    import java.util.List;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class SymTableWalker extends TreeParser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND", "ARRAY", "ASSIGN", "BEGIN", 
		"BLOCKLIST", "BLOCKSCOPE", "BREAK", "COLON", "COMMA", "COMMENT", "DIGIT", 
		"DIV", "DO", "ELSE", "ELSE_STATS", "END", "ENDDO", "ENDIF", "EQ", "EXPRLIST", 
		"FIXEDPT", "FIXEDPTLIT", "FOR", "FUNCDECL", "FUNCTION", "FUNCTION_CALL", 
		"GREATER", "GREATEREQ", "ID", "IDLIST", "IF", "IF_THEN", "IF_THEN_ELSE", 
		"INT", "INTLIT", "INVALID_CHAR", "INVALID_FIXEDPTLIT", "INVALID_INTLIT", 
		"LBRACK", "LESSER", "LESSEREQ", "LOWER", "LPAREN", "MAIN", "MAINSCOPE", 
		"MINUS", "MULT", "NEQ", "OF", "OR", "PARAMLIST", "PLUS", "PROGRAM", "RBRACK", 
		"RETURN", "RPAREN", "SEMI", "THEN", "THEN_STATS", "TO", "TYPE", "TYPEDECL", 
		"TYPEDECLLIST", "UPPER", "VAR", "VARDECL", "VARDECLLIST", "VOID", "WHILE", 
		"WHITESPACE"
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
	public static final int FIXEDPT=24;
	public static final int FIXEDPTLIT=25;
	public static final int FOR=26;
	public static final int FUNCDECL=27;
	public static final int FUNCTION=28;
	public static final int FUNCTION_CALL=29;
	public static final int GREATER=30;
	public static final int GREATEREQ=31;
	public static final int ID=32;
	public static final int IDLIST=33;
	public static final int IF=34;
	public static final int IF_THEN=35;
	public static final int IF_THEN_ELSE=36;
	public static final int INT=37;
	public static final int INTLIT=38;
	public static final int INVALID_CHAR=39;
	public static final int INVALID_FIXEDPTLIT=40;
	public static final int INVALID_INTLIT=41;
	public static final int LBRACK=42;
	public static final int LESSER=43;
	public static final int LESSEREQ=44;
	public static final int LOWER=45;
	public static final int LPAREN=46;
	public static final int MAIN=47;
	public static final int MAINSCOPE=48;
	public static final int MINUS=49;
	public static final int MULT=50;
	public static final int NEQ=51;
	public static final int OF=52;
	public static final int OR=53;
	public static final int PARAMLIST=54;
	public static final int PLUS=55;
	public static final int PROGRAM=56;
	public static final int RBRACK=57;
	public static final int RETURN=58;
	public static final int RPAREN=59;
	public static final int SEMI=60;
	public static final int THEN=61;
	public static final int THEN_STATS=62;
	public static final int TO=63;
	public static final int TYPE=64;
	public static final int TYPEDECL=65;
	public static final int TYPEDECLLIST=66;
	public static final int UPPER=67;
	public static final int VAR=68;
	public static final int VARDECL=69;
	public static final int VARDECLLIST=70;
	public static final int VOID=71;
	public static final int WHILE=72;
	public static final int WHITESPACE=73;

	// delegates
	public TreeParser[] getDelegates() {
		return new TreeParser[] {};
	}

	// delegators


	public SymTableWalker(TreeNodeStream input) {
		this(input, new RecognizerSharedState());
	}
	public SymTableWalker(TreeNodeStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return SymTableWalker.tokenNames; }
	@Override public String getGrammarFileName() { return "cs4240_team1/SymTableWalker.g"; }


	    SymbolTable globalSymbolTable = new SymbolTable(true);
	    List<SemanticError> errors = new ArrayList<SemanticError>();



	// $ANTLR start "walk"
	// cs4240_team1/SymTableWalker.g:20:1: walk : tiger_program EOF ;
	public final void walk() throws RecognitionException {
		try {
			// cs4240_team1/SymTableWalker.g:21:5: ( tiger_program EOF )
			// cs4240_team1/SymTableWalker.g:21:7: tiger_program EOF
			{
			pushFollow(FOLLOW_tiger_program_in_walk58);
			tiger_program();
			state._fsp--;

			match(input,EOF,FOLLOW_EOF_in_walk60); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "walk"



	// $ANTLR start "tiger_program"
	// cs4240_team1/SymTableWalker.g:24:1: tiger_program : ^( PROGRAM type_declaration_list[globalSymbolTable] ( funct_declaration[globalSymbolTable] )* main_function[globalSymbolTable] ) ;
	public final void tiger_program() throws RecognitionException {
		try {
			// cs4240_team1/SymTableWalker.g:25:5: ( ^( PROGRAM type_declaration_list[globalSymbolTable] ( funct_declaration[globalSymbolTable] )* main_function[globalSymbolTable] ) )
			// cs4240_team1/SymTableWalker.g:25:7: ^( PROGRAM type_declaration_list[globalSymbolTable] ( funct_declaration[globalSymbolTable] )* main_function[globalSymbolTable] )
			{
			match(input,PROGRAM,FOLLOW_PROGRAM_in_tiger_program78); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_type_declaration_list_in_tiger_program80);
			type_declaration_list(globalSymbolTable);
			state._fsp--;

			// cs4240_team1/SymTableWalker.g:25:58: ( funct_declaration[globalSymbolTable] )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==FUNCTION) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// cs4240_team1/SymTableWalker.g:25:58: funct_declaration[globalSymbolTable]
					{
					pushFollow(FOLLOW_funct_declaration_in_tiger_program83);
					funct_declaration(globalSymbolTable);
					state._fsp--;

					}
					break;

				default :
					break loop1;
				}
			}

			pushFollow(FOLLOW_main_function_in_tiger_program87);
			main_function(globalSymbolTable);
			state._fsp--;

			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "tiger_program"



	// $ANTLR start "funct_declaration"
	// cs4240_team1/SymTableWalker.g:28:1: funct_declaration[SymbolTable symTable] : ^( FUNCTION ret_type ID param_list[nSymTable, parameters] block_list[nSymTable] ) ;
	public final void funct_declaration(SymbolTable symTable) throws RecognitionException {
		CommonTree ID1=null;
		String ret_type2 =null;
		boolean block_list3 =false;


			SymbolTable nSymTable = new SymbolTable(symTable);
		    List<Parameter> parameters = new ArrayList<>();

		try {
			// cs4240_team1/SymTableWalker.g:33:5: ( ^( FUNCTION ret_type ID param_list[nSymTable, parameters] block_list[nSymTable] ) )
			// cs4240_team1/SymTableWalker.g:33:7: ^( FUNCTION ret_type ID param_list[nSymTable, parameters] block_list[nSymTable] )
			{
			match(input,FUNCTION,FOLLOW_FUNCTION_in_funct_declaration113); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_ret_type_in_funct_declaration115);
			ret_type2=ret_type();
			state._fsp--;

			ID1=(CommonTree)match(input,ID,FOLLOW_ID_in_funct_declaration117); 
			pushFollow(FOLLOW_param_list_in_funct_declaration119);
			param_list(nSymTable, parameters);
			state._fsp--;


						/* the function should be declared before any types/vars inside are declared. */
						FunctionEntry pToInsert = new FunctionEntry((ID1!=null?ID1.getText():null), ret_type2, parameters);
						if (SemanticChecks.check_func_declaration_valid(ID1.getToken(),pToInsert,symTable,errors)) {
							symTable.insertFunction(pToInsert);

							nSymTable.setFunctionReturnType(pToInsert.getReturnType());
							for (Parameter p: parameters) {
								nSymTable.insertVar(p);
							}
						}
					
			pushFollow(FOLLOW_block_list_in_funct_declaration125);
			block_list3=block_list(nSymTable);
			state._fsp--;

			match(input, Token.UP, null); 


						TigerType returnType = pToInsert.getReturnType();
						if (!block_list3 && returnType != null && !returnType.isVoid()) {
							String errorMsg = String.format(
									"body of non-void function '%s' not guaranteed to execute a 'return' statement",
									ID1.getText());
							errors.add(new SemanticError(ID1.getToken(), errorMsg));
						}
					
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "funct_declaration"



	// $ANTLR start "ret_type"
	// cs4240_team1/SymTableWalker.g:55:1: ret_type returns [String text] : ( VOID | ID | INT | FIXEDPT );
	public final String ret_type() throws RecognitionException {
		String text = null;


		CommonTree VOID4=null;
		CommonTree ID5=null;
		CommonTree INT6=null;
		CommonTree FIXEDPT7=null;

		try {
			// cs4240_team1/SymTableWalker.g:56:5: ( VOID | ID | INT | FIXEDPT )
			int alt2=4;
			switch ( input.LA(1) ) {
			case VOID:
				{
				alt2=1;
				}
				break;
			case ID:
				{
				alt2=2;
				}
				break;
			case INT:
				{
				alt2=3;
				}
				break;
			case FIXEDPT:
				{
				alt2=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}
			switch (alt2) {
				case 1 :
					// cs4240_team1/SymTableWalker.g:56:7: VOID
					{
					VOID4=(CommonTree)match(input,VOID,FOLLOW_VOID_in_ret_type150); 
					text = (VOID4!=null?VOID4.getText():null);
					}
					break;
				case 2 :
					// cs4240_team1/SymTableWalker.g:57:7: ID
					{
					ID5=(CommonTree)match(input,ID,FOLLOW_ID_in_ret_type160); 
					text = (ID5!=null?ID5.getText():null);
					}
					break;
				case 3 :
					// cs4240_team1/SymTableWalker.g:58:7: INT
					{
					INT6=(CommonTree)match(input,INT,FOLLOW_INT_in_ret_type170); 
					text = (INT6!=null?INT6.getText():null);
					}
					break;
				case 4 :
					// cs4240_team1/SymTableWalker.g:59:7: FIXEDPT
					{
					FIXEDPT7=(CommonTree)match(input,FIXEDPT,FOLLOW_FIXEDPT_in_ret_type180); 
					text = (FIXEDPT7!=null?FIXEDPT7.getText():null);
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return text;
	}
	// $ANTLR end "ret_type"



	// $ANTLR start "main_function"
	// cs4240_team1/SymTableWalker.g:62:1: main_function[SymbolTable symTable] : ^( MAINSCOPE block_list[nSymTable] ) ;
	public final void main_function(SymbolTable symTable) throws RecognitionException {

			SymbolTable nSymTable = new SymbolTable(symTable);
			nSymTable.setFunctionReturnType(TigerType.VOID_TYPE);

		try {
			// cs4240_team1/SymTableWalker.g:67:5: ( ^( MAINSCOPE block_list[nSymTable] ) )
			// cs4240_team1/SymTableWalker.g:67:7: ^( MAINSCOPE block_list[nSymTable] )
			{
			match(input,MAINSCOPE,FOLLOW_MAINSCOPE_in_main_function208); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_block_list_in_main_function210);
			block_list(nSymTable);
			state._fsp--;

			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "main_function"



	// $ANTLR start "param_list"
	// cs4240_team1/SymTableWalker.g:71:1: param_list[SymbolTable symTable, List<Parameter> parameters] : ^( PARAMLIST ( param[symTable, parameters] )* ) ;
	public final void param_list(SymbolTable symTable, List<Parameter> parameters) throws RecognitionException {
		try {
			// cs4240_team1/SymTableWalker.g:72:5: ( ^( PARAMLIST ( param[symTable, parameters] )* ) )
			// cs4240_team1/SymTableWalker.g:72:7: ^( PARAMLIST ( param[symTable, parameters] )* )
			{
			match(input,PARAMLIST,FOLLOW_PARAMLIST_in_param_list233); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// cs4240_team1/SymTableWalker.g:72:19: ( param[symTable, parameters] )*
				loop3:
				while (true) {
					int alt3=2;
					int LA3_0 = input.LA(1);
					if ( (LA3_0==ID) ) {
						alt3=1;
					}

					switch (alt3) {
					case 1 :
						// cs4240_team1/SymTableWalker.g:72:19: param[symTable, parameters]
						{
						pushFollow(FOLLOW_param_in_param_list235);
						param(symTable, parameters);
						state._fsp--;

						}
						break;

					default :
						break loop3;
					}
				}

				match(input, Token.UP, null); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "param_list"



	// $ANTLR start "param"
	// cs4240_team1/SymTableWalker.g:75:1: param[SymbolTable symTable, List<Parameter> parameters] : ^( ID type_id ) ;
	public final void param(SymbolTable symTable, List<Parameter> parameters) throws RecognitionException {
		CommonTree ID8=null;
		String type_id9 =null;

		try {
			// cs4240_team1/SymTableWalker.g:76:5: ( ^( ID type_id ) )
			// cs4240_team1/SymTableWalker.g:76:9: ^( ID type_id )
			{
			ID8=(CommonTree)match(input,ID,FOLLOW_ID_in_param259); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_type_id_in_param261);
			type_id9=type_id();
			state._fsp--;

			match(input, Token.UP, null); 


			            parameters.add( new Parameter((ID8!=null?ID8.getText():null), type_id9) );
			        
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "param"



	// $ANTLR start "block_list"
	// cs4240_team1/SymTableWalker.g:85:1: block_list[SymbolTable symTable] returns [boolean guaranteedReturn] : ^( BLOCKLIST ( block[symTable,false] )+ ) ;
	public final boolean block_list(SymbolTable symTable) throws RecognitionException {
		boolean guaranteedReturn = false;


		boolean block10 =false;

		try {
			// cs4240_team1/SymTableWalker.g:87:5: ( ^( BLOCKLIST ( block[symTable,false] )+ ) )
			// cs4240_team1/SymTableWalker.g:87:7: ^( BLOCKLIST ( block[symTable,false] )+ )
			{
			match(input,BLOCKLIST,FOLLOW_BLOCKLIST_in_block_list292); 
			match(input, Token.DOWN, null); 
			// cs4240_team1/SymTableWalker.g:87:19: ( block[symTable,false] )+
			int cnt4=0;
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==BLOCKSCOPE) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// cs4240_team1/SymTableWalker.g:87:20: block[symTable,false]
					{
					pushFollow(FOLLOW_block_in_block_list295);
					block10=block(symTable, false);
					state._fsp--;


								/* we just need one block to have guaranteed return (NOTE: everything below is dead code) */
								if (block10) {
									guaranteedReturn = true;
								}
							
					}
					break;

				default :
					if ( cnt4 >= 1 ) break loop4;
					EarlyExitException eee = new EarlyExitException(4, input);
					throw eee;
				}
				cnt4++;
			}

			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return guaranteedReturn;
	}
	// $ANTLR end "block_list"



	// $ANTLR start "block"
	// cs4240_team1/SymTableWalker.g:95:1: block[SymbolTable symTable, boolean isInLoop] returns [boolean guaranteedReturn] : ^( BLOCKSCOPE type_declaration_list[nSymTable] var_declaration_list[nSymTable] stat_seq[nSymTable,isInLoop] ) ;
	public final boolean block(SymbolTable symTable, boolean isInLoop) throws RecognitionException {
		boolean guaranteedReturn = false;


		boolean stat_seq11 =false;


			SymbolTable nSymTable = new SymbolTable(symTable);

		try {
			// cs4240_team1/SymTableWalker.g:99:5: ( ^( BLOCKSCOPE type_declaration_list[nSymTable] var_declaration_list[nSymTable] stat_seq[nSymTable,isInLoop] ) )
			// cs4240_team1/SymTableWalker.g:99:7: ^( BLOCKSCOPE type_declaration_list[nSymTable] var_declaration_list[nSymTable] stat_seq[nSymTable,isInLoop] )
			{
			match(input,BLOCKSCOPE,FOLLOW_BLOCKSCOPE_in_block330); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_type_declaration_list_in_block332);
			type_declaration_list(nSymTable);
			state._fsp--;

			pushFollow(FOLLOW_var_declaration_list_in_block335);
			var_declaration_list(nSymTable);
			state._fsp--;

			pushFollow(FOLLOW_stat_seq_in_block338);
			stat_seq11=stat_seq(nSymTable, isInLoop);
			state._fsp--;

			match(input, Token.UP, null); 


						guaranteedReturn = stat_seq11;
					
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return guaranteedReturn;
	}
	// $ANTLR end "block"



	// $ANTLR start "type_declaration_list"
	// cs4240_team1/SymTableWalker.g:104:1: type_declaration_list[SymbolTable symTable] : ^( TYPEDECLLIST ( type_declaration[symTable] )* ) ;
	public final void type_declaration_list(SymbolTable symTable) throws RecognitionException {
		try {
			// cs4240_team1/SymTableWalker.g:105:5: ( ^( TYPEDECLLIST ( type_declaration[symTable] )* ) )
			// cs4240_team1/SymTableWalker.g:105:7: ^( TYPEDECLLIST ( type_declaration[symTable] )* )
			{
			match(input,TYPEDECLLIST,FOLLOW_TYPEDECLLIST_in_type_declaration_list361); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// cs4240_team1/SymTableWalker.g:105:22: ( type_declaration[symTable] )*
				loop5:
				while (true) {
					int alt5=2;
					int LA5_0 = input.LA(1);
					if ( (LA5_0==TYPEDECL) ) {
						alt5=1;
					}

					switch (alt5) {
					case 1 :
						// cs4240_team1/SymTableWalker.g:105:22: type_declaration[symTable]
						{
						pushFollow(FOLLOW_type_declaration_in_type_declaration_list363);
						type_declaration(symTable);
						state._fsp--;

						}
						break;

					default :
						break loop5;
					}
				}

				match(input, Token.UP, null); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "type_declaration_list"



	// $ANTLR start "var_declaration_list"
	// cs4240_team1/SymTableWalker.g:108:1: var_declaration_list[SymbolTable symTable] : ^( VARDECLLIST ( var_declaration[symTable] )* ) ;
	public final void var_declaration_list(SymbolTable symTable) throws RecognitionException {
		try {
			// cs4240_team1/SymTableWalker.g:109:5: ( ^( VARDECLLIST ( var_declaration[symTable] )* ) )
			// cs4240_team1/SymTableWalker.g:109:7: ^( VARDECLLIST ( var_declaration[symTable] )* )
			{
			match(input,VARDECLLIST,FOLLOW_VARDECLLIST_in_var_declaration_list385); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// cs4240_team1/SymTableWalker.g:109:21: ( var_declaration[symTable] )*
				loop6:
				while (true) {
					int alt6=2;
					int LA6_0 = input.LA(1);
					if ( (LA6_0==VAR) ) {
						alt6=1;
					}

					switch (alt6) {
					case 1 :
						// cs4240_team1/SymTableWalker.g:109:21: var_declaration[symTable]
						{
						pushFollow(FOLLOW_var_declaration_in_var_declaration_list387);
						var_declaration(symTable);
						state._fsp--;

						}
						break;

					default :
						break loop6;
					}
				}

				match(input, Token.UP, null); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "var_declaration_list"



	// $ANTLR start "type_declaration"
	// cs4240_team1/SymTableWalker.g:112:1: type_declaration[SymbolTable symTable] : ^( TYPEDECL ID type ) ;
	public final void type_declaration(SymbolTable symTable) throws RecognitionException {
		CommonTree ID12=null;
		TreeRuleReturnScope type13 =null;

		try {
			// cs4240_team1/SymTableWalker.g:113:5: ( ^( TYPEDECL ID type ) )
			// cs4240_team1/SymTableWalker.g:113:7: ^( TYPEDECL ID type )
			{
			match(input,TYPEDECL,FOLLOW_TYPEDECL_in_type_declaration409); 
			match(input, Token.DOWN, null); 
			ID12=(CommonTree)match(input,ID,FOLLOW_ID_in_type_declaration411); 
			pushFollow(FOLLOW_type_in_type_declaration413);
			type13=type();
			state._fsp--;

			match(input, Token.UP, null); 


						TypeEntry pToInsert = new TypeEntry((ID12!=null?ID12.getText():null), (type13!=null?((SymTableWalker.type_return)type13).baseTypeId:null), (type13!=null?((SymTableWalker.type_return)type13).dimension1:null), (type13!=null?((SymTableWalker.type_return)type13).dimension2:null));
						if (SemanticChecks.check_type_declaration_valid(ID12.getToken(), pToInsert, symTable, errors)) {
							symTable.insertType(pToInsert);
						}
					
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "type_declaration"


	public static class type_return extends TreeRuleReturnScope {
		public String baseTypeId;
		public String dimension1;
		public String dimension2;
	};


	// $ANTLR start "type"
	// cs4240_team1/SymTableWalker.g:122:1: type returns [String baseTypeId, String dimension1, String dimension2] : ( base_type | ^( ARRAY base_type dim1= INTLIT (dim2= INTLIT )? ) );
	public final SymTableWalker.type_return type() throws RecognitionException {
		SymTableWalker.type_return retval = new SymTableWalker.type_return();
		retval.start = input.LT(1);

		CommonTree dim1=null;
		CommonTree dim2=null;
		String base_type14 =null;
		String base_type15 =null;

		try {
			// cs4240_team1/SymTableWalker.g:123:5: ( base_type | ^( ARRAY base_type dim1= INTLIT (dim2= INTLIT )? ) )
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==FIXEDPT||LA8_0==INT) ) {
				alt8=1;
			}
			else if ( (LA8_0==ARRAY) ) {
				alt8=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}

			switch (alt8) {
				case 1 :
					// cs4240_team1/SymTableWalker.g:123:9: base_type
					{
					pushFollow(FOLLOW_base_type_in_type442);
					base_type14=base_type();
					state._fsp--;

					retval.baseTypeId = base_type14;
					}
					break;
				case 2 :
					// cs4240_team1/SymTableWalker.g:124:9: ^( ARRAY base_type dim1= INTLIT (dim2= INTLIT )? )
					{
					match(input,ARRAY,FOLLOW_ARRAY_in_type455); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_base_type_in_type457);
					base_type15=base_type();
					state._fsp--;

					dim1=(CommonTree)match(input,INTLIT,FOLLOW_INTLIT_in_type461); 
					// cs4240_team1/SymTableWalker.g:124:43: (dim2= INTLIT )?
					int alt7=2;
					int LA7_0 = input.LA(1);
					if ( (LA7_0==INTLIT) ) {
						alt7=1;
					}
					switch (alt7) {
						case 1 :
							// cs4240_team1/SymTableWalker.g:124:43: dim2= INTLIT
							{
							dim2=(CommonTree)match(input,INTLIT,FOLLOW_INTLIT_in_type465); 
							}
							break;

					}

					match(input, Token.UP, null); 


					            retval.baseTypeId = base_type15;
					            retval.dimension1 = (dim1!=null?dim1.getText():null);
					            retval.dimension2 = (dim2 == null) ? null : (dim2!=null?dim2.getText():null);
					        
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "type"



	// $ANTLR start "base_type"
	// cs4240_team1/SymTableWalker.g:131:1: base_type returns [String text] : ( INT | FIXEDPT );
	public final String base_type() throws RecognitionException {
		String text = null;


		CommonTree INT16=null;
		CommonTree FIXEDPT17=null;

		try {
			// cs4240_team1/SymTableWalker.g:132:5: ( INT | FIXEDPT )
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==INT) ) {
				alt9=1;
			}
			else if ( (LA9_0==FIXEDPT) ) {
				alt9=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}

			switch (alt9) {
				case 1 :
					// cs4240_team1/SymTableWalker.g:132:7: INT
					{
					INT16=(CommonTree)match(input,INT,FOLLOW_INT_in_base_type490); 
					text = (INT16!=null?INT16.getText():null);
					}
					break;
				case 2 :
					// cs4240_team1/SymTableWalker.g:133:7: FIXEDPT
					{
					FIXEDPT17=(CommonTree)match(input,FIXEDPT,FOLLOW_FIXEDPT_in_base_type500); 
					text = (FIXEDPT17!=null?FIXEDPT17.getText():null);
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return text;
	}
	// $ANTLR end "base_type"



	// $ANTLR start "var_declaration"
	// cs4240_team1/SymTableWalker.g:137:1: var_declaration[SymbolTable symTable] : ^( VAR type_id ( optional_init )? id_list[$symTable, $type_id.text, hasOptInit, optInitType] ) ;
	public final void var_declaration(SymbolTable symTable) throws RecognitionException {
		TigerType optional_init18 =null;
		String type_id19 =null;


		    TigerType optInitType = null;
		    boolean hasOptInit = false;

		try {
			// cs4240_team1/SymTableWalker.g:142:5: ( ^( VAR type_id ( optional_init )? id_list[$symTable, $type_id.text, hasOptInit, optInitType] ) )
			// cs4240_team1/SymTableWalker.g:142:9: ^( VAR type_id ( optional_init )? id_list[$symTable, $type_id.text, hasOptInit, optInitType] )
			{
			match(input,VAR,FOLLOW_VAR_in_var_declaration530); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_type_id_in_var_declaration532);
			type_id19=type_id();
			state._fsp--;

			// cs4240_team1/SymTableWalker.g:142:23: ( optional_init )?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==ASSIGN) ) {
				alt10=1;
			}
			switch (alt10) {
				case 1 :
					// cs4240_team1/SymTableWalker.g:142:24: optional_init
					{
					pushFollow(FOLLOW_optional_init_in_var_declaration535);
					optional_init18=optional_init();
					state._fsp--;


					                hasOptInit = true;
					                optInitType = optional_init18;
					            
					}
					break;

			}

			pushFollow(FOLLOW_id_list_in_var_declaration541);
			id_list(symTable, type_id19, hasOptInit, optInitType);
			state._fsp--;

			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "var_declaration"



	// $ANTLR start "type_id"
	// cs4240_team1/SymTableWalker.g:148:1: type_id returns [String text] : ( base_type | ID );
	public final String type_id() throws RecognitionException {
		String text = null;


		CommonTree ID21=null;
		String base_type20 =null;

		try {
			// cs4240_team1/SymTableWalker.g:149:5: ( base_type | ID )
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
					// cs4240_team1/SymTableWalker.g:149:7: base_type
					{
					pushFollow(FOLLOW_base_type_in_type_id564);
					base_type20=base_type();
					state._fsp--;

					text = base_type20;
					}
					break;
				case 2 :
					// cs4240_team1/SymTableWalker.g:150:7: ID
					{
					ID21=(CommonTree)match(input,ID,FOLLOW_ID_in_type_id574); 
					text = (ID21!=null?ID21.getText():null);
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return text;
	}
	// $ANTLR end "type_id"



	// $ANTLR start "id_list"
	// cs4240_team1/SymTableWalker.g:153:1: id_list[SymbolTable symTable, String typeId, boolean hasOptInit, TigerType optInitType] : ^( IDLIST ( ID )+ ) ;
	public final void id_list(SymbolTable symTable, String typeId, boolean hasOptInit, TigerType optInitType) throws RecognitionException {
		CommonTree ID22=null;

		try {
			// cs4240_team1/SymTableWalker.g:154:5: ( ^( IDLIST ( ID )+ ) )
			// cs4240_team1/SymTableWalker.g:154:7: ^( IDLIST ( ID )+ )
			{
			match(input,IDLIST,FOLLOW_IDLIST_in_id_list595); 
			match(input, Token.DOWN, null); 
			// cs4240_team1/SymTableWalker.g:154:16: ( ID )+
			int cnt12=0;
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( (LA12_0==ID) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// cs4240_team1/SymTableWalker.g:154:17: ID
					{
					ID22=(CommonTree)match(input,ID,FOLLOW_ID_in_id_list598); 

								VarEntry pToInsert = new VarEntry((ID22!=null?ID22.getText():null), typeId);
								if (SemanticChecks.check_var_declaration_valid(ID22.getToken(), pToInsert, symTable, errors)) {
									symTable.insertVar(pToInsert);

									TigerType varType = pToInsert.getType();
									if (hasOptInit) {
										if (!varType.isInitializableFrom(optInitType)) {
											errors.add(new SemanticError(
												ID22.getToken(),
												String.format("cannot initialize variable of%s type '%s'%s using type '%s'",
													varType.isArray() ? " array" : "",
													varType,
													varType.isArray() ? (varType.typeClass == TypeClass.ARRAY_INT ? " of int" : " of fixedpt") : "",
													optInitType)));
										}
									} else {
										/* we are required to initialize arrays!  so if we don't... */
										if (varType.isArray()) {
											errors.add(new SemanticError(
												ID22.getToken(),
												"missing required initialization for array '" + (ID22!=null?ID22.getText():null) + "'"));
										}
									}
								}

					        
					}
					break;

				default :
					if ( cnt12 >= 1 ) break loop12;
					EarlyExitException eee = new EarlyExitException(12, input);
					throw eee;
				}
				cnt12++;
			}

			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "id_list"



	// $ANTLR start "optional_init"
	// cs4240_team1/SymTableWalker.g:183:1: optional_init returns [TigerType type] : ^( ':=' literal ) ;
	public final TigerType optional_init() throws RecognitionException {
		TigerType type = null;


		TreeRuleReturnScope literal23 =null;

		try {
			// cs4240_team1/SymTableWalker.g:184:5: ( ^( ':=' literal ) )
			// cs4240_team1/SymTableWalker.g:184:9: ^( ':=' literal )
			{
			match(input,ASSIGN,FOLLOW_ASSIGN_in_optional_init627); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_literal_in_optional_init629);
			literal23=literal();
			state._fsp--;

			match(input, Token.UP, null); 


						type = (literal23!=null?((SymTableWalker.literal_return)literal23).type:null);
			        
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return type;
	}
	// $ANTLR end "optional_init"



	// $ANTLR start "stat_seq"
	// cs4240_team1/SymTableWalker.g:194:1: stat_seq[SymbolTable symTable, boolean isInLoop] returns [boolean guaranteedReturn] : ( stat[symTable, isInLoop] )+ ;
	public final boolean stat_seq(SymbolTable symTable, boolean isInLoop) throws RecognitionException {
		boolean guaranteedReturn = false;


		boolean stat24 =false;

		try {
			// cs4240_team1/SymTableWalker.g:195:5: ( ( stat[symTable, isInLoop] )+ )
			// cs4240_team1/SymTableWalker.g:195:7: ( stat[symTable, isInLoop] )+
			{
			// cs4240_team1/SymTableWalker.g:195:7: ( stat[symTable, isInLoop] )+
			int cnt13=0;
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0==ASSIGN||(LA13_0 >= BLOCKSCOPE && LA13_0 <= BREAK)||LA13_0==FOR||LA13_0==FUNCTION_CALL||LA13_0==IF||LA13_0==RETURN||LA13_0==WHILE) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// cs4240_team1/SymTableWalker.g:195:8: stat[symTable, isInLoop]
					{
					pushFollow(FOLLOW_stat_in_stat_seq657);
					stat24=stat(symTable, isInLoop);
					state._fsp--;


								if (stat24) {
									guaranteedReturn = true;
								}
							
					}
					break;

				default :
					if ( cnt13 >= 1 ) break loop13;
					EarlyExitException eee = new EarlyExitException(13, input);
					throw eee;
				}
				cnt13++;
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return guaranteedReturn;
	}
	// $ANTLR end "stat_seq"



	// $ANTLR start "stat"
	// cs4240_team1/SymTableWalker.g:206:1: stat[SymbolTable symTable, boolean isInLoop] returns [boolean guaranteedReturn] : ( function_call[symTable] | assignment[symTable] | ^( IF expr[symTable] ^( THEN_STATS s1= stat_seq[symTable,isInLoop] ) ( ^( ELSE_STATS s2= stat_seq[symTable,isInLoop] ) )? ) | ^( WHILE expr[symTable] stat_seq[symTable,true] ) | ^( FOR ID index_expr[symTable] index_expr[symTable] stat_seq[symTable,true] ) | BREAK | ^( RETURN expr[symTable] ) | block[symTable,isInLoop] );
	public final boolean stat(SymbolTable symTable, boolean isInLoop) throws RecognitionException {
		boolean guaranteedReturn = false;


		CommonTree ID25=null;
		CommonTree BREAK26=null;
		CommonTree RETURN28=null;
		boolean s1 =false;
		boolean s2 =false;
		TreeRuleReturnScope expr27 =null;
		boolean block29 =false;


			/* only set true by...
		     *   1. RETURN
		     *   2. An if-else that has both branches with guaranteedReturn
		     *   3. blocks are statements -- so if the block statement has a guaranteedReturn
		     */
			guaranteedReturn = false;

			/* for use with IF statement's guaranteed return */
			boolean thenHasGuaranteedReturn = false;
			boolean elseHasGuaranteedReturn = false;

		try {
			// cs4240_team1/SymTableWalker.g:219:5: ( function_call[symTable] | assignment[symTable] | ^( IF expr[symTable] ^( THEN_STATS s1= stat_seq[symTable,isInLoop] ) ( ^( ELSE_STATS s2= stat_seq[symTable,isInLoop] ) )? ) | ^( WHILE expr[symTable] stat_seq[symTable,true] ) | ^( FOR ID index_expr[symTable] index_expr[symTable] stat_seq[symTable,true] ) | BREAK | ^( RETURN expr[symTable] ) | block[symTable,isInLoop] )
			int alt15=8;
			switch ( input.LA(1) ) {
			case FUNCTION_CALL:
				{
				alt15=1;
				}
				break;
			case ASSIGN:
				{
				alt15=2;
				}
				break;
			case IF:
				{
				alt15=3;
				}
				break;
			case WHILE:
				{
				alt15=4;
				}
				break;
			case FOR:
				{
				alt15=5;
				}
				break;
			case BREAK:
				{
				alt15=6;
				}
				break;
			case RETURN:
				{
				alt15=7;
				}
				break;
			case BLOCKSCOPE:
				{
				alt15=8;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 15, 0, input);
				throw nvae;
			}
			switch (alt15) {
				case 1 :
					// cs4240_team1/SymTableWalker.g:219:9: function_call[symTable]
					{
					pushFollow(FOLLOW_function_call_in_stat694);
					function_call(symTable);
					state._fsp--;

					}
					break;
				case 2 :
					// cs4240_team1/SymTableWalker.g:220:9: assignment[symTable]
					{
					pushFollow(FOLLOW_assignment_in_stat705);
					assignment(symTable);
					state._fsp--;

					}
					break;
				case 3 :
					// cs4240_team1/SymTableWalker.g:221:9: ^( IF expr[symTable] ^( THEN_STATS s1= stat_seq[symTable,isInLoop] ) ( ^( ELSE_STATS s2= stat_seq[symTable,isInLoop] ) )? )
					{
					match(input,IF,FOLLOW_IF_in_stat717); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_stat719);
					expr(symTable);
					state._fsp--;

					match(input,THEN_STATS,FOLLOW_THEN_STATS_in_stat723); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_stat_seq_in_stat727);
					s1=stat_seq(symTable, isInLoop);
					state._fsp--;


								thenHasGuaranteedReturn = s1;
							
					match(input, Token.UP, null); 

					// cs4240_team1/SymTableWalker.g:223:6: ( ^( ELSE_STATS s2= stat_seq[symTable,isInLoop] ) )?
					int alt14=2;
					int LA14_0 = input.LA(1);
					if ( (LA14_0==ELSE_STATS) ) {
						alt14=1;
					}
					switch (alt14) {
						case 1 :
							// cs4240_team1/SymTableWalker.g:223:7: ^( ELSE_STATS s2= stat_seq[symTable,isInLoop] )
							{
							match(input,ELSE_STATS,FOLLOW_ELSE_STATS_in_stat735); 
							match(input, Token.DOWN, null); 
							pushFollow(FOLLOW_stat_seq_in_stat739);
							s2=stat_seq(symTable, isInLoop);
							state._fsp--;

							match(input, Token.UP, null); 


										elseHasGuaranteedReturn = s2;
									
							}
							break;

					}

					match(input, Token.UP, null); 


								guaranteedReturn = thenHasGuaranteedReturn && elseHasGuaranteedReturn;
							
					}
					break;
				case 4 :
					// cs4240_team1/SymTableWalker.g:228:9: ^( WHILE expr[symTable] stat_seq[symTable,true] )
					{
					match(input,WHILE,FOLLOW_WHILE_in_stat759); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_stat761);
					expr(symTable);
					state._fsp--;

					pushFollow(FOLLOW_stat_seq_in_stat764);
					stat_seq(symTable, true);
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 5 :
					// cs4240_team1/SymTableWalker.g:229:9: ^( FOR ID index_expr[symTable] index_expr[symTable] stat_seq[symTable,true] )
					{
					match(input,FOR,FOLLOW_FOR_in_stat777); 
					match(input, Token.DOWN, null); 
					ID25=(CommonTree)match(input,ID,FOLLOW_ID_in_stat779); 

								/* LOGIC COPIED FROM ID in INDEX-EXPR!! */

								/* will log error and return null if var does not exist */
								TigerType varType = VarChecker.getTypeForVar((ID25!=null?ID25.getText():null), symTable, ID25.getToken(), errors);

								/* var exists, but type is no good for this arithmetic */
								if (varType != null && !varType.isValidInIndexArithmetic()) {
									errors.add(new SemanticError(
										ID25.getToken(),
										String.format("variable '%s' of type '%s' not allowed as for-loop counter (must be type 'int')", (ID25!=null?ID25.getText():null), varType)));
								}
							
					pushFollow(FOLLOW_index_expr_in_stat783);
					index_expr(symTable);
					state._fsp--;

					pushFollow(FOLLOW_index_expr_in_stat786);
					index_expr(symTable);
					state._fsp--;

					pushFollow(FOLLOW_stat_seq_in_stat789);
					stat_seq(symTable, true);
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 6 :
					// cs4240_team1/SymTableWalker.g:243:9: BREAK
					{
					BREAK26=(CommonTree)match(input,BREAK,FOLLOW_BREAK_in_stat807); 

					            SemanticChecks.check_break(BREAK26.getToken(), isInLoop, errors);
					        
					}
					break;
				case 7 :
					// cs4240_team1/SymTableWalker.g:246:9: ^( RETURN expr[symTable] )
					{
					RETURN28=(CommonTree)match(input,RETURN,FOLLOW_RETURN_in_stat820); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_stat822);
					expr27=expr(symTable);
					state._fsp--;

					match(input, Token.UP, null); 


								/* don't perform return check if expression result has error!
									Also, may not have been successful function declaration --> func return type is null
								 */
								guaranteedReturn = true;
								if ((expr27!=null?((SymTableWalker.expr_return)expr27).type:null) != null && symTable.getFunctionReturnType() != null) {
									SemanticChecks.check_function_return(RETURN28.getToken(), (expr27!=null?((SymTableWalker.expr_return)expr27).type:null), symTable.getFunctionReturnType(), errors);
								}
					        
					}
					break;
				case 8 :
					// cs4240_team1/SymTableWalker.g:255:9: block[symTable,isInLoop]
					{
					pushFollow(FOLLOW_block_in_stat836);
					block29=block(symTable, isInLoop);
					state._fsp--;


								guaranteedReturn = block29;
							
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return guaranteedReturn;
	}
	// $ANTLR end "stat"



	// $ANTLR start "assignment"
	// cs4240_team1/SymTableWalker.g:260:1: assignment[SymbolTable symTable] : ^( ':=' value[symTable] ( expr[symTable] | function_call[symTable] ) ) ;
	public final void assignment(SymbolTable symTable) throws RecognitionException {
		TreeRuleReturnScope expr30 =null;
		TreeRuleReturnScope value31 =null;
		TreeRuleReturnScope function_call32 =null;

		try {
			// cs4240_team1/SymTableWalker.g:261:5: ( ^( ':=' value[symTable] ( expr[symTable] | function_call[symTable] ) ) )
			// cs4240_team1/SymTableWalker.g:261:7: ^( ':=' value[symTable] ( expr[symTable] | function_call[symTable] ) )
			{
			match(input,ASSIGN,FOLLOW_ASSIGN_in_assignment858); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_value_in_assignment860);
			value31=value(symTable);
			state._fsp--;

			// cs4240_team1/SymTableWalker.g:262:4: ( expr[symTable] | function_call[symTable] )
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0==AND||LA16_0==DIV||LA16_0==EQ||LA16_0==FIXEDPTLIT||(LA16_0 >= GREATER && LA16_0 <= ID)||LA16_0==INTLIT||(LA16_0 >= LESSER && LA16_0 <= LESSEREQ)||(LA16_0 >= MINUS && LA16_0 <= NEQ)||LA16_0==OR||LA16_0==PLUS) ) {
				alt16=1;
			}
			else if ( (LA16_0==FUNCTION_CALL) ) {
				alt16=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 16, 0, input);
				throw nvae;
			}

			switch (alt16) {
				case 1 :
					// cs4240_team1/SymTableWalker.g:262:6: expr[symTable]
					{
					pushFollow(FOLLOW_expr_in_assignment868);
					expr30=expr(symTable);
					state._fsp--;


										if ((expr30!=null?((SymTableWalker.expr_return)expr30).type:null) != null
												&& (value31!=null?((SymTableWalker.value_return)value31).type:null) != null
												&& !(value31!=null?((SymTableWalker.value_return)value31).type:null).isAssignableFrom((expr30!=null?((SymTableWalker.expr_return)expr30).type:null))) {
											errors.add(new SemanticError(
												(value31!=null?((SymTableWalker.value_return)value31).token:null),
												"cannot assign type '" + (expr30!=null?((SymTableWalker.expr_return)expr30).type:null) + "' to type '" + (value31!=null?((SymTableWalker.value_return)value31).type:null) + "'"));
										}
									
					}
					break;
				case 2 :
					// cs4240_team1/SymTableWalker.g:271:6: function_call[symTable]
					{
					pushFollow(FOLLOW_function_call_in_assignment878);
					function_call32=function_call(symTable);
					state._fsp--;


										if ((function_call32!=null?((SymTableWalker.function_call_return)function_call32).returnType:null) != null
												&& (value31!=null?((SymTableWalker.value_return)value31).type:null) != null
												&& !(value31!=null?((SymTableWalker.value_return)value31).type:null).isAssignableFrom((function_call32!=null?((SymTableWalker.function_call_return)function_call32).returnType:null))) {
											String message = ((function_call32!=null?((SymTableWalker.function_call_return)function_call32).returnType:null).isVoid())
												? "attempting to use result of 'void' function '" + (function_call32!=null?((SymTableWalker.function_call_return)function_call32).funcId:null) + "'"
												: "cannot assign return type '" + (function_call32!=null?((SymTableWalker.function_call_return)function_call32).returnType:null) + "' to type '" + (value31!=null?((SymTableWalker.value_return)value31).type:null) + "'";
											errors.add(new SemanticError((value31!=null?((SymTableWalker.value_return)value31).token:null), message));
										}
									
					}
					break;

			}

			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "assignment"


	public static class function_call_return extends TreeRuleReturnScope {
		public TigerType returnType;
		public String funcId;
	};


	// $ANTLR start "function_call"
	// cs4240_team1/SymTableWalker.g:290:1: function_call[SymbolTable symTable] returns [TigerType returnType, String funcId] : ^( FUNCTION_CALL ID (args= function_args[symTable] )? ) ;
	public final SymTableWalker.function_call_return function_call(SymbolTable symTable) throws RecognitionException {
		SymTableWalker.function_call_return retval = new SymTableWalker.function_call_return();
		retval.start = input.LT(1);

		CommonTree ID33=null;
		TreeRuleReturnScope args =null;


			List<TigerType> paramTypes;
			List<TigerType> argTypes;
			FunctionEntry funcEntry;
			boolean hasArgs = false;

		try {
			// cs4240_team1/SymTableWalker.g:297:5: ( ^( FUNCTION_CALL ID (args= function_args[symTable] )? ) )
			// cs4240_team1/SymTableWalker.g:297:7: ^( FUNCTION_CALL ID (args= function_args[symTable] )? )
			{
			match(input,FUNCTION_CALL,FOLLOW_FUNCTION_CALL_in_function_call920); 
			match(input, Token.DOWN, null); 
			ID33=(CommonTree)match(input,ID,FOLLOW_ID_in_function_call922); 

						retval.funcId = (ID33!=null?ID33.getText():null);
						/* this call will return std lib func entries! */
						funcEntry = FunctionChecker.getFunctionEntry(ID33.getToken(), symTable, errors);
					
			// cs4240_team1/SymTableWalker.g:301:5: (args= function_args[symTable] )?
			int alt17=2;
			int LA17_0 = input.LA(1);
			if ( (LA17_0==EXPRLIST) ) {
				alt17=1;
			}
			switch (alt17) {
				case 1 :
					// cs4240_team1/SymTableWalker.g:301:6: args= function_args[symTable]
					{
					pushFollow(FOLLOW_function_args_in_function_call929);
					args=function_args(symTable);
					state._fsp--;


								hasArgs = true;
							
					}
					break;

			}

			match(input, Token.UP, null); 


						if (funcEntry == null) {
							retval.returnType = null;
						} else {
							paramTypes = FunctionChecker.extractParameterTypes(funcEntry.parameters, symTable);

							argTypes = hasArgs ? (args!=null?((SymTableWalker.function_args_return)args).argTypes:null) : new ArrayList<TigerType>();
							if ((args!=null?((SymTableWalker.function_args_return)args).invalidArgs:false)) {
								retval.returnType = null;
							} else if (FunctionChecker.checkArgTypes(argTypes, paramTypes, ID33.getToken(), errors)) {
								retval.returnType = funcEntry.getReturnType();
							} else {
								retval.returnType = null;
							}
						}
					
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "function_call"


	public static class function_args_return extends TreeRuleReturnScope {
		public List<TigerType> argTypes;
		public boolean invalidArgs;
	};


	// $ANTLR start "function_args"
	// cs4240_team1/SymTableWalker.g:322:1: function_args[SymbolTable symTable] returns [List<TigerType> argTypes, boolean invalidArgs] : ^( EXPRLIST ( expr[symTable] )+ ) ;
	public final SymTableWalker.function_args_return function_args(SymbolTable symTable) throws RecognitionException {
		SymTableWalker.function_args_return retval = new SymTableWalker.function_args_return();
		retval.start = input.LT(1);

		TreeRuleReturnScope expr34 =null;


			retval.argTypes = new ArrayList<>();

		try {
			// cs4240_team1/SymTableWalker.g:326:5: ( ^( EXPRLIST ( expr[symTable] )+ ) )
			// cs4240_team1/SymTableWalker.g:326:7: ^( EXPRLIST ( expr[symTable] )+ )
			{
			match(input,EXPRLIST,FOLLOW_EXPRLIST_in_function_args967); 
			match(input, Token.DOWN, null); 
			// cs4240_team1/SymTableWalker.g:326:18: ( expr[symTable] )+
			int cnt18=0;
			loop18:
			while (true) {
				int alt18=2;
				int LA18_0 = input.LA(1);
				if ( (LA18_0==AND||LA18_0==DIV||LA18_0==EQ||LA18_0==FIXEDPTLIT||(LA18_0 >= GREATER && LA18_0 <= ID)||LA18_0==INTLIT||(LA18_0 >= LESSER && LA18_0 <= LESSEREQ)||(LA18_0 >= MINUS && LA18_0 <= NEQ)||LA18_0==OR||LA18_0==PLUS) ) {
					alt18=1;
				}

				switch (alt18) {
				case 1 :
					// cs4240_team1/SymTableWalker.g:326:19: expr[symTable]
					{
					pushFollow(FOLLOW_expr_in_function_args970);
					expr34=expr(symTable);
					state._fsp--;


								if ((expr34!=null?((SymTableWalker.expr_return)expr34).type:null) == null) {
									retval.invalidArgs = true;
								}
								retval.argTypes.add((expr34!=null?((SymTableWalker.expr_return)expr34).type:null));
							
					}
					break;

				default :
					if ( cnt18 >= 1 ) break loop18;
					EarlyExitException eee = new EarlyExitException(18, input);
					throw eee;
				}
				cnt18++;
			}

			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "function_args"


	public static class expr_return extends TreeRuleReturnScope {
		public TigerType type;
		public Token token;
	};


	// $ANTLR start "expr"
	// cs4240_team1/SymTableWalker.g:342:1: expr[SymbolTable symTable] returns [TigerType type, Token token] : ( ^( logical_op e1= expr[symTable] e2= expr[symTable] ) | ^( comparison_op e1= expr[symTable] e2= expr[symTable] ) | ^( arithmetic_op e1= expr[symTable] e2= expr[symTable] ) | value[symTable] | literal );
	public final SymTableWalker.expr_return expr(SymbolTable symTable) throws RecognitionException {
		SymTableWalker.expr_return retval = new SymTableWalker.expr_return();
		retval.start = input.LT(1);

		TreeRuleReturnScope e1 =null;
		TreeRuleReturnScope e2 =null;
		TreeRuleReturnScope value35 =null;
		TreeRuleReturnScope literal36 =null;

		try {
			// cs4240_team1/SymTableWalker.g:344:5: ( ^( logical_op e1= expr[symTable] e2= expr[symTable] ) | ^( comparison_op e1= expr[symTable] e2= expr[symTable] ) | ^( arithmetic_op e1= expr[symTable] e2= expr[symTable] ) | value[symTable] | literal )
			int alt19=5;
			switch ( input.LA(1) ) {
			case AND:
			case OR:
				{
				alt19=1;
				}
				break;
			case EQ:
			case GREATER:
			case GREATEREQ:
			case LESSER:
			case LESSEREQ:
			case NEQ:
				{
				alt19=2;
				}
				break;
			case DIV:
			case MINUS:
			case MULT:
			case PLUS:
				{
				alt19=3;
				}
				break;
			case ID:
				{
				alt19=4;
				}
				break;
			case FIXEDPTLIT:
			case INTLIT:
				{
				alt19=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 19, 0, input);
				throw nvae;
			}
			switch (alt19) {
				case 1 :
					// cs4240_team1/SymTableWalker.g:344:9: ^( logical_op e1= expr[symTable] e2= expr[symTable] )
					{
					pushFollow(FOLLOW_logical_op_in_expr1011);
					logical_op();
					state._fsp--;

					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr1015);
					e1=expr(symTable);
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr1020);
					e2=expr(symTable);
					state._fsp--;

					match(input, Token.UP, null); 


								/* we set an error before returning null -- the error has been captured, so just propogate it up */
								if ((e1!=null?((SymTableWalker.expr_return)e1).type:null) == null || (e2!=null?((SymTableWalker.expr_return)e2).type:null) == null) {
									/* before propogating -- check if the other side has an error */
									if ((e1!=null?((SymTableWalker.expr_return)e1).type:null) != null && !(e1!=null?((SymTableWalker.expr_return)e1).type:null).isValidInLogical()) {
										errors.add(new SemanticError((e1!=null?((SymTableWalker.expr_return)e1).token:null), "cannot use type '" + (e1!=null?((SymTableWalker.expr_return)e1).type:null) + "' with logical operator"));
									} else if ((e2!=null?((SymTableWalker.expr_return)e2).type:null) != null && !(e2!=null?((SymTableWalker.expr_return)e2).type:null).isValidInLogical()) {
										errors.add(new SemanticError((e2!=null?((SymTableWalker.expr_return)e2).token:null), "cannot use type '" + (e2!=null?((SymTableWalker.expr_return)e2).type:null) + "' with logical operator"));
									} 
									retval.token = (e1!=null?((SymTableWalker.expr_return)e1).type:null) == null ? (e1!=null?((SymTableWalker.expr_return)e1).token:null) : (e2!=null?((SymTableWalker.expr_return)e2).token:null);
									retval.type = null;  /* propogate signal that error has been captured */
								} else if ((e1!=null?((SymTableWalker.expr_return)e1).type:null) != null && !(e1!=null?((SymTableWalker.expr_return)e1).type:null).isValidInLogical()) {
									errors.add(new SemanticError((e1!=null?((SymTableWalker.expr_return)e1).token:null), "cannot use type '" + (e1!=null?((SymTableWalker.expr_return)e1).type:null) + "' with logical operator"));
									/* check if other side has an error */
									if ((e2!=null?((SymTableWalker.expr_return)e2).type:null) != null && !(e2!=null?((SymTableWalker.expr_return)e2).type:null).isValidInLogical()) {
										errors.add(new SemanticError((e2!=null?((SymTableWalker.expr_return)e2).token:null), "cannot use type '" + (e2!=null?((SymTableWalker.expr_return)e2).type:null) + "' with logical operator"));
									}
									retval.token = (e1!=null?((SymTableWalker.expr_return)e1).token:null);
									retval.type = null;
								} else if ((e2!=null?((SymTableWalker.expr_return)e2).type:null) != null && !(e2!=null?((SymTableWalker.expr_return)e2).type:null).isValidInLogical()) {
									errors.add(new SemanticError((e2!=null?((SymTableWalker.expr_return)e2).token:null), "cannot use type '" + (e2!=null?((SymTableWalker.expr_return)e2).type:null) + "' with logical operator"));
									retval.token = (e2!=null?((SymTableWalker.expr_return)e2).token:null);
									retval.type = null;
								} else {
									retval.token = (e1!=null?((SymTableWalker.expr_return)e1).token:null);
									retval.type = TypeChecker.getTypeAfterLogical((e1!=null?((SymTableWalker.expr_return)e1).type:null), (e2!=null?((SymTableWalker.expr_return)e2).type:null));
									if (retval.type == null) {
										errors.add(new SemanticError((e1!=null?((SymTableWalker.expr_return)e1).token:null), "cannot mix '" + (e1!=null?((SymTableWalker.expr_return)e1).type:null) + "' with '" + (e2!=null?((SymTableWalker.expr_return)e2).type:null) + "' in logical"));
									}
								}
					        
					}
					break;
				case 2 :
					// cs4240_team1/SymTableWalker.g:377:9: ^( comparison_op e1= expr[symTable] e2= expr[symTable] )
					{
					pushFollow(FOLLOW_comparison_op_in_expr1042);
					comparison_op();
					state._fsp--;

					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr1046);
					e1=expr(symTable);
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr1051);
					e2=expr(symTable);
					state._fsp--;

					match(input, Token.UP, null); 


								/* we set an error before returning null -- the error has been captured, so just propogate it up */
								if ((e1!=null?((SymTableWalker.expr_return)e1).type:null) == null || (e2!=null?((SymTableWalker.expr_return)e2).type:null) == null) {
									/* check if the other side has an error, too before propogating */
									if ((e1!=null?((SymTableWalker.expr_return)e1).type:null) != null && !(e1!=null?((SymTableWalker.expr_return)e1).type:null).isValidInComparison()) {
										errors.add(new SemanticError((e1!=null?((SymTableWalker.expr_return)e1).token:null), "cannot use type '" + (e1!=null?((SymTableWalker.expr_return)e1).type:null) + "' in comparison"));
									} else if ((e2!=null?((SymTableWalker.expr_return)e2).type:null) != null && !(e2!=null?((SymTableWalker.expr_return)e2).type:null).isValidInComparison()) {
										errors.add(new SemanticError((e2!=null?((SymTableWalker.expr_return)e2).token:null), "cannot use type '" + (e2!=null?((SymTableWalker.expr_return)e2).type:null) + "' in comparison"));
									}
									retval.token = (e1!=null?((SymTableWalker.expr_return)e1).type:null) == null ? (e1!=null?((SymTableWalker.expr_return)e1).token:null) : (e2!=null?((SymTableWalker.expr_return)e2).token:null);
									retval.type = null;  /* propogate signal that error has been captured */
								} else if ((e1!=null?((SymTableWalker.expr_return)e1).type:null) != null && !(e1!=null?((SymTableWalker.expr_return)e1).type:null).isValidInComparison()) {
									errors.add(new SemanticError((e1!=null?((SymTableWalker.expr_return)e1).token:null), "cannot use type '" + (e1!=null?((SymTableWalker.expr_return)e1).type:null) + "' in comparison"));
									/* check if other side has an error before propogating */
									if ((e2!=null?((SymTableWalker.expr_return)e2).type:null) != null && !(e2!=null?((SymTableWalker.expr_return)e2).type:null).isValidInComparison()) {
										errors.add(new SemanticError((e2!=null?((SymTableWalker.expr_return)e2).token:null), "cannot use type '" + (e2!=null?((SymTableWalker.expr_return)e2).type:null) + "' in comparison"));
									}
									retval.token = (e1!=null?((SymTableWalker.expr_return)e1).token:null);
									retval.type = null;
								} else if ((e2!=null?((SymTableWalker.expr_return)e2).type:null) != null && !(e2!=null?((SymTableWalker.expr_return)e2).type:null).isValidInComparison()) {
									errors.add(new SemanticError((e2!=null?((SymTableWalker.expr_return)e2).token:null), "cannot use type '" + (e2!=null?((SymTableWalker.expr_return)e2).type:null) + "' in comparison"));
									retval.token = (e2!=null?((SymTableWalker.expr_return)e2).token:null);
									retval.type = null;
								} else {
									retval.token = (e1!=null?((SymTableWalker.expr_return)e1).token:null);
									retval.type = TypeChecker.getTypeAfterComparison((e1!=null?((SymTableWalker.expr_return)e1).type:null), (e2!=null?((SymTableWalker.expr_return)e2).type:null));
									if (retval.type == null) {
										errors.add(new SemanticError((e1!=null?((SymTableWalker.expr_return)e1).token:null), "cannot mix '" + (e1!=null?((SymTableWalker.expr_return)e1).type:null) + "' with '" + (e2!=null?((SymTableWalker.expr_return)e2).type:null) + "' in comparison"));
									}
								}
					        
					}
					break;
				case 3 :
					// cs4240_team1/SymTableWalker.g:410:9: ^( arithmetic_op e1= expr[symTable] e2= expr[symTable] )
					{
					pushFollow(FOLLOW_arithmetic_op_in_expr1073);
					arithmetic_op();
					state._fsp--;

					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr1077);
					e1=expr(symTable);
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr1082);
					e2=expr(symTable);
					state._fsp--;

					match(input, Token.UP, null); 


								/* we set an error before returning null -- the error has been captured, so just propogate it up */
								if ((e1!=null?((SymTableWalker.expr_return)e1).type:null) == null || (e2!=null?((SymTableWalker.expr_return)e2).type:null) == null) {
									/* before propogating, check if other side is invalid operand */
									if ((e1!=null?((SymTableWalker.expr_return)e1).type:null) != null && !(e1!=null?((SymTableWalker.expr_return)e1).type:null).isValidInArithmetic()) {
										errors.add(new SemanticError((e1!=null?((SymTableWalker.expr_return)e1).token:null), "cannot use type '" + (e1!=null?((SymTableWalker.expr_return)e1).type:null) + "' in arithmetic"));
									} else if ((e2!=null?((SymTableWalker.expr_return)e2).type:null) != null && !(e2!=null?((SymTableWalker.expr_return)e2).type:null).isValidInArithmetic()) {
										errors.add(new SemanticError((e2!=null?((SymTableWalker.expr_return)e2).token:null), "cannot use type '" + (e2!=null?((SymTableWalker.expr_return)e2).type:null) + "' in arithmetic"));
									}
									retval.token = (e1!=null?((SymTableWalker.expr_return)e1).type:null) == null ? (e1!=null?((SymTableWalker.expr_return)e1).token:null) : (e2!=null?((SymTableWalker.expr_return)e2).token:null);
									retval.type = null;  /* propogate signal that error has been captured */
								} else if ((e1!=null?((SymTableWalker.expr_return)e1).type:null) != null && !(e1!=null?((SymTableWalker.expr_return)e1).type:null).isValidInArithmetic()) {
									errors.add(new SemanticError((e1!=null?((SymTableWalker.expr_return)e1).token:null), "cannot use type '" + (e1!=null?((SymTableWalker.expr_return)e1).type:null) + "' in arithmetic"));
									/* before propogating, check if other side is invalid operand */
									if ((e2!=null?((SymTableWalker.expr_return)e2).type:null) != null && !(e2!=null?((SymTableWalker.expr_return)e2).type:null).isValidInArithmetic()) {
										errors.add(new SemanticError((e2!=null?((SymTableWalker.expr_return)e2).token:null), "cannot use type '" + (e2!=null?((SymTableWalker.expr_return)e2).type:null) + "' in arithmetic"));
									}
									retval.token = (e1!=null?((SymTableWalker.expr_return)e1).token:null);
									retval.type = null;
								} else if ((e2!=null?((SymTableWalker.expr_return)e2).type:null) != null && !(e2!=null?((SymTableWalker.expr_return)e2).type:null).isValidInArithmetic()) {
									errors.add(new SemanticError((e2!=null?((SymTableWalker.expr_return)e2).token:null), "cannot use type '" + (e2!=null?((SymTableWalker.expr_return)e2).type:null) + "' in arithmetic"));
									retval.token = (e2!=null?((SymTableWalker.expr_return)e2).token:null);
									retval.type = null;
								} else {
									retval.token = (e1!=null?((SymTableWalker.expr_return)e1).token:null);
									retval.type = TypeChecker.getTypeAfterArithmetic((e1!=null?((SymTableWalker.expr_return)e1).type:null), (e2!=null?((SymTableWalker.expr_return)e2).type:null));
									if (retval.type == null) {
										errors.add(new SemanticError((e1!=null?((SymTableWalker.expr_return)e1).token:null), "cannot mix '" + (e1!=null?((SymTableWalker.expr_return)e1).type:null) + "' with '" + (e2!=null?((SymTableWalker.expr_return)e2).type:null) + "' in arithmetic"));
									}
								}
					        
					}
					break;
				case 4 :
					// cs4240_team1/SymTableWalker.g:442:7: value[symTable]
					{
					pushFollow(FOLLOW_value_in_expr1095);
					value35=value(symTable);
					state._fsp--;


								retval.type = (value35!=null?((SymTableWalker.value_return)value35).type:null);
								retval.token = (value35!=null?((SymTableWalker.value_return)value35).token:null);
							
					}
					break;
				case 5 :
					// cs4240_team1/SymTableWalker.g:446:7: literal
					{
					pushFollow(FOLLOW_literal_in_expr1106);
					literal36=literal();
					state._fsp--;


								retval.type = (literal36!=null?((SymTableWalker.literal_return)literal36).type:null);
								retval.token = (literal36!=null?((SymTableWalker.literal_return)literal36).token:null);
							
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expr"



	// $ANTLR start "logical_op"
	// cs4240_team1/SymTableWalker.g:452:1: logical_op : ( '&' | '|' );
	public final void logical_op() throws RecognitionException {
		try {
			// cs4240_team1/SymTableWalker.g:452:11: ( '&' | '|' )
			// cs4240_team1/SymTableWalker.g:
			{
			if ( input.LA(1)==AND||input.LA(1)==OR ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "logical_op"



	// $ANTLR start "comparison_op"
	// cs4240_team1/SymTableWalker.g:453:1: comparison_op : ( '<' | '<=' | '>' | '>=' | '=' | '<>' );
	public final void comparison_op() throws RecognitionException {
		try {
			// cs4240_team1/SymTableWalker.g:453:14: ( '<' | '<=' | '>' | '>=' | '=' | '<>' )
			// cs4240_team1/SymTableWalker.g:
			{
			if ( input.LA(1)==EQ||(input.LA(1) >= GREATER && input.LA(1) <= GREATEREQ)||(input.LA(1) >= LESSER && input.LA(1) <= LESSEREQ)||input.LA(1)==NEQ ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "comparison_op"



	// $ANTLR start "arithmetic_op"
	// cs4240_team1/SymTableWalker.g:454:1: arithmetic_op : ( '+' | '-' | '*' | '/' );
	public final void arithmetic_op() throws RecognitionException {
		try {
			// cs4240_team1/SymTableWalker.g:454:14: ( '+' | '-' | '*' | '/' )
			// cs4240_team1/SymTableWalker.g:
			{
			if ( input.LA(1)==DIV||(input.LA(1) >= MINUS && input.LA(1) <= MULT)||input.LA(1)==PLUS ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "arithmetic_op"


	public static class value_return extends TreeRuleReturnScope {
		public TigerType type;
		public Token token;
	};


	// $ANTLR start "value"
	// cs4240_team1/SymTableWalker.g:457:1: value[SymbolTable symTable] returns [TigerType type, Token token] : ^( ID (indexCount= value_tail[symTable] )? ) ;
	public final SymTableWalker.value_return value(SymbolTable symTable) throws RecognitionException {
		SymTableWalker.value_return retval = new SymTableWalker.value_return();
		retval.start = input.LT(1);

		CommonTree ID37=null;
		int indexCount =0;

		try {
			// cs4240_team1/SymTableWalker.g:458:5: ( ^( ID (indexCount= value_tail[symTable] )? ) )
			// cs4240_team1/SymTableWalker.g:458:9: ^( ID (indexCount= value_tail[symTable] )? )
			{
			ID37=(CommonTree)match(input,ID,FOLLOW_ID_in_value1193); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// cs4240_team1/SymTableWalker.g:458:24: (indexCount= value_tail[symTable] )?
				int alt20=2;
				int LA20_0 = input.LA(1);
				if ( (LA20_0==ID||LA20_0==INTLIT||(LA20_0 >= MINUS && LA20_0 <= MULT)||LA20_0==PLUS) ) {
					alt20=1;
				}
				switch (alt20) {
					case 1 :
						// cs4240_team1/SymTableWalker.g:458:24: indexCount= value_tail[symTable]
						{
						pushFollow(FOLLOW_value_tail_in_value1197);
						indexCount=value_tail(symTable);
						state._fsp--;

						}
						break;

				}

				match(input, Token.UP, null); 
			}


						String indexErrorMessage;
						retval.token = ID37.getToken();
						retval.type = VarChecker.getTypeForVar((ID37!=null?ID37.getText():null), symTable, retval.token, errors);

						/* check if we will get an index error */
						if (retval.type != null && !retval.type.isValidIndexCount(indexCount)) {
							if (retval.type.isArray1D()) {
								indexErrorMessage = "attempting to index one-dimensional array '" + (ID37!=null?ID37.getText():null) + "' with 2 levels of indexing";
							} else if (retval.type.isArray2D()) {
								indexErrorMessage = "partial indexing of two-dimensional array '" + (ID37!=null?ID37.getText():null) + "' is not allowed";
							} else {
								indexErrorMessage = "attempting to index variable '" + (ID37!=null?ID37.getText():null) + "' that is not an array type";
							}
							retval.type = null;  /* set to null to indicate logged error to "calling" rule */
							errors.add(new SemanticError(retval.token, indexErrorMessage));
						} else if (retval.type != null) {
							retval.type = retval.type.getTypeAfterIndex(indexCount);
						}
			        
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "value"


	public static class literal_return extends TreeRuleReturnScope {
		public TigerType type;
		public Token token;
	};


	// $ANTLR start "literal"
	// cs4240_team1/SymTableWalker.g:480:1: literal returns [TigerType type, Token token] : ( INTLIT | FIXEDPTLIT );
	public final SymTableWalker.literal_return literal() throws RecognitionException {
		SymTableWalker.literal_return retval = new SymTableWalker.literal_return();
		retval.start = input.LT(1);

		CommonTree INTLIT38=null;
		CommonTree FIXEDPTLIT39=null;

		try {
			// cs4240_team1/SymTableWalker.g:481:5: ( INTLIT | FIXEDPTLIT )
			int alt21=2;
			int LA21_0 = input.LA(1);
			if ( (LA21_0==INTLIT) ) {
				alt21=1;
			}
			else if ( (LA21_0==FIXEDPTLIT) ) {
				alt21=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 21, 0, input);
				throw nvae;
			}

			switch (alt21) {
				case 1 :
					// cs4240_team1/SymTableWalker.g:481:9: INTLIT
					{
					INTLIT38=(CommonTree)match(input,INTLIT,FOLLOW_INTLIT_in_literal1225); 

								retval.type = TigerType.LITERAL_INT_TYPE;
								retval.token = INTLIT38.getToken();
					        
					}
					break;
				case 2 :
					// cs4240_team1/SymTableWalker.g:485:9: FIXEDPTLIT
					{
					FIXEDPTLIT39=(CommonTree)match(input,FIXEDPTLIT,FOLLOW_FIXEDPTLIT_in_literal1237); 

								retval.type = TigerType.LITERAL_FIXEDPT_TYPE;
								retval.token = FIXEDPTLIT39.getToken();
					        
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "literal"



	// $ANTLR start "value_tail"
	// cs4240_team1/SymTableWalker.g:492:1: value_tail[SymbolTable symTable] returns [int indexCount] : ( index_expr[symTable] ) ( index_expr[symTable] )? ;
	public final int value_tail(SymbolTable symTable) throws RecognitionException {
		int indexCount = 0;


		try {
			// cs4240_team1/SymTableWalker.g:493:5: ( ( index_expr[symTable] ) ( index_expr[symTable] )? )
			// cs4240_team1/SymTableWalker.g:493:7: ( index_expr[symTable] ) ( index_expr[symTable] )?
			{
			// cs4240_team1/SymTableWalker.g:493:7: ( index_expr[symTable] )
			// cs4240_team1/SymTableWalker.g:493:8: index_expr[symTable]
			{
			pushFollow(FOLLOW_index_expr_in_value_tail1264);
			index_expr(symTable);
			state._fsp--;

			indexCount = 1;
			}

			// cs4240_team1/SymTableWalker.g:493:49: ( index_expr[symTable] )?
			int alt22=2;
			int LA22_0 = input.LA(1);
			if ( (LA22_0==ID||LA22_0==INTLIT||(LA22_0 >= MINUS && LA22_0 <= MULT)||LA22_0==PLUS) ) {
				alt22=1;
			}
			switch (alt22) {
				case 1 :
					// cs4240_team1/SymTableWalker.g:493:50: index_expr[symTable]
					{
					pushFollow(FOLLOW_index_expr_in_value_tail1271);
					index_expr(symTable);
					state._fsp--;

					indexCount = 2;
					}
					break;

			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return indexCount;
	}
	// $ANTLR end "value_tail"


	public static class index_expr_return extends TreeRuleReturnScope {
		public TigerType type;
		public Token token;
	};


	// $ANTLR start "index_expr"
	// cs4240_team1/SymTableWalker.g:496:1: index_expr[SymbolTable symTable] returns [TigerType type, Token token] : ( ^( index_expr_op e1= index_expr[symTable] e2= index_expr[symTable] ) | INTLIT | ID );
	public final SymTableWalker.index_expr_return index_expr(SymbolTable symTable) throws RecognitionException {
		SymTableWalker.index_expr_return retval = new SymTableWalker.index_expr_return();
		retval.start = input.LT(1);

		CommonTree INTLIT40=null;
		CommonTree ID41=null;
		TreeRuleReturnScope e1 =null;
		TreeRuleReturnScope e2 =null;

		try {
			// cs4240_team1/SymTableWalker.g:497:5: ( ^( index_expr_op e1= index_expr[symTable] e2= index_expr[symTable] ) | INTLIT | ID )
			int alt23=3;
			switch ( input.LA(1) ) {
			case MINUS:
			case MULT:
			case PLUS:
				{
				alt23=1;
				}
				break;
			case INTLIT:
				{
				alt23=2;
				}
				break;
			case ID:
				{
				alt23=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 23, 0, input);
				throw nvae;
			}
			switch (alt23) {
				case 1 :
					// cs4240_team1/SymTableWalker.g:497:7: ^( index_expr_op e1= index_expr[symTable] e2= index_expr[symTable] )
					{
					pushFollow(FOLLOW_index_expr_op_in_index_expr1299);
					index_expr_op();
					state._fsp--;

					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_index_expr_in_index_expr1303);
					e1=index_expr(symTable);
					state._fsp--;

					pushFollow(FOLLOW_index_expr_in_index_expr1308);
					e2=index_expr(symTable);
					state._fsp--;

					match(input, Token.UP, null); 


								if ((e1!=null?((SymTableWalker.index_expr_return)e1).type:null) == null || (e2!=null?((SymTableWalker.index_expr_return)e2).type:null) == null) {
									/* propogate error up */
									retval.type = null;
									retval.token = ((e1!=null?((SymTableWalker.index_expr_return)e1).type:null) == null) ? (e1!=null?((SymTableWalker.index_expr_return)e1).token:null) : (e2!=null?((SymTableWalker.index_expr_return)e2).token:null);
								} else if (!(e1!=null?((SymTableWalker.index_expr_return)e1).type:null).isValidInIndexArithmetic() || !(e2!=null?((SymTableWalker.index_expr_return)e2).type:null).isValidInIndexArithmetic()) {
									/* this code may not be called b/c ID will capture the same exact errors first */

									/* print errors for both if both are invalid */
									String errorFormat = "values of type '%s' not allowed in index expression (only type 'int' is accepted)";
									if (!(e2!=null?((SymTableWalker.index_expr_return)e2).type:null).isValidInIndexArithmetic()) {
										errors.add(new SemanticError((e2!=null?((SymTableWalker.index_expr_return)e2).token:null), String.format(errorFormat, (e2!=null?((SymTableWalker.index_expr_return)e2).type:null))));
										retval.token = (e2!=null?((SymTableWalker.index_expr_return)e2).token:null);
									}
									if (!(e1!=null?((SymTableWalker.index_expr_return)e1).type:null).isValidInIndexArithmetic()) {
										errors.add(new SemanticError((e1!=null?((SymTableWalker.index_expr_return)e1).token:null), String.format(errorFormat, (e1!=null?((SymTableWalker.index_expr_return)e1).type:null))));
										retval.token = (e1!=null?((SymTableWalker.index_expr_return)e1).token:null);
									}
									retval.type = null; /* indicate error was logged */
								} else {
									retval.type = TypeChecker.getTypeAfterArithmetic((e1!=null?((SymTableWalker.index_expr_return)e1).type:null), (e2!=null?((SymTableWalker.index_expr_return)e2).type:null));
									retval.token = (e1!=null?((SymTableWalker.index_expr_return)e1).token:null);
								}
							
					}
					break;
				case 2 :
					// cs4240_team1/SymTableWalker.g:521:7: INTLIT
					{
					INTLIT40=(CommonTree)match(input,INTLIT,FOLLOW_INTLIT_in_index_expr1320); 

								retval.type = TigerType.LITERAL_INT_TYPE;
								retval.token = INTLIT40.getToken();
							
					}
					break;
				case 3 :
					// cs4240_team1/SymTableWalker.g:525:7: ID
					{
					ID41=(CommonTree)match(input,ID,FOLLOW_ID_in_index_expr1330); 

								/* THIS LOGIC IS COPIED IN FOR STATEMENT!!! */ 

								/* will log error and return null if var does not exist */
								retval.type = VarChecker.getTypeForVar((ID41!=null?ID41.getText():null), symTable, ID41.getToken(), errors);
								retval.token = ID41.getToken();

								/* var exists, but type is no good for this arithmetic */
								if (retval.type != null && !retval.type.isValidInIndexArithmetic()) {
									errors.add(
										new SemanticError(ID41.getToken(),
										"values of type " + retval.type + " are not allowed in index expression (only type 'int' is accepted)"));
									retval.type = null;
								}
							
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "index_expr"



	// $ANTLR start "index_expr_op"
	// cs4240_team1/SymTableWalker.g:542:1: index_expr_op : ( '+' | '-' | '*' );
	public final void index_expr_op() throws RecognitionException {
		try {
			// cs4240_team1/SymTableWalker.g:542:14: ( '+' | '-' | '*' )
			// cs4240_team1/SymTableWalker.g:
			{
			if ( (input.LA(1) >= MINUS && input.LA(1) <= MULT)||input.LA(1)==PLUS ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "index_expr_op"

	// Delegated rules



	public static final BitSet FOLLOW_tiger_program_in_walk58 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_walk60 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PROGRAM_in_tiger_program78 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_type_declaration_list_in_tiger_program80 = new BitSet(new long[]{0x0001000010000000L});
	public static final BitSet FOLLOW_funct_declaration_in_tiger_program83 = new BitSet(new long[]{0x0001000010000000L});
	public static final BitSet FOLLOW_main_function_in_tiger_program87 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_FUNCTION_in_funct_declaration113 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ret_type_in_funct_declaration115 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_ID_in_funct_declaration117 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_param_list_in_funct_declaration119 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_block_list_in_funct_declaration125 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_VOID_in_ret_type150 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_ret_type160 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_ret_type170 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FIXEDPT_in_ret_type180 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MAINSCOPE_in_main_function208 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_block_list_in_main_function210 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PARAMLIST_in_param_list233 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_param_in_param_list235 = new BitSet(new long[]{0x0000000100000008L});
	public static final BitSet FOLLOW_ID_in_param259 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_type_id_in_param261 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BLOCKLIST_in_block_list292 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_block_in_block_list295 = new BitSet(new long[]{0x0000000000000208L});
	public static final BitSet FOLLOW_BLOCKSCOPE_in_block330 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_type_declaration_list_in_block332 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_var_declaration_list_in_block335 = new BitSet(new long[]{0x0400000424000640L,0x0000000000000100L});
	public static final BitSet FOLLOW_stat_seq_in_block338 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_TYPEDECLLIST_in_type_declaration_list361 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_type_declaration_in_type_declaration_list363 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000002L});
	public static final BitSet FOLLOW_VARDECLLIST_in_var_declaration_list385 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_var_declaration_in_var_declaration_list387 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000010L});
	public static final BitSet FOLLOW_TYPEDECL_in_type_declaration409 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_type_declaration411 = new BitSet(new long[]{0x0000002001000020L});
	public static final BitSet FOLLOW_type_in_type_declaration413 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_base_type_in_type442 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARRAY_in_type455 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_base_type_in_type457 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_INTLIT_in_type461 = new BitSet(new long[]{0x0000004000000008L});
	public static final BitSet FOLLOW_INTLIT_in_type465 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_INT_in_base_type490 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FIXEDPT_in_base_type500 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_var_declaration530 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_type_id_in_var_declaration532 = new BitSet(new long[]{0x0000000200000040L});
	public static final BitSet FOLLOW_optional_init_in_var_declaration535 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_id_list_in_var_declaration541 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_base_type_in_type_id564 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_type_id574 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDLIST_in_id_list595 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_id_list598 = new BitSet(new long[]{0x0000000100000008L});
	public static final BitSet FOLLOW_ASSIGN_in_optional_init627 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_literal_in_optional_init629 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_stat_in_stat_seq657 = new BitSet(new long[]{0x0400000424000642L,0x0000000000000100L});
	public static final BitSet FOLLOW_function_call_in_stat694 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assignment_in_stat705 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_stat717 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_stat719 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_THEN_STATS_in_stat723 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_stat_seq_in_stat727 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ELSE_STATS_in_stat735 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_stat_seq_in_stat739 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_WHILE_in_stat759 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_stat761 = new BitSet(new long[]{0x0400000424000640L,0x0000000000000100L});
	public static final BitSet FOLLOW_stat_seq_in_stat764 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_FOR_in_stat777 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_stat779 = new BitSet(new long[]{0x0086004100000000L});
	public static final BitSet FOLLOW_index_expr_in_stat783 = new BitSet(new long[]{0x0086004100000000L});
	public static final BitSet FOLLOW_index_expr_in_stat786 = new BitSet(new long[]{0x0400000424000640L,0x0000000000000100L});
	public static final BitSet FOLLOW_stat_seq_in_stat789 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BREAK_in_stat807 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RETURN_in_stat820 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_stat822 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_block_in_stat836 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ASSIGN_in_assignment858 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_value_in_assignment860 = new BitSet(new long[]{0x00AE1841E2408010L});
	public static final BitSet FOLLOW_expr_in_assignment868 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_function_call_in_assignment878 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_FUNCTION_CALL_in_function_call920 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_function_call922 = new BitSet(new long[]{0x0000000000800008L});
	public static final BitSet FOLLOW_function_args_in_function_call929 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_EXPRLIST_in_function_args967 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_function_args970 = new BitSet(new long[]{0x00AE1841C2408018L});
	public static final BitSet FOLLOW_logical_op_in_expr1011 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr1015 = new BitSet(new long[]{0x00AE1841C2408010L});
	public static final BitSet FOLLOW_expr_in_expr1020 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_comparison_op_in_expr1042 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr1046 = new BitSet(new long[]{0x00AE1841C2408010L});
	public static final BitSet FOLLOW_expr_in_expr1051 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_arithmetic_op_in_expr1073 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr1077 = new BitSet(new long[]{0x00AE1841C2408010L});
	public static final BitSet FOLLOW_expr_in_expr1082 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_value_in_expr1095 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_literal_in_expr1106 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_value1193 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_value_tail_in_value1197 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_INTLIT_in_literal1225 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FIXEDPTLIT_in_literal1237 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_index_expr_in_value_tail1264 = new BitSet(new long[]{0x0086004100000002L});
	public static final BitSet FOLLOW_index_expr_in_value_tail1271 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_index_expr_op_in_index_expr1299 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_index_expr_in_index_expr1303 = new BitSet(new long[]{0x0086004100000000L});
	public static final BitSet FOLLOW_index_expr_in_index_expr1308 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_INTLIT_in_index_expr1320 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_index_expr1330 = new BitSet(new long[]{0x0000000000000002L});
}
