package spring.aop.demo;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.aop.service.MovieService;

public class Application {
private static final String PATH = "aop-jointpoint-advisor-auto-proxy.xml";
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(PATH);
		
		// Get bean proxy and return joinpoint type at runtime
		MovieService service = context.getBean("movieService", MovieService.class);
		
		// Auto proxy
		// MovieService service = context.getBean("movieService", MovieService.class);
		service.printName();
		
		System.out.println("====================");
		
		service.printCatalog();
		
		context.close();
	}
}
