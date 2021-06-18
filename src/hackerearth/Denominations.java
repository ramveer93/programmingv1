/*
 * Copyright (c) 2018 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
 
package hackerearth;

import java.util.Arrays;

/**
 * 
 * @author ramveersingh
 */
public class Denominations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * you have given a no , and three denominations 3, 5,10 
		 * we need to find out in how many ways we can make that number using the infinite no of denominations
		 */

	}
	
	private static int findDenominations(int n){
		String s;
		int a[] = new int[n+1];
		Arrays.fill(a, 0);
		a[0]=1;
		for(int i=3;i<=n;i++){
			a[i]+=a[i-3];
		}
		for(int j=5;j<=n;j++){
			a[j]+=a[j-5];
		}
		for(int k=10;k<=n;k++){
			a[k]+=a[k-10];
		}
		return a[n];
	}

}
