package collection.list;

import java.util.List;

import utils.CollectionUtils;
import static utils.CollectionUtils.*;

public class Ex06 {
	public static void main(String[] args) {
		List<Integer> first = CollectionUtils.init(1,2,3 ,4);
		List<Integer> second = init(3,4 ,5, 6);
		
		//addAll : hop
		//removeAll: remove Giao
		//retainAll: remove Hieu
		
		//first.addAll(second);
		first.retainAll(second);
		
		show(first);
		show(second);
	}
}
