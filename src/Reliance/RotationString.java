/*
 * Copyright (c) 2018 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */

package Reliance;

import java.util.Arrays;
import java.util.List;

import javax.swing.plaf.synth.SynthSeparatorUI;

/**
 * 
 * @author ramveersingh
 */
public class RotationString {

	public static void main(String args[]) {
		String s1 = "ABCD";
		String s2 = "CDAB";
		System.out.println("Is rotation:"+isRotation(s1,s2));
		
//		commasepToArr("wqwqwq,reerrere,sddsdsds,trtrtrtrrt,rdfddfdf,ioiiooiio,dsdsds,scccxcxcx,s,aaaad,fdjfdfdfdkdf,");
		
		
	}

	private static boolean isRotation(String s1, String s2) {
		String t = s1 + s1;
		System.out.println("total : "+t);
		if(t.indexOf(s2) != -1) {
			return true;
		} 
	    return false;
	}
	
	private static List<String> commasepToArr(String str){
		List<String> items = Arrays.asList(str.split("\\s*,\\s*"));
		items.forEach(i->System.out.println(i));
		return items;
	}
}
