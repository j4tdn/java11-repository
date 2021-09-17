package thread.core;

import java.util.concurrent.TimeUnit;

import utils.ThreadUtils;

public class Ex01 {
	public static void main(String[] args) {
		System.out.println("something");
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				ThreadUtils.doTask(2, TimeUnit.SECONDS);
				
				ThreadUtils.printCurrentThreadName();
				System.out.println("Running a task ... ");
			}
		}, "thread1");
		
		t1.start();	// automatically call t1.run
		
		// current thread
		ThreadUtils.printCurrentThreadName();
		
		System.out.println("anything");
	}
	
}