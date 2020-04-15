package faceGraphical.showTree.elements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import faceGraphical.showTree.informations.HightVisitor;
import faceGraphical.showTree.informations.IconsStyle;
import mainStructures.textCommands.nodesPart.ExecutionTree;

public class TreePanel  extends JPanel {
	private ExecutionTree tree;
	private int treeHeight;

	/**
	 * Showing the grid will make the debug easier.
	 */
	private boolean debugGrid = false;

	public TreePanel(ExecutionTree tree) {
		int windowWidth = IconsStyle.WINDOW_WIDTH;

		this.tree = tree;
		HightVisitor hightVistor = new HightVisitor();
		tree.accept(hightVistor);
		treeHeight = hightVistor.getHeight();

		setPreferredSize(new Dimension(windowWidth, IconsStyle.WINDOW_HEIGHT));
		setBackground(Color.WHITE);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setFont(new Font("Dialog", Font.PLAIN, IconsStyle.POLICE_SIZE));
		g.setColor(Color.BLUE);

		if (debugGrid) {
			drawDebugGrid(g);
		}

		DisplayVisitor paintVisitor = new DisplayVisitor(g, IconsStyle.START_POINT, treeHeight);
		tree.accept(paintVisitor);

	}

	private void drawDebugGrid(Graphics g) {
		int width = getWidth();
		int height = getHeight();
		g.setColor(Color.GRAY);

		for (int i = IconsStyle.SCALE; i <= width; i += IconsStyle.SCALE) {
			g.drawLine(i, 1, i, height);
		}

		for (int i = IconsStyle.SCALE; i <= height; i += IconsStyle.SCALE) {
			g.drawLine(1, i, width, i);
		}
	}
}
