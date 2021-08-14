package Ex04;

public class Card {
	private int face;
	private int suit;
	public Card() 
	{
		this.face = (int)(Math.random()*4);
		this.suit = (int)(Math.random()*13);
	}
	public int getFace() 
	{
		return face;
	}
	public void setFace(int face) 
	{
		this.face = face;
	}
	public int getSuit() 
	{
		return suit;
	}
	public void setSuit(int suit) 
	{
		this.suit = suit;
	}

	public boolean equals(Object obj) 
	{
		Card c = (Card)obj;
		return (this.suit == c.getSuit() && this.face == c.getFace());
	}
	// Ham override 

	public String toString() 
	{
		String ret = "";
		switch(suit)
		{
			case 0: ret = "A";break;
			case 1: ret = "2";break;
			case 2: ret = "3";break;
			case 3: ret = "4";break;
			case 4: ret = "5";break;
			case 5: ret = "6";break;
			case 6: ret = "7";break;
			case 7: ret = "8";break;
			case 8: ret = "9";break;
			case 9: ret = "10";break;
			case 10: ret = "J";break;
			case 11: ret = "Q";break;
			case 12: ret = "K";break;
		}
		switch(face)
		{
			case 0: ret += " cờ";break;
			case 1: ret += " rô";break;
			case 2: ret += " chuồn";break;
			case 3: ret += " bích";break;
		}
		return ret;
	}
}
