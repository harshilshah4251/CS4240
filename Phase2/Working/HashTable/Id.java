//
//  Id.java
//  4240
//
//  Created by Sung Hye Jeon on 11/3/14.
//  Copyright (c) 2014 Sung Hye Jeon. All rights reserved.
//


public class Id extends Expr {

	public int offset;
	public boolean init;
	// not sure what's offset is for

	public Id(String id, Type p, int b) { 
		super(id,p); offset = b; 
		}

	public Id(String id, Type p, boolean i) {
		super(id,p);
		init = i;
	}
	public Id(String id, Type p) {
		super(id,p);
		init = false;
	}

	public void initId() {
		init = true;
	}

	public String toString() {
		return (" ID/name : " + s + ", " +  type + ", init: " + init+"\n");
	}

}
