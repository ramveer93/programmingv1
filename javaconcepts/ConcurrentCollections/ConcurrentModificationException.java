package ConcurrentCollections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentModificationException extends Thread {

	static ArrayList<Integer> list = new ArrayList<>();
//	static CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
	
	

	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		list.add(10);
	}
	
	public static void main(String args[])
	{
		
		list.add(101);
		list.add(102);
		list.add(109);
		list.add(112);
		
		ConcurrentModificationException ce = new ConcurrentModificationException();
		ce.start();
		
		Iterator<Integer> itr = list.iterator();
		while(itr.hasNext()) 
		{
			
//			itr.remove();
			list.remove(0);
			System.out.println(itr.next());
			
		}
	}
}
