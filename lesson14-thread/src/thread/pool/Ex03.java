package thread.pool;

import static java.util.concurrent.TimeUnit.*;
import static utils.ThreadUtils.*;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

public class Ex03 {
	
	private static Random rd = new Random();
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// Thread, Runnable
		
		// Thread Pool
		// + Blocking Queue
		// + Threads
		
		// Thread Pool
		// + >> execute(Runnable): void
		// + >> submit(Callable<T>): Future<T>
		
		// FutureTask implements RunnableFuture<V> extends Runnable, Future<V>
		// + Callable<T> >> task
		// + Future<T>   >> return value
		
		ExecutorService service = Executors.newSingleThreadExecutor();
		
		FutureTask<Integer> futureTask = new FutureTask<Integer>(new Task());
		
		// submit task >> set return value to FutureTask
		Future<?> future = service.submit(futureTask);
		
		// return
		System.out.println(futureTask.get());
		service.shutdown();
	}
	
	private static class Task implements Callable<Integer> {
		@Override
		public Integer call() throws Exception {
			// task random number from 10 to 20
			int rand = 10 + rd.nextInt(11);
			
			startThread(rand);
			doTask(2, SECONDS);
			return 10 + rd.nextInt(11);
		}
	}
}
