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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author ramveersingh
 */
public class CountWaysGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Scanner sc  = new Scanner(System.in);
//		System.out.println(countWays(sc.nextLong()));
//		List<Long> l = new ArrayList<>();
//		Collections.sort(l);
		int a[] = {3,5,3,5,5,11,5,22,5,34};
		int x = 5;
		m1(a,x);
	}
	
	
	private static void m1(int a[], int x){
		int j = a.length-1;
		int c = 0;
		for(int i=a.length-1;i>=0;i--){
			if(a[i]!=x){
				a[j--] = a[i];
				c++;
				
			}
		}
		for(int j1=0;j1<a.length-c;j1++)
		{
			//if(a[j1]==x){
			a[j1] = 1;
		//}
			
		}
		System.out.println(Arrays.toString(a));
		
	}
	
	
	
	private static void m(int a[],int x){
		
		for(int i=0;i<a.length;i++){
			if(a[i]==x){
				a[i] = -1;
			}
		}
		
		for(int i=a.length-1;i>=1;i--){
			if(a[i]==-1){
				int temp = a[i];
				a[i] = a[i-1];
				a[i-1] = temp;
			}
		}
		for(int i=0;i<a.length;i++){
			if(a[i]==-1){
				a[i] = 1;
			}
		}
		for(int i=0;i<a.length;i++)
		System.out.println(a[i]+"");
		
	}
	private static long countWays(long n){
		long a[] = new long[(int) (n+1)];
		Arrays.fill(a, 0);
		a[0] = 1;
		for(int i=3;i<=n;i++){
			a[i]+=a[i-3];
		}
		for(int i=5;i<=n;i++){
			a[i]+=a[i-5];
		}
		for(int i=10;i<=n;i++){
			a[i]+=a[i-10];
		}
		return a[(int) n];
	}

}
