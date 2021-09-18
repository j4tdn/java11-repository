package thread.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import static utils.ThreadUtils.*;

/**
 * Thread pool
 * + pool size : numbers of threads
 * + block queue : numbers of tasks
 * 
 * 
 */
public class Ex02 {
	private static Random rd = new Random();
	private static long start = 0;
	private static int capacity = 20;
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("Thread start !!!");
		
		start = System.currentTimeMillis();
		// blocking queue
		List<FutureTask<Integer>> futureTasks = new ArrayList<>(capacity);
		
		for(int i = 0; i < capacity; i++) {
			long time =  2 +  rd.nextInt(6);	
			futureTasks.add(new FutureTask<Integer>(new Task()));
		}
		
			
		ExecutorService service =  Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		for(FutureTask<Integer> task : futureTasks) {
			service.submit(task);
			System.out.println("random : " + task.get());
		}
		
		// shutdown thread pools
		service.shutdown();
		System.out.println("Thread end !!!");
	}
	
	private static class Task  implements Callable<Integer> { 
		
		@Override
		public Integer call() throws Exception {
			// tasks random number from 10 to 20
			int rand = 10 + rd.nextInt(11);
			startThread(rand);
			doTask(2, TimeUnit.SECONDS);
			return rand;
		}
	}
}
