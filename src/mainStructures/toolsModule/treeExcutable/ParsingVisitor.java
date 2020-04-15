package mainStructures.toolsModule.treeExcutable;

import mainStructures.dataFramework.TableDatabase;
import mainStructures.nodeCommand.CommandJointJOIN;
import mainStructures.nodeCommand.CommandProjectionSELECT;
import mainStructures.nodeCommand.CommandSelectionWHERE;

public interface ParsingVisitor<T> {

    T visit(CommandProjectionSELECT node);

    T visit(CommandSelectionWHERE node);

    T visit(CommandJointJOIN node);

    T visit(TableDatabase node);

}
