package mainStructures.toolsModule.treeExcutable;

import java.util.ArrayList;
import java.util.Stack;

import mainStructures.nodeCommand.ExecutionTree;
/**
 * Build a Execution Tree by using stack
 */
public class TreeBuilder {
	
	public static ExecutionTree buildTree (ArrayList<ExecutionTree> nodes) {
		Stack <ExecutionTree> stack = new Stack<>();
		for (ExecutionTree node : nodes) {
			if (node.getClass().getName().equals("mainStructures.nodeCommand.CommandJointJOIN")) {
				node.setLeft(stack.pop());
				stack.push(node);
			}else {
				stack.push(node);
			}
		}
		ExecutionTree[] root = new ExecutionTree[2];
		while(stack.size()!=1) {
			root[0]=stack.pop();
			root[1]=stack.pop();
			root[1].setRight(root[0]);
			stack.push(root[1]);
		}
		return stack.pop();

	}

}
