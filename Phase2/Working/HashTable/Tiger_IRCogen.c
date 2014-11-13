//
//  Tiger_IRCogen.c
//  
//
//  Created by Sung Hye Jeon on 11/12/14.
//
//

#include "Tiger_IRCogen.h"

PART3




grammar Tiger;

options {
    k = 1;
    backtrack = no;
    output = AST;
}

/* Lexical Rules */
tokens {
    COMMA = ',';
    COLON = ':';
    SEMI = ';';
    LPAREN = '(';
    RPAREN = ')';
    LBRACK = '[';
    RBRACK = ']';
    PLUS = '+';
    MINUS = '-';
    MULT = '*';
    DIV = '/';
    EQ = '=';
    NEQ = '<>';
    LESSER = '<';
    LESSEREQ = '<=';
    GREATER = '>';
    GREATEREQ = '>=';
    AND = '&';
    OR = '|';
    ASSIGN = ':=';
    
    FUNCTION = 'function';
    BEGIN = 'begin';
    END = 'end';
    VOID = 'void';
    MAIN = 'main';
    TYPE = 'type';
    ARRAY = 'array';
    OF = 'of';
    INT = 'int';
    FIXEDPT = 'fixedpt';
    VAR = 'var';
    IF = 'if';
    THEN = 'then';
    ENDIF = 'endif';f
    ELSE = 'else';
    WHILE = 'while';
    DO = 'do';
    ENDDO = 'enddo';
    FOR = 'for';
    TO = 'to';
    BREAK = 'break';
    RETURN = 'return';
    
    /* synthetic tokens for AST */
    IF_THEN;
    IF_THEN_ELSE;
    FUNCTION_CALL;
    THEN_STATS;
    ELSE_STATS;
    BLOCKSCOPE;
    MAINSCOPE;
    VARDECL;
    TYPEDECL;
    FUNCDECL;
    PARAMLIST;
    IDLIST;
    EXPRLIST;
    BLOCKLIST;
    TYPEDECLLIST;
    VARDECLLIST;
    PROGRAM;
    EXPR_WITH_START_ID;



@members {
    
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
}

ID
:   (LOWER|UPPER)(LOWER|UPPER|DIGIT|'_')*
;

WHITESPACE
:   ( '\t' | ' ' | '\r' | '\n' | '\u000C' )+   {$channel=HIDDEN;}
;

COMMENT
:   '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
;

INTLIT
:   '0'
|   '1'..'9' (DIGIT)*
;

FIXEDPTLIT
:   INTLIT '.' (DIGIT | DIGIT DIGIT | DIGIT DIGIT DIGIT)
;

INVALID_INTLIT
:   '0' (DIGIT)+ {$type=Token.INVALID_TOKEN_TYPE;}
;

INVALID_FIXEDPTLIT
:   INVALID_INTLIT '.' (DIGIT | DIGIT DIGIT | DIGIT DIGIT DIGIT)? {$type=Token.INVALID_TOKEN_TYPE;}
|   INTLIT '.' (DIGIT DIGIT DIGIT DIGIT+)? {$type=Token.INVALID_TOKEN_TYPE;}
;

/* low priority rule so unrecognized chars like '?' are caught in tokens and sent to parser
 * otherwise, neither  lexer.getNumberSyntaxErrors()   nor   parser.getNumberSyntaxErrors()  get increased
 */
INVALID_CHAR
:   . {$type=Token.INVALID_TOKEN_TYPE;}
;

fragment LOWER: 'a'..'z';
fragment UPPER: 'A'..'Z';
fragment DIGIT: '0'..'9';






/* PARSER RULES */

tiger_program : type_declaration_list funct_declaration_list_then_main EOF -> ^(PROGRAM type_declaration_list funct_declaration_list_then_main);

funct_declaration_list_then_main
: myRet=VOID! (funct_declaration_tail[$myRet] funct_declaration_list_then_main | main_function_tail)
| (myRet=ID|myRet=INT|myRet=FIXEDPT) funct_declaration_tail[$myRet] funct_declaration_list_then_main
;

funct_declaration_tail[Token retType]
: FUNCTION ID '(' param_list ')' BEGIN block_list END ';' -> ^(FUNCTION {new CommonTree($retType)} ID param_list block_list)
;

main_function_tail : MAIN '(' ')' BEGIN block_list END ';' -> ^(MAINSCOPE block_list);

param_list
: (param ( ',' param )*)? -> ^(PARAMLIST param*)
;

param : ID ':' type_id;

block_list : block+ -> ^(BLOCKLIST block+);

block : BEGIN declaration_segment stat_seq END ';' -> ^(BLOCKSCOPE declaration_segment stat_seq);

declaration_segment : {}type_declaration_list var_declaration_list ;

type_declaration_list
: type_declaration* -> ^(TYPEDECLLIST type_declaration*)
;

var_declaration_list
: var_declaration* -> ^(VARDECLLIST var_declaration*)
;

type_declaration : TYPE ID '=' type ';' -> ^(TYPEDECL ID type);

type
: base_type
| ARRAY '[' INTLIT ']' ('[' INTLIT ']')? OF base_type -> ^(ARRAY base_type INTLIT+)
;

type_id
: base_type
| ID
;

base_type
: INT
| FIXEDPT
;

var_declaration : VAR id_list ':' type_id optional_init ';' -> ^(VAR type_id id_list optional_init?);

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


//need to be implemented
function_args
: '(' expr_list ')'
-> expr_list?
;

//need to be implemented : offset calculation, function_arg, part java doc
function_call_or_assignment     returns [String val]
    : ID
        (function_args -> ^(FUNCTION_CALL ID function_args?)
        | t = value_tail ':=' t1 = expr_or_function_call -> ^(':=' ^(ID value_tail?) expr_or_function_call))';'
    
    /*{
        if(t.r == "")    // {val = $ID.text;}
        else if(t.c == ""){
            Temp r = new Temp(Type.Char);
            r.s = "t" + r.number;
            val = r.s;
            r.emit("array_store, " + r.s + ", " + $startId.text + ", " + t.r);
        }
        else{
            //offset calculation with r and c -> instead of t.c, i need calculated value
            Temp r = new Temp(Type.Char);
            r.s = "t" + r.number;
            val = r.s;
            r.emit("array_store, " + r.s + ", " + $startId.text + ", " + t.c);
        }
    }*/
    
    ;

//need to implemented : function_arg
expr_or_function_call    returns [String val]
    : ID
        (t1 = expr_with_start_id[$ID] -> ^(EXPR_WITH_START_ID expr_with_start_id?)
         //how to handle function_args and pass as val?
         | function_args-> ^(FUNCTION_CALL ID function_args?))
    | t1 = expr_no_start_id
    
    {val = t1.val;}
    ;



/* notation: termN corresponds to precedence level N */
expr    returns [String val]
    :   expr4 = term4        {val = $expr4.val;}
    (and_operator^ t4 = term4
    {Temp r = new Temp(Type.Char);    //Type.Int does not mean anything. this is just placeholder
         r.s = "t" + r.number;;
         val = r.s;
         
         switch (op){
             case    & :    r.emit("and, " + $expr4.val + ", " + $t4.val + ", " + r.s);
             case    | :    r.emit( "or, " + $expr4.val + ", " + $t4.val + ", " + r.s);
         }})*
    ;
    
//need to be implemented : branch op
term4 : term3 (compare_operator^ term3)* ;

term3   returns [String val]
    :   expr2 = term2        {val = $expr2.val;}
    (add_operator^ t2 = term2
    {Temp r = new Temp(Type.Char);
         r.s = "t" + r.number;;
         val = r.s;
         
         switch (op){
             case    + :    r.emit("add, " + $expr2.val + ", " + $t2.val + ", " + r.s);
             case    - :    r.emit("sub, " + $expr2.val + ", " + $t2.val + ", " + r.s);
         }})*
    ;
    

term2   returns [String val]
    :   expr1 = term1       {val = $tns1.val;}
    (mult_operator^ t1 = term1
    {Temp r = new Temp(Type.Char);    //type doesnt mean anything.
         r.s = "t" + r.number;         //create temp label
         val = r.s;                   //put t1 into val
         
         switch (op){
             case    * :    r.emit("mult, " + $expr1.text + ", " + $t1.val + ", " + r.s);
             case    / :    r.emit( "div, " + $expr1.text + ", " + $t1.val + ", " + r.s);
         }})*
    ;
    
term1   [String val]
    : literal   {val = $literal.text;}
    | value     {val = $value.text;}
    | '(' expr ')'
    -> expr
    ;
    
    
    
//for example : 3 / 2 + 2
expr_no_start_id   returns [String val]
    :   tns4 = term4_no_start_id        {val = $tns4.val;}
    (and_operator^ t4 = term4
    {Temp r = new Temp(Type.Char);
         r.s = "t" + r.number;
         val = r.s;
         
         switch (op){
             case    & :    r.emit("and, " + $tns4.val + ", " + $t4.val + ", " + r.s);
             case    | :    r.emit( "or, " + $tns4.val + ", " + $t4.val + ", " + r.s);
         }})*
    ;
                                   
//need to be implemented : branch op
term4_no_start_id   returns [String val]
    : term3_no_start_id
    (compare_operator^ term3)*
    ;
    
term3_no_start_id   returns [String val]
    :   tns2 = term2_no_start_id        {val = $tns2.val;}
    (add_operator^ t2 = term2
    {Temp r = new Temp(Type.Char);
         r.s = "t" + r.number;;
         val = r.s;
         
         switch (op){
             case    + :    r.emit("add, " + $tns2.val + ", " + $t2.val + ", " + r.s);
             case    - :    r.emit("sub, " + $tns2.val + ", " + $t2.val + ", " + r.s);
         }})*
    ;
    
term2_no_start_id   returns [String val]
    :   tns1 = term1_no_start_id        {val = $tns1.val;}
    (mult_operator^ t1 = term1
     {Temp r = new Temp(Type.Char);    //type doesnt mean anything.
         r.s = "t" + r.number;         //create temp label
         val = r.s;                   //put t1 into val
         
         switch (op){
             case    * :    r.emit("mult, " + $tns1.val + ", " + $t1.val + ", " + r.s);
             case    / :    r.emit( "div, " + $tns1.val + ", " + $t1.val + ", " + r.s);
         }})*
    ;
    
term1_no_start_id   returns [String val]
    : literal       {val = $literal.text;}
    | '(' expr ')'
        -> expr
    ;
    
    

//a[1][2]
expr_with_start_id[Token startId]       returns [String val]
    : tws4 = term4_with_start_id[$startId]
    (and_operator^ t4 = term4
     {Temp r = new Temp(Type.Char);
         r.s = "t" + r.number;
         val = r.s;
         
         switch (op){
             case    & :    r.emit("and, " + $tws4.val + ", " + $t4.val + ", " + r.s);
             case    | :    r.emit( "or, " + $tws4.val + ", " + $t4.val + ", " + r.s);
         }})*
    ;
    
    
//need to be implemented : branch op
term4_with_start_id[Token startId]
    : tws3 = term3_with_start_id[$startId] (compare_operator^ term3)* ;

term3_with_start_id[Token startId]     returns [String val]
    : tws2 = term2_with_start_id[$startId]      {val = $tws2.val;}
    (add_operator^ t2 = term2
     {Temp r = new Temp(Type.Char);
         r.s = "t" + r.number;;
         val = r.s;
         
         switch (op){
             case    + :    r.emit("add, " + $tws2.val + ", " + $t2.val + ", " + r.s);
             case    - :    r.emit("sub, " + $tws2.val + ", " + $t2.val + ", " + r.s);
         }})*
    ;
    
term2_with_start_id[Token startId]     returns [String val]
    : tws1 = term1_with_start_id[$startId]      {val = $tws1.val;}
    (mult_operator^ t1 = term1
     {Temp r = new Temp(Type.Char);    //type doesnt mean anything.
         r.s = "t" + r.number;         //create temp label
         val = r.s;                    //put t1 into val
         
         switch (op){
             case    * :    r.emit("mult, " + $tws1.val + ", " + $t1.val + ", " + r.s);
             case    / :    r.emit( "div, " + $tws1.val + ", " + $t1.val + ", " + r.s);
         }})*
    ;
 
    
//need to be implemented : offset calculation
term1_with_start_id[Token startId]  returns [String val]
    : t = value_tail -> ^({new CommonTree($startId)} value_tail?){
        if(t.r == ""){
            val = $startId.text;
        }
        else if(t.c == ""){
            Temp r = new Temp(Type.Char);
            r.s = "t" + r.number;
            val = r.s;
            r.emit("array_store, " + r.s + ", " + $startId.text + ", " + t.r);
        }
        else{
            //offset calculation with r and c -> instead of t.c, i need calculated value
            Temp r = new Temp(Type.Char);
            r.s = "t" + r.number;
            val = r.s;
            r.emit("array_store, " + r.s + ", " + $startId.text + ", " + t.c);
        }
        
            };
    
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
    
value : ID value_tail -> ^(ID value_tail?);             //where value called?
    
literal
    : INTLIT
    | FIXEDPTLIT
    ;
    
value_tail   returns [String r, String c]            //value tail returns : whether it is string or not, row number, colum number for index
        
    : {r = ""; c = "";} '[' t = index_expr ']'    {r = t.val;}
    ('[' t2 = index_expr ']')?  {c = t2.val;}
    
    -> index_expr+  /* antlr will auto-group two index_expr's */
    |
    ;
    
index_expr  returns [String val]
    :   i = index_term    {val = index_factor;}
    (add_operator^ i1 = index_term
    {Temp r = new Temp(Type.Int);
    r.s = "t" + r.number;
    val = r.s;
    r.emit("add," + $i.val + ", " + $i1.val + ", " + r.s);
    })*
    ;
    
index_term  returns [String val]
    :   i = index_factor    {val = $i.val;}
    ('*'^ i1 = index_factor
    {Temp r = new Temp(Type.Int);
    r.s = "t" + r.number;
    val = r.s;
    r.emit("mult, " + $i.val + ", " + $i1.val + ", " + r.s);
    })*
    ;  /* no division allowed in index */
    
index_factor    returns [String val]
    :INTLIT     {val = INTLIT.text;}
    | ID        {val = ID.text;}
    ;

