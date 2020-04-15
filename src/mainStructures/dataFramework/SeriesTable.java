package mainStructures.dataFramework;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class SeriesTable extends ArrayList<RowTable> {
	
	private String fromTable;
	private LinkedHashMap<String,String> infoDatatype;

	public SeriesTable(LinkedHashMap<String, String> infoDatatype, String tableName) {
		super();
		this.infoDatatype = infoDatatype;
		fromTable = tableName;
	}

}
