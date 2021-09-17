package thread.core;

import static utils.ThreadUtils.join;
import static utils.ThreadUtils.printCurrentThreadName;

public class Ex03 {
	public static void main(String[] args) {
		Thread t1 = new Thread(new Task(), "thread 1");
		t1.start();
		join(t1);
		
		Thread t2 = new Thread(new Task(), "thread 2");
		t2.start();
		join(t2);
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