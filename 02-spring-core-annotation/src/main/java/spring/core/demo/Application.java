package spring.core.demo;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.core.bean.MovieRecommender;
import spring.core.config.DemoAppConfiguration;

public class Application {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(DemoAppConfiguration.class);
		showAvailableBeans(context.getBeanDefinitionNames());
	
		MovieRecommender recommender = context.getBean("movieRecommender", MovieRecommender.class);
		recommender.recommend();
		
		context.close();
	}
	
	private static void showAvailableBeans(String[] beanNames) {
		System.out.println("===============");
		for (String beanName: beanNames) {
			System.out.println(beanName);
		}
		System.out.println("===============");
	}
}
