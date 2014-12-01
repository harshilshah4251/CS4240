tree grammar TigerTreeWalker;

options {
    tokenVocab = Tiger;  /* uses Tiger.tokens */
    ASTLabelType = CommonTree;
}

@header {
	package cs4240_team1;
}
//
//@members {
//    /* Symbol table mgmt and IR code mgmt goes here? */
//}

walk
    : tiger_program EOF
    ;

tiger_program
    : ^(PROGRAM type_declaration_list funct_declaration* main_function)
    ;

funct_declaration
    : ^(FUNCTION ret_type ID param_list block_list)
    ;

ret_type
    : VOID
    | ID
    | INT
    | FIXEDPT
    ;

main_function
    : ^(MAINSCOPE block_list)
    ;

param_list
    : ^(PARAMLIST param*)
    ;

param
    : ^(ID type_id);

block_list
    : ^(BLOCKLIST block+)
    ;

block
    : ^(BLOCKSCOPE type_declaration_list var_declaration_list stat_seq)
    ;

type_declaration_list
    : ^(TYPEDECLLIST type_declaration*)
    ;

var_declaration_list
    : ^(VARDECLLIST var_declaration*)
    ;

type_declaration
    : ^(TYPEDECL ID type)
    ;

type
    : base_type
    | ^(ARRAY base_type INTLIT+)
    ;

base_type
    : INT
    | FIXEDPT
    ;

var_declaration
    : ^(VAR type_id id_list optional_init?)
    ;

type_id
    : base_type
    | ID
    ;

id_list
    : ^(IDLIST ID+)
    ;

optional_init
    : ':=' literal
    ;

stat_seq
    : stat+
    ;

/* TODO -- if is a little ... funky.  check if it's okay
 *
 * May want to revert back to IFTHEN and IFTHENELSE synthetic tokens?
 */
stat
    : function_call
    | assignment
    | ^(IF expr ^(THEN_STATS stat_seq) (^(ELSE_STATS stat_seq))?)
    /*
    | (^(IF expr ^(THEN_STATS stat_seq) ^(ELSE_STATS stat_seq))
        | ^(IF expr ^(THEN_STATS stat_seq))
        )
    */
    | ^(WHILE expr stat_seq)
    | ^(FOR ID index_expr index_expr stat_seq)
    | BREAK
    | ^(RETURN expr)
    | block
    ;

assignment
    : ^(':=' ^(ID value_tail?) (expr | function_call))
    ;

function_call
    : ^(FUNCTION_CALL ID function_args?)
    ;

function_args
    : ^(EXPRLIST expr+)
    ;


/* NOTE: expr in tree grammar is quite different than parser's rule!
 *
 * Our expression AST subtrees are already set up to give the proper evaluation
 * through post-order traversal!
 *
 * So, tree walker doesn't care about operator precedence
 */
expr
    : ^('&' expr expr)
    | ^('|' expr expr)

    | ^('=' expr expr)
    | ^('<>' expr expr)
    | ^('<' expr expr)
    | ^('>' expr expr)
    | ^('<=' expr expr)
    | ^('>=' expr expr)

    | ^('+' expr expr)
    | ^('-' expr expr)

    | ^('*' expr expr)
    | ^('/' expr expr)

    | value
    | literal
    ;

value
    : ^(ID value_tail?)
    ;

literal
    : INTLIT
    | FIXEDPTLIT
    ;

value_tail 
    : index_expr index_expr?
    ;

index_expr
    : ^('+' index_expr index_expr)
    | ^('-' index_expr index_expr)
    | ^('*' index_expr index_expr)
    | INTLIT
    | ID
    ;
