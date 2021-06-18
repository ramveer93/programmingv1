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
public class SampleDemo implements Runnable{
	private Thread t;
	private String threadName;
	SampleDemo(String threadName){
		this.threadName = threadName;
		
	}
	public void run(){
		while(true){
			System.out.println(threadName);
		}
	}
	public void start(){
		if(t==null){
			t = new Thread(this,threadName);
			t.start();
		}
	}

	
}
