package mainStructures.toolsModule.treeExcutable;

import mainStructures.dataFramework.TableDatabase;
import mainStructures.textCommands.nodesPart.*;

public interface ParsingVisitor<T> {

    T visit(CommandProjectionSELECT node);

    T visit(CommandSelectionWHERE node);

    T visit(CommandJointJOIN node);

    T visit(TableDatabase node);

}
