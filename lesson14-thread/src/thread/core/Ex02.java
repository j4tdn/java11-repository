package thread.core;

import static utils.ThreadUtils.*;

import java.util.concurrent.TimeUnit;

public class Ex02 {
	public static void main(String[] args) {
		System.out.println("main start");
		Thread t1 = new Thread(new Task(), "thread 1");
		t1.start();

		// current thread
		printCurThreadName();
		System.out.println("main end");
	}

	private static class Task implements Runnable {
		@Override
		public void run() {
			printCurThreadName();
			System.out.println("running");
		}
	}
}