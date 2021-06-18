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
public class BinomialCofficient {

	public static void main(String args[]){
		System.out.println(getCofficient(5,2));
		
		System.out.println(getCoffDP(5,2));
	}
	
	
	/**
	 * c(n,k)=c(n-1,k-1)+c(n-1,k)
	 * c(n,0) = c(n,n) = 1 
	 * 
	 * @param n
	 * @param k
	 * @return
	 */
	private static int getCofficient(int n, int k){
		if(k==0 || k==n){
			return 1;
		}else return getCofficient(n-1,k-1)+getCofficient(n-1,k);
		
	}
	
	private static int getCoffDP(int n, int k){
		int dp[][] = new int[n+1][k+1];
		for(int i=0;i<=n;i++){
			for(int j = 0 ; j<=Math.min(i,k);j++){
				if(j==0 || j==i){
					dp[i][j] = 1;
				}
				else 
					dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
			}
			
		}
		return dp[n][k];
		
	}
	
	
}
