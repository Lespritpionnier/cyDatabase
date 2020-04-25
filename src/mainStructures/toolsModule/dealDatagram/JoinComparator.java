package mainStructures.toolsModule.dealDatagram;

import mainStructures.dataFramework.RowTable;
import mainStructures.dataFramework.TableArchetype;
/**
 * Service for Joint-JOIN
 * This class only have a static method,
 * 	which means we don't need to "new" it,
 * 		which is good things for our program
 */
public class JoinComparator {

	public static TableArchetype goWork(String key, TableArchetype tab1, TableArchetype tab2) {
		//System.out.println(key);
		//System.out.println(tab2.getKeyName());
		if(key.equals(tab2.getKeyName())) {
			for (RowTable row : tab1) {
				RowTable rowAdded = tab2.get(Integer.parseInt(row.get(key).getData()) - 1);
				row.putAll(rowAdded);
			}

//			String[] tits = new String[tab1.getTitle().length+tab2.getTitle().length];
//	        System.arraycopy(tab1.getTitle(),0,tits,0,tab1.getTitle().length);
//	        System.arraycopy(tab2.getTitle(),0,tits,tab1.getTitle().length-1,tab2.getTitle().length);
//	        tab1.setTitle(tits);
//	        System.out.println(tits);
	        
	        String[]after = new String[tab1.getTitle().length+tab2.getTitle().length];
	       // System.arraycopy(tab1.getTitle(),0,after,0,tab1.getTitle().length);
	        //System.arraycopy(tab2.getTitle(),0,after,tab1.getTitle().length,tab2.getTitle().length);
	        tab1.setTitle(after);
	        //System.out.println(after);
		}
		return tab1;
	}
}
