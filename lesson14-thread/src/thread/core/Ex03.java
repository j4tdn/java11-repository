package thread.core;

import utils.ThreadUtils;

public class Ex03 {

	public static void main(String[] args) {
		System.out.println("main start");
		
		Thread t1 = new Thread(new Task(), "thread1");
		t1.start();
		join(t1);
		
		Thread t2 = new Thread(new Task(), "thread2");
		t2.start();
		join(t2);
		
		ThreadUtils.printCurrentThreadName();
	}
	
	private static class Task implements Runnable {
		@Override
		public void run() {
			ThreadUtils.printCurrentThreadName();
			System.out.println("running a task ...");
		}
	}
	
	private static void join(Thread thread) {
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
