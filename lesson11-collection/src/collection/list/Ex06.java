package collection.list;

import static utils.CollectionUtils.*;

import java.util.List;

public class Ex06 {
	public static void main(String[] args) {
		List<Integer> first = init(1, 2, 3);
		List<Integer> second = init(3, 4, 5, 6);

		// addAll: Hợp
		// removeAll: remove Giao
		// retainAll: remove Hiệu

		first.addAll(second);

		show(first);
		show(second);
	}
}
