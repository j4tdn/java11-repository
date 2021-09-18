package thread.pool;

import static utils.ThreadUtils.doTask;
import static utils.ThreadUtils.startThread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class Ex03 {
	private static Random rd = new Random();
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// thread, Runnable
		
		// thread pool
		// + blocking queue
		// + threads
		
		// thread pool 
		// + >> execute(Runnable):void
		// + >> submit(Callable<T>):  Future<T>
		
		// FutureTask implements RunnableFuture<V> extends Runnable, Future<V>
		// + Callable<T>	>> task
		// + Future  		>> return value
		
		ExecutorService service = Executors.newSingleThreadExecutor();

		FutureTask<Integer> futureTask = new FutureTask<>(new Task());
	
		//submit task >> set return value to FutureTask
		service.submit(futureTask);
	
		// return 
		System.out.println(futureTask.get());
		service.shutdown();
		
		
	}
	private static class Task implements Callable<Integer>{
		@Override
		public Integer call() throws Exception {
			// task random number from 10 - 20
			startThread();
			int rand = 10 + rd.nextInt(11);
			doTask(2 , TimeUnit.SECONDS);
			return rand;
		}
	}
}
