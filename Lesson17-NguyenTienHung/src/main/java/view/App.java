package view;

import java.time.LocalDate;
import java.time.Month;

import service.ItemByService;

public class App {
	private static ItemByService itemByDateService;
	public static void main(String[] args) {
     itemByDateService = new ItemByService();
      LocalDate localDate =LocalDate.of(2019, Month.NOVEMBER, 23);
      
    // System.out.println("1.Yeu cau :"+itemByDateService.getItemByDate(localDate));
	
      System.out.println("2.Yeu cau :"+itemByDateService.getItemByQuantity());
	
	
	}
}
