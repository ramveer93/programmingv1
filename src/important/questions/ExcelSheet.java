/*
 * Copyright (c) 2018 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
 
package important.questions;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author ramveersingh
 */
public class ExcelSheet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(getExcelStr(34));
		System.out.println(titleToNum(getExcelStr(34)));
	}
	/**
	 * if n%26==0, put z and next no is n/26-1
	 * if n%26!=0  , put that char char(ren-1)+'A' and no will be n/26
	 * @param no
	 * @return
	 */
	public static String getExcelStr(int no){
		String s = "";
		while(no>0){
			int rem = no%26;
			if(rem==0){
				s = s+"Z";
				no = no/26-1;
			}else if(rem!=0){
				char r = (char) ((rem-1)+'A');
				s = s+r;
				no  =no/26;
			}
		}
		return revStr(s);
	}

	
	/**
	 * similar to converting from binary to no,
	 * 
	 * CBA: 1*26^0+2*26^1+3*26^2
	 * @param title
	 * @return
	 */
	public static int titleToNum(String title){
		Map<Character,Integer> map = new HashMap<>();
		char c = 'A';
		for(int i=1;i<=26;i++){
			map.put(c, i);
			c +=1;
		}
		int lngth = title.length()-1;
		int res = 0; 
		int t =0;
		while(lngth>=0){
			char r = title.charAt(lngth);
			res = (int) (res+Math.pow(26, t)*map.get(r));
			lngth--;
			t++;
		}
		return res;
	}
	
	
	private static String revStr(String s){
		if(s==null || s.length()<1){
			return s;
		}
		else return revStr(s.substring(1))+s.charAt(0);
	}
}
