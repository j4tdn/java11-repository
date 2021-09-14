package utils;

import java.util.concurrent.TimeUnit;

public class ThreadUtils {
	private ThreadUtils() {

	}

	public static void printCurrentThreadName() {
		System.out.println(">> thread #" + Thread.currentThread().getName());
	}

	public static void startThread() {
		System.out.println(Thread.currentThread().getName() + " is running ...");
	}
	
	public static String getThreadName() {
		return Thread.currentThread().getName();
	}

	// virtual task with a certain time
	public static void doTask(long time, TimeUnit unit) {
		try {
			unit.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// block current thread
	public static void join(Thread thread) {
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
