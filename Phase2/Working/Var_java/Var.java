public class Var {
	void error(String s) {throw new Errors(s); }
	static int labels = 0;
	public static int newlabel() {return ++labels;}
	public static void emitlabel(int i) {
		System.out.println("L" + i + ";");
	}
	public static void emi(String s) {
		System.out.println("\t" + s);
	}
}
