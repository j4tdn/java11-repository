package mutable;

public class Ex03 {
	public static void main(String[] args) throws InterruptedException {
		MutableTask task = new MutableTask();
		Thread t0 = new Thread(task, "Thread-0");
		t0.start();
		Thread t1 = new Thread(task, "Thread-1");
		t1.start();

		t0.join();
		t1.join();

		System.out.println("Mutable String length: " + task.length());
	}

	private static class MutableTask implements Runnable {
		private StringBuffer mutable;
		private static long COUNT = 50000;

		public MutableTask() {
			mutable = new StringBuffer();
		}

		@Override
		public void run() {
			System.out.println("thread " + Thread.currentThread().getName() + "is running ...");
			for (int i = 1; i <= COUNT; i++) {
				mutable.append("a");
			}

		}

		public int length() {
			return mutable.length();
		}

	}
}
