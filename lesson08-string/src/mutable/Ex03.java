package mutable;

public class Ex03 {
	public static void main(String[] args) throws InterruptedException {
		MutableTask task = new MutableTask();
		
		Thread tA = new Thread(task,"Thread-A");
		Thread tB = new Thread(task,"Thread-B");
		tA.start();
		tB.start();
		
		tA.join();
		tB.join();
		
		System.out.println("length : " + task.lenght());
	}
	
	public static class MutableTask implements Runnable {
		// multiple thread access this task
		// share data
		//private StringBuilder mutable;
		private StringBuffer mutable;
		private int count = 50000;
		
		public MutableTask() {
			mutable = new StringBuffer();
		}
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + " is running ...");
			for(int i = 0; i < count; i++) {
				mutable.append("a");
			}
			
		}
		
		public int lenght() {
			return mutable.length();
		}
		
	}
}
