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
public class MacOsWindow implements Window{

	/* (non-Javadoc)
	 * @see abstractfactory.pattern.Window#setTitle(javabasic.lang.String)
	 */
	@Override
	public void setTitle(String s) {
		System.out.println("mac os title: "+s);
	}

	/* (non-Javadoc)
	 * @see abstractfactory.pattern.Window#repaint()
	 */
	@Override
	public void repaint() {
		System.out.println("mac os reapinted");
		
	}

}
