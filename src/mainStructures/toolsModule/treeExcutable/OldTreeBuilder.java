package mainStructures.toolsModule.treeExcutable;

import java.util.ArrayList;
import java.util.Stack;


import faceGraphical.showTree.NodeGraphical;
import mainStructures.dataFramework.TableDatabase;
import mainStructures.textCommands.nodesPart.CommandJointJOIN;
import mainStructures.textCommands.nodesPart.CommandArchetypeNode;
import mainStructures.textCommands.nodesPart.CommandProjectionSELECT;
import mainStructures.textCommands.nodesPart.CommandSelectionWHERE;
import mainStructures.textCommands.nodesPart.ExecutionTree;

public class OldTreeBuilder {
    private ExecutionTree root;
    private ArrayList<ExecutionTree> stocking= new ArrayList<ExecutionTree>();
    
    
    public OldTreeBuilder() {
    	
    }
    
    public void addAll(ArrayList<ExecutionTree> list) {
    	stocking.addAll(list);
    }
    
   
    
    public void add(ExecutionTree node) {
    			stocking.add(node);
    }
    
  
    public ArrayList<ExecutionTree> getStocking(){
    	return stocking;
    }

    public Class<? extends Object> makeTree(ExecutionTree node){
		return ((Object) node).getClass();   
    } 
    
    public String getName(ExecutionTree node) {
    	OldTreeBuilder tree= new OldTreeBuilder();
    	String name;
    	Class<? extends Object> test;
    	test=tree.makeTree(node);
    	name=test.getName();    	
    	int pos = name.lastIndexOf(".");
    	if (pos > -1) {
    		return name.substring(pos+1);
    	} else {
		return name;
    	}
    }
    
 
   /*public ExecutionTree buildTree(ArrayList<ExecutionTree> input) {
    	Stack<ExecutionTree> stack = new Stack<ExecutionTree>();
    	Stack<String> car = new Stack<String>();
    	String result="";
    	ExecutionTree root1=null;
		ExecutionTree root2=null;
		ExecutionTree root3=null;
		ExecutionTree root4=null;
    	
    	for (int index = 0; index < input.size(); index++) {
    		
    		String currentChar = this.getName(input.get(index));
    		ExecutionTree operand = null;
    	
    		
    		if(isCommandProj(currentChar)) {
    			root1= NodeGraphical.createOperation(currentChar, root2, null);
    			result+=currentChar;
    		}
    		

    		else if(isCommandSelection(currentChar)) {
    			root2= NodeGraphical.createOperation(currentChar, root3, null);
    		}
    		

    		else if(isCommandJoin(currentChar)) {
    			root3= NodeGraphical.createOperation(currentChar, root4, root4);
    			result+=currentChar;
    		}
    		
    		else if(isTable(currentChar)) {
    			root4= NodeGraphical.createConstant(currentChar);
    			result+=currentChar;
    			
    		}
    		
    		
			}
    		root4= NodeGraphical.createConstant("TabLe_database");

    		root3= NodeGraphical.createOperation("CommandJointJOIN", root4, root4);
    		//System.out.println(root3);
    		root2= NodeGraphical.createOperation("CommandSelectionWHERE", root3, null);
    		//System.out.println(root2);
    		root1= NodeGraphical.createOperation("CommandProjectionSELECT", root2, null);
		
    	
    		//System.out.println(root1);
    		return root1;
    	
    	}*/
    	
    	
   
   
   
   
   public ExecutionTree buildTree1(ArrayList<ExecutionTree> input) {
	   Stack<ExecutionTree> stack = new Stack<ExecutionTree>();
	   String formula=""; 
	   final String SEPARATEUR = " ";

		String constantValue = "";
		String variableName = "";
		
		for (int index = 0; index < input.size(); index++) {
				formula+=(this.getName(input.get(index))+" ");
				
				
		}
	
		
		
		String tab[]=formula.split(SEPARATEUR); 
		
		
		if(tab[0].equals("CommandProjectionSELECT")) {
			CommandArchetypeNode operation2= NodeGraphical.createOperation(
				tab[0], null, null);
			stack.push(operation2);
   		}
		  
		  
		if(tab[1].equals("CommandSelectionWHERE")) {
			CommandArchetypeNode operation1 = NodeGraphical.createOperation(
				tab[1], null, null);
			stack.push(operation1);
		}
	
		
		for (int index = 2; index <tab.length; index++) {
			// The current char in the formula to process
			String currentChar=tab[index];
			
			

			if (isTable(currentChar)) {
				// Verify if it is the end of the formula or the end of the
				// constant chain / variable chain.
				boolean end = ((index + 1) == tab.length)
						|| (isCommands(tab[index]));
				System.out.println("44444444444444444444");

				ExecutionTree operand = null;
				//if (isTable(currentChar)) {
					constantValue += currentChar;
					
						System.out.println("16777777777777777777777");
						// All numbers are gathered, create the constant
						operand =NodeGraphical.createConstant(constantValue);
						System.out.println(operand.getClass()+" 1700000000000000000000000000000000");
						//stack.push(operand);
						constantValue = "";
						System.out.println("333");
					
						//	} 
				
				if(end) {
					if (stack.isEmpty()) {
						// This is the case at beginning.
						stack.push(operand);
					} else {
						ExecutionTree peek = stack.peek();
						System.out.println(peek+"peek182222222222222222222");
						if (peek instanceof CommandJointJOIN) {
							((CommandJointJOIN) peek).setRight(operand);
						} else {
							stack.push(operand);
						}
					}
				}
				
			} else {
				
				//ExecutionTree operand = NodeGraphical.createConstant(currentChar);
				//stack.push(operand);
				//System.out.println(stack);
				
				// We need two different treatments for * and +/-
				if (currentChar.equals("CommandJointJOIN")) {
					// Create the * with the existing left operand.
					// The right operand will be null for the moment.
					ExecutionTree pop = stack.pop();
					System.out.println("yessssssssss"+stack.pop());
					CommandArchetypeNode operation = NodeGraphical.createOperation(
							currentChar, pop, null);
					System.out.println("noooooo"+operation);
					System.out.println("noooooo"+operation.getLeft());
					stack.push(operation);
				} else {
					//System.out.println(stack);
					// Process operations addition(+) or subtraction(-).
					
						ExecutionTree leftOperand = stack.pop();
						System.out.println("noo"+stack.pop());
						CommandArchetypeNode operation =NodeGraphical.createOperation(
								currentChar, leftOperand, null);
						

						stack.push(operation);
						
					
				}
			}
			System.out.println("214"+stack);
		}
		
		

		// The last step for merge the two arithmetic operations.
		if (stack.size() == 2) {
			ExecutionTree rightOperand = stack.pop();
			CommandArchetypeNode operation = (CommandArchetypeNode) stack.peek();
			operation.setRight(rightOperand);
			System.out.println("228noooooo"+operation.getRight());
		}

		// Return the root of the tree (the root IS the tree).
		//System.out.println(stack.get(0).getLeft().getClass());
		System.out.println(stack);
		return stack.pop();
   	}
    	
    	
    	
    public String relationnel(ArrayList<ExecutionTree> input)	{
    	
    	
    	Stack<String> stack1= new Stack<String>();

    	Stack<String> stack2= new Stack<String>();
    	String result="";
    	
    	
    	
    	
    	for (int index = 0; index < input.size(); index++) {
    		
    		String currentChar = this.getName(input.get(index));
    	
    	
    		
    		if(isCommandProj(currentChar)) {
    			
    			result+=currentChar+"( ";
    			stack2.push(" )");
  
    			
    		}
    		
    		else if(isCommandSelection(currentChar)) {
    			
    			result+=currentChar+"( ";
    			stack2.push(" )"); 
    		}

    		else if(isCommandJoin(currentChar)) {
    			String a= this.getName(input.get(index-1));
    			String b= this.getName(input.get(index+1));
    			result+="("+a+" "+currentChar+" "+b+" )";
    			
    		
    		}
    		
    		
    	
    	}
    	
    	while(!stack2.isEmpty()) {
    		result+=stack2.pop();
    	}
    	return result+="\n";
    	   	
    	
    }

 
    
   public ExecutionTree treeBuild3(ArrayList<ExecutionTree> input) {
	   Stack<ExecutionTree> stack = new Stack<ExecutionTree>();
	   String formula=""; 
	   final String SEPARATEUR = " ";

		String constantValue = "";
		String variableName = "";
		
		for (int index = 0; index < input.size(); index++) {
				formula+=(this.getName(input.get(index))+" ");
				
				
		}
	
		String tab[]=formula.split(SEPARATEUR); 
		
		
		TableDatabase operation2= NodeGraphical.createConstant(tab[4]);
		TableDatabase operation3= NodeGraphical.createConstant(tab[2]);
		
		CommandJointJOIN operation1= (CommandJointJOIN) NodeGraphical.createOperation(
				tab[3], operation2, operation3);
		

		CommandSelectionWHERE operation4= (CommandSelectionWHERE) NodeGraphical.createOperation(
				tab[1], operation1, null);
		
		

		CommandProjectionSELECT operation5= (CommandProjectionSELECT) NodeGraphical.createOperation(
				tab[0], operation1, null);
		
		
	   
	   
	   return operation5;
   }
    
    
   
   

	private boolean isCommands(String value) {
		return value.equals("CommandArrangementORDER") || value.equals("CommandJointJOIN") || value.equals("CommandJointJOIN") 
				|| value.equals("CommandModificationSET") 
				|| value.equals("CommandProjectionSELECT") || value.equals("CommandRemovingDELETE") || value.equals("CommandSelectionWHERE"); 
				
	}
	
	private boolean isCommandJoin(String value) {
		return  value.equals("CommandJointJOIN"); 
				
	}
	
	private boolean isCommandProj(String value) {
		return  value.equals("CommandProjectionSELECT"); 
				
	}
	
	private boolean isCommandSelection(String value) {
		return  value.equals("CommandSelectionWHERE"); 
				
	}
	

	private boolean isTable(String value) {
		return !isCommands(value);
	}
    
}
