/*
 * Copyright (c) 2018 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
 
package abstractp.info;

/**
 * 
 * @author ramveersingh
 */
public class CCircle implements IShape{

	double pi = 3.14;
	int r;
	CCircle(int r){
		super();
		this.r = r;
	}
	
	public void draw(){
		
	}
	
	public double area(){
		return pi*r*r;
	}
}
