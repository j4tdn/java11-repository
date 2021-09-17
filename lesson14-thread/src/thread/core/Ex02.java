package thread.core;

import static utils.ThreadUtils.printCurrentThreadName;

public class Ex02 {
	public static void main(String[] args) {
		System.out.println("main start");
		Thread t1 = new Thread(new Task(), "thread 1");
		t1.start();

		// current thread
		printCurrentThreadName();
		System.out.println("main end");
	}

	private static class Task implements Runnable {
		@Override
		public void run() {
			printCurrentThreadName();
			System.out.println("running");
		}
	}
}