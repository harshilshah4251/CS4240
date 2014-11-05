{\rtf1\ansi\ansicpg1252\cocoartf1265\cocoasubrtf210
{\fonttbl\f0\fswiss\fcharset0 ArialMT;}
{\colortbl;\red255\green255\blue255;}
\margl1440\margr1440\vieww12560\viewh14520\viewkind0
\pard\tx720\tx1440\tx2160\tx2880\tx3600\tx4320\tx5040\tx5760\tx6480\tx7200\tx7920\tx8640\pardirnatural

\f0\fs24 \cf0 tree grammar TigerWalker;\
\
options \{\
	tokenVocab = Tiger	\
	ASTLabelType = CommonTree;\
\}\
\
walk\
	:	^(PROGRAM type_declaration_list funct_declaration_list_then_main) //main scope\
	;\
\
//THIS PART I AM NOT SURE\
funct_declaration_list_then_main\
	: 	myRet=VOID! (funct_declaration_tail[$myRet] funct_declaration_list_then_main | main_function_tail)\
	| 	(myRet=ID|myRet=INT|myRet=FIXEDPT) funct_declaration_tail[$myRet] funct_declaration_list_then_main\
    	;\
\
funct_declaration_tail[Token retType]\
	:	^(FUNCTION \{new CommonTree($retType)\} ID param_list block_list)\
	;\
\
main_function_tail \
	: 	^(MAINSCOPE block_list);\
\
param_list\
	: 	^(PARAMLIST param*)\
    	;\
\
// until this, should it be one large node?\
\
block \
	: 	^(BLOCKSCOPE declaration_segment stat_seq)\
	;\
\
type_declaration_list\
    	:	 ^(TYPEDECLLIST type_declaration*)\
    	;\
\
var_declaration_list\
    	: 	^(VARDECLLIST var_declaration*)\
  	;\
\
\pard\tx720\tx1440\tx2160\tx2880\tx3600\tx4320\tx5040\tx5760\tx6480\tx7200\tx7920\tx8640\pardirnatural
\cf0 type_declaration \
	: 	^(TYPEDECL ID type)\
	;\
\
type\
    	: 	base_type\
    	| 	^(ARRAY base_type INTLIT+)\
    	;\
\
type_id\
    	: 	base_type\
   	| 	ID\
    	;\
\
base_type\
    	: 	INT\
    	| 	FIXEDPT\
    	;\
\
var_declaration \
	:  	^(VAR type_id id_list optional_init?)\
	;\
\
id_list\
    	: 	^(IDLIST ID+)\
    	;\
\
optional_init\
    	: ':=' literal\
    	|\
    	;\
\
stat_seq\
    	: 	stat+\
    	;\
\
\
\
\
\
\
//\
stat\
   	: function_call_or_assignment\
    	| IF expr THEN seq1=stat_seq \
        		( ELSE seq2=stat_seq ENDIF\
            		-> ^(IF expr ^(THEN_STATS $seq1) ^(ELSE_STATS $seq2))\
        		| ENDIF\
          			-> ^(IF expr ^(THEN_STATS $seq1))\
        ) ';'\
    | WHILE expr DO stat_seq ENDDO ';'\
        -> ^(WHILE expr stat_seq)\
    | FOR ID ':=' index_expr TO index_expr DO stat_seq ENDDO ';'\
        -> ^(FOR ID index_expr index_expr stat_seq)\
    | BREAK ';'!\
    | RETURN expr ';'\
        -> ^(RETURN expr)\
    | block\
    ;\
//\
\
function_args\
    :         expr_list?\
    ;\
\
\
//\
function_call_or_assignment\
    : ID \
        (function_args\
            -> ^(FUNCTION_CALL ID function_args?)\
        | value_tail ':=' expr_or_function_call\
            -> ^(':=' ^(ID value_tail?) expr_or_function_call)\
        ) ';'\
    ;\
\
//\
\
expr_or_function_call\
    : ID \
        (expr_with_start_id[$ID] -> ^(EXPR_WITH_START_ID expr_with_start_id?)\
        | function_args\
            -> ^(FUNCTION_CALL ID function_args?)\
        )\
    | expr_no_start_id\
    ;\
\
/* notation: termN corresponds to precedence level N */\
expr : term4 (and_operator^ term4)* ;\
term4 : term3 (compare_operator^ term3)* ;\
term3 : term2 (add_operator^ term2)* ;\
term2 : term1 (mult_operator^ term1)* ;\
term1\
    : literal\
    | value\
    | '(' expr ')'\
        -> expr\
    ;\
\
expr_no_start_id : term4_no_start_id (and_operator^ term4)* ;\
term4_no_start_id : term3_no_start_id (compare_operator^ term3)* ;\
term3_no_start_id : term2_no_start_id (add_operator^ term2)* ;\
term2_no_start_id : term1_no_start_id (mult_operator^ term1)* ;\
term1_no_start_id\
    : literal\
    | '(' expr ')'\
        -> expr\
    ;\
\
expr_with_start_id[Token startId] : term4_with_start_id[$startId] (and_operator^ term4)* ;\
term4_with_start_id[Token startId] : term3_with_start_id[$startId] (compare_operator^ term3)* ;\
term3_with_start_id[Token startId] : term2_with_start_id[$startId] (add_operator^ term2)* ;\
term2_with_start_id[Token startId] : term1_with_start_id[$startId] (mult_operator^ term1)* ;\
term1_with_start_id[Token startId]\
    : value_tail -> ^(\{new CommonTree($startId)\} value_tail?)\
    ;\
\
expr_list\
    : expr ( ',' expr )* -> ^(EXPRLIST expr+)\
    |\
    ;\
\
/*expr_list_tail\
    : ',' expr expr_list_tail\
        -> expr expr_list_tail?\
    |\
    ;*/\
\
mult_operator : '*' | '/' ;\
\
add_operator : '+' | '-' ;\
\
compare_operator : '=' | '<>' | '<' | '>' | '<=' | '>=' ;\
\
and_operator : '&' | '|' ;\
\
value : ID value_tail -> ^(ID value_tail?);\
\
literal\
    : INTLIT\
    | FIXEDPTLIT\
    ;\
\
value_tail \
    : '[' index_expr ']' ('[' index_expr ']')?\
            -> index_expr+  /* antlr will auto-group two index_expr's */\
    |\
    ;\
\
index_expr : index_term (add_operator^ index_term)* ;\
\
index_term : index_factor ('*'^ index_factor)* ;  /* no division allowed in index */\
\
index_factor : INTLIT | ID ;\
\
\
\
\
\
\
\
\
\
\
\
\
\
\
\
\
\
\
\
\
\
\
}
