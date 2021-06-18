package goldmansach;

/**
 * https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/
 * 
 * @author sramveer
 *
 */

public class MaxLengthPalindramSubstring {
	public static void main(String[] args) {
		System.out.println(maxPalindram("forgeeksskeegfor"));
	}

	private static int maxPalindram(String str) {
		int size = str.length();
		boolean table[][] = new boolean[size][size];
		/**
		 * all 1 length strings will be palindram
		 */
		int start = 0;
		int maxLength = 0;
		for (int i = 0; i < size; i++) {
			table[i][i] = true;
		}

		/**
		 * check for string of length 2
		 */
		for (int i = 0; i < size - 1; i++) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				table[i][i + 1] = true;
				maxLength = 2;
				start = i;
			}
		}

		/**
		 * check for length more than 2 for a[i][j] = if-> a[i] = = a[j] &&
		 * a[i+1][j-1]==true then a[i][j] = true
		 */
		for (int k = 3; k <= size; k++) {
			for (int i = 0; i < size - k + 1; i++) {
				int j = i + k - 1;
				if (table[i + 1][j - 1] && str.charAt(i) == str.charAt(j)) {
					table[i][j] = true;
					if (k > maxLength) {
						maxLength = k;
						start = i;
					}
				}

			}
		}
		/**
		 * print the palindram string
		 */
		String output = str.substring(start, start+maxLength );
		System.out.println("----------output----------" + output);

		return maxLength;

	}

}
