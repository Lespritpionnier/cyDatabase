package faceGraphical.showTree.informations;

import java.awt.Graphics;

import mainStructures.dataFramework.TableDatabase;
import mainStructures.nodeCommand.CommandJointJOIN;
import mainStructures.nodeCommand.CommandProjectionSELECT;
import mainStructures.nodeCommand.CommandSelectionWHERE;

public interface ColorStrategt {

	void setColor(Graphics graphics, CommandJointJOIN node);

	void setColor(Graphics graphics, CommandProjectionSELECT node);

	void setColor(Graphics graphics, CommandSelectionWHERE node);

	void setColor(Graphics graphics, TableDatabase node);

	void setLineColor(Graphics graphics);
	
}
