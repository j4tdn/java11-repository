package thread.pool;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;


public class Ex04 {
	private static ExecutorService service;
	private static int poolsize = 4;
	 
	static {
		service = Executors.newFixedThreadPool(poolsize); 
	}
	
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		FutureTask<List<Integer>> digitTask = new FutureTask<>(() -> loadDigits());	
		FutureTask<List<String>> textTask = new FutureTask<>(() -> loadTexts());	
		
		// submit tasks
		runTask(Arrays.asList(digitTask, textTask));
		
		// get return value
		List<Integer> digits = digitTask.get();
		List<String> texts = textTask.get();
		
		System.out.println(digits);
		System.out.println(texts);
		service.shutdown();
	}
	
	
	
	private static void runTask(List<FutureTask<?>> tasks) {
		tasks.forEach(service::submit);
	}



	private static List<Integer> loadDigits(){
		return Arrays.asList(1,2,3,4,5);
	}
	
	private static List<String> loadTexts(){
		return Arrays.asList("a", "b", "c", "d");
	}
}
