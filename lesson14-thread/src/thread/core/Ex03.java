package thread.core;

import static utils.ThreadUtils.*;

import java.util.concurrent.TimeUnit;


public class Ex03 {
	public static void main(String[] args) { // anonymous class
		
		System.out.println("main start");
		
		Thread t1 = new Thread(new Task(), "thread 1");
		t1.start(); // automatically call t1.run
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
			doTask(2, TimeUnit.SECONDS);
			
			printCurrentThreadName();
			System.out.println("running a task ....");
		}
		
	}
	
}
