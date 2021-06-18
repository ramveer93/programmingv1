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

import java.util.HashSet;

/**
 * 
 * @author ramveersingh
 */
public class UniqueArray {

	
	
	public static void main(String args[]){
		int a[] = {2,3,3,4,5,8};
		System.out.println("  sum is : "+getUniqueArraySum(a));
		String t[] = {"q","p"};
		
	}
	
	/**
	 * given array(sorted)  :  2, 3,3, 4, 5, 8: -->  2,3,4,4,5,8---> 2,3,4,5,5,8-----> 2,3,4,5,6,8: sum it now
	 * @param a
	 * @return
	 */
	private static int getUniqueArraySum(int a[]){
		HashSet<Integer> set = new HashSet<>();
		for(int i=0;i<a.length;i++){
			if(!set.add(a[i]) && a[i]==a[i-1]){
				a[i] = a[i]+1;
				for(int j=i;j<a.length;j++){
					if(!set.add(a[j]) && a[j]==a[j-1]){
						a[j] = a[j]+1;break;
					}
				}
			}
			
			
		}
		
		int sum = 0;
		for(int k=0;k<a.length;k++){
			sum+=a[k];
			System.out.println(" "+a[k]);
		}
		
		return sum;
	}
}
