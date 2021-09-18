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

import utils.ThreadUtils;

import static utils.ThreadUtils.*;

/**
 * 
 * Thread Pool
 * + pool size: number of threads
 * + blocking queue: number of tasks
 *
 */
public class Ex01 {
	private static Random rd = new Random();
	private static long start = 0;
	private static int capacity = 20;
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("thread start");
		// blocking queue 
		List<Task> tasks = new ArrayList<>(capacity);
		for (int i = 0; i < capacity; i++) {
			tasks.add(new Task());
		}
		// thread pool - idea processors
		ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		for (Task task: tasks) {
			Future<Integer> future = service.submit(task);
			System.out.println("random: " + future.get());
		}
		
		// shutdown thread pools
		service.shutdown();
		System.out.println("thread end");
	}
	
	private static class Task implements Callable<Integer> {
		@Override
		public Integer call() throws Exception {
			// task random number from 10 to 20
			int rand = 10 + rd.nextInt(11);
			ThreadUtils.startThread(rand);
			doTask(2, TimeUnit.SECONDS);
			return 10 + rd.nextInt(11);
		}
		
	}
}
