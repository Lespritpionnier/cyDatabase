package faceGraphical.userInterface;

import java.util.ArrayList;

import javax.swing.JFrame;

import faceGraphical.showTree.elements.TreePanel;
import mainStructures.dataFramework.Table_database;
import mainStructures.textExecutable.ExecutionTree;
import mainStructures.textExecutable.TreeBuilder;
import mainStructures.textExecutable.commands.CommandJointJOIN;
import mainStructures.textExecutable.commands.CommandProjectionSELECT;
import mainStructures.textExecutable.commands.CommandSelectionWHERE;



public class GUI extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TreePanel treePanel;

	/**
	 * To create a graphical tree frame, we need to specify the input tree text file.
	 * 
	 * @param input the name of input file with its path
	 */
	public GUI(ArrayList<ExecutionTree> input) {
		super("Graphical Tree Demo");

		TreeBuilder builder = new TreeBuilder();
		builder.addAll(input);
		ExecutionTree tree = builder.buildTree();

		treePanel = new TreePanel(tree);

		initLayout();
	}

	private void initLayout() {
		getContentPane().add(treePanel);
		setVisible(true);
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
	}


	public static void main(String[] args) {
		ArrayList<ExecutionTree> list= new ArrayList<ExecutionTree> ();
		list.add(new Table_database("tab1"));
		list.add(new CommandJointJOIN(null, null));
		list.add(new CommandProjectionSELECT(null, null));
		list.add(new CommandSelectionWHERE(null, null));
		
		new GUI(list);
	}
}