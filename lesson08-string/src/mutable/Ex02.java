package mutable;

public class Ex02 {
	public static void main(String[] args) {
		System.out.println("main thread start");
		Thread t0 = new Thread(new Task(), "Thread-0");
		t0.start();
		System.out.println("main thread end");
	}

	public static class Task implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("current thread: " + Thread.currentThread().getName());
			System.out.println("Excuting thread !!!");
		}

	}
}
