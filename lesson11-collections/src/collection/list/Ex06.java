package collection.list;

import java.util.List;

import static utils.CollectionUtils.*;

public class Ex06 {
	public static void main(String[] args) {
		List<Integer> first = init(1, 2, 3, 4);
		List<Integer> second = init(3, 4, 5, 6);

		// addAll: Hợp
		// removeAll: remove Giao
		// retailAll: remove Hiệu
		
		show(first);
		show(second);
	}

}
