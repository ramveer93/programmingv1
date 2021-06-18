/*
 * Copyright (c) 2018 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
 
package com.version2.nearbuy;

/**
 * 
 * @author ramveersingh
 */
public final class Test4 {
class Inner{
	void Test(){
		if(Test4.this.flag){
			sample();
			
		}
	}
	
}
private boolean flag = true;
public void sample(){
	System.out.println("sample");
}
public Test4(){
	(new Inner()).Test();
}
public static void main(String args[]){
	new Test4();
}
}
