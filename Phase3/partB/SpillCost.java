
public class SpillCost {

	public String name;
	public int used;
	public int def;
	public double spillCost;

	public SpillCost() {
		name = "";
		used = 0;
		def = 0;
	}
	
	public SpillCost(String s) {
		name = s;
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

	public void updateSpill() {
		spillCost = used + def;
	}

	public boolean equals(Object obj) {
		if((obj instanceof SpillCost) && this.name.equals(((SpillCost)obj).name)) {
			return true;
		} else {
			return false;
		}
	}

}
