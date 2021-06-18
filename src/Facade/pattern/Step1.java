/*
 * Copyright (c) 2018 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
 
package Facade.pattern;

/**
 * 
 * @author ramveersingh
 */
public class Step1 {
	
	public void injectFuel(){
		System.out.println("Fuel injected");
	}
	
	public void igniteFuel(){
		System.out.println("fuel ignited");
	}
}