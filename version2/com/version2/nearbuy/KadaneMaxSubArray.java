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
public class KadaneMaxSubArray {

	public static void main(String args[]){
		int a[] = {-2,-3,4,-1,-2,1,5,-3};
		System.out.println(maxSubArray(a));
	}
	
	/**
	 * 
	 * @param a
	 * @return
	 */
	private static int maxSubArray(int a[]){
		int sum = 0;
		int maxSum = Integer.MIN_VALUE;
		for(int i=0;i<a.length;i++){
			sum = sum+a[i];
			if(sum<0){
				sum =0;
			}
			if(sum>maxSum){
				maxSum = sum;
			}
		}return maxSum;
		
	}
}
