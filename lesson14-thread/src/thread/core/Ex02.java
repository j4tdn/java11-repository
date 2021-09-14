package thread.core;

import static utils.ThreadUtils.*;

import java.util.concurrent.TimeUnit;

public class Ex02 {
		
		// thread main
		public static void main(String[] args) { // anonymous class
			
			System.out.println("main start");
			
			Thread t1 = new Thread(new Task(), "thread 1");
			t1.start(); // automatically call t1.run
			
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


