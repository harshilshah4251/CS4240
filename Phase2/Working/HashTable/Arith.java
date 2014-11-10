//
//  Arith.java
//  4240
//
//  Created by Sung Hye Jeon on 11/3/14.
//  Copyright (c) 2014 Sung Hye Jeon. All rights reserved.
//

public class Arith extends Op {

    public Expr expr1, expr2;

    public Arith(String op, Expr expr1, Expr expr2) {
        super(op, null); 
	this.expr1 = expr1; 
	this.expr2 = expr2;
	/*
        type = Type.max(expr1.type, expr2.type);
        if (type == null) 
        error("type error");
	*/
	if (!typeCheckPassed(expr1.type, expr2.type))
	    error("type error");
    }
    
    public boolean typeCheckPassed(Type t1, Type t2) {
	boolean isLegal = false;

	if (Type.numeric(t1) && Type.numeric(t2)) {
	    isLegal = true;
	}

	else if ((t1 instanceof UserType) && (t2 instanceof UserType)) {
	    if(((UserType)t1).userTypeName.equals(((UserType)t2).userTypeName)) {
		isLegal = true;
	    }
	}

	return isLegal;
    }
    
    public Expr gen() { 
        return new Arith(s, expr1.reduce(), expr2.reduce()); 
    }
    
    public String toString() {
        return expr1.toString() + " " + s + " " + expr2.toString();
    }
}
