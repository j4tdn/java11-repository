package service;

import java.util.List;

import dao.DetailItemPurchaseDao;
import dao.DetailItemPurchaseDaoImpl;
import persistence.DetaiItemGroupDto;
import persistence.DetailItemPurchaseDto;

public class DetailItemPurchaseServiceImpl implements DetailItemPurchaseService {

	private DetailItemPurchaseDao dao;

	public DetailItemPurchaseServiceImpl() {
		dao = new DetailItemPurchaseDaoImpl();
	}

	@Override
	public List<DetailItemPurchaseDto> get(int year) {
		return dao.get(year);
	}



	

}
