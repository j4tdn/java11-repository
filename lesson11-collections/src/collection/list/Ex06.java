package collection.list;

import java.util.List;

import utils.CollectionUtils;

public class Ex06 {
	public static void main(String[] args) {
		List<Integer> first = CollectionUtils.init(1, 2, 3, 4);
		List<Integer> second = CollectionUtils.init(3, 4, 5, 6);

		first.retainAll(second);
		CollectionUtils.show(first);
		CollectionUtils.show(second);
	}
}
