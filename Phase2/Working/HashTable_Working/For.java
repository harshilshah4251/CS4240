// Check if first condition is assignment
// And check if second condition is INT

public class For extends Stat {

	Expr expr;
	Stat stat;

	public For(Stat s, Expr x) {
		stat = s;
		expr = x;
		if((!(s instanceof Set)) || (expr.type != Type.Int)) expr.error("For block condition error");

	}
}
