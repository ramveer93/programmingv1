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

import java.util.Scanner;

/**
 * 
 * @author ramveersingh
 * 
 * 1. valley: 
 * ci-1>=ci<=ci+1: ci is at valley(ci==1):    8  5  9   :  2  1 2
 * ci-1>=ci>=ci+1: fall (ci=ci+1+1)          :    8 7 6     :  3  2 1
 * ci-1<=ci<=ci+1: rise(ci =ci-1+1)      :    6 7 8     :  1  2 3
 * ci-1<ci>ci+1  : peak( max(ci-1, ci+1)+1)           :    6 8 7     :  1 2  1
 * 
 * 
 * 
 * 
 * 
 * 
 */
public class Candies {
	
	public static void main(String args[]){
		
		
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int a[] = new int[n];
		for(int i=0;i<n;i++){
			a[i] = sc.nextInt();
		}
		//getCandies( n,  a);
		getc(n,a);
//		Scanner scan = new Scanner(System.in);
//		int length = scan.nextInt();
//
//		int[] children = new int[length];
//		int[] candies = new int[length];
//
//		// seed
//		children[0] = scan.nextInt();
//		candies[0] = 1;
//
//		// search forward sequences
//		for (int i = 1; i < length; i++){
//			children[i] = scan.nextInt();
//			candies[i] = 1;
//			if (children[i] > children[i - 1]) 
//				candies[i] = candies[i - 1] + 1;   
//		}
//
//		// search reverse sequences
//		for (int i = length - 1; i > 0; i--){
//		    if (children[i] < children[i - 1]) 
//			    candies[i - 1] = Math.max(candies[i - 1], candies[i] + 1);
//		}
//
//		long sum = 0;
//		for (int i= 0; i < candies.length; i++){
//			sum += candies[i];
//		}
//
//		System.out.println(sum);
	}
	
	private static long getc(int n, int arr[]){
		int[] candies = new int[n];
		candies[0] = 1;
		for(int i=1;i<n;i++)
		{
			candies[i] = 1;
			if(arr[i]>arr[i-1]){
				candies[i] =candies[i-1]+1; 
				
			}
			
		}
		
		for(int i=n-1;i>0;i--)
		{
			//candies[i] = 1;
			if(arr[i]<arr[i-1]){
				candies[i-1] = Math.max(candies[i-1],candies[i]+1);
				
			}
			
		}
		long sum = 0;
		for(int i=0;i<candies.length;i++){
			sum+=candies[i];
			
		}
		System.out.println(sum);
		return sum;
		
		
	}
	
	private static int getCandies(int n, int a[]){
		
		/**velly
		 * ci-1>=ci<=ci+1: ci is at valley(ci==1) 
		 */
		int c[] = new int[n];
		for(int i=1;i<=n-2;i++){
			if(a[i-1]>=a[i] && a[i]<=a[i+1]){
				c[i]=1;
			}
		}
		
		/**
		 * rises:
		 * ci-1<=ci<=ci+1: rise(ci =ci-1+1) 
		 * 
		 */
		for(int i=1;i<=n-2;i++){
			if(a[i-1]<a[i] && a[i]<=a[i+1]){
				c[i]=c[i-1]+1;
			}
		}
		
		
		/**
		 * fall
		 * ci-1>=ci>=ci+1: fall (ci=ci+1+1)  
		 * 
		 */
		for(int i=1;i<=n-2;i++){
			if(a[i-1]>=a[i] && a[i]>=a[i+1]){
				c[i]=c[i+1]+1;
			}
		}
		
		/**
		 * peaks
		 * ci-1<ci>ci+1 peak( max(ci-1, ci+1)+1)   
		 * 
		 */
		for(int i=1;i<=n-2;i++){
			if(a[i-1]<a[i] && a[i]>a[i+1]){
				c[i]=Math.max(c[i-1], c[i+1])+1;
			}
		}
		int s = 0;
		for(int i=0;i<c.length;i++){
			s+=c[i];
		}
		System.out.println(s);
        return s;		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
}
