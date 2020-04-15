package faceGraphical.showTree.informations;



import mainStructures.dataFramework.TableDatabase;
import mainStructures.textCommands.nodesPart.CommandJointJOIN;
import mainStructures.textCommands.nodesPart.CommandProjectionSELECT;
import mainStructures.textCommands.nodesPart.CommandSelectionWHERE;
import mainStructures.textCommands.nodesPart.ExecutionTree;
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
