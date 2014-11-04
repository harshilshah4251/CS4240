// Set class handles assignment statements
// compare Id and Expr types
// It should check the Id's type and the Function's return value

// Ex)
// Array := Array (X)
// int := int | fixedpt := fixedpt (O)
// Boolean := Boolean (X)

public class Set extends Stat {
	public Id lvalue;
	public Expr expr;
	public Function func;
	public Set(Id i, Expr x) {
		lvalue = i;
		expr = x;
		if (check(lvalue.type, expr.type) == null) error ("Assign error");
	}
	
	// Construction when there's Function assignment
	public Set(Id i, Function f) {
		lvalue = i;
		func = f;
		if (check(lvalue.type, func) == null) error ("Assign error");
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
	
	public Type check(Type p1, Function f1) {
		if(p1 != f1.funcReturn()) return null;
		else return p1;
		// Have to check how many parameters does he has
	}

	//public void gen
}
