package mainStructures.toolsModule.treeExcutable;

import java.util.ArrayList;
import java.util.Stack;

import mainStructures.textCommands.nodesPart.ExecutionTree;

public class TreeBuilder {
	
	public static ExecutionTree buildTree (ArrayList<ExecutionTree> nodes) {
		
		Stack <ExecutionTree> stack = new Stack<>();
//System.out.println("PPPPPPPPPPPPPPPPPile"+nodes);
		for (ExecutionTree node : nodes) {
			if (node.getClass().getName().equals("mainStructures.textCommands.nodesPart.CommandJointJOIN")) {
				node.setLeft(stack.pop());
//System.out.println("JOINUP"+node.getClass().getName());
				stack.push(node);
			}else {
				stack.push(node);
//System.out.println("ELSENNNNNNNNOZ"+node.getClass().getName());
			}
		}
		
		ExecutionTree[] root = new ExecutionTree[2];
		while(stack.size()!=1) {
			root[0]=stack.pop();
//System.out.println("Right"+root[0].getClass().getName());
			root[1]=stack.pop();
//System.out.println("UP"+root[1].getClass().getName());
			root[1].setRight(root[0]);
			stack.push(root[1]);
		}
		return stack.pop();

	}

}
