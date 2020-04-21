package mainStructures.dataFramework.itemTypes;

import mainStructures.dataFramework.ItemRow;

/**
 * This is the type Date
 */


public class DataDate implements ItemRow {

	private static final long serialVersionUID = 1L;
	private String data;

	@Override
	public int compareTo(String s) {
		return data.compareTo(s);
	}
    
    @Override
    public String toString() {
        return "DataDate{" + data + '\'' + '}';
    }

    public DataDate(String value) {
        data=value;
    }

    @Override
    public void setData(String s) {
        data=s;
    }

    @Override
	public String getData() {
		return data;
	}


}
