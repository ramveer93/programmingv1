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

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * 
 * @author ramveersingh
 */
public class CallableDemo implements Callable<String>{

	/* (non-Javadoc)
	 * @see java.util.concurrent.Callable#call()
	 */
	public String call() {
        System.out.println("Starting call() method in second thread");
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {
            // Ignore
        }
        
        System.out.println("Completed call() method in second thread");
        return "Finished";
    }


	
	public static void main(String args[]) throws InterruptedException, ExecutionException{
		ExecutorService es = Executors.newFixedThreadPool(2);
		//Future<String> f = es.submit(new CallableDemo());
		java.util.concurrent.Future<String> f=es.submit(new CallableDemo());
		System.out.println(f.get());
		es.shutdown();
		
	}

}
