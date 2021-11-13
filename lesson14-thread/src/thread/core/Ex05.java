package thread.core;

public class Ex05 {
	private static volatile int counter = 2;

	public static void main(String[] args) {
		System.out.println("Thread main start");

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("#thread t1 is running...");
				counter++;
				System.out.println("#thread t1 counter: " + counter);
			}
		}, "Thread1");
		t1.start();
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("#thread t2 is running...");
				counter *= 2;
				System.out.println("#thread t2 counter: " + counter);
			}
		}, "Thread");
		t2.start();
		counter += 2;
		System.out.println("#main counter: " + counter);
		System.out.println("Thread main end");
	}
}
