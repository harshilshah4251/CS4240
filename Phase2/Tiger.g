grammar Tiger;

options {
  language = Java;
  
 
  k=1; backtrack = no;
}
 

tiger_program
  : type_declaration_list funct_declaration main_function
  ;

// Reserved key words

Function : 'function';
Begin : 'begin';
End : 'end';
Void : 'void';
Main : 'main';
Type : 'type';
Array : 'array';
Of : 'of';
Int : 'int';
Fixedpt : 'fixedpt';
Var : 'var';
If : 'if';
Then : 'then';
Endif : 'endif';
Else : 'else';
While : 'while';
Do : 'do';
Enddo : 'enddo';
For : 'for';
To : 'to';
Break : 'break';
Return : 'return';

//Punctuation Symbols / Binary operators

COMMA : ',';
COLON : ':';
SEMI : ';';
LPAREN : '(';
RPAREN : ')';
LBRACK : '[';
RBRACK : ']';
PLUS : '+';
MINUS : '-';
MULT : '*';
DIV : '/';
EQ : '=';
NEQ : '<>';
LESSER : '<';
LESSEREQ : '<=';
GREATER : '>';
GREATEREQ : '>=';
AND : '&';
OR : '|';
ASSIGN : ':=';


//Lexical Rules

ID:('a'..'z' | 'A'..'Z')('a'..'z' | 'A'..'Z' | '0'..'9' | '_')*;
COMMENT: '/*' ( options {greedy=false;} : . )* '*/'{$channel = HIDDEN;};
INTLIT : ('0'..'9') | (('1'..'9')('0'..'9')+);
FIXEDPTLIT  :  INTLIT ('.')  ('0'..'9')(('0'..'9')('0'..'9')?)?; 
WS: (' ' | '\t' | '\n' | '\r' | '\f')+ {$channel = HIDDEN;};


//LL(1) modification is done 
//
//before modification : 
//funct_declaration
//  : ret_type Function ID '(' param_list ')' Begin block_list End ';'
//  ;
//main_function
//  : Void Main '('')' Begin block_list End ';'
//  ;

funct_declaration
  : Void funct_declaration_tail
  | funct_declaration_type_id funct_declaration
  ;
  
funct_declaration_tail
  : (funct_declaration_void funct_declaration)?
  ;
  
funct_declaration_type_id
  : type_id Function ID '(' param_list ')' Begin block_list End ';'
  ;
funct_declaration_void
  : Function ID '(' param_list ')' Begin block_list End ';'
  ;  
main_function
  : Main '('')' Begin block_list End ';'
  ;
    


  
ret_type
  : Void
  | type_id
  ;
  

param_list
  : (param param_list_tail)?
  ;
param_list_tail
  : (',' param param_list_tail)?
  ;
param
  : ID ':' type_id
  ;
  
block_list
  : block block_tail   
  ;
  
block_tail
  : (block block_tail)?   
  ;

block 
  : Begin declaration_segment stat_seq End ';'
  ;

declaration_segment
  : type_declaration_list var_declaration_list
  ;

type_declaration_list
  : (type_declaration type_declaration_list)?
  ;

var_declaration_list
  : (var_declaration var_declaration_list)?
  ;

type_declaration
  : Type ID '=' type ';'
  ;
  
  
  
// LL(1) modification is done   
// before modification,  
//  : base_type 
//  | ('array [' INTLIT ']' Of base_type)
//  | ('array [' INTLIT ']' '[' INTLIT ']' Of base_type)
type
  : base_type | (Array ' [' INTLIT ']' type_tail Of base_type)
  ;
  
type_tail
  :  ('[' INTLIT ']')?
  ;
  

type_id
  : base_type 
  |  ID
  ;

base_type
  : Int 
  | Fixedpt
  ;

var_declaration
  : Var id_list ':' type_id optional_init ';'
  ;



// LL(1) modification is done  
// before modification: 
//  : ID 
//  | (ID ',' id_list)
id_list
  : ID id_list_tail 
  ;

id_list_tail
  : (',' id_list)?
  ;
  
  
optional_init
  : (':=' constant)?
  ;
  
  
  
// LL(1) modification is done  
// before modification: 
// stat | stat stat_seq 
stat_seq
  : stat stat_seq_tail
  ;
stat_seq_tail
  : stat_seq?
  ;
    
    

// LL(1) modification is done  
stat
  : ID id_stat
  | if_stat 
  | while_stat 
  | for_stat
  | break_stat
  | return_stat
  | (block)
  ;
id_stat
  : (value_tail ':=' stat_tail ';') 
  | ('(' expr_list ')' ';') 
  ;
  
  
// LL(1) modification is done
//
//before modification : 
//stat_tail
//  : expr 
//  | (ID '(' expr_list ')') 
//  ;
//value
//  : ID value_tail
//  ;

stat_tail
  : special_expr
  | (ID stat_tail_tail) 
  ;
  
stat_tail_tail
  : value_expr
  | '(' expr_list ')'
  ;
  
// this expression is using (expr) and constant only for the first input, not value
special_expr
  : special_expr_head special_expr_tail
  ;
  
special_expr_tail
  : logical_op expr
  | special_expr1
  ;

special_expr1
  : compar_op expr
  | special_expr2
  ;

special_expr2
  : add_op expr
  | special_expr3
  ;  
  
special_expr3
  : (mul_op expr)?
  ;    
  
special_expr_head
  : ('(' expr ')' )  | constant
  ;

// this expression is using value only for the first input, not constant and (expr)
value_expr
  : value_expr_head  value_expr_tail 
  ;
  
value_expr_tail
  : logical_op expr
  | value_expr1
  ;

value_expr1
  : compar_op expr
  | value_expr2
  ;

value_expr2
  : add_op expr
  | value_expr3
  ;  
  
value_expr3
  : (mul_op expr)?
  ;    
  
value_expr_head
  : value_tail  
  ;
  

  
  
  
//stat_tail part ends here  
  
  
if_stat
  : (If expr Then stat_seq else_stat Endif ';')
  ;

else_stat
  :  ( Else stat_seq )?
  ;

while_stat
  : (While expr Do stat_seq Enddo ';')
  ;

for_stat
  : (For ID ':=' index_expr To index_expr Do stat_seq Enddo ';') 
  ;

break_stat
  : (Break';') 
  ;

return_stat
  : (Return expr ';') 
  ;



// LL(1) modification is done  
// before modification: 
// : constant
// |  value 
// | expr binary_operator expr 
// | ('(' expr ')' )          
expr
  : expr1 expr_tail
  ;

expr_tail
  : (logical_op expr1 expr_tail)?
  ;

logical_op
  : '&' | '|'
  ;

expr1
  : expr2 expr1_tail
  ;

expr1_tail
  : (compar_op expr2 expr1_tail)?
  ;

compar_op
  : '=' | '<>' | '<' | '>' | '<=' | '>='
  ;

expr2
  : expr3 expr2_tail
  ;

expr2_tail
  : (add_op expr3 expr2_tail)?
  ;

add_op
  : '+' | '-'
  ;

expr3
  : factor expr3_tail
  ;

expr3_tail
  : (mul_op factor expr3_tail)?
  ;

mul_op
  : '*' | '/'
  ;

factor
  : ('(' expr ')' )  | constant| value
  ;


constant
  : INTLIT 
  | FIXEDPTLIT
  ;


expr_list
  : (expr expr_list_tail)?
  ;
  
expr_list_tail
  : (',' expr expr_list_tail)?
  ;


value
  : ID value_tail
  ;



// LL(1) modification is done  
// before modification:
//  : (('[' index_expr ']') 
//  | ('[' index_expr ']''[' index_expr ']'))?
value_tail
  :  ('[' index_expr ']' value_tail_tail )?
  ;
value_tail_tail
  : ('[' index_expr ']')?
  ;



// LL(1) modification is done  
// before modification:
//  : INTLIT  
//  | ID 
//  | ( (INTLIT | ID ) (index_oper)  (INTLIT | ID )) 
index_expr
  : index_expr1 index_expr_tail
  ;

index_expr_tail
  : (index_add_op index_expr1 index_expr_tail)?
  ;

index_add_op
  : '+' | '-'
  ;

index_expr1
  : index_expr_factor index_expr1_tail
  ;

index_expr1_tail
  : (index_mul_op index_expr_factor index_expr1_tail)?
  ;

index_mul_op
  : '*'
  ;

index_expr_factor
  : INTLIT | ID
  ;
 
 
 
 


