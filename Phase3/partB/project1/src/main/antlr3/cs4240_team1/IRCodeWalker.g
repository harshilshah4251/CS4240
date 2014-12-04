tree grammar IRCodeWalker;

options {
    tokenVocab = Tiger;  /* uses Tiger.tokens */
    ASTLabelType = CommonTree;
}

@header {
    package cs4240_team1;

    import java.util.ArrayList;
    import java.util.List;
    import java.util.Stack;
    import utility.Utility;
}

@members {

    /* we will populate the tempSymbolTable within Generation */
	Generation g = new Generation();

	/* this needs to be populated from the previous step in TigerMain.*/
    SymbolTable globalSymbolTable;


    /**
     * This stack is used to manage the traversal of the symbol tables
     * as we generate the IR code.
     */
    Stack<SymbolTable> scopeStack = new Stack();
}

walk
    : tiger_program EOF
    ; 

tiger_program
@init {
	SymbolTable currTable = globalSymbolTable;
	/* push the global symbol table's children to kick off the recursion!*/
	scopeStack.addAll(Utility.reverseList(globalSymbolTable.getChildren()));
	}
    : ^(PROGRAM type_declaration_list[currTable] funct_declaration* main_function)
    ;

funct_declaration
	@init{
		SymbolTable currTable = scopeStack.pop();	
		scopeStack.addAll(Utility.reverseList(currTable.getChildren()));
		//[CB 11/5/15] I think parameters is supposed to be modified by the kids.
    	List<Parameter> parameters = new ArrayList<>();
	}
    :	^(FUNCTION ret_type ID {
			g.emit(Op.LABEL, new LabelArgument($ID.text));
		} param_list[parameters] block_list) {
			if (currTable.returnType.isVoid()) {
				g.emit(Op.RETURN, new IRCodeArgument[0]);
			}
    	}
    ;

ret_type returns [String text]
    : VOID {$text = $VOID.text;}
    | ID {$text = $ID.text;}
    | INT {$text = $INT.text;}
    | FIXEDPT {$text = $FIXEDPT.text;}
    ;

main_function  
	@init {
		g.emit(Op.LABEL, new LabelArgument("main"));
		SymbolTable currTable = scopeStack.pop();	

		scopeStack.addAll(Utility.reverseList(currTable.getChildren()));
	}
    :	^(MAINSCOPE block_list) {
			g.emit(Op.RETURN, new IRCodeArgument[0]);
    	}
    ;

/* each parameter will add its info to the "parameters" argument */
param_list[List<Parameter> parameters]
    : ^(PARAMLIST param[parameters]*)
    ;

param[List<Parameter> parameters]
    :   ^(ID type_id) 
    ;

block_list
	/* [CB 11/2/14] we know that we are NOT in a loop here, pass null for loopExitLabel to block */
    : ^(BLOCKLIST block[null]+) 
    ;

/* [CB 11/5/14] pop the appropriate scope off the stack */
block[IRCodeArgument loopExitLabel]
	@init {
		SymbolTable currTable = scopeStack.pop();	
		scopeStack.addAll(Utility.reverseList(currTable.getChildren()));
	}
    : ^(BLOCKSCOPE type_declaration_list[currTable] var_declaration_list[currTable] stat_seq[currTable, loopExitLabel])
    ;

type_declaration_list[SymbolTable currTable]
    : ^(TYPEDECLLIST type_declaration*)
    ;

var_declaration_list[SymbolTable currTable]
    : ^(VARDECLLIST var_declaration[currTable]*)
    ;

type_declaration
    :	^(TYPEDECL ID type) 
    ;

type returns [String baseTypeId, String dimension1, String dimension2]
    :   base_type 
    |   ^(ARRAY base_type dim1=INTLIT dim2=INTLIT?) 
    ;

base_type returns [String text]
    : INT 
    | FIXEDPT 
    ;

/* declaring and initializing variables occurs inside id_list rule */
var_declaration[SymbolTable currTable]
    : 
     {IRCodeArgument initValue = null;}
      ^(VAR type_id (e1=optional_init
     {
    //g.emit(new IRComment("***var definition activated***"));
     initValue = $e1.outArg;}
      )? id_list[currTable, $type_id.text, initValue]) 
    
    ;

type_id returns [String text]
    : base_type 
    | ID 
    ;

id_list[SymbolTable currTable, String typeId, IRCodeArgument initValue]
    :	^(IDLIST (ID
    {if(initValue!=null) {
        VarEntry varEntry = (VarEntry) currTable.lookup($ID.text);
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
    }}
    )+)
    ;

/* return the value of the init statement */
optional_init returns [IRCodeArgument outArg]
    :   ^(':=' literal) {
        $outArg = $literal.outArg; 
    }
    ;

/* defines rules for stat_seq, which is*/
stat_seq[SymbolTable currTable, IRCodeArgument loopExitLabel]
    : stat[currTable, loopExitLabel]+ 
    ;


/*[CB 11/9/14] loopExitLabel is populated if we are currently in a loop.
  allows BREAK statements to have something to jump to */
stat[SymbolTable currTable, IRCodeArgument loopExitLabel]
    :   function_call[currTable,false]
    |   assignment[currTable]
    |	{
			boolean hasElseStats;  /* if true, we need a goto endIf target */
			boolean hasShortCircuit;  /* if true, we may need a true target */
			LabelArgument trueTarget = null;
			LabelArgument falseTarget;
			LabelArgument endTarget;  /* only used for if-then-else */
		}
		^(IF {
			hasElseStats = $IF.getChildCount() == 3;
			String boolOperator = $IF.getChild(0).getText();
			hasShortCircuit = "&".equals(boolOperator) || "|".equals(boolOperator);
			if (hasShortCircuit) {
				trueTarget = g.newLabel1();
			}
			falseTarget = g.newLabel1();
			endTarget = (hasElseStats) ? g.newLabel1() : falseTarget;
		}	
			bool_expr[currTable, falseTarget, trueTarget, falseTarget, true]
			^(THEN_STATS {
				if (trueTarget != null) {
					g.emit(Op.LABEL, trueTarget);
				}
			} stat_seq[currTable,loopExitLabel]) {
				if (hasElseStats) {
					g.emit(Op.GOTO, endTarget);
				}
				g.emit(Op.LABEL, falseTarget);
			}
			(^(ELSE_STATS stat_seq[currTable,loopExitLabel] {
				g.emit(Op.LABEL, endTarget);
			}))?)
    |	{
            LabelArgument loopBeginLabel = g.newLabel1();
			LabelArgument bodyLabel = null;  /* may be need in case of short-circuiting (if there are ORs) */
            LabelArgument doneLabel = g.newLabel1();
    	    g.emit(Op.LABEL, loopBeginLabel); 
        }
        ^(WHILE {
			String boolOperator = $WHILE.getChild(0).getText();
			if ("&".equals(boolOperator) || "|".equals(boolOperator)) {
				bodyLabel = g.newLabel1();
			}
		} bool_expr[currTable, doneLabel, bodyLabel, doneLabel, true] {
			if (bodyLabel != null) {  /* short-circuting, so may need a body label */
				g.emit(Op.LABEL, bodyLabel);
			}
		} stat_seq[currTable, doneLabel] {
            g.emit(Op.GOTO, loopBeginLabel);
    	    g.emit(Op.LABEL, doneLabel); 
        }
        )
    |  
        {
            LabelArgument loopBeginLabel = g.newLabel1();
            LabelArgument doneLabel = g.newLabel1();
            VarEntry counter = g.newTemp(TigerType.BASE_INT_TYPE);
            IRCodeArgument start= $i1.outArg;
        }
     ^(FOR ID i1=index_expr[currTable] 
     (i2=index_expr[currTable]
       {
		  /* note: current algorithm allows user to write to indexVar
		   * without affecting loop iterations
           */
		  VarEntry indexVar = (VarEntry) currTable.lookup($ID.text);
          VarEntry stopCount = g.newTemp(TigerType.BASE_INT_TYPE); //stopCount tells you when to stop the loop.

          g.emit(Op.ASSIGNVAR, stopCount, $i2.outArg);
    	  g.emit(Op.ASSIGNVAR,counter ,$i1.outArg); //counter starts at the lower bound, counts up to stopCount
    	  g.emit(Op.LABEL, loopBeginLabel); 
          g.emit(Op.BRGT, counter, stopCount, doneLabel);
		  g.emit(Op.ASSIGNVAR, indexVar, counter);
          g.emit(Op.ADD, counter, new LiteralArgument("1",TigerType.LITERAL_INT_TYPE), counter);
       }
     ) (stat_seq[currTable, doneLabel]
        {
            g.emit(Op.GOTO, loopBeginLabel);
    	    g.emit(Op.LABEL, doneLabel); 
        }
     ))
    /*[CB 11/2/14] BREAK statements can only occur in a loop */
    |   BREAK {
        g.emit(Op.GOTO, loopExitLabel); 
    }
    |   ^(RETURN expr[currTable]) {
			g.emit(Op.RETURN, $expr.outArg);
		}
    /*[CB 11/5/14] don't need to pass table to block, as block will pop off the
      next table off the stack anyway!*/
    |   block[loopExitLabel]
    ;

assignment[SymbolTable currTable] returns [IRCodeArgument outArg]
@init {
    boolean has_tail = false;
}
    : ^(':=' ^(ID (value_tail[currTable, $ID.text] {has_tail = true;})?) (res=expr[currTable] | res=function_call[currTable,true])) {
        VarEntry outStore = (VarEntry) currTable.lookup($ID.text);
        if(has_tail) {
            g.emit(Op.ARRAYSTORE,  outStore, $value_tail.offset_reg, $res.outArg);
        } else {
    	   g.emit(Op.ASSIGNVAR,outStore, $res.outArg);
        }
    }
    ;

function_call[SymbolTable currTable, boolean fnHasReturn] returns [IRCodeArgument outArg]
@init {
    List<IRCodeArgument> callArgs;
    Boolean hasArgs = false;

}
    : ^(FUNCTION_CALL ID (function_args[currTable] {hasArgs = true;} )?) {
        $outArg = null;
        callArgs = hasArgs ? $function_args.varsToPass : new ArrayList<IRCodeArgument>();
        IRCodeArgument funcEntry = (FunctionEntry) currTable.lookupFunctionIncludingStdLib($ID.text);
        TigerType funcType = funcEntry.getTigerType();
        VarEntry temp = g.newTemp(funcType);
        callArgs.add(0, funcEntry);

        /*[CB 11/9/14] we do not worry about pass-by-value in this phase*/  
            if(fnHasReturn) {
                callArgs.add(0, temp);
                $outArg = temp;
                g.emit(Op.CALLR, callArgs);
            } else {
                g.emit(Op.CALL, callArgs);
                }
    }
    ;

/* returns a list of the register names holding the values to pass*/
function_args[SymbolTable currTable] returns [List<IRCodeArgument> varsToPass]
@init {
    List<IRCodeArgument> realFnArgs = new ArrayList<IRCodeArgument>();
}
    : ^(EXPRLIST (ei=expr[currTable] {
	realFnArgs.add($ei.outArg);
	})+)
    {$varsToPass = realFnArgs;}
    ;

/* used with "if-then", "if-then-else", and "while"
 *
 * The parameters for the bool_expr rule vary on meaning depending on the operator.
 *
 * branchLabel
 *   for comparison operators:  the label to use in their branch
 *   this is unused as a parameter for logical operators.
 *   However, logical operators need to set this value appropriately for their conditional children
 *
 * trueLabel
 *   for comparison operators:  ignore this value
 *   for logical operators:  the label of the calling rule's "true" target
 *
 * falseLabel
 *   the label of the calling rule's "false" target (ignored by comparison ops)
 *
 *   NOTE: logicals will need to pass appropriate labels down the chain based on short-circuiting
 *
 * negate
 *   for comparison operators:
 *       if negate is true, then the branch instruction should correspond to the negated operator
 *       i.e.  '=' would emit a 'brneq' instruction
 *
 *   for logical operators:
 *       ignore this value as a parameter
 *       logicals set this parameter appropriately for their children
 */

bool_expr[SymbolTable currTable,
          LabelArgument branchLabel,
          LabelArgument trueLabel,
          LabelArgument falseLabel,
          boolean negate]
	:	logical_expr[currTable, trueLabel, falseLabel, null]
	|	compare_expr[currTable, branchLabel, negate]
	;

/* rightShortCircuit represents the short circuit policy to use for the right-most compare node in a subtree */
logical_expr[SymbolTable currTable, LabelArgument trueLabel, LabelArgument falseLabel, String rightShortCircuit]
@init {
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

}
	:	^(op='&'
			{
				leftChildText = $op.getChild(0).getText();
				if ("|".equals(leftChildText) || "&".equals(leftChildText)) {
					secondExprLabel = g.newLabel1();
				}
			}
			(	logical_expr[currTable, secondExprLabel, falseLabel, "&"]
			|	compare_expr[currTable, falseLabel, true]  /* short circuit on false */
			)
			{
				if (secondExprLabel != null) {
					g.emit(Op.LABEL, secondExprLabel);
				}
			}
			(	logical_expr[currTable, trueLabel, falseLabel, rightShortCircuit]
			|	compare_expr[currTable, secondBranchLabel, secondBranchNegate]
			)
		)
	|	^(op='|'
			{
				leftChildText = $op.getChild(0).getText();
				if ("|".equals(leftChildText) || "&".equals(leftChildText)) {
					secondExprLabel = g.newLabel1();
				}
			}
			(	logical_expr[currTable, trueLabel, secondExprLabel, "|"]
			|	compare_expr[currTable, trueLabel, false]  /* short circuit on true */
			)
			{
				if (secondExprLabel != null) {
					g.emit(Op.LABEL, secondExprLabel);
				}
			}
			(	logical_expr[currTable, trueLabel, falseLabel, rightShortCircuit]
			|	compare_expr[currTable, secondBranchLabel, secondBranchNegate]
			)
		)
	;

compare_expr[SymbolTable currTable, LabelArgument branchLabel, boolean negate]
@init {
	Op opCode;
}
    /* Comparison operators:  < <= > >= = <> */
    :   ^('=' e1=expr[currTable] e2=expr[currTable]) {
			opCode = negate ? Op.BRNEQ : Op.BREQ;
			g.emit(opCode, $e1.outArg, $e2.outArg, branchLabel);
		}
    |   ^('<>' e1=expr[currTable] e2=expr[currTable]) {
			opCode = negate ? Op.BREQ : Op.BRNEQ;
			g.emit(opCode, $e1.outArg, $e2.outArg, branchLabel);
		}
    |   ^('<' e1=expr[currTable] e2=expr[currTable]) {
			opCode = negate ? Op.BRGEQ : Op.BRLT;
			g.emit(opCode, $e1.outArg, $e2.outArg, branchLabel);
		}
    |   ^('>=' e1=expr[currTable] e2=expr[currTable]) {
			opCode = negate ? Op.BRLT : Op.BRGEQ;
			g.emit(opCode, $e1.outArg, $e2.outArg, branchLabel);
		}
    |   ^('>' e1=expr[currTable] e2=expr[currTable]) {
			opCode = negate ? Op.BRLEQ : Op.BRGT;
			g.emit(opCode, $e1.outArg, $e2.outArg, branchLabel);
		}
    |   ^('<=' e1=expr[currTable] e2=expr[currTable]) {
			opCode = negate ? Op.BRGT : Op.BRLEQ;
			g.emit(opCode, $e1.outArg, $e2.outArg, branchLabel);
		}
	;

/* each expr returns the variable holding the results of evaluating expr */
expr[SymbolTable currTable] returns [IRCodeArgument outArg]
    /* Add operators:  + - */
    :   ^('+' e1=expr[currTable] e2=expr[currTable]) {
        TigerType promotedType = TypeChecker.getTypeAfterArithmetic($e1.outArg.getTigerType(), $e2.outArg.getTigerType());
    	VarEntry outStore = g.newTemp(promotedType);

		g.emit(Op.ADD,$e1.outArg ,$e2.outArg ,outStore);

    	$outArg = outStore;
    
    }
    |   ^('-' e1=expr[currTable] e2=expr[currTable]) {
		TigerType promotedType = TypeChecker.getTypeAfterArithmetic($e1.outArg.getTigerType(), $e2.outArg.getTigerType());
    	VarEntry outStore = g.newTemp(promotedType);
   
		g.emit(Op.SUB,$e1.outArg ,$e2.outArg ,outStore); 

    	$outArg = outStore;
    }

    /* Mult operators: */ 
    |   ^('*' e1=expr[currTable] e2=expr[currTable]) {
		TigerType promotedType = TypeChecker.getTypeAfterArithmetic($e1.outArg.getTigerType(), $e2.outArg.getTigerType());
    	VarEntry outStore = g.newTemp(promotedType);
		g.emit(Op.MULT,$e1.outArg ,$e2.outArg ,outStore); 

    	$outArg = outStore;
    }
    |   ^('/' e1=expr[currTable] e2=expr[currTable]) {
		TigerType promotedType = TypeChecker.getTypeAfterArithmetic($e1.outArg.getTigerType(), $e2.outArg.getTigerType());
    	VarEntry outStore = g.newTemp(promotedType);
    
		g.emit(Op.DIV, $e1.outArg ,$e2.outArg ,outStore); 

    	$outArg = outStore;

    }

    | value[currTable] {

		IRCodeArgument outStore = $value.outArg;
    	$outArg = outStore;
    
    }
    | literal {
    	$outArg = $literal.outArg;
    }
    ;

/* index count is number of indexes in valueTail */
value[SymbolTable currTable] returns [IRCodeArgument outArg]
@init {
    boolean has_tail = false;
}
    :   ^(ID (value_tail[currTable, $ID.text] {has_tail = true;})?) {

		VarEntry entry = (VarEntry) currTable.lookup($ID.text);
		if (has_tail) {
				VarEntry outStore = g.newTemp(TigerType.BASE_INT_TYPE);
				g.emit(Op.ARRAYLOAD, outStore , entry, $value_tail.offset_reg);
				$outArg = outStore;
		} else {
				$outArg = entry;
		}
    }
    ;

literal returns [IRCodeArgument outArg]
    :   INTLIT {
        $outArg = new LiteralArgument($INTLIT.text, TigerType.LITERAL_INT_TYPE);
        }
    |   FIXEDPTLIT {
        $outArg = new LiteralArgument($FIXEDPTLIT.text, TigerType.LITERAL_FIXEDPT_TYPE);
        }
    ;

/* index count is number of indexes in valueTail */
/* returns a register holding the results of doing the
   array calculation */
value_tail[SymbolTable currTable, String arrayName] returns [IRCodeArgument offset_reg]
@init {
    Boolean twoArgs = false;
}
    : (i1=index_expr[currTable]) (i2=index_expr[currTable] {twoArgs = true;})? {
        if (twoArgs) {
          VarEntry arrayEntry = (VarEntry) currTable.lookup($value_tail.arrayName);
          TigerType dimensions = arrayEntry.type;
          LiteralArgument indexArg = new LiteralArgument(dimensions.dimension2.toString(), TigerType.LITERAL_INT_TYPE);
		  VarEntry outStore = g.newTemp(TigerType.BASE_INT_TYPE);
		  VarEntry outStore2 = g.newTemp(TigerType.BASE_INT_TYPE);
		  g.emit(Op.MULT, $i1.outArg, indexArg, outStore);
		  g.emit(Op.ADD, outStore, $i2.outArg ,outStore2);
		  $offset_reg = outStore2;
        } else {
            $offset_reg = $i1.outArg;
        }
    }
    ;

index_expr[SymbolTable currTable] returns [IRCodeArgument outArg]
    : ^('+' i1=index_expr[currTable] i2=index_expr[currTable]) {
        VarEntry temp = g.newTemp(TigerType.BASE_INT_TYPE);
        g.emit(Op.ADD,$i1.outArg ,$i2.outArg ,temp);
        $outArg = temp;
    }
    | ^('-' i1=index_expr[currTable] i2=index_expr[currTable]) {
        VarEntry temp = g.newTemp(TigerType.BASE_INT_TYPE);
        g.emit(Op.SUB,$i1.outArg ,$i2.outArg ,temp);
        $outArg = temp;
    }
    | ^('*' i1=index_expr[currTable] i2=index_expr[currTable]) {
        VarEntry temp = g.newTemp(TigerType.BASE_INT_TYPE);
        g.emit(Op.MULT,$i1.outArg ,$i2.outArg ,temp);
        $outArg = temp;
    }
    | INTLIT {
        $outArg = new LiteralArgument($INTLIT.text, TigerType.LITERAL_INT_TYPE);
    }
    /* Not actually a temp, preserving the name for the return value */
    | ID {
       VarEntry uniqueVar = ((VarEntry) currTable.lookup($ID.text));
       $outArg = uniqueVar;
    }
    ;

