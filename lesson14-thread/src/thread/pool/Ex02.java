package thread.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static utils.ThreadUtils.*;

/**
 * Thread Pool
 * + pool size: number of threads
 * + blocking queue: number of tasks
 */
public class Ex02 {
	private static Random rd = new Random();
	private static int capacity = 20;
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("Thread start");
		
		// blocking queue
		List<Task> tasks = new ArrayList<>(capacity);
		for(int i = 0; i < capacity; i++) {
			tasks.add(new Task());
		}
		
		// thread pool - idea processors
		ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		for(Task task : tasks) {
			Future<Integer> future = service.submit(task);
			System.out.println("random: " + future.get());
		}
		service.shutdown();
		System.out.println("Thread end");
	}
	
	private static class Task implements Callable<Integer> {
		@Override
		public Integer call() throws Exception {
			int rand = 10 + rd.nextInt(11);
			startThread(rand);
			doTask(2, TimeUnit.SECONDS);
			return rand;
		}
	}
}
