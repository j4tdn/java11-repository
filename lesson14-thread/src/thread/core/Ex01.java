package thread.core;

import static utils.ThreadUtils.*;

import java.util.concurrent.TimeUnit;

public class Ex01 {
	public static void main(String[] args) {
		System.out.println("main start");
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// prepare data took 2s
				doTask(2, TimeUnit.SECONDS);
				printCurrentThreadName();
				System.out.println("running a task.....");
			}
		},"thread1");
		t1.start();
		
		
		//current thread
		
		printCurrentThreadName();;
		System.out.println("main end");
	}
}
