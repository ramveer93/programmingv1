package com.version2.athena;

import java.util.Scanner;

/**
 * https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
 * 
 * @author sramveer
 *
 */
public class FindElemntInRotatedSortedArray {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int arr[] = { 30, 40, 50, 10, 20 };
		System.out.println(binarySearch(arr, 3));
		System.out.println("using recursive bs: " + recursiveBS(arr, 3, 0, arr.length - 1));
		System.out.println(findElementInRotatedSortedArray(arr, 10));

	}

	private static int findElementInRotatedSortedArray(int ar[], int k) {
		/**
		 * The array is ascending sorted, Find the sorting point and apply the binary
		 * sort in both the arrays
		 */
		int i = 0;
		while (i < ar.length - 1) {
			if (ar[i] <= ar[i + 1]) {
				i++;
			} else {
				break;
			}
		}
		int firstBs = recursiveBS(ar, k, 0, i);
		int secondBS = recursiveBS(ar, k, i + 1, ar.length - 1);
		return firstBs == -1 ? secondBS : firstBs;
	}

	/**
	 * Recursive binary search 
	 * @param arr
	 * @param k
	 * @param l
	 * @param r
	 * @return
	 */
	private static int recursiveBS(int arr[], int k, int l, int r) {
		if (l <= r) {
			int mid = (l + r) / 2;
			if (arr[mid] == k) {
				return mid;
			} else if (arr[mid] > k) {
				return recursiveBS(arr, k, l, mid - 1);
			} else if (arr[mid] < k) {
				return recursiveBS(arr, k, mid + 1, r);
			}

		}
		return -1;
	}
    /**
     * Iterative Binary search 
     * @param arr
     * @param k
     * @return
     */
	private static int binarySearch(int arr[], int k) {
		int l = 0;
		int r = arr.length - 1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (arr[mid] == k) {
				return mid;
			} else if (arr[mid] > k) {
				r = mid - 1;
			} else if (arr[mid] < k) {
				l = mid + 1;
			}
		}
		return -1;
	}
}
