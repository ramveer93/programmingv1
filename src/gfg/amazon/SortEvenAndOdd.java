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

/**
 * 
 * @author ramveersingh
 */
public class SortEvenAndOdd {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = {1,23,12,90,11,56,21,32,26};
		//sortEvenOdd(a);
		segregateEvenOdd(a);

	}
	/**
	 * left = 0, right  = l-1;
	 * keep incrementing left until we see an odd no 
	 * keep decrementing right untill we see and even no
	 * 
	 * @param a
	 */
	public static void segregateEvenOdd(int a[]){
		int left = 0; int right = a.length-1;
		while(left<right){
			if(a[left]%2==0 && left<right){
				left++;
			}
			if(a[right]%2!=0 && left<right){
				right--;
			}
			if(left<right){
				int temp = a[left];
				a[left]= a[right];
				a[right] = temp;
			}
		}
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]+"  ");
		}
		int i=0;
		while(a[i]%2==0){
			i++;
		}
		Arrays.sort(a,0,i);
		Arrays.sort(a,i,a.length);
		System.out.println("sorted-----------");
		for(int i1=0;i1<a.length;i1++){
			System.out.println(a[i1]+"  ");
		}
		
		
		
	}
	public static void sortEvenOdd(int a[]){
		int count = a.length-1;
		for(int i=0;i<count;i++){
			if(a[i]%2!=0){
				int t = a[i];
				a[i] = a[i+1];
				a[i+1] = t;
				
			}
		}
		
	for(int i=0;i<a.length;i++){
		System.out.println(a[i]+"  ");
	}
	}

}
