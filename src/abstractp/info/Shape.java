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
public abstract class Shape {
	String objectName;

	Shape(String objectName) {
		this.objectName = objectName;
	}
	
	public void moveTo(int x, int y){
		System.out.println(objectName+"Object moved from : "+x+" to "+y);
	}
	abstract public double area();
	abstract public void draw();
}
