package chess;
import java.util.ArrayList;

public class Piece {
	protected enum COLOR{
		WHITE, BLACK;
	}
	protected enum TYPE{
			DUMMY, ROOK, PAWN, KNIGHT, BISHOP, QUEEN, KING;
	}
	private int id;
	private int posX;
	private int posY;
	private COLOR color;
	private TYPE type;
	private boolean firstMove;
	

	
	public Piece(int id, int posX, int posY, Piece.COLOR color, Piece.TYPE type, boolean firstMove) {
		super();
		this.id = id;
		this.posX = posX;
		this.posY = posY;
		this.color = color;
		this.type = type;
		this.firstMove = firstMove;

	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	public COLOR getColor() {
		return color;
	}
	public void setColor(COLOR color) {
		this.color = color;
	}
	public TYPE getType() {
		return type;
	}
	public void setType(TYPE type) {
		this.type = type;
	}
	public boolean isFirstMove() {
		return firstMove;
	}
	public void setFirstMove(boolean firstMove) {
		this.firstMove = firstMove;
	}

	@Override
	public String toString() {
		return "Piece [id=" + id + ", posX=" + posX + ", posY=" + posY + ", color=" + color + ", type=" + type
				+ ", firstMove=" + firstMove + "]";
	}
	
	
}
