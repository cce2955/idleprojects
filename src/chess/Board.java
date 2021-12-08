package chess;

import java.util.ArrayList;


public class Board {
	//Array list to hold Space IDs
	ArrayList<Space> spaceIDArr = new ArrayList<>();
	int horizontalLength;
	int verticalLength;
	enum PLAYERCOLOR{
		WHITE, BLACK;
	}
	PLAYERCOLOR playerColor;
	/**
	 * @param horizontalLength
	 * @param verticalLength
	 */
	public Board(int horizontalLength, int verticalLength, PLAYERCOLOR playerColor) {
		super();
		this.horizontalLength = horizontalLength;
		this.verticalLength = verticalLength;
		this.playerColor = playerColor;
		for(int i= 0; i < horizontalLength *verticalLength; i++) {
			//Generate space IDs to be used in board
			//Board will be slicedd using horizontal length
			spaceIDArr.add(new Space(i, false));
		}
		
	}
	
	public String letterSpaces (int num) {
		switch (num) {
			case 0:
				return "A";
			case 1:
				return "B";
			case 2:
				return "C";
			case 3:
				return "D";
			case 4:
				return "E";
			case 5:
				return "F";
			case 6:
				return "G";
			case 7:
				return "H";
			default:
				return "Error";
		}
	}
	

	public int getHorizontalLength() {
		return horizontalLength;
	}
	private void setHorizontalLength(int horizontalLength) {
		this.horizontalLength = horizontalLength;
	}
	public int getVerticalLength() {
		return verticalLength;
	}
	private void setVerticalLength(int verticalLength) {
		this.verticalLength = verticalLength;
	}
	
	
	
}
