
import java.util.*;

public class SymbolTable {
	private Hashtable<String, Var> table();

	// Not sure what's this for
	protected SymbolTable outer;

	public SymbolTable() {
		table = new Hashtable();
		outer = null;
	}

	// Not sure if we are going to sue this constructor
	public SymbolTable(SymbolTable st) {
		table = new Hashtable();
		outer = st;
	}

	public void put(String token, Type t, int b) {
		table.put(token, new Id(token, t, b));
	}

	// Search if given token with the name is in the symbol tables
	// We might not use this since we are implementing stack in TigerTree.g
	public Id get(String token) {
		for (SymbolTable tab = this; tab != null; tab = tab.outer) {
			Id id = (Id)(tab.table.get(token));
			if(id != null) return id;
		}

		return null;
	}
}
