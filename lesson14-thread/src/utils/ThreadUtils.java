package utils;

import java.util.concurrent.TimeUnit;

public class ThreadUtils {
	public ThreadUtils() {

	}

	public static void printCurrentThreadName() {
		System.out.println(">> thread #" + getThreadName());
	}

	public static void strartThread(int rand) {
		System.out.println(getThreadName() + " is running..." + rand);
	}
	
	public static void enThread(long start) {
		System.out.println(Thread.currentThread().getName() + " took " + (System.currentTimeMillis() - start));
	}
	public static String getThreadName() {
		return Thread.currentThread().getName();
	}
	// virtual task with a certain time
	public static void doTask(long time, TimeUnit unit) {
		try {
			unit.sleep(time);
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
