package hackerearth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

class TestClass {
	public static void main(String args[]) throws Exception {
		// ma("aaabbacccd",3);
		// ma("aaabbacccbbbd",4);
		ma("aabbcd", 1);
	}
	private static void ma(String s, int k) {
		TreeMap<Character, Integer> map = new TreeMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
			} else {
				map.put(s.charAt(i), 1);
			}
		}
		System.out.println(map.toString());
		Set<Entry<Character, Integer>> set = map.entrySet();
		List<Entry<Character, Integer>> list = new ArrayList<>(set);
		Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
			public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		Set<Integer> ls = new LinkedHashSet<>();
		System.out.println("after sorting by value-----");
		for (Entry<Character, Integer> e : list) {
			System.out.println("key: " + e.getKey() + " value: " + e.getValue());
			ls.add(e.getValue());
		}
		System.out.println("removed duplicate from value array --------" + ls.toString());
		System.out.println(new ArrayList<>(ls).get(k - 1));
		for (Entry<Character, Integer> e1 : list) {
			if (e1.getValue().equals(new ArrayList<>(ls).get(k - 1))) {
				System.out.println(e1.getKey());
				break;
			}
		}

	}

}
