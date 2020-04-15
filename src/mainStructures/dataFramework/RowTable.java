package mainStructures.dataFramework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class RowTable extends LinkedHashMap<String, ItemRow>{
    /**
     * The keys of this HashMap are the names of the columns in the table
     */
    	
    	@Override
        public ItemRow put(String key, ItemRow value) {
    		ItemRow newV = value;
            if (!containsKey(key)) {
            	return super.put(key, newV);
            }
			return null;
        }
    
    	
    }
    	
//    	@Override
//        public ItemRow put(String key, ItemRow value) {
//            return putVal(hash(key), key, value, true, true);
//        }
//        
    


//	public java.lang.String toString() {
//        Iterator<Entry<String, Item_row>> i = entrySet().iterator();
//        if (! i.hasNext())
//            return "???";
//        i.next();//Take off the first place
//        StringBuilder sb = new StringBuilder();
//        sb.append('(');
//        for (;;) {
//        	Entry<String, Item_row> e = i.next();
//        	String key = e.getKey();
//        	Item_row value = e.getValue();
//            sb.append(key);
//
//            if (! i.hasNext())
//                return sb.append(')').toString();
//            sb.append(", ");
//        }
//    }











/*
    public String[] getColumnsName(){
        String[] columnsName = new String[super.size()];
        return columnsName;
    }

 */

