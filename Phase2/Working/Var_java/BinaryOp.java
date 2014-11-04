
public class BinaryOp extends Expr {
	public BinaryOp(String tok, Type p) { 
		super(tok,p); 
		}
	
	public Expr reduce() {
		Expr x = gen();
		Temp t = new Temp(type);
		emit(t.toString() + " = " + x.toString());
		return t;
	}
}
