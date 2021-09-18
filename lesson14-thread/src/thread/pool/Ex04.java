package thread.pool;

import static utils.ThreadUtils.doTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import utils.ThreadUtils;

/**
 * Thread pool
 * + pool size: number of threads
 * + blocking queue: number of tasks
 */

public class Ex04 {
	private static Random rd = new Random();
	private static int capacity = 20;
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("Thread Start");

		// blocking queue
		List<FutureTask<Integer>> futureTasks = new ArrayList<>(capacity);
		for (int i = 0; i < capacity; i++) {
			futureTasks.add(new FutureTask<>(new Task()));
		}
		
		// thread pool - idea processors
		ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		
		for (FutureTask<Integer> futureTask : futureTasks) {
			service.submit(futureTask);
			System.out.println("random: " + futureTask.get());
		}
		
		// shutdow thread pools
		service.shutdown();
		System.out.println("Thread End");
	}
	
	private static class Task implements Callable<Integer> {
		int rand = 10 + rd.nextInt(11);
		@Override
		public Integer call() throws Exception {
			// task random number from 10 to 20
			ThreadUtils.strartThread(rand);
			doTask(2, TimeUnit.SECONDS);
			return rand;
		}
		
	}
}
