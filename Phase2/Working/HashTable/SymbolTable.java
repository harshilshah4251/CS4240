
import java.util.*;

public class SymbolTable {
	private Hashtable<String, Var> table;
	public int level;

	// Not sure what's this for
	protected SymbolTable outer;

	public SymbolTable(int l) {
		table = new Hashtable();
		outer = null;
		level = l;
	}

	// Not sure if we are going to sue this constructor
	public SymbolTable(SymbolTable st) {
		table = new Hashtable();
		outer = st;
	}

	public void put(String token, Type t, int b) {
		table.put(token, new Id(token, t, b));
	}

	public void put(String token, Var i) {
		table.put(token, i);
	}

	public void keySet() {
		System.out.println(table.keySet());
	}

	public int size() {
		return table.size();
	}

	public Var get(String name) {
		return table.get(name);
	}
	public boolean containsKey(String name) {
		return table.containsKey(name);
	}

	// Search if given token with the name is in the symbol tables
	// We might not use this since we are implementing stack in TigerTree.g
/*
	public Id get(String token) {
		for (SymbolTable tab = this; tab != null; tab = tab.outer) {
			Id id = (Id)(tab.table.get(token));
			if(id != null) return id;
		}

		return null;
	}
*/

	public String toString() {
		return "level : " + level + "\n" + table.toString();
	}
}
