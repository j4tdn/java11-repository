package thread.core;

public class Ex05 {
	// volatile: read data from main memory
	// non-volatile: read data from CPU cache >> reduce wrong data
	private static volatile int counter = 2;
	
	// #main += 2
	// #thread1 +=1
	// #thread2 *=2
	
	// m12 >> 4 5 10
	// m21 >> 4 8 9
	// 12m >> 3 6 8
	// 1m2 >> 3 5 10
	// 21m >> 4 5 7
	// 2m1 >> 4 6 7
	public static void main(String[] args) {
		System.out.println("Thread main start");
		
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("#thread1 is running ...");
				counter++;
				System.out.println("#thread1 counter: " + counter);
			}
			
		}, "thread 1");
		t1.start();
		
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("#thread2 is running ...");
				counter *= 2;
				System.out.println("#thread2 counter: " + counter);
			}
			
		}, "thread 2");
		t2.start();
		
		counter += 2;
		System.out.println("#main counter: " + counter);
		System.out.println("Thread main end");
	}
}
