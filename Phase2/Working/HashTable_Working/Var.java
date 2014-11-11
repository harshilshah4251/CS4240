public class Var {
	public String error(String s) {
		return s;
	
	}
	
	static int labels = 0;
	public static int newlabel() {return ++labels;}
	public static void emitlabel(int i) {
		System.out.println("L" + i + ";");
	}
	public static void emit(String s) {
		System.out.println("\t" + s);
	}
}
