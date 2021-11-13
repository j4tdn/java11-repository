package thread.core;

import java.util.concurrent.TimeUnit;

import utils.ThreadUtils;

public class Ex01 {
	public static void main(String[] args) {
		System.out.println("main start");
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				ThreadUtils.dotask(2, TimeUnit.SECONDS);
				ThreadUtils.currentThread();
				System.out.println("running a task ....");
			}
		}, "thread1");
		t1.start();

		ThreadUtils.currentThread();
		System.out.println("main end");
	}
}
