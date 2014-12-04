
public class Var{
	public String name;
	public int used;
	public int def;
	public int spill_cost;


	public Var() {
		name = "Var not init";
		used = 0;
		def = 0;
		spill_cost = 0;
	}

	public Var(String n) {
		name = n;
		used = 0;
		def = 0;
		spill_cost = 0;
	}

	public void setName(String s) {
		name = s;
	}

	public void increaseUsed() {
		used++;
	}

	public void increaseDef() {
		def++;
	}

	public int getSpill() {
		spill_cost = used + def;
		return spill_cost;
	}

	public void updateSpill() {
		spill_cost = used + def;
	}

	public boolean equals(Object obj) {
		if(obj instanceof Var && this.name.equals(((Var)obj).name)) {
			return true;
		} else {
			return false;
		}
	}

	public String toString() {
		String s = "Var: " + name + " def: " + def + " used: " + used + "\n";
		return s;
	}
}




