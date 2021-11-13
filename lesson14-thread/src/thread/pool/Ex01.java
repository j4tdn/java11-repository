package thread.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import utils.ThreadUtils;

public class Ex01 {
	private static Random rd = new Random();
	private static long start = 0;
	private static int capacity = 20;

	public static void main(String[] args) {
		System.out.println("thread start");
		System.out.println(Runtime.getRuntime().availableProcessors());
		start = System.currentTimeMillis();
		List<Task> tasks = new ArrayList<>(capacity);

		for (int i = 0; i < capacity; i++) {
			long time = 2 + rd.nextInt(6);
			tasks.add(new Task(time, TimeUnit.SECONDS));
		}
		ExecutorService service = Executors.newFixedThreadPool(4);
		for (Task item : tasks) {
			service.execute(item);
		}
		System.out.println("thread end");
	}

	private static class Task implements Runnable {
		private long time;
		private TimeUnit unit;

		public Task(long time, TimeUnit timeUnit) {
			this.time = time;
			this.unit = timeUnit;
		}

		@Override
		public void run() {
			ThreadUtils.startThread(time);
			utils.ThreadUtils.dotask(time, unit);
			ThreadUtils.EndThread(start);

		}

	}

}
