package demo;

import javax.print.attribute.standard.JobName;

import bean.Apple;

public class Ex03 {
	public static void main(String[] args) {
		// final >> final at stack
		final int a = 10;
		// a=2;
		final Apple a1 = new Apple(); // H1
		final Apple a2 = new Apple(); // H2
		// a1 = a2; // not allowed
		a1.setColor("yellow"); // allowed

		// final >> primitive : cannot reassign value
		// final >> object: cannot reassign reference's address

		Runnable runnable = running(2000);
		runnable.run();
	}

	private static Runnable running(int time) {
		// lexical scope
		// local variable
		// outer scope
		String jobName = "Queue Job";
		Apple jobDetail = new Apple(1, "black", 100, "Lao");

		// anonymous class >> contain method run
		// Ex03 and Anonymous class are separately
		return new Runnable() {

			// closure function
			// function can reference to outer scope variables
			// even those variables are cleared after finish outer function
			// nonlocal variables are explicitly final >> FROM version 1.8
			@Override
			public void run() {
				// local variable
				// inner scope
				jobDetail.setColor("while");
				System.out.println(jobName + "is running about" + time + "ms");
				System.out.println("jobDetail" + jobDetail);
			}
		};
	}
}
