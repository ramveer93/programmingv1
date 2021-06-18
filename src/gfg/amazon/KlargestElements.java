/*
 * Copyright (c) 2018 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
 
package gfg.amazon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 
 * @author ramveersingh
 * 
 * Given an array, print k largest elements from the array.  The output elements should be printed in decreasing order.

Input:

The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is N and k, N is the size of array and K is the largest elements to be returned.
The second line of each test case contains N input C[i].

Output:

Print the k largest element in descending order.

Constraints:

1 ≤ T ≤ 100
1 ≤ N ≤ 100
K ≤ N
1 ≤ C[i] ≤ 1000

Example:

Input:
2
5 2
12 5 787 1 23
7 3
1 23 12 9 30 2 50

Output:
787 23
50 30 23
 */
public class KlargestElements {

	public static void main(String args[]){
//		int T;
//		int N=0;
//		int K;
//		Scanner sc = new Scanner(System.in);
//		T=sc.nextInt();
//		for(int i=0;i<T;i++){
//			N = sc.nextInt();
//			K = sc.nextInt();
//			Integer c[] = new Integer[N];
//			
//			for(int j=0;j<N;j++){
//				c[j] = sc.nextInt();
//			}
//			//System.out.println("got the data ");
//			klargest(K ,c);
//		}
		int a[] = {5,6,1,90,3,15,67,12,0,56};
		insertionSort(a);
		
	}
	
	private static void klargest(int k , Integer a[]){
		Arrays.sort(a,new Comparator<Integer>(){
			@Override
			public int compare(Integer a1, Integer a2){
				return a2.compareTo(a1);
			}
		});
		for(int i=0;i<k;i++){
			System.out.print(a[i]+" "); //$NON-NLS-1$
		}
		
	}
	
	private static void insertionSort(int ar[]){
	    for(int i=1;i<ar.length;i++){
	        int temp;
	        for(int j = i;j>0;j--){
	            if(ar[j]>ar[j-1]){
	                temp = ar[j];
	                ar[j] =ar[j-1];
	                ar[j-1] =temp;
	            }
	        }
	    }
	   for(int i=0;i<ar.length;i++){
		   System.out.println(ar[i]+"  ");
	   }
	    
	}
	
	
	
	
	
	
	
	
	
	
	
}
