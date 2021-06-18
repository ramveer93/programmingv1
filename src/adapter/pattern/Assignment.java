/*
 * Copyright (c) 2018 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
 
package adapter.pattern;

/**
 * 
 * @author ramveersingh
 * 
 * Problem here is that we dont have implementation for the Pen class , but we have implementation for PilotPen which 
 * also does the same thing to write
 * So we will use that implementation to make our implementation for pen class
 */
public class Assignment {
private Pen p;

public Pen getP() {
	return this.p;
}

public void setP(Pen p) {
	this.p = p;
}
public void writeAssignment(String str){
	p.write(str);
}
}
