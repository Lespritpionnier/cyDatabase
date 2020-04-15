package faceGraphical.showTree.informations;

import java.awt.Color;
import java.awt.Graphics;

import faceGraphical.showTree.informations.ColorStrategt;
import mainStructures.dataFramework.TableDatabase;
import mainStructures.textCommands.nodesPart.CommandJointJOIN;
import mainStructures.textCommands.nodesPart.CommandProjectionSELECT;
import mainStructures.textCommands.nodesPart.CommandSelectionWHERE;


public class PaintColor implements ColorStrategt {
	
	@Override
	public void setColor(Graphics graphics, CommandJointJOIN node) {
		graphics.setColor(Color.RED);
	}

	@Override
	public void setColor(Graphics graphics, CommandProjectionSELECT node) {
		graphics.setColor(Color.BLUE);

	}

	@Override
	public void setColor(Graphics graphics, CommandSelectionWHERE node) {
		processOperation(graphics);
	}

	@Override
	public void setColor(Graphics graphics, TableDatabase node) {
		processOperation(graphics);

	}

	

	@Override
	public void setLineColor(Graphics graphics) {
		graphics.setColor(Color.BLACK);

	}

	private void processOperation(Graphics graphics) {
		graphics.setColor(Color.BLACK);

	}

}
