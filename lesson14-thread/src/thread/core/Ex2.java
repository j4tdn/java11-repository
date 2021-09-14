package thread.core;

import java.util.concurrent.TimeUnit;

import utils.ThreadUtils;

public class Ex2 {
	public static void main(String[] args) {
		System.out.println("Hoa");
		Thread t1 = new Thread(new Task(), "thread1");
		t1.start(); // automatically call t1.run >> runnable

		// current thread
		ThreadUtils.printCurrentThreadName();
		System.out.println("dep troai");
	}

	private static class Task implements Runnable {

		@Override
		public void run() {
			// prepare data took 2 seconds
			ThreadUtils.doTask(2, TimeUnit.SECONDS);

			ThreadUtils.printCurrentThreadName();
			System.out.println("running a task ...");

		}
	}
}
