/*
 * Copyright (c) 2018 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */

package gfg.amazon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * 
 * @author ramveersingh
 */
public class Hierarcy {

	private static Stack<Character> stack = new Stack<>();
	public static void main(String args[]) {
//		/**
//		 * 1: 3, 4, 5 
//		 * 5: 6,7,8,9 
//		 * 4: 10,12,90
//		 * 
//		 */
//		List<Integer> l1 = new ArrayList<>();
//		l1.add(3);
//		l1.add(4);
//		l1.add(5);
//		List<Integer> l5 = new ArrayList<>();
//		l5.add(6);
//		l5.add(7);
//		l5.add(8);
//		l5.add(9);
//		List<Integer> l4 = new ArrayList<>();
//		l4.add(10);
//		l4.add(12);
//		l4.add(90);
//		Map<Integer, List<Integer>> map = new HashMap<>();
//		map.put(1, l1);
//		map.put(5, l5);
//		map.put(4, l4);
//		System.out.println(getAttendee(map, 1).toString());
//		 int arr[] = { 4,8,5,2,4};
//	        int size =5;
//	        int k = 4;
//	        int ans = calculateMaxSumLength(arr, size, k);
//	        System.out.println("Max Length :: " + ans);
		 Integer i1 = 10; int i2 = 10; 
		 inc(i1); 
		 inc(i2); 
		 System.out.println(i1); System.out.println(i2);
	}
	public static void inc(Integer input)
	{ input = input+10; 
	}
	
	private static int calculateMaxSumLength(int arr[], int n, int k) {
        int ans = 0; 
        int count = 0;
        int flag = 0;
        for (int i = 0; i < n;) {
            count = 0;
            flag = 0;
            while (i < n && arr[i] <= k) {
                count++;
                if (arr[i] == k)
                    flag = 1;
                i++;
            }
            if (flag == 1)
                ans += count;
            while (i < n && arr[i] > k)
                i++;
        }
        return ans;
    }

	
	
	private static List<Integer> getAttendee(Map<Integer, List<Integer>> map, Integer id) {
		List<Integer> list = map.get(id);
		List<Integer> l = new ArrayList<>();
		l.addAll(list);
		if (list.size() == 0) {
			return list;
		}
		Iterator<Integer> itr = list.iterator();
		while (itr.hasNext()) {
			Integer key = itr.next();
			if (map.get(key) != null) {
				l.addAll(map.get(key));
			}
		}
		return l;
	}

}
