tree grammar TigerTree;

//class TigerTree extends TreeParser;

options {
	ASTLabelType = CommonTree;
	//tokenVocab = TiberParser;
}


@header {
// Not sure if we need this
	import java.util.Map;
	import java.util.TreeMap;
	import java.util.ArrayList;
	import java.util.Stack;
	import java.util.LinkedList;
}


@member {
	//public Stack<SymbolTable> stack = new Stack<>();

	// Use LinkedList that works like stack to implement scope
	// Used LinkedList to make search easier
	public LinkedList<SymtolTable> stack = new LinkedList<>();
	// Use ArrayList to store all the Symbol table we have used
	public ArrayList<SymbolTable> tableList = new ArrayList<>();

	private int level;

	// When entering new scope, add the SymbolTable into the Stack and List
	private void enterNewScope(SymbolTable table) {
		stack.addFirst(table);
		tableList.add(table);
		level++;
	}

	// When exiting a scpoe, remove the symbol table from the stack
	private SymbolTable exitScope() {
		stack.removeLast();
		if(level > 0) level--;
	}

	// It will get the top SymbolTable of the stack
	// which means get the SymbolTable of current scope
	private SymbolTable getTopTable() {
		return stack.getLast();
	}
}

/* PARSER RULES */

tiger_program : 
	{	
		// This new SymbolTable will be the global SymbolTable
		enterNewScope(new SymbolTable());
		level = 0;
		
	}
	type_declaration_list funct_declaration_list_then_main EOF 
	-> ^(PROGRAM type_declaration_list funct_declaration_list_then_main);

;


funct_declaration_list_then_main
    : myRet=VOID! (funct_declaration_tail[$myRet] funct_declaration_list_then_main | main_function_tail)
    | (myRet=ID|myRet=INT|myRet=FIXEDPT) funct_declaration_tail[$myRet] funct_declaration_list_then_main
    ;

funct_declaration_tail[Token retType]
    : FUNCTION ID '(' param_list ')' BEGIN block_list END ';' 
	-> ^(FUNCTION {new CommonTree($retType)} ID param_list block_list)
    ;

main_function_tail : MAIN '(' ')' BEGIN block_list END ';' 
	-> ^(MAINSCOPE block_list);


// should return ArrayList?
param_list
    : (param ( ',' param )*)? 
	-> ^(PARAMLIST param*)
    ;

param 
	: ID ':' type_id;

block_list : block+ -> ^(BLOCKLIST block+);

block : BEGIN declaration_segment stat_seq END ';' 
	-> ^(BLOCKSCOPE declaration_segment stat_seq);

declaration_segment : type_declaration_list var_declaration_list ;

type_declaration_list
    : type_declaration* 
	-> ^(TYPEDECLLIST type_declaration*)
    ;
    
var_declaration_list
    : var_declaration* 
	-> ^(VARDECLLIST var_declaration*)
    ;

type_declaration : TYPE ID '=' type ';' 
	-> ^(TYPEDECL ID type);

type
    : base_type
    | ARRAY '[' INTLIT ']' ('[' INTLIT ']')? OF base_type 
	-> ^(ARRAY base_type INTLIT+)
    ;

type_id
    : base_type
    | ID
    ;

base_type returns [Type e]
    : INT {e = Type.Int;} // check here again
    | FIXEDPT {e = Type.Float;} 
    ;

var_declaration : VAR id_list ':' type_id optional_init ';' 
	-> ^(VAR type_id id_list optional_init?);

id_list
    : ID ( ',' ID )* -> ^(IDLIST ID+)
    ;

optional_init
    : ':=' literal
    |
    ;

stat_seq
    : stat+
    ;

stat
    : function_call_or_assignment
    | IF expr THEN seq1=stat_seq 
        ( ELSE seq2=stat_seq ENDIF
            -> ^(IF expr ^(THEN_STATS $seq1) ^(ELSE_STATS $seq2))
        | ENDIF
            -> ^(IF expr ^(THEN_STATS $seq1))
        ) ';'
    | WHILE expr DO stat_seq ENDDO ';'
        -> ^(WHILE expr stat_seq)
    | FOR ID ':=' index_expr TO index_expr DO stat_seq ENDDO ';'
        -> ^(FOR ID index_expr index_expr stat_seq)
    | BREAK ';'!
    | RETURN expr ';'
        -> ^(RETURN expr)
    | block
    ;

function_args
    : '(' expr_list ')'
        -> expr_list?
    ;

function_call_or_assignment
    : ID 
        (function_args
            -> ^(FUNCTION_CALL ID function_args?)
        | value_tail ':=' expr_or_function_call
            -> ^(':=' ^(ID value_tail?) expr_or_function_call)
        ) ';'
    ;

expr_or_function_call
    : ID 
        (expr_with_start_id[$ID] 
		-> ^(EXPR_WITH_START_ID expr_with_start_id?)
        | function_args
            -> ^(FUNCTION_CALL ID function_args?)
        )
    | expr_no_start_id
    ;

/* notation: termN corresponds to precedence level N */
expr : term4 (and_operator^ term4)* ;
term4 : term3 (compare_operator^ term3)* ;
term3 : term2 (add_operator^ term2)* ;
term2 : term1 (mult_operator^ term1)* ;
term1
    : literal
    | value
    | '(' expr ')'
        -> expr
    ;

expr_no_start_id : term4_no_start_id (and_operator^ term4)* ;
term4_no_start_id : term3_no_start_id (compare_operator^ term3)* ;
term3_no_start_id : term2_no_start_id (add_operator^ term2)* ;
term2_no_start_id : term1_no_start_id (mult_operator^ term1)* ;
term1_no_start_id
    : literal
    | '(' expr ')'
        -> expr
    ;

expr_with_start_id[Token startId] : term4_with_start_id[$startId] (and_operator^ term4)* ;
term4_with_start_id[Token startId] : term3_with_start_id[$startId] (compare_operator^ term3)* ;
term3_with_start_id[Token startId] : term2_with_start_id[$startId] (add_operator^ term2)* ;
term2_with_start_id[Token startId] : term1_with_start_id[$startId] (mult_operator^ term1)* ;
term1_with_start_id[Token startId]
    : value_tail -> ^({new CommonTree($startId)} value_tail?)
    ;

expr_list
    : expr ( ',' expr )* -> ^(EXPRLIST expr+)
    |
    ;

/*expr_list_tail
    : ',' expr expr_list_tail
        -> expr expr_list_tail?
    |
    ;*/

mult_operator : '*' | '/' ;

add_operator : '+' | '-' ;

compare_operator : '=' | '<>' | '<' | '>' | '<=' | '>=' ;

and_operator : '&' | '|' ;

value : ID value_tail -> ^(ID value_tail?);

literal
    : INTLIT
    | FIXEDPTLIT
    ;

value_tail 
    : '[' index_expr ']' ('[' index_expr ']')?
            -> index_expr+  /* antlr will auto-group two index_expr's */
    |
    ;

index_expr : index_term (add_operator^ index_term)* ;

index_term : index_factor ('*'^ index_factor)* ;  /* no division allowed in index */

index_factor : INTLIT | ID ;


/*
class MyWalker extends TreeParser;
{
	SymbolTable top = null;
	int used = 0;
}
*/


