package mutable;

public class Ex03 {
	public static void main(String[] args) throws InterruptedException {
		// Mutable: StringBuilder - StringBuffer
		// One task and theads execute
		MutableTask task = new MutableTask();
		Thread tA = new Thread(task, "Thread-A");
		tA.start();
		
		Thread tB = new Thread(task, "Thread-B");
		tB.start();
		
		// make sure thread A finish then go on with thread main
		tA.join();
		tB.join();
		System.out.println("length: " + task.length());
	}
	
	public static class MutableTask implements Runnable {
		// multiple threads access this task with share data
		// share data: StringBuilder, String Buffer
		
		// private StringBuffer mutable;
		private StringBuilder mutable;
		private int count = 50000;
		
		public MutableTask() {
			// mutable = new StringBuffer();
			mutable = new StringBuilder();
		}

		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + " is running...");
			for (int i = 1; i <= count; i++) {
				mutable.append("a");
			}
			
		}
		public int length() {
			return mutable.length();
		}
	}
}
