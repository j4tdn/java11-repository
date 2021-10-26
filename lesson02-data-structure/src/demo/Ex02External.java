package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Ex02External{
	public static void main(String[] args) {
		List<Integer> l = Arrays.asList(1, 2, 3, 3, 5);
		l.add(4);
		Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4));
		Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5, 6));
		set1.add(8);
		for(Integer s : set1) {
			if(set2.contains(s)) System.out.println(s);
		}
	}
}
