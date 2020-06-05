package cardDeck;

public class Card {

	protected enum Suit {
		HEART, CLUB, SPADE, DIAMOND, EMPTY;
	}
	protected enum Face {
		ACE, JACK, QUEEN, KING, JOKER, EMPTY;
	}
	protected enum Color{
		RED, BLUE;
	}
	
	private int id;
	
	private int num;
	
	private Suit suit;
	private Face face;
	private Color color;
	
	
	public Card(int id, int num, Suit suit, Face face) {
		super();
		this.id = id;
		this.num = num;
		this.suit = suit;
		this.face = face;
	}
	
	public Card(int id, int num, Suit suit, Face face, Color color) {
		super();
		this.id = id;
		this.num = num;
		this.suit = suit;
		this.face = face;
		this.color = color;
	}
	
	
	public Card() {
		super();
	}

	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Suit getSuit() {
		return suit;
	}
	public void setSuit(Suit suit) {
		this.suit = suit;
	}
	public Face getFace() {
		return face;
	}
	public void setFace(Face face) {
		this.face = face;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
