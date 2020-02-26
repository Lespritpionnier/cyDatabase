package mainStructures.dataFramework; 
import mainStructures.textExecutable.ExecutionTree;
import mainStructures.toolsModule.pairVisitor.TreeVisitor;

import java.util.ArrayList;

public class Table_database extends TableArchetype implements ExecutionTree {
 //   private KeyPrimary keyCurrent;
    private ArrayList<Row_table> rows = new ArrayList<>();
    private ArrayList<String> columns = new ArrayList<>();

   public Table_database(String name) { super(name); }
   public Table_database(String name, ArrayList<Row_table> rows) {
      super(name);
      this.rows = rows;
   }

   public void addRow(){
        //TODO
    }
    public void addColumn(String name){
        //TODO
    }

   @Override
   public <T> T accept(TreeVisitor<T> visitor) {
      return null;
   }
}
