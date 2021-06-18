package walmart;

public class ThreadDeadlock {
	public static Object lock1 = new Object();
	public static Object lock2 = new Object();

	public static void main(String args[]) 
	{
		ThreadDemo1 t1 = new ThreadDemo1();
		ThreadDemo2 t2 = new ThreadDemo2();
		t1.start();
		t2.start();
//		try {
//			//t1.join();
//			t2.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		

	}

	private static class ThreadDemo1 extends Thread {
		@Override
		public void run() {
			synchronized (lock1) {
				System.out.println("Thread 1: Holding lock 1...");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Thread 1: Waiting for lock 2...");
				synchronized (lock2) {
					System.out.println("thread 1 holding lock 1 and lock 2");

				}
			}
		}

	}

	private static class ThreadDemo2 extends Thread {
		@Override
		public void run() {
			synchronized (lock1) {
				System.out.println("thread 2 holding lock 2");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("thread 2 wating for lock 1");
				synchronized (lock2) 
				{
					System.out.println("thread 2 holding lock 2 and lock1");
				}
			}

		}

	}
}
