package spring.core.bean;

public class MovieCatalogue {

	private Catalogue catalogue;

	public MovieCatalogue(Catalogue catalogue) {
		this.catalogue = catalogue;
	}

	public void showMovie() {
		switch (catalogue) {
		case ACTION:
			System.out.println("Hot Movie 01 Action--> 24.05.2022");
			break;
		case ADVENTURE:
			System.out.println("Hot Movie 02 Adventure--> 12.06.2022");
			break;
		default:
			System.out.println("undefined");
		}
	}
}
