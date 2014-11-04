//
//  Not.java
//  4240
//
//  Created by Sung Hye Jeon on 11/3/14.
//  Copyright (c) 2014 Sung Hye Jeon. All rights reserved.
//

public class Not extends Logical {
	public Not(Expr x2) { super("!", x2, x2); }
	public void jumping(int t, int f) { expr2.jumping(f, t); }
	public String toString() { return s + " " + expr2.toString(); }

}
