package goldmansach;
/*
 * https://www.geeksforgeeks.org/segregate-0s-and-1s-in-an-array-by-traversing-array-once/
 * 1. count 0s and 1s and print
 * 2. two pointers one from starting and another from end, whenever both are not equal swap them 
 */

import java.util.Arrays;

public class MinMoveToSegregateZeroAndOnes {

	public static void main(String args[]) {
		int a[] = { 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0 };
		segregateZeroAndOnes(a);
	}

	private static void segregateZeroAndOnes(int a[]) {
		int l = 0;
		int r = a.length - 1;

		while (l < r) {
			if (a[l] == 0) {
				l++;
			}
			if (a[r] == 1) {
				r--;
			}
			if (l < r) {
				int temp = a[l];
				a[l] = a[r];
				a[r] = temp;
				l++;
				r--;

			}

		}

		System.out.println(" array after segregation: " + Arrays.toString(a));

	}

}
