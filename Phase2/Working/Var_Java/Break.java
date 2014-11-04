public class Break extends Stat {
	Stat stat;
	public Break() {
		if (stat.Enclosing == null) error("Unenclosed break");
		stat = Stat.Enclosing;
	}

	// public void gen()
}
