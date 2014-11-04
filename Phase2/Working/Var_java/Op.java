
public class Op extends BinaryOp {
	public Op(String tok, Type p) { super(tok,p); }
	public Expr reduce() {
		Expr x = gen();
		Temp t = new Temp(type);
		emit(t.toString() + " = " + x.toString());
		return t;
	}

}
