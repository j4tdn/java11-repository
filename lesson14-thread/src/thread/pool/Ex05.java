package thread.pool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Ex05 {
	private static ExecutorService service;
	private static int pool = Runtime.getRuntime().availableProcessors();
	static {
		service = Executors.newFixedThreadPool(pool);
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		FutureTask<List<Integer>> digitTask = new FutureTask<>(() -> loadDigits());
		FutureTask<List<String>> TextTask = new FutureTask<>(() -> loadText());
		submitTask(Arrays.asList(digitTask, TextTask));
		List<Integer> digits = digitTask.get();
		List<String> texts = TextTask.get();
	}

	private static void submitTask(List<FutureTask<?>> futureTasks) {
		futureTasks.forEach(service::submit);
	}

	private static List<Integer> loadDigits() {
		return Arrays.asList(1, 23, 4, 5);
	}

	private static List<String> loadText() {
		return Arrays.asList("k", "h", "o", "a");
	}
}
