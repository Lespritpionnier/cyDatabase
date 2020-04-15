package faceGraphical.showTree.informations;

import java.awt.Graphics;

import mainStructures.dataFramework.TableDatabase;
import mainStructures.textCommands.nodesPart.CommandJointJOIN;
import mainStructures.textCommands.nodesPart.CommandProjectionSELECT;
import mainStructures.textCommands.nodesPart.CommandSelectionWHERE;

public interface ColorStrategt {

	void setColor(Graphics graphics, CommandJointJOIN node);

	void setColor(Graphics graphics, CommandProjectionSELECT node);

	void setColor(Graphics graphics, CommandSelectionWHERE node);

	void setColor(Graphics graphics, TableDatabase node);

	void setLineColor(Graphics graphics);
	
}
