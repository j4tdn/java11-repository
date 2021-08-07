package collection.list;

import java.util.List;

import static utils.CollectionUtils.*;

public class Ex06 {
	public static void main(String[] args) {
		List<Integer> first = init(1,2,3,4);
		List<Integer> second = init(5,3,4);
		
		
		first.addAll(second);
		first.removeAll(second); //remove phan tu Giao
		first.retainAll(second); //remove phần tử Hiệu
		
		printf(first);
		printf(second);
	}
}
