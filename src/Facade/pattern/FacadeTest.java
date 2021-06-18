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
public class FacadeTest {
	public static void main(String[] args){
		CarFacade cfd = new CarFacade();
		cfd.startcar();
		cfd.moveCar();
	}

}
