/*
 * Copyright (c) 2018 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
 
package utility;

/**
 * 
 * @author ramveersingh
 */
public class TestCarExample {

	public static void main(String args[]){
		//Question --------1
		Car c = new Sedan();
		c.openDoor();
		//c.openHatch();  : CE
		
		
		
		//Question -------2
		Sedan s = (Sedan)c;
		s.openDoor();
		s.openHatch();
		
		Sedan sd = new Sedan();
		//HatchBack hb  = (HatchBack)sd;   CE
		
//		HatchBack hb  = (HatchBack)c;
//		hb.openDoor();     //RE classCast exception
		
		
		Luxury l = new Luxury();
		l.openDoor();
		
//		Car s  = (Sedan)new Car();
//		s.openDoor();
		//s.openHatch();
		
    //	Sedan s2  = new Sedan();
	//	Sedan s1  = (HatchBack)s2();
		
		Object o = new String("ranveer");
		String str = (String)o;
		System.out.println(str);
		
		
		
	}
	
	
}
