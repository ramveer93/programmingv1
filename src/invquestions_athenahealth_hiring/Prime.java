/*
 * Copyright (c) 2018 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
 
package invquestions_athenahealth_hiring;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * @author ramveersingh
 */
public class Prime {

	public static void main(String args[]){
		System.out.println(isprime(1));
		int ar[] = {1,4,3,2,6};
		specialArray(ar);
	}
	
	private static void specialArray(int ar[]){
		int primeArray[] = new int[ar.length];
		int i=0;
		int k=0;
		int pcount=0;
		while(i<ar.length){
			if(isprime(ar[i])){
				primeArray[k++] = ar[i];
				pcount++;
			}
			i++;
		}
		Integer nonprime[] = new Integer[ar.length-pcount];
		int i1=0;
		int k1=0;
		while(i1<ar.length){
			if(!isprime(ar[i1])){
				nonprime[k1++] = ar[i1];
			}
			i1++;
		}
		Comparator<Integer> com = new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b){
				return b.compareTo(a);
				
			}
		};
		Arrays.sort(primeArray,0,pcount);
		Arrays.sort(nonprime,com);
		int finalArr[] = new int[ar.length];
		for(int p=0;p<pcount;p++){
			finalArr[p]=primeArray[p];
		}
		for(int l=0;l<nonprime.length;l++){
			finalArr[pcount+l] = nonprime[l];
		}
		for(int q1=0;q1<finalArr.length;q1++){
			System.out.print(ar[q1]+" ");
		}
		System.out.println("special array----------");
		for(int q=0;q<finalArr.length;q++){
			System.out.print(finalArr[q]+" ");
		}
		
	}
	
	private static boolean isprime(int n){
		int i=2;
		if(n==1) return false;
		while(i<n-1){
			if(n%i==0){
				return false;
			}
			i++;
		}
		return true;
	}
}
