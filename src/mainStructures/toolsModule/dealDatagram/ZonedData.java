package mainStructures.toolsModule.dealDatagram;

import mainStructures.dataFramework.RowTable;
import mainStructures.dataFramework.TableArchetype;

import java.util.ArrayList;

public class ZonedData extends TableArchetype {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ZonedData(String[] title, String tableName) {
		super.title = title;
		super.tableName = tableName;
	}
	public ZonedData(String one, String tableName) {
		String[] title = new String[1];
		title[0]=one;
		super.title = title;
		super.tableName = tableName;
	}




}
