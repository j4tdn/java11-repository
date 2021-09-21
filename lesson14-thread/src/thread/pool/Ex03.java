package thread.pool;

import static utils.ThreadUtils.startThread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Ex03 {
	private static Random rd = new Random();
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// Thread , Runable 
		// Thread Pool 
		// + pool size 
		// + blocking queue
		
		// Thread pool
		// + >> execute(Runable) : void
		// + >> submit(Callable<T>) : Future<T>
		
		// FutureTask
		// + Callable<T> >> task
		// + Future<T> >> return value
		
		ExecutorService service =  Executors.newSingleThreadExecutor();
		FutureTask<Integer> futureTask = new FutureTask<>(new Task());
		
		// submit task >>  set return value to FutureTask
		service.submit(futureTask);
		
		// return 
		System.out.print(futureTask.get());
		
		service.shutdown();
	}
	
private static class Task  implements Callable<Integer> { 
		
		@Override
		public Integer call() throws Exception {
			// tasks random number from 10 to 20
			int rand = 10 + rd.nextInt(11);
			startThread(rand);
			return rand;
		}
	}
}