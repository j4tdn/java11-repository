package thread.core;

import utils.ThreadUtils;

public class Ex01 {
	public static void main(String[] args) {
		System.out.println("main start");
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				ThreadUtils.printCurrentThreadName();
			}
		}, "thread1");
		
		t1.start();
		
		System.out.println("=======================");
		System.out.println("main end");
	}
}
