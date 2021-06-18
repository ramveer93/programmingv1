/*
 * Copyright (c) 2018 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
 
package abstractfactory.pattern;

/**
 * 
 * @author ramveersingh
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String os = "WIN";
		AbstractWindowFactory  fact = null;
		if(os.equals("MAC")){
			fact = new MacOsWindowFactory();
		}else if (os.equals("WIN")){
			fact  = new MSWindowFactory();
		}
		
		Window win = fact.createwindow();
		win.repaint();
		win.setTitle("wins is super");

	}

}
