package utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import allocation.Store;

public class FileUtils {
	// step 1: Filling in missing “Expected Sales” values

	public static String notification(List<Store> data) {
		for (Store store : data) {
			if(store.getExpectedSales() == null && store.getReferenceStoreId() ==0) {
				return "Expected sales cannot be calculated. Please add a reference store or include stores with expected sales for interpolation";
			}
		}
		return null;
	}

	private static Map<Store, BigDecimal> filling (List<Store> data) {
		Map<Store, BigDecimal> result = new HashMap<Store, BigDecimal>();
		for (Store store : data) {
			if(store.getReferenceStoreId() == 0) {
				
			};
		}
	}

}
