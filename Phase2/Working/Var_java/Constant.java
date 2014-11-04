
public class Constant extends Expr {
	public Constant(String tok, Type p) { 
		super(tok,p);
		}
	
	public Constant(int i) { 
		super("" + i, Type.Int); 
		}
	
	public static final Constant
	
	True = new Constant("true", Type.Bool),
	False = new Constant("false", Type.Bool);
	
	public void jumping(int t, int f) {
		if (this == True && t != 0) emit("goto L" + t);
		else if (this == False && f != 0) emit("goto L" + f);
	}


}
