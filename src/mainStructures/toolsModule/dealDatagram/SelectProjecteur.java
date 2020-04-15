package mainStructures.toolsModule.dealDatagram;

import java.util.ArrayList;
import java.util.Iterator;

import mainStructures.dataFramework.RowTable;
import mainStructures.dataFramework.TableDatabase;

public class SelectProjecteur {

	public static TableDatabase goWork(ArrayList<String> dataWanted, TableDatabase tab) {
//System.out.println(dataWanted);
		if(dataWanted.get(0).equals("*")) {
			return tab;
		}else {
			String [] title = new String[dataWanted.size()];
			dataWanted.toArray(title);
			tab.setTitle(title);
//System.out.println(tab.getTitle());
		}
		return tab;
	}
}
