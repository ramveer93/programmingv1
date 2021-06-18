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

import javax.swing.plaf.synth.SynthSeparatorUI;

/**
 * 
 * @author ramveersingh
 */
public class ReverseRec {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s  = "abcd"; //$NON-NLS-1$
		 System.out.println(rev(s));

	}
	private static String rev(String s){
		if(s==null || s.length()<1){
			return s;
		}
		 return rev(s.substring(1))+s.charAt(0);
	}

}
