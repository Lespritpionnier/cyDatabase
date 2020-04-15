package mainStructures.toolsModule.dealDatagram;

import java.util.ArrayList;
import java.util.Iterator;

import mainStructures.dataFramework.RowTable;
import mainStructures.dataFramework.TableDatabase;
import mainStructures.dataFramework.itemTypes.DataBit;
import mainStructures.dataFramework.itemTypes.DataNumber;
import mainStructures.dataFramework.itemTypes.DataText;
import mainStructures.dataFramework.itemTypes.KeyForeign;
import mainStructures.textCommands.nodesPart.ExecutionTree;

public class WhereFilter {
	
	public static TableDatabase goWork(ArrayList<String> pre, TableDatabase tab) {
		
		Iterator<String> iterator = pre.iterator();
		while (iterator.hasNext()) {
			String who = iterator.next();
				int knife = who.indexOf(".")+1;
				who = who.substring(knife, who.length());
//System.out.println("WHO "+ who);
			String how = iterator.next();
			String when = iterator.next();
//System.out.println(when+"Wowen "+ how);
	        switch (how){
	            case ">": {
	            	Iterator<RowTable> iter = tab.iterator();
	            	while (iter.hasNext()) { 
	            		RowTable now = iter.next();
	            		if(now.get(who).compareTo(when)<=0) {
	            			iter.remove();
	            		}
	            	}
	                break;
	            }
	            case ">=": {
	            	Iterator<RowTable> iter = tab.iterator();
	            	while (iter.hasNext()) {
	            		RowTable now = iter.next();
	            		if(now.get(who).compareTo(when)<0) {
	            			System.out.println(now.get(who));
	            			iter.remove();
	            		}
	            	}
	                break;
	            }
	            case "<": {
	                
	                break;
	            }
	            case "<=": {
	               
	                break;
	            }
	            case "=": {
	            	Iterator<RowTable> iter = tab.iterator();
	            	while (iter.hasNext()) {
	            		RowTable now = iter.next();
	            		if(!now.get(who).getData().equals(when)) {
	            			System.out.println(now.get(who));
	            			iter.remove();
	            		}
	            	}
	                break;
	            }
	            case "<>": {
		               
	                break;
	            }
	        }
		}
		
		return tab;
//System.out.println("ARE YOU  WORKING "+key);
				
			}
}
