//
//  Type.java
//  4240
//
//  Created by Sung Hye Jeon on 11/3/14.
//  Copyright (c) 2014 Sung Hye Jeon. All rights reserved.
//

public class TwoDArray extends Type{

	public Type of;
	public int size = 1; 
	public int row = 1;
	public int column = 1;
	
//s is name, w is size and p is type 
	public TwoDArray(String s, int r, int c,  Type p) {	
		super(s, c*r*p.size);
		size = r*c;
		of = p;		
		this.row = r;
		this.column = c; 
	}

	public String toString(){
		return "[" + row + "] " + "[" + column+"]" + of.toString();
	}
}
