package demo;

import bean.Apple;

public class Ex03 {
	public static void main(String[] args) {
	
		// final >> final at stack
				final int a = 10;
				// a = 20; // not allowed

				final Apple a1 = new Apple(); // H1
				final Apple a2 = new Apple(); // H2
				// a1 = a2; // not allowed
				a1.setColor("yellow"); // allowed
				
				// final >> primitive: cannot reassign value
				// final >> object: cannot reassign reference's address
				
				Runnable runnable = runninng(2000);
				runnable.run();
	}
	
	private static Runnable runninng(int time) {
		//lexical scope 
		//local variable
		//outer scope
		
		String jobName = "Queue job";
		Apple jobDetail = new Apple(1,"blue",100,"Lao");
		
		//anonymous class >> contain method run
		//Ex03and Anonymous class are separated
		return new Runnable() {
			
			//closure function
			//function can reference to outer scope variables
			//even those variables are cleared after finish outer function
			//nonlocal variables are explicitly final >> From ver 1.8
			@Override
			public void run() {
				//local variable
				//inner scope
				System.out.println(jobName + "is running about"+ time+" ms");
				System.out.println("jobDetail" + jobDetail);	
			}
		};
	}
}