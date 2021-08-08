package collection.list;

import java.util.List;

import static utils.CollectionUtils.*;

public class Ex06 {
	public static void main(String[] args) {
		List<Integer> first = init(1, 2, 3, 4, 5);
		List<Integer> second = init(4, 5, 6, 7);

		// addAll: Hợp
		// removeAll: remove Giao
		// retainAll: remove Hiệu
		first.retainAll(second);

		printf(first);
		printf(second);
	}
}
