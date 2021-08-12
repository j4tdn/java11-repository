package ex03;

public class Card {
	private TypeCard typecard;
	private String ordercard;

	public Card() {
		// TODO Auto-generated constructor stub
	}

	public Card(TypeCard typecard, String ordercard) {
		super();
		this.typecard = typecard;
		this.ordercard = ordercard;
	}

	public TypeCard getTypecard() {
		return typecard;
	}

	public void setTypecard(TypeCard typecard) {
		this.typecard = typecard;
	}

	public String getOrdercard() {
		return ordercard;
	}

	public void setOrdercard(String ordercard) {
		this.ordercard = ordercard;
	}

	@Override
	public String toString() {
		return "Card [typecard=" + typecard + ", ordercard=" + ordercard + "]";
	}

}
