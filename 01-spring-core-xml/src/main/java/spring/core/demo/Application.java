package spring.core.demo;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.bean.Item;
import spring.core.bean.ItemGroup;
import spring.core.service.ClientService;

public class Application {
	
	private static final String contextPath = "spring-beans.xml";
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(contextPath);
		
		String[] beanNames = context.getBeanDefinitionNames();
		
		for (String beanName: beanNames) {
			System.out.println(beanName);
		}
		
		System.out.println("==================");
		ItemGroup igA = context.getBean("igA", ItemGroup.class);
		ItemGroup igC = context.getBean("igC", ItemGroup.class);
		Item itemA = context.getBean("itemA", Item.class);
		ClientService clienService = context.getBean("clientA", ClientService.class);
		
		System.out.println("igA: " + igA);
		System.out.println("igC: " + igC);
		System.out.println("itemA: " + itemA);
		
		clienService.clientInfo();
		
		System.out.println("====================");
		ItemGroup igB1 = context.getBean("igB", ItemGroup.class);
		igB1.setName("Item Group XYZ");
		System.out.println("igB1: " + igB1);
		
		ItemGroup igB2 = context.getBean("igB", ItemGroup.class);
		System.out.println("igB2: " + igB2);
		
		context.close();
	}
}
