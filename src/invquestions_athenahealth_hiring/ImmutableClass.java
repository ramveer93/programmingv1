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

import java.util.HashMap;
import java.util.Iterator;

/**
 * 
 * @author ramveersingh
 */
public final class ImmutableClass {

	private final int id;
	private final String name;
	private final HashMap<String, String> testMap;
	// public ImmutableClass(int i, String n, HashMap<String,String> hm){
	// System.out.println("Performing deep copy for object initialization");
	// this.id = i;
	// this.name = n;
	// this.testMap = hm;
	// }

	public ImmutableClass(int i, String n, HashMap<String, String> hm) {
		System.out.println("Performing deep copy for object initialization");
		this.id = i;
		this.name = n;
		HashMap<String, String> mp = new HashMap<>();
		Iterator<String> itr = hm.keySet().iterator();
		String key;
		while (itr.hasNext()) {
			key = itr.next();
			mp.put(key, hm.get(key));
		}
		this.testMap = mp;
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public HashMap<String, String> getTestMap() {
		 return this.testMap;
		//return (HashMap<String, String>) testMap.clone();
	}

	public static void main(String args[]) {
		int id = 10;
		String name = "Ramveer";
		HashMap<String, String> map = new HashMap<>();
		map.put("1", "one");
		map.put("2", "two");
		ImmutableClass ic = new ImmutableClass(id, name, map);
		System.out.println(name == ic.getName());
		System.out.println(id == ic.getId());
		System.out.println("name and id is : " + ic.getName() + " id: " + ic.getId());
		System.out.println("map    : " + ic.getTestMap());
		id = 123;
		name = "Tanu";
		map.put("3", "three");
		System.out.println("id after changing local : " + ic.getId());
		System.out.println("name after changing local : " + ic.getName());
		System.out.println("map after changing local : " + ic.getTestMap());

	}
}
