import java.util.LinkedList;

public class EBB {
    private LinkedList<BasicBlock> ebb = new LinkedList<BasicBlock>();
    private LinkedList<Integer> preEbb = new LinkedList<Integer>();
    private LinkedList<Integer> postEbb = new LinkedList<Integer>();
    private int start;

    public LinkedList getEbb() {
	return ebb;
    }

    public void addBlock(BasicBlock basicBlock) {
	ebb.add(basicBlock);
    }
    
    public LinkedList getPreEbb() {
	return preEbb;
    }

    public LinkedList getPostEbb() {
	return postEbb;
    }

    public void addPreEbb(int previousEbb) {
	preEbb.add(previousEbb);
    }

    public void addPostEbb(int post) {
	postEbb.add(post);
    }

    public String toString() {
	String s = "";
	for (int i = 0; i < ebb.size(); i++) {
	    s += ebb.get(i) + "\n";
	}
	return s;
    }
}
