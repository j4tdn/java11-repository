package mutable;

public class Ex03 {
	public static void main(String[] args) throws InterruptedException {
		MutableTask task = new MutableTask();
		
		Thread tA = new Thread(task, "Thread-A");
		tA.start();
		Thread tB = new Thread(task, "Thread-B");
		tB.start();
		
		tA.join();
		tB.join();
		
		System.out.println("length: " + task.length());
		
	}
	public static class MutableTask implements Runnable {
		private StringBuffer mutable;
		private int count = 50000;
		
		public MutableTask() {
			mutable = new StringBuffer();
			
		}
		
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + "is running ...");
			for(int i = 0; i <= count; i++) {
				mutable.append("a");
			}
			
		}
		public int length() {
			return mutable.length();
		}
	}

}
