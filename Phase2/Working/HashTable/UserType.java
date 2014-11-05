

public class UserType extends Type {
	public Type of;

	// Should check here agin
	public int size 1;

	public UserType(String s, int w, Type p) {
	// check size again
		super(s, w*p.size);

	// Check size Again
		size = w;
		of = p;
	}

	public String toString() {
		return "UserType / " + of.toString();
	}
}
