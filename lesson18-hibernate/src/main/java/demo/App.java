package demo;


import provider.HibernateProvider;

public class App {
	public static void main(String[] args) {
		System.out.println(HibernateProvider.getSessionFactory());
	}
}
