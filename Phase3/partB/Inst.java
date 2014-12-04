import java.util.ArrayList;

public class Inst{
	public ArrayList<String> used;
	public String def;
	public boolean isEmpty;


	public Inst() {
		used = new ArrayList<String>();
		def = "";
		isEmpty = true;
	}


	public void addUsed(String s) {
		used.add(s);
		isEmpty = false;
	}

	public void addDef(String s) {
		def = s;
		isEmpty = false;
	}

	public boolean isEmpty() {
		return isEmpty;
	}

	public ArrayList<String> getUsed() {
		return used;
	}

	public String getDef() {
		return def;
	}

	public String toString() {
		String s = "used : " + used + " def: " + def;
		return s;
	}


}
