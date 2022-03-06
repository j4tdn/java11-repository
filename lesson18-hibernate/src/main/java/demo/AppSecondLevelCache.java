package demo;

import dao.HibernateItemGroupDao;

public class AppSecondLevelCache {
	private static HibernateItemGroupDao itemGroupDao;
	
	static {
		itemGroupDao = new HibernateItemGroupDao();
	}
	
	public static void main(String[] args) {
		itemGroupDao.demoSlvCache();
	}
}
