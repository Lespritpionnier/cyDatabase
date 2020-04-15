package faceGraphical.showTree.elements;

import java.awt.Graphics;

import faceGraphical.showTree.informations.NodePosition;
import mainStructures.dataFramework.TableDatabase;
import mainStructures.textCommands.nodesPart.CommandJointJOIN;
import mainStructures.textCommands.nodesPart.CommandProjectionSELECT;
import mainStructures.textCommands.nodesPart.CommandSelectionWHERE;
import mainStructures.toolsModule.treeExcutable.ParsingVisitor;

public class DisplayVisitor implements ParsingVisitor<Void> {
	public DisplayVisitor(Graphics g, NodePosition startPoint, int treeHeight) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Void visit(CommandProjectionSELECT node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(CommandSelectionWHERE node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(CommandJointJOIN node) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Void visit(TableDatabase node) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
