//
//  Constant.java
//  4240
//
//  Created by Sung Hye Jeon on 11/3/14.
//  Copyright (c) 2014 Sung Hye Jeon. All rights reserved.
//

public class Constant extends Expr {
	public Constant(String tok, Type p) { 
		super(tok,p);
		}
	
	public Constant(int i) { 
		super("" + i, Type.Int); 
		}
	
	public static final Constant
	
	True = new Constant("true", Type.Bool),
	False = new Constant("false", Type.Bool);
	
	public void jumping(int t, int f) {
		if (this == True && t != 0) emit("goto L" + t);
		else if (this == False && f != 0) emit("goto L" + f);
	}


}
