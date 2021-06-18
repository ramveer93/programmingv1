package goldmansach;

public class OddAndEvenThreadProblems {
	public static void main(String args[]) {
		new EvenClass().start();
		new OddClass().start();
	}
	private static Integer i= 0;
	
	public static class EvenClass extends Thread{
		public void run() {
			while(i<=10) {
				synchronized (i) {
					if(i%2 == 0) {
						try {
							Thread.sleep(500);
							System.out.println("Even: "+i);
							i = i+1;
						}catch(Exception e) {
							e.printStackTrace();
						}
						
					}
				}
				
			}
		}
	}
	public static class OddClass extends Thread{
		public void run() {
			while(i<10) {
				synchronized (i) {
					if(i%2!=0) {
						try {
							Thread.sleep(500);
							System.out.println("Odd: "+i);
							i = i+1;
						}catch(Exception e) {
							
						}
					}
				}
			}
		}
	}

}


