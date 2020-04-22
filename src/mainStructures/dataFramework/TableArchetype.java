package mainStructures.dataFramework;

import java.util.ArrayList;

/**
 * This class extends directly an ArrayList<RowTable>
 * 	which is  because it mark the nature of it
 * 		of course also his children class
 */
public abstract class TableArchetype extends ArrayList<RowTable> {
	private static final long serialVersionUID = 1L;
	protected String[] title;
    protected String tableName;
    protected String primaryKey; 



    public String[][] toJTable (){
        String[][] jTable= new String[this.size()][title.length];
        for(int i=0; i<this.size(); i++) {
            for(int j = 0; j<title.length; j++) {
                jTable[i][j]= this.get(i).get(title[j]).getData();
            }
        }
        return jTable;
    }

    public String[] getTitle() {
    	return title;
    }
    public void setTitle(String[] title) {
    	this.title = title;
    }
    
    public String getKeyName() { return primaryKey; }
    public void setName(String tableName) { this.tableName=tableName; }
    public String getName() { return tableName; }
}
