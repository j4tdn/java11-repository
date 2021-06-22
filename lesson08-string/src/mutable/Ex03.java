package mutable;

public class Ex03 {
	public static void main(String[] args) throws InterruptedException {
		// Mutable: StringBuilder - StringBuffer
		MutableTask task = new MutableTask();
		Thread tA = new Thread(task, "Thread-A");
		Thread tB = new Thread(task, "Thread-A");

		tA.start();
		tB.start();

		// make sure threadA finish then go on with thread main
		tA.join();
		tB.join();
		
		System.out.println("length: " + task.getLength());
	}
	
	public static class MutableTask implements Runnable{
		// multiple threads access this task with share data
		
//		private StringBuffer mutable;
		private StringBuilder mutable;
		private int count = 500000;
		
		public MutableTask() {
//			mutable = new StringBuffer();
			mutable = new StringBuilder();
		}
		@Override
		public void run() {
			for(int i= 1; i<= count; i++) {
				mutable.append("a");
			}
		}
		
		public int getLength() {
			return mutable.length();
		}
	}
}
