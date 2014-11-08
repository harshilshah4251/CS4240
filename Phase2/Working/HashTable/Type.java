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
	// true if initialized, false otherwise
	//public boolean init;
	
	public Type(String s, int w){
		name = s;
		size = w;
//		init = false;
	}

    public Type(String name) {
	this.name = name;
    }
	
	public static final Type	
		Int = new Type("int", 4), 
		Float = new Type("float", 8), //fixedptlit
		Char = new Type("char", 1), 
		Void = new Type("void", 0),
		Bool = new Type("bool", 1),

		// Don't add String to Symbol table
		// Just check if the assignment String := String is correct
		string = new Type("string", 0);

	
	public static boolean numeric (Type p){
		return  (p == Type.Char) || (p == Type.Int) || (p == Type.Float);
	}
	
	public static Type max(Type p1, Type p2) {
		if (!numeric(p1) || !numeric(p2)) return null;
		else if (p1 == Type.Float || p2 == Type.Float) return Type.Float;
		else if (p1 == Type.Int || p2 == Type.Int) return Type.Int;
		else return Type.Char;
	}
	
	// Set the Variable is initialized
	public static void initialize(Type p1) {
//		p1.init = true;
	}

	public String toString() {
		return "type : " + name + ", size : " + size;
	}
	
}
