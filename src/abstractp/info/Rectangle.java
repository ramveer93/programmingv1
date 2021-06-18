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
public class Rectangle extends Shape {

	/**
	 * @param objectName
	 */
	int x;int y;
	Rectangle(String objectName,int x,int y) {
		super(objectName);
		this.x=x;
		this.y = y;
	}

	/* (non-Javadoc)
	 * @see abstractp.info.Shape#area()
	 */
	@Override
	public double area() {
		return x*y;
	}

	/* (non-Javadoc)
	 * @see abstractp.info.Shape#draw()
	 */
	@Override
	public void draw() {
		System.out.println("rectangle is drawn");
	}
	@Override
	public void moveTo(int x, int y){
		System.out.println("Object moved from rectangle : "+x+" to "+y);
	}

}
