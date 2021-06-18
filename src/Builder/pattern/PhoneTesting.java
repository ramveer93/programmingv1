/*
 * Copyright (c) 2018 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
 
package Builder.pattern;

/**
 * 
 * @author ramveersingh
 * 
 * Here 2 problems:
 * 1. we have to give all the values
 * 2. we have to give all the values in fixed order
 */
public class PhoneTesting {
	public static void main(String args[]){
//		Phone p = new Phone("Android", "Qualqm", 2, 2700, 5.6);
//		  System.out.println(p);
		Phone p = new PhoneBuilder().setBattery(4000).setOs("IOS").getPhone();
		System.out.println(p);
	}
}
