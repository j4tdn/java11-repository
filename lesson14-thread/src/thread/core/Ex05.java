package thread.core;

public class Ex05 {
	// volatile >> read data from main memory
	// non-volatile >> read data from each CPU cache >> reduce wrong case
	private static int counter = 2;

	// #main +=2
	// thread1 +=1
	// thread2 *=2
	public static void main(String[] args) {
		System.out.println("thread main start");

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("#Thread1 is running ...");
				counter++;
				System.out.println("#thread1 counter: " + counter);
			}
		});
		t1.start();

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("#Thread2 is running ...");
				counter*=2;
				System.out.println("#thread2 counter: " + counter);
			}
		});
		t2.start();

		counter += 2;
		System.out.println("#main counter: " + counter);
		System.out.println("thread main end");

	}
}
