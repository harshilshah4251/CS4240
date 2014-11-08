import java.util.ArrayList;

public class Function extends Var{

    private ArrayList<Id> paramList = new ArrayList<Id>();
    private String funcName;
    private Type returnType;
    private int numParam;

    public Function(String funcName, Type returnType, ArrayList<Id> paramList) {
        this.funcName = funcName;
        this.returnType = returnType;
	this.paramList = paramList;
	numParam = paramList.size();
    }

    public void addParam(Id id) {
        paramList.add(id);
        numParam = paramList.size();
    }

    public Type funcReturn() {
        return returnType;
    }

    //public 


}

