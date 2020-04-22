package mainStructures.toolsModule.dealDatagram;

import mainStructures.dataFramework.RowTable;
import mainStructures.dataFramework.TableArchetype;
import mainStructures.dataFramework.TableDatabase;

import java.util.ArrayList;
import java.util.Iterator;
/**
 * Service for Motification-UPDATE
 * This class only have a static method,
 * 	which means we don't need to "new" it,
 * 		which is good things for our program
 */
public class WhereSetter {
    public static TableArchetype doWork (TableDatabase tab, ArrayList<String>set, ArrayList<String> where){
        String who = set.get(0);
        int knife = who.indexOf(".")+1;
        who = who.substring(knife, who.length());
        String what = set.get(2);
        
     System.out.println("WHO "+ who);
     System.out.println("TAB "+ tab);
     
        String when = where.get(0);
        knife = when.indexOf(".")+1;
        when = when.substring(knife, when.length());
        String how = where.get(2);
        System.out.println(when + how + what);
        System.out.println(set);
        System.out.println(where);
        
        Iterator<RowTable> iter = tab.iterator();
        while (iter.hasNext()) {
        	RowTable now = iter.next();
        	now.get(who).setData(what);
        	System.out.println(now.get(when));
    		if(!now.get(when).getData().equals(how)) {
            }
        }
        return tab;
    }
}
