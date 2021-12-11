package demo;

import org.hibernate.SessionFactory;

import utils.HibernateProvider;

public class App {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateProvider.getSessionFactory();
		System.out.println(sessionFactory);
	}
}
