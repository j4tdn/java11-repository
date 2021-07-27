package collection.list;

import java.util.List;


import static utils.collectionUtils.*;

public class Ex06 {
	public static void main(String[] args) {
		List<Integer> first = init(1,2,3,4);
		List<Integer> second = init(3,4,5,6);
		
		//first.addAll(second);: hop
		//first.removeAll(second); // remove giao
		
		first.retainAll(second); // thuoc a ma khong thuoc b
		
		show(first);
		show(second);
	}

}
