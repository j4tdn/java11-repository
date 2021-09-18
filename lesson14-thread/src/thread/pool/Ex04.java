package thread.pool;
import static utils.ThreadUtils.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import utils.ThreadUtils;


/*
 * Thread Poll
 * + pool size: number of thread
 * + blocking queue: number of tasks
 */
public class Ex04 {
	private static Random rd = new Random();
	private static int capacity = 20;
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("thread start");
		
		
		//blocking queue
		List<FutureTask<Integer>> futureTasks = new ArrayList<>(capacity);
		for(int i =0; i< capacity; i++) {
			futureTasks.add(new FutureTask<Integer>(new Task()));
		}
		
	// thread pool - idea processors
	ExecutorService service =	Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
	for (FutureTask<Integer> futureTask : futureTasks) {
		 service.submit(futureTask);
		 System.out.println("random: " + futureTask.get());
	}
	
	// shutdown thread pools
	service.shutdown();
	System.out.println("thread end");
	}
	
	
	private static class Task implements Callable<Integer>{

		@Override
		public Integer call() throws Exception {
			//task random number from 10 to 20
			int rand = 10+ rd.nextInt(11);
			ThreadUtils.startThread(rand);
			doTask(2, TimeUnit.SECONDS );
			return 10 + rd.nextInt();
		}
		
			
		
		
	}
}
