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

/**
 * 
 * @author ramveersingh
 */
public class ReverseWords {

	public static void main(String args[]){
		String s = "India is my country";
		System.out.println(reverseWord(s));
	}
	private static String reverseWord(String s){
		String output ="";
		String a[] = s.split(" ");
		for(int i=0;i<a.length;i++){
			String t  = a[i];
			String tt = "";
			StringBuilder sb = new StringBuilder(t);
			output+=sb.reverse().toString()+" ";
//			for(int j=t.length()-1;j>=0;j--){
//				tt+=t.charAt(j);
//			}
			//output+=tt+" ";
		}
		return output;
		
	}
}
