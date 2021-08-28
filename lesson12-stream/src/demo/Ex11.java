package demo;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;

public class Ex11 {
	public static void main(String[] args) {
		int[] digits = {1,2,1,4,5,8,10,4,12};
		
		// chia hết cho 10
		
		boolean d10 = Arrays.stream(digits).anyMatch(i->i%10 == 0);
		
		//phan tu dau tien
		OptionalInt optIntD4 =  Arrays.stream(digits).filter(i -> i % 4 == 0).findFirst();
		if(optIntD4.isPresent()) {
			System.out.println("fisrtD4: " + optIntD4.getAsInt());
		}
		//phan tu bat ky chia het cho 5
		OptionalInt optIntD5 =  Arrays.stream(digits).filter(i -> i % 5 == 0).findAny();
		if(optIntD5.isPresent()) {
			System.out.println("fisrtD4: " + optIntD5.getAsInt());
		}
		//does all elements less than 100
		boolean all100  =  Arrays.stream(digits).allMatch(i->i<100);
		System.out.println("all: " + all100);
		
		// kt nho hon 100
		boolean none100  =  Arrays.stream(digits).noneMatch(i->i<100);
		System.out.println("all: " + none100);
	}
}
