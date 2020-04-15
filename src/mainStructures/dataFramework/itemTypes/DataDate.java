package mainStructures.dataFramework.itemTypes;

import mainStructures.dataFramework.ItemRow;

public class DataDate implements ItemRow {
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
	public String getData() {
		// TODO Auto-generated method stub
		return data;
	}


}
