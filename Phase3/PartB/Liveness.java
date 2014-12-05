import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import java.util.Stack;

public class Liveness {

	//static ArrayList<String> irList;
	static ArrayList<String> branch;
	static ArrayList<String> binary;
	String assign = "assign";
	String arrStore = "array_store";
	String arrLoad = "array_load";

	public static ArrayList<Inst> parseInst(ArrayList<String> list) {
		ArrayList<Inst> instList = new ArrayList<Inst>();
		for(int i = 0; i < list.size(); i++) {
			String curr = list.get(i);
			String firstUsed = "";
			String secondUsed = "";
			String lastUsed = "";
			int firstCom = curr.indexOf(",");
			int secondCom = curr.indexOf(",",firstCom+1);
			int lastCom = curr.lastIndexOf(",");
System.out.println(curr);
			boolean firstNumber = true;
			boolean secondNumber = true;
			boolean lastNumber = true;
			if(firstCom + 2 <= secondCom ) {
				firstUsed = curr.substring(firstCom + 2, secondCom );
			}
			if(secondCom + 2 <= lastCom ) {
				secondUsed = curr.substring(secondCom + 2, lastCom );
			}
			if(lastCom + 2 <= curr.length()) {
				lastUsed = curr.substring(lastCom + 2, curr.length());
			}

			try{
				Integer.parseInt(firstUsed);
			} catch(NumberFormatException e) {
				firstNumber = false;
			}

			try{
				Integer.parseInt(secondUsed);
			} catch(NumberFormatException e) {
				secondNumber = false;
			}
	
			try{
				Integer.parseInt(lastUsed);
			} catch(NumberFormatException e) {
				lastNumber = false;
			}


			for(int j = 0; j < branch.size(); j++) {
				if(curr.contains(branch.get(j))) {
					Inst inst = new Inst();
					if(!firstNumber) {
						inst.addUsed(firstUsed);
					}
					if(!secondNumber) {
						inst.addUsed(secondUsed);
					}
System.out.println(inst);
				instList.add(inst);
				}
			}

			for(int j = 0; j < binary.size(); j++) {
				if(!curr.contains("array_store") && curr.contains(binary.get(j))) {
					Inst inst = new Inst();
					if(!firstNumber) {
						inst.addUsed(firstUsed);
					}
					if(!secondNumber) {
						inst.addUsed(secondUsed);
					}
					if(!lastNumber) {
						inst.addDef(lastUsed);
					}
System.out.println(inst);
				instList.add(inst);
				}
			}
			if(curr.contains("assign")) {
				Inst inst = new Inst();
				if(!firstNumber) {
					inst.addDef(firstUsed);
				}
				if(!secondNumber) {
					inst.addUsed(secondUsed);
				}
System.out.println(inst);
				instList.add(inst);
			}
			if(curr.contains("array_store")) {
				Inst inst = new Inst();
				if(!firstNumber) {
					inst.addDef(firstUsed);
				}
				if(!secondNumber) {
					inst.addUsed(secondUsed);
				}
				if(!lastNumber) {
					inst.addUsed(lastUsed);
				}
System.out.println(inst);
				instList.add(inst);
			}
			if(curr.contains("array_load")) {
				Inst inst = new Inst();
				if(!firstNumber) {
					inst.addDef(firstUsed);
				}
				if(!secondNumber) {
					inst.addUsed(secondUsed);
				}
				if(!lastNumber) {
					inst.addUsed(lastUsed);
				}
System.out.println(inst);
				instList.add(inst);
			}
			if(curr.contains("goto") || curr.contains("return")) {
				Inst inst = new Inst();
				instList.add(inst);
System.out.println(inst);
			}
		}
		return instList;
	}

	public static ArrayList<Var> getSpillCost(ArrayList<Inst> irList) {
		ArrayList<Var> spill = new ArrayList<Var>();

		for(int i = 0; i < irList.size(); i++) {
			Inst curr = irList.get(i);
			ArrayList<String> used = curr.used;
			for(int j = 0; j < used.size(); j++) {
				if(spill.contains(new Var(used.get(j)))) {
					int index = spill.indexOf(new Var(used.get(j)));
System.out.println(index + " of " + used.get(j));
					Var currSpill = spill.get(index);
					currSpill.increaseUsed();
				} else { 
System.out.println("NOT FOuND : " + used.get(j));
					Var newVar = new Var(used.get(j));
					newVar.increaseUsed();
					spill.add(newVar);
				}
			}
			String def = curr.def;
			if(spill.contains(new Var(def))) {
				int index = spill.indexOf(new Var(def));
				Var currSpill = spill.get(index);
				currSpill.increaseDef();
			} else {
				Var newVar = new Var(def);
				newVar.increaseDef();
				spill.add(newVar);
			}
		}
		for(int i = 0; i < spill.size(); i++) {
			spill.get(i).updateSpill();
		}

		return spill;
	}


	public static void separateIntFloat(ArrayList<Var> intList, ArrayList<Var> floatList, ArrayList<Var> list) {

		// by now we just put all the list in to the intList
		intList = list;

	}


	public static void pushToStack(Stack<Var> stack, ArrayList<Var> list) {

		int listSize = list.size();

		for(int i = 0; i < listSize; i++) {
			stack.push(findMin(list));
		}
	}

	public static Var findMin(ArrayList<Var> list) {
		Var min = list.get(0);
		int index = 0;

		for(int i = 0; i < list.size(); i++) {
			if(min.spill_cost > list.get(i).spill_cost) {
				min = list.get(i);
				index = i;
			}
		}
		list.remove(min);
		return min;
	}

	public static void replaceIntIr(ArrayList<String> ir, ArrayList<Stack<Var>> stackList, LinkedList<BasicBlock> blocks) {

		int start = 0;
		int end = 0;
		int blockInd = 0;
		for(int i = 0; i < stackList.size(); i++ ) {

			Stack<String> regs = new Stack<String>();
			String StringT = "$t";
			String StringS = "$s";
			for(int j = 0; i < 10; i++ ) {
				regs.add(StringT + i);
			}
			for(int j = 0; i < 8; i++) { 
				regs.add(StringS + i);
			}
			
			Stack<Var> varStack = stackList.get(blockInd);
			String nextReg = regs.pop();
	
			while(!regs.empty() && !varStack.empty()) {


			//start = blocks.get(i).start;
			//end = blocks.get(i).end;

			//if(curr.contains(")")) {
				

			//while(CFG.getLine(ir.get(j)) >= start || CFG.getLine(ir.get(
				
			}
		}
	


	}

	public static void replaceFloatIr(ArrayList<String> ir, ArrayList<Stack<Var>> stackList, LinkedList<BasicBlock> blocks) {

	

	}

	
	public static void main(String[] args) {

		ArrayList<String> irList = CFG.getIRList(args[0]);
		ArrayList<String> rawIrList = CFG.getRawIr(args[0]);
		LinkedList<BasicBlock> cfg = CFG.getCFG(args[0]);
	

System.out.println(cfg);
//System.out.println(irList);
		branch = new ArrayList<String>();
		binary = new ArrayList<>();
		// Consider Array Assignemnt
	
		binary.add("add");
		binary.add("sub");
		binary.add("mult");
		binary.add("div");
		binary.add("and");
		binary.add("or");

		branch.add("breq");
		branch.add("brneq");
		branch.add("brlt");
		branch.add("brgt");
		branch.add("brgeq");
		branch.add("brleq");


		// blockList : divide IR code into each Blocks
		ArrayList<ArrayList<String>> blockList = new ArrayList<ArrayList<String>>();
		for(int i = 0; i < cfg.size(); i++) {
			ArrayList<String> subList = new ArrayList<String>();
			int startInd = cfg.get(i).start - 1;
			int endInd = cfg.get(i).end;
			for(int j = startInd; j < endInd; j++) {
				subList.add(irList.get(j));
			}
			blockList.add(subList);
		}


		// Inst : tells what's declared or used in the instruction
		// blockInstList : divide Inst for each Blocks
		ArrayList<ArrayList<Inst>> blockInstList = new ArrayList<ArrayList<Inst>>();
		for(int i = 0; i < blockList.size(); i++) {
			ArrayList<Inst> instList = parseInst(blockList.get(i));
			blockInstList.add(instList);
		}

		// Var : has how many it's used or declared
		// blockVarList : divide each variables into each Blcoks
		ArrayList<ArrayList<Var>> blockVarList = new ArrayList<ArrayList<Var>>();
		for(int i = 0; i < blockInstList.size(); i++) {
			blockVarList.add(getSpillCost(blockInstList.get(i)));
		}

		//System.out.println(blockVarList);

		// has list of stacks that contains Variables
		ArrayList<Stack<Var>> blockIntStack = new ArrayList<Stack<Var>>();
		ArrayList<Stack<Var>> blockFloatStack = new ArrayList<Stack<Var>>();

		// By now I put all the variables into the intStack
		//pushToStack(intStack, intVarList);

		for(int i = 0; i < blockVarList.size(); i++) {

			ArrayList<Var> intVarList = new ArrayList<Var>();
			ArrayList<Var> floatVarList = new ArrayList<Var>();

			separateIntFloat(intVarList, floatVarList, blockVarList.get(i));

			Stack<Var> intStack = new Stack<Var>();
			Stack<Var> floatStack = new Stack<Var>();

			pushToStack(intStack, intVarList);
			pushToStack(floatStack, floatVarList);

			blockIntStack.add(intStack);
			blockFloatStack.add(floatStack);
		}

		replaceIntIr(rawIrList, blockIntStack, cfg);
		replaceFloatIr(rawIrList, blockFloatStack, cfg);


	}
}
