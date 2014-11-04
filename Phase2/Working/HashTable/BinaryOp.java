//
//  BinaryOp.java
//  4240
//
//  Created by Sung Hye Jeon on 11/3/14.
//  Copyright (c) 2014 Sung Hye Jeon. All rights reserved.
//

public class BinaryOp extends Expr {
	public BinaryOp(String tok, Type p) { 
		super(tok,p); 
		}
	
	public Expr reduce() {
		Expr x = gen();
		Temp t = new Temp(type);
		emit(t.toString() + " = " + x.toString());
		return t;
	}
}
