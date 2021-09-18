package thread.pool;

import static utils.ThreadUtils.doTask;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import utils.ThreadUtils;

public class Ex03 {
	
	private static final Random rd = new Random();
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService service = Executors.newSingleThreadExecutor();
		
		FutureTask<Integer> futureTask = new FutureTask<>(new Task());
		
		service.submit(futureTask);
		
		System.out.println(futureTask.get());
		service.shutdown();
	}
	
	private static class Task implements Callable<Integer> {

		@Override
		public Integer call() throws Exception {
			int rand = 10 + rd.nextInt(11);
			
			ThreadUtils.startThread(rand);
			doTask(2, TimeUnit.SECONDS);
			return 10 + rd.nextInt(11);
		}
		
	}
}
