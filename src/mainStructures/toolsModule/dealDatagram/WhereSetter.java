package mainStructures.toolsModule.dealDatagram;

import mainStructures.dataFramework.RowTable;
import mainStructures.dataFramework.TableArchetype;
import mainStructures.dataFramework.TableDatabase;

import java.util.ArrayList;
import java.util.Iterator;

public class WhereSetter {
    public static TableArchetype doWork (TableDatabase tab, ArrayList<String>set, ArrayList<String> where){
        String who = set.get(0);
        int knife = who.indexOf(".")+1;
        who = who.substring(knife, who.length());
        String what = set.get(2);

        String when = where.get(0);
        knife = when.indexOf(".")+1;
        when = when.substring(knife, when.length());
        how = where.get(2);

        for (RowTable now : tab) {
            if (!now.get(when).getData().equals(how)) {
//System.out.println(now.get(when));
                now.get(who).setData(what);
            }
        }
        return tab;
    }
}
