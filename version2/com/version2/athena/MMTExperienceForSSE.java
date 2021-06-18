package com.version2.athena;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MMTExperienceForSSE {

	Map<Integer, Integer> map;
	ArrayList<Object> list;

	MMTExperienceForSSE() {
		map = new HashMap<Integer, Integer>();
		list = new ArrayList<>();
	}

	public static void main(String args[]) {
		MMTExperienceForSSE ss = new MMTExperienceForSSE();
		ss.add(10);
		ss.add(20);
		ss.add(30);
		ss.add(40);
		System.out.println("searching 30....." + ss.search(30));
		ss.remove(30);
		ss.add(50);
		System.out.println(ss.search(50));
		System.out.println(ss.getRandom());

	}

	// https://www.geeksforgeeks.org/design-a-data-structure-that-supports-insert-delete-search-and-getrandom-in-constant-time/
	// design a ds that support all insert , delete, search and getrandom in
	// constant time
	/**
	 * 
	 * @param number
	 * 
	 * 
	 * 
	 *               take an array and hashmap<Integer,integer>, key: element and
	 *               value will be index in array add: check if the element already
	 *               exists in map , if yes return nothing, if no add the element in
	 *               end of array also put the element in map as well with key as
	 *               that no and value as arr.size
	 */
	private void add(int number) {
		if (map.get(number) != null) {
			return;
		}
		int s = list.size();
		list.add(number);
		map.put(number, s);
	}

	/**
	 * 
	 * @param number Check if the number exists in map, if not return; else remove
	 *               the element from the map swag that element with the last
	 *               element of array and delete the last element in the array
	 * 
	 * 
	 */
	private void remove(int number) {
		if (map.get(number) == null) {
			return;
		}
		map.remove(number);
		int last = (int) list.get(list.size() - 1);
		last = number;
		number = last;
		list.remove(list.size() - 1);
		map.put(number, last);
	}

	private int search(int number) {
		return map.get(number);
	}

	private int getRandom() {
		Random rd = new Random();
		int nextRendom = rd.nextInt(list.size());
		return (int) list.get(nextRendom);

	}

}
