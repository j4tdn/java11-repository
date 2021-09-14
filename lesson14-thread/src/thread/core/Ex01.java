package thread.core;

import java.util.concurrent.TimeUnit;

import utils.ThreadUtils;

public class Ex01 {
	public static void main(String[] args) {
		// Thread t1 = new Thread(Runnable);
		// t1.start() >>> t1.run()[native method] >> t1.run() {runnable.run()}
		
		System.out.println("Hoa");
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// prepare data took 2 seconds
				ThreadUtils.doTask(2, TimeUnit.SECONDS);
				
				ThreadUtils.printCurrentThreadName();
				System.out.println("running a task ...");
			}
		}, "thread1");
		t1.start(); // automatically call t1.run >> runnable
		
		// current thread
		ThreadUtils.printCurrentThreadName();
		
		System.out.println("dep troai");
	}
}
