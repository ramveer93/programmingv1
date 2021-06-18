package invquestions_athenahealth_hiring;
/*
 * Given an array of distinct integers. The task is to count all the triplets such that sum of two elements equals the third element.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. First line of each test case contains an Integer N denoting size of array and the second line contains N space separated elements.

Output:
For each test case, print the count of all triplets, in new line. If no such triplets can form, print "-1".

Constraints:
1 <= T <= 100
3 <= N <= 105
1 <= A[i] <= 106

Example:
Input:
2
4
1 5 3 2
3
3 2 7
Output:
2
-1
Testcase 1: There are 2 triplets: 1 + 2 = 3 and 3 +2 = 5


 */

import java.util.Arrays;
import java.util.Scanner;

public class CountTheTriplets {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t;
		int n;
		t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			n = sc.nextInt();
			int ar[] = new int[n];
			for (int j = 0; j < n; j++) {
				ar[j] = sc.nextInt();
			}
			//System.out.println("the result for test case : -> " + i + "   result -> " + countTriplets(ar));
			System.out.println("the result for test case countTripletsWithBST : -> " + i + "   result -> " + countTripletsWithBST(ar));

		}

	}

	private static int countTriplets(int ar[]) {
		int count = 0;
		for (int i = 0; i < ar.length; i++) {
			for (int j = i + 1; j < ar.length; j++) {
				for (int k = 0; k < ar.length; k++) {
					if (ar[i] + ar[j] == ar[k]) {
						count++;
					}

				}

			}

		}

		return count > 0 ? count : -1;

	}

	private static int countTripletsWithBST(int ar[]) {
		int count = 0;
		Arrays.sort(ar);
		for (int i = 0; i < ar.length; i++) {
			for (int j = i + 1; j < ar.length; j++) {
				int sum = ar[i] + ar[j];
				if (Arrays.binarySearch(ar, ar[i] + ar[j]) > 0) {
					count++;
				}

			}

		}
		return count > 0 ? count : -1;

	}

}
