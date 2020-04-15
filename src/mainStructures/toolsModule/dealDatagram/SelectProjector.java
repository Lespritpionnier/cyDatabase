package mainStructures.toolsModule.dealDatagram;

import java.util.ArrayList;

import mainStructures.dataFramework.TableArchetype;

public class SelectProjector {

	public static TableArchetype goWork(ArrayList<String> dataWanted, TableArchetype tab) {
//System.out.println(dataWanted);
		switch (dataWanted.get(0)) {
			case "*":
				return tab;

			case "DISTINCT":
				return tab;

			case "MAX":

				return tab;

			case "AVG":
				return tab;
		}

		String[] title = new String[dataWanted.size()];
		dataWanted.toArray(title);
		tab.setTitle(title);
//System.out.println(tab.getTitle());
		return tab;
	}
}
