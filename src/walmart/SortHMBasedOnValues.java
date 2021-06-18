package walmart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

public class SortHMBasedOnValues {
	public static void main(String args[]) 
	{

		HashMap<String, Integer> hm = new HashMap<String, Integer>(); 
		  
        // enter data into hashmap 
        hm.put("Math", 98); 
        hm.put("Data Structure", 85); 
        hm.put("Database", 91); 
        hm.put("Java", 95); 
        hm.put("Operating System", 79); 
        hm.put("Networking", 80); 
        System.out.println("before sorting ..."+hm);
        HashMap<String,Integer> hhm = sortHashMapByValue(hm);
        System.out.println("after sorting ..."+hhm);
	}

	public static HashMap<String, Integer> sortHashMapByValue(HashMap<String, Integer> hm) {
		List<Entry<String, Integer>> list = new ArrayList<>(hm.entrySet());
		Collections.sort(list, new Comparator<Entry<String, Integer>>() {
			public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) {
				return e1.getValue().compareTo(e2.getValue());
			}
		});
		HashMap<String, Integer> temp = new LinkedHashMap<>();
		for (Entry<String, Integer> e : list) {
			temp.put(e.getKey(), e.getValue());
		}
		return temp;
	}

}
