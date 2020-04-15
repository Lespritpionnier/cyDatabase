package mainStructures.toolsModule.makeAnalysis.comdAutomate;

import mainStructures.dataFramework.TableDatabase;
import mainStructures.textCommands.nodesPart.CommandJointJOIN;

import java.util.ArrayList;

public class BoxJOIN{
    private String choiceON ;

//    public BoxJOIN(String name){
//        super(name);
//        choiceON = null;
//    }

    public BoxJOIN() {
		// TODO Auto-generated constructor stub
	}

	public void addChoiceON(String choice) {
        choiceON=choice;
    }

    public CommandJointJOIN makeNode() {
        CommandJointJOIN join = new CommandJointJOIN();
        join.setCondition(choiceON);
        return join;
    }

	@Override
	public String toString() {
		return choiceON.toString();
	}
    


  /*!!!!!!!!!!!
    public BoxJOIN(ArrayList<ExecutionTree> nodes, StringTokenizer remain) {

        super(nodes, remain);
    }
  !!!!!!!!!!!*/

}
