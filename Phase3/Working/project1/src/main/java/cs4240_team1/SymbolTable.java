package cs4240_team1;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import utility.Utility;

/*
 * class which represents a symbol table for a given scope.
 * */
public class SymbolTable {

	/**
	 * this is used to assign a unique numeric id to each variable entry.
	 */
	static int varCounter = 0;

	/**
	 * human-readable unique name for this symbol table.
	 */
	String name;

	/**
	 * records what level the current symbol table is nested at.
	 */
	int nestingLevel;

	/**
	 * records what the position of this block is within the parent symbol
	 * table.
	 */
	int blockIndex;

	/** pointer to the parent scope */
	SymbolTable parent;

	/**
	 * list of the child scopes of this one, indexed by position. If no child
	 * scopes exist, this is an empty list
	 */
	List<SymbolTable> children;

	/** the hashtable that actually stores the entries */
	Map<String, SymbolTableEntry> ht;

	/**
	 * return type for each function for easy access
	 */
	TigerType returnType;

	/**
	 * can the table hold functions? Used for printing the table. Only true for
	 * the top-level, non-temp symbol table
	 */
	boolean canHoldFunctions;

	/**
	 * this constructor is meant to be used to build the toplevel symbol table
	 */
	public SymbolTable(boolean canHoldFunctions) {
		this.parent = null;
		this.children = new ArrayList<>();
		this.ht = new HashMap<>();
		this.nestingLevel = 0;
		this.blockIndex = 0;
		this.name = "table";
		this.canHoldFunctions = canHoldFunctions;
	}

	/**
	 * this constructor is meant to be used to build non-toplevel symbol tables,
	 * with a parent table.
	 * 
	 * @param parent
	 *            the parent table of this symbol table.
	 */
	public SymbolTable(SymbolTable parent) {
		this.parent = parent;
		this.children = new ArrayList<>();
		this.ht = new HashMap<>();
		this.blockIndex = parent.getChildren().size();
		this.nestingLevel = parent.getNestingLevel() + 1;
		this.canHoldFunctions = false;
		this.name = parent.getName() + "#" + blockIndex;
		parent.addChildEntry(this);
		this.returnType = parent.returnType;
		// here we see that parent.getChildren() can't legally be null.
	}

	public SymbolTableEntry lookup(String name) {
		if (ht.containsKey(name)) {
			return ht.get(name);
		} else {
			if (this.parent == null) {
				return null;
			} else {
				return this.parent.lookup(name);
			}
		}
	}

	/** Returns null if there is no TypeEntry for the given id */
	public TypeEntry lookupType(String typeId) {
		SymbolTableEntry typeEntry = lookup(typeId);
		if (typeEntry == null || !(typeEntry instanceof TypeEntry)) {
			/* typeEntry does not exist */
			return null;
		}

		return (TypeEntry) typeEntry;
	}

	/**
	 * Returns the function entry for the funcId, including a usable
	 * FunctionEntry object if this is a standard library call.
	 */
	public FunctionEntry lookupFunctionIncludingStdLib(String funcId) {
		if ("printi".equals(funcId)) {
			return FunctionEntry.STDLIB_PRINTI;
		} else if ("flush".equals(funcId)) {
			return FunctionEntry.STDLIB_FLUSH;
		} else if ("not".equals(funcId)) {
			return FunctionEntry.STDLIB_NOT;
		} else if ("exit".equals(funcId)) {
			return FunctionEntry.STDLIB_EXIT;
		} else {
			SymbolTableEntry entry = lookup(funcId);
			if (entry instanceof FunctionEntry) {
				return (FunctionEntry) entry;
			} else {
				return null;
			}
		}
	}

	/** For inserting FunctionEntry's that have been checked for semantics. */
	public void insertFunction(FunctionEntry newEntry) {
		/* first, associate a TigerType for the function's return type */
		TigerType returnType = resolveToTigerType(newEntry.returnTypeId);
		newEntry.setReturnType(returnType);
		insert(newEntry);
	}

	/** Used to quickly access return type for functions */
	public void setFunctionReturnType(TigerType returnType) {
		this.returnType = returnType;
	}

	/**
	 * For inserting TypeEntry's that have been checked for semantic
	 * correctness.
	 */
	public void insertType(TypeEntry newEntry) {
		/* First, CREATE a TigerType for the type */
		TigerType newTigerType = new TigerType(newEntry);
		newEntry.tigerType = newTigerType;

		insert(newEntry);
	}

	/**
	 * For inserting VarEntry's that have been checked for semantic correctness.
	 */
	public void insertVar(VarEntry newEntry) {
		/* First, associate a TigerType for the var's type */
		TigerType varType = resolveToTigerType(newEntry.typeId);
		newEntry.setType(varType);

		/* Now, assign a uniqueId to the var */
		newEntry.uniqueVarId = "__"+ newEntry.varId + "" + varCounter;
		varCounter++;

		insert(newEntry);
	}

	public void insertVar(Parameter param) {
		insertVar(new VarEntry(param.paramId, param.typeId));
	}

	public void insert(SymbolTableEntry entry) {
		assert (!ht.containsKey(entry.tableKey));
		ht.put(entry.tableKey, entry);
	}

	/** Gets the corresponding TigerType for the typeId - null if none exists */
	public TigerType resolveToTigerType(String typeId) {
		/* if it is derived type, access TigerType via symbol table entry */
		if (TypeChecker.isDerivedTypeId(typeId, this)) {
			return lookupType(typeId).tigerType;
		}

		/* otherwise, we have a base or void type */
		if ("int".equals(typeId)) {
			return TigerType.BASE_INT_TYPE;
		} else if ("fixedpt".equals(typeId)) {
			return TigerType.BASE_FIXEDPT_TYPE;
		} else if ("void".equals(typeId)) {
			return TigerType.VOID_TYPE;
		}

		return null;
	}

	/** adds a symbol table to the child list of this symbol table */
	public void addChildEntry(SymbolTable child) {
		this.children.add(child);
	}

	/** returns a string for pretty printing of this table and its children */
	public String recursivePrettyPrintString() {
		StringBuilder prettyPrintBuilder = new StringBuilder();
		this.buildPrettyPrint(prettyPrintBuilder);
		return prettyPrintBuilder.toString();
	}

	private void buildPrettyPrint(StringBuilder accumulator) {
		accumulator.append(this.toString(nestingLevel));
		accumulator.append('\n');

		for (SymbolTable child : children) {
			child.buildPrettyPrint(accumulator);
		}
	}

	/**
	 * responsible for creating the string for only this symbol table's entries
	 * (no children)
	 * 
	 * @param indentLevel
	 *            controls how much the toString output will be indented.
	 *            usually matches the nestingLevel value for the current object.
	 */
	public String toString(int indentLevel) {
		Collection<TypeEntry> typeEntries = getTypeEntries();
		Collection<VarEntry> varEntries = getVarEntries();

		String result = "";
		String indent = "";

		while (indentLevel > 0) {
			indent += "\t";
			indentLevel--;
		}


		result = indent +  Utility.formatHeaderForOutput(this.getName() + " START");

		if (canHoldFunctions) {
			Collection<FunctionEntry> functionEntries = getFunctionEntries();
			functionEntries.add(FunctionEntry.STDLIB_PRINTI);
			functionEntries.add(FunctionEntry.STDLIB_FLUSH);
			functionEntries.add(FunctionEntry.STDLIB_NOT);
			functionEntries.add(FunctionEntry.STDLIB_EXIT);

			result += "\n\n" + indent + Utility.formatHeaderForOutput("FUNCTIONS ("
					+ functionEntries.size() + ")"); 
			for (FunctionEntry funcEntry : functionEntries) {
				result += "\n";
				result += indent + funcEntry.toString();
			}
		}

		result += "\n\n" + indent + 
				Utility.formatHeaderForOutput("TYPES ("+ typeEntries.size() + ")");
		for (TypeEntry typeEntry : typeEntries) {
			result += "\n";
			result += indent + typeEntry.toString();
		}

		result += "\n\n" + indent + 
				Utility.formatHeaderForOutput("VARIABLES ("+
				+ varEntries.size() + ")");
		for (VarEntry varEntry : varEntries) {
			result += "\n";
			result += indent + varEntry.toString();
		}

		result += "\n" + indent + Utility.formatHeaderForOutput("END OF TABLE");
		return result;
	}

	private Collection<FunctionEntry> getFunctionEntries() {
		Collection<FunctionEntry> functionEntries = new ArrayList<>();

		for (SymbolTableEntry entry : ht.values()) {
			if (entry instanceof FunctionEntry) {
				functionEntries.add((FunctionEntry) entry);
			}
		}
		return functionEntries;
	}

	/** Get return type for easy access */
	public TigerType getFunctionReturnType() {/*
											 * take care of main, return void
											 * automatically
											 */
		return this.returnType;
	}

	private Collection<TypeEntry> getTypeEntries() {
		Collection<TypeEntry> typeEntries = new ArrayList<>();

		for (SymbolTableEntry entry : ht.values()) {
			if (entry instanceof TypeEntry) {
				typeEntries.add((TypeEntry) entry);
			}
		}
		return typeEntries;
	}

	private Collection<VarEntry> getVarEntries() {
		Collection<VarEntry> varEntries = new ArrayList<>();

		for (SymbolTableEntry entry : ht.values()) {
			if (entry instanceof VarEntry) {
				varEntries.add((VarEntry) entry);
			}
		}
		return varEntries;
	}

	public int getNestingLevel() {
		return nestingLevel;
	}

	public String getName() {
		return name;
	}

	public int getBlockIndex() {
		return blockIndex;
	}

	public SymbolTable getParent() {
		return parent;
	}

	public List<SymbolTable> getChildren() {
		return children;
	}

	public Map<String, SymbolTableEntry> getHt() {
		return ht;
	}
}
