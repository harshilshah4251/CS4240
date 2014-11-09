//
//  Expr.java
//  4240
//
//  Created by Sung Hye Jeon on 11/3/14.
//  Copyright (c) 2014 Sung Hye Jeon. All rights reserved.
//

public class Expr extends Var {
	public String s;
	public Type type;
	
	Expr(String tok, Type p){ 
		s = tok; type = p; 
		}
	
	public Expr gen() { 
		return this; 
		}
	
	public Expr reduce() { 
		return this; 
	}

	public String getName() {
		return s;
	}

	public Type getType() {
		return type;
	}
	
	public void jumping(int t, int f) { 
		emitjumps(toString(), t, f); 
		}
	
	public void emitjumps(String test, int t, int f) {
		if (t != 0 && f != 0) {
			emit("if " + test + " goto L" + t);
			emit("goto L" + f);
		} else if (t != 0) emit("if " + test + " goto L" + t);
		else if (f != 0) emit("iffalse " + test + " goto L" + f);
	}
	
	public String toString() { return s; }

}
