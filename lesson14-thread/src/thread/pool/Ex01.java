package thread.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static utils.ThreadUtils.*;

/**
 * Thread Pool
 * + pool size: number of threads
 * + blocking queue: number of tasks
 */
public class Ex01 {
	private static Random rd = new Random();
	private static long start = 0;
	private static int capacity = 20;
	
	public static void main(String[] args) {
		System.out.println("thread start");
		
		start = System.currentTimeMillis();
		
		// blocking queue
		List<Task> tasks = new ArrayList<>(capacity);
		for (int i = 0; i < capacity; i++) {
			long time = 2 + rd.nextInt(6);
			tasks.add(new Task(time, TimeUnit.SECONDS));
		}
		
		// thread pool - idea processors
		int processors = Runtime.getRuntime().availableProcessors();
		System.out.println("processors: " + processors);
		ExecutorService service = Executors.newFixedThreadPool(processors);
		for (Task task: tasks) {
			service.execute(task);
		}
		
		System.out.println("thread end");
		
	}
	
	private static class Task implements Runnable {
		
		private long time;
		private TimeUnit unit;
		
		public Task(long time, TimeUnit unit) {
			this.time = time;
			this.unit = unit;
		}
		
		@Override
		public void run() {
			startThread(time);
			doTask(time, unit);
			endThread(start);
		}
	}
}
