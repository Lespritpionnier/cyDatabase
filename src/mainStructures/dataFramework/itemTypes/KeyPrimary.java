package mainStructures.dataFramework.itemTypes;

import mainStructures.dataFramework.ItemRow;
import mainStructures.dataFramework.exceptions.WrongDataTypeException;

public class KeyPrimary implements ItemRow {
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
   /*
    @Override
    public boolean checkTypeCorrect(DataArchetype item) throws WrongDataTypeException {
        return false;
    }

    @Override
    public void setData(DataArchetype item) {

    }

    @Override
    public boolean equals(DataArchetype item) {
        return false;
    }

 */

	@Override
	public int compareTo(String s) {
		return data.toString().compareTo(s);
	}
}
