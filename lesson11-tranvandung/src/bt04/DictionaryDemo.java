package bt04;

import java.util.Set;
import utils.Utils;
import java.util.LinkedHashSet;
import java.util.Scanner;


public class DictionaryDemo {
	public static void main(String[] args) {
		Set<Vocabulary> voc = new LinkedHashSet<>();
		System.out.println("==== ENGLISH DICTIONARY ====");
		voc.add(new Vocabulary("I", "Toi", "O", "O + adv"));
		voc.add(new Vocabulary("Animal", "Dong Vat", "N", "S + V + adv"));
		voc.add(new Vocabulary("Angry", "Tuc Gian", "Adj", "S + O + adj"));
		voc.add(new Vocabulary("Sad", "Buon", "Adj", "S +  O + adj"));
		voc.add(new Vocabulary("Work", "Lam", "V", "S + V "));
		voc.add(new Vocabulary("Dog", "Con Cho ", "N", "S+v"));

		// 1: add vocabulary
		Vocabulary v1 = new Vocabulary("i", "Choi", "V", "none");
		Vocabulary v2 = new Vocabulary("k", "Choi", "V", "none");
		voc.add(v1);
		voc.add(v2);
		Utils.printfSet(voc);

		// 2: find word
		Scanner ip = new Scanner(System.in);
		System.out.print("Enter your work you need find:");
		String find = ip.nextLine();
		System.out.println(voc.stream().filter(obj -> obj.getWord().toUpperCase().contains(find.toUpperCase())).findFirst().get());
	}
}
