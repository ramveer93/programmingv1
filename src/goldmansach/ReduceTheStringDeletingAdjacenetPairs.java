package goldmansach;

import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.*;

public class ReduceTheStringDeletingAdjacenetPairs {

	public static void main(String args[]) {
		// stringReduce("aaaabbbbccdddd");

		 System.out.println(pp("GGGrrt"));

//		List<String> l = new ArrayList<String>();
////		l.add("a");
////		l.add("b");
////		l.add("c");
////		l.add("d");
////		l.add("e");
////		l.add("e");
////		l.add("e");
////		l.add("e");
////		l.add("d");
////		l.add("d");
////		l.add("c");
////		l.add("b");
////		l.add("f");
////		l.add("g");
////		l.add("f");
////		
////		
//		l.add("a");
//		l.add("a");
////		l.add("c");
////		l.add("b");
//
//		System.out.println(areSufficientConsequetive(l, 2));
//
////		List<String> ll = getShrunkArray(l,3);
////		System.out.println(ll.toString());
	}

	private static String pp(String s) {
		StringBuffer sb = new StringBuffer();
		int count = 1;
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				count++;
			} 
			System.out.println("i value is : "+i+" and s.length-2 is : "+(s.length()-2));
			if (s.charAt(i) != s.charAt(i + 1) || (i == s.length()- 2)) {
				String ss = count + "" + s.charAt(i);
				sb.append(ss);
				count = 1;
				System.out.println("   ss is : "+ss+" and s.char is : "+s.charAt(i));
			}
			
		}
		if(s.charAt(s.length()-1)!=s.charAt(s.length()-2)) {
			String ss = count + "" + s.charAt(s.length()-1);
			sb.append(ss);
		}
		return sb.toString();
	}

	public static List<String> getShrunkArray(List<String> inputArray, int burstLength) {
		List<String> result = new ArrayList<>();
		Map<String, Integer> map = new ConcurrentHashMap<>();

		for (int i = 0; i < inputArray.size(); i++) {
			if (map.containsKey(inputArray.get(i))) {
				map.put(inputArray.get(i), map.get(inputArray.get(i)) + 1);
			} else {
				map.put(inputArray.get(i), 1);
			}
		}

		for (Entry<String, Integer> entry : map.entrySet()) {
			int count = entry.getValue();
			String key = entry.getKey();
			if (count < burstLength) {
				map.remove(key);
			}
		}

		for (int j = 0; j < inputArray.size(); j++) {
			if (!map.containsKey(inputArray.get(j))) {
				result.add(inputArray.get(j));
			}
		}

		return result;
	}

	private static boolean areSufficientConsequetive(List<String> inputArray, int k) {
		int count = 0;
		for (int i = 0; i < inputArray.size() - 1; i++) {
			if (inputArray.get(i).equals(inputArray.get(i + 1)) ) {
				count++;
			}
			if (count == k || (inputArray.size()==2 && inputArray.get(0).equals(inputArray.get(1))) || (inputArray.size()==2 && k==1 &&  !inputArray.get(0).equals(inputArray.get(1)) )) {
				return true;
			}
		}
		return false;
	}

	private static void stringReduce(String str) {
		Map<Character, Integer> map = new HashMap<>();
		StringBuffer sb = new StringBuffer();
		List<String> l = new ArrayList<>();
		for (int i = 0; i < str.length(); i++) {
			if (map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
			} else {
				map.put(str.charAt(i), 1);
			}
		}
		for (Entry<Character, Integer> entry : map.entrySet()) {
			int count = entry.getValue() % 2;

			for (int j = 0; j < count; j++) {
				sb.append(entry.getKey());

			}

		}
		System.out.println("reduced string : " + sb.toString());

	}

}
