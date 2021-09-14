package thread.core;
import static utils.ThreadUtils.*;
public class Ex03 {
public static void main(String[] args) throws InterruptedException {
	System.out.println("main start");
	
	Thread t1 = new Thread(new Task(), "thread1");
	t1.start();
	t1.join();
	Thread t2 = new Thread(new Task(), "thread2");
	t2.start();
	t2.join();
	
	printCurrentThreadName();
	System.out.println("main end");
}
private static class Task implements Runnable{
	@Override
	public void run() {
		printCurrentThreadName();
		System.out.println("running a task ...");
}
}
}
