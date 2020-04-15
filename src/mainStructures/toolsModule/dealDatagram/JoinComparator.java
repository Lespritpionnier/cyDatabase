package mainStructures.toolsModule.dealDatagram;

import java.util.Iterator;

import mainStructures.dataFramework.RowTable;
import mainStructures.dataFramework.TableArchetype;

public class JoinComparator {

	public static TableArchetype goWork(String key, TableArchetype tab1, TableArchetype tab2) {
//System.out.println("ARE YOU  WORKING "+key);
		if(key.equals(tab2.getKeyName())) {
			for (RowTable row : tab1) {
				//System.out.println(row.get(key));
				RowTable rowAdded = tab2.get(Integer.parseInt(row.get(key).getData()) - 1);
				row.putAll(rowAdded);
			}
		}
		return tab1;
	}
}
