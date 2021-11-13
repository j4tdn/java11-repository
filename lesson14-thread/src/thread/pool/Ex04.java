package thread.pool;

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

public class Ex04 {
	private static Random rd = new Random();
	private static long start = 0;
	private static int capacity = 20;

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("thread start");

		List<FutureTask<Integer>> tasks = new ArrayList<>(capacity);

		for (int i = 0; i < capacity; i++) {
			tasks.add(new FutureTask<Integer>(new Task()));
		}
		ExecutorService service = Executors.newFixedThreadPool(4);
		for (FutureTask<Integer> item : tasks) {
			service.submit(item);
			System.out.println("random: " + item.get());
		}
		service.shutdown();
		System.out.println("thread end");
	}

	private static class Task implements Callable<Integer> {

		@Override
		public Integer call() throws Exception {
			int rand = 10 + rd.nextInt(11);
			ThreadUtils.startThread(rand);
			ThreadUtils.dotask(2, TimeUnit.SECONDS);
			return rand;
		}

	}

}
