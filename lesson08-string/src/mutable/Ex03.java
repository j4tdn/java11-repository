package mutable;

public class Ex03 {
	public static void main(String[] args) throws InterruptedException {
		//Mutable: StringBuilder - StringBuffer
		MutableTask task = new MutableTask();
		
		Thread tA = new Thread(task, "TaskA");
		tA.start();
		
		Thread tB = new Thread(task,"TaskB");
		tB.start();
		
		tA.join();
		tB.join();
		System.out.println("lenght: " + task.lenght());
		
	}
	
	public static class MutableTask implements Runnable {
		private StringBuilder mutable;
		private int count = 5000;
		public MutableTask() {
			mutable = new StringBuilder();
		}
		
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + "is running ");
			for (int i = 1; i <= count; i++) {
				mutable.append("a");
			}
		}
		
		public int lenght() {
			return mutable.length();
		}
	}
}
