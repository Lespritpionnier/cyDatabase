package mainStructures.unitStockpile;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;

import mainStructures.dataFramework.TableDatabase;

/**
 * Database is a space of Table, like all SGBD
 * For this software, we only allow 1 Database exist
 */

public class CyDatabase implements Serializable {
	private static final long serialVersionUID = 1L;



	private HashMap<String, TableDatabase> myTables = new HashMap<String, TableDatabase>();

    public void addTable (TableDatabase newTable) {
        myTables.put(newTable.getName(),newTable);
    }
    public TableDatabase getTable(String tableName){
        return myTables.get(tableName);
    }

	public HashMap<String, TableDatabase> getMyTables() {
		return myTables;
	}

	public void serializationSave(String fileName) {
		ObjectOutputStream stream;
		try {
			stream = new ObjectOutputStream(new FileOutputStream(fileName));
			
			Collection<TableDatabase> values = myTables.values();
			for (TableDatabase table : values) {
				stream.writeObject(table);
			}
			stream.close();
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	public void serializationRead(String fileName) {
		try {
			ObjectInputStream stream = new ObjectInputStream(new FileInputStream(fileName));
			TableDatabase table = null;
			while ((table = (TableDatabase) stream.readObject()) != null) {
				this.addTable(table);
			}
			stream.close();
		} catch (EOFException e) {
			System.out.println("End of file reading");
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
	
	@Override
	public String toString() {
		return "CyDatabase [myTables=" + myTables + "]";
	}
}
