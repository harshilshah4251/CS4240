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
	if (!typeCheckPassed(expr1, expr2))
	    error("type error with : " + expr1.type.name + " | "+ expr2.type.name+"\n");
    }

	//public Arith(String op, 

	public static Expr getFinalType(Expr e1, Expr e2) {
	    if(isUserType(e1.type)) {
			return new Expr("UserType", new UserType(e1.type.name, e1.type));
		} else if(e1.type.name.equals("int")
			&& e2.type.name.equals("int")) {
				return new Expr("int", Type.Int);
		} else {
			return new Expr("float", Type.Float);
		}
		//This should not happen
		//System.out.println("Wrong Final Type!\n");
		//return null;
	}
    
    public static boolean typeCheckPassed(Expr e1, Expr e2) {
	System.out.println("entered typeCheckPassed");
	boolean isLegal = false;
	if(e1 == null || e2 == null) {
		System.out.println("null input in typeCheckPassed!");
	} else {
	    System.out.println("Else?");
	if (Type.numeric(e1.type) && Type.numeric(e2.type)) {
	    isLegal = true;
	    System.out.println("both are numeric");
	}
	/*
	else if ((e1.type instanceof UserType) || (e2.type instanceof UserType)) {
	    System.out.println("both types are user types");
	    if(((UserType)e1.type).userTypeName.equals(((UserType)e2.type).userTypeName)) {
		isLegal = true;
	    }
	}
	*/
	else if (isUserType(e1.type) && isUserType(e2.type)) {
	    System.out.println("both types are user types");
	    if(e1.type.name.equals(e2.type.name)) {
		isLegal = true;
	    }
	}

	}
	
	return isLegal;
    }

    public static boolean isUserType(Type t) {
	boolean isUserType = false;
	if (!t.name.equals("int") && !t.name.equals("fixedpt")) {
	    isUserType = true;
	}
	return isUserType;
    }
    
    public Expr gen() { 
        return new Arith(s, expr1.reduce(), expr2.reduce()); 
    }
    
    public String toString() {
        return expr1.toString() + " " + s + " " + expr2.toString();
    }
}
