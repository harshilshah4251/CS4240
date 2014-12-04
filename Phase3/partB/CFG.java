import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.HashSet;
import java.util.Set;
import java.util.LinkedList;
import java.util.ArrayList;

public class CFG {


	public static ArrayList getIRList(String fileName) {
		ArrayList<String> ir = new ArrayList<String>();
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String curr = "";
			int i = 0;
			while((curr = br.readLine()) != null) {
				if(curr.contains(")")) {
					ir.add(curr);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ir;
	}
					
	public static int getLine(String s) {
		int i = s.indexOf(")");
		String result = s.substring(0, i);
		int r = Integer.parseInt(result);
		return r;
	}

	public static BasicBlock getBlockS(LinkedList<BasicBlock> list, int blockStart) {
		int i = 0;
		for(i = 0; i < list.size(); i++) {
			if(list.get(i).start == blockStart) {
				return list.get(i);
			}
		}
		return new BasicBlock(0);
	}

	public static BasicBlock getBlockE(LinkedList<BasicBlock> list, int blockEnd) {
		int i = 0;
		for(i = 0; i < list.size(); i++) {
			if(list.get(i).end == blockEnd) 
				return list.get(i);
		}
		return new BasicBlock(0);
	}

	public static int findLabelLine(String label, String fileName) {
		int result = 0;
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String curr = "";
			boolean found = false;
			while((curr = br.readLine()) != null) {
				if(curr.contains(label)) {
					if(curr.contains(":")) {
						found = true;
					}
				}
				if(found) {
					if(curr.contains(")")) {
						result = getLine(curr);
						return result;
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static String findLabel(String s) {
		int index = s.lastIndexOf(",");
		String result = s.substring(index+2, s.length());
		return result;
	}

	public static String findSendLabel(String s) {
		int firstIndex = s.indexOf(",");
		String s1 = s.substring(firstIndex + 1, s.length());
		int secondIndex = s1.indexOf(",");
		String s2 = s1.substring(1, secondIndex);
		return s2;
	}

	public static void updatePost(LinkedList<BasicBlock> list) {
		for(int i = 0; i < list.size(); i++) {
			BasicBlock curr = list.get(i);
			LinkedList<Integer> post = curr.post;
			for(int j = 0; j < post.size(); j++) {
				int prestart = post.get(j);
				for(int k = 0; k < list.size(); k++) {
					if(list.get(k).start == prestart) {
						list.get(k).addPre(curr.start);
					}
				}
			}
		}
	}
				
		

	public static LinkedList getCFG(String name) {
		String prev = "";
		String curr = "";
		String next = "";
		String fileName = name;

		BasicBlock currBlock = new BasicBlock(0);
		LinkedList<BasicBlock> blockList = new LinkedList<BasicBlock>();

		LinkedList<String> label = new LinkedList<String>();
		LinkedList<String> branch = new LinkedList<String>();
		LinkedList<String> send = new LinkedList<String>();

		label.add(":");
		branch.add("breq");
		branch.add("brneq");
		branch.add("brlt");
		branch.add("brgt");
		branch.add("brgeq");
		branch.add("brleq");
		branch.add("break");
		send.add("goto");
		//send.add("return");

		try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			boolean setNextStart = false;
			if(currBlock.start == 0) {
				while((curr = br.readLine()) != null && !curr.contains("1)")) {
				}
					BasicBlock first = new BasicBlock(1);
					blockList.add(first);
					currBlock = first;
					prev = curr;
			}
				
			while((curr = br.readLine()) != null) {
				int i = 0;
				int cases = 0;
				if(setNextStart) {
					if(curr.contains(")")) {
						BasicBlock block = new BasicBlock(getLine(curr));
						blockList.add(block);
						currBlock = block;
						setNextStart = false;
					}
				} if(!setNextStart) {
					for(i = 0; i < label.size(); i++) {
						if(curr.contains(label.get(i))) {
							setNextStart = true;
							currBlock.setEnd(getLine(prev));
						}
					}
					for(i = 0; i < branch.size(); i++) {
						if(curr.contains(branch.get(i))) {
							setNextStart = true;
							currBlock.setEnd(getLine(curr));
						}
					}
					for(i = 0; i < send.size(); i++) {
						if(curr.contains(send.get(i))) {
							setNextStart = true;
							currBlock.setEnd(getLine(curr));
						}
					}
				}
				if(curr.contains(")")) {
					prev = curr;
				}
			}
			currBlock.setEnd(getLine(prev));
		} catch (Exception e) {
			e.printStackTrace();
		}

		try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			int i = 0;
			int j = 0;
			int endBlock = 0;
			while((curr = br.readLine()) != null) {
				BasicBlock block;
				boolean used = false;
				for(i = 0; i < blockList.size(); i++) {
					currBlock = blockList.get(i);
					endBlock = currBlock.end;
					if(curr.contains(")") && endBlock == getLine(curr)) {
						for(j = 0; j < branch.size(); j++) {
							if(curr.contains(branch.get(j))) {
								used = true;
								currBlock.addPost(endBlock+1);
								int labelLine = findLabelLine(findLabel(curr), fileName);
								currBlock.addPost(labelLine);

							}
						}
					}
				}
				for(i = 0; i < blockList.size(); i++) {
					currBlock = blockList.get(i);
					endBlock = currBlock.end;
					if(curr.contains(")") && endBlock == getLine(curr)) {
						for(j =0; j< send.size(); j++) {
							if(curr.contains(send.get(j))) {
								used = true;
								int labelLine = findLabelLine(findSendLabel(curr),fileName);
								block = getBlockS(blockList, labelLine);
								currBlock.addPost(labelLine);
							}
						}
					}
				}
				if(!used) {
					for(i = 0; i < blockList.size(); i++) {
						currBlock = blockList.get(i);
						endBlock = currBlock.end;
						if(curr.contains(")") && endBlock == getLine(curr)) {
							if(!curr.contains("return")) {
								currBlock.addPost(endBlock+1);
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println(blockList);
		updatePost(blockList);
		return blockList;
	}
}


