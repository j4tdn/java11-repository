package demo;

import java.util.List;

import dao.HibernateGroupDao;
import persistence.ItemGroup;

public class App {
	public static void main(String[] args) {
//		SessionFactory sessionFactory = HibernateProvider.getSessionFactory();
		HibernateGroupDao hibernateGroupDao = new HibernateGroupDao();
		List<ItemGroup> list = hibernateGroupDao.getAll();
		System.out.println(list);
	}
}
