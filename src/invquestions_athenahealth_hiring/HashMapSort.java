/*
 * Copyright (c) 2018 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */

package invquestions_athenahealth_hiring;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 
 * @author ramveersingh
 */
public class HashMapSort {

	public static void main(String args[]) {
		   Map<String, Integer> map = new HashMap<String, Integer>();
	        map.put("javabasic", 20);
	        map.put("C++", 45);
	        map.put("Java2Novice", 2);
	        map.put("Unix", 67);
	        map.put("MAC", 26);
	        map.put("Why this kolavari", 93);
	        System.out.println("before : "+map.toString());
	        sortMapByValues(map);
	        //System.out.println("After : "+map.toString());
	}

	/**
	 * 
	 */
	private static void sortMapByValues(Map<String ,Integer> map) {
		Set<Entry<String,Integer>> set = map.entrySet();
		List<Entry<String,Integer>> list = new ArrayList<>(set);
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>(){
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2){
				return o1.getValue().compareTo(o2.getValue());
			}
			
		});
		for(Entry<String,Integer> e: list){
			System.out.println("Key: "+e.getKey()+"value: "+e.getValue());
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
