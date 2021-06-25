package mutable;

import java.util.concurrent.TimeUnit;

public class Ex02 {
	public static void main(String[] args) {
		// Thread

		System.out.println("Ex02#main - start");
		System.out.println(Thread.currentThread().getName() + " is running");
		Thread t0 = new Thread(new Task(), "thread-0");
		t0.start();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Ex02main - end");
	}

	private static class Task implements Runnable {
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + "is running...");
			System.out.println("Task#run ...");
		}
	}

}
