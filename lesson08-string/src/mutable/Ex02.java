package mutable;

import java.util.concurrent.TimeUnit;

public class Ex02 {
	public static void main(String[] args) {
		// Thread
		// default: single thread - thread main
		System.out.println("EX02#main - start");

		System.out.println(Thread.currentThread().getName() + " is running ...");

		Task task = new Task();
		Thread t0 = new Thread(task, "thread-0");
		t0.start();

		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("EX02#main - end");
	}

	// thread execute task - runnale
	public static class Task implements Runnable {
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + " is running ...");
			System.out.println("Task#run ...");
		}
	}
}
