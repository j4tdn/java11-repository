package spring.core.demo;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.bean.Item;
import spring.core.bean.ItemGroup;


public class Application {

	private static final String contextPath = "spring-beans.xml";

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(contextPath);

		String[] names = context.getBeanDefinitionNames();

		for (String name : names) {
			System.out.println(name);
		}

		System.out.println("===================");

		ItemGroup itemGroupA = context.getBean("igA", ItemGroup.class);
		ItemGroup itemGroupB = context.getBean("igB", ItemGroup.class);
		ItemGroup itemGroupC = context.getBean("igC", ItemGroup.class);

		System.out.println(itemGroupA);
		System.out.println(itemGroupB);
		System.out.println(itemGroupC);

		Item itemA = context.getBean("itemA", Item.class);
		
		System.out.println(itemA);
		
		
		
		context.close();
	}
}
