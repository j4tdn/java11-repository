package spring.aop.demo;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.aop.configuration.AppConfig;
import spring.aop.service.MovieService;

public class Application {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		 
		MovieService movieService = context.getBean("movieService", MovieService.class);
		movieService.addMovie();
		movieService.updateMovie();
		
		context.close();
	}

}
