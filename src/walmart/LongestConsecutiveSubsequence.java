package walmart;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://www.youtube.com/watch?v=rpku4iVaDNU
 * 
 * @author sramveer
 *
 */

public class LongestConsecutiveSubsequence {

	public static void main(String args[]) {
		int a[] = {36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42};
		System.out.println("------" + lcsSorting(a));
	}

	static int lcsOptimized(int a[]) {
		Set<Integer> set = new HashSet<>();
		for (int num : a) {
			set.add(num);
		}
		int longestStreak = 0;

		for (int numb : set) {
			if (!set.contains(numb - 1)) {
				int currentNum = numb;
				int currentStreak = 1;
				while (set.contains(numb + 1)) {
					currentStreak++;
					currentNum = currentNum + 1;
				}
				longestStreak = Math.max(longestStreak, currentStreak);
			}
		}
		return longestStreak;
	}

	private static int lcsBruteForce(int a[]) {

		int sequence = 0;
		int localsc = 1;
		for (int i = 0; i < a.length; i++) {
			int number = a[i];

			while (exist(a, number + 1)) {
				localsc++;
				number = number + 1;
			}
			if (localsc > sequence) {
				sequence = localsc;
				localsc = 1;
			}

		}
		return sequence;
	}

	private static int lcsSorting(int a[]) {
		Arrays.sort(a);
		int c = 0;
		int f = 0;
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] + 1 == a[i + 1]) {
				c++;

			} else {
				if (c > f) {
					f = c;
				}
			}

		}
		return f;

	}

	private static boolean exist(int a[], int x) {

		for (int i = 0; i < a.length; i++) {
			if (a[i] == x) {
				return true;

			}

		}
		return false;
	}
}
