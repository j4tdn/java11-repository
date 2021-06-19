package immutable;

public class Ex03 {
	public static void main(String[] args) {
		String s = "Recs3122ycle V321iew";
		
		System.out.println("length : " + s.length());
		System.out.println("charAt(3) :" + s.charAt(3));
		
//		for(int i = 0; i < s.length(); i++) {
//			char temp = s.charAt(i);
//			if(Character.isDigit(temp)) {
//				System.out.print(temp + " ");
//			}
//		}
		

		s.concat(" - Layout"); // + operator || concatenate
		System.out.println("s : " + s);
		
		
	}
}
