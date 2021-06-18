
public class NewThread {

	
	public static void main(String[] args) {
		new muti();
	}
	
	
	
	
}

class muti extends Thread{
	muti(){
		super("my thread");
		start();
	}
	public void run() {
		System.out.println(this);
	}
}
