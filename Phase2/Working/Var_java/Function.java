
import java.util.ArrayList;

public class Function {
	public ArrayList paramList = new ArrayList<Type>();
	public Type returnType;
	public String funcName;
	public int size;

	public Function(String s, Type t) {
		funcName = s;
		returnType = t;
	}

	public void addParam(Type t) {
		paramList.add(t);
		size = paramList.size();
	}

	public Type funcReturn() {
		return returnType;
	}

	//public 


}

