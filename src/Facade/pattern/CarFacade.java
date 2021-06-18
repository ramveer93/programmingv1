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
public class CarFacade {

	public void startcar(){
		System.out.println("-------------Car starting-------------");
		new Step1().injectFuel();
		new Step1().igniteFuel();
		System.out.println("-------------Car started-------------");
	}
	
	public void moveCar(){
		System.out.println("-------------Car moveing-------------");
		new Step2().turnOnHeadLight();
		new Step3().changeGear();
		new Step3().pressAccelator();
		System.out.println("-------------Car moved-------------");
	}
}
