public class While extends Stat {
	Expr expr;
	Stat stat;
	public While() { expr = null; stat = null;}
	public void init(Expr x, Stat s) {
		expr = x;
		stat = s;
		if(expr.type != Type.Bool) expr.error("boolean required in while");
	}
		// public void gen();
}
	
