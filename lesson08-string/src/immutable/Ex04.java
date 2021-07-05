package immutable;

public class Ex04 {
	/**
		
	 */
	public static void main(String[] args) {
		String s = "GridLayout Grid Manager";
		String[] books = {"S-STK-TK123", "234-STK", "SGK345"};
		
		// Print classical books
		for (String book : books) {
			if (book.contains("STK")) {
				System.out.println(book);
			}
		}
		s = s.replaceFirst("Grid", "Flow");
		System.out.println("s: " + s);
		
		String ss = "  Football   Cooking   Badminton   ";
		// ss = "Football Cooking Badminton";;
		String result = ss.trim().replaceAll("\\s+", " ");
		System.out.println("result: " + result);
		
		String song = "d:/music/somthingyoulike.mp3";
		int lastSlash = song.lastIndexOf("/");
		int loasDot = song.lastIndexOf(".");
		String songName = song.substring(lastSlash+1, loasDot);
		System.out.println("songname: " + songName);
	}
}
