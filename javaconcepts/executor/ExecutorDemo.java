package executor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorDemo {

	public static void main(String args[]) {

		ExecutorService executor = Executors.newFixedThreadPool(3);
		Runnable job = () -> {
			try {
				System.out.println("running runnable job");
				Thread.sleep(100);
				System.out.println("running runnable job completed");
			} catch (Exception e) {
				e.printStackTrace();
			}
		};

		executor.submit(job);
//		executor.shutdown();
//		try {
//			if (!executor.awaitTermination(800, TimeUnit.MILLISECONDS)) {
//				executor.shutdownNow();
//			}
//		} catch (InterruptedException e) {
//			executor.shutdownNow();
//
//		}

		Callable<Integer> number = () -> {
			int sum = 0;
			for (int i = 0; i < 34; i++) {
				sum += i;
			}
			return sum;
		};
		Future<Integer> future = executor.submit(number);
		try {
			int n = future.get();
			System.out.println("number came: " + n);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

//		executor.shutdown();
//		try {
//			if (!executor.awaitTermination(600, TimeUnit.MILLISECONDS)) {
//				executor.shutdownNow();
//
//			}
//
//		} catch (InterruptedException e) {
//			executor.shutdownNow();
//		}

		Set<Callable<String>> tasks = new HashSet<>();
		tasks.add(new Callable<String>() {
			public String call() throws Exception {
				return "Task 1";
			}

		});
		
		
		tasks.add(new Callable<String>() {
			public String call()throws Exception{
				return "Task 2";
			}
		});
		
		tasks.add(new Callable<String>() {
			public String call() {
				return "Task 3";
			}
		});
		try {
			List<Future<String>> list = executor.invokeAll(tasks);
			for(Future<String> f: list)
			{
				String s = f.get();
				System.out.println("ss.."+s);
				
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
