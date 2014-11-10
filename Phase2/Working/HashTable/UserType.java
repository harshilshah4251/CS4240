

public class UserType extends Type {
	public Type of;
	public String userTypeName;

	// Should check here agin
	// Should check here agin
	public UserType(String s) {
		super(s);
		/*if(s.equals("int")) {
			size = 4;
		}*/
	}
	
	public UserType(String n, Type p) {
		super(p.name,p.size);
		userTypeName = n;
		of = p;
	}
	/*public UserType(String n, String s, Type p) {
		super(s, p.size);
		userTypeName = n;
	}*/

	public UserType(String s, int w, Type p) {
	// check size again
		super(s, w*p.size);

	// Check size Again
		size = w;
		of = p;
	}

	public String toString() {
		if(of != null){
		return "UserType/ Name: " + name + " TotalSize : "+ size + 
			" BaseType : " + of + "\n";
		//", size: " + size +"\n";
		}else {
			return "null\n";
		}
	}
}
