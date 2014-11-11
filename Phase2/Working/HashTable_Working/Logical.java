//
//  Logical.java
//  4240
//
//  Created by Sung Hye Jeon on 11/3/14.
//  Copyright (c) 2014 Sung Hye Jeon. All rights reserved.
//


public class Logical extends BinaryOp {
    public Expr expr1, expr2;
    
    public Logical(String tok, Expr expr1, Expr expr2) {
        super(tok, null); 
	this.expr1 = expr1; 
	this.expr2 = expr2;

	if (!typeCheckPassed(expr1, expr2) {
		error("Type error with: " + expr1.type.name + " | " + expr2.type.name + "\n");
	    }
	}
    }

    public static boolean typeCheckPassed(Expr e1, Expr e2) {
	boolean isLegal = false;

	if(e1 == null || e2 == null) {
	    System.out.println("ILLEGAL: Can't have null input in typeCheckPassed!");
	} 
	else {
	    // should only pass if both operands are boolean
	    if (e1.type == Type.Bool && e2.type == Type.Bool) {
		isLegal = true;
	    }
	}

	return isLegal;
    }

    
    public Type check(Type p1, Type p2) {
        if ( p1 == Type.Bool && p2 == Type.Bool ) return Type.Bool;
        else return null;
    }
    
    public Expr gen() {
        int f = newlabel();
        int a = newlabel();
        Temp temp = new Temp(type);
        this.jumping(0, f);
        emit(temp.toString() + " = true");
        emit("goto L" + a);
        emitlabel(f);
        emit(temp.toString() + " = false");
        emitlabel(a);
        return temp;
    }
    
    public String toString(){
        return expr1.toString() + " " + s + " " + expr2.toString();
    }

}
