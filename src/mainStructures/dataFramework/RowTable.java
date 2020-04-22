package mainStructures.dataFramework;

import java.util.LinkedHashMap;

/**
 * This is the Row of the Tables of this SGBD!
 * 	It extends directly LinkedHashMap<String, ItemRow>
 * 	which is a HashMap who can memory the rank of the elements be putting in
 */

public class RowTable extends LinkedHashMap<String, ItemRow>{

	private static final long serialVersionUID = 1L;

    	
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


