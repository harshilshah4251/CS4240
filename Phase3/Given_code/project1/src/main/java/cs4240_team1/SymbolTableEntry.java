package cs4240_team1;

public abstract class SymbolTableEntry {

    public final String tableKey;

    public SymbolTableEntry(String tableKey) {
        this.tableKey = tableKey;
    }
    
	/** Should return "type", "var", or "function" (for convenience) */
	public abstract String getCategoryAsString();

}
