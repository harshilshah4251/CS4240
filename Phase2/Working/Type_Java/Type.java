//
//  Type.java
//  4240
//
//  Created by Sung Hye Jeon on 11/3/14.
//  Copyright (c) 2014 Sung Hye Jeon. All rights reserved.
//

public class Type {
	public int size =0;
	public String name = "";
	
	public Type(String s, int w){
		name = s;
		size = w;
	}
	
	public static final Type	
		Int = new Type("int", 4), 
		Float = new Type("float", 8), //fixedptlit
		Char = new Type("char", 1); 
	
	public static boolean numberic (Type p){
		return  (p == Type.Char) || (p == Type.Int) || (p == Type.Float);
	}
	
	
}
