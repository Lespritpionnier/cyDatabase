package mainStructures.dataFramework.dataDetails;

import mainStructures.dataFramework.Item_row;
import mainStructures.dataFramework.exceptions.WrongDataTypeException;

public class DataDate extends Item_row {

	
	public DataDate(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean checkTypeCorrect(DataArchetype item) throws WrongDataTypeException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void setData(DataArchetype item) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean equals(DataArchetype item) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
