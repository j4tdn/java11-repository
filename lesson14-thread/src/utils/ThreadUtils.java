package utils;

import java.util.concurrent.TimeUnit;

public class ThreadUtils {
	private ThreadUtils() {
	}
	
	public static String getThreadName() {
		return Thread.currentThread().getName();
	}
	
	public static void printCurrentThreadName() {
		System.out.println(">> thread #" + Thread.currentThread().getName());
	}
	
	public static void startThread() {
		System.out.println(Thread.currentThread().getName() + "is running ...");
	}
	
	// virtual task with a certain time
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
