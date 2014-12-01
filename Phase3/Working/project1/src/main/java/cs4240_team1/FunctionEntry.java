package cs4240_team1;

import java.util.List;
import java.util.ArrayList;

public class FunctionEntry extends SymbolTableEntry implements IRCodeArgument {

    public final String functionId;
    public final List<Parameter> parameters;  /* if no parameters, this is length 0 */

    public String returnTypeId;
	public TigerType returnType;

    public FunctionEntry(String functionId, String returnTypeId, List<Parameter> parameters) {
        super(functionId);
        this.functionId = functionId;
        this.returnTypeId = returnTypeId;
        this.parameters = parameters;
    }

	/* for accessing what a FunctionEntry would look like for standard library functions that are callable */
	public static final FunctionEntry STDLIB_PRINTI = createSTLPrinti();
	public static final FunctionEntry STDLIB_FLUSH = createSTLFlush();
	public static final FunctionEntry STDLIB_NOT = createSTLNot();
	public static final FunctionEntry STDLIB_EXIT = createSTLExit();

    @Override
    public String toString() {
        String result;
        result = "< " + functionId + " | ret: " + returnTypeId;

        String delim = " | params: (";
        for (Parameter p: parameters) {
           result += delim + p.typeId;
           delim = ", ";
        }
        result += parameters.isEmpty() ? " >" : ") >";
        return result;
    }

	@Override
	public String getCategoryAsString() {
		return "function";
	}

	public TigerType getReturnType() {
		return returnType;
	}

	public void setReturnType(TigerType newReturnType) {
		this.returnType = newReturnType;
		this.returnTypeId = newReturnType.typeId;
	}

    @Override
    public String getTextForIR() {
        return this.functionId;
    }

    @Override
    public TigerType getTigerType() {
        return this.returnType;
    }

	/* FOR STD LIB FUNCTIONS */

	/** printi(i: int): void */
	private static FunctionEntry createSTLPrinti() {
		List<Parameter> params = new ArrayList<>();
		params.add(new Parameter("i", "int"));

		FunctionEntry printi = new FunctionEntry("printi", "void", params);
		printi.setReturnType(TigerType.VOID_TYPE);
		return printi;
	}

	/** flush(): void */
	private static FunctionEntry createSTLFlush() {
		List<Parameter> params = new ArrayList<>();
		FunctionEntry flush = new FunctionEntry("flush", "void", params);
		
		flush.setReturnType(TigerType.VOID_TYPE);
		return flush;
	}

	/** not(i: int): int */
	private static FunctionEntry createSTLNot() {
		List<Parameter> params = new ArrayList<>();
		params.add(new Parameter("i", "int"));

		FunctionEntry not = new FunctionEntry("not", "int", params);
		not.setReturnType(TigerType.BASE_INT_TYPE);
		return not;
	}

	/** exit(i: int): void */
	private static FunctionEntry createSTLExit() {
		List<Parameter> params = new ArrayList<>();
		params.add(new Parameter("i", "int"));

		FunctionEntry exit = new FunctionEntry("exit", "void", params);
		exit.setReturnType(TigerType.VOID_TYPE);
		return exit;
	}
}
