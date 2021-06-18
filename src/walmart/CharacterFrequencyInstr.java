package walmart;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

public class CharacterFrequencyInstr {
	public static void main(String args[]) {
		freq("geeksforgeeks");
		
		countArray("geeksforgeeks");

	}

	public static void freq(String s) {
//		Map<Character, Integer> map = new TreeMap<>(new MyCustomComparator());

		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();

//		SortedMap<Character,Integer> ss = new TreeMap<>(new MyCustomComparator() );

		for (char c : s.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}

		for (Entry<Character, Integer> e : map.entrySet()) {
			System.out.println(" key : " + e.getKey() + "----------value : " + e.getValue());
		}
	}

	public static void countArray(String s) {

		int SIZE = 26;
		int freq[] = new int[SIZE];
		for (int i = 0; i < s.length(); i++) {
			freq[s.charAt(i) - 'a']++;
		}

		for (int i = 0; i < s.length(); i++) {
			if (freq[s.charAt(i) - 'a'] != 0) {
				System.out.println("------" + s.charAt(i) + freq[s.charAt(i) - 'a']);
				freq[s.charAt(i) - 'a'] = 0;

			}

		}
	}
}
