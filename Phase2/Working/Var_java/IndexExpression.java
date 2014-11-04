
public class IndexExpression extends Op {
	public Id array;
	public Expr index;
	public IndexExpression(Id a, Expr i, Type p) { 
		super("[]", p); array = a; index = i; 
		}
	
	public Expr gen() { 
		return new IndexExpression(array, index.reduce(), type); 
		}
	
	public void jumping(int t, int f) { 
		emitjumps(reduce().toString(), t, f); 
		}
	
	public String toString() {
	return array.toString() + " [ " + index.toString() + " ]";
	
	}

}
