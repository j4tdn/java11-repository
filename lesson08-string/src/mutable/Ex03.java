package mutable;

public class Ex03 {
	public static void main(String[] args) throws InterruptedException {
		// Mutable: StringBuilder - StringBuffer
		
		MutableTask task = new MutableTask();
		
		Thread tA = new Thread(task, "Thread -A");
		tA.start();
		
		Thread tB = new Thread(task, "Thread -B");
		tB.start();
		
		// make sure threadA finish then go on with main thread
		tA.join();
		tB.join();
		
		System.out.println(task.length());
		
	}
	
	public static class MutableTask implements Runnable {
		//multiple thread access this task with share data
		//share data: StringBuilder, StringBuffer
		
//		private StringBuffer mutable;
		private StringBuilder mutable;
		private int count = 50000;
		
		public MutableTask() {
//			mutable = new StringBuffer();
			mutable = new StringBuilder();
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
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
