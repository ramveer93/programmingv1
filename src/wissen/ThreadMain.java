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
public class ThreadMain {
public static void main(String args[]){
	ChildThread ct = new ChildThread();
	System.out.println(ct);
	ct.start();
	System.out.println("main thread starts first");
}
	

}
