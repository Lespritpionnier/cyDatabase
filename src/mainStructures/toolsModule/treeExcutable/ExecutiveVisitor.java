package mainStructures.toolsModule.treeExcutable;

import mainStructures.toolsModule.dealDatagram.ZonedData;
import mainStructures.dataFramework.TableArchetype;
import mainStructures.dataFramework.TableDatabase;
import mainStructures.nodeCommand.CommandJointJOIN;
import mainStructures.nodeCommand.CommandProjectionSELECT;
import mainStructures.nodeCommand.CommandSelectionWHERE;
import mainStructures.toolsModule.dealDatagram.JoinComparator;
import mainStructures.toolsModule.dealDatagram.SelectProjector;
import mainStructures.toolsModule.dealDatagram.WhereFilter;

public class ExecutiveVisitor implements ParsingVisitor<TableArchetype>{

	@Override
	public TableArchetype visit(CommandProjectionSELECT node) {
		TableArchetype tab = node.getRight().accept(this);
		return SelectProjector.goWork(node.getDataWanted(), tab);
	}

	@Override
	public TableArchetype visit(CommandSelectionWHERE node) {
		TableArchetype tab = node.getRight().accept(this);
		return WhereFilter.goWork(node.getPreConditions(), tab);
	}

	@Override
	public TableArchetype visit(CommandJointJOIN node) {
		TableArchetype tab1 = node.getLeft().accept(this);
//System.out.println("TB1 in V "+tab1);
		TableArchetype tab2 = node.getRight().accept(this);
//System.out.println("TB2 in V "+tab2);
		return JoinComparator.goWork(node.getCondition(), tab1, tab2);
	}

	@Override
	public TableArchetype visit(TableDatabase node) {
		return node.toVirtual();
	}

}
