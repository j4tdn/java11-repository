package thread.core;

import java.util.concurrent.TimeUnit;

import utils.ThreadUtils;

public class Ex01 {
	// thread main
	public static void main(String[] args) {
		// Thread t1 = new Thread(runnable);
		// t1.start() >> t1.run()[native method] >> t1.run() {runnable.run()}
		System.out.println("=== MainStart ===");
		System.out.println("something");

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				// prepare data took
				ThreadUtils.doTask(2, TimeUnit.SECONDS);
				
				ThreadUtils.printCurrentThreadName();
				System.out.println("running a task...");
			}
		}, "thread 1");
		t1.start(); // automatically call t1.run >> runnable
		
		// current thread
		ThreadUtils.printCurrentThreadName();

		System.out.println("anything");
		System.out.println("=== MainEnd ===");
	}
}
