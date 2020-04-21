package mainStructures.unitStockpile;


import java.io.*;
import java.util.LinkedList;
import java.util.Random;
/**
 * This class is for saving the status by Serialization
 * The "undo" and "redo" are also base on Serialization
 */
public class  StatusAltering {
	private CyDatabase CyDB;
    private LinkedList<String> alteration = new LinkedList<>();
    private int cursor = 0;
    private int sizeMax = 7;
    private boolean peek;

    public StatusAltering(CyDatabase CyDB) {
    	this.CyDB = CyDB;
        String wesh="Good";
        StringBuilder filename = new StringBuilder();
        for (int j=0; j<sizeMax; j++){
            filename.append(wesh);
            alteration.add(filename.toString());
            filename.delete(2,4);
        }
System.out.println(alteration);
        peek = false;
    }

    public void markStatus() {
        if (cursor==sizeMax-1){
            String tem = alteration.pollFirst();
            saveStatus(tem);
            alteration.add(tem);
            peek = true;
        }else {
            saveStatus(alteration.get(cursor++));
            peek = false;
        }
        System.out.println(alteration);
    }

    public void saveStatus(String fileName) {
        try {
            ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(fileName));
            stream.writeObject(CyDB);
            stream.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        System.out.println(alteration);
    }
    public CyDatabase readStatus(String fileName) {
        try {
            ObjectInputStream stream = new ObjectInputStream(new FileInputStream(fileName));
            CyDatabase status = (CyDatabase) stream.readObject();
            stream.close();
            return status;
        } catch (ClassNotFoundException | IOException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }


    public CyDatabase undoStatus() {
        if (cursor!=0)
            return readStatus(alteration.get(--cursor));
        else return null;
    }
    public CyDatabase redoStatus() {
        if (cursor<sizeMax||peek)
            return readStatus(alteration.get(++cursor));
        else return null;
    }
}
