package thread.core;

import static utils.ThreadUtils.*;

import java.util.concurrent.TimeUnit;

public class Ex01 {
	public static void main(String[] args) {
		System.out.println("main start");
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				doTask(2, TimeUnit.SECONDS);
				
				printCurThreadName();
				System.out.println("running");
			}
		}, "thread 1");
		t1.start();
		
		// current thread
		printCurThreadName();
		
		System.out.println("main end");
	}
}