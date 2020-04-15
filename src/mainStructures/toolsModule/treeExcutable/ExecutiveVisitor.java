package mainStructures.toolsModule.treeExcutable;

import mainStructures.dataFramework.TableDatabase;
import mainStructures.textCommands.nodesPart.CommandJointJOIN;
import mainStructures.textCommands.nodesPart.CommandProjectionSELECT;
import mainStructures.textCommands.nodesPart.CommandSelectionWHERE;
import mainStructures.toolsModule.dealDatagram.JoinComparator;
import mainStructures.toolsModule.dealDatagram.SelectProjecteur;
import mainStructures.toolsModule.dealDatagram.WhereFilter;

public class ExecutiveVisitor implements ParsingVisitor<TableDatabase>{

	@Override
	public TableDatabase visit(CommandProjectionSELECT node) {
		TableDatabase tab = node.getRight().accept(this);
		return SelectProjecteur.goWork(node.getDataWanted(), tab);
	}

	@Override
	public TableDatabase visit(CommandSelectionWHERE node) {
		TableDatabase tab = node.getRight().accept(this);
		return WhereFilter.goWork(node.getPreConditions(), tab);
	}

	@Override
	public TableDatabase visit(CommandJointJOIN node) {
		TableDatabase tab1 = node.getLeft().accept(this);
//System.out.println("TB1 in V "+tab1);
		TableDatabase tab2 = node.getRight().accept(this);
//System.out.println("TB2 in V "+tab2);
		return JoinComparator.goWork(node.getCondition(), tab1, tab2);
	}

	@Override
	public TableDatabase visit(TableDatabase node) {
		return node;
	}

}
