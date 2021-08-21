package demo;

import bean.Apple;

public class Ex03 {
	public static void main(String[] args) {
		// final >> final at stack
		final int a = 10;
		// a = 20;
		final Apple a1 = new Apple(); // H1
		final Apple a2 = new Apple(); // H2
		// a1 = a2; // not allowed
		a1.setColor("yellow"); // allowed
		
		Runnable runnable = running(2000);
		runnable.run();
	}
	
	private static Runnable running(int time) {
		String jobName = "Queue Job";
		Apple jobDetail = new Apple(1, "black", 100, "Lao");
		
		return new Runnable() {
		
			// closure function
			// function can reference to outer scope variable 
			// even those variables are cleared after finish outer function
			@Override
			public void run() {
				System.out.println(jobName + " is running about " + time + "ms");
				System.out.println("JobDetail: " + jobDetail );
			}
		};
	}
}
