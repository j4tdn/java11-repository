package service;

import java.util.List;

import dao.DetailItemGroupDao;
import dao.DetailItemGroupDaoImpl;
import persistence.DetaiItemGroupDto;

public class DetaiItemGroupServiceImpl implements DetaiItemGroupService{
	
	private DetailItemGroupDao dao;
	
	public DetaiItemGroupServiceImpl() {
		dao= new DetailItemGroupDaoImpl(); 
	}
	public List<DetaiItemGroupDto> get(){
		return dao.get();
	}
}
