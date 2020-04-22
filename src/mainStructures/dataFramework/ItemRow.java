package mainStructures.dataFramework;

import java.io.Serializable;
/**
 * This is the archetype-interface of Item (of data)!
 * 	It is serializable
 */


public interface ItemRow extends Serializable{
	void setData(String s);
	String getData();
	int compareTo(String s);

}
