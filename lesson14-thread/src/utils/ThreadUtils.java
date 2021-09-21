package utils;

import java.util.concurrent.TimeUnit;

public class ThreadUtils {
	public ThreadUtils() {
		// TODO Auto-generated constructor stub
	}
	
	public static void printCurThreadName() {
		System.out.println("current thread # " + Thread.currentThread().getName());
	}
	public static void startThread() {
		System.out.println(Thread.currentThread().getName() + " is running ...");
	}
	
	public static void startThread(long time) {
		System.out.println(Thread.currentThread().getName() + " is running ... " + time );
	}
	
	public static void endThread(long start) {
		System.out.println(Thread.currentThread().getName() + " took" + (System.currentTimeMillis()- start));
	}
	
	public static void doTask(long time, TimeUnit unit) {
		try {
			unit.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void join(Thread thread) {
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}