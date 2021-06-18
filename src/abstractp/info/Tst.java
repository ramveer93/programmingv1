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
public class Tst {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Shape rt = new Rectangle("Rectangle", 20, 10);
		System.out.println(rt.area());
	    rt.draw();
	    rt.moveTo(30, 2);
	    
	    
	    Shape cr = new Circle("circle",3);
	    System.out.println(cr.area());
	    cr.draw();
	    cr.moveTo(2, 3);
		

	}

}
