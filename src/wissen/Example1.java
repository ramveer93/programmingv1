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

/**
 * 
 * @author ramveersingh
 */
public class Example1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
      Thread t = Thread.currentThread();
      try{
    	  Thread.sleep(2000);
    	  t.setName("ramveer");
    	  System.out.println(t);
      }catch(InterruptedException e){
    	  System.out.println("exception: "+e.getMessage());
      }
     
      
      System.out.println(t);
	}

}
