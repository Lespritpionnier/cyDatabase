package mainStructures.unitStockpile;


import java.io.*;
import java.util.LinkedList;
import java.util.Random;

public class  StatusAltering {
    private LinkedList<String> alteration = new LinkedList<>();
    private int cursor = 0;
    private int sizeMax = 5;
    private boolean peek;

    public StatusAltering() {
        String wesh="abcdefghijklmnopqrstuvwxyz";
        Random random=new Random();
        StringBuilder filename = new StringBuilder();
        for (int j=0; j<sizeMax; j++){
            for(int i=0;i<6;i++){
                int number=random.nextInt(26);
                filename.append(wesh.charAt(number));
            }
            alteration.add(filename.toString());
            filename.delete(0,5);
        }
        peek = false;
    }

    public void markStatus(CyDatabase status) {
        if (cursor==sizeMax){
            String tem = alteration.pollFirst();
            saveStatus(status,tem);
            alteration.add(tem);
        }else {
            saveStatus(status, alteration.get(++cursor));
            peek = false;
        }
    }

    public void saveStatus(CyDatabase status, String fileName) {
        try {
            ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(fileName));
            stream.writeObject(status);
            stream.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
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
        if (cursor<sizeMax)
            return readStatus(alteration.get(++cursor));
        else return null;
    }
}
