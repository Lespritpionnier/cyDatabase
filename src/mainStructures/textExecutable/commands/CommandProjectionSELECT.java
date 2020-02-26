package mainStructures.textExecutable.commands;

import mainStructures.dataFramework.dataDetails.DataArchetype;
import mainStructures.dataFramework.Table_database;
import mainStructures.textExecutable.ExecutionTree;
import mainStructures.toolsModule.pairVisitor.TreeVisitor;

import java.util.ArrayList;

public class CommandProjectionSELECT extends CommandArchetype {
    private String orderBY; //Name of the column.
    private boolean ifDISTINCT = false;
    private ArrayList<String> dataWanted = new ArrayList<>();

    public CommandProjectionSELECT(ArrayList<String> dataWanted) {
        super();
        this.dataWanted = dataWanted;
    }

    /**
     * Those METHODS below are made before, maybe WRONG or MOUCHE
     * DONT FORGET the situation of "SUM, AVG, MIN, MAX, COUNT"
     *                              (Only one syntax to stock)
     * @param ifDISTINCT
     */

    public void setDistinct(boolean ifDISTINCT) {
        this.ifDISTINCT = ifDISTINCT;
    }










/*
    public int getCOUNT (String columnName, Table_database table){
        int count = 0;
        //TO DO
        return count;
    }
    public double getSUM (String columnName, Table_database table){
        double sum = 0;
        //TO DO
        return sum;
    }
    public double getAVG (String columnName, Table_database table){
        double numerator = getSUM(columnName, table);
        int denominator = getCOUNT(columnName, table);
        //Need to be better in performance
        return numerator/denominator;
    }
    public DataArchetype getMAX (String columnName, Table_database table){
        //Need a confirmation of the returning type
    }
    public DataArchetype getMIN (String columnName, Table_database table){
        //Need a confirmation of the returning type (ALL ABOVE)
    }
*/

    @Override
    public ExecutionTree getLeft() {
        return null;
    }

    @Override
    public ExecutionTree getRight() {
        return null;
    }

    @Override
    public <T> T accept(TreeVisitor<T> visitor) {
        return null;
    }
}
