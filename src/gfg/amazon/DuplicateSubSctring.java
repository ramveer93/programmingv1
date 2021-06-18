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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author ramveersingh
 */
public class DuplicateSubSctring {

	private static Set<String> s = new HashSet<>();
	public static void main(String args[]){
//		//getSubstr("abcdbc",3);
////		int n=123;
////		System.out.println(sumOfDigitInDecimal(2312));
//		
//		System.out.println(countStr(2));
		
		
		
		 System.out.println("First Test");
		    char[] set1 = {'a', 'e','i','o','u'};
		    int k = 2;
		    printAllKLength(set1, k);
		    System.out.println("set s is : "+s.size());
		     
//		    System.out.println("\nSecond Test");
//		    char[] set2 = {'a', 'b', 'c', 'd'};
//		    k = 1;
//		    printAllKLength(set2, k); 
	}
	
	// The method that prints all 
	// possible strings of length k.
	// It is mainly a wrapper over 
	// recursive function printAllKLengthRec()
	private static void printAllKLength(char[] set, int k)
	{
	    int n = set.length; 
	    printAllKLengthRec(set, "", n, k);
	}
	 
	// The main recursive method
	// to print all possible 
	// strings of length k
	private static void printAllKLengthRec(char[] set, 
	                               String prefix, 
	                               int n, int k)
	{
	     
	    if (k == 0) 
	    {
	    	char tempAr[] = prefix.toCharArray();
	    	Arrays.sort(tempAr);
	    	s.add(new String(tempAr));
	        System.out.println(prefix);
	        return;
	    }
	    for (int i = 0; i < n; ++i)
	    {
	 
	        String newPrefix = prefix + set[i]; 
	        printAllKLengthRec(set, newPrefix, 
	                                n, k - 1); 
	    }
	}
	
	
	
	private static int sumOfDigitInDecimal(double d){
		String s = Double.toString(d);
		String [] arr = s.split("\\."); //$NON-NLS-1$
		String first = arr[0];
		String second = arr[1];
		int firstSum = 0;
		int decSum = 0;
		for(int i=0;i<first.length();i++){
			firstSum+=Integer.parseInt(String.valueOf(first.charAt(i)));
		}
		for(int j=0;j<second.length();j++){
			decSum+=Integer.parseInt(String.valueOf(second.charAt(j)));
		}
		return firstSum+decSum;
	}
	private static void getSubstr(String total, int k){
		List<String> list = new ArrayList<>();
		for(int i=0;i<total.length()-1;i++){
			if(i+k<total.length()){
				String sub = total.substring(i, i+k);
				String t = total.substring(i+k,total.length());
				if(t.indexOf(sub)>-1){
					list.add(sub);
				}
			}
		}
		System.out.println(list.toString());
	}
}
