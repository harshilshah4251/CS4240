package cs4240_team1;

import java.util.ArrayList;
import java.util.List;


/* [CB 11/7/14] this class controls code generation.  the code is built up
 * in codeList while IRCodeWalker runs. Then the code can be gotten out at the
 * end of the process.
 */
public class Generation {

    public static final String temp = "_t";
    public static final String label = "_label";
    private static int tempCount = 0;
    private static int labelCount = 0;
    private static SymbolTable tempSymbolTable = new SymbolTable(false);
    
    /**
     * this contains the actual list of code as it is being built up
     * during tree traversal.
     */
    List<IRInstruction> codeList;
    
    public Generation() {
    	this.codeList = new ArrayList<IRInstruction>();
    }

    /* public static String newLabel() {
        StringBuilder build = new StringBuilder(label);
        build.append(labelCount);
        labelCount++;
        return build.toString();
    } */

    public static LabelArgument newLabel1() {
        StringBuilder build = new StringBuilder(label);
        build.append(labelCount);
        labelCount++;
        return new LabelArgument(build.toString());
    }

    public static VarEntry newTemp(TigerType type) {
        StringBuilder build = new StringBuilder(temp);
        build.append(tempCount);
        tempCount++;
        VarEntry out = new VarEntry(build.toString(), type, build.toString());
        tempSymbolTable.insert(out);
        return out;
    }

    /* public static String newTempStr() {
        StringBuilder build = new StringBuilder(temp);
        build.append(tempCount);
        tempCount++;
        return build.toString();
    } */
    
    /* the other stuff is too damn complex, just need to print the ir in any case. */
    /* public void emitStr(String s) {
    	outBuffer.append(s + "\n");
    	//System.out.println(s);
    } */

    public void emit(IRInstruction i) {
    	codeList.add(i);
    }
    
    public void emit(Op op, IRCodeArgument ... args) {
    	codeList.add(new IRInstruction(op, args));
    }

    public void emit(Op op, List<IRCodeArgument> args) {
        codeList.add(new IRInstruction(op, args));
    }
    
    public List<IRInstruction> getCodeList() {
    	return codeList;
    }

    public void printString() {
        for (IRInstruction arg : codeList) {
            System.out.println(arg.toString());
        }
    }

	public static SymbolTable getTempSymbolTable() {
		return tempSymbolTable;
	}
}
