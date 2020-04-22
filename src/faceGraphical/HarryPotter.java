package faceGraphical;

import mainStructures.dataFramework.TableArchetype;
import mainStructures.toolsModule.textAnalysis.SyntaxHandling;
import mainStructures.unitStockpile.CyDatabase;

import java.util.Random;

/**
 * This class is for creating big data
 * 	which including some static method
 */
public class HarryPotter {
    public static TableArchetype magic1(CyDatabase myDB) {
        return new SyntaxHandling(myDB.getMyTables(),"CREATE TABLE tab1(" +
                "id_first AUTOINCREMENT, " +
                "id_second LONG, " +
                "number1 TEXT, " +
                "text1 TEXT, " +
                "PRIMARY KEY(id_first), " +
                "FOREIGN KEY(id_second) REFERENCES tab2(id_second);").makeNodes();
    }

    public static TableArchetype magic2(CyDatabase myDB) {
        String wesh="abcdefghijklmnopqrstuvwxyz";
        Random random=new Random();
        StringBuilder mess = new StringBuilder();
        int number=0;
        for (int j=0; j<sizeMax; j++){
            for(int i=0;i<6;i++){
                number=random.nextInt(26);
                mess.append(wesh.charAt(number));
            }
        }
        String pass = "INSERT INTO tab1 (id_second, number1, text1)" +
                "VALUES ( " + Integer.toString(random.nextInt(50)) +", " + Integer.toString(number) + ", "+mess.toString()+") ;";
       return new SyntaxHandling(myDB.getMyTables(),pass).makeNodes();
    }

    public static TableArchetype magic3(CyDatabase myDB) {
        return new SyntaxHandling(myDB.getMyTables(),"CREATE TABLE tab2(" +
                "id_second AUTOINCREMENT, " +
                "id_third LONG, " +
                "number2 TEXT, " +
                "text2 TEXT, " +
                "PRIMARY KEY(id_second ), " +
                "FOREIGN KEY(id_third) REFERENCES tab3(id_third);").makeNodes();
    }

    public static TableArchetype magic4(CyDatabase myDB) {
        String wesh="abcdefghijklmnopqrstuvwxyz";
        Random random=new Random();
        StringBuilder mess = new StringBuilder();
        int number=0;
        for (int j=0; j<sizeMax; j++){
            for(int i=0;i<6;i++){
                number=random.nextInt(26);
                mess.append(wesh.charAt(number));
            }
        }
        String pass = "INSERT INTO tab1 (id_third, number2, text2) " +
                "VALUES ( " + Integer.toString(random.nextInt(50)) +", " + Integer.toString(number) + ", "+mess.toString()+") ;";
        return new SyntaxHandling(myDB.getMyTables(),pass).makeNodes();
    }

    public static TableArchetype magic5(CyDatabase myDB) {
        return new SyntaxHandling(myDB.getMyTables(),"CREATE TABLE tab3( " +
                "id_third AUTOINCREMENT, " +
                "number3 TEXT, " +
                "text3 TEXT, " +
                "PRIMARY KEY(id_third)); ").makeNodes();
    }

    public static TableArchetype magic6(CyDatabase myDB) {
        String wesh="abcdefghijklmnopqrstuvwxyz";
        Random random=new Random();
        StringBuilder mess = new StringBuilder();
        int number=0;
        for (int j=0; j<sizeMax; j++){
            for(int i=0;i<6;i++){
                number=random.nextInt(26);
                mess.append(wesh.charAt(number));
            }
        }
        String pass = "INSERT INTO tab1 (number3, text3)" +
                "VALUES ( " + Integer.toString(number) + ", "+mess.toString()+") ;";
        return new SyntaxHandling(myDB.getMyTables(),pass).makeNodes();
    }
}