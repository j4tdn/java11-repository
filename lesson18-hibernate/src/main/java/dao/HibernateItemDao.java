package dao;

import java.util.List;

import persistence.Item;

public interface HibernateItemDao {
	List<Item> getAll();
}
