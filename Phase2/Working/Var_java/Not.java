
public class Not extends Logical {
	public Not(Expr x2) { super("!", x2, x2); }
	public void jumping(int t, int f) { expr2.jumping(f, t); }
	public String toString() { return s + " " + expr2.toString(); }

}
