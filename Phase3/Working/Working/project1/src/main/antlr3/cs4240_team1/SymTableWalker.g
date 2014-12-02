tree grammar SymTableWalker;

options {
    tokenVocab = Tiger;  /* uses Tiger.tokens */
    ASTLabelType = CommonTree;
}

@header {
    package cs4240_team1;

    import java.util.ArrayList;
    import java.util.List;
}

@members {
    SymbolTable globalSymbolTable = new SymbolTable(true);
    List<SemanticError> errors = new ArrayList<SemanticError>();
}

walk
    : tiger_program EOF
    ;

tiger_program
    : ^(PROGRAM type_declaration_list[globalSymbolTable] funct_declaration[globalSymbolTable]* main_function[globalSymbolTable])
    ;

funct_declaration[SymbolTable symTable]
@init {
	SymbolTable nSymTable = new SymbolTable(symTable);
    List<Parameter> parameters = new ArrayList<>();
}
    :	^(FUNCTION ret_type ID param_list[nSymTable, parameters] {
			/* the function should be declared before any types/vars inside are declared. */
			FunctionEntry pToInsert = new FunctionEntry($ID.text, $ret_type.text, parameters);
			if (SemanticChecks.check_func_declaration_valid($ID.getToken(),pToInsert,symTable,errors)) {
				symTable.insertFunction(pToInsert);

				nSymTable.setFunctionReturnType(pToInsert.getReturnType());
				for (Parameter p: parameters) {
					nSymTable.insertVar(p);
				}
			}
		}  block_list[nSymTable]) {
			TigerType returnType = pToInsert.getReturnType();
			if (!$block_list.guaranteedReturn && returnType != null && !returnType.isVoid()) {
				String errorMsg = String.format(
						"body of non-void function '\%s' not guaranteed to execute a 'return' statement",
						$ID.getText());
				errors.add(new SemanticError($ID.getToken(), errorMsg));
			}
		}
    ;

ret_type returns [String text]
    : VOID {$text = $VOID.text;}
    | ID {$text = $ID.text;}
    | INT {$text = $INT.text;}
    | FIXEDPT {$text = $FIXEDPT.text;}
    ;

main_function[SymbolTable symTable]  //creating a useless scope here for pretty printing main's scopes!
@init {
	SymbolTable nSymTable = new SymbolTable(symTable);
	nSymTable.setFunctionReturnType(TigerType.VOID_TYPE);
}
    : ^(MAINSCOPE block_list[nSymTable])
    ;

/* each parameter will add its info to the "parameters" argument */
param_list[SymbolTable symTable, List<Parameter> parameters]
    : ^(PARAMLIST param[symTable, parameters]*)
    ;

param[SymbolTable symTable, List<Parameter> parameters]
    :   ^(ID type_id) {
            parameters.add( new Parameter($ID.text, $type_id.text) );
        }
    ;

/* guaranteedReturn:  says that this function body will certainly have a return call
 *
 * i.e. at least one of the blocks contains a certain return call
 */
block_list[SymbolTable symTable] returns [boolean guaranteedReturn]
	/* [CB 11/2/14] we know that we are NOT in a loop here, pass false for isInLoop to block */
    :	^(BLOCKLIST (block[symTable,false] {
			/* we just need one block to have guaranteed return (NOTE: everything below is dead code) */
			if ($block.guaranteedReturn) {
				$guaranteedReturn = true;
			}
		})+) 
    ;

block[SymbolTable symTable, boolean isInLoop] returns [boolean guaranteedReturn]
@init {
	SymbolTable nSymTable = new SymbolTable(symTable);
}
    :	^(BLOCKSCOPE type_declaration_list[nSymTable] var_declaration_list[nSymTable] stat_seq[nSymTable,isInLoop]) {
			$guaranteedReturn = $stat_seq.guaranteedReturn;
		}
    ;

type_declaration_list[SymbolTable symTable]
    : ^(TYPEDECLLIST type_declaration[symTable]*)
    ;

var_declaration_list[SymbolTable symTable]
    : ^(VARDECLLIST var_declaration[symTable]*)
    ;

type_declaration[SymbolTable symTable]
    :	^(TYPEDECL ID type) 
		{
			TypeEntry pToInsert = new TypeEntry($ID.text, $type.baseTypeId, $type.dimension1, $type.dimension2);
			if (SemanticChecks.check_type_declaration_valid($ID.getToken(), pToInsert, symTable, errors)) {
				symTable.insertType(pToInsert);
			}
		}
    ;

type returns [String baseTypeId, String dimension1, String dimension2]
    :   base_type {$baseTypeId = $base_type.text;}
    |   ^(ARRAY base_type dim1=INTLIT dim2=INTLIT?) {
            $baseTypeId = $base_type.text;
            $dimension1 = $dim1.text;
            $dimension2 = ($dim2 == null) ? null : $dim2.text;
        }
    ;

base_type returns [String text]
    : INT {$text = $INT.text;}
    | FIXEDPT {$text = $FIXEDPT.text;}
    ;

/* declaring and initializing variables occurs inside id_list rule */
var_declaration[SymbolTable symTable]
@init {
    TigerType optInitType = null;
    boolean hasOptInit = false;
}
    :   ^(VAR type_id (optional_init {
                hasOptInit = true;
                optInitType = $optional_init.type;
            })? id_list[$symTable, $type_id.text, hasOptInit, optInitType])
    ;

type_id returns [String text]
    : base_type {$text = $base_type.text;}
    | ID {$text = $ID.text;}
    ;

id_list[SymbolTable symTable, String typeId, boolean hasOptInit, TigerType optInitType]
    :	^(IDLIST (ID {
			VarEntry pToInsert = new VarEntry($ID.text, typeId);
			if (SemanticChecks.check_var_declaration_valid($ID.getToken(), pToInsert, symTable, errors)) {
				symTable.insertVar(pToInsert);

				TigerType varType = pToInsert.getType();
				if (hasOptInit) {
					if (!varType.isInitializableFrom(optInitType)) {
						errors.add(new SemanticError(
							$ID.getToken(),
							String.format("cannot initialize variable of\%s type '\%s'\%s using type '\%s'",
								varType.isArray() ? " array" : "",
								varType,
								varType.isArray() ? (varType.typeClass == TypeClass.ARRAY_INT ? " of int" : " of fixedpt") : "",
								optInitType)));
					}
				} else {
					/* we are required to initialize arrays!  so if we don't... */
					if (varType.isArray()) {
						errors.add(new SemanticError(
							$ID.getToken(),
							"missing required initialization for array '" + $ID.text + "'"));
					}
				}
			}

        })+)
    ;

optional_init returns [TigerType type]
    :   ^(':=' literal) {
			$type = $literal.type;
        }
    ;

/* guaranteedReturn:  only two possibilities
 *
 *   1) stat_seq has a direct RETURN call
 *   2) stat_seq has an if-else, where both if stat_seq and else stat_seq have guaranteedReturn
 */
stat_seq[SymbolTable symTable, boolean isInLoop] returns [boolean guaranteedReturn]
    :	(stat[symTable, isInLoop] {
			if ($stat.guaranteedReturn) {
				$guaranteedReturn = true;
			}
		})+ 
    ;

/* TODO -- if is a little ... funky.  check if it's okay
 *
 * May want to revert back to IFTHEN and IFTHENELSE synthetic tokens?
 */
stat[SymbolTable symTable, boolean isInLoop] returns [boolean guaranteedReturn]
@init {
	/* only set true by...
     *   1. RETURN
     *   2. An if-else that has both branches with guaranteedReturn
     *   3. blocks are statements -- so if the block statement has a guaranteedReturn
     */
	$guaranteedReturn = false;

	/* for use with IF statement's guaranteed return */
	boolean thenHasGuaranteedReturn = false;
	boolean elseHasGuaranteedReturn = false;
}
    :   function_call[symTable]
    |   assignment[symTable]
    |   ^(IF expr[symTable] ^(THEN_STATS s1=stat_seq[symTable,isInLoop] {
			thenHasGuaranteedReturn = $s1.guaranteedReturn;
		}) (^(ELSE_STATS s2=stat_seq[symTable,isInLoop]) {
			elseHasGuaranteedReturn = $s2.guaranteedReturn;
		})?) {
			$guaranteedReturn = thenHasGuaranteedReturn && elseHasGuaranteedReturn;
		}
    |   ^(WHILE expr[symTable] stat_seq[symTable,true])
    |   ^(FOR ID {
			/* LOGIC COPIED FROM ID in INDEX-EXPR!! */

			/* will log error and return null if var does not exist */
			TigerType varType = VarChecker.getTypeForVar($ID.text, symTable, $ID.getToken(), errors);

			/* var exists, but type is no good for this arithmetic */
			if (varType != null && !varType.isValidInIndexArithmetic()) {
				errors.add(new SemanticError(
					$ID.getToken(),
					String.format("variable '\%s' of type '\%s' not allowed as for-loop counter (must be type 'int')", $ID.text, varType)));
			}
		} index_expr[symTable] index_expr[symTable] stat_seq[symTable,true])
    /*[CB 11/2/14] BREAK statements can only occur in a loop */
    |   BREAK {
            SemanticChecks.check_break($BREAK.getToken(), isInLoop, errors);
        }
    |   ^(RETURN expr[symTable]) {
			/* don't perform return check if expression result has error!
				Also, may not have been successful function declaration --> func return type is null
			 */
			$guaranteedReturn = true;
			if ($expr.type != null && symTable.getFunctionReturnType() != null) {
				SemanticChecks.check_function_return($RETURN.getToken(), $expr.type, $symTable.getFunctionReturnType(), errors);
			}
        }
    |   block[symTable,isInLoop] {
			$guaranteedReturn = $block.guaranteedReturn;
		}
    ;

assignment[SymbolTable symTable]
    :	^(':=' value[symTable]
			(	expr[symTable] {
					if ($expr.type != null
							&& $value.type != null
							&& !$value.type.isAssignableFrom($expr.type)) {
						errors.add(new SemanticError(
							$value.token,
							"cannot assign type '" + $expr.type + "' to type '" + $value.type + "'"));
					}
				}
			|	function_call[symTable] {
					if ($function_call.returnType != null
							&& $value.type != null
							&& !$value.type.isAssignableFrom($function_call.returnType)) {
						String message = ($function_call.returnType.isVoid())
							? "attempting to use result of 'void' function '" + $function_call.funcId + "'"
							: "cannot assign return type '" + $function_call.returnType + "' to type '" + $value.type + "'";
						errors.add(new SemanticError($value.token, message));
					}
				}
			)
		)
    ;

/* First:  check that ID is a function.
 * Second: check that parameters match function signature
 *
 * returns a null type if error has been reported
 */
function_call[SymbolTable symTable] returns [TigerType returnType, String funcId]
@init {
	List<TigerType> paramTypes;
	List<TigerType> argTypes;
	FunctionEntry funcEntry;
	boolean hasArgs = false;
}
    :	^(FUNCTION_CALL ID {
			$funcId = $ID.text;
			/* this call will return std lib func entries! */
			funcEntry = FunctionChecker.getFunctionEntry($ID.getToken(), symTable, errors);
		} (args=function_args[symTable] {
			hasArgs = true;
		})?) {
			if (funcEntry == null) {
				$returnType = null;
			} else {
				paramTypes = FunctionChecker.extractParameterTypes(funcEntry.parameters, symTable);

				argTypes = hasArgs ? $args.argTypes : new ArrayList<TigerType>();
				if ($args.invalidArgs) {
					$returnType = null;
				} else if (FunctionChecker.checkArgTypes(argTypes, paramTypes, $ID.getToken(), errors)) {
					$returnType = funcEntry.getReturnType();
				} else {
					$returnType = null;
				}
			}
		}
    ;

/* Returns a list of TigerTypes of arguments and an ignore flag if expr was invalid */
function_args[SymbolTable symTable] returns [List<TigerType> argTypes, boolean invalidArgs]
@init {
	$argTypes = new ArrayList<>();
}
    :	^(EXPRLIST (expr[symTable] {
			if ($expr.type == null) {
				$invalidArgs = true;
			}
			$argTypes.add($expr.type);
		})+) 
    ;


/* NOTE: expr in tree grammar is quite different than parser's rule!
 *
 * Our expression AST subtrees are already set up to give the proper evaluation
 * through post-order traversal!
 *
 * So, tree walker doesn't care about operator precedence
 */
expr[SymbolTable symTable] returns [TigerType type, Token token]
    /* Logical operators:  & | */
    :   ^(logical_op e1=expr[symTable] e2=expr[symTable]) {
			/* we set an error before returning null -- the error has been captured, so just propogate it up */
			if ($e1.type == null || $e2.type == null) {
				/* before propogating -- check if the other side has an error */
				if ($e1.type != null && !$e1.type.isValidInLogical()) {
					errors.add(new SemanticError($e1.token, "cannot use type '" + $e1.type + "' with logical operator"));
				} else if ($e2.type != null && !$e2.type.isValidInLogical()) {
					errors.add(new SemanticError($e2.token, "cannot use type '" + $e2.type + "' with logical operator"));
				} 
				$token = $e1.type == null ? $e1.token : $e2.token;
				$type = null;  /* propogate signal that error has been captured */
			} else if ($e1.type != null && !$e1.type.isValidInLogical()) {
				errors.add(new SemanticError($e1.token, "cannot use type '" + $e1.type + "' with logical operator"));
				/* check if other side has an error */
				if ($e2.type != null && !$e2.type.isValidInLogical()) {
					errors.add(new SemanticError($e2.token, "cannot use type '" + $e2.type + "' with logical operator"));
				}
				$token = $e1.token;
				$type = null;
			} else if ($e2.type != null && !$e2.type.isValidInLogical()) {
				errors.add(new SemanticError($e2.token, "cannot use type '" + $e2.type + "' with logical operator"));
				$token = $e2.token;
				$type = null;
			} else {
				$token = $e1.token;
				$type = TypeChecker.getTypeAfterLogical($e1.type, $e2.type);
				if ($type == null) {
					errors.add(new SemanticError($e1.token, "cannot mix '" + $e1.type + "' with '" + $e2.type + "' in logical"));
				}
			}
        }

    /* Comparison operators:  < <= > >= = <> */
    |   ^(comparison_op e1=expr[symTable] e2=expr[symTable]) {
			/* we set an error before returning null -- the error has been captured, so just propogate it up */
			if ($e1.type == null || $e2.type == null) {
				/* check if the other side has an error, too before propogating */
				if ($e1.type != null && !$e1.type.isValidInComparison()) {
					errors.add(new SemanticError($e1.token, "cannot use type '" + $e1.type + "' in comparison"));
				} else if ($e2.type != null && !$e2.type.isValidInComparison()) {
					errors.add(new SemanticError($e2.token, "cannot use type '" + $e2.type + "' in comparison"));
				}
				$token = $e1.type == null ? $e1.token : $e2.token;
				$type = null;  /* propogate signal that error has been captured */
			} else if ($e1.type != null && !$e1.type.isValidInComparison()) {
				errors.add(new SemanticError($e1.token, "cannot use type '" + $e1.type + "' in comparison"));
				/* check if other side has an error before propogating */
				if ($e2.type != null && !$e2.type.isValidInComparison()) {
					errors.add(new SemanticError($e2.token, "cannot use type '" + $e2.type + "' in comparison"));
				}
				$token = $e1.token;
				$type = null;
			} else if ($e2.type != null && !$e2.type.isValidInComparison()) {
				errors.add(new SemanticError($e2.token, "cannot use type '" + $e2.type + "' in comparison"));
				$token = $e2.token;
				$type = null;
			} else {
				$token = $e1.token;
				$type = TypeChecker.getTypeAfterComparison($e1.type, $e2.type);
				if ($type == null) {
					errors.add(new SemanticError($e1.token, "cannot mix '" + $e1.type + "' with '" + $e2.type + "' in comparison"));
				}
			}
        }

    /* Arithmetic operators: * / + - */
    |   ^(arithmetic_op e1=expr[symTable] e2=expr[symTable]) {
			/* we set an error before returning null -- the error has been captured, so just propogate it up */
			if ($e1.type == null || $e2.type == null) {
				/* before propogating, check if other side is invalid operand */
				if ($e1.type != null && !$e1.type.isValidInArithmetic()) {
					errors.add(new SemanticError($e1.token, "cannot use type '" + $e1.type + "' in arithmetic"));
				} else if ($e2.type != null && !$e2.type.isValidInArithmetic()) {
					errors.add(new SemanticError($e2.token, "cannot use type '" + $e2.type + "' in arithmetic"));
				}
				$token = $e1.type == null ? $e1.token : $e2.token;
				$type = null;  /* propogate signal that error has been captured */
			} else if ($e1.type != null && !$e1.type.isValidInArithmetic()) {
				errors.add(new SemanticError($e1.token, "cannot use type '" + $e1.type + "' in arithmetic"));
				/* before propogating, check if other side is invalid operand */
				if ($e2.type != null && !$e2.type.isValidInArithmetic()) {
					errors.add(new SemanticError($e2.token, "cannot use type '" + $e2.type + "' in arithmetic"));
				}
				$token = $e1.token;
				$type = null;
			} else if ($e2.type != null && !$e2.type.isValidInArithmetic()) {
				errors.add(new SemanticError($e2.token, "cannot use type '" + $e2.type + "' in arithmetic"));
				$token = $e2.token;
				$type = null;
			} else {
				$token = $e1.token;
				$type = TypeChecker.getTypeAfterArithmetic($e1.type, $e2.type);
				if ($type == null) {
					errors.add(new SemanticError($e1.token, "cannot mix '" + $e1.type + "' with '" + $e2.type + "' in arithmetic"));
				}
			}
        }

    |	value[symTable] {
			$type = $value.type;
			$token = $value.token;
		}
    |	literal {
			$type = $literal.type;
			$token = $literal.token;
		}
    ;

logical_op: '&' | '|' ;
comparison_op: '<' | '<=' | '>' | '>=' | '=' | '<>' ;
arithmetic_op: '+' | '-' | '*' | '/' ;

/* index count is number of indexes in valueTail */
value[SymbolTable symTable] returns [TigerType type, Token token]
    :   ^(ID indexCount=value_tail[symTable]?) {
			String indexErrorMessage;
			$token = $ID.getToken();
			$type = VarChecker.getTypeForVar($ID.text, symTable, $token, errors);

			/* check if we will get an index error */
			if ($type != null && !$type.isValidIndexCount(indexCount)) {
				if ($type.isArray1D()) {
					indexErrorMessage = "attempting to index one-dimensional array '" + $ID.text + "' with 2 levels of indexing";
				} else if ($type.isArray2D()) {
					indexErrorMessage = "partial indexing of two-dimensional array '" + $ID.text + "' is not allowed";
				} else {
					indexErrorMessage = "attempting to index variable '" + $ID.text + "' that is not an array type";
				}
				$type = null;  /* set to null to indicate logged error to "calling" rule */
				errors.add(new SemanticError($token, indexErrorMessage));
			} else if ($type != null) {
				$type = $type.getTypeAfterIndex(indexCount);
			}
        }
    ;

literal returns [TigerType type, Token token]
    :   INTLIT {
			$type = TigerType.LITERAL_INT_TYPE;
			$token = $INTLIT.getToken();
        }
    |   FIXEDPTLIT {
			$type = TigerType.LITERAL_FIXEDPT_TYPE;
			$token = $FIXEDPTLIT.getToken();
        }
    ;

/* index count is number of indexes in valueTail */
value_tail[SymbolTable symTable] returns [int indexCount]
    : (index_expr[symTable] {$indexCount = 1;}) (index_expr[symTable] {$indexCount = 2;})?
    ;

index_expr[SymbolTable symTable] returns [TigerType type, Token token]
    :	^(index_expr_op e1=index_expr[symTable] e2=index_expr[symTable]) {
			if ($e1.type == null || $e2.type == null) {
				/* propogate error up */
				$type = null;
				$token = ($e1.type == null) ? $e1.token : $e2.token;
			} else if (!$e1.type.isValidInIndexArithmetic() || !$e2.type.isValidInIndexArithmetic()) {
				/* this code may not be called b/c ID will capture the same exact errors first */

				/* print errors for both if both are invalid */
				String errorFormat = "values of type '\%s' not allowed in index expression (only type 'int' is accepted)";
				if (!$e2.type.isValidInIndexArithmetic()) {
					errors.add(new SemanticError($e2.token, String.format(errorFormat, $e2.type)));
					$token = $e2.token;
				}
				if (!$e1.type.isValidInIndexArithmetic()) {
					errors.add(new SemanticError($e1.token, String.format(errorFormat, $e1.type)));
					$token = $e1.token;
				}
				$type = null; /* indicate error was logged */
			} else {
				$type = TypeChecker.getTypeAfterArithmetic($e1.type, $e2.type);
				$token = $e1.token;
			}
		}
    |	INTLIT {
			$type = TigerType.LITERAL_INT_TYPE;
			$token = $INTLIT.getToken();
		}
    |	ID {
			/* THIS LOGIC IS COPIED IN FOR STATEMENT!!! */ 

			/* will log error and return null if var does not exist */
			$type = VarChecker.getTypeForVar($ID.text, symTable, $ID.getToken(), errors);
			$token = $ID.getToken();

			/* var exists, but type is no good for this arithmetic */
			if ($type != null && !$type.isValidInIndexArithmetic()) {
				errors.add(
					new SemanticError($ID.getToken(),
					"values of type " + $type + " are not allowed in index expression (only type 'int' is accepted)"));
				$type = null;
			}
		}
    ;

index_expr_op: '+' | '-' | '*' ;
