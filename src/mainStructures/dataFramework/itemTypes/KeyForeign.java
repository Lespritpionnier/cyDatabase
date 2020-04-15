package mainStructures.dataFramework.itemTypes;

public class KeyForeign extends KeyPrimary {
    /*
    String aimedTable;
    String aimedKey;
     */

    public KeyForeign(String data) {
        super(Long.parseLong(data));
    }
	@Override
	public void setData(String s) {
		super.data=Long.getLong(s);
	}
	@Override
	public String toString() {
		return "KeyForeign:{"  + getData() +'}';
	}
}
