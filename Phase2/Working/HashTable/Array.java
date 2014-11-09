//
//  Type.java
//  4240
//
//  Created by Sung Hye Jeon on 11/3/14.
//  Copyright (c) 2014 Sung Hye Jeon. All rights reserved.
//

public class Array extends Type {
	public Type of;
	public int size; 
	
	public Array(String s, int w, Type p) {	//s is name, w is size and p is type 
		super(s, w* p.size);
		size = w;
		of = p;		
	}

	public String toString(){
		return "[" + size + "] " + of.toString();
	}
}
