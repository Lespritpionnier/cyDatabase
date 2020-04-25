package mainStructures.toolsModule.dealDatagram;

import java.util.ArrayList;
import java.util.Iterator;

import mainStructures.dataFramework.RowTable;
import mainStructures.dataFramework.TableArchetype;
/**
 * Service for Suppression-DELECT
 * This class only have a static method,
 * 	which means we don't need to "new" it,
 * 		which is good things for our program
 */
public class WhereDropper {
	public static TableArchetype goWork(ArrayList<String> pre, TableArchetype tab) {
		Iterator<String> iterator = pre.iterator();
		while (iterator.hasNext()) {
			String who = iterator.next();
				int knife = who.indexOf(".")+1;
				who = who.substring(knife, who.length());
//System.out.println(pre);
			String how = iterator.next();
			String when = iterator.next();
			Iterator<RowTable> iter = tab.iterator();
	        switch (how){
	            case ">": {
	            	while (iter.hasNext()) { 
	            		RowTable now = iter.next();
	            		if(now.get(who).compareTo(when)>0) {
	            			iter.remove();
	            		}
	            	}
	                break;
	            }
	            case ">=": {
	            	while (iter.hasNext()) {
	            		RowTable now = iter.next();
	            		if(now.get(who).compareTo(when)>=0) {
	            			System.out.println(now.get(who));
	            			iter.remove();
	            		}
	            	}
	                break;
	            }
	            case "<": {
					while (iter.hasNext()) {
						RowTable now = iter.next();
						if(now.get(who).compareTo(when)<0) {
							System.out.println(now.get(who));
							iter.remove();
						}
					}
	                break;
	            }
	            case "<=": {
					while (iter.hasNext()) {
						RowTable now = iter.next();
						if(now.get(who).compareTo(when)<=0) {
							System.out.println(now.get(who));
							iter.remove();
						}
					}
	                break;
	            }
	            case "=": {
	            	while (iter.hasNext()) {
	            		RowTable now = iter.next();
	            		if(now.get(who).getData().equals(when)) {
	            			System.out.println(now.get(who));
	            			iter.remove();
	            		}
	            	}
	                break;
	            }
	            case "<>": {
					while (iter.hasNext()) {
						RowTable now = iter.next();
						if(!now.get(who).getData().equals(when)) {
							System.out.println(now.get(who));
							iter.remove();
						}
					}
	                break;
	            }
	        }
		}
		return tab;
	}
}
