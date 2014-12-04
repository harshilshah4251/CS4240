// $ANTLR 3.5.2 cs4240_team1/IRCodeWalker.g 2014-12-04 08:35:49

    package cs4240_team1;

    import java.util.ArrayList;
    import java.util.List;
    import java.util.Stack;
    import utility.Utility;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class IRCodeWalker extends TreeParser {
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


	public IRCodeWalker(TreeNodeStream input) {
		this(input, new RecognizerSharedState());
	}
	public IRCodeWalker(TreeNodeStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return IRCodeWalker.tokenNames; }
	@Override public String getGrammarFileName() { return "cs4240_team1/IRCodeWalker.g"; }



	    /* we will populate the tempSymbolTable within Generation */
		Generation g = new Generation();

		/* this needs to be populated from the previous step in TigerMain.*/
	    SymbolTable globalSymbolTable;


	    /**
	     * This stack is used to manage the traversal of the symbol tables
	     * as we generate the IR code.
	     */
	    Stack<SymbolTable> scopeStack = new Stack();



	// $ANTLR start "walk"
	// cs4240_team1/IRCodeWalker.g:33:1: walk : tiger_program EOF ;
	public final void walk() throws RecognitionException {
		try {
			// cs4240_team1/IRCodeWalker.g:34:5: ( tiger_program EOF )
			// cs4240_team1/IRCodeWalker.g:34:7: tiger_program EOF
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
	// cs4240_team1/IRCodeWalker.g:37:1: tiger_program : ^( PROGRAM type_declaration_list[currTable] ( funct_declaration )* main_function ) ;
	public final void tiger_program() throws RecognitionException {

			SymbolTable currTable = globalSymbolTable;
			/* push the global symbol table's children to kick off the recursion!*/
			scopeStack.addAll(Utility.reverseList(globalSymbolTable.getChildren()));
			
		try {
			// cs4240_team1/IRCodeWalker.g:43:5: ( ^( PROGRAM type_declaration_list[currTable] ( funct_declaration )* main_function ) )
			// cs4240_team1/IRCodeWalker.g:43:7: ^( PROGRAM type_declaration_list[currTable] ( funct_declaration )* main_function )
			{
			match(input,PROGRAM,FOLLOW_PROGRAM_in_tiger_program84); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_type_declaration_list_in_tiger_program86);
			type_declaration_list(currTable);
			state._fsp--;

			// cs4240_team1/IRCodeWalker.g:43:50: ( funct_declaration )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==FUNCTION) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// cs4240_team1/IRCodeWalker.g:43:50: funct_declaration
					{
					pushFollow(FOLLOW_funct_declaration_in_tiger_program89);
					funct_declaration();
					state._fsp--;

					}
					break;

				default :
					break loop1;
				}
			}

			pushFollow(FOLLOW_main_function_in_tiger_program92);
			main_function();
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
	// cs4240_team1/IRCodeWalker.g:46:1: funct_declaration : ^( FUNCTION ret_type ID param_list[parameters] block_list ) ;
	public final void funct_declaration() throws RecognitionException {
		CommonTree ID1=null;


				SymbolTable currTable = scopeStack.pop();	
				scopeStack.addAll(Utility.reverseList(currTable.getChildren()));
				//[CB 11/5/15] I think parameters is supposed to be modified by the kids.
		    	List<Parameter> parameters = new ArrayList<>();
			
		try {
			// cs4240_team1/IRCodeWalker.g:53:5: ( ^( FUNCTION ret_type ID param_list[parameters] block_list ) )
			// cs4240_team1/IRCodeWalker.g:53:7: ^( FUNCTION ret_type ID param_list[parameters] block_list )
			{
			match(input,FUNCTION,FOLLOW_FUNCTION_in_funct_declaration116); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_ret_type_in_funct_declaration118);
			ret_type();
			state._fsp--;

			ID1=(CommonTree)match(input,ID,FOLLOW_ID_in_funct_declaration120); 

						g.emit(Op.LABEL, new LabelArgument((ID1!=null?ID1.getText():null)));
					
			pushFollow(FOLLOW_param_list_in_funct_declaration124);
			param_list(parameters);
			state._fsp--;

			pushFollow(FOLLOW_block_list_in_funct_declaration127);
			block_list();
			state._fsp--;

			match(input, Token.UP, null); 


						if (currTable.returnType.isVoid()) {
							g.emit(Op.RETURN, new IRCodeArgument[0]);
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
	// cs4240_team1/IRCodeWalker.g:62:1: ret_type returns [String text] : ( VOID | ID | INT | FIXEDPT );
	public final String ret_type() throws RecognitionException {
		String text = null;


		CommonTree VOID2=null;
		CommonTree ID3=null;
		CommonTree INT4=null;
		CommonTree FIXEDPT5=null;

		try {
			// cs4240_team1/IRCodeWalker.g:63:5: ( VOID | ID | INT | FIXEDPT )
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
					// cs4240_team1/IRCodeWalker.g:63:7: VOID
					{
					VOID2=(CommonTree)match(input,VOID,FOLLOW_VOID_in_ret_type151); 
					text = (VOID2!=null?VOID2.getText():null);
					}
					break;
				case 2 :
					// cs4240_team1/IRCodeWalker.g:64:7: ID
					{
					ID3=(CommonTree)match(input,ID,FOLLOW_ID_in_ret_type161); 
					text = (ID3!=null?ID3.getText():null);
					}
					break;
				case 3 :
					// cs4240_team1/IRCodeWalker.g:65:7: INT
					{
					INT4=(CommonTree)match(input,INT,FOLLOW_INT_in_ret_type171); 
					text = (INT4!=null?INT4.getText():null);
					}
					break;
				case 4 :
					// cs4240_team1/IRCodeWalker.g:66:7: FIXEDPT
					{
					FIXEDPT5=(CommonTree)match(input,FIXEDPT,FOLLOW_FIXEDPT_in_ret_type181); 
					text = (FIXEDPT5!=null?FIXEDPT5.getText():null);
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
	// cs4240_team1/IRCodeWalker.g:69:1: main_function : ^( MAINSCOPE block_list ) ;
	public final void main_function() throws RecognitionException {

				g.emit(Op.LABEL, new LabelArgument("main"));
				SymbolTable currTable = scopeStack.pop();	

				scopeStack.addAll(Utility.reverseList(currTable.getChildren()));
			
		try {
			// cs4240_team1/IRCodeWalker.g:76:5: ( ^( MAINSCOPE block_list ) )
			// cs4240_team1/IRCodeWalker.g:76:7: ^( MAINSCOPE block_list )
			{
			match(input,MAINSCOPE,FOLLOW_MAINSCOPE_in_main_function209); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_block_list_in_main_function211);
			block_list();
			state._fsp--;

			match(input, Token.UP, null); 


						g.emit(Op.RETURN, new IRCodeArgument[0]);
			    	
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
	// cs4240_team1/IRCodeWalker.g:82:1: param_list[List<Parameter> parameters] : ^( PARAMLIST ( param[parameters] )* ) ;
	public final void param_list(List<Parameter> parameters) throws RecognitionException {
		try {
			// cs4240_team1/IRCodeWalker.g:83:5: ( ^( PARAMLIST ( param[parameters] )* ) )
			// cs4240_team1/IRCodeWalker.g:83:7: ^( PARAMLIST ( param[parameters] )* )
			{
			match(input,PARAMLIST,FOLLOW_PARAMLIST_in_param_list235); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// cs4240_team1/IRCodeWalker.g:83:19: ( param[parameters] )*
				loop3:
				while (true) {
					int alt3=2;
					int LA3_0 = input.LA(1);
					if ( (LA3_0==ID) ) {
						alt3=1;
					}

					switch (alt3) {
					case 1 :
						// cs4240_team1/IRCodeWalker.g:83:19: param[parameters]
						{
						pushFollow(FOLLOW_param_in_param_list237);
						param(parameters);
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
	// cs4240_team1/IRCodeWalker.g:86:1: param[List<Parameter> parameters] : ^( ID type_id ) ;
	public final void param(List<Parameter> parameters) throws RecognitionException {
		try {
			// cs4240_team1/IRCodeWalker.g:87:5: ( ^( ID type_id ) )
			// cs4240_team1/IRCodeWalker.g:87:9: ^( ID type_id )
			{
			match(input,ID,FOLLOW_ID_in_param261); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_type_id_in_param263);
			type_id();
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
	// $ANTLR end "param"



	// $ANTLR start "block_list"
	// cs4240_team1/IRCodeWalker.g:90:1: block_list : ^( BLOCKLIST ( block[null] )+ ) ;
	public final void block_list() throws RecognitionException {
		try {
			// cs4240_team1/IRCodeWalker.g:92:5: ( ^( BLOCKLIST ( block[null] )+ ) )
			// cs4240_team1/IRCodeWalker.g:92:7: ^( BLOCKLIST ( block[null] )+ )
			{
			match(input,BLOCKLIST,FOLLOW_BLOCKLIST_in_block_list286); 
			match(input, Token.DOWN, null); 
			// cs4240_team1/IRCodeWalker.g:92:19: ( block[null] )+
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
					// cs4240_team1/IRCodeWalker.g:92:19: block[null]
					{
					pushFollow(FOLLOW_block_in_block_list288);
					block(null);
					state._fsp--;

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
	}
	// $ANTLR end "block_list"



	// $ANTLR start "block"
	// cs4240_team1/IRCodeWalker.g:96:1: block[IRCodeArgument loopExitLabel] : ^( BLOCKSCOPE type_declaration_list[currTable] var_declaration_list[currTable] stat_seq[currTable, loopExitLabel] ) ;
	public final void block(IRCodeArgument loopExitLabel) throws RecognitionException {

				SymbolTable currTable = scopeStack.pop();	
				scopeStack.addAll(Utility.reverseList(currTable.getChildren()));
			
		try {
			// cs4240_team1/IRCodeWalker.g:101:5: ( ^( BLOCKSCOPE type_declaration_list[currTable] var_declaration_list[currTable] stat_seq[currTable, loopExitLabel] ) )
			// cs4240_team1/IRCodeWalker.g:101:7: ^( BLOCKSCOPE type_declaration_list[currTable] var_declaration_list[currTable] stat_seq[currTable, loopExitLabel] )
			{
			match(input,BLOCKSCOPE,FOLLOW_BLOCKSCOPE_in_block319); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_type_declaration_list_in_block321);
			type_declaration_list(currTable);
			state._fsp--;

			pushFollow(FOLLOW_var_declaration_list_in_block324);
			var_declaration_list(currTable);
			state._fsp--;

			pushFollow(FOLLOW_stat_seq_in_block327);
			stat_seq(currTable, loopExitLabel);
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
	// $ANTLR end "block"



	// $ANTLR start "type_declaration_list"
	// cs4240_team1/IRCodeWalker.g:104:1: type_declaration_list[SymbolTable currTable] : ^( TYPEDECLLIST ( type_declaration )* ) ;
	public final void type_declaration_list(SymbolTable currTable) throws RecognitionException {
		try {
			// cs4240_team1/IRCodeWalker.g:105:5: ( ^( TYPEDECLLIST ( type_declaration )* ) )
			// cs4240_team1/IRCodeWalker.g:105:7: ^( TYPEDECLLIST ( type_declaration )* )
			{
			match(input,TYPEDECLLIST,FOLLOW_TYPEDECLLIST_in_type_declaration_list348); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// cs4240_team1/IRCodeWalker.g:105:22: ( type_declaration )*
				loop5:
				while (true) {
					int alt5=2;
					int LA5_0 = input.LA(1);
					if ( (LA5_0==TYPEDECL) ) {
						alt5=1;
					}

					switch (alt5) {
					case 1 :
						// cs4240_team1/IRCodeWalker.g:105:22: type_declaration
						{
						pushFollow(FOLLOW_type_declaration_in_type_declaration_list350);
						type_declaration();
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
	// cs4240_team1/IRCodeWalker.g:108:1: var_declaration_list[SymbolTable currTable] : ^( VARDECLLIST ( var_declaration[currTable] )* ) ;
	public final void var_declaration_list(SymbolTable currTable) throws RecognitionException {
		try {
			// cs4240_team1/IRCodeWalker.g:109:5: ( ^( VARDECLLIST ( var_declaration[currTable] )* ) )
			// cs4240_team1/IRCodeWalker.g:109:7: ^( VARDECLLIST ( var_declaration[currTable] )* )
			{
			match(input,VARDECLLIST,FOLLOW_VARDECLLIST_in_var_declaration_list371); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// cs4240_team1/IRCodeWalker.g:109:21: ( var_declaration[currTable] )*
				loop6:
				while (true) {
					int alt6=2;
					int LA6_0 = input.LA(1);
					if ( (LA6_0==VAR) ) {
						alt6=1;
					}

					switch (alt6) {
					case 1 :
						// cs4240_team1/IRCodeWalker.g:109:21: var_declaration[currTable]
						{
						pushFollow(FOLLOW_var_declaration_in_var_declaration_list373);
						var_declaration(currTable);
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
	// cs4240_team1/IRCodeWalker.g:112:1: type_declaration : ^( TYPEDECL ID type ) ;
	public final void type_declaration() throws RecognitionException {
		try {
			// cs4240_team1/IRCodeWalker.g:113:5: ( ^( TYPEDECL ID type ) )
			// cs4240_team1/IRCodeWalker.g:113:7: ^( TYPEDECL ID type )
			{
			match(input,TYPEDECL,FOLLOW_TYPEDECL_in_type_declaration394); 
			match(input, Token.DOWN, null); 
			match(input,ID,FOLLOW_ID_in_type_declaration396); 
			pushFollow(FOLLOW_type_in_type_declaration398);
			type();
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
	// $ANTLR end "type_declaration"


	public static class type_return extends TreeRuleReturnScope {
		public String baseTypeId;
		public String dimension1;
		public String dimension2;
	};


	// $ANTLR start "type"
	// cs4240_team1/IRCodeWalker.g:116:1: type returns [String baseTypeId, String dimension1, String dimension2] : ( base_type | ^( ARRAY base_type dim1= INTLIT (dim2= INTLIT )? ) );
	public final IRCodeWalker.type_return type() throws RecognitionException {
		IRCodeWalker.type_return retval = new IRCodeWalker.type_return();
		retval.start = input.LT(1);

		CommonTree dim1=null;
		CommonTree dim2=null;

		try {
			// cs4240_team1/IRCodeWalker.g:117:5: ( base_type | ^( ARRAY base_type dim1= INTLIT (dim2= INTLIT )? ) )
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
					// cs4240_team1/IRCodeWalker.g:117:9: base_type
					{
					pushFollow(FOLLOW_base_type_in_type423);
					base_type();
					state._fsp--;

					}
					break;
				case 2 :
					// cs4240_team1/IRCodeWalker.g:118:9: ^( ARRAY base_type dim1= INTLIT (dim2= INTLIT )? )
					{
					match(input,ARRAY,FOLLOW_ARRAY_in_type435); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_base_type_in_type437);
					base_type();
					state._fsp--;

					dim1=(CommonTree)match(input,INTLIT,FOLLOW_INTLIT_in_type441); 
					// cs4240_team1/IRCodeWalker.g:118:43: (dim2= INTLIT )?
					int alt7=2;
					int LA7_0 = input.LA(1);
					if ( (LA7_0==INTLIT) ) {
						alt7=1;
					}
					switch (alt7) {
						case 1 :
							// cs4240_team1/IRCodeWalker.g:118:43: dim2= INTLIT
							{
							dim2=(CommonTree)match(input,INTLIT,FOLLOW_INTLIT_in_type445); 
							}
							break;

					}

					match(input, Token.UP, null); 

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
	// cs4240_team1/IRCodeWalker.g:121:1: base_type returns [String text] : ( INT | FIXEDPT );
	public final String base_type() throws RecognitionException {
		String text = null;


		try {
			// cs4240_team1/IRCodeWalker.g:122:5: ( INT | FIXEDPT )
			// cs4240_team1/IRCodeWalker.g:
			{
			if ( input.LA(1)==FIXEDPT||input.LA(1)==INT ) {
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
		return text;
	}
	// $ANTLR end "base_type"



	// $ANTLR start "var_declaration"
	// cs4240_team1/IRCodeWalker.g:127:1: var_declaration[SymbolTable currTable] : ^( VAR type_id (e1= optional_init )? id_list[currTable, $type_id.text, initValue] ) ;
	public final void var_declaration(SymbolTable currTable) throws RecognitionException {
		IRCodeArgument e1 =null;
		String type_id6 =null;

		try {
			// cs4240_team1/IRCodeWalker.g:128:5: ( ^( VAR type_id (e1= optional_init )? id_list[currTable, $type_id.text, initValue] ) )
			// cs4240_team1/IRCodeWalker.g:129:6: ^( VAR type_id (e1= optional_init )? id_list[currTable, $type_id.text, initValue] )
			{
			IRCodeArgument initValue = null;
			match(input,VAR,FOLLOW_VAR_in_var_declaration514); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_type_id_in_var_declaration516);
			type_id6=type_id();
			state._fsp--;

			// cs4240_team1/IRCodeWalker.g:130:21: (e1= optional_init )?
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==ASSIGN) ) {
				alt9=1;
			}
			switch (alt9) {
				case 1 :
					// cs4240_team1/IRCodeWalker.g:130:22: e1= optional_init
					{
					pushFollow(FOLLOW_optional_init_in_var_declaration521);
					e1=optional_init();
					state._fsp--;


					    //g.emit(new IRComment("***var definition activated***"));
					     initValue = e1;
					}
					break;

			}

			pushFollow(FOLLOW_id_list_in_var_declaration539);
			id_list(currTable, type_id6, initValue);
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
	// cs4240_team1/IRCodeWalker.g:138:1: type_id returns [String text] : ( base_type | ID );
	public final String type_id() throws RecognitionException {
		String text = null;


		try {
			// cs4240_team1/IRCodeWalker.g:139:5: ( base_type | ID )
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==FIXEDPT||LA10_0==INT) ) {
				alt10=1;
			}
			else if ( (LA10_0==ID) ) {
				alt10=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}

			switch (alt10) {
				case 1 :
					// cs4240_team1/IRCodeWalker.g:139:7: base_type
					{
					pushFollow(FOLLOW_base_type_in_type_id568);
					base_type();
					state._fsp--;

					}
					break;
				case 2 :
					// cs4240_team1/IRCodeWalker.g:140:7: ID
					{
					match(input,ID,FOLLOW_ID_in_type_id577); 
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
	// cs4240_team1/IRCodeWalker.g:143:1: id_list[SymbolTable currTable, String typeId, IRCodeArgument initValue] : ^( IDLIST ( ID )+ ) ;
	public final void id_list(SymbolTable currTable, String typeId, IRCodeArgument initValue) throws RecognitionException {
		CommonTree ID7=null;

		try {
			// cs4240_team1/IRCodeWalker.g:144:5: ( ^( IDLIST ( ID )+ ) )
			// cs4240_team1/IRCodeWalker.g:144:7: ^( IDLIST ( ID )+ )
			{
			match(input,IDLIST,FOLLOW_IDLIST_in_id_list597); 
			match(input, Token.DOWN, null); 
			// cs4240_team1/IRCodeWalker.g:144:16: ( ID )+
			int cnt11=0;
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==ID) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// cs4240_team1/IRCodeWalker.g:144:17: ID
					{
					ID7=(CommonTree)match(input,ID,FOLLOW_ID_in_id_list600); 
					if(initValue!=null) {
					        VarEntry varEntry = (VarEntry) currTable.lookup((ID7!=null?ID7.getText():null));
					        TigerType checkArr = varEntry.type;
					        if (checkArr.isArray()) {
					            VarEntry outStore = g.newTemp(TigerType.LITERAL_INT_TYPE);
					            if (checkArr.isArray1D()) {
					                g.emit(Op.ASSIGNARR, varEntry, new LiteralArgument(checkArr.dimension1.toString(), TigerType.LITERAL_INT_TYPE), initValue);
					            } else {
					                g.emit(Op.MULT, new LiteralArgument(checkArr.dimension1.toString(), TigerType.LITERAL_INT_TYPE),new LiteralArgument(checkArr.dimension2.toString(), TigerType.LITERAL_INT_TYPE), outStore);
					            g.emit(Op.ASSIGNARR, varEntry, outStore, initValue);
					            }
					        } else {
					            g.emit(Op.ASSIGNVAR, varEntry, initValue);
					        }
					    }
					}
					break;

				default :
					if ( cnt11 >= 1 ) break loop11;
					EarlyExitException eee = new EarlyExitException(11, input);
					throw eee;
				}
				cnt11++;
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
	// cs4240_team1/IRCodeWalker.g:164:1: optional_init returns [IRCodeArgument outArg] : ^( ':=' literal ) ;
	public final IRCodeArgument optional_init() throws RecognitionException {
		IRCodeArgument outArg = null;


		IRCodeArgument literal8 =null;

		try {
			// cs4240_team1/IRCodeWalker.g:165:5: ( ^( ':=' literal ) )
			// cs4240_team1/IRCodeWalker.g:165:9: ^( ':=' literal )
			{
			match(input,ASSIGN,FOLLOW_ASSIGN_in_optional_init640); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_literal_in_optional_init642);
			literal8=literal();
			state._fsp--;

			match(input, Token.UP, null); 


			        outArg = literal8; 
			    
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return outArg;
	}
	// $ANTLR end "optional_init"



	// $ANTLR start "stat_seq"
	// cs4240_team1/IRCodeWalker.g:171:1: stat_seq[SymbolTable currTable, IRCodeArgument loopExitLabel] : ( stat[currTable, loopExitLabel] )+ ;
	public final void stat_seq(SymbolTable currTable, IRCodeArgument loopExitLabel) throws RecognitionException {
		try {
			// cs4240_team1/IRCodeWalker.g:172:5: ( ( stat[currTable, loopExitLabel] )+ )
			// cs4240_team1/IRCodeWalker.g:172:7: ( stat[currTable, loopExitLabel] )+
			{
			// cs4240_team1/IRCodeWalker.g:172:7: ( stat[currTable, loopExitLabel] )+
			int cnt12=0;
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( (LA12_0==ASSIGN||(LA12_0 >= BLOCKSCOPE && LA12_0 <= BREAK)||LA12_0==FOR||LA12_0==FUNCTION_CALL||LA12_0==IF||LA12_0==RETURN||LA12_0==WHILE) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// cs4240_team1/IRCodeWalker.g:172:7: stat[currTable, loopExitLabel]
					{
					pushFollow(FOLLOW_stat_in_stat_seq665);
					stat(currTable, loopExitLabel);
					state._fsp--;

					}
					break;

				default :
					if ( cnt12 >= 1 ) break loop12;
					EarlyExitException eee = new EarlyExitException(12, input);
					throw eee;
				}
				cnt12++;
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
	// $ANTLR end "stat_seq"



	// $ANTLR start "stat"
	// cs4240_team1/IRCodeWalker.g:178:1: stat[SymbolTable currTable, IRCodeArgument loopExitLabel] : ( function_call[currTable,false] | assignment[currTable] | ^( IF bool_expr[currTable, falseTarget, trueTarget, falseTarget, true] ^( THEN_STATS stat_seq[currTable,loopExitLabel] ) ( ^( ELSE_STATS stat_seq[currTable,loopExitLabel] ) )? ) | ^( WHILE bool_expr[currTable, doneLabel, bodyLabel, doneLabel, true] stat_seq[currTable, doneLabel] ) | ^( FOR ID i1= index_expr[currTable] (i2= index_expr[currTable] ) ( stat_seq[currTable, doneLabel] ) ) | BREAK | ^( RETURN expr[currTable] ) | block[loopExitLabel] );
	public final void stat(SymbolTable currTable, IRCodeArgument loopExitLabel) throws RecognitionException {
		CommonTree IF9=null;
		CommonTree WHILE10=null;
		CommonTree ID11=null;
		IRCodeArgument i1 =null;
		IRCodeArgument i2 =null;
		IRCodeArgument expr12 =null;

		try {
			// cs4240_team1/IRCodeWalker.g:179:5: ( function_call[currTable,false] | assignment[currTable] | ^( IF bool_expr[currTable, falseTarget, trueTarget, falseTarget, true] ^( THEN_STATS stat_seq[currTable,loopExitLabel] ) ( ^( ELSE_STATS stat_seq[currTable,loopExitLabel] ) )? ) | ^( WHILE bool_expr[currTable, doneLabel, bodyLabel, doneLabel, true] stat_seq[currTable, doneLabel] ) | ^( FOR ID i1= index_expr[currTable] (i2= index_expr[currTable] ) ( stat_seq[currTable, doneLabel] ) ) | BREAK | ^( RETURN expr[currTable] ) | block[loopExitLabel] )
			int alt14=8;
			switch ( input.LA(1) ) {
			case FUNCTION_CALL:
				{
				alt14=1;
				}
				break;
			case ASSIGN:
				{
				alt14=2;
				}
				break;
			case IF:
				{
				alt14=3;
				}
				break;
			case WHILE:
				{
				alt14=4;
				}
				break;
			case FOR:
				{
				alt14=5;
				}
				break;
			case BREAK:
				{
				alt14=6;
				}
				break;
			case RETURN:
				{
				alt14=7;
				}
				break;
			case BLOCKSCOPE:
				{
				alt14=8;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 14, 0, input);
				throw nvae;
			}
			switch (alt14) {
				case 1 :
					// cs4240_team1/IRCodeWalker.g:179:9: function_call[currTable,false]
					{
					pushFollow(FOLLOW_function_call_in_stat691);
					function_call(currTable, false);
					state._fsp--;

					}
					break;
				case 2 :
					// cs4240_team1/IRCodeWalker.g:180:9: assignment[currTable]
					{
					pushFollow(FOLLOW_assignment_in_stat702);
					assignment(currTable);
					state._fsp--;

					}
					break;
				case 3 :
					// cs4240_team1/IRCodeWalker.g:181:7: ^( IF bool_expr[currTable, falseTarget, trueTarget, falseTarget, true] ^( THEN_STATS stat_seq[currTable,loopExitLabel] ) ( ^( ELSE_STATS stat_seq[currTable,loopExitLabel] ) )? )
					{

								boolean hasElseStats;  /* if true, we need a goto endIf target */
								boolean hasShortCircuit;  /* if true, we may need a true target */
								LabelArgument trueTarget = null;
								LabelArgument falseTarget;
								LabelArgument endTarget;  /* only used for if-then-else */
							
					IF9=(CommonTree)match(input,IF,FOLLOW_IF_in_stat716); 

								hasElseStats = IF9.getChildCount() == 3;
								String boolOperator = IF9.getChild(0).getText();
								hasShortCircuit = "&".equals(boolOperator) || "|".equals(boolOperator);
								if (hasShortCircuit) {
									trueTarget = g.newLabel1();
								}
								falseTarget = g.newLabel1();
								endTarget = (hasElseStats) ? g.newLabel1() : falseTarget;
							
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_bool_expr_in_stat724);
					bool_expr(currTable, falseTarget, trueTarget, falseTarget, true);
					state._fsp--;

					match(input,THEN_STATS,FOLLOW_THEN_STATS_in_stat731); 

									if (trueTarget != null) {
										g.emit(Op.LABEL, trueTarget);
									}
								
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_stat_seq_in_stat735);
					stat_seq(currTable, loopExitLabel);
					state._fsp--;

					match(input, Token.UP, null); 


									if (hasElseStats) {
										g.emit(Op.GOTO, endTarget);
									}
									g.emit(Op.LABEL, falseTarget);
								
					// cs4240_team1/IRCodeWalker.g:209:4: ( ^( ELSE_STATS stat_seq[currTable,loopExitLabel] ) )?
					int alt13=2;
					int LA13_0 = input.LA(1);
					if ( (LA13_0==ELSE_STATS) ) {
						alt13=1;
					}
					switch (alt13) {
						case 1 :
							// cs4240_team1/IRCodeWalker.g:209:5: ^( ELSE_STATS stat_seq[currTable,loopExitLabel] )
							{
							match(input,ELSE_STATS,FOLLOW_ELSE_STATS_in_stat746); 
							match(input, Token.DOWN, null); 
							pushFollow(FOLLOW_stat_seq_in_stat748);
							stat_seq(currTable, loopExitLabel);
							state._fsp--;


											g.emit(Op.LABEL, endTarget);
										
							match(input, Token.UP, null); 

							}
							break;

					}

					match(input, Token.UP, null); 

					}
					break;
				case 4 :
					// cs4240_team1/IRCodeWalker.g:212:7: ^( WHILE bool_expr[currTable, doneLabel, bodyLabel, doneLabel, true] stat_seq[currTable, doneLabel] )
					{

					            LabelArgument loopBeginLabel = g.newLabel1();
								LabelArgument bodyLabel = null;  /* may be need in case of short-circuiting (if there are ORs) */
					            LabelArgument doneLabel = g.newLabel1();
					    	    g.emit(Op.LABEL, loopBeginLabel); 
					        
					WHILE10=(CommonTree)match(input,WHILE,FOLLOW_WHILE_in_stat774); 

								String boolOperator = WHILE10.getChild(0).getText();
								if ("&".equals(boolOperator) || "|".equals(boolOperator)) {
									bodyLabel = g.newLabel1();
								}
							
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_bool_expr_in_stat778);
					bool_expr(currTable, doneLabel, bodyLabel, doneLabel, true);
					state._fsp--;


								if (bodyLabel != null) {  /* short-circuting, so may need a body label */
									g.emit(Op.LABEL, bodyLabel);
								}
							
					pushFollow(FOLLOW_stat_seq_in_stat783);
					stat_seq(currTable, doneLabel);
					state._fsp--;


					            g.emit(Op.GOTO, loopBeginLabel);
					    	    g.emit(Op.LABEL, doneLabel); 
					        
					match(input, Token.UP, null); 

					}
					break;
				case 5 :
					// cs4240_team1/IRCodeWalker.g:233:9: ^( FOR ID i1= index_expr[currTable] (i2= index_expr[currTable] ) ( stat_seq[currTable, doneLabel] ) )
					{

					            LabelArgument loopBeginLabel = g.newLabel1();
					            LabelArgument doneLabel = g.newLabel1();
					            VarEntry counter = g.newTemp(TigerType.BASE_INT_TYPE);
					            IRCodeArgument start= i1;
					        
					match(input,FOR,FOLLOW_FOR_in_stat822); 
					match(input, Token.DOWN, null); 
					ID11=(CommonTree)match(input,ID,FOLLOW_ID_in_stat824); 
					pushFollow(FOLLOW_index_expr_in_stat828);
					i1=index_expr(currTable);
					state._fsp--;

					// cs4240_team1/IRCodeWalker.g:240:6: (i2= index_expr[currTable] )
					// cs4240_team1/IRCodeWalker.g:240:7: i2= index_expr[currTable]
					{
					pushFollow(FOLLOW_index_expr_in_stat840);
					i2=index_expr(currTable);
					state._fsp--;


							  /* note: current algorithm allows user to write to indexVar
							   * without affecting loop iterations
					           */
							  VarEntry indexVar = (VarEntry) currTable.lookup((ID11!=null?ID11.getText():null));
					          VarEntry stopCount = g.newTemp(TigerType.BASE_INT_TYPE); //stopCount tells you when to stop the loop.

					          g.emit(Op.ASSIGNVAR, stopCount, i2);
					    	  g.emit(Op.ASSIGNVAR,counter ,i1); //counter starts at the lower bound, counts up to stopCount
					    	  g.emit(Op.LABEL, loopBeginLabel); 
					          g.emit(Op.BRGT, counter, stopCount, doneLabel);
							  g.emit(Op.ASSIGNVAR, indexVar, counter);
					          g.emit(Op.ADD, counter, new LiteralArgument("1",TigerType.LITERAL_INT_TYPE), counter);
					       
					}

					// cs4240_team1/IRCodeWalker.g:255:8: ( stat_seq[currTable, doneLabel] )
					// cs4240_team1/IRCodeWalker.g:255:9: stat_seq[currTable, doneLabel]
					{
					pushFollow(FOLLOW_stat_seq_in_stat860);
					stat_seq(currTable, doneLabel);
					state._fsp--;


					            g.emit(Op.GOTO, loopBeginLabel);
					    	    g.emit(Op.LABEL, doneLabel); 
					        
					}

					match(input, Token.UP, null); 

					}
					break;
				case 6 :
					// cs4240_team1/IRCodeWalker.g:262:9: BREAK
					{
					match(input,BREAK,FOLLOW_BREAK_in_stat895); 

					        g.emit(Op.GOTO, loopExitLabel); 
					    
					}
					break;
				case 7 :
					// cs4240_team1/IRCodeWalker.g:265:9: ^( RETURN expr[currTable] )
					{
					match(input,RETURN,FOLLOW_RETURN_in_stat908); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_stat910);
					expr12=expr(currTable);
					state._fsp--;

					match(input, Token.UP, null); 


								g.emit(Op.RETURN, expr12);
							
					}
					break;
				case 8 :
					// cs4240_team1/IRCodeWalker.g:270:9: block[loopExitLabel]
					{
					pushFollow(FOLLOW_block_in_stat930);
					block(loopExitLabel);
					state._fsp--;

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
	}
	// $ANTLR end "stat"



	// $ANTLR start "assignment"
	// cs4240_team1/IRCodeWalker.g:273:1: assignment[SymbolTable currTable] returns [IRCodeArgument outArg] : ^( ':=' ^( ID ( value_tail[currTable, $ID.text] )? ) (res= expr[currTable] |res= function_call[currTable,true] ) ) ;
	public final IRCodeArgument assignment(SymbolTable currTable) throws RecognitionException {
		IRCodeArgument outArg = null;


		CommonTree ID13=null;
		IRCodeArgument res =null;
		IRCodeArgument value_tail14 =null;


		    boolean has_tail = false;

		try {
			// cs4240_team1/IRCodeWalker.g:277:5: ( ^( ':=' ^( ID ( value_tail[currTable, $ID.text] )? ) (res= expr[currTable] |res= function_call[currTable,true] ) ) )
			// cs4240_team1/IRCodeWalker.g:277:7: ^( ':=' ^( ID ( value_tail[currTable, $ID.text] )? ) (res= expr[currTable] |res= function_call[currTable,true] ) )
			{
			match(input,ASSIGN,FOLLOW_ASSIGN_in_assignment959); 
			match(input, Token.DOWN, null); 
			ID13=(CommonTree)match(input,ID,FOLLOW_ID_in_assignment962); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// cs4240_team1/IRCodeWalker.g:277:19: ( value_tail[currTable, $ID.text] )?
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( (LA15_0==ID||LA15_0==INTLIT||(LA15_0 >= MINUS && LA15_0 <= MULT)||LA15_0==PLUS) ) {
					alt15=1;
				}
				switch (alt15) {
					case 1 :
						// cs4240_team1/IRCodeWalker.g:277:20: value_tail[currTable, $ID.text]
						{
						pushFollow(FOLLOW_value_tail_in_assignment965);
						value_tail14=value_tail(currTable, (ID13!=null?ID13.getText():null));
						state._fsp--;

						has_tail = true;
						}
						break;

				}

				match(input, Token.UP, null); 
			}

			// cs4240_team1/IRCodeWalker.g:277:74: (res= expr[currTable] |res= function_call[currTable,true] )
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0==DIV||LA16_0==FIXEDPTLIT||LA16_0==ID||LA16_0==INTLIT||(LA16_0 >= MINUS && LA16_0 <= MULT)||LA16_0==PLUS) ) {
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
					// cs4240_team1/IRCodeWalker.g:277:75: res= expr[currTable]
					{
					pushFollow(FOLLOW_expr_in_assignment976);
					res=expr(currTable);
					state._fsp--;

					}
					break;
				case 2 :
					// cs4240_team1/IRCodeWalker.g:277:97: res= function_call[currTable,true]
					{
					pushFollow(FOLLOW_function_call_in_assignment983);
					res=function_call(currTable, true);
					state._fsp--;

					}
					break;

			}

			match(input, Token.UP, null); 


			        VarEntry outStore = (VarEntry) currTable.lookup((ID13!=null?ID13.getText():null));
			        if(has_tail) {
			            g.emit(Op.ARRAYSTORE,  outStore, value_tail14, res);
			        } else {
			    	   g.emit(Op.ASSIGNVAR,outStore, res);
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
		return outArg;
	}
	// $ANTLR end "assignment"



	// $ANTLR start "function_call"
	// cs4240_team1/IRCodeWalker.g:287:1: function_call[SymbolTable currTable, boolean fnHasReturn] returns [IRCodeArgument outArg] : ^( FUNCTION_CALL ID ( function_args[currTable] )? ) ;
	public final IRCodeArgument function_call(SymbolTable currTable, boolean fnHasReturn) throws RecognitionException {
		IRCodeArgument outArg = null;


		CommonTree ID16=null;
		List<IRCodeArgument> function_args15 =null;


		    List<IRCodeArgument> callArgs;
		    Boolean hasArgs = false;


		try {
			// cs4240_team1/IRCodeWalker.g:293:5: ( ^( FUNCTION_CALL ID ( function_args[currTable] )? ) )
			// cs4240_team1/IRCodeWalker.g:293:7: ^( FUNCTION_CALL ID ( function_args[currTable] )? )
			{
			match(input,FUNCTION_CALL,FOLLOW_FUNCTION_CALL_in_function_call1016); 
			match(input, Token.DOWN, null); 
			ID16=(CommonTree)match(input,ID,FOLLOW_ID_in_function_call1018); 
			// cs4240_team1/IRCodeWalker.g:293:26: ( function_args[currTable] )?
			int alt17=2;
			int LA17_0 = input.LA(1);
			if ( (LA17_0==EXPRLIST) ) {
				alt17=1;
			}
			switch (alt17) {
				case 1 :
					// cs4240_team1/IRCodeWalker.g:293:27: function_args[currTable]
					{
					pushFollow(FOLLOW_function_args_in_function_call1021);
					function_args15=function_args(currTable);
					state._fsp--;

					hasArgs = true;
					}
					break;

			}

			match(input, Token.UP, null); 


			        outArg = null;
			        callArgs = hasArgs ? function_args15 : new ArrayList<IRCodeArgument>();
			        IRCodeArgument funcEntry = (FunctionEntry) currTable.lookupFunctionIncludingStdLib((ID16!=null?ID16.getText():null));
			        TigerType funcType = funcEntry.getTigerType();
			        VarEntry temp = g.newTemp(funcType);
			        callArgs.add(0, funcEntry);

			        /*[CB 11/9/14] we do not worry about pass-by-value in this phase*/  
			            if(fnHasReturn) {
			                callArgs.add(0, temp);
			                outArg = temp;
			                g.emit(Op.CALLR, callArgs);
			            } else {
			                g.emit(Op.CALL, callArgs);
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
		return outArg;
	}
	// $ANTLR end "function_call"



	// $ANTLR start "function_args"
	// cs4240_team1/IRCodeWalker.g:313:1: function_args[SymbolTable currTable] returns [List<IRCodeArgument> varsToPass] : ^( EXPRLIST (ei= expr[currTable] )+ ) ;
	public final List<IRCodeArgument> function_args(SymbolTable currTable) throws RecognitionException {
		List<IRCodeArgument> varsToPass = null;


		IRCodeArgument ei =null;


		    List<IRCodeArgument> realFnArgs = new ArrayList<IRCodeArgument>();

		try {
			// cs4240_team1/IRCodeWalker.g:317:5: ( ^( EXPRLIST (ei= expr[currTable] )+ ) )
			// cs4240_team1/IRCodeWalker.g:317:7: ^( EXPRLIST (ei= expr[currTable] )+ )
			{
			match(input,EXPRLIST,FOLLOW_EXPRLIST_in_function_args1060); 
			match(input, Token.DOWN, null); 
			// cs4240_team1/IRCodeWalker.g:317:18: (ei= expr[currTable] )+
			int cnt18=0;
			loop18:
			while (true) {
				int alt18=2;
				int LA18_0 = input.LA(1);
				if ( (LA18_0==DIV||LA18_0==FIXEDPTLIT||LA18_0==ID||LA18_0==INTLIT||(LA18_0 >= MINUS && LA18_0 <= MULT)||LA18_0==PLUS) ) {
					alt18=1;
				}

				switch (alt18) {
				case 1 :
					// cs4240_team1/IRCodeWalker.g:317:19: ei= expr[currTable]
					{
					pushFollow(FOLLOW_expr_in_function_args1065);
					ei=expr(currTable);
					state._fsp--;


						realFnArgs.add(ei);
						
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

			varsToPass = realFnArgs;
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return varsToPass;
	}
	// $ANTLR end "function_args"



	// $ANTLR start "bool_expr"
	// cs4240_team1/IRCodeWalker.g:351:1: bool_expr[SymbolTable currTable,\n LabelArgument branchLabel,\n LabelArgument trueLabel,\n LabelArgument falseLabel,\n boolean negate] : ( logical_expr[currTable, trueLabel, falseLabel, null] | compare_expr[currTable, branchLabel, negate] );
	public final void bool_expr(SymbolTable currTable, LabelArgument branchLabel, LabelArgument trueLabel, LabelArgument falseLabel, boolean negate) throws RecognitionException {
		try {
			// cs4240_team1/IRCodeWalker.g:356:2: ( logical_expr[currTable, trueLabel, falseLabel, null] | compare_expr[currTable, branchLabel, negate] )
			int alt19=2;
			int LA19_0 = input.LA(1);
			if ( (LA19_0==AND||LA19_0==OR) ) {
				alt19=1;
			}
			else if ( (LA19_0==EQ||(LA19_0 >= GREATER && LA19_0 <= GREATEREQ)||(LA19_0 >= LESSER && LA19_0 <= LESSEREQ)||LA19_0==NEQ) ) {
				alt19=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 19, 0, input);
				throw nvae;
			}

			switch (alt19) {
				case 1 :
					// cs4240_team1/IRCodeWalker.g:356:4: logical_expr[currTable, trueLabel, falseLabel, null]
					{
					pushFollow(FOLLOW_logical_expr_in_bool_expr1095);
					logical_expr(currTable, trueLabel, falseLabel, null);
					state._fsp--;

					}
					break;
				case 2 :
					// cs4240_team1/IRCodeWalker.g:357:4: compare_expr[currTable, branchLabel, negate]
					{
					pushFollow(FOLLOW_compare_expr_in_bool_expr1101);
					compare_expr(currTable, branchLabel, negate);
					state._fsp--;

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
	}
	// $ANTLR end "bool_expr"



	// $ANTLR start "logical_expr"
	// cs4240_team1/IRCodeWalker.g:361:1: logical_expr[SymbolTable currTable, LabelArgument trueLabel, LabelArgument falseLabel, String rightShortCircuit] : ( ^(op= '&' ( logical_expr[currTable, secondExprLabel, falseLabel, \"&\"] | compare_expr[currTable, falseLabel, true] ) ( logical_expr[currTable, trueLabel, falseLabel, rightShortCircuit] | compare_expr[currTable, secondBranchLabel, secondBranchNegate] ) ) | ^(op= '|' ( logical_expr[currTable, trueLabel, secondExprLabel, \"|\"] | compare_expr[currTable, trueLabel, false] ) ( logical_expr[currTable, trueLabel, falseLabel, rightShortCircuit] | compare_expr[currTable, secondBranchLabel, secondBranchNegate] ) ) );
	public final void logical_expr(SymbolTable currTable, LabelArgument trueLabel, LabelArgument falseLabel, String rightShortCircuit) throws RecognitionException {
		CommonTree op=null;


			String leftChildText;
			LabelArgument secondExprLabel = null;
			LabelArgument secondBranchLabel = null;
			boolean secondBranchNegate;

			if ("&".equals(rightShortCircuit)) {
				secondBranchLabel = falseLabel;  /* follow "&" short circuit policy */
				secondBranchNegate = true;
			} else if ("|".equals(rightShortCircuit)) {
				secondBranchLabel = trueLabel;  /* follow "|" short circuit policy */
				secondBranchNegate = false;
			} else {  /* equals null */
				secondBranchLabel = falseLabel;  /* policy for the right-most conditional (the last executed one) */
				secondBranchNegate = true;
			}


		try {
			// cs4240_team1/IRCodeWalker.g:380:2: ( ^(op= '&' ( logical_expr[currTable, secondExprLabel, falseLabel, \"&\"] | compare_expr[currTable, falseLabel, true] ) ( logical_expr[currTable, trueLabel, falseLabel, rightShortCircuit] | compare_expr[currTable, secondBranchLabel, secondBranchNegate] ) ) | ^(op= '|' ( logical_expr[currTable, trueLabel, secondExprLabel, \"|\"] | compare_expr[currTable, trueLabel, false] ) ( logical_expr[currTable, trueLabel, falseLabel, rightShortCircuit] | compare_expr[currTable, secondBranchLabel, secondBranchNegate] ) ) )
			int alt24=2;
			int LA24_0 = input.LA(1);
			if ( (LA24_0==AND) ) {
				alt24=1;
			}
			else if ( (LA24_0==OR) ) {
				alt24=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 24, 0, input);
				throw nvae;
			}

			switch (alt24) {
				case 1 :
					// cs4240_team1/IRCodeWalker.g:380:4: ^(op= '&' ( logical_expr[currTable, secondExprLabel, falseLabel, \"&\"] | compare_expr[currTable, falseLabel, true] ) ( logical_expr[currTable, trueLabel, falseLabel, rightShortCircuit] | compare_expr[currTable, secondBranchLabel, secondBranchNegate] ) )
					{
					op=(CommonTree)match(input,AND,FOLLOW_AND_in_logical_expr1124); 

									leftChildText = op.getChild(0).getText();
									if ("|".equals(leftChildText) || "&".equals(leftChildText)) {
										secondExprLabel = g.newLabel1();
									}
								
					match(input, Token.DOWN, null); 
					// cs4240_team1/IRCodeWalker.g:387:4: ( logical_expr[currTable, secondExprLabel, falseLabel, \"&\"] | compare_expr[currTable, falseLabel, true] )
					int alt20=2;
					int LA20_0 = input.LA(1);
					if ( (LA20_0==AND||LA20_0==OR) ) {
						alt20=1;
					}
					else if ( (LA20_0==EQ||(LA20_0 >= GREATER && LA20_0 <= GREATEREQ)||(LA20_0 >= LESSER && LA20_0 <= LESSEREQ)||LA20_0==NEQ) ) {
						alt20=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 20, 0, input);
						throw nvae;
					}

					switch (alt20) {
						case 1 :
							// cs4240_team1/IRCodeWalker.g:387:6: logical_expr[currTable, secondExprLabel, falseLabel, \"&\"]
							{
							pushFollow(FOLLOW_logical_expr_in_logical_expr1136);
							logical_expr(currTable, secondExprLabel, falseLabel, "&");
							state._fsp--;

							}
							break;
						case 2 :
							// cs4240_team1/IRCodeWalker.g:388:6: compare_expr[currTable, falseLabel, true]
							{
							pushFollow(FOLLOW_compare_expr_in_logical_expr1144);
							compare_expr(currTable, falseLabel, true);
							state._fsp--;

							}
							break;

					}


									if (secondExprLabel != null) {
										g.emit(Op.LABEL, secondExprLabel);
									}
								
					// cs4240_team1/IRCodeWalker.g:395:4: ( logical_expr[currTable, trueLabel, falseLabel, rightShortCircuit] | compare_expr[currTable, secondBranchLabel, secondBranchNegate] )
					int alt21=2;
					int LA21_0 = input.LA(1);
					if ( (LA21_0==AND||LA21_0==OR) ) {
						alt21=1;
					}
					else if ( (LA21_0==EQ||(LA21_0 >= GREATER && LA21_0 <= GREATEREQ)||(LA21_0 >= LESSER && LA21_0 <= LESSEREQ)||LA21_0==NEQ) ) {
						alt21=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 21, 0, input);
						throw nvae;
					}

					switch (alt21) {
						case 1 :
							// cs4240_team1/IRCodeWalker.g:395:6: logical_expr[currTable, trueLabel, falseLabel, rightShortCircuit]
							{
							pushFollow(FOLLOW_logical_expr_in_logical_expr1165);
							logical_expr(currTable, trueLabel, falseLabel, rightShortCircuit);
							state._fsp--;

							}
							break;
						case 2 :
							// cs4240_team1/IRCodeWalker.g:396:6: compare_expr[currTable, secondBranchLabel, secondBranchNegate]
							{
							pushFollow(FOLLOW_compare_expr_in_logical_expr1173);
							compare_expr(currTable, secondBranchLabel, secondBranchNegate);
							state._fsp--;

							}
							break;

					}

					match(input, Token.UP, null); 

					}
					break;
				case 2 :
					// cs4240_team1/IRCodeWalker.g:399:4: ^(op= '|' ( logical_expr[currTable, trueLabel, secondExprLabel, \"|\"] | compare_expr[currTable, trueLabel, false] ) ( logical_expr[currTable, trueLabel, falseLabel, rightShortCircuit] | compare_expr[currTable, secondBranchLabel, secondBranchNegate] ) )
					{
					op=(CommonTree)match(input,OR,FOLLOW_OR_in_logical_expr1191); 

									leftChildText = op.getChild(0).getText();
									if ("|".equals(leftChildText) || "&".equals(leftChildText)) {
										secondExprLabel = g.newLabel1();
									}
								
					match(input, Token.DOWN, null); 
					// cs4240_team1/IRCodeWalker.g:406:4: ( logical_expr[currTable, trueLabel, secondExprLabel, \"|\"] | compare_expr[currTable, trueLabel, false] )
					int alt22=2;
					int LA22_0 = input.LA(1);
					if ( (LA22_0==AND||LA22_0==OR) ) {
						alt22=1;
					}
					else if ( (LA22_0==EQ||(LA22_0 >= GREATER && LA22_0 <= GREATEREQ)||(LA22_0 >= LESSER && LA22_0 <= LESSEREQ)||LA22_0==NEQ) ) {
						alt22=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 22, 0, input);
						throw nvae;
					}

					switch (alt22) {
						case 1 :
							// cs4240_team1/IRCodeWalker.g:406:6: logical_expr[currTable, trueLabel, secondExprLabel, \"|\"]
							{
							pushFollow(FOLLOW_logical_expr_in_logical_expr1203);
							logical_expr(currTable, trueLabel, secondExprLabel, "|");
							state._fsp--;

							}
							break;
						case 2 :
							// cs4240_team1/IRCodeWalker.g:407:6: compare_expr[currTable, trueLabel, false]
							{
							pushFollow(FOLLOW_compare_expr_in_logical_expr1211);
							compare_expr(currTable, trueLabel, false);
							state._fsp--;

							}
							break;

					}


									if (secondExprLabel != null) {
										g.emit(Op.LABEL, secondExprLabel);
									}
								
					// cs4240_team1/IRCodeWalker.g:414:4: ( logical_expr[currTable, trueLabel, falseLabel, rightShortCircuit] | compare_expr[currTable, secondBranchLabel, secondBranchNegate] )
					int alt23=2;
					int LA23_0 = input.LA(1);
					if ( (LA23_0==AND||LA23_0==OR) ) {
						alt23=1;
					}
					else if ( (LA23_0==EQ||(LA23_0 >= GREATER && LA23_0 <= GREATEREQ)||(LA23_0 >= LESSER && LA23_0 <= LESSEREQ)||LA23_0==NEQ) ) {
						alt23=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 23, 0, input);
						throw nvae;
					}

					switch (alt23) {
						case 1 :
							// cs4240_team1/IRCodeWalker.g:414:6: logical_expr[currTable, trueLabel, falseLabel, rightShortCircuit]
							{
							pushFollow(FOLLOW_logical_expr_in_logical_expr1232);
							logical_expr(currTable, trueLabel, falseLabel, rightShortCircuit);
							state._fsp--;

							}
							break;
						case 2 :
							// cs4240_team1/IRCodeWalker.g:415:6: compare_expr[currTable, secondBranchLabel, secondBranchNegate]
							{
							pushFollow(FOLLOW_compare_expr_in_logical_expr1240);
							compare_expr(currTable, secondBranchLabel, secondBranchNegate);
							state._fsp--;

							}
							break;

					}

					match(input, Token.UP, null); 

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
	}
	// $ANTLR end "logical_expr"



	// $ANTLR start "compare_expr"
	// cs4240_team1/IRCodeWalker.g:420:1: compare_expr[SymbolTable currTable, LabelArgument branchLabel, boolean negate] : ( ^( '=' e1= expr[currTable] e2= expr[currTable] ) | ^( '<>' e1= expr[currTable] e2= expr[currTable] ) | ^( '<' e1= expr[currTable] e2= expr[currTable] ) | ^( '>=' e1= expr[currTable] e2= expr[currTable] ) | ^( '>' e1= expr[currTable] e2= expr[currTable] ) | ^( '<=' e1= expr[currTable] e2= expr[currTable] ) );
	public final void compare_expr(SymbolTable currTable, LabelArgument branchLabel, boolean negate) throws RecognitionException {
		IRCodeArgument e1 =null;
		IRCodeArgument e2 =null;


			Op opCode;

		try {
			// cs4240_team1/IRCodeWalker.g:425:5: ( ^( '=' e1= expr[currTable] e2= expr[currTable] ) | ^( '<>' e1= expr[currTable] e2= expr[currTable] ) | ^( '<' e1= expr[currTable] e2= expr[currTable] ) | ^( '>=' e1= expr[currTable] e2= expr[currTable] ) | ^( '>' e1= expr[currTable] e2= expr[currTable] ) | ^( '<=' e1= expr[currTable] e2= expr[currTable] ) )
			int alt25=6;
			switch ( input.LA(1) ) {
			case EQ:
				{
				alt25=1;
				}
				break;
			case NEQ:
				{
				alt25=2;
				}
				break;
			case LESSER:
				{
				alt25=3;
				}
				break;
			case GREATEREQ:
				{
				alt25=4;
				}
				break;
			case GREATER:
				{
				alt25=5;
				}
				break;
			case LESSEREQ:
				{
				alt25=6;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 25, 0, input);
				throw nvae;
			}
			switch (alt25) {
				case 1 :
					// cs4240_team1/IRCodeWalker.g:425:9: ^( '=' e1= expr[currTable] e2= expr[currTable] )
					{
					match(input,EQ,FOLLOW_EQ_in_compare_expr1279); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_compare_expr1283);
					e1=expr(currTable);
					state._fsp--;

					pushFollow(FOLLOW_expr_in_compare_expr1288);
					e2=expr(currTable);
					state._fsp--;

					match(input, Token.UP, null); 


								opCode = negate ? Op.BRNEQ : Op.BREQ;
								g.emit(opCode, e1, e2, branchLabel);
							
					}
					break;
				case 2 :
					// cs4240_team1/IRCodeWalker.g:429:9: ^( '<>' e1= expr[currTable] e2= expr[currTable] )
					{
					match(input,NEQ,FOLLOW_NEQ_in_compare_expr1303); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_compare_expr1307);
					e1=expr(currTable);
					state._fsp--;

					pushFollow(FOLLOW_expr_in_compare_expr1312);
					e2=expr(currTable);
					state._fsp--;

					match(input, Token.UP, null); 


								opCode = negate ? Op.BREQ : Op.BRNEQ;
								g.emit(opCode, e1, e2, branchLabel);
							
					}
					break;
				case 3 :
					// cs4240_team1/IRCodeWalker.g:433:9: ^( '<' e1= expr[currTable] e2= expr[currTable] )
					{
					match(input,LESSER,FOLLOW_LESSER_in_compare_expr1327); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_compare_expr1331);
					e1=expr(currTable);
					state._fsp--;

					pushFollow(FOLLOW_expr_in_compare_expr1336);
					e2=expr(currTable);
					state._fsp--;

					match(input, Token.UP, null); 


								opCode = negate ? Op.BRGEQ : Op.BRLT;
								g.emit(opCode, e1, e2, branchLabel);
							
					}
					break;
				case 4 :
					// cs4240_team1/IRCodeWalker.g:437:9: ^( '>=' e1= expr[currTable] e2= expr[currTable] )
					{
					match(input,GREATEREQ,FOLLOW_GREATEREQ_in_compare_expr1351); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_compare_expr1355);
					e1=expr(currTable);
					state._fsp--;

					pushFollow(FOLLOW_expr_in_compare_expr1360);
					e2=expr(currTable);
					state._fsp--;

					match(input, Token.UP, null); 


								opCode = negate ? Op.BRLT : Op.BRGEQ;
								g.emit(opCode, e1, e2, branchLabel);
							
					}
					break;
				case 5 :
					// cs4240_team1/IRCodeWalker.g:441:9: ^( '>' e1= expr[currTable] e2= expr[currTable] )
					{
					match(input,GREATER,FOLLOW_GREATER_in_compare_expr1375); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_compare_expr1379);
					e1=expr(currTable);
					state._fsp--;

					pushFollow(FOLLOW_expr_in_compare_expr1384);
					e2=expr(currTable);
					state._fsp--;

					match(input, Token.UP, null); 


								opCode = negate ? Op.BRLEQ : Op.BRGT;
								g.emit(opCode, e1, e2, branchLabel);
							
					}
					break;
				case 6 :
					// cs4240_team1/IRCodeWalker.g:445:9: ^( '<=' e1= expr[currTable] e2= expr[currTable] )
					{
					match(input,LESSEREQ,FOLLOW_LESSEREQ_in_compare_expr1399); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_compare_expr1403);
					e1=expr(currTable);
					state._fsp--;

					pushFollow(FOLLOW_expr_in_compare_expr1408);
					e2=expr(currTable);
					state._fsp--;

					match(input, Token.UP, null); 


								opCode = negate ? Op.BRGT : Op.BRLEQ;
								g.emit(opCode, e1, e2, branchLabel);
							
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
	}
	// $ANTLR end "compare_expr"



	// $ANTLR start "expr"
	// cs4240_team1/IRCodeWalker.g:452:1: expr[SymbolTable currTable] returns [IRCodeArgument outArg] : ( ^( '+' e1= expr[currTable] e2= expr[currTable] ) | ^( '-' e1= expr[currTable] e2= expr[currTable] ) | ^( '*' e1= expr[currTable] e2= expr[currTable] ) | ^( '/' e1= expr[currTable] e2= expr[currTable] ) | value[currTable] | literal );
	public final IRCodeArgument expr(SymbolTable currTable) throws RecognitionException {
		IRCodeArgument outArg = null;


		IRCodeArgument e1 =null;
		IRCodeArgument e2 =null;
		IRCodeArgument value17 =null;
		IRCodeArgument literal18 =null;

		try {
			// cs4240_team1/IRCodeWalker.g:454:5: ( ^( '+' e1= expr[currTable] e2= expr[currTable] ) | ^( '-' e1= expr[currTable] e2= expr[currTable] ) | ^( '*' e1= expr[currTable] e2= expr[currTable] ) | ^( '/' e1= expr[currTable] e2= expr[currTable] ) | value[currTable] | literal )
			int alt26=6;
			switch ( input.LA(1) ) {
			case PLUS:
				{
				alt26=1;
				}
				break;
			case MINUS:
				{
				alt26=2;
				}
				break;
			case MULT:
				{
				alt26=3;
				}
				break;
			case DIV:
				{
				alt26=4;
				}
				break;
			case ID:
				{
				alt26=5;
				}
				break;
			case FIXEDPTLIT:
			case INTLIT:
				{
				alt26=6;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 26, 0, input);
				throw nvae;
			}
			switch (alt26) {
				case 1 :
					// cs4240_team1/IRCodeWalker.g:454:9: ^( '+' e1= expr[currTable] e2= expr[currTable] )
					{
					match(input,PLUS,FOLLOW_PLUS_in_expr1442); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr1446);
					e1=expr(currTable);
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr1451);
					e2=expr(currTable);
					state._fsp--;

					match(input, Token.UP, null); 


					        TigerType promotedType = TypeChecker.getTypeAfterArithmetic(e1.getTigerType(), e2.getTigerType());
					    	VarEntry outStore = g.newTemp(promotedType);

							g.emit(Op.ADD,e1 ,e2 ,outStore);

					    	outArg = outStore;
					    
					    
					}
					break;
				case 2 :
					// cs4240_team1/IRCodeWalker.g:463:9: ^( '-' e1= expr[currTable] e2= expr[currTable] )
					{
					match(input,MINUS,FOLLOW_MINUS_in_expr1466); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr1470);
					e1=expr(currTable);
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr1475);
					e2=expr(currTable);
					state._fsp--;

					match(input, Token.UP, null); 


							TigerType promotedType = TypeChecker.getTypeAfterArithmetic(e1.getTigerType(), e2.getTigerType());
					    	VarEntry outStore = g.newTemp(promotedType);
					   
							g.emit(Op.SUB,e1 ,e2 ,outStore); 

					    	outArg = outStore;
					    
					}
					break;
				case 3 :
					// cs4240_team1/IRCodeWalker.g:473:9: ^( '*' e1= expr[currTable] e2= expr[currTable] )
					{
					match(input,MULT,FOLLOW_MULT_in_expr1498); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr1502);
					e1=expr(currTable);
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr1507);
					e2=expr(currTable);
					state._fsp--;

					match(input, Token.UP, null); 


							TigerType promotedType = TypeChecker.getTypeAfterArithmetic(e1.getTigerType(), e2.getTigerType());
					    	VarEntry outStore = g.newTemp(promotedType);
							g.emit(Op.MULT,e1 ,e2 ,outStore); 

					    	outArg = outStore;
					    
					}
					break;
				case 4 :
					// cs4240_team1/IRCodeWalker.g:480:9: ^( '/' e1= expr[currTable] e2= expr[currTable] )
					{
					match(input,DIV,FOLLOW_DIV_in_expr1522); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr1526);
					e1=expr(currTable);
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr1531);
					e2=expr(currTable);
					state._fsp--;

					match(input, Token.UP, null); 


							TigerType promotedType = TypeChecker.getTypeAfterArithmetic(e1.getTigerType(), e2.getTigerType());
					    	VarEntry outStore = g.newTemp(promotedType);
					    
							g.emit(Op.DIV, e1 ,e2 ,outStore); 

					    	outArg = outStore;

					    
					}
					break;
				case 5 :
					// cs4240_team1/IRCodeWalker.g:490:7: value[currTable]
					{
					pushFollow(FOLLOW_value_in_expr1544);
					value17=value(currTable);
					state._fsp--;



							IRCodeArgument outStore = value17;
					    	outArg = outStore;
					    
					    
					}
					break;
				case 6 :
					// cs4240_team1/IRCodeWalker.g:496:7: literal
					{
					pushFollow(FOLLOW_literal_in_expr1555);
					literal18=literal();
					state._fsp--;


					    	outArg = literal18;
					    
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
		return outArg;
	}
	// $ANTLR end "expr"



	// $ANTLR start "value"
	// cs4240_team1/IRCodeWalker.g:502:1: value[SymbolTable currTable] returns [IRCodeArgument outArg] : ^( ID ( value_tail[currTable, $ID.text] )? ) ;
	public final IRCodeArgument value(SymbolTable currTable) throws RecognitionException {
		IRCodeArgument outArg = null;


		CommonTree ID19=null;
		IRCodeArgument value_tail20 =null;


		    boolean has_tail = false;

		try {
			// cs4240_team1/IRCodeWalker.g:506:5: ( ^( ID ( value_tail[currTable, $ID.text] )? ) )
			// cs4240_team1/IRCodeWalker.g:506:9: ^( ID ( value_tail[currTable, $ID.text] )? )
			{
			ID19=(CommonTree)match(input,ID,FOLLOW_ID_in_value1589); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// cs4240_team1/IRCodeWalker.g:506:14: ( value_tail[currTable, $ID.text] )?
				int alt27=2;
				int LA27_0 = input.LA(1);
				if ( (LA27_0==ID||LA27_0==INTLIT||(LA27_0 >= MINUS && LA27_0 <= MULT)||LA27_0==PLUS) ) {
					alt27=1;
				}
				switch (alt27) {
					case 1 :
						// cs4240_team1/IRCodeWalker.g:506:15: value_tail[currTable, $ID.text]
						{
						pushFollow(FOLLOW_value_tail_in_value1592);
						value_tail20=value_tail(currTable, (ID19!=null?ID19.getText():null));
						state._fsp--;

						has_tail = true;
						}
						break;

				}

				match(input, Token.UP, null); 
			}



					VarEntry entry = (VarEntry) currTable.lookup((ID19!=null?ID19.getText():null));
					if (has_tail) {
							VarEntry outStore = g.newTemp(TigerType.BASE_INT_TYPE);
							g.emit(Op.ARRAYLOAD, outStore , entry, value_tail20);
							outArg = outStore;
					} else {
							outArg = entry;
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
		return outArg;
	}
	// $ANTLR end "value"



	// $ANTLR start "literal"
	// cs4240_team1/IRCodeWalker.g:519:1: literal returns [IRCodeArgument outArg] : ( INTLIT | FIXEDPTLIT );
	public final IRCodeArgument literal() throws RecognitionException {
		IRCodeArgument outArg = null;


		CommonTree INTLIT21=null;
		CommonTree FIXEDPTLIT22=null;

		try {
			// cs4240_team1/IRCodeWalker.g:520:5: ( INTLIT | FIXEDPTLIT )
			int alt28=2;
			int LA28_0 = input.LA(1);
			if ( (LA28_0==INTLIT) ) {
				alt28=1;
			}
			else if ( (LA28_0==FIXEDPTLIT) ) {
				alt28=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 28, 0, input);
				throw nvae;
			}

			switch (alt28) {
				case 1 :
					// cs4240_team1/IRCodeWalker.g:520:9: INTLIT
					{
					INTLIT21=(CommonTree)match(input,INTLIT,FOLLOW_INTLIT_in_literal1623); 

					        outArg = new LiteralArgument((INTLIT21!=null?INTLIT21.getText():null), TigerType.LITERAL_INT_TYPE);
					        
					}
					break;
				case 2 :
					// cs4240_team1/IRCodeWalker.g:523:9: FIXEDPTLIT
					{
					FIXEDPTLIT22=(CommonTree)match(input,FIXEDPTLIT,FOLLOW_FIXEDPTLIT_in_literal1635); 

					        outArg = new LiteralArgument((FIXEDPTLIT22!=null?FIXEDPTLIT22.getText():null), TigerType.LITERAL_FIXEDPT_TYPE);
					        
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
		return outArg;
	}
	// $ANTLR end "literal"



	// $ANTLR start "value_tail"
	// cs4240_team1/IRCodeWalker.g:531:1: value_tail[SymbolTable currTable, String arrayName] returns [IRCodeArgument offset_reg] : (i1= index_expr[currTable] ) (i2= index_expr[currTable] )? ;
	public final IRCodeArgument value_tail(SymbolTable currTable, String arrayName) throws RecognitionException {
		IRCodeArgument offset_reg = null;


		IRCodeArgument i1 =null;
		IRCodeArgument i2 =null;


		    Boolean twoArgs = false;

		try {
			// cs4240_team1/IRCodeWalker.g:535:5: ( (i1= index_expr[currTable] ) (i2= index_expr[currTable] )? )
			// cs4240_team1/IRCodeWalker.g:535:7: (i1= index_expr[currTable] ) (i2= index_expr[currTable] )?
			{
			// cs4240_team1/IRCodeWalker.g:535:7: (i1= index_expr[currTable] )
			// cs4240_team1/IRCodeWalker.g:535:8: i1= index_expr[currTable]
			{
			pushFollow(FOLLOW_index_expr_in_value_tail1671);
			i1=index_expr(currTable);
			state._fsp--;

			}

			// cs4240_team1/IRCodeWalker.g:535:34: (i2= index_expr[currTable] )?
			int alt29=2;
			int LA29_0 = input.LA(1);
			if ( (LA29_0==ID||LA29_0==INTLIT||(LA29_0 >= MINUS && LA29_0 <= MULT)||LA29_0==PLUS) ) {
				alt29=1;
			}
			switch (alt29) {
				case 1 :
					// cs4240_team1/IRCodeWalker.g:535:35: i2= index_expr[currTable]
					{
					pushFollow(FOLLOW_index_expr_in_value_tail1678);
					i2=index_expr(currTable);
					state._fsp--;

					twoArgs = true;
					}
					break;

			}


			        if (twoArgs) {
			          VarEntry arrayEntry = (VarEntry) currTable.lookup(arrayName);
			          TigerType dimensions = arrayEntry.type;
			          LiteralArgument indexArg = new LiteralArgument(dimensions.dimension2.toString(), TigerType.LITERAL_INT_TYPE);
					  VarEntry outStore = g.newTemp(TigerType.BASE_INT_TYPE);
					  VarEntry outStore2 = g.newTemp(TigerType.BASE_INT_TYPE);
					  g.emit(Op.MULT, i1, indexArg, outStore);
					  g.emit(Op.ADD, outStore, i2 ,outStore2);
					  offset_reg = outStore2;
			        } else {
			            offset_reg = i1;
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
		return offset_reg;
	}
	// $ANTLR end "value_tail"



	// $ANTLR start "index_expr"
	// cs4240_team1/IRCodeWalker.g:551:1: index_expr[SymbolTable currTable] returns [IRCodeArgument outArg] : ( ^( '+' i1= index_expr[currTable] i2= index_expr[currTable] ) | ^( '-' i1= index_expr[currTable] i2= index_expr[currTable] ) | ^( '*' i1= index_expr[currTable] i2= index_expr[currTable] ) | INTLIT | ID );
	public final IRCodeArgument index_expr(SymbolTable currTable) throws RecognitionException {
		IRCodeArgument outArg = null;


		CommonTree INTLIT23=null;
		CommonTree ID24=null;
		IRCodeArgument i1 =null;
		IRCodeArgument i2 =null;

		try {
			// cs4240_team1/IRCodeWalker.g:552:5: ( ^( '+' i1= index_expr[currTable] i2= index_expr[currTable] ) | ^( '-' i1= index_expr[currTable] i2= index_expr[currTable] ) | ^( '*' i1= index_expr[currTable] i2= index_expr[currTable] ) | INTLIT | ID )
			int alt30=5;
			switch ( input.LA(1) ) {
			case PLUS:
				{
				alt30=1;
				}
				break;
			case MINUS:
				{
				alt30=2;
				}
				break;
			case MULT:
				{
				alt30=3;
				}
				break;
			case INTLIT:
				{
				alt30=4;
				}
				break;
			case ID:
				{
				alt30=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 30, 0, input);
				throw nvae;
			}
			switch (alt30) {
				case 1 :
					// cs4240_team1/IRCodeWalker.g:552:7: ^( '+' i1= index_expr[currTable] i2= index_expr[currTable] )
					{
					match(input,PLUS,FOLLOW_PLUS_in_index_expr1708); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_index_expr_in_index_expr1712);
					i1=index_expr(currTable);
					state._fsp--;

					pushFollow(FOLLOW_index_expr_in_index_expr1717);
					i2=index_expr(currTable);
					state._fsp--;

					match(input, Token.UP, null); 


					        VarEntry temp = g.newTemp(TigerType.BASE_INT_TYPE);
					        g.emit(Op.ADD,i1 ,i2 ,temp);
					        outArg = temp;
					    
					}
					break;
				case 2 :
					// cs4240_team1/IRCodeWalker.g:557:7: ^( '-' i1= index_expr[currTable] i2= index_expr[currTable] )
					{
					match(input,MINUS,FOLLOW_MINUS_in_index_expr1730); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_index_expr_in_index_expr1734);
					i1=index_expr(currTable);
					state._fsp--;

					pushFollow(FOLLOW_index_expr_in_index_expr1739);
					i2=index_expr(currTable);
					state._fsp--;

					match(input, Token.UP, null); 


					        VarEntry temp = g.newTemp(TigerType.BASE_INT_TYPE);
					        g.emit(Op.SUB,i1 ,i2 ,temp);
					        outArg = temp;
					    
					}
					break;
				case 3 :
					// cs4240_team1/IRCodeWalker.g:562:7: ^( '*' i1= index_expr[currTable] i2= index_expr[currTable] )
					{
					match(input,MULT,FOLLOW_MULT_in_index_expr1752); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_index_expr_in_index_expr1756);
					i1=index_expr(currTable);
					state._fsp--;

					pushFollow(FOLLOW_index_expr_in_index_expr1761);
					i2=index_expr(currTable);
					state._fsp--;

					match(input, Token.UP, null); 


					        VarEntry temp = g.newTemp(TigerType.BASE_INT_TYPE);
					        g.emit(Op.MULT,i1 ,i2 ,temp);
					        outArg = temp;
					    
					}
					break;
				case 4 :
					// cs4240_team1/IRCodeWalker.g:567:7: INTLIT
					{
					INTLIT23=(CommonTree)match(input,INTLIT,FOLLOW_INTLIT_in_index_expr1773); 

					        outArg = new LiteralArgument((INTLIT23!=null?INTLIT23.getText():null), TigerType.LITERAL_INT_TYPE);
					    
					}
					break;
				case 5 :
					// cs4240_team1/IRCodeWalker.g:571:7: ID
					{
					ID24=(CommonTree)match(input,ID,FOLLOW_ID_in_index_expr1789); 

					       VarEntry uniqueVar = ((VarEntry) currTable.lookup((ID24!=null?ID24.getText():null)));
					       outArg = uniqueVar;
					    
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
		return outArg;
	}
	// $ANTLR end "index_expr"

	// Delegated rules



	public static final BitSet FOLLOW_tiger_program_in_walk58 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_walk60 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PROGRAM_in_tiger_program84 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_type_declaration_list_in_tiger_program86 = new BitSet(new long[]{0x0001000010000000L});
	public static final BitSet FOLLOW_funct_declaration_in_tiger_program89 = new BitSet(new long[]{0x0001000010000000L});
	public static final BitSet FOLLOW_main_function_in_tiger_program92 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_FUNCTION_in_funct_declaration116 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ret_type_in_funct_declaration118 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_ID_in_funct_declaration120 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_param_list_in_funct_declaration124 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_block_list_in_funct_declaration127 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_VOID_in_ret_type151 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_ret_type161 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_ret_type171 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FIXEDPT_in_ret_type181 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MAINSCOPE_in_main_function209 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_block_list_in_main_function211 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PARAMLIST_in_param_list235 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_param_in_param_list237 = new BitSet(new long[]{0x0000000100000008L});
	public static final BitSet FOLLOW_ID_in_param261 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_type_id_in_param263 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BLOCKLIST_in_block_list286 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_block_in_block_list288 = new BitSet(new long[]{0x0000000000000208L});
	public static final BitSet FOLLOW_BLOCKSCOPE_in_block319 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_type_declaration_list_in_block321 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_var_declaration_list_in_block324 = new BitSet(new long[]{0x0400000424000640L,0x0000000000000100L});
	public static final BitSet FOLLOW_stat_seq_in_block327 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_TYPEDECLLIST_in_type_declaration_list348 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_type_declaration_in_type_declaration_list350 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000002L});
	public static final BitSet FOLLOW_VARDECLLIST_in_var_declaration_list371 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_var_declaration_in_var_declaration_list373 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000010L});
	public static final BitSet FOLLOW_TYPEDECL_in_type_declaration394 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_type_declaration396 = new BitSet(new long[]{0x0000002001000020L});
	public static final BitSet FOLLOW_type_in_type_declaration398 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_base_type_in_type423 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARRAY_in_type435 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_base_type_in_type437 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_INTLIT_in_type441 = new BitSet(new long[]{0x0000004000000008L});
	public static final BitSet FOLLOW_INTLIT_in_type445 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_VAR_in_var_declaration514 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_type_id_in_var_declaration516 = new BitSet(new long[]{0x0000000200000040L});
	public static final BitSet FOLLOW_optional_init_in_var_declaration521 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_id_list_in_var_declaration539 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_base_type_in_type_id568 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_type_id577 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDLIST_in_id_list597 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_id_list600 = new BitSet(new long[]{0x0000000100000008L});
	public static final BitSet FOLLOW_ASSIGN_in_optional_init640 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_literal_in_optional_init642 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_stat_in_stat_seq665 = new BitSet(new long[]{0x0400000424000642L,0x0000000000000100L});
	public static final BitSet FOLLOW_function_call_in_stat691 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assignment_in_stat702 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_stat716 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_bool_expr_in_stat724 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_THEN_STATS_in_stat731 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_stat_seq_in_stat735 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ELSE_STATS_in_stat746 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_stat_seq_in_stat748 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_WHILE_in_stat774 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_bool_expr_in_stat778 = new BitSet(new long[]{0x0400000424000640L,0x0000000000000100L});
	public static final BitSet FOLLOW_stat_seq_in_stat783 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_FOR_in_stat822 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_stat824 = new BitSet(new long[]{0x0086004100000000L});
	public static final BitSet FOLLOW_index_expr_in_stat828 = new BitSet(new long[]{0x0086004100000000L});
	public static final BitSet FOLLOW_index_expr_in_stat840 = new BitSet(new long[]{0x0400000424000640L,0x0000000000000100L});
	public static final BitSet FOLLOW_stat_seq_in_stat860 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BREAK_in_stat895 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RETURN_in_stat908 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_stat910 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_block_in_stat930 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ASSIGN_in_assignment959 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_assignment962 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_value_tail_in_assignment965 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_expr_in_assignment976 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_function_call_in_assignment983 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_FUNCTION_CALL_in_function_call1016 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_function_call1018 = new BitSet(new long[]{0x0000000000800008L});
	public static final BitSet FOLLOW_function_args_in_function_call1021 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_EXPRLIST_in_function_args1060 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_function_args1065 = new BitSet(new long[]{0x0086004102008008L});
	public static final BitSet FOLLOW_logical_expr_in_bool_expr1095 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_compare_expr_in_bool_expr1101 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_AND_in_logical_expr1124 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_logical_expr_in_logical_expr1136 = new BitSet(new long[]{0x00281800C0400010L});
	public static final BitSet FOLLOW_compare_expr_in_logical_expr1144 = new BitSet(new long[]{0x00281800C0400010L});
	public static final BitSet FOLLOW_logical_expr_in_logical_expr1165 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_compare_expr_in_logical_expr1173 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_OR_in_logical_expr1191 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_logical_expr_in_logical_expr1203 = new BitSet(new long[]{0x00281800C0400010L});
	public static final BitSet FOLLOW_compare_expr_in_logical_expr1211 = new BitSet(new long[]{0x00281800C0400010L});
	public static final BitSet FOLLOW_logical_expr_in_logical_expr1232 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_compare_expr_in_logical_expr1240 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_EQ_in_compare_expr1279 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_compare_expr1283 = new BitSet(new long[]{0x0086004102008000L});
	public static final BitSet FOLLOW_expr_in_compare_expr1288 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NEQ_in_compare_expr1303 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_compare_expr1307 = new BitSet(new long[]{0x0086004102008000L});
	public static final BitSet FOLLOW_expr_in_compare_expr1312 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LESSER_in_compare_expr1327 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_compare_expr1331 = new BitSet(new long[]{0x0086004102008000L});
	public static final BitSet FOLLOW_expr_in_compare_expr1336 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_GREATEREQ_in_compare_expr1351 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_compare_expr1355 = new BitSet(new long[]{0x0086004102008000L});
	public static final BitSet FOLLOW_expr_in_compare_expr1360 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_GREATER_in_compare_expr1375 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_compare_expr1379 = new BitSet(new long[]{0x0086004102008000L});
	public static final BitSet FOLLOW_expr_in_compare_expr1384 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LESSEREQ_in_compare_expr1399 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_compare_expr1403 = new BitSet(new long[]{0x0086004102008000L});
	public static final BitSet FOLLOW_expr_in_compare_expr1408 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PLUS_in_expr1442 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr1446 = new BitSet(new long[]{0x0086004102008000L});
	public static final BitSet FOLLOW_expr_in_expr1451 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MINUS_in_expr1466 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr1470 = new BitSet(new long[]{0x0086004102008000L});
	public static final BitSet FOLLOW_expr_in_expr1475 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MULT_in_expr1498 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr1502 = new BitSet(new long[]{0x0086004102008000L});
	public static final BitSet FOLLOW_expr_in_expr1507 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DIV_in_expr1522 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr1526 = new BitSet(new long[]{0x0086004102008000L});
	public static final BitSet FOLLOW_expr_in_expr1531 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_value_in_expr1544 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_literal_in_expr1555 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_value1589 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_value_tail_in_value1592 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_INTLIT_in_literal1623 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FIXEDPTLIT_in_literal1635 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_index_expr_in_value_tail1671 = new BitSet(new long[]{0x0086004100000002L});
	public static final BitSet FOLLOW_index_expr_in_value_tail1678 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_index_expr1708 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_index_expr_in_index_expr1712 = new BitSet(new long[]{0x0086004100000000L});
	public static final BitSet FOLLOW_index_expr_in_index_expr1717 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MINUS_in_index_expr1730 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_index_expr_in_index_expr1734 = new BitSet(new long[]{0x0086004100000000L});
	public static final BitSet FOLLOW_index_expr_in_index_expr1739 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MULT_in_index_expr1752 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_index_expr_in_index_expr1756 = new BitSet(new long[]{0x0086004100000000L});
	public static final BitSet FOLLOW_index_expr_in_index_expr1761 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_INTLIT_in_index_expr1773 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_index_expr1789 = new BitSet(new long[]{0x0000000000000002L});
}
