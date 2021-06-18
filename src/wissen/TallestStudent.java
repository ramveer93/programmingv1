/*
 * Copyright (c) 2018 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
 
package wissen;

import java.util.Scanner;

/**
 * 
 * @author ramveersingh
 */
public class TallestStudent {

	public static void main(String args[]){
		int t;
		int n;
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		for(int i=0;i<t;i++){
			n = sc.nextInt();
			int a[] = new int[n];
			for(int j=0;j<n;j++){
				a[j] = sc.nextInt();
			}
			System.out.println(tallest(a,n));
			
		}
	}
	/**
	 * 
	 * @param a
	 * @param n
	 * @return
	 */
	public static  int tallest(int a[], int n){
		int sum=0;
		int cIndex = 0;
		int csum = 0;
		for(int i=0;i<n;i++){
			for(int j=i+1;j<n;j++){
				if(a[i]<=a[j]){
					sum++;
					break;
				}
				if(a[i]>a[j]){
					sum++;
				}
			}
			if(sum>csum){
				csum = sum;
				cIndex = i;
				sum = 0;
			}else if(sum==csum){
				cIndex = i;
				csum = sum;
				sum = 0;
			}else if(sum<csum){
				sum = 0;
			}
			//System.out.println("no: "+a[i]+" index: "+cIndex+" sum: "+csum);
		}
		cIndex+=1;
		//System.out.println("index is : "+cIndex+"sm: "+csum);
		return cIndex;
		
	}
}
