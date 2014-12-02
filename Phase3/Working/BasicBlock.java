import java.util.LinkedList;

public class BasicBlock{
	public int name;
	LinkedList<BasicBlock> pre = new LinkedList<BasicBlock>();
	//LinkedList<BasicBlock> post = new LinkedList<BasicBlock>();
	LinkedList<Integer> post = new LinkedList<Integer>();
	public int start;
	public int end;
	
	public BasicBlock() {
		System.out.println("BasicBlock class construction might be wrong!");
	}
	public BasicBlock(int name) {
		this.start =  name;
	}
	
	public void setStart(int i) {
		start = i;
	}

	public void setEnd(int i) {
		end = i;
	}

	public void addPre(BasicBlock b) {
		pre.add(b);
	}

	//public void addPost(BasicBlock b) {
	public void addPost(int b){
		post.add(b);
	}
	
	public LinkedList getPreList() {
		return pre;
	}

	public LinkedList getPostList() {
		return post;
	}

	public String toString() {
		String s = "start: " + start + " end: " + end + " pre: " + pre + " post : " + post  +"\n";
		return s;
	}

}
	

