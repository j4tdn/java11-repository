package thread.core;

import java.util.concurrent.TimeUnit;

import utils.ThreadUtils;

public class Ex02 {
	public static void main(String[] args) {
		System.out.println("main start");
		Thread t1 = new Thread(new Task(), "thread1");
		t1.start();

		ThreadUtils.currentThread();
		System.out.println("main end");
	}

	private static class Task implements Runnable {

		@Override
		public void run() {
			ThreadUtils.dotask(2, TimeUnit.SECONDS);
			ThreadUtils.currentThread();
			System.out.println("running a task ....");
		}

	}
}