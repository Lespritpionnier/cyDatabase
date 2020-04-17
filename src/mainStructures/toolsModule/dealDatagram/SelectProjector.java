package mainStructures.toolsModule.dealDatagram;

import java.util.ArrayList;
import java.util.Iterator;

import mainStructures.dataFramework.RowTable;
import mainStructures.dataFramework.TableArchetype;
import mainStructures.dataFramework.itemTypes.DataNumber;

public class SelectProjector {

	public static TableArchetype goWork(ArrayList<String> dataWanted, TableArchetype tab) {
//System.out.println(dataWanted);
		switch (dataWanted.get(0)) {

			case "*":
				return tab;


			case "SUM":
				ZonedData sum = new ZonedData("SUM_"+dataWanted.get(1),tab.getName());
				double add = 0.0;
				Iterator<RowTable> iter1 = tab.iterator();
				while (iterator.hasNext()){
					RowTable now = iter1.next();
					add+=Double.parseDouble(now.get(dataWanted.get(1)).getData());
				}
				DataNumber sum1 = new DataNumber(Double.toString(add));
				RowTable sum2 = new RowTable();
				sum2.put(dataWanted.get(1),sum1);
				sum.add(sum2);
				return sum;


			case "AVG":
				ZonedData avg = new ZonedData("AVG_"+dataWanted.get(1),tab.getName());
				double even = 0.0;
				int i=0;
				Iterator<RowTable> iter2 = tab.iterator();
				while (iterator.hasNext()){
					i++;
					RowTable now = iter2.next();
					even+=Double.parseDouble(now.get(dataWanted.get(1)).getData());
				}
				DataNumber avg1 = new DataNumber(Double.toString(even/i));
				RowTable avg2 = new RowTable();
				avg2.put(dataWanted.get(1),avg1);
				avg.add(avg2);
				return avg;


			case "MIN":
				ZonedData min = new ZonedData("MIN_"+dataWanted.get(1),tab.getName());
				double mini = 0.0;
				Iterator<RowTable> iter3 = tab.iterator();
				while (iterator.hasNext()){
					RowTable now = iter3.next();
					if (Double.parseDouble(now.get(dataWanted.get(1)).getData())<mini){
						mini = Double.parseDouble(now.get(dataWanted.get(1)).getData());
					}
				}
				DataNumber min1 = new DataNumber(Double.toString(mini));
				RowTable min2 = new RowTable();
				min2.put(dataWanted.get(1),min1);
				min.add(min2);
				return min;


			case "MAX":
				ZonedData max = new ZonedData("MAX_"+dataWanted.get(1),tab.getName());
				double big = 0.0;
				Iterator<RowTable> iter4 = tab.iterator();
				while (iterator.hasNext()){
					RowTable now = iter4.next();
					if (Double.parseDouble(now.get(dataWanted.get(1)).getData())>big){
						big = Double.parseDouble(now.get(dataWanted.get(1)).getData());
					}
				}
				DataNumber max1 = new DataNumber(Double.toString(big));
				RowTable max2 = new RowTable();
				max2.put(dataWanted.get(1),max1);
				max.add(max2);
				return max;


			case "COUNT":
				ZonedData count = new ZonedData("COUNT_"+dataWanted.get(1),tab.getName());
				int num = 0;
				Iterator<RowTable> iter5 = tab.iterator();
				while (iterator.hasNext()){
					num++;
				}
				DataNumber count1 = new DataNumber(Double.toString(num));
				RowTable count2 = new RowTable();
				count2.put(dataWanted.get(1),count1);
				count.add(count2);
				return count;


			default:
				String[] title = new String[dataWanted.size()];
				dataWanted.toArray(title);
				tab.setTitle(title);
				return tab;

		}
	}
}
