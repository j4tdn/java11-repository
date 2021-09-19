package utils;

import java.util.concurrent.TimeUnit;

public class ThreadUtils {
	private ThreadUtils() {
	}
	
	public static void printCurrentThreadName() {
		System.out.println(">> Thread #" + Thread.currentThread().getName());
	}
	
	public static void startThread() {
		System.out.println(Thread.currentThread().getName() + " is running");
	}
	
	public static void startThread(long time) {
		System.out.println(Thread.currentThread().getName() + " is running ... " + time);
	}
	
	public static String getThredName() {
		return Thread.currentThread().getName();
	}
	
	// virtual task
	public static void doTask(long time, TimeUnit unit) {
		try {
			unit.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void endThread(long start) {
		System.out.println(Thread.currentThread().getName() + " took " + (System.currentTimeMillis() - start));
	}
}
