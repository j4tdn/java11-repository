package demo;

import bean.Apple;

public class Ex03 {
	
	//
	
	public static void main(String[] args) {
		// local variable
		
		
		
		// final >> final at stack
		final int a = 10;
		// a = 20;	
				
		final Apple a1 = new Apple();
		final Apple a2 = new Apple();
		// a1 = a2;            // not allowed
		a1.setColor("yellow"); // allowed
		
		// final >> primitive: cannot reassign value
		// final >> object: cannot reassign reference's address
		
		Runnable runnable = running(2000);
		runnable.run();
	}
	
	private static Runnable running(int time) {
		// lexical scope
		// local variable
		// outer scope
		final String jobName = "Queue Job";
		final Apple jobDetail = new Apple(1, "black", 100, "Lao");
		
		// anonymous class >> contains method run
		// Ex03 and Anonymous class are separate
		return new Runnable() {
			
			// closure function
			// function can reference to outer scope variables
			// even those variable are cleared after finish outer function
			@Override
			public void run() {
				// local variable
				// inner scope
				// jobName = "Stack job";
				jobDetail.setColor("white");
				System.out.println(jobName + "is running ..." + time +"ms");
				System.out.println("JobDetal: " + jobDetail);
			}
		};
	}
}