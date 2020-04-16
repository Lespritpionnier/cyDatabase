package mainStructures.toolsModule.dealDatagram;

import java.util.ArrayList;

import mainStructures.dataFramework.TableArchetype;

public class SelectProjector {

	public static TableArchetype goWork(ArrayList<String> dataWanted, TableArchetype tab) {
//System.out.println(dataWanted);
		switch (dataWanted.get(0)) {
			case "*":
				return tab;
				
			case "SUM":
			
			case "AVG":
				
			case "MIN":

			case "MAX":
					
			case "COUNT":
				
			default:
				String[] title = new String[dataWanted.size()];
				dataWanted.toArray(title);
				tab.setTitle(title);
//System.out.println(tab.getTitle());
				return tab;
		}
	}
}
