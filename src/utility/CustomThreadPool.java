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

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 
 * @author ramveersingh
 */
public class CustomThreadPool {

	private final int threadCount;
	private final PoolWorker[] thread;
	private final LinkedBlockingQueue queue;

	public CustomThreadPool(int threadCount) {
		this.threadCount = threadCount;
		this.queue = new LinkedBlockingQueue();
		this.thread = new PoolWorker[threadCount];
		System.out.println("creating a pool of "+threadCount+" threads");
		for (int i = 0; i < threadCount; i++) {
			thread[i] = new PoolWorker();
			thread[i].start();
		}
	}
	public void execute(Runnable task) {
		System.out.println("got a task");
		synchronized (queue) {
			queue.add(task);
			queue.notify();
		}
	}

	private class PoolWorker extends Thread {
		@Override
		public void run() {
			System.out.println("inside run method"); //$NON-NLS-1$
			Runnable task ;
			while(true){
				synchronized(queue){
					while (queue.isEmpty()) {
						try {
							queue.wait();
						} catch (InterruptedException e) {
							System.out.println("exception occured while queue is waiting : " + e.getMessage());
							e.printStackTrace();
						}
					}
					    task = (Runnable) queue.poll();
						try {
							task.run();
						} catch (Exception e) {
							System.out.println("error executing task : " + e.getMessage());
						}

					
				}
			}
			
			
			
		}

	}

}
