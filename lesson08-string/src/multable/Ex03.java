package multable;


public class Ex03 {
	public static void main(String[] args) throws InterruptedException{
		//Mutable: StringBuilder- StringBuffer
		MutableTask task = new MutableTask();
		
		Thread tA = new Thread(task,"Thread-A");
		tA.start();
		
		Thread tB = new Thread(task, "Thread-B");
		tB.start();
		
		//make sure thread A finish then go on with thread main 
		tA.join();
		tB.join();
		
		
		System.out.println("length: " +task.length());
	}
	
	public static class MutableTask implements Runnable {
		//multiple threads access this task with share data
		//share data: StringBuilder, StringBuffer
		
		//private StringBuffer multable;
		private StringBuilder multable;
		private int count = 50000;
		
		public MutableTask() {
			//mutable = new StringBuffer();
			multable = new StringBuilder();
		}
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + " is running....");
			for(int i = 1; i<= count; i++) {
				multable.append("a");
			}
		}
		public int length() {
			return multable.length();
		}
		
	}
}