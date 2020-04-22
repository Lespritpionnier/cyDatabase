package mainStructures.dataFramework.itemTypes;

import mainStructures.dataFramework.ItemRow;
/**
 * This is the type Number
 */

public class DataNumber implements ItemRow {

	private static final long serialVersionUID = 1L;
	private Double data;

    public DataNumber(String value) {
        data = Double.parseDouble(value);
    }

    public String getData() {
        return data.toString();
    }

    public void setData(Double data) {
        this.data = data;
    }
    
	@Override
	public int compareTo(String s) {
		return data.toString().compareTo(s);
	}
    @Override
    public void setData(String s) {
        data=Double.valueOf(s);
    }
    @Override
    public String toString() {
        return "DataNumber{" +
                "data=" + data +
                '}';
    }

}
