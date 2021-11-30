package dao;

import java.sql.Connection;

import connection.DbManager;

public class ItemDaoImpl {
	private final Connection  connection;

	
	public ItemDaoImpl() {
		connection = DbManager.getConnection();
	}
}
