/*
 * Copyright (c) 2018 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
 
package utility;

/**
 * 
 * @author ramveersingh
 */
public class Task implements Runnable{

	
	private int num;
	public Task(int num){
		this.num=num;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CustomThreadPool pool = new CustomThreadPool(2);
		for(int i=0;i<5;i++){
			Task t = new Task(i);
			pool.execute(t);
		}
	}

	
	@Override
	public void run() {
		System.out.println("Running task: "+this.num); //$NON-NLS-1$
		
	}

}
