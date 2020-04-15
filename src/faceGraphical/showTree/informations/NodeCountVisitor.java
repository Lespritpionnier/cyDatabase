package faceGraphical.showTree.informations;



import mainStructures.dataFramework.TableDatabase;
import mainStructures.nodeCommand.CommandJointJOIN;
import mainStructures.nodeCommand.CommandProjectionSELECT;
import mainStructures.nodeCommand.CommandSelectionWHERE;
import mainStructures.nodeCommand.ExecutionTree;
import mainStructures.toolsModule.treeExcutable.ParsingVisitor;

public class NodeCountVisitor implements ParsingVisitor<Integer> {
	private int count;

	public NodeCountVisitor() {
		count = 0;
	}
	

	private Integer processCommandNode(ExecutionTree node) {
		node.getLeft().accept(this);
		node.getRight().accept(this);
		return ++count;
	}
	
	private Integer processTableNode(ExecutionTree node) {
		return ++count;
	}
	
	
	@Override
	public Integer visit(CommandProjectionSELECT node) {
		processCommandNode(node);
		return null;
	}

	@Override
	public Integer visit(CommandSelectionWHERE node) {
		processCommandNode(node);
		return null;
	}

	@Override
	public Integer visit(CommandJointJOIN node) {
		processCommandNode(node);
		return null;
	}

	@Override
	public Integer visit(TableDatabase node) {
		processTableNode(node);
		return null;
	}
}
