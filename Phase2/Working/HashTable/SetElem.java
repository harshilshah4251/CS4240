// SetElem handles assignment to array elements
// It needs to be modified

public class SetElem extends Stat {
	public Id array;
	public Expr index;
	public Expr expr;	
	public SetElem(Access x, Expr y) {
		array = x.array;
		index = x.index;
		expr = y;
		if (check(x.type, expr.type) == null) error("Array type error");
	}

	public Type check(Type p1, Type p2) {
		if (p1 instanceof Array || p2 instanceof Array) return null;
		else if (p1 == p2) return p2;
		else if (Type.numeric(p1) && Type.numeric(p2)) return p2;
		else return null;
	}

	//public void gen

}
