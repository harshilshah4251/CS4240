//
//  IndexExpression.java
//  4240
//
//  Created by Sung Hye Jeon on 11/3/14.
//  Copyright (c) 2014 Sung Hye Jeon. All rights reserved.
//


public class IndexExpression extends Op {
	public Id array;
	public Expr index;
	public IndexExpression(Id a, Expr i, Type p) { 
		super("[]", p); array = a; index = i; 
		}
	
	public Expr gen() { 
		return new IndexExpression(array, index.reduce(), type); 
		}
	
	public void jumping(int t, int f) { 
		emitjumps(reduce().toString(), t, f); 
		}
	
	public String toString() {
	return array.toString() + " [ " + index.toString() + " ]";
	
	}

}
