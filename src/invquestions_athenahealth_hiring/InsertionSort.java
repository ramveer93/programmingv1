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
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

/**
 * 
 * @author ramveersingh
 */
public class InsertionSort {

	public static void main(String args[]) {
		int ar[] = { 9, 90,900, 110,11,45 };
       //insertionSort(ar);
       
      // System.out.println(largestNum(ar));
       
       //reverseStack();
       
       Stack<Integer> st = new Stack<>();
       
       for(int i=0;i<9;i++){
    	   st.push(i);
       }
       System.out.println("before reversed s: "+st);
       reverseS(st);
       
       System.out.println("reversed s: "+st);
	}

	private static void reverseStack(){
		Stack<Integer> stack = new Stack<>();
		for(int i=0;i<10;i++){
			stack.push(i);
		}
		System.out.println("Before reversing stack: "+stack);
		stack.sort(Collections.reverseOrder());
		System.out.println("reversed stack: "+stack);
	}
	
	private static void reverseS(Stack<Integer> s){
		if(s.isEmpty()){
			return;
		}else {
			int pop =s.pop();
			 reverseS(s);
			 insert(s,pop);
		}
		
	}
	
	private static void insert(Stack<Integer> s, int popped){
		if(s.isEmpty()){
			s.push(popped);
		}
		else{
			int element = s.pop();
			insert(s,popped);
			s.push(element);
		}
	}
	
	
	private static String largestNum(int num[]){
		String ar[] = new String[num.length];
		
		for(int i=0;i<num.length;i++){
			ar[i] = String.valueOf(num[i]);
		}
		Arrays.sort(ar,new Comparator<String>(){
			public int compare(String a, String b){
				return (b+a).compareTo(a+b);
			}
		});
		StringBuffer sb = new StringBuffer();
		for(String a:ar){
			sb.append(a);
		}
		while(sb.charAt(0)=='0' && sb.length()>1){
			sb.deleteCharAt(0);
		}
		return sb.toString();
	}
	private static int[] insertionSort(int ar[]) {
		for (int i = 1; i < ar.length; i++) {
			int temp;
			for (int j = i; j > 0; j--) {
				if (ar[j] < ar[j - 1]) {
					temp = ar[j];
					ar[j] = ar[j-1];
					ar[j-1] = temp;
				}
			}

		}
        for(int k=0;k<ar.length;k++){
        	System.out.println(ar[k]);
        }
		return ar;
	}
	
	
}
