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
    ENDIF = 'endif';
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
}

@header {
// Not sure if we need this
	import java.util.Map;
	import java.util.TreeMap;
	import java.util.ArrayList;
	import java.util.Stack;
	import java.util.LinkedList;
	import java.io.*;
}



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
					//System.out.println("ERROR in \"" + currFunc.funcName + "\" " +"Symbol table " + i +": \n" + tableList.get(i) + "\n");
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
//				System.out.println("ERROR in \"" + currFunc.funcName + "\" " +"Symbol Found : "+ name + " "+ stack.get(i).get(name));
				return stack.get(i).get(name);
			}
		}

//		if (currFunc == null) {
//			System.out.println("ERROR in \"" + currFunc.funcName + "\" " +"In Global level, " + name + ": Symbol not found in SymbolTable!\n");
//		} else {
			System.out.println("ERROR in \"" + currFunc.funcName + "\" " +"In Function " + currFunc.funcName + " " + name + ": Symbol not found in SymbolTable!\n");
//		}
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

System.out.println("ERROR in \"" + currFunc.funcName + "\" " +"looking for : " + funcName);
		Var func = getValue(funcName);
		if (func == null) {
			System.out.println("ERROR in \"" + currFunc.funcName + "\" " +funcName + " function not found!");
		} else if(!(func instanceof Function)) {
			System.out.println("ERROR in \"" + currFunc.funcName + "\" " +funcName + " is supposed to be Function type!\n");
		} else {

			ArrayList<Id> fpList = ((Function)func).getParamList();
System.out.println("ERROR in \"" + currFunc.funcName + "\" " +funcName + "/The parameters from symbol table are : " + fpList);
System.out.println("ERROR in \"" + currFunc.funcName + "\" " +funcName + "/The used parameters are : " + pList);
			// checking if the function doesn't have paramter
			// it's wrong even when either one is null
			if(fpList != null && pList != null) {
			if(pList.size() != fpList.size()) { 
				System.out.println("ERROR in \"" + currFunc.funcName + "\" " +funcName + " has wrong number of parameter!\n");
			} else {
				for(int i = 0; i < pList.size(); i++) {
					Var id = getValue(pList.get(i));
					if(!(id instanceof Id)) {
						System.out.println("ERROR in \"" + currFunc.funcName + "\" " +funcName + " function has wrong parameter!\n");
					} else if(!fpList.get(i).type.equals(((Id)id).type)) {
						System.out.println("ERROR in \"" + currFunc.funcName + "\" " +funcName + " function has wrong parameter type!\n");
					} else if(((Id)id).init) {
						System.out.println("ERROR in \"" + currFunc.funcName + "\" " +funcName + " a parameter is not initialized before use!\n");
					}
				}
			}
			}
		}
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

tiger_program 
    : 
	{	
		// This new SymbolTable will be the global SymbolTable
		level = 0;
		enterNewScope(new SymbolTable(level));
		// Add Standard Library Functions into Global Symbol Table
		addSTL();
	}
	type_declaration_list funct_declaration_list_then_main 
		{printSymbol();}
//		{getValue("Mat33");getValue("x");}
	EOF 
	-> ^(PROGRAM type_declaration_list funct_declaration_list_then_main)
;


funct_declaration_list_then_main
    : myRet=VOID! (funct_declaration_tail[$myRet, $myRet.text] funct_declaration_list_then_main | main_function_tail)

    | (myRet=ID|myRet=INT|myRet=FIXEDPT) funct_declaration_tail[$myRet, $myRet.text] funct_declaration_list_then_main
    ;

funct_declaration_tail[Token retType, String returnType]
    : {Type type = new Type($returnType);}
        FUNCTION ID '(' param_list ')' 
	{
		Function newFunc = new Function($ID.text, type, $param_list.paramList);
		getTopTable().put($ID.text, newFunc);

//new Function($ID.text, type, $param_list.paramList));
		currFunc = newFunc;

		enterNewScope(new SymbolTable(level));

		for(int i = 0; i < $param_list.paramList.size(); i++) {

			getTopTable().put($param_list.paramList.get(i).getName(), 
					new Id($param_list.paramList.get(i).getName(), $param_list.paramList.get(i).getType(),true));
		}

	}

	BEGIN block_list END ';' 
	{
		exitScope();
		currFunc = new Function("Global level", Type.Int, new ArrayList());
	}

	-> ^(FUNCTION {new CommonTree($retType)} ID param_list block_list)
    ;

main_function_tail 
    : MAIN '(' ')' BEGIN block_list END ';' 
	-> ^(MAINSCOPE block_list);

param_list returns[ArrayList<Id> paramList]
    : {$paramList = new ArrayList<Id>();}
    (par1=param {$paramList.add($par1.param);} 
	( ',' par2=param {$paramList.add($par2.param);})*)? 

	-> ^(PARAMLIST param*)
    ;

param returns[Id param]
	: ID ':' type_id
        {$param = new Id($ID.text, $type_id.e);}
    ;


block_list
    : block+ -> ^(BLOCKLIST block+);

block 
	: BEGIN 
		{enterNewScope(new SymbolTable(level));} 
	declaration_segment stat_seq END ';'

		{exitScope();} 

	-> ^(BLOCKSCOPE declaration_segment stat_seq);

declaration_segment 
    : type_declaration_list var_declaration_list ;

type_declaration_list
    : type_declaration* 
	-> ^(TYPEDECLLIST type_declaration*)
    ;
    
var_declaration_list
    : var_declaration* 
	-> ^(VARDECLLIST var_declaration*)
    ;

type_declaration 
    : TYPE ID '=' type ';'

	{
		if($type.w == 0) {
			getTopTable().put($ID.text, new UserType($ID.text, new Type($type.e.name)));
		} else if ($type.h==0) {
			getTopTable().put($ID.text, new UserType($ID.text, new Array($type.e.name, $type.w, $type.e)));
		} else {
			getTopTable().put($ID.text, new UserType($ID.text, new TwoDArray($type.e.name, $type.w, $type.h, $type.e)));
		}
	}

	-> ^(TYPEDECL ID type);

type returns [Type e, int w, int h]
    : base_type {$e = $base_type.e;}
    | {int i = 0;$w=0;$h=0;} ARRAY '[' init1=INTLIT ']' ('[' init2=INTLIT ']'{i++;})? OF base_type 
	{if(i == 0) {
		$w = Integer.parseInt($init1.text);
		$h = 0;
		$e = $base_type.e;
	} else {
		$w = Integer.parseInt($init1.text);
		$h = Integer.parseInt($init2.text);
		$e = $base_type.e;
	}
	}
	-> ^(ARRAY base_type INTLIT+)
    ;

type_id returns [Type e]

    : base_type {$e = $base_type.e;}
	// This is for user defined type
	// Haven't checked if $id.text is working, but should ID's String

    | id=ID {$e = new Type($id.text);}
    ;

//@returns initialized Type object
base_type returns [Type e]
    : INT {$e = Type.Int;} // check here again
    | FIXEDPT {$e = Type.Float;} 
    ;

var_declaration 
    : 
// The place where we add variables into SymbolTable

	VAR id_list ':' type_id optional_init ';' 
		{
			for(int i = 0; i < $id_list.list.size(); i++) {
				getTopTable().put($id_list.list.get(i), new Id($id_list.list.get(i), $type_id.e, $optional_init.b));
			}
		}

	-> ^(VAR type_id id_list optional_init?);



id_list returns[ArrayList<String> list]
    :{$list = new ArrayList();} 
	i=ID {$list.add($i.text);}(',' j=ID {$list.add($j.text);})* 
	
		-> ^(IDLIST ID+)
    ;

optional_init returns[boolean b]
// literal is initialize value

    : {$b = true;}':=' literal 
    | {$b = false;}
    ;

stat_seq
    : stat+
    ;

stat
    : function_call_or_assignment
    | IF expr {if (!$expr.e.type.name.equals("boolean"))} THEN seq1=stat_seq 
        ( ELSE seq2=stat_seq ENDIF
            -> ^(IF expr ^(THEN_STATS $seq1) ^(ELSE_STATS $seq2))
        | ENDIF
            -> ^(IF expr ^(THEN_STATS $seq1))
        ) ';'
    | WHILE expr {if (!$expr.e.type.name.equals("boolean"))} DO stat_seq ENDDO ';'
        -> ^(WHILE expr stat_seq)
    | FOR ID ':=' index_expr TO index_expr DO stat_seq ENDDO ';'
        -> ^(FOR ID index_expr index_expr stat_seq)
    | BREAK ';'!
    | RETURN expr ';'
        -> ^(RETURN expr)
    | block
    ;

// This returns parameter list
function_args returns[ArrayList<String> pList]
    : '(' expr_list ')'
	{$pList = $expr_list.list;}
        -> expr_list?
    ;

function_call_or_assignment
    : ID 
        (function_args
		{
			checkFuncParam($ID.text, $function_args.pList);
		}
		// should compare pList(String) and fpList(Id)
		// check parameter list here
		// This is the case when Function returnType is Void
            -> ^(FUNCTION_CALL ID function_args?)

        | value_tail ':=' expr_or_function_call
		{
			Var v = getValue($ID.text);
			Type t = $expr_or_function_call.t;
			if(v == null || t == null) {
				System.out.println("ERROR in \"" + currFunc.funcName + "\" " +$ID.text + " function_call_or_assignment NULL!");
			} else if(!((Id)v).type.name.equals(t.name)) {
				System.out.println("ERROR in \"" + currFunc.funcName + "\" " +$ID.text + "=> Assignment Type doesn't match!" + " " + ((Id)v).type.name + "/ "+ t.name);
			} else {
				((Id)v).initId();
			}
		}
		// compare type of ID and expr_or_function_call
		// check if the ID is array
		// check type at the both side
            -> ^(':=' ^(ID value_tail?) expr_or_function_call)
        ) ';'
    ;

// Check if the return has to be Type or Expr
// Input should be Expr
expr_or_function_call returns[Type t]
    : ID // ID : function name
        (expr_with_start_id[$ID, $ID.text] 


		-> ^(EXPR_WITH_START_ID expr_with_start_id?)
        | ((function_args 
		{
			checkFuncParam($ID.text, $function_args.pList);
			Var fun = getValue($ID.text);
			if (fun == null) {
				System.out.println("ERROR in \"" + currFunc.funcName + "\" " +$ID.text + " Function not found in Symbol Table!");
			} else {
				$t = ((Function)fun).funcReturn();
			}
		})
            -> ^(FUNCTION_CALL ID function_args?))
        )
    | (expr_no_start_id
	//{
//		$t = $expr_no_start_id.e.type;
//commented out because returned value $e is null
	//}
)
    ;

/* notation: termN corresponds to precedence level N */
expr returns[Expr e]
    : {int i = 0;}t1=term4 (and_operator^ t2=term4
            {
                if (Logical.typeCheckPassed($t1.e, $t2.e)) {
                    $e = new Expr("bool", Type.Bool);
                }
                i++;
            })*
      {
          if (i == 0) {
              $e = $t1.e; // if there is no second operand, term1's type should be returned
      }
    };


term4 returns[Expr e]
    : {int i = 0;}t1=term3 (compare_operator^ t2=term3
            {
                if (Arith.typeCheckPassed($t1.e, $t2.e)) {
                     $e = new Expr("bool", Type.Bool);   
	// if both terms' types are correct, a boolean value should be returned 
                    }
                    i++;
            })* 
    {
		if(i == 0) {
			$e = $t1.e; // if there is no second operand, term1's type should be returned
		}
	}
    ;
term3 returns[Expr e]
    : {int i = 0;}t1=term2 (add_operator^ t2=term2
	{
		if (Arith.typeCheckPassed($t1.e, $t2.e)) {
			$e = Arith.getFinalType($t1.e, $t2.e);
		}
		i++;
	})* 
	{
		if(i==0) {
			$e = $t1.e;
		}
	};

term2 returns[Expr e] 
    : {int i = 0;}t1=term1 (mult_operator^ t2=term1
	{
		if(Arith.typeCheckPassed($t1.e, $t2.e)) {
			$e = Arith.getFinalType($t1.e, $t2.e);
		}
            	i++;

	})*
	{
            if(i == 0) {
                $e = $t1.e;
            }
        };

term1 returns[Expr e]
    : literal {$e = $literal.e;}
    | value {$e = $value.e;}
    | '(' expr ')' {$e = $expr.e;}
        -> expr
    ;

expr_no_start_id returns[Expr e]
    : {int i = 0;}t1=term4_no_start_id (and_operator^ t2=term4
            {
                if (Logical.typeCheckPassed($t1.e, $t2.e)) {
                    $e = new Expr("bool", Type.Bool);
                }
                i++;
            })*
      {
          if (i == 0) {
              $e = $t1.e; // if there is no second operand, term1's type should be returned
      }
    };


term4_no_start_id returns[Expr e]
    : {int i = 0;}t1=term3_no_start_id (compare_operator^ t2=term3
            {
                if (Arith.typeCheckPassed($t1.e, $t2.e)) {
                     $e = new Expr("bool", Type.Bool);   
	// if both terms' types are correct, a boolean value should be returned 
                    }
                    i++;
            })* 
    	{
		if(i == 0) {
			$e = $t1.e; // if there is no second operand, term1's type should be returned
		}
	};


term3_no_start_id returns[Expr e]
    : {int i = 0;}t1=term2_no_start_id (add_operator^ t2=term2
	{
		if (Arith.typeCheckPassed($t1.e, $t2.e)) {
			$e = Arith.getFinalType($t1.e, $t2.e);
		}
		i++;
	})* 
	{
		if(i==0) {
			$e = $t1.e;
		}
	};

term2_no_start_id returns[Expr e]
    : {int i = 0;}t1=term1_no_start_id (mult_operator^ t2=term1
	{
		if(Arith.typeCheckPassed($t1.e, $t2.e)) {
			$e = Arith.getFinalType($t1.e, $t2.e);
		}
            	i++;

	})*
	{
            if(i == 0) {
                $e = $t1.e;
            }
        };


term1_no_start_id returns[Expr e]
    : literal {$e = $literal.e;}
    | '(' expr ')' {$e = $expr.e;}
        -> expr
    ;

expr_with_start_id[Token startId, String s]  returns [Expr e]
    : {int i = 0;} t1=term4_with_start_id[$startId, $s] (and_operator^ t2=term4
	{
                if (Logical.typeCheckPassed($t1.e, $t2.e)) {
                    $e = new Expr("bool", Type.Bool);
                }
                i++;
            })*
      {
          if (i == 0) {
              $e = $t1.e; // if there is no second operand, term1's type should be returned
      }
    };


term4_with_start_id[Token startId, String s] returns [Expr e]
    : {int i = 0;} t1=term3_with_start_id[$startId, $s] (compare_operator^ t2=term3
            {
                if (Arith.typeCheckPassed($t1.e, $t2.e)) {
                     $e = new Expr("bool", Type.Bool);   
	// if both terms' types are correct, a boolean value should be returned 
                    }
                    i++;
            })* 
    	{
		if(i == 0) {
			$e = $t1.e; // if there is no second operand, term1's type should be returned
		}
	};


term3_with_start_id[Token startId, String s] returns [Expr e]
    : {int i = 0;} t1=term2_with_start_id[$startId, $s] (add_operator^ t2=term2
	{
		if (Arith.typeCheckPassed($t1.e, $t2.e)) {
			$e = Arith.getFinalType($t1.e, $t2.e);
		}
		i++;
	})* 
	{
		if(i==0) {
			$e = $t1.e;
		}
	};


term2_with_start_id[Token startId, String s] returns [Expr e]
    : {int i = 0;} t1=term1_with_start_id[$startId, $s] (mult_operator^ t2=term1
	{
		if(Arith.typeCheckPassed($t1.e, $t2.e)) {
			$e = Arith.getFinalType($t1.e, $t2.e);
		}
            	i++;

	})*
	{
            if(i == 0) {
                $e = $t1.e;
            }
        };



term1_with_start_id[Token startId, String s] returns[Expr e]
    : value_tail {
		Var v = getValue(s);
		if(v == null) {
			System.out.println("ERROR in \"" + currFunc.funcName + "\" " +s + " Symbol not found! / term1_with_start_id");
		} else if(!(v instanceof Id)) {
			System.out.println("ERROR in \"" + currFunc.funcName + "\" " +s + " is not Id! / term1_with_start_id");
		} else {
			$e = ((Expr)v);
		}
	}

	-> ^({new CommonTree($startId)} value_tail?)

    ;

expr_list returns[ArrayList<String> list]
    : {$list = new ArrayList();} e1=expr {$list.add($e1.text);} 
	( ',' e2=expr {$list.add($e2.text);})* -> ^(EXPRLIST expr+)
    |
    ;

mult_operator 
    : '*' | '/' ;

add_operator 
    : '+' | '-' ;

compare_operator 
    : '=' | '<>' | '<' | '>' | '<=' | '>=' ;

and_operator 
    : '&' | '|' ;

value returns[Expr e]
    : ID value_tail 
	{
		Var v = getValue($ID.text);
		if (!(v instanceof Id)) {
			System.out.println("ERROR in \"" + currFunc.funcName + "\" " +$ID.text + " is not Id value Type!");
		} else if(!((Id)v).init) {
			System.out.println("ERROR in \"" + currFunc.funcName + "\" " +$ID.text + " is not initialized before use!");
		} else {
			$e = ((Id)v);
		}
	}

-> ^(ID value_tail?);

literal returns[Expr e]
    : INTLIT {$e = new Constant($INTLIT.text, Type.Int);}
    | FIXEDPTLIT {$e = new Constant($FIXEDPTLIT.text, Type.Float);}
    ;

value_tail 
    : '[' index_expr ']' ('[' index_expr ']')?
            -> index_expr+  /* antlr will auto-group two index_expr's */
    | /* null */
    ;

// Below this line are for array index
index_expr returns[Expr e]
    : {int i = 0;} t1=index_term (add_operator^ t2=index_term
    {
     if(Arith.typeCheckPassed($t1.e, $t2.e)) {
			$e = Arith.getFinalType($t1.e, $t2.e);
		}
           	i++;
    })* 
	{
        if(i == 0) {
            $e = $t1.e;
        }
    }
    ;

index_term returns[Expr e]
    : {int i = 0;} t1=index_factor ('*'^ t2=index_factor
	{
		if(Arith.typeCheckPassed($t1.e, $t2.e)) {
			$e = Arith.getFinalType($t1.e, $t2.e);
		}
           	i++;
    })*
	{
        if(i == 0) {
            $e = $t1.e;
        }
    }
    ;  /* no division allowed in index */

index_factor returns[Expr e]
    : INTLIT {$e = new Constant($INTLIT.text, Type.Int);}
    | ID {$e = (Id)getValue($ID.text);
          // ID's type has to be int
            if (!$e.type.name.equals("int")) {
                System.out.println("ID cannot be types other than int");
            }
        }
    ;
