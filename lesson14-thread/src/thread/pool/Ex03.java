package thread.pool;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import static utils.ThreadUtils.*;
import static java.util.concurrent.TimeUnit.*;

import javax.tools.DocumentationTool.DocumentationTask;

import utils.ThreadUtils;

public class Ex03 {
	private static Random rd = new Random();
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// thread, Runnable
		
		// thread Pool
		// + Blocking Queue
		// + Threads
		
		// Thread Pool
		// + >> execute(Runnable): void
		// + >> submit(Callable<T>): Future<T>
		
		ExecutorService service = Executors.newSingleThreadExecutor();
		
		FutureTask<Integer> futureTask = new FutureTask<>(new Task());

		service.submit(futureTask);
		System.out.println(futureTask.get());
	}
	private static class Task implements Callable<Integer>{

		@Override
		public Integer call() throws Exception {
			int rand = 10 + rd.nextInt(11);
			
			ThreadUtils.startThread(rand);
			doTask(2, TimeUnit.SECONDS);
			return rand;
		}
		
	}
}
