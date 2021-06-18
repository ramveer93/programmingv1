package invquestions_athenahealth_hiring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 
 * @author sramveer
 * 
 * 
 * 
 * Given an array arr of N integers. Find the contiguous sub-array with maximum sum.

Input:
The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows. The first line of each test case contains a single integer N denoting the size of array. The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.

Output:
Print the maximum sum of the contiguous sub-array in a separate line for each test case.

Constraints:
1 ≤ T ≤ 110
1 ≤ N ≤ 106
-107 ≤ A[i] <= 107

Example:
Input
2
5
1 2 3 -2 5
4
-1 -2 -3 -4
Output
9
-1

Explanation:
Testcase 1: Max subarray sum is 9 of elements (1, 2, 3, -2, 5) which is a contiguous subarray.

** For More Input/Output Examples Use 'Expected Output' option **
 *
 */
public class KadaneAlgo {
	public static void main(String args[]) throws NumberFormatException, IOException {
		int t;
		int n;
		
//		Scanner sc = new Scanner(System.in);
//		t = sc.nextInt();
//		for (int i = 0; i < t; i++) {
//			n = sc.nextInt();
//			int ar[] = new int[n];
//			for (int j = 0; j < n; j++) {
//				ar[j] = sc.nextInt();
//			}
//			System.out.println(kadaneAlgo(ar));
//
//		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		while(t-->=0) {
			String str = br.readLine();
			if(!str.isEmpty() &&  str!=null) {
				n = Integer.parseInt(str);
				int ar[] = new int[n];
				String line = br.readLine();
				String st[] = line.trim().split("\\s+");
				for(int i=0;i<n;i++) {
					ar[i] = Integer.parseInt(st[i]);
				}
				System.out.println(kadaneAlgo(ar));
				
			}
			
			
		}

	}

	private static int kadaneAlgo(int ar[]) {
		int sum = Integer.MIN_VALUE;
		int localSum = 0;
		for (int i = 0; i < ar.length; i++) {
			localSum += ar[i];
			if (sum < localSum) {
				sum = localSum;
			}
			if (localSum < 0) {
				localSum = 0;
			}

		}
		return sum;

	}
}
