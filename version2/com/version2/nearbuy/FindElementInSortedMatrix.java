/*
 * Copyright (c) 2018 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */

package com.version2.nearbuy;

/**
 * 
 * @author ramveersingh
 */
public class FindElementInSortedMatrix {

	/**
	 * @param args
	 */
	public static void main(String args[]) {
		int mat[][] = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 50 } };
		findElement(4, 4, mat, 889);
	}

	private static void findElement(int n, int m, int a[][], int k) {
		int i = 0;
		int j = m - 1;
		while (i < n && j >= 0) {
			if (a[i][j] == k) {
				System.out.println(k + " found at : " + i + "  and : " + j);
				break;
			} else if (a[i][j] >= k) {
				j--;
			} else {
				i++;
			}
		}

	}

}
