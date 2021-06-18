package goldmansach;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MaxAvgStudents {

	public static void main(String args[]) {

		String s[][] = { { "jerry", "65" }, { "bob", "91" }, { "jerry", "23" }, { "Eric", "83" }, { "bob", "910" } };
		int maxAvg = 0;
		int studentIndex = 0;
		String studentName = "";
		for (int i = 0; i < s.length; i++) {
			String name = s[i][0];
			String avg = s[i][1];
			int avgScore = Integer.parseInt(avg);
			if (avgScore >= maxAvg) {
				maxAvg = avgScore;
				studentIndex = i;
				studentName = name;
			}
		}

		System.out.println("max avg....." + maxAvg);
		System.out.println("studentIndex....." + studentIndex);
		System.out.println("studentName..." + studentName);
		/**
		 * store in map
		 */

		Map<String, Integer> map = new HashMap<>();
		for (int j = 0; j < s.length; j++) {
			String name = s[j][0];
			int avg = Integer.parseInt(s[j][1]);
			if (map.containsKey(name)) {
				int avgFromMap = map.get(name);
				if (avgFromMap <= avg) {
					avgFromMap = avg;
					map.put(name, avgFromMap);
				}
			} else {
				map.put(name, avg);
			}
		}
		int maxAvgFromMap = 0;
		String nameFromMap = "";
		for(Entry<String,Integer> entry: map.entrySet()) 
		{
			String key = entry.getKey();
			int value = entry.getValue();
			if(value>=maxAvgFromMap) {
				maxAvgFromMap = value;
				nameFromMap = key;
			}
		}
		System.out.println(" avg from map....."+maxAvgFromMap);
		System.out.println(" nameFromMap from map....."+nameFromMap);
	}

}
