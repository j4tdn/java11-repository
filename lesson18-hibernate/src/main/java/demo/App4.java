package demo;

import java.util.List;

import dao.HibernateItemGroupDao;
import dao.ItemGroupDao;
import persistence.ItemGroupDto;
import utils.SqlUtils;

public class App4 {
	private static ItemGroupDao itemGroupDao;
	
	static {
		itemGroupDao = new HibernateItemGroupDao();
	}
	
	public static void main(String[] args) {
		List<ItemGroupDto> itemGroupDtos = itemGroupDao.getItemsByItemGroupId();
		SqlUtils.print(itemGroupDtos);
	}
}
