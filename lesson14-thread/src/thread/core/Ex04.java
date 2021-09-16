package thread.core;
import static utils.ThreadUtils.*;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.*;

public class Ex04 {
	private static long start = 0;
	
	public static void main(String[] args) {
		Task task1 = new Task(3, SECONDS);
		Task task2 = new Task(4, SECONDS);
		Task task3 = new Task(3, SECONDS);
		
		start = System.currentTimeMillis();
		
		Thread t1 = new Thread(task1, "thread 1");
		t1.start();
		
		Thread t2 = new Thread(task2, "thread 2");
		t2.start();
		
		Thread t3 = new Thread(task3, "thread 3");
		t3.start();
		
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
			startThread();
			doTask(3, TimeUnit.SECONDS);
			System.out.println("tooks " + (System.currentTimeMillis() - start) + "ms");
		}
	}
}