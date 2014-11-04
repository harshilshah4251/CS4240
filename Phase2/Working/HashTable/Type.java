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
		Char = new Type("char", 1), 
<<<<<<< HEAD
		Void = new Type("void", 0),
		Bool = new Type("bool", 0);
=======
		Bool = new Type("bool", 1);
>>>>>>> 0b97a00ffeaf593ee8f538ef7cee8a4018e69399
	
	public static boolean numeric (Type p){
		return  (p == Type.Char) || (p == Type.Int) || (p == Type.Float);
	}
	
	public static Type max(Type p1, Type p2) {
		if (!numeric(p1) || !numeric(p2)) return null;
		else if (p1 == Type.Float || p2 == Type.Float) return Type.Float;
		else if (p1 == Type.Int || p2 == Type.Int) return Type.Int;
		else return Type.Char;
	}
	
}
