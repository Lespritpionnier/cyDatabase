package mainStructures.dataFramework.itemTypes;

/**
 * This is the type FOREIGN KEY
 */

public class KeyForeign extends KeyPrimary {

	private static final long serialVersionUID = 1L;
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
