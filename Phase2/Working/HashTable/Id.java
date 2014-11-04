//
//  Id.java
//  4240
//
//  Created by Sung Hye Jeon on 11/3/14.
//  Copyright (c) 2014 Sung Hye Jeon. All rights reserved.
//


public class Id extends Expr {

	public int offset;
	public Id(String id, Type p, int b) { 
		super(id,p); offset = b; 
		}

}
