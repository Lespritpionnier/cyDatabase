package mainStructures.dataFramework.itemTypes;

import mainStructures.dataFramework.ItemRow;
/**
 * This is the type PRIMARY KEY
 */

public class KeyPrimary implements ItemRow {

	private static final long serialVersionUID = 1L;
	protected Long data;

    public KeyPrimary(long value) {
        data=value;
    }

    @Override
    public void setData(String s) {

    }

    public String getData() {
        return data.toString();
    }
    
    public String toString() {
        return "KeyPrimary:{"  + data +'}';
    }
  
	@Override
	public int compareTo(String s) {
		return data.toString().compareTo(s);
	}
}
