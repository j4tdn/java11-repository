package ex03;

public class Card {
	private String orderByCard;
	private String properties;
	
	public Card() {
	}

	public Card(String orderByCard, String properties) {
		super();
		this.orderByCard = orderByCard;
		this.properties = properties;
	}

	public String getOrderByCard() {
		return orderByCard;
	}

	public void setOrderByCard(String orderByCard) {
		this.orderByCard = orderByCard;
	}

	public String getProperties() {
		return properties;
	}

	public void setProperties(String properties) {
		this.properties = properties;
	}

	@Override
	public String toString() {
		return "Card [orderByCard=" + orderByCard + ", properties=" + properties + "]";
	}
	
	
}
