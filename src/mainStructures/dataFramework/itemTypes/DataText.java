package mainStructures.dataFramework.itemTypes;

import mainStructures.dataFramework.ItemRow;

/**
 * This is the type TEXT
 */

public class DataText implements ItemRow {

	private static final long serialVersionUID = 1L;
	private String data;

    public DataText(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    @Override
    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DataText{" + '\'' + data + '\'' + '}';
    }

	@Override
	public int compareTo(String s) {
		return data.compareTo(s);
	}


}
