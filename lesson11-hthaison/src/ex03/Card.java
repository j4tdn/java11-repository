package ex03;

public class Card {
	private String he;
	private String toc;
	
	public Card() {
		// TODO Auto-generated constructor stub
	}

	public Card(String he, String toc) {
		super();
		this.he = he;
		this.toc = toc;
	}

	public String getHe() {
		return he;
	}

	public void setHe(String he) {
		this.he = he;
	}

	public String getToc() {
		return toc;
	}

	public void setToc(String toc) {
		this.toc = toc;
	}

	@Override
	public String toString() {
		return  he + ", " + toc;
	}
	

}
