package goldmansach;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LongestSubstrWithMUniqueChars {

	public static void main(String[] args) {
		longestSubstrWithMUniqueChars("aabbcc",2);
	}

	private static void longestSubstrWithMUniqueChars(String str, int m) {
		Map<Character, Integer> countMap = new HashMap<>();
		int start = 0, end = 0, windowSize = 1, windowStart = 0;

		for (int i = 0; i < str.length(); i++) {
			Character c = str.charAt(i);
			if (countMap.containsKey(c)) {
				countMap.put(c, countMap.get(c) + 1);
			} else {
				countMap.put(c, 1);
			}
			end++;
            // move start if no of unique char greater than m 
			while (!isLessThenM(countMap,m)) {
				int value = countMap.get(str.charAt(start));
				countMap.put(str.charAt(start), --value);
				start++;
			}
			if (end - start + 1 > windowSize) {
				windowSize = end - start + 1;
				windowStart = start;
			}
		}
		System.out.println("windowStart..."+windowStart+"   windowSize--- "+windowSize);
		System.out.println(str.subSequence(windowStart, windowStart + windowSize-1));
	}

	private static boolean isLessThenM(Map<Character, Integer> map, int m) {

		int count = 0;

		for (Entry<Character, Integer> entry : map.entrySet()) {
			int value = entry.getValue();
			if (value != 0) {
				count++;
			}
		}
		return count <= m;

	}
}
