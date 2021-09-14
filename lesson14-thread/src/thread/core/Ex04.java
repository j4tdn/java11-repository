package thread.core;

import static utils.ThreadUtils.*;

import java.util.concurrent.TimeUnit;

public class Ex04 {
	// Task: Took 3 seconds
	// Demo performance case with 3 calculation tasks
	// Run single thread: Took 9 seconds
	// run parallel with 3 threads: Took 3 seconds
	
	private static long start = 0;
	public static void main(String[] args) {
		Task task1 = new Task(3, TimeUnit.SECONDS);
		Task task2 = new Task(4, TimeUnit.SECONDS);
		Task task3 = new Task(3, TimeUnit.SECONDS);
		
		start = System.currentTimeMillis();
		
		Thread t1 = new Thread(task1, "Thread1");
		t1.start();
		Thread t2 = new Thread(task1, "Thread2");
		t2.start();
		Thread t3 = new Thread(task1, "Thread3");
		t3.start();

		System.out.println("Tooks: " + (System.currentTimeMillis() - start) + "ms");
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
			System.out.println(getThredName() + "tooks" + (System.currentTimeMillis()- start));;
		}
	}
}
