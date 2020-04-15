package mainStructures.dataFramework;

import java.util.ArrayList;

public abstract class TableArchetype extends ArrayList<RowTable> {
    protected String[] title;
    protected String tableName;


    public String[] getTitle() {
        return title;
    }
    public void setTitle(String[] title) {
//System.out.println(title[2]);
        this.title = title;
    }

    public String[][] toJTable (){
        String[][] jTable= new String[this.size()][title.length];
//System.out.println(this.size()+" and "+title.length);
        for(int i=0; i<this.size(); i++) {
            for(int j = 0; j<title.length; j++) {
                jTable[i][j]= this.get(i).get(title[j]).getData();
                System.out.println(this.get(i).get(title[j]).getData());
            }
        }
        return jTable;
    }

    public void setName(String tableName) { this.tableName=tableName; }
    public String getName() { return tableName; }
}
