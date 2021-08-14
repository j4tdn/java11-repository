package demo;

import bean.Apple;

public class Ex03 {
	public static void main(String[] args) {
		// local variable

		Runnable runnable = running(2000);
		runnable.run();


		final int a = 10;
		//a =20;

		final Apple a1 = new Apple();
		final Apple a2 = new Apple();
		// a1= a2; not allowed
		a1.setColor("yellow"); // allowed

		//final >> primitive: can not reassign value
		//final >> object: can not reassign reference's address.

	}

	private static Runnable running(int time) {
		// lexical scope
		// local variable
		// outer scope
		String jobName = "Queue Job";
		Apple jobDetail = new Apple(1, "black", 100, "Lao");

		// anonymous class >> contains method run
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
				// jobName = "Stack Job";
				jobDetail.setColor("white");
				System.out.println(jobName + "is running about " + time + "ms" );
				System.out.println("JobDetail: " + jobDetail);

			}
		};
	}
}
