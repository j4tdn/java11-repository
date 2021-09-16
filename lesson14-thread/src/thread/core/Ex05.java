package thread.core;

import javax.sound.midi.Soundbank;

public class Ex05 {
	private static volatile int counter = 2;
	public static void main(String[] args) {
		System.out.println("Thread main strart");
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("t1 is running...");
				counter++;
				System.out.println("#thread1 counter: " + counter);
			}
		}, "thead1");
		t1.start();
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("t2 is running ...");
				counter*=2;
				System.out.println("#thread2 counter: " + counter);
			}
		},"thread2");
		t2.start();
		
		counter += 2;
		System.out.println("#main counter: " + counter);
		System.out.println("thread main end");
	}
}
