//
//  Arith.java
//  4240
//
//  Created by Sung Hye Jeon on 11/3/14.
//  Copyright (c) 2014 Sung Hye Jeon. All rights reserved.
//

public class Arith extends Op {
	public Expr expr1, expr2;
	public Arith(String op, Expr x1, Expr x2) {
		super(op, null); expr1 = x1; expr2 = x2;
		type = Type.max(expr1.type, expr2.type);
		if (type == null) error("type error");
	}
	
	public Expr gen() { 
		return new Arith(s, expr1.reduce(), expr2.reduce()); 
		}
	
	public String toString() {
	return expr1.toString() + " " + s + " " + expr2.toString();
	}
}
