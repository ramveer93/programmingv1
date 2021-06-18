/*
 * Copyright (c) 2018 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
 
package wissen;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * @author ramveersingh
 */
public class ExecutorDemo implements Runnable{

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
	for(int i=0;i<3;i++){
		System.out.println(i);
	}
	}

	public static void main(String args[]){
		ExecutorService ex = Executors.newCachedThreadPool();
		ex.execute(new ExecutorDemo());
		ex.execute(new ExecutorDemo());
		ex.execute(new ExecutorDemo());
		ex.execute(new ExecutorDemo());
		//ex.execute(new ExecutorDemo());
//		ex.shutdown();
//		ex.execute(new ExecutorDemo());
//		
	}

}
