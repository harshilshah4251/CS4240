
public class And extends Logical {
	public And(Expr x1, Expr x2) { super("&&", x1, x2); }
	public void jumping(int t, int f) {
		int label = f != 0 ? f : newlabel();
		expr1.jumping(0, label);
		expr2.jumping(t, f);
		
		if (f == 0) emitlabel(label);
	}
}
