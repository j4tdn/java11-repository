package service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.ItemDAO;
import persistence.ItemByDate;
import persistence.ItemByQuantity;

public class ItemByService {
	private ItemDAO itemByDateDAO;

	public ItemByService() {
		itemByDateDAO = new ItemDAO();
	}

	public List<ItemByDate> getItemByDate(LocalDate time) {
		return itemByDateDAO.getItemByDate(time);

	}

	public List<ItemByQuantity> getItemByQuantity() {
		return itemByDateDAO.getItemByQuantity();
	}
}
