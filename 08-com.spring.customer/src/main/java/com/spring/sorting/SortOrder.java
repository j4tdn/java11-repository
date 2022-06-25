package com.spring.sorting;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SortOrder {
	private List<SortParam> sortParams = new ArrayList<>();

	public SortOrder addParam(String property, boolean asc) {
		return this.addSortParam(new SortParam(property, asc));
	}

	public SortOrder addSortParam(SortParam sortParam) {
		if (!sortParams.contains(sortParam)) {
			sortParams.add(sortParam);
		}
		return this;
	}

	public List<SortParam> getSortParams() {
		return sortParams;
	}

	public String getSqlOrder() {
		// sortOrder#sortParams{new SortParam(first_name, true), new SortParam(last_name, false)}
		// String sql = "SELECT * FROM customer";
		// sql += sortOrder.getSqlOrder();
		StringBuilder sb = new StringBuilder();
		Iterator<SortParam> iterator = sortParams.iterator();
		while (iterator.hasNext()) {
			SortParam sortParam = iterator.next();
			String sortPoperty = sortParam.getProperty();
			boolean isAccending = sortParam.isAccending();
			if (sortPoperty != null) {
				sb.append(sortPoperty);
				// default ASC
				if (!isAccending) {
					sb.append(" DESC ");
				}
				if (iterator.hasNext()) {
					sb.append(", ");
				}
			}
		}
		if (sb.length() > 0) {
			sb.insert(0, " ORDER BY ");
		}
		return sb.toString();
	};
}
