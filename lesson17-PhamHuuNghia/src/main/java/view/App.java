package view;

import static utils.SqlUtils.*;

import persistence.DetailItemPurchaseDto;
import service.DetaiItemGroupService;
import service.DetaiItemGroupServiceImpl;
import service.DetaiItemService;
import service.DetailItemPurchaseService;
import service.DetailItemPurchaseServiceImpl;
import service.DetailItemServiceImpl;

public class App {

	private static DetaiItemGroupService detaiItemGroupService;
	private static DetailItemPurchaseService detailItemPurchaseService ;
	private static DetaiItemService detaiItemService; 
	static {
		detaiItemGroupService = new DetaiItemGroupServiceImpl();
		detailItemPurchaseService=new DetailItemPurchaseServiceImpl();
		detaiItemService=new DetailItemServiceImpl();
	}

	public static void main(String[] args) {
		
		
		System.out.println("========Cau 2===========");
		print(detaiItemGroupService.get());
		
		System.out.println("========Cau 3===========");
		print(DetailItemPurchaseDto.transferToListName(detailItemPurchaseService.get(2020)));
		
		System.out.println("========Cau 4===========");
		print(detaiItemService.get());
	}

}
