package mainStructures.toolsModule.makeAnalysis.textBoxes;

import mainStructures.dataFramework.Table_warehouse;
import mainStructures.textExecutable.ExecutionTree;

import java.util.ArrayList;

public class BoxFROM implements BoxArchetype{
    String tableName;
    public BoxFROM(String tableName) {
        this.tableName = tableName;
    }

    @Override
    public ExecutionTree makeNode() {
        return new Table_warehouse(tableName);
    }
}
