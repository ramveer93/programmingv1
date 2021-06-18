package atlassina;

import java.util.Arrays;

public class FindTheWinner {
	public static void main(String args[]) {
		findWinner("abcdbh");
	}

	private static void findWinner(String s) {
		String s1 = "";
		String s2 = "";
		for (int i = 0; i < s.length(); i++) {
			if (i % 2 == 0) {
				s1 += s.charAt(i);
			} else if (i % 2 != 0) {
				s2 += s.charAt(i);
			}
		}
		Arrays.sort(s1.toCharArray());
		Arrays.sort(s2.toCharArray());
		if (s1.compareTo(s2) < 0) {
			System.out.println("A");

		} else if (s2.compareTo(s1) < 0) {
			System.out.println("B");
		} else {
			System.out.println("Tie");
		}
	}
}
