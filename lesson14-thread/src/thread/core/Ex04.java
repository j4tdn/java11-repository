package thread.core;

import java.util.concurrent.TimeUnit;

import utils.ThreadUtils;

public class Ex04 {
	private static long start = 0;

	public static void main(String[] args) {
		Task task1 = new Task(3, TimeUnit.SECONDS);
		Task task2 = new Task(3, TimeUnit.SECONDS);
		Task task3 = new Task(3, TimeUnit.SECONDS);

		start = System.currentTimeMillis();
		Thread t1 = new Thread(task1, "thread1");
		t1.start();
		Thread t2 = new Thread(task2, "thread2");
		t2.start();
		Thread t3 = new Thread(task3, "thread3");
		t3.start();

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
			ThreadUtils.dotask(time, unit);
			System.out.println(ThreadUtils.getThreadName() + "Tooks " + (System.currentTimeMillis() - start) + "ms");
		}

	}
}
