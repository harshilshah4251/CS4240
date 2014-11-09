

public class UserType extends Type {
	public Type of;

	// Should check here agin
	// Should check here agin
	public UserType(String s) {
		super(s,0);
	}
	
	public UserType(String s, Type p) {
		super(s,p.size);
		of = p;
	}

	public UserType(String s, int w, Type p) {
	// check size again
		super(s, w*p.size);

	// Check size Again
		size = w;
		of = p;
	}

	public String toString() {
		if(of != null)
		return "UserType / " +  of.toString() + "\n";
		else return "null\n";
	}
}
