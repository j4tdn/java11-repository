package mutable;

import java.util.concurrent.TimeUnit;

public class Ex02 {
	public static void main(String[] args) {
		System.out.println("Ex02#main - start");
		System.out.println(Thread.currentThread().getName() +"is running....");
		
		
//		Task task  = new Task();
//		task.run();
		Thread t0 = new Thread(new Task(),"thread-0");
		t0.start();
		
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("Ex02#main - end");
	}
	public static class Task implements Runnable{
		@Override
		public void run() {
			System.out.println("Task#run...");
		}
	}
}
