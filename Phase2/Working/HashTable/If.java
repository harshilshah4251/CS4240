public class If extends Stat {
	Expr expr;
	Stat stat;
	public If(Expr x, Stat s) {
		expr = x;
		stat = s;
		if(expr.type != Type.Bool) expr.error("boolean reuiqred in if");
	}

	//public gen();
}
