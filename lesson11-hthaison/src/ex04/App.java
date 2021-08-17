package ex04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Word> list = dictionary();
		int mode = -1;
		String word;
		while(mode != 0) {
			System.out.println("Mode: ");
			mode = sc.nextInt();
			switch (mode) {
			case 1: 
				Vocabulary(list);
				break;
			case 2:
				word = word();
				System.out.println("result:");
				search(list, word);
				break;
				
			}
		}
	}
	private static String word() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap tu can search: ");
		String word = sc.nextLine();
		return word;
	}
	private static List<Word> dictionary() {
		List<Word> list = new ArrayList<>();
		list.add(new Word("learn", "hoc", "v", "vua learn vua play"));
		list.add(new Word("Hight", "cao", "adj", "Hight 2"));
		list.add(new Word("low"  , "thap", "adj", "thap low"));
		list.add(new Word("fine ", "khoe", "adj", "i'm fine thanks you and u"));
		list.add(new Word("blue", "xanh duong", "adj", " An blue kia"));
		return list;

	}
	private static List<Word> Vocabulary(List<Word> list) {
		Word newWord = new  Word();
		Scanner sc = new Scanner(System.in);
		System.out.print("Word: ");
		newWord.setWord(sc.nextLine());
		System.out.print("Mean: ");
		newWord.setMean(sc.nextLine());
		System.out.println("Loai tu");
		newWord.setLoai(sc.nextLine());
		System.out.println("Note");
		newWord.setNote(sc.nextLine());
		boolean check = true;
		for(Word i : list) {
			if(i.compareTo(newWord) != 0) {
				check = true;
			}
		}
		if(check) {
			list.add(newWord);
		}
		if(!check) {
			System.out.println("Da ton tai tu nay");
		}
		
		return list;
	}
	private static void search(List<Word> list, String word) {
		Word result = new Word();
		for(Word i : list) {
			if(word.equals(i.getWord())) {
				i.toString();
			}
		}
		
		
	}

}
