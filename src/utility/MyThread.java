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
public class MyThread extends Thread{

	private static Thread main;
	@Override
	public void run(){
		try{
			main.join();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		for(int i=0;i<10;i++){
			System.out.println("Child thread");
			//System.out.println("Before yied: in run "+Thread.currentThread().getState());
			//Thread.yield();
			//System.out.println("After yield in run: "+Thread.currentThread().getState());
			
		}
	}
	
	public static void main(String args[]){
		MyThread t = new MyThread();
//		t.setPriority(1);
//		t.start();
//		System.out.println(t.getPriority());
//		System.out.println("Main thread priority: "+Thread.currentThread().getPriority());
//		for(int j=0;j<10;j++){
//			System.out.println("main thread");
//		}
		//System.out.println("Before starting: "+t.getState());
//		t.start();
//		try{
//			t.join();
//		}catch(InterruptedException e){
//			e.printStackTrace();
//		}
		//System.out.println("after starting: "+t.getState());
		
		
		main = Thread.currentThread();
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int j=0;j<10;j++){
			System.out.println("main thread");
		}
	}
}
