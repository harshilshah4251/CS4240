
import java.util.*;

public class SymbolTable {
	private Hashtable table;
	protected SymbolTable outer;
	public SymbolTable(SymbolTable st) {
		table = new Hashtable();
		outer = st;
	}

	public void put(String token, Type t, int b) {
		table.put(token, new Id(token, t, b));
	}

	public Id get(String token) {
		for (SymbolTable tab = this; tab != null; tab = tab.outer) {
			Id id = (Id)(tab.table.get(token));
			if(id != null) return id;
		}

		return null;
	}
}
