package thread.pool;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Ex05 {

	private static ExecutorService service;
	private static int poolSize = 4;

	static {
		service = Executors.newFixedThreadPool(poolSize);
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		FutureTask<List<Integer>> digitTask = new FutureTask<>(() -> loadDigits());
		FutureTask<List<String>> textTask = new FutureTask<>(() -> loadTexts());

		// submits tasks
		submitTask(Arrays.asList(digitTask, textTask));

		// get return value
		List<Integer> digits = digitTask.get();
		List<String> texts = textTask.get();

		System.out.println(digits);
		System.out.println(texts);
		service.shutdown();
	}

	private static void submitTask(List<FutureTask<?>> tasks) {
		for (FutureTask<?> task : tasks) {
			service.submit(task);
		}
		// tasks.forEach(service::submit);
	}

	// query from database
	private static List<Integer> loadDigits() {
		return Arrays.asList(1, 2, 3, 4, 5);
	}

	private static List<String> loadTexts() {
		return Arrays.asList("a", "b", "m", "n", "x");
	}

}
