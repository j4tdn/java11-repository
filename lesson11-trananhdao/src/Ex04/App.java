package Ex04;

public class App {
	public static void main(String[] args) {
        Card_List c = new Card_List();
        System.out.println(c);
        System.out.println("\nBAI SAU KHI XAO: \n");

        c.shuffleCardPack();
        System.out.println(c);

    }
}
