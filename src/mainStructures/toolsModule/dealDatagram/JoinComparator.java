package mainStructures.toolsModule.dealDatagram;

import java.util.Iterator;

import mainStructures.dataFramework.RowTable;
import mainStructures.dataFramework.TableDatabase;

public class JoinComparator {

	public static TableDatabase goWork(String key, TableDatabase tab1, TableDatabase tab2) {
//System.out.println("ARE YOU  WORKING "+key);
		if(key.equals(tab2.getKeyName())) {
			Iterator<RowTable> iterator = tab1.iterator();
			while (iterator.hasNext()) {
				RowTable row = iterator.next();
//System.out.println(row.get(key));
				RowTable rowAdded = tab2.get(Integer.valueOf(row.get(key).getData())-1);
				row.putAll(rowAdded);
			}
		}
		return tab1;
	}



}
