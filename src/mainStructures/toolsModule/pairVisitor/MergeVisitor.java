package mainStructures.toolsModule.pairVisitor;

import mainStructures.dataFramework.Table_database;
import mainStructures.dataFramework.Table_warehouse;
import mainStructures.textExecutable.commands.CommandJointJOIN;

public class MergeVisitor implements TableVisitor {
   
	
	@Override
    
    
    public Table_warehouse visit(Table_warehouse tableArray) {
        return tableArray;
    }

    @Override
    public Table_warehouse visit(Table_database tableList) {
      //  Table_warehouse table_convert = new Table_warehouse();
        //TODO
        return null;
    }

    public Table_warehouse visit(CommandJointJOIN node) {
        //Table_warehouse table_merge = new Table_warehouse();
        //TODO
        return null;
    }

	
  
}