public class IfElse extends Stat {
	Expr expr;
	Stat stat1, stat2;
	public Else(Expr x, Stat s1, Stat s2) {
		expr = x;
		stat1 = s1;
		stat2 = s2;
		if (expr.type != Type.Bool) expr.error("boolean required in if");
		// public void gen();
}
