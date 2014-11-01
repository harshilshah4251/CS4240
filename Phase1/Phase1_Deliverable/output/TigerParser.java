// $ANTLR 3.5.1 /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g 2014-10-28 00:14:50

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class TigerParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND", "ASSIGN", "Array", "Begin", 
		"Break", "COLON", "COMMA", "COMMENT", "DIV", "Do", "EQ", "Else", "End", 
		"Enddo", "Endif", "FIXEDPTLIT", "Fixedpt", "For", "Function", "GREATER", 
		"GREATEREQ", "ID", "INTLIT", "If", "Int", "LBRACK", "LESSER", "LESSEREQ", 
		"LPAREN", "MINUS", "MULT", "Main", "NEQ", "OR", "Of", "PLUS", "RBRACK", 
		"RPAREN", "Return", "SEMI", "Then", "To", "Type", "Var", "Void", "WS", 
		"While", "' ['"
	};
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

	@Override public String[] getTokenNames() { return TigerParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g"; }



	// $ANTLR start "tiger_program"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:11:1: tiger_program : type_declaration_list funct_declaration main_function ;
	public final void tiger_program() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:12:3: ( type_declaration_list funct_declaration main_function )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:12:5: type_declaration_list funct_declaration main_function
			{
			pushFollow(FOLLOW_type_declaration_list_in_tiger_program47);
			type_declaration_list();
			state._fsp--;

			pushFollow(FOLLOW_funct_declaration_in_tiger_program49);
			funct_declaration();
			state._fsp--;

			pushFollow(FOLLOW_main_function_in_tiger_program51);
			main_function();
			state._fsp--;

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
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:83:1: funct_declaration : ( Void funct_declaration_tail | funct_declaration_type_id funct_declaration );
	public final void funct_declaration() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:84:3: ( Void funct_declaration_tail | funct_declaration_type_id funct_declaration )
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==Void) ) {
				alt1=1;
			}
			else if ( (LA1_0==Fixedpt||LA1_0==ID||LA1_0==Int) ) {
				alt1=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}

			switch (alt1) {
				case 1 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:84:5: Void funct_declaration_tail
					{
					match(input,Void,FOLLOW_Void_in_funct_declaration530); 
					pushFollow(FOLLOW_funct_declaration_tail_in_funct_declaration532);
					funct_declaration_tail();
					state._fsp--;

					}
					break;
				case 2 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:85:5: funct_declaration_type_id funct_declaration
					{
					pushFollow(FOLLOW_funct_declaration_type_id_in_funct_declaration538);
					funct_declaration_type_id();
					state._fsp--;

					pushFollow(FOLLOW_funct_declaration_in_funct_declaration540);
					funct_declaration();
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
	// $ANTLR end "funct_declaration"



	// $ANTLR start "funct_declaration_tail"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:88:1: funct_declaration_tail : ( funct_declaration_void funct_declaration )? ;
	public final void funct_declaration_tail() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:89:3: ( ( funct_declaration_void funct_declaration )? )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:89:5: ( funct_declaration_void funct_declaration )?
			{
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:89:5: ( funct_declaration_void funct_declaration )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==Function) ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:89:6: funct_declaration_void funct_declaration
					{
					pushFollow(FOLLOW_funct_declaration_void_in_funct_declaration_tail556);
					funct_declaration_void();
					state._fsp--;

					pushFollow(FOLLOW_funct_declaration_in_funct_declaration_tail558);
					funct_declaration();
					state._fsp--;

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
	}
	// $ANTLR end "funct_declaration_tail"



	// $ANTLR start "funct_declaration_type_id"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:92:1: funct_declaration_type_id : type_id Function ID '(' param_list ')' Begin block_list End ';' ;
	public final void funct_declaration_type_id() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:93:3: ( type_id Function ID '(' param_list ')' Begin block_list End ';' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:93:5: type_id Function ID '(' param_list ')' Begin block_list End ';'
			{
			pushFollow(FOLLOW_type_id_in_funct_declaration_type_id575);
			type_id();
			state._fsp--;

			match(input,Function,FOLLOW_Function_in_funct_declaration_type_id577); 
			match(input,ID,FOLLOW_ID_in_funct_declaration_type_id579); 
			match(input,LPAREN,FOLLOW_LPAREN_in_funct_declaration_type_id581); 
			pushFollow(FOLLOW_param_list_in_funct_declaration_type_id583);
			param_list();
			state._fsp--;

			match(input,RPAREN,FOLLOW_RPAREN_in_funct_declaration_type_id585); 
			match(input,Begin,FOLLOW_Begin_in_funct_declaration_type_id587); 
			pushFollow(FOLLOW_block_list_in_funct_declaration_type_id589);
			block_list();
			state._fsp--;

			match(input,End,FOLLOW_End_in_funct_declaration_type_id591); 
			match(input,SEMI,FOLLOW_SEMI_in_funct_declaration_type_id593); 
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
	// $ANTLR end "funct_declaration_type_id"



	// $ANTLR start "funct_declaration_void"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:95:1: funct_declaration_void : Function ID '(' param_list ')' Begin block_list End ';' ;
	public final void funct_declaration_void() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:96:3: ( Function ID '(' param_list ')' Begin block_list End ';' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:96:5: Function ID '(' param_list ')' Begin block_list End ';'
			{
			match(input,Function,FOLLOW_Function_in_funct_declaration_void605); 
			match(input,ID,FOLLOW_ID_in_funct_declaration_void607); 
			match(input,LPAREN,FOLLOW_LPAREN_in_funct_declaration_void609); 
			pushFollow(FOLLOW_param_list_in_funct_declaration_void611);
			param_list();
			state._fsp--;

			match(input,RPAREN,FOLLOW_RPAREN_in_funct_declaration_void613); 
			match(input,Begin,FOLLOW_Begin_in_funct_declaration_void615); 
			pushFollow(FOLLOW_block_list_in_funct_declaration_void617);
			block_list();
			state._fsp--;

			match(input,End,FOLLOW_End_in_funct_declaration_void619); 
			match(input,SEMI,FOLLOW_SEMI_in_funct_declaration_void621); 
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
	// $ANTLR end "funct_declaration_void"



	// $ANTLR start "main_function"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:98:1: main_function : Main '(' ')' Begin block_list End ';' ;
	public final void main_function() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:99:3: ( Main '(' ')' Begin block_list End ';' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:99:5: Main '(' ')' Begin block_list End ';'
			{
			match(input,Main,FOLLOW_Main_in_main_function635); 
			match(input,LPAREN,FOLLOW_LPAREN_in_main_function637); 
			match(input,RPAREN,FOLLOW_RPAREN_in_main_function638); 
			match(input,Begin,FOLLOW_Begin_in_main_function640); 
			pushFollow(FOLLOW_block_list_in_main_function642);
			block_list();
			state._fsp--;

			match(input,End,FOLLOW_End_in_main_function644); 
			match(input,SEMI,FOLLOW_SEMI_in_main_function646); 
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



	// $ANTLR start "ret_type"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:105:1: ret_type : ( Void | type_id );
	public final void ret_type() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:106:3: ( Void | type_id )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==Void) ) {
				alt3=1;
			}
			else if ( (LA3_0==Fixedpt||LA3_0==ID||LA3_0==Int) ) {
				alt3=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:106:5: Void
					{
					match(input,Void,FOLLOW_Void_in_ret_type668); 
					}
					break;
				case 2 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:107:5: type_id
					{
					pushFollow(FOLLOW_type_id_in_ret_type674);
					type_id();
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
	// $ANTLR end "ret_type"



	// $ANTLR start "param_list"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:111:1: param_list : ( param param_list_tail )? ;
	public final void param_list() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:112:3: ( ( param param_list_tail )? )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:112:5: ( param param_list_tail )?
			{
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:112:5: ( param param_list_tail )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==ID) ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:112:6: param param_list_tail
					{
					pushFollow(FOLLOW_param_in_param_list691);
					param();
					state._fsp--;

					pushFollow(FOLLOW_param_list_tail_in_param_list693);
					param_list_tail();
					state._fsp--;

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
	}
	// $ANTLR end "param_list"



	// $ANTLR start "param_list_tail"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:114:1: param_list_tail : ( ',' param param_list_tail )? ;
	public final void param_list_tail() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:115:3: ( ( ',' param param_list_tail )? )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:115:5: ( ',' param param_list_tail )?
			{
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:115:5: ( ',' param param_list_tail )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==COMMA) ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:115:6: ',' param param_list_tail
					{
					match(input,COMMA,FOLLOW_COMMA_in_param_list_tail708); 
					pushFollow(FOLLOW_param_in_param_list_tail710);
					param();
					state._fsp--;

					pushFollow(FOLLOW_param_list_tail_in_param_list_tail712);
					param_list_tail();
					state._fsp--;

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
	}
	// $ANTLR end "param_list_tail"



	// $ANTLR start "param"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:117:1: param : ID ':' type_id ;
	public final void param() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:118:3: ( ID ':' type_id )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:118:5: ID ':' type_id
			{
			match(input,ID,FOLLOW_ID_in_param726); 
			match(input,COLON,FOLLOW_COLON_in_param728); 
			pushFollow(FOLLOW_type_id_in_param730);
			type_id();
			state._fsp--;

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
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:121:1: block_list : block block_tail ;
	public final void block_list() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:122:3: ( block block_tail )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:122:5: block block_tail
			{
			pushFollow(FOLLOW_block_in_block_list745);
			block();
			state._fsp--;

			pushFollow(FOLLOW_block_tail_in_block_list747);
			block_tail();
			state._fsp--;

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



	// $ANTLR start "block_tail"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:125:1: block_tail : ( block block_tail )? ;
	public final void block_tail() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:126:3: ( ( block block_tail )? )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:126:5: ( block block_tail )?
			{
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:126:5: ( block block_tail )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==Begin) ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:126:6: block block_tail
					{
					pushFollow(FOLLOW_block_in_block_tail766);
					block();
					state._fsp--;

					pushFollow(FOLLOW_block_tail_in_block_tail768);
					block_tail();
					state._fsp--;

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
	}
	// $ANTLR end "block_tail"



	// $ANTLR start "block"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:129:1: block : Begin declaration_segment stat_seq End ';' ;
	public final void block() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:130:3: ( Begin declaration_segment stat_seq End ';' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:130:5: Begin declaration_segment stat_seq End ';'
			{
			match(input,Begin,FOLLOW_Begin_in_block787); 
			pushFollow(FOLLOW_declaration_segment_in_block789);
			declaration_segment();
			state._fsp--;

			pushFollow(FOLLOW_stat_seq_in_block791);
			stat_seq();
			state._fsp--;

			match(input,End,FOLLOW_End_in_block793); 
			match(input,SEMI,FOLLOW_SEMI_in_block795); 
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



	// $ANTLR start "declaration_segment"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:133:1: declaration_segment : type_declaration_list var_declaration_list ;
	public final void declaration_segment() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:134:3: ( type_declaration_list var_declaration_list )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:134:5: type_declaration_list var_declaration_list
			{
			pushFollow(FOLLOW_type_declaration_list_in_declaration_segment808);
			type_declaration_list();
			state._fsp--;

			pushFollow(FOLLOW_var_declaration_list_in_declaration_segment810);
			var_declaration_list();
			state._fsp--;

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
	// $ANTLR end "declaration_segment"



	// $ANTLR start "type_declaration_list"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:137:1: type_declaration_list : ( type_declaration type_declaration_list )? ;
	public final void type_declaration_list() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:138:3: ( ( type_declaration type_declaration_list )? )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:138:5: ( type_declaration type_declaration_list )?
			{
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:138:5: ( type_declaration type_declaration_list )?
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==Type) ) {
				alt7=1;
			}
			switch (alt7) {
				case 1 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:138:6: type_declaration type_declaration_list
					{
					pushFollow(FOLLOW_type_declaration_in_type_declaration_list824);
					type_declaration();
					state._fsp--;

					pushFollow(FOLLOW_type_declaration_list_in_type_declaration_list826);
					type_declaration_list();
					state._fsp--;

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
	}
	// $ANTLR end "type_declaration_list"



	// $ANTLR start "var_declaration_list"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:141:1: var_declaration_list : ( var_declaration var_declaration_list )? ;
	public final void var_declaration_list() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:142:3: ( ( var_declaration var_declaration_list )? )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:142:5: ( var_declaration var_declaration_list )?
			{
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:142:5: ( var_declaration var_declaration_list )?
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==Var) ) {
				alt8=1;
			}
			switch (alt8) {
				case 1 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:142:6: var_declaration var_declaration_list
					{
					pushFollow(FOLLOW_var_declaration_in_var_declaration_list842);
					var_declaration();
					state._fsp--;

					pushFollow(FOLLOW_var_declaration_list_in_var_declaration_list844);
					var_declaration_list();
					state._fsp--;

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
	}
	// $ANTLR end "var_declaration_list"



	// $ANTLR start "type_declaration"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:145:1: type_declaration : Type ID '=' type ';' ;
	public final void type_declaration() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:146:3: ( Type ID '=' type ';' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:146:5: Type ID '=' type ';'
			{
			match(input,Type,FOLLOW_Type_in_type_declaration859); 
			match(input,ID,FOLLOW_ID_in_type_declaration861); 
			match(input,EQ,FOLLOW_EQ_in_type_declaration863); 
			pushFollow(FOLLOW_type_in_type_declaration865);
			type();
			state._fsp--;

			match(input,SEMI,FOLLOW_SEMI_in_type_declaration867); 
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



	// $ANTLR start "type"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:156:1: type : ( base_type | ( Array ' [' INTLIT ']' type_tail Of base_type ) );
	public final void type() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:157:3: ( base_type | ( Array ' [' INTLIT ']' type_tail Of base_type ) )
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==Fixedpt||LA9_0==Int) ) {
				alt9=1;
			}
			else if ( (LA9_0==Array) ) {
				alt9=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}

			switch (alt9) {
				case 1 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:157:5: base_type
					{
					pushFollow(FOLLOW_base_type_in_type893);
					base_type();
					state._fsp--;

					}
					break;
				case 2 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:157:17: ( Array ' [' INTLIT ']' type_tail Of base_type )
					{
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:157:17: ( Array ' [' INTLIT ']' type_tail Of base_type )
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:157:18: Array ' [' INTLIT ']' type_tail Of base_type
					{
					match(input,Array,FOLLOW_Array_in_type898); 
					match(input,51,FOLLOW_51_in_type900); 
					match(input,INTLIT,FOLLOW_INTLIT_in_type902); 
					match(input,RBRACK,FOLLOW_RBRACK_in_type904); 
					pushFollow(FOLLOW_type_tail_in_type906);
					type_tail();
					state._fsp--;

					match(input,Of,FOLLOW_Of_in_type908); 
					pushFollow(FOLLOW_base_type_in_type910);
					base_type();
					state._fsp--;

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
	}
	// $ANTLR end "type"



	// $ANTLR start "type_tail"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:160:1: type_tail : ( '[' INTLIT ']' )? ;
	public final void type_tail() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:161:3: ( ( '[' INTLIT ']' )? )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:161:6: ( '[' INTLIT ']' )?
			{
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:161:6: ( '[' INTLIT ']' )?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==LBRACK) ) {
				alt10=1;
			}
			switch (alt10) {
				case 1 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:161:7: '[' INTLIT ']'
					{
					match(input,LBRACK,FOLLOW_LBRACK_in_type_tail928); 
					match(input,INTLIT,FOLLOW_INTLIT_in_type_tail930); 
					match(input,RBRACK,FOLLOW_RBRACK_in_type_tail932); 
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
	}
	// $ANTLR end "type_tail"



	// $ANTLR start "type_id"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:165:1: type_id : ( base_type | ID );
	public final void type_id() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:166:3: ( base_type | ID )
			int alt11=2;
			int LA11_0 = input.LA(1);
			if ( (LA11_0==Fixedpt||LA11_0==Int) ) {
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
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:166:5: base_type
					{
					pushFollow(FOLLOW_base_type_in_type_id950);
					base_type();
					state._fsp--;

					}
					break;
				case 2 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:167:6: ID
					{
					match(input,ID,FOLLOW_ID_in_type_id958); 
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
	// $ANTLR end "type_id"



	// $ANTLR start "base_type"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:170:1: base_type : ( Int | Fixedpt );
	public final void base_type() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:171:3: ( Int | Fixedpt )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:
			{
			if ( input.LA(1)==Fixedpt||input.LA(1)==Int ) {
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
	// $ANTLR end "base_type"



	// $ANTLR start "var_declaration"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:175:1: var_declaration : Var id_list ':' type_id optional_init ';' ;
	public final void var_declaration() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:176:3: ( Var id_list ':' type_id optional_init ';' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:176:5: Var id_list ':' type_id optional_init ';'
			{
			match(input,Var,FOLLOW_Var_in_var_declaration991); 
			pushFollow(FOLLOW_id_list_in_var_declaration993);
			id_list();
			state._fsp--;

			match(input,COLON,FOLLOW_COLON_in_var_declaration995); 
			pushFollow(FOLLOW_type_id_in_var_declaration997);
			type_id();
			state._fsp--;

			pushFollow(FOLLOW_optional_init_in_var_declaration999);
			optional_init();
			state._fsp--;

			match(input,SEMI,FOLLOW_SEMI_in_var_declaration1001); 
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



	// $ANTLR start "id_list"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:185:1: id_list : ID id_list_tail ;
	public final void id_list() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:186:3: ( ID id_list_tail )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:186:5: ID id_list_tail
			{
			match(input,ID,FOLLOW_ID_in_id_list1020); 
			pushFollow(FOLLOW_id_list_tail_in_id_list1022);
			id_list_tail();
			state._fsp--;

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



	// $ANTLR start "id_list_tail"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:189:1: id_list_tail : ( ',' id_list )? ;
	public final void id_list_tail() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:190:3: ( ( ',' id_list )? )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:190:5: ( ',' id_list )?
			{
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:190:5: ( ',' id_list )?
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0==COMMA) ) {
				alt12=1;
			}
			switch (alt12) {
				case 1 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:190:6: ',' id_list
					{
					match(input,COMMA,FOLLOW_COMMA_in_id_list_tail1037); 
					pushFollow(FOLLOW_id_list_in_id_list_tail1039);
					id_list();
					state._fsp--;

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
	}
	// $ANTLR end "id_list_tail"



	// $ANTLR start "optional_init"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:194:1: optional_init : ( ':=' constant )? ;
	public final void optional_init() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:195:3: ( ( ':=' constant )? )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:195:5: ( ':=' constant )?
			{
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:195:5: ( ':=' constant )?
			int alt13=2;
			int LA13_0 = input.LA(1);
			if ( (LA13_0==ASSIGN) ) {
				alt13=1;
			}
			switch (alt13) {
				case 1 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:195:6: ':=' constant
					{
					match(input,ASSIGN,FOLLOW_ASSIGN_in_optional_init1060); 
					pushFollow(FOLLOW_constant_in_optional_init1062);
					constant();
					state._fsp--;

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
	}
	// $ANTLR end "optional_init"



	// $ANTLR start "stat_seq"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:203:1: stat_seq : stat stat_seq_tail ;
	public final void stat_seq() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:204:3: ( stat stat_seq_tail )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:204:5: stat stat_seq_tail
			{
			pushFollow(FOLLOW_stat_in_stat_seq1088);
			stat();
			state._fsp--;

			pushFollow(FOLLOW_stat_seq_tail_in_stat_seq1090);
			stat_seq_tail();
			state._fsp--;

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



	// $ANTLR start "stat_seq_tail"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:206:1: stat_seq_tail : ( stat_seq )? ;
	public final void stat_seq_tail() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:207:3: ( ( stat_seq )? )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:207:5: ( stat_seq )?
			{
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:207:5: ( stat_seq )?
			int alt14=2;
			int LA14_0 = input.LA(1);
			if ( ((LA14_0 >= Begin && LA14_0 <= Break)||LA14_0==For||LA14_0==ID||LA14_0==If||LA14_0==Return||LA14_0==While) ) {
				alt14=1;
			}
			switch (alt14) {
				case 1 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:207:5: stat_seq
					{
					pushFollow(FOLLOW_stat_seq_in_stat_seq_tail1102);
					stat_seq();
					state._fsp--;

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
	}
	// $ANTLR end "stat_seq_tail"



	// $ANTLR start "stat"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:213:1: stat : ( ID id_stat | if_stat | while_stat | for_stat | break_stat | return_stat | ( block ) );
	public final void stat() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:214:3: ( ID id_stat | if_stat | while_stat | for_stat | break_stat | return_stat | ( block ) )
			int alt15=7;
			switch ( input.LA(1) ) {
			case ID:
				{
				alt15=1;
				}
				break;
			case If:
				{
				alt15=2;
				}
				break;
			case While:
				{
				alt15=3;
				}
				break;
			case For:
				{
				alt15=4;
				}
				break;
			case Break:
				{
				alt15=5;
				}
				break;
			case Return:
				{
				alt15=6;
				}
				break;
			case Begin:
				{
				alt15=7;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 15, 0, input);
				throw nvae;
			}
			switch (alt15) {
				case 1 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:214:5: ID id_stat
					{
					match(input,ID,FOLLOW_ID_in_stat1127); 
					pushFollow(FOLLOW_id_stat_in_stat1129);
					id_stat();
					state._fsp--;

					}
					break;
				case 2 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:215:5: if_stat
					{
					pushFollow(FOLLOW_if_stat_in_stat1135);
					if_stat();
					state._fsp--;

					}
					break;
				case 3 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:216:5: while_stat
					{
					pushFollow(FOLLOW_while_stat_in_stat1142);
					while_stat();
					state._fsp--;

					}
					break;
				case 4 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:217:5: for_stat
					{
					pushFollow(FOLLOW_for_stat_in_stat1149);
					for_stat();
					state._fsp--;

					}
					break;
				case 5 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:218:5: break_stat
					{
					pushFollow(FOLLOW_break_stat_in_stat1155);
					break_stat();
					state._fsp--;

					}
					break;
				case 6 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:219:5: return_stat
					{
					pushFollow(FOLLOW_return_stat_in_stat1161);
					return_stat();
					state._fsp--;

					}
					break;
				case 7 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:220:5: ( block )
					{
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:220:5: ( block )
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:220:6: block
					{
					pushFollow(FOLLOW_block_in_stat1168);
					block();
					state._fsp--;

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
	}
	// $ANTLR end "stat"



	// $ANTLR start "id_stat"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:222:1: id_stat : ( ( value_tail ':=' stat_tail ';' ) | ( '(' expr_list ')' ';' ) );
	public final void id_stat() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:223:3: ( ( value_tail ':=' stat_tail ';' ) | ( '(' expr_list ')' ';' ) )
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( ((LA16_0 >= AND && LA16_0 <= ASSIGN)||LA16_0==COMMA||(LA16_0 >= DIV && LA16_0 <= EQ)||(LA16_0 >= GREATER && LA16_0 <= GREATEREQ)||(LA16_0 >= LBRACK && LA16_0 <= LESSEREQ)||(LA16_0 >= MINUS && LA16_0 <= MULT)||(LA16_0 >= NEQ && LA16_0 <= OR)||LA16_0==PLUS||LA16_0==RPAREN||(LA16_0 >= SEMI && LA16_0 <= Then)) ) {
				alt16=1;
			}
			else if ( (LA16_0==LPAREN) ) {
				alt16=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 16, 0, input);
				throw nvae;
			}

			switch (alt16) {
				case 1 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:223:5: ( value_tail ':=' stat_tail ';' )
					{
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:223:5: ( value_tail ':=' stat_tail ';' )
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:223:6: value_tail ':=' stat_tail ';'
					{
					pushFollow(FOLLOW_value_tail_in_id_stat1182);
					value_tail();
					state._fsp--;

					match(input,ASSIGN,FOLLOW_ASSIGN_in_id_stat1184); 
					pushFollow(FOLLOW_stat_tail_in_id_stat1186);
					stat_tail();
					state._fsp--;

					match(input,SEMI,FOLLOW_SEMI_in_id_stat1188); 
					}

					}
					break;
				case 2 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:224:5: ( '(' expr_list ')' ';' )
					{
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:224:5: ( '(' expr_list ')' ';' )
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:224:6: '(' expr_list ')' ';'
					{
					match(input,LPAREN,FOLLOW_LPAREN_in_id_stat1197); 
					pushFollow(FOLLOW_expr_list_in_id_stat1199);
					expr_list();
					state._fsp--;

					match(input,RPAREN,FOLLOW_RPAREN_in_id_stat1201); 
					match(input,SEMI,FOLLOW_SEMI_in_id_stat1203); 
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
	}
	// $ANTLR end "id_stat"



	// $ANTLR start "stat_tail"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:239:1: stat_tail : ( special_expr | ( ID stat_tail_tail ) );
	public final void stat_tail() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:240:3: ( special_expr | ( ID stat_tail_tail ) )
			int alt17=2;
			int LA17_0 = input.LA(1);
			if ( (LA17_0==FIXEDPTLIT||LA17_0==INTLIT||LA17_0==LPAREN) ) {
				alt17=1;
			}
			else if ( (LA17_0==ID) ) {
				alt17=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 17, 0, input);
				throw nvae;
			}

			switch (alt17) {
				case 1 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:240:5: special_expr
					{
					pushFollow(FOLLOW_special_expr_in_stat_tail1234);
					special_expr();
					state._fsp--;

					}
					break;
				case 2 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:241:5: ( ID stat_tail_tail )
					{
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:241:5: ( ID stat_tail_tail )
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:241:6: ID stat_tail_tail
					{
					match(input,ID,FOLLOW_ID_in_stat_tail1241); 
					pushFollow(FOLLOW_stat_tail_tail_in_stat_tail1243);
					stat_tail_tail();
					state._fsp--;

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
	}
	// $ANTLR end "stat_tail"



	// $ANTLR start "stat_tail_tail"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:244:1: stat_tail_tail : ( value_expr | '(' expr_list ')' );
	public final void stat_tail_tail() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:245:3: ( value_expr | '(' expr_list ')' )
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( ((LA18_0 >= AND && LA18_0 <= ASSIGN)||LA18_0==COMMA||(LA18_0 >= DIV && LA18_0 <= EQ)||(LA18_0 >= GREATER && LA18_0 <= GREATEREQ)||(LA18_0 >= LBRACK && LA18_0 <= LESSEREQ)||(LA18_0 >= MINUS && LA18_0 <= MULT)||(LA18_0 >= NEQ && LA18_0 <= OR)||LA18_0==PLUS||LA18_0==RPAREN||(LA18_0 >= SEMI && LA18_0 <= Then)) ) {
				alt18=1;
			}
			else if ( (LA18_0==LPAREN) ) {
				alt18=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 18, 0, input);
				throw nvae;
			}

			switch (alt18) {
				case 1 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:245:5: value_expr
					{
					pushFollow(FOLLOW_value_expr_in_stat_tail_tail1260);
					value_expr();
					state._fsp--;

					}
					break;
				case 2 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:246:5: '(' expr_list ')'
					{
					match(input,LPAREN,FOLLOW_LPAREN_in_stat_tail_tail1266); 
					pushFollow(FOLLOW_expr_list_in_stat_tail_tail1268);
					expr_list();
					state._fsp--;

					match(input,RPAREN,FOLLOW_RPAREN_in_stat_tail_tail1270); 
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
	// $ANTLR end "stat_tail_tail"



	// $ANTLR start "special_expr"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:250:1: special_expr : special_expr_head special_expr_tail ;
	public final void special_expr() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:251:3: ( special_expr_head special_expr_tail )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:251:5: special_expr_head special_expr_tail
			{
			pushFollow(FOLLOW_special_expr_head_in_special_expr1286);
			special_expr_head();
			state._fsp--;

			pushFollow(FOLLOW_special_expr_tail_in_special_expr1288);
			special_expr_tail();
			state._fsp--;

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
	// $ANTLR end "special_expr"



	// $ANTLR start "special_expr_tail"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:254:1: special_expr_tail : ( logical_op expr | special_expr1 );
	public final void special_expr_tail() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:255:3: ( logical_op expr | special_expr1 )
			int alt19=2;
			int LA19_0 = input.LA(1);
			if ( (LA19_0==AND||LA19_0==OR) ) {
				alt19=1;
			}
			else if ( (LA19_0==DIV||LA19_0==EQ||(LA19_0 >= GREATER && LA19_0 <= GREATEREQ)||(LA19_0 >= LESSER && LA19_0 <= LESSEREQ)||(LA19_0 >= MINUS && LA19_0 <= MULT)||LA19_0==NEQ||LA19_0==PLUS||LA19_0==SEMI) ) {
				alt19=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 19, 0, input);
				throw nvae;
			}

			switch (alt19) {
				case 1 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:255:5: logical_op expr
					{
					pushFollow(FOLLOW_logical_op_in_special_expr_tail1303);
					logical_op();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_special_expr_tail1305);
					expr();
					state._fsp--;

					}
					break;
				case 2 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:256:5: special_expr1
					{
					pushFollow(FOLLOW_special_expr1_in_special_expr_tail1311);
					special_expr1();
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
	// $ANTLR end "special_expr_tail"



	// $ANTLR start "special_expr1"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:259:1: special_expr1 : ( compar_op expr | special_expr2 );
	public final void special_expr1() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:260:3: ( compar_op expr | special_expr2 )
			int alt20=2;
			int LA20_0 = input.LA(1);
			if ( (LA20_0==EQ||(LA20_0 >= GREATER && LA20_0 <= GREATEREQ)||(LA20_0 >= LESSER && LA20_0 <= LESSEREQ)||LA20_0==NEQ) ) {
				alt20=1;
			}
			else if ( (LA20_0==DIV||(LA20_0 >= MINUS && LA20_0 <= MULT)||LA20_0==PLUS||LA20_0==SEMI) ) {
				alt20=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 20, 0, input);
				throw nvae;
			}

			switch (alt20) {
				case 1 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:260:5: compar_op expr
					{
					pushFollow(FOLLOW_compar_op_in_special_expr11324);
					compar_op();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_special_expr11326);
					expr();
					state._fsp--;

					}
					break;
				case 2 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:261:5: special_expr2
					{
					pushFollow(FOLLOW_special_expr2_in_special_expr11332);
					special_expr2();
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
	// $ANTLR end "special_expr1"



	// $ANTLR start "special_expr2"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:264:1: special_expr2 : ( add_op expr | special_expr3 );
	public final void special_expr2() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:265:3: ( add_op expr | special_expr3 )
			int alt21=2;
			int LA21_0 = input.LA(1);
			if ( (LA21_0==MINUS||LA21_0==PLUS) ) {
				alt21=1;
			}
			else if ( (LA21_0==DIV||LA21_0==MULT||LA21_0==SEMI) ) {
				alt21=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 21, 0, input);
				throw nvae;
			}

			switch (alt21) {
				case 1 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:265:5: add_op expr
					{
					pushFollow(FOLLOW_add_op_in_special_expr21345);
					add_op();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_special_expr21347);
					expr();
					state._fsp--;

					}
					break;
				case 2 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:266:5: special_expr3
					{
					pushFollow(FOLLOW_special_expr3_in_special_expr21353);
					special_expr3();
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
	// $ANTLR end "special_expr2"



	// $ANTLR start "special_expr3"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:269:1: special_expr3 : ( mul_op expr )? ;
	public final void special_expr3() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:270:3: ( ( mul_op expr )? )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:270:5: ( mul_op expr )?
			{
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:270:5: ( mul_op expr )?
			int alt22=2;
			int LA22_0 = input.LA(1);
			if ( (LA22_0==DIV||LA22_0==MULT) ) {
				alt22=1;
			}
			switch (alt22) {
				case 1 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:270:6: mul_op expr
					{
					pushFollow(FOLLOW_mul_op_in_special_expr31371);
					mul_op();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_special_expr31373);
					expr();
					state._fsp--;

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
	}
	// $ANTLR end "special_expr3"



	// $ANTLR start "special_expr_head"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:273:1: special_expr_head : ( ( '(' expr ')' ) | constant );
	public final void special_expr_head() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:274:3: ( ( '(' expr ')' ) | constant )
			int alt23=2;
			int LA23_0 = input.LA(1);
			if ( (LA23_0==LPAREN) ) {
				alt23=1;
			}
			else if ( (LA23_0==FIXEDPTLIT||LA23_0==INTLIT) ) {
				alt23=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 23, 0, input);
				throw nvae;
			}

			switch (alt23) {
				case 1 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:274:5: ( '(' expr ')' )
					{
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:274:5: ( '(' expr ')' )
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:274:6: '(' expr ')'
					{
					match(input,LPAREN,FOLLOW_LPAREN_in_special_expr_head1395); 
					pushFollow(FOLLOW_expr_in_special_expr_head1397);
					expr();
					state._fsp--;

					match(input,RPAREN,FOLLOW_RPAREN_in_special_expr_head1399); 
					}

					}
					break;
				case 2 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:274:24: constant
					{
					pushFollow(FOLLOW_constant_in_special_expr_head1406);
					constant();
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
	// $ANTLR end "special_expr_head"



	// $ANTLR start "value_expr"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:278:1: value_expr : value_expr_head value_expr_tail ;
	public final void value_expr() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:279:3: ( value_expr_head value_expr_tail )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:279:5: value_expr_head value_expr_tail
			{
			pushFollow(FOLLOW_value_expr_head_in_value_expr1420);
			value_expr_head();
			state._fsp--;

			pushFollow(FOLLOW_value_expr_tail_in_value_expr1423);
			value_expr_tail();
			state._fsp--;

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
	// $ANTLR end "value_expr"



	// $ANTLR start "value_expr_tail"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:282:1: value_expr_tail : ( logical_op expr | value_expr1 );
	public final void value_expr_tail() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:283:3: ( logical_op expr | value_expr1 )
			int alt24=2;
			int LA24_0 = input.LA(1);
			if ( (LA24_0==AND||LA24_0==OR) ) {
				alt24=1;
			}
			else if ( (LA24_0==DIV||LA24_0==EQ||(LA24_0 >= GREATER && LA24_0 <= GREATEREQ)||(LA24_0 >= LESSER && LA24_0 <= LESSEREQ)||(LA24_0 >= MINUS && LA24_0 <= MULT)||LA24_0==NEQ||LA24_0==PLUS||LA24_0==SEMI) ) {
				alt24=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 24, 0, input);
				throw nvae;
			}

			switch (alt24) {
				case 1 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:283:5: logical_op expr
					{
					pushFollow(FOLLOW_logical_op_in_value_expr_tail1439);
					logical_op();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_value_expr_tail1441);
					expr();
					state._fsp--;

					}
					break;
				case 2 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:284:5: value_expr1
					{
					pushFollow(FOLLOW_value_expr1_in_value_expr_tail1447);
					value_expr1();
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
	// $ANTLR end "value_expr_tail"



	// $ANTLR start "value_expr1"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:287:1: value_expr1 : ( compar_op expr | value_expr2 );
	public final void value_expr1() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:288:3: ( compar_op expr | value_expr2 )
			int alt25=2;
			int LA25_0 = input.LA(1);
			if ( (LA25_0==EQ||(LA25_0 >= GREATER && LA25_0 <= GREATEREQ)||(LA25_0 >= LESSER && LA25_0 <= LESSEREQ)||LA25_0==NEQ) ) {
				alt25=1;
			}
			else if ( (LA25_0==DIV||(LA25_0 >= MINUS && LA25_0 <= MULT)||LA25_0==PLUS||LA25_0==SEMI) ) {
				alt25=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 25, 0, input);
				throw nvae;
			}

			switch (alt25) {
				case 1 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:288:5: compar_op expr
					{
					pushFollow(FOLLOW_compar_op_in_value_expr11460);
					compar_op();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_value_expr11462);
					expr();
					state._fsp--;

					}
					break;
				case 2 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:289:5: value_expr2
					{
					pushFollow(FOLLOW_value_expr2_in_value_expr11468);
					value_expr2();
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
	// $ANTLR end "value_expr1"



	// $ANTLR start "value_expr2"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:292:1: value_expr2 : ( add_op expr | value_expr3 );
	public final void value_expr2() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:293:3: ( add_op expr | value_expr3 )
			int alt26=2;
			int LA26_0 = input.LA(1);
			if ( (LA26_0==MINUS||LA26_0==PLUS) ) {
				alt26=1;
			}
			else if ( (LA26_0==DIV||LA26_0==MULT||LA26_0==SEMI) ) {
				alt26=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 26, 0, input);
				throw nvae;
			}

			switch (alt26) {
				case 1 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:293:5: add_op expr
					{
					pushFollow(FOLLOW_add_op_in_value_expr21481);
					add_op();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_value_expr21483);
					expr();
					state._fsp--;

					}
					break;
				case 2 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:294:5: value_expr3
					{
					pushFollow(FOLLOW_value_expr3_in_value_expr21489);
					value_expr3();
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
	// $ANTLR end "value_expr2"



	// $ANTLR start "value_expr3"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:297:1: value_expr3 : ( mul_op expr )? ;
	public final void value_expr3() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:298:3: ( ( mul_op expr )? )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:298:5: ( mul_op expr )?
			{
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:298:5: ( mul_op expr )?
			int alt27=2;
			int LA27_0 = input.LA(1);
			if ( (LA27_0==DIV||LA27_0==MULT) ) {
				alt27=1;
			}
			switch (alt27) {
				case 1 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:298:6: mul_op expr
					{
					pushFollow(FOLLOW_mul_op_in_value_expr31507);
					mul_op();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_value_expr31509);
					expr();
					state._fsp--;

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
	}
	// $ANTLR end "value_expr3"



	// $ANTLR start "value_expr_head"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:301:1: value_expr_head : value_tail ;
	public final void value_expr_head() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:302:3: ( value_tail )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:302:5: value_tail
			{
			pushFollow(FOLLOW_value_tail_in_value_expr_head1530);
			value_tail();
			state._fsp--;

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
	// $ANTLR end "value_expr_head"



	// $ANTLR start "if_stat"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:312:1: if_stat : ( If expr Then stat_seq else_stat Endif ';' ) ;
	public final void if_stat() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:313:3: ( ( If expr Then stat_seq else_stat Endif ';' ) )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:313:5: ( If expr Then stat_seq else_stat Endif ';' )
			{
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:313:5: ( If expr Then stat_seq else_stat Endif ';' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:313:6: If expr Then stat_seq else_stat Endif ';'
			{
			match(input,If,FOLLOW_If_in_if_stat1565); 
			pushFollow(FOLLOW_expr_in_if_stat1567);
			expr();
			state._fsp--;

			match(input,Then,FOLLOW_Then_in_if_stat1569); 
			pushFollow(FOLLOW_stat_seq_in_if_stat1571);
			stat_seq();
			state._fsp--;

			pushFollow(FOLLOW_else_stat_in_if_stat1573);
			else_stat();
			state._fsp--;

			match(input,Endif,FOLLOW_Endif_in_if_stat1575); 
			match(input,SEMI,FOLLOW_SEMI_in_if_stat1577); 
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
	// $ANTLR end "if_stat"



	// $ANTLR start "else_stat"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:316:1: else_stat : ( Else stat_seq )? ;
	public final void else_stat() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:317:3: ( ( Else stat_seq )? )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:317:6: ( Else stat_seq )?
			{
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:317:6: ( Else stat_seq )?
			int alt28=2;
			int LA28_0 = input.LA(1);
			if ( (LA28_0==Else) ) {
				alt28=1;
			}
			switch (alt28) {
				case 1 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:317:8: Else stat_seq
					{
					match(input,Else,FOLLOW_Else_in_else_stat1594); 
					pushFollow(FOLLOW_stat_seq_in_else_stat1596);
					stat_seq();
					state._fsp--;

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
	}
	// $ANTLR end "else_stat"



	// $ANTLR start "while_stat"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:320:1: while_stat : ( While expr Do stat_seq Enddo ';' ) ;
	public final void while_stat() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:321:3: ( ( While expr Do stat_seq Enddo ';' ) )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:321:5: ( While expr Do stat_seq Enddo ';' )
			{
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:321:5: ( While expr Do stat_seq Enddo ';' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:321:6: While expr Do stat_seq Enddo ';'
			{
			match(input,While,FOLLOW_While_in_while_stat1613); 
			pushFollow(FOLLOW_expr_in_while_stat1615);
			expr();
			state._fsp--;

			match(input,Do,FOLLOW_Do_in_while_stat1617); 
			pushFollow(FOLLOW_stat_seq_in_while_stat1619);
			stat_seq();
			state._fsp--;

			match(input,Enddo,FOLLOW_Enddo_in_while_stat1621); 
			match(input,SEMI,FOLLOW_SEMI_in_while_stat1623); 
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
	// $ANTLR end "while_stat"



	// $ANTLR start "for_stat"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:324:1: for_stat : ( For ID ':=' index_expr To index_expr Do stat_seq Enddo ';' ) ;
	public final void for_stat() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:325:3: ( ( For ID ':=' index_expr To index_expr Do stat_seq Enddo ';' ) )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:325:5: ( For ID ':=' index_expr To index_expr Do stat_seq Enddo ';' )
			{
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:325:5: ( For ID ':=' index_expr To index_expr Do stat_seq Enddo ';' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:325:6: For ID ':=' index_expr To index_expr Do stat_seq Enddo ';'
			{
			match(input,For,FOLLOW_For_in_for_stat1638); 
			match(input,ID,FOLLOW_ID_in_for_stat1640); 
			match(input,ASSIGN,FOLLOW_ASSIGN_in_for_stat1642); 
			pushFollow(FOLLOW_index_expr_in_for_stat1644);
			index_expr();
			state._fsp--;

			match(input,To,FOLLOW_To_in_for_stat1646); 
			pushFollow(FOLLOW_index_expr_in_for_stat1648);
			index_expr();
			state._fsp--;

			match(input,Do,FOLLOW_Do_in_for_stat1650); 
			pushFollow(FOLLOW_stat_seq_in_for_stat1652);
			stat_seq();
			state._fsp--;

			match(input,Enddo,FOLLOW_Enddo_in_for_stat1654); 
			match(input,SEMI,FOLLOW_SEMI_in_for_stat1656); 
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
	// $ANTLR end "for_stat"



	// $ANTLR start "break_stat"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:328:1: break_stat : ( Break ';' ) ;
	public final void break_stat() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:329:3: ( ( Break ';' ) )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:329:5: ( Break ';' )
			{
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:329:5: ( Break ';' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:329:6: Break ';'
			{
			match(input,Break,FOLLOW_Break_in_break_stat1672); 
			match(input,SEMI,FOLLOW_SEMI_in_break_stat1673); 
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
	// $ANTLR end "break_stat"



	// $ANTLR start "return_stat"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:332:1: return_stat : ( Return expr ';' ) ;
	public final void return_stat() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:333:3: ( ( Return expr ';' ) )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:333:5: ( Return expr ';' )
			{
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:333:5: ( Return expr ';' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:333:6: Return expr ';'
			{
			match(input,Return,FOLLOW_Return_in_return_stat1689); 
			pushFollow(FOLLOW_expr_in_return_stat1691);
			expr();
			state._fsp--;

			match(input,SEMI,FOLLOW_SEMI_in_return_stat1693); 
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
	// $ANTLR end "return_stat"



	// $ANTLR start "expr"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:344:1: expr : expr1 expr_tail ;
	public final void expr() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:345:3: ( expr1 expr_tail )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:345:5: expr1 expr_tail
			{
			pushFollow(FOLLOW_expr1_in_expr1716);
			expr1();
			state._fsp--;

			pushFollow(FOLLOW_expr_tail_in_expr1718);
			expr_tail();
			state._fsp--;

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
	// $ANTLR end "expr"



	// $ANTLR start "expr_tail"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:348:1: expr_tail : ( logical_op expr1 expr_tail )? ;
	public final void expr_tail() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:349:3: ( ( logical_op expr1 expr_tail )? )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:349:5: ( logical_op expr1 expr_tail )?
			{
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:349:5: ( logical_op expr1 expr_tail )?
			int alt29=2;
			int LA29_0 = input.LA(1);
			if ( (LA29_0==AND||LA29_0==OR) ) {
				alt29=1;
			}
			switch (alt29) {
				case 1 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:349:6: logical_op expr1 expr_tail
					{
					pushFollow(FOLLOW_logical_op_in_expr_tail1732);
					logical_op();
					state._fsp--;

					pushFollow(FOLLOW_expr1_in_expr_tail1734);
					expr1();
					state._fsp--;

					pushFollow(FOLLOW_expr_tail_in_expr_tail1736);
					expr_tail();
					state._fsp--;

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
	}
	// $ANTLR end "expr_tail"



	// $ANTLR start "logical_op"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:352:1: logical_op : ( '&' | '|' );
	public final void logical_op() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:353:3: ( '&' | '|' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:
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



	// $ANTLR start "expr1"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:356:1: expr1 : expr2 expr1_tail ;
	public final void expr1() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:357:3: ( expr2 expr1_tail )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:357:5: expr2 expr1_tail
			{
			pushFollow(FOLLOW_expr2_in_expr11768);
			expr2();
			state._fsp--;

			pushFollow(FOLLOW_expr1_tail_in_expr11770);
			expr1_tail();
			state._fsp--;

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
	// $ANTLR end "expr1"



	// $ANTLR start "expr1_tail"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:360:1: expr1_tail : ( compar_op expr2 expr1_tail )? ;
	public final void expr1_tail() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:361:3: ( ( compar_op expr2 expr1_tail )? )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:361:5: ( compar_op expr2 expr1_tail )?
			{
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:361:5: ( compar_op expr2 expr1_tail )?
			int alt30=2;
			int LA30_0 = input.LA(1);
			if ( (LA30_0==EQ||(LA30_0 >= GREATER && LA30_0 <= GREATEREQ)||(LA30_0 >= LESSER && LA30_0 <= LESSEREQ)||LA30_0==NEQ) ) {
				alt30=1;
			}
			switch (alt30) {
				case 1 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:361:6: compar_op expr2 expr1_tail
					{
					pushFollow(FOLLOW_compar_op_in_expr1_tail1784);
					compar_op();
					state._fsp--;

					pushFollow(FOLLOW_expr2_in_expr1_tail1786);
					expr2();
					state._fsp--;

					pushFollow(FOLLOW_expr1_tail_in_expr1_tail1788);
					expr1_tail();
					state._fsp--;

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
	}
	// $ANTLR end "expr1_tail"



	// $ANTLR start "compar_op"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:364:1: compar_op : ( '=' | '<>' | '<' | '>' | '<=' | '>=' );
	public final void compar_op() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:365:3: ( '=' | '<>' | '<' | '>' | '<=' | '>=' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:
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
	// $ANTLR end "compar_op"



	// $ANTLR start "expr2"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:368:1: expr2 : expr3 expr2_tail ;
	public final void expr2() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:369:3: ( expr3 expr2_tail )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:369:5: expr3 expr2_tail
			{
			pushFollow(FOLLOW_expr3_in_expr21836);
			expr3();
			state._fsp--;

			pushFollow(FOLLOW_expr2_tail_in_expr21838);
			expr2_tail();
			state._fsp--;

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
	// $ANTLR end "expr2"



	// $ANTLR start "expr2_tail"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:372:1: expr2_tail : ( add_op expr3 expr2_tail )? ;
	public final void expr2_tail() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:373:3: ( ( add_op expr3 expr2_tail )? )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:373:5: ( add_op expr3 expr2_tail )?
			{
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:373:5: ( add_op expr3 expr2_tail )?
			int alt31=2;
			int LA31_0 = input.LA(1);
			if ( (LA31_0==MINUS||LA31_0==PLUS) ) {
				alt31=1;
			}
			switch (alt31) {
				case 1 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:373:6: add_op expr3 expr2_tail
					{
					pushFollow(FOLLOW_add_op_in_expr2_tail1852);
					add_op();
					state._fsp--;

					pushFollow(FOLLOW_expr3_in_expr2_tail1854);
					expr3();
					state._fsp--;

					pushFollow(FOLLOW_expr2_tail_in_expr2_tail1856);
					expr2_tail();
					state._fsp--;

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
	}
	// $ANTLR end "expr2_tail"



	// $ANTLR start "add_op"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:376:1: add_op : ( '+' | '-' );
	public final void add_op() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:377:3: ( '+' | '-' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:
			{
			if ( input.LA(1)==MINUS||input.LA(1)==PLUS ) {
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
	// $ANTLR end "add_op"



	// $ANTLR start "expr3"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:380:1: expr3 : factor expr3_tail ;
	public final void expr3() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:381:3: ( factor expr3_tail )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:381:5: factor expr3_tail
			{
			pushFollow(FOLLOW_factor_in_expr31888);
			factor();
			state._fsp--;

			pushFollow(FOLLOW_expr3_tail_in_expr31890);
			expr3_tail();
			state._fsp--;

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
	// $ANTLR end "expr3"



	// $ANTLR start "expr3_tail"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:384:1: expr3_tail : ( mul_op factor expr3_tail )? ;
	public final void expr3_tail() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:385:3: ( ( mul_op factor expr3_tail )? )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:385:5: ( mul_op factor expr3_tail )?
			{
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:385:5: ( mul_op factor expr3_tail )?
			int alt32=2;
			int LA32_0 = input.LA(1);
			if ( (LA32_0==DIV||LA32_0==MULT) ) {
				alt32=1;
			}
			switch (alt32) {
				case 1 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:385:6: mul_op factor expr3_tail
					{
					pushFollow(FOLLOW_mul_op_in_expr3_tail1904);
					mul_op();
					state._fsp--;

					pushFollow(FOLLOW_factor_in_expr3_tail1906);
					factor();
					state._fsp--;

					pushFollow(FOLLOW_expr3_tail_in_expr3_tail1908);
					expr3_tail();
					state._fsp--;

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
	}
	// $ANTLR end "expr3_tail"



	// $ANTLR start "mul_op"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:388:1: mul_op : ( '*' | '/' );
	public final void mul_op() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:389:3: ( '*' | '/' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:
			{
			if ( input.LA(1)==DIV||input.LA(1)==MULT ) {
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
	// $ANTLR end "mul_op"



	// $ANTLR start "factor"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:392:1: factor : ( ( '(' expr ')' ) | constant | value );
	public final void factor() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:393:3: ( ( '(' expr ')' ) | constant | value )
			int alt33=3;
			switch ( input.LA(1) ) {
			case LPAREN:
				{
				alt33=1;
				}
				break;
			case FIXEDPTLIT:
			case INTLIT:
				{
				alt33=2;
				}
				break;
			case ID:
				{
				alt33=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 33, 0, input);
				throw nvae;
			}
			switch (alt33) {
				case 1 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:393:5: ( '(' expr ')' )
					{
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:393:5: ( '(' expr ')' )
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:393:6: '(' expr ')'
					{
					match(input,LPAREN,FOLLOW_LPAREN_in_factor1941); 
					pushFollow(FOLLOW_expr_in_factor1943);
					expr();
					state._fsp--;

					match(input,RPAREN,FOLLOW_RPAREN_in_factor1945); 
					}

					}
					break;
				case 2 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:393:24: constant
					{
					pushFollow(FOLLOW_constant_in_factor1952);
					constant();
					state._fsp--;

					}
					break;
				case 3 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:393:34: value
					{
					pushFollow(FOLLOW_value_in_factor1955);
					value();
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
	// $ANTLR end "factor"



	// $ANTLR start "constant"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:397:1: constant : ( INTLIT | FIXEDPTLIT );
	public final void constant() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:398:3: ( INTLIT | FIXEDPTLIT )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:
			{
			if ( input.LA(1)==FIXEDPTLIT||input.LA(1)==INTLIT ) {
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
	// $ANTLR end "constant"



	// $ANTLR start "expr_list"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:403:1: expr_list : ( expr expr_list_tail )? ;
	public final void expr_list() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:404:3: ( ( expr expr_list_tail )? )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:404:5: ( expr expr_list_tail )?
			{
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:404:5: ( expr expr_list_tail )?
			int alt34=2;
			int LA34_0 = input.LA(1);
			if ( (LA34_0==FIXEDPTLIT||(LA34_0 >= ID && LA34_0 <= INTLIT)||LA34_0==LPAREN) ) {
				alt34=1;
			}
			switch (alt34) {
				case 1 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:404:6: expr expr_list_tail
					{
					pushFollow(FOLLOW_expr_in_expr_list1991);
					expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_list_tail_in_expr_list1993);
					expr_list_tail();
					state._fsp--;

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
	}
	// $ANTLR end "expr_list"



	// $ANTLR start "expr_list_tail"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:407:1: expr_list_tail : ( ',' expr expr_list_tail )? ;
	public final void expr_list_tail() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:408:3: ( ( ',' expr expr_list_tail )? )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:408:5: ( ',' expr expr_list_tail )?
			{
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:408:5: ( ',' expr expr_list_tail )?
			int alt35=2;
			int LA35_0 = input.LA(1);
			if ( (LA35_0==COMMA) ) {
				alt35=1;
			}
			switch (alt35) {
				case 1 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:408:6: ',' expr expr_list_tail
					{
					match(input,COMMA,FOLLOW_COMMA_in_expr_list_tail2011); 
					pushFollow(FOLLOW_expr_in_expr_list_tail2013);
					expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_list_tail_in_expr_list_tail2015);
					expr_list_tail();
					state._fsp--;

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
	}
	// $ANTLR end "expr_list_tail"



	// $ANTLR start "value"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:412:1: value : ID value_tail ;
	public final void value() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:413:3: ( ID value_tail )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:413:5: ID value_tail
			{
			match(input,ID,FOLLOW_ID_in_value2031); 
			pushFollow(FOLLOW_value_tail_in_value2033);
			value_tail();
			state._fsp--;

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
	// $ANTLR end "value"



	// $ANTLR start "value_tail"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:422:1: value_tail : ( '[' index_expr ']' value_tail_tail )? ;
	public final void value_tail() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:423:3: ( ( '[' index_expr ']' value_tail_tail )? )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:423:6: ( '[' index_expr ']' value_tail_tail )?
			{
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:423:6: ( '[' index_expr ']' value_tail_tail )?
			int alt36=2;
			int LA36_0 = input.LA(1);
			if ( (LA36_0==LBRACK) ) {
				alt36=1;
			}
			switch (alt36) {
				case 1 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:423:7: '[' index_expr ']' value_tail_tail
					{
					match(input,LBRACK,FOLLOW_LBRACK_in_value_tail2054); 
					pushFollow(FOLLOW_index_expr_in_value_tail2056);
					index_expr();
					state._fsp--;

					match(input,RBRACK,FOLLOW_RBRACK_in_value_tail2058); 
					pushFollow(FOLLOW_value_tail_tail_in_value_tail2060);
					value_tail_tail();
					state._fsp--;

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
	}
	// $ANTLR end "value_tail"



	// $ANTLR start "value_tail_tail"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:425:1: value_tail_tail : ( '[' index_expr ']' )? ;
	public final void value_tail_tail() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:426:3: ( ( '[' index_expr ']' )? )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:426:5: ( '[' index_expr ']' )?
			{
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:426:5: ( '[' index_expr ']' )?
			int alt37=2;
			int LA37_0 = input.LA(1);
			if ( (LA37_0==LBRACK) ) {
				alt37=1;
			}
			switch (alt37) {
				case 1 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:426:6: '[' index_expr ']'
					{
					match(input,LBRACK,FOLLOW_LBRACK_in_value_tail_tail2076); 
					pushFollow(FOLLOW_index_expr_in_value_tail_tail2078);
					index_expr();
					state._fsp--;

					match(input,RBRACK,FOLLOW_RBRACK_in_value_tail_tail2080); 
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
	}
	// $ANTLR end "value_tail_tail"



	// $ANTLR start "index_expr"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:436:1: index_expr : index_expr1 index_expr_tail ;
	public final void index_expr() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:437:3: ( index_expr1 index_expr_tail )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:437:5: index_expr1 index_expr_tail
			{
			pushFollow(FOLLOW_index_expr1_in_index_expr2102);
			index_expr1();
			state._fsp--;

			pushFollow(FOLLOW_index_expr_tail_in_index_expr2104);
			index_expr_tail();
			state._fsp--;

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
	// $ANTLR end "index_expr"



	// $ANTLR start "index_expr_tail"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:440:1: index_expr_tail : ( index_add_op index_expr1 index_expr_tail )? ;
	public final void index_expr_tail() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:441:3: ( ( index_add_op index_expr1 index_expr_tail )? )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:441:5: ( index_add_op index_expr1 index_expr_tail )?
			{
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:441:5: ( index_add_op index_expr1 index_expr_tail )?
			int alt38=2;
			int LA38_0 = input.LA(1);
			if ( (LA38_0==MINUS||LA38_0==PLUS) ) {
				alt38=1;
			}
			switch (alt38) {
				case 1 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:441:6: index_add_op index_expr1 index_expr_tail
					{
					pushFollow(FOLLOW_index_add_op_in_index_expr_tail2118);
					index_add_op();
					state._fsp--;

					pushFollow(FOLLOW_index_expr1_in_index_expr_tail2120);
					index_expr1();
					state._fsp--;

					pushFollow(FOLLOW_index_expr_tail_in_index_expr_tail2122);
					index_expr_tail();
					state._fsp--;

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
	}
	// $ANTLR end "index_expr_tail"



	// $ANTLR start "index_add_op"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:444:1: index_add_op : ( '+' | '-' );
	public final void index_add_op() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:445:3: ( '+' | '-' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:
			{
			if ( input.LA(1)==MINUS||input.LA(1)==PLUS ) {
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
	// $ANTLR end "index_add_op"



	// $ANTLR start "index_expr1"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:448:1: index_expr1 : index_expr_factor index_expr1_tail ;
	public final void index_expr1() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:449:3: ( index_expr_factor index_expr1_tail )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:449:5: index_expr_factor index_expr1_tail
			{
			pushFollow(FOLLOW_index_expr_factor_in_index_expr12154);
			index_expr_factor();
			state._fsp--;

			pushFollow(FOLLOW_index_expr1_tail_in_index_expr12156);
			index_expr1_tail();
			state._fsp--;

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
	// $ANTLR end "index_expr1"



	// $ANTLR start "index_expr1_tail"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:452:1: index_expr1_tail : ( index_mul_op index_expr_factor index_expr1_tail )? ;
	public final void index_expr1_tail() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:453:3: ( ( index_mul_op index_expr_factor index_expr1_tail )? )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:453:5: ( index_mul_op index_expr_factor index_expr1_tail )?
			{
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:453:5: ( index_mul_op index_expr_factor index_expr1_tail )?
			int alt39=2;
			int LA39_0 = input.LA(1);
			if ( (LA39_0==MULT) ) {
				alt39=1;
			}
			switch (alt39) {
				case 1 :
					// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:453:6: index_mul_op index_expr_factor index_expr1_tail
					{
					pushFollow(FOLLOW_index_mul_op_in_index_expr1_tail2170);
					index_mul_op();
					state._fsp--;

					pushFollow(FOLLOW_index_expr_factor_in_index_expr1_tail2172);
					index_expr_factor();
					state._fsp--;

					pushFollow(FOLLOW_index_expr1_tail_in_index_expr1_tail2174);
					index_expr1_tail();
					state._fsp--;

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
	}
	// $ANTLR end "index_expr1_tail"



	// $ANTLR start "index_mul_op"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:456:1: index_mul_op : '*' ;
	public final void index_mul_op() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:457:3: ( '*' )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:457:5: '*'
			{
			match(input,MULT,FOLLOW_MULT_in_index_mul_op2189); 
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
	// $ANTLR end "index_mul_op"



	// $ANTLR start "index_expr_factor"
	// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:460:1: index_expr_factor : ( INTLIT | ID );
	public final void index_expr_factor() throws RecognitionException {
		try {
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:461:3: ( INTLIT | ID )
			// /home/q/Desktop/CS4240/ANTLR/Phase1/Phase1_Deliverable/Tiger.g:
			{
			if ( (input.LA(1) >= ID && input.LA(1) <= INTLIT) ) {
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
	// $ANTLR end "index_expr_factor"

	// Delegated rules



	public static final BitSet FOLLOW_type_declaration_list_in_tiger_program47 = new BitSet(new long[]{0x0001000012100000L});
	public static final BitSet FOLLOW_funct_declaration_in_tiger_program49 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_main_function_in_tiger_program51 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Void_in_funct_declaration530 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_funct_declaration_tail_in_funct_declaration532 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_funct_declaration_type_id_in_funct_declaration538 = new BitSet(new long[]{0x0001000012100000L});
	public static final BitSet FOLLOW_funct_declaration_in_funct_declaration540 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_funct_declaration_void_in_funct_declaration_tail556 = new BitSet(new long[]{0x0001000012100000L});
	public static final BitSet FOLLOW_funct_declaration_in_funct_declaration_tail558 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_id_in_funct_declaration_type_id575 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_Function_in_funct_declaration_type_id577 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_ID_in_funct_declaration_type_id579 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_LPAREN_in_funct_declaration_type_id581 = new BitSet(new long[]{0x0000020002000000L});
	public static final BitSet FOLLOW_param_list_in_funct_declaration_type_id583 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_RPAREN_in_funct_declaration_type_id585 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Begin_in_funct_declaration_type_id587 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_block_list_in_funct_declaration_type_id589 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_End_in_funct_declaration_type_id591 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_SEMI_in_funct_declaration_type_id593 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Function_in_funct_declaration_void605 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_ID_in_funct_declaration_void607 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_LPAREN_in_funct_declaration_void609 = new BitSet(new long[]{0x0000020002000000L});
	public static final BitSet FOLLOW_param_list_in_funct_declaration_void611 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_RPAREN_in_funct_declaration_void613 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Begin_in_funct_declaration_void615 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_block_list_in_funct_declaration_void617 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_End_in_funct_declaration_void619 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_SEMI_in_funct_declaration_void621 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Main_in_main_function635 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_LPAREN_in_main_function637 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_RPAREN_in_main_function638 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Begin_in_main_function640 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_block_list_in_main_function642 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_End_in_main_function644 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_SEMI_in_main_function646 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Void_in_ret_type668 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_id_in_ret_type674 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_param_in_param_list691 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_param_list_tail_in_param_list693 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COMMA_in_param_list_tail708 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_param_in_param_list_tail710 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_param_list_tail_in_param_list_tail712 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_param726 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_COLON_in_param728 = new BitSet(new long[]{0x0000000012100000L});
	public static final BitSet FOLLOW_type_id_in_param730 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_block_list745 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_block_tail_in_block_list747 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_block_tail766 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_block_tail_in_block_tail768 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Begin_in_block787 = new BitSet(new long[]{0x0000C00000000000L});
	public static final BitSet FOLLOW_declaration_segment_in_block789 = new BitSet(new long[]{0x000404000A200180L});
	public static final BitSet FOLLOW_stat_seq_in_block791 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_End_in_block793 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_SEMI_in_block795 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_declaration_list_in_declaration_segment808 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_var_declaration_list_in_declaration_segment810 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_declaration_in_type_declaration_list824 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_type_declaration_list_in_type_declaration_list826 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_declaration_in_var_declaration_list842 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_var_declaration_list_in_var_declaration_list844 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Type_in_type_declaration859 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_ID_in_type_declaration861 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_EQ_in_type_declaration863 = new BitSet(new long[]{0x0000000010100040L});
	public static final BitSet FOLLOW_type_in_type_declaration865 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_SEMI_in_type_declaration867 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_base_type_in_type893 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Array_in_type898 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_51_in_type900 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_INTLIT_in_type902 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_RBRACK_in_type904 = new BitSet(new long[]{0x0000004020000000L});
	public static final BitSet FOLLOW_type_tail_in_type906 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_Of_in_type908 = new BitSet(new long[]{0x0000000010100000L});
	public static final BitSet FOLLOW_base_type_in_type910 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LBRACK_in_type_tail928 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_INTLIT_in_type_tail930 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_RBRACK_in_type_tail932 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_base_type_in_type_id950 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_type_id958 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Var_in_var_declaration991 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_id_list_in_var_declaration993 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_COLON_in_var_declaration995 = new BitSet(new long[]{0x0000000012100000L});
	public static final BitSet FOLLOW_type_id_in_var_declaration997 = new BitSet(new long[]{0x0000080000000020L});
	public static final BitSet FOLLOW_optional_init_in_var_declaration999 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_SEMI_in_var_declaration1001 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_id_list1020 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_id_list_tail_in_id_list1022 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COMMA_in_id_list_tail1037 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_id_list_in_id_list_tail1039 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ASSIGN_in_optional_init1060 = new BitSet(new long[]{0x0000000004080000L});
	public static final BitSet FOLLOW_constant_in_optional_init1062 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_stat_in_stat_seq1088 = new BitSet(new long[]{0x000404000A200180L});
	public static final BitSet FOLLOW_stat_seq_tail_in_stat_seq1090 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_stat_seq_in_stat_seq_tail1102 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_stat1127 = new BitSet(new long[]{0x0000000120000020L});
	public static final BitSet FOLLOW_id_stat_in_stat1129 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_if_stat_in_stat1135 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_while_stat_in_stat1142 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_for_stat_in_stat1149 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_break_stat_in_stat1155 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_return_stat_in_stat1161 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_stat1168 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_tail_in_id_stat1182 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ASSIGN_in_id_stat1184 = new BitSet(new long[]{0x0000000106080000L});
	public static final BitSet FOLLOW_stat_tail_in_id_stat1186 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_SEMI_in_id_stat1188 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_id_stat1197 = new BitSet(new long[]{0x0000020106080000L});
	public static final BitSet FOLLOW_expr_list_in_id_stat1199 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_RPAREN_in_id_stat1201 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_SEMI_in_id_stat1203 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_special_expr_in_stat_tail1234 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_stat_tail1241 = new BitSet(new long[]{0x0000000120000000L});
	public static final BitSet FOLLOW_stat_tail_tail_in_stat_tail1243 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_expr_in_stat_tail_tail1260 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_stat_tail_tail1266 = new BitSet(new long[]{0x0000020106080000L});
	public static final BitSet FOLLOW_expr_list_in_stat_tail_tail1268 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_RPAREN_in_stat_tail_tail1270 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_special_expr_head_in_special_expr1286 = new BitSet(new long[]{0x000000B6C1805010L});
	public static final BitSet FOLLOW_special_expr_tail_in_special_expr1288 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_logical_op_in_special_expr_tail1303 = new BitSet(new long[]{0x0000000106080000L});
	public static final BitSet FOLLOW_expr_in_special_expr_tail1305 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_special_expr1_in_special_expr_tail1311 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_compar_op_in_special_expr11324 = new BitSet(new long[]{0x0000000106080000L});
	public static final BitSet FOLLOW_expr_in_special_expr11326 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_special_expr2_in_special_expr11332 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_add_op_in_special_expr21345 = new BitSet(new long[]{0x0000000106080000L});
	public static final BitSet FOLLOW_expr_in_special_expr21347 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_special_expr3_in_special_expr21353 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_mul_op_in_special_expr31371 = new BitSet(new long[]{0x0000000106080000L});
	public static final BitSet FOLLOW_expr_in_special_expr31373 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_special_expr_head1395 = new BitSet(new long[]{0x0000000106080000L});
	public static final BitSet FOLLOW_expr_in_special_expr_head1397 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_RPAREN_in_special_expr_head1399 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_constant_in_special_expr_head1406 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_expr_head_in_value_expr1420 = new BitSet(new long[]{0x000000B6C1805010L});
	public static final BitSet FOLLOW_value_expr_tail_in_value_expr1423 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_logical_op_in_value_expr_tail1439 = new BitSet(new long[]{0x0000000106080000L});
	public static final BitSet FOLLOW_expr_in_value_expr_tail1441 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_expr1_in_value_expr_tail1447 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_compar_op_in_value_expr11460 = new BitSet(new long[]{0x0000000106080000L});
	public static final BitSet FOLLOW_expr_in_value_expr11462 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_expr2_in_value_expr11468 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_add_op_in_value_expr21481 = new BitSet(new long[]{0x0000000106080000L});
	public static final BitSet FOLLOW_expr_in_value_expr21483 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_expr3_in_value_expr21489 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_mul_op_in_value_expr31507 = new BitSet(new long[]{0x0000000106080000L});
	public static final BitSet FOLLOW_expr_in_value_expr31509 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_tail_in_value_expr_head1530 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_If_in_if_stat1565 = new BitSet(new long[]{0x0000000106080000L});
	public static final BitSet FOLLOW_expr_in_if_stat1567 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_Then_in_if_stat1569 = new BitSet(new long[]{0x000404000A200180L});
	public static final BitSet FOLLOW_stat_seq_in_if_stat1571 = new BitSet(new long[]{0x0000000000048000L});
	public static final BitSet FOLLOW_else_stat_in_if_stat1573 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_Endif_in_if_stat1575 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_SEMI_in_if_stat1577 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Else_in_else_stat1594 = new BitSet(new long[]{0x000404000A200180L});
	public static final BitSet FOLLOW_stat_seq_in_else_stat1596 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_While_in_while_stat1613 = new BitSet(new long[]{0x0000000106080000L});
	public static final BitSet FOLLOW_expr_in_while_stat1615 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_Do_in_while_stat1617 = new BitSet(new long[]{0x000404000A200180L});
	public static final BitSet FOLLOW_stat_seq_in_while_stat1619 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_Enddo_in_while_stat1621 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_SEMI_in_while_stat1623 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_For_in_for_stat1638 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_ID_in_for_stat1640 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ASSIGN_in_for_stat1642 = new BitSet(new long[]{0x0000000006000000L});
	public static final BitSet FOLLOW_index_expr_in_for_stat1644 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_To_in_for_stat1646 = new BitSet(new long[]{0x0000000006000000L});
	public static final BitSet FOLLOW_index_expr_in_for_stat1648 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_Do_in_for_stat1650 = new BitSet(new long[]{0x000404000A200180L});
	public static final BitSet FOLLOW_stat_seq_in_for_stat1652 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_Enddo_in_for_stat1654 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_SEMI_in_for_stat1656 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Break_in_break_stat1672 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_SEMI_in_break_stat1673 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Return_in_return_stat1689 = new BitSet(new long[]{0x0000000106080000L});
	public static final BitSet FOLLOW_expr_in_return_stat1691 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_SEMI_in_return_stat1693 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr1_in_expr1716 = new BitSet(new long[]{0x0000002000000010L});
	public static final BitSet FOLLOW_expr_tail_in_expr1718 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_logical_op_in_expr_tail1732 = new BitSet(new long[]{0x0000000106080000L});
	public static final BitSet FOLLOW_expr1_in_expr_tail1734 = new BitSet(new long[]{0x0000002000000010L});
	public static final BitSet FOLLOW_expr_tail_in_expr_tail1736 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr2_in_expr11768 = new BitSet(new long[]{0x00000010C1804000L});
	public static final BitSet FOLLOW_expr1_tail_in_expr11770 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_compar_op_in_expr1_tail1784 = new BitSet(new long[]{0x0000000106080000L});
	public static final BitSet FOLLOW_expr2_in_expr1_tail1786 = new BitSet(new long[]{0x00000010C1804000L});
	public static final BitSet FOLLOW_expr1_tail_in_expr1_tail1788 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr3_in_expr21836 = new BitSet(new long[]{0x0000008200000000L});
	public static final BitSet FOLLOW_expr2_tail_in_expr21838 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_add_op_in_expr2_tail1852 = new BitSet(new long[]{0x0000000106080000L});
	public static final BitSet FOLLOW_expr3_in_expr2_tail1854 = new BitSet(new long[]{0x0000008200000000L});
	public static final BitSet FOLLOW_expr2_tail_in_expr2_tail1856 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_factor_in_expr31888 = new BitSet(new long[]{0x0000000400001000L});
	public static final BitSet FOLLOW_expr3_tail_in_expr31890 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_mul_op_in_expr3_tail1904 = new BitSet(new long[]{0x0000000106080000L});
	public static final BitSet FOLLOW_factor_in_expr3_tail1906 = new BitSet(new long[]{0x0000000400001000L});
	public static final BitSet FOLLOW_expr3_tail_in_expr3_tail1908 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_factor1941 = new BitSet(new long[]{0x0000000106080000L});
	public static final BitSet FOLLOW_expr_in_factor1943 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_RPAREN_in_factor1945 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_constant_in_factor1952 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_in_factor1955 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_expr_list1991 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_expr_list_tail_in_expr_list1993 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COMMA_in_expr_list_tail2011 = new BitSet(new long[]{0x0000000106080000L});
	public static final BitSet FOLLOW_expr_in_expr_list_tail2013 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_expr_list_tail_in_expr_list_tail2015 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_value2031 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_value_tail_in_value2033 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LBRACK_in_value_tail2054 = new BitSet(new long[]{0x0000000006000000L});
	public static final BitSet FOLLOW_index_expr_in_value_tail2056 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_RBRACK_in_value_tail2058 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_value_tail_tail_in_value_tail2060 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LBRACK_in_value_tail_tail2076 = new BitSet(new long[]{0x0000000006000000L});
	public static final BitSet FOLLOW_index_expr_in_value_tail_tail2078 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_RBRACK_in_value_tail_tail2080 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_index_expr1_in_index_expr2102 = new BitSet(new long[]{0x0000008200000000L});
	public static final BitSet FOLLOW_index_expr_tail_in_index_expr2104 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_index_add_op_in_index_expr_tail2118 = new BitSet(new long[]{0x0000000006000000L});
	public static final BitSet FOLLOW_index_expr1_in_index_expr_tail2120 = new BitSet(new long[]{0x0000008200000000L});
	public static final BitSet FOLLOW_index_expr_tail_in_index_expr_tail2122 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_index_expr_factor_in_index_expr12154 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_index_expr1_tail_in_index_expr12156 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_index_mul_op_in_index_expr1_tail2170 = new BitSet(new long[]{0x0000000006000000L});
	public static final BitSet FOLLOW_index_expr_factor_in_index_expr1_tail2172 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_index_expr1_tail_in_index_expr1_tail2174 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MULT_in_index_mul_op2189 = new BitSet(new long[]{0x0000000000000002L});
}
