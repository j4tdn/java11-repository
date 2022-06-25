package com.spring.sorting;

import java.util.HashMap;
import java.util.Map;

import com.spring.entity.Customer;

public class SortUtils {
	private SortUtils() {
	}
	
	public static Map<String, String> CUSTOMER_ORDER_MAP = new HashMap<String, String>() {
		private static final long serialVersionUID = 4293312786696007788L;

		{
			put("orderByFirstName", Customer.FIRST_NAME);
			put("orderByLastName", Customer.LAST_NAME);
			put("orderByEmail", Customer.EMAIL);
		}
	};
}
