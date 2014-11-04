//
//  Temp.java
//  4240
//
//  Created by Sung Hye Jeon on 11/3/14.
//  Copyright (c) 2014 Sung Hye Jeon. All rights reserved.
//

public class Temp extends Expr {
	static int count = 0;
	int number;
	public Temp(Type p) { 
		super("t", p); 
		number = ++count; 
		}
	
	public String toString() { 
		return "t" + number; 
		}


}
