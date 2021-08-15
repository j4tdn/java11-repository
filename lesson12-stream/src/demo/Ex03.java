package demo;

import bean.Apple;

// class Ex03 >> contains method main
public class Ex03 {
	public static void main(String[] args) {
		// final >> final at stack
		final int a = 10;
		// a = 20

		final Apple a1 = new Apple();
		final Apple a2 = new Apple();
		// a1 = a2; // not allowed
		a1.setColor("yellow"); // allowed

		// final >> primitive: cannot reassign value
		// final >> object: cannot reassign references's address

		Runnable run = running(2000);
		run.run();
	}

	private static Runnable running(int time) {
		// lexical scope
		// local variable
		// outer scope
		String jobName = "Queue Job";
		Apple jobDetail = new Apple(1, "Black", 100, "Lao");

		// closure function
		// function can reference to outer scope variables

		// even those variables are cleared after finish outer function
		// nonlocal variables are explicitly final >> FROM version 1.8
		// jobName = "Stack Job";
		return () -> {
			jobDetail.setColor("white");
			System.out.println(jobName + " is running about " + time + "ms");
			System.out.println("JobDetail: " + jobDetail);
		};
	}
}