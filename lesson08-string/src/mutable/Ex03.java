package mutable;

import java.util.concurrent.TimeUnit;

// StringBuilder versus StringBuffer
public class Ex03 {
	public static void main(String[] args) throws InterruptedException {
		
		MutableTask task = new MutableTask();
		Thread t0 = new Thread(task, "Thread-0");
		t0.start();
		
		Thread t1 = new Thread(task, "Thread-1");
		t1.start();
		
		t0.join();
		t1.join();
		System.out.println("Mutable String length: " + task.length());
	}
	
	private static class MutableTask implements Runnable{
		private StringBuffer multable;
		private static long COUNT = 50000;
		public MutableTask() {
			multable = new StringBuffer();
		}
		@Override
		public void run() {
			System.out.println("threaad " + Thread.currentThread().getName()+ " is running");
			for(int i = 1; i < COUNT; i++) {
				multable.append("a");
			}
		}
		 
		public int length() {
			return multable.length();
		}
	}
}
