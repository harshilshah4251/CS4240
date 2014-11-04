// Set class handles assignment statements
// compare Id and Expr types

// Ex)
// Array := Array (X)
// int := int | fixedpt := fixedpt (O)
// Boolean := Boolean (X)

public Class Set extends Stat {
	public Id lvalue;
	public Expr expr;
	public Set(Id i, Expr x) {
		lvalue = i;
		expr = x;
		if (check(lvalue.type, expr.type) == null) error ("type error");
	}

	public Type check(Type p1, Type p2) {
		if (p1 instanceof Array || p2 instanceof Array) return null;
// have to check again
		if (p1 == p2) return p2;
		if(Type.numeric(p1) && Type.numeric(p2)) return p2;
		else if (p1 == Type.Bool && p2 == Type.Bool) return null;
			// In our grammar, Boolean assignment cannot happen
		else return null;
	}
	//public void gen
}
