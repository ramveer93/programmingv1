package atlassian;

public class TwoSynchronizedMethodSameClassWithDiffThread {

	public static void main() 
	{
		new TwoSynchronizedMethodSameClassWithDiffThread().methodB();
		new TwoSynchronizedMethodSameClassWithDiffThread().methodB();
	}

	public synchronized void methodA() {

	}

	public synchronized void methodB() {

	}

}
