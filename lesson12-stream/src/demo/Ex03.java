package demo;

import bean.Apple;

//class Ex03 >> contains method main & running
public class Ex03 {
	
	//global variables = attributes = properties 
	public static void main(String[] args) {
		//final -> final at stack
		final int a = 10;
		//a =20; error
		
		final Apple a1 = new Apple(); //H1 
		final Apple a2 = new Apple(); //H2
		//a1 = a2;  not allowed 
		a1.setColor("yellow"); //allowed
		
		//final >> primitive: cannot reassign value
		//final >> object: cannot reassign reference's address
		
		Runnable runnable = running(2000);
 		runnable.run();
		
	}
	
	private static Runnable running (int time ) {
		//lexical scope: bien dc dung trong ham running
		//local variable bien cuc bo
		//outer scope
		String jobName = "Queue job";
		Apple jobDetail = new Apple(1, "black", 100, "Lao");
		
		//anonymous class >> contains running	's method
		//Ex03 and Anonymous class are separately 
		return new Runnable() {
			
			//closure function: la 1 anonymous class chua function, co the truy cap cac bien
			// trong outer scope nhung mac dinh la final
			//function can reference to outer scope variables 
			//even those variables are cleared after finish outer function
			//nonlocal 	variables are explicitly final >> FROM version 1.8 
			@Override
			public void run() {
				//local variable
				//inner scope
				//jobName = "STack Job"; error
				jobDetail.setColor("white");
				
				System.out.println(jobName + "is running about" + time + "ms");
				System.out.println("JobDetail: " + jobDetail);
			}
		};
		
	}
}
