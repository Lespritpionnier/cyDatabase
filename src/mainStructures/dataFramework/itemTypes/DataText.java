package mainStructures.dataFramework.itemTypes;

import mainStructures.dataFramework.ItemRow;

public class DataText implements ItemRow {
    private String data;

    public DataText(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

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
