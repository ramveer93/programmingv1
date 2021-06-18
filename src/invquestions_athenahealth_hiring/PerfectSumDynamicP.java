/*
 * Copyright (c) 2018 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */

package invquestions_athenahealth_hiring;

/**
 * 
 * @author ramveersingh
 */
public class PerfectSumDynamicP {
	/**
	 * @param: args
	 */
	public static void main(String args[]) {
   int set[] = {3, 34, 4, 12, 5, 2};
   System.out.println(isPerfSum(set,set.length,7));
	}

	private static boolean isPerfSum(int[] s, int n, int sum) {
		if (sum == 0) {
			return true;
		} else if (n == 0 && sum != 0) {
			return false;
		} else if (s[n - 1] > sum) {
			return isPerfSum(s, n - 1, sum);
		} else
			return isPerfSum(s, n - 1, sum) || isPerfSum(s, n - 1, sum - s[n - 1]);
	}
}
