package thread.core;

import utils.ThreadUtils;

public class Ex03 {
	public static void main(String[] args) {
		System.out.println("main start");
		Thread t1 = new Thread(new Task(), "thread1");
		t1.start();
		ThreadUtils.join(t1);
		Thread t2 = new Thread(new Task(), "thread2");
		t2.start();
		ThreadUtils.join(t2);

		ThreadUtils.currentThread();
		System.out.println("main end");
	}

	private static class Task implements Runnable {

		@Override
		public void run() {
			ThreadUtils.currentThread();
			System.out.println("running a task ....");
		}

	}
}