package goldmansach;

public class PrintOddEvenByTwoThread implements Runnable {

	private static int MAX_NO = 10;
	private static boolean evenFlag = true;

	
	public synchronized void run() {
		if (evenFlag) {
			printEven();
		} else {
			printOdd();
		}
	}

	private void printEven() {
		for (int i = 0; i <= MAX_NO; i = i + 2) {
			System.out.println(i + " thread: " + Thread.currentThread().getName());
		}
		evenFlag = false;
	}

	private void printOdd() {
		for (int i = 1; i < MAX_NO; i = i + 2) {
			System.out.println(i + " thread: " + Thread.currentThread().getName());
		}
		evenFlag = true;
	}
	
	public static void main(String[] args) throws InterruptedException {
		PrintOddEvenByTwoThread obj = new PrintOddEvenByTwoThread();
		Thread even = new Thread(obj);
		Thread odd = new Thread(obj);
		even.start();
		odd.start();
		even.join();
		odd.join();
	}
}
