package faceGraphical.showTree.elements;


import mainStructures.dataFramework.Table_database;
import mainStructures.textExecutable.ExecutionTree;

import mainStructures.textExecutable.commands.CommandArchetype;
import mainStructures.textExecutable.commands.CommandJointJOIN;
import mainStructures.textExecutable.commands.CommandProjectionSELECT;
import mainStructures.textExecutable.commands.CommandSelectionWHERE;



public class NodeGraphical{

	private static final String JOIN_SYMBOL="JOIN";
	private static final String SELECT_SYMBOL= "Projection";
	private static final String WHERE_SYMBOL = "Selection";
	//private static final String CREATE_SYMBOL = "Création";
	//private static final String DELETE_SYMBOL = "Suppression";


	
	public static Table_database createConstant(String name) {
		return new Table_database(name);
	}



	public static CommandArchetype createOperation(String type, ExecutionTree left, ExecutionTree right) throws IllegalArgumentException {
		
	
			switch (type) {
			case JOIN_SYMBOL:
				return new CommandJointJOIN(left, right);
			case SELECT_SYMBOL:
				return new CommandProjectionSELECT(left, right);
			case WHERE_SYMBOL:
				return new CommandSelectionWHERE(left, right);
			
			default:
				throw new IllegalArgumentException("Unknown operation type : " + type);
			}
		}
	}




