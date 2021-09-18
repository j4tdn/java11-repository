package thread.pool;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;

public class Ex05 {
	private static ExecutorService service;
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		FutureTask<List<Integer>> digitTask =  new FutureTask<>(()-> loadDigit());
		FutureTask<List<String>> textTask = new FutureTask<>(() -> loadText());
	
		submitTasks(Arrays.asList(digitTask,textTask));
		
		List<Integer> digits = digitTask.get();
		List<String> texts = textTask.get();
		System.out.println(digits);
		System.out.println(texts);
	}

	private static void submitTasks(List<FutureTask<?>> tasks) {
		tasks.forEach(service::submit);
	}
	private static List<Integer>loadDigit() {
		return Arrays.asList(1, 2, 3, 4, 5);
	}
	private static List<String> loadText() {
		return Arrays.asList("a", "b", "c", "D", "e");
	}
}
