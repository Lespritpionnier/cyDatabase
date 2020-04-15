package faceGraphical.showTree.informations;

import mainStructures.dataFramework.TableDatabase;
import mainStructures.textCommands.nodesPart.CommandJointJOIN;
import mainStructures.textCommands.nodesPart.CommandArchetypeNode;
import mainStructures.textCommands.nodesPart.CommandProjectionSELECT;
import mainStructures.textCommands.nodesPart.CommandSelectionWHERE;
import mainStructures.toolsModule.treeExcutable.ParsingVisitor;

public class HightVisitor implements ParsingVisitor<Void> {
	
	private int height = 0;
	private int currentHeight = 0;

	public int getHeight() {
		return height;
	}

	
	private void processTable() {
		if (height < currentHeight) {
			height = currentHeight;
		}
	}

	

	private void processCommand(CommandArchetypeNode node) {
		currentHeight++;
		node.getLeft().accept(this);
		node.getRight().accept(this);
		currentHeight--;
	}

	@Override
	public Void visit(CommandProjectionSELECT node) {
		processCommand(node);
		return null;
	}

	@Override
	public Void visit(CommandSelectionWHERE node) {
		processCommand(node);
		return null;
	}

	@Override
	public Void visit(CommandJointJOIN node) {
		processCommand(node);
		return null;
	}

	

	@Override
	public Void visit(TableDatabase node) {
		processTable();
		return null;
	}

	

}
