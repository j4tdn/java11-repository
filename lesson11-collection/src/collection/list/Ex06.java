package collection.list;

import java.util.List;
import static utils.CollectionUtils.*;

public class Ex06 {
	public static void main(String[] args) {
		List<Integer> first = init(1, 2, 3, 4);
		List<Integer> second = init(3, 4, 5, 6);
		
		// addAll: hợp nhau
		// removeAll: giao nhau
		// tetailAll: hiệu
		
		first.retainAll(second);
		
		show(first);
		show(second);
	}

}
