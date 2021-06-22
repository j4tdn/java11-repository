package mutable;

public class Ex03 {
	public static void main(String[] args) throws InterruptedException {
		MutableTask task = new MutableTask();
		Thread tA = new Thread(task, "thread-A");
		tA.start();

		Thread tB = new Thread(task, "thread-A");
		tB.start();

		tA.join();
		tB.join();

		System.out.println("length: " + task.length());
	}

	public static class MutableTask implements Runnable {
		// multiple threads access this task with share date
		// share data: StringBulder, StringBuffer
		// private StringBuilder mutable;
		private StringBuffer mutable;
		private int count = 50000;

		public MutableTask() {
			// mutable = new StringBuilder()
			mutable = new StringBuffer();
		}

		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + " is running ...");
			for (int i = 1; i <= count; i++) {
				mutable.append("a");
			}
		}

		public int length() {
			return mutable.length();
		}
	}
}
