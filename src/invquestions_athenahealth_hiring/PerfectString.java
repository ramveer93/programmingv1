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

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author ramveersingh
 */
public class PerfectString {

	/**
	 * @param:  args
	 */
	public static void main(String [] args){
		/*
		 * Check if a string has all characters with same frequency with one variation allowed
		 */
		System.out.println(isValidPerfString("aabbcdcs")); //$NON-NLS-1$
	}
	private static boolean isValidPerfString(String s){
		Map<Character,Integer> map  =new HashMap<>();
		for(int i=0;i<s.length();i++){
			if(map.containsKey(s.charAt(i))){
				int k = map.get(s.charAt(i))+1;
				map.put(s.charAt(i), k);
			}else{
				map.put(s.charAt(i), 1);
			}
		}
		System.out.println("map is : "+map.toString()); //$NON-NLS-1$
		int onec = 0;
		for(Integer in:map.values()){
			if(in%2!=0){
				onec = onec+1;
			}
		}
		for(Integer ig : map.values()){
			if(ig%2==0 && onec==1){
				return true;
			}
		}
		
		return false;
		
	}
}
