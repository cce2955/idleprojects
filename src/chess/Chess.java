package chess;

import java.util.ArrayList;
import java.util.Scanner;

import javax.sound.sampled.FloatControl.Type;

import chess.Board.PLAYERCOLOR;
import chess.Piece.COLOR;
import chess.Piece.TYPE;

public class Chess {
	Scanner sc = new Scanner(System.in);
	//Standard 8x8 board
	private Board board = new Board(8, 8, PLAYERCOLOR.WHITE);
	//Array to hold pieces
	private ArrayList<Piece> pieceArr = new ArrayList<>();
	//Hold potential moves the user can make
	private ArrayList<String> moveArr =new ArrayList<>();
	//Along with the choices, set up potential IDs for the new spaces so pieces can be set with the array.
	private ArrayList<Integer> potentialIDArr = new ArrayList<>();
	//This will be the global ID of the piece the user is currently utilizing
	private int id= 0;
	public void start() {	
		generatePieces();
		updateBoard(board.getHorizontalLength(), board.getVerticalLength());
		gameLogic();
		updateBoard(board.getHorizontalLength(), board.getVerticalLength());
		sc.close();
	}
	
	private void gameLogic() {

		System.out.println();
		System.out.println("Which piece are you moving?(P or Pawn for Pawn, etc.)");
		String choice = sc.nextLine();
		switch(choice.toLowerCase()) {
			case "p":
			case "pawn":
				System.out.println(availableUnits(TYPE.PAWN));
				break;
			case "b":
			case "bishop":
				System.out.println(availableUnits(TYPE.BISHOP));
		
				break;
			case "h":
			case "knight":
				System.out.println(availableUnits(TYPE.KNIGHT));
		
				break;
			case "r":
			case "rook":
				System.out.println(availableUnits(TYPE.ROOK));
		
				break;
			case "q":
			case "queen":
				System.out.println(availableUnits(TYPE.QUEEN));
		
				break;
			case "k":
			case "king":
				System.out.println(availableUnits(TYPE.KING));
				break;
			default:
				//Force into loop if bad input
				System.out.println("Sorry that's not a valid piece, tyoe in the correct name or the first letter (ex. Pawn or P for Pawns)");
				gameLogic();
		}
		choice = sc.nextLine();
		if(choice.length() == 2) {
			System.out.println(pieceMovement(potentialMoves(choice)));
		}else {
			System.out.println("Sorry that's not a valid piece, please try again");
			gameLogic();
		}
		
		choice = sc.nextLine();
		String lambdaChoice = choice.toUpperCase();
		moveArr.forEach(item -> {
			
			if (lambdaChoice.equals(item)) {
				
				//If choice is correct, change the ID so the position of the piece will change.
				//Also clear the old space and make it empty
				//Make the new space occupied
				int oldID = id;
				pieceArr.get(id).setId(potentialMoves(item));
				board.spaceIDArr.get(oldID).setOccupied(false);
				board.spaceIDArr.get(id).setOccupied(true);
				
			}
		});
		
		}
	
	private String availableUnits(TYPE type) {
		StringBuilder sb = new StringBuilder();
		sb.append("Your available units are: ");
		pieceArr.forEach(piece ->{
			if(piece.getType() == type && piece.isDefeated() == false) {
				//This is a very stupid and unsafe way to do this, which is why I'm doing it
				//Admitting is the first step
				if(board.playerColor.toString().equals(piece.getColor().toString())) {
					sb.append("[" + board.letterSpaces(piece.getId()/8) + piece.getId() % 8 + "]");	
				}
			
			}
		});
		sb.append("\nWhich one would you like to move?");
		return sb.toString();
	}
	private int potentialMoves(String input) {
		//Calculate input and find the ID from the input
		id = 0;
		int x = 0;
		int y = 0;
		try {
			y = Integer.parseInt((String) input.subSequence(1, 2));
		}catch(NumberFormatException e) {
			System.out.println("That is not a valid input, please try again");
			gameLogic();
		}
		
		//Basically do the inverse of letters to find the X coordinate
		switch (input.subSequence(0, 1).toString().toLowerCase()) {
			case "a":
				x = 0;
				break;
			case "b":
				x = 1;
				break;
			case "c":
				x = 2;
				break;
			case "d":
				x = 3;
				break;
			case "e":
				x = 4;
				break;
			case "f":
				x = 5;
				break;
			case "g":
				x = 6;
				break;
			case "h":
				x = 7;
				break;
			default:
				System.out.println("That is not a valid input, please try again");
				gameLogic();
			}
		
		//Finds the exact ID of the piece we're using
		id = (x * 8) + y;
		return id;
	}
	
	private String pieceMovement(int ID) {
		StringBuilder sb = new StringBuilder();
		//Empty move array 
		moveArr.clear();
		sb.delete(0, sb.length());
		sb.append("Your available moves are: ");
		switch(pieceArr.get(ID).getType()) {
		case PAWN:
			//Pretty straight forward, your only options is the space in front of you or if it's the first turn
			//The first and second space
			try {
				if(!board.spaceIDArr.get(ID + 8).isOccupied()) {
					if(board.playerColor == PLAYERCOLOR.WHITE) {	
						sb.append(" [" + board.letterSpaces((ID/8) + 1) + ((ID % 8) + "] "));
						moveArr.add(board.letterSpaces((ID/8) + 1) + ((ID % 8)));
						potentialIDArr.add(((ID/8)+1) + (ID % 8));
					}else {
						sb.append(" [" + board.letterSpaces((ID/8) -1 ) + ((ID % 8) + "] "));
						moveArr.add(board.letterSpaces((ID/8) - 1) + ((ID % 8)));
						potentialIDArr.add(((ID/8)-1) + (ID % 8));
					}
				}
				//This space should never be occupied but may as well be safe
				if(pieceArr.get(ID).isFirstMove() && !board.spaceIDArr.get(ID + 16).isOccupied()) {
					if(board.playerColor == PLAYERCOLOR.WHITE) {
						sb.append(" [" + board.letterSpaces((ID/8) + 2) + ((ID % 8) + "] "));
						moveArr.add(board.letterSpaces((ID/8) + 2) + ((ID % 8)));
					}else {
						sb.append(" [" + board.letterSpaces((ID/8) -1 ) + ((ID % 8) + "] "));
						moveArr.add(board.letterSpaces((ID/8) - 1) + ((ID % 8)));
					}
				}	
			}catch (IndexOutOfBoundsException e) {
				System.out.println("There are no spaces available");
			}
			
			break;
		default:
			break;
		}
		return sb.toString();
	}
	private void generatePieces() {
		for(int i = 0; i < board.horizontalLength* board.verticalLength; i++) {
			//There probably is a way to do this via an algorithm which will infuriate me at day's end but
			//I'm gonna hard code these values for now
			if(i >= 8 && i <= 15) {
				pieceArr.add(new Piece(i, Piece.COLOR.WHITE, Piece.TYPE.PAWN, true, false));
			}
			if(i >= 48 && i <= 55) {
				pieceArr.add(new Piece(i, Piece.COLOR.BLACK, Piece.TYPE.PAWN, true, false));
			}
			if(i == 0 || i ==7) {
				pieceArr.add(new Piece(i, Piece.COLOR.WHITE, Piece.TYPE.ROOK, true, false));
			}
			if(i == 56 || i ==63) {
				pieceArr.add(new Piece(i, Piece.COLOR.BLACK, Piece.TYPE.ROOK, true, false));
			}
			if(i == 1 || i == 6) {
				pieceArr.add(new Piece(i, Piece.COLOR.WHITE, Piece.TYPE.KNIGHT, true, false));
			}
			if(i == 57 || i == 62) {
				pieceArr.add(new Piece(i, Piece.COLOR.BLACK, Piece.TYPE.KNIGHT, true, false));
			}
			if(i == 2 || i == 5) {
				pieceArr.add(new Piece(i, Piece.COLOR.WHITE, Piece.TYPE.BISHOP, true, false));
			}
			if(i == 58 || i == 61) {
				pieceArr.add(new Piece(i, Piece.COLOR.BLACK, Piece.TYPE.BISHOP, true, false));
			}

			if(i ==3) {
				pieceArr.add(new Piece(i, Piece.COLOR.WHITE, Piece.TYPE.QUEEN, true, false));
			}
			if(i ==4) {
				pieceArr.add(new Piece(i, Piece.COLOR.WHITE, Piece.TYPE.KING, true, false));
			}
			if(i ==59) {
				pieceArr.add(new Piece(i, Piece.COLOR.BLACK, Piece.TYPE.QUEEN, true, false));
			}
			if(i ==60) {
				pieceArr.add(new Piece(i, Piece.COLOR.BLACK, Piece.TYPE.KING, true, false));
			}
			try {
				if(pieceArr.get(i).getId() == board.spaceIDArr.get(i).spaceID) {
					//Flip a space on the grid as occupied if a piece is added to this ID
					//This can be used to scan for collisions during a movement check 
					board.spaceIDArr.get(i).occupied = true;
				}else {
					//Likewise, free up a space if nothing is there
					board.spaceIDArr.get(i).occupied = false;
				}
			}catch(IndexOutOfBoundsException e) {
				
			}
			
		}

	}
	private void updateBoard (int length, int width) {
		boolean isEmpty = true;
		for(int i = 0; i < length * width; i++) {
			//After X amount of iterations break the grid by a line 
			if(i % length == 0 && i > 0) {
				System.out.println();
			}
			
			//Assign a final variable for this lamba check
			int loopI = i;
			pieceArr.forEach(piece -> {
				//If a piece
					if(piece.getId() == loopI) {
						board.spaceIDArr.get(loopI).setOccupied(true);
						switch(piece.getColor()) {
						case WHITE:
							System.out.print("[W");
							break;
						case BLACK:
							System.out.print("[B");
							break;
						default:
							System.out.print("[COLOR ERROR");
						}
						switch(piece.getType()) {
							case PAWN:
								System.out.print("P]");
								break;
							case BISHOP:
								System.out.print("B]");
								break;
							case KNIGHT:
								//H for horsie
								System.out.print("H]");
								break;
							case ROOK:
								System.out.print("R]");
								break;
							case QUEEN:
								System.out.print("Q]");
								break;
							case KING:
								System.out.print("P]");
								break;
							default:
								System.out.print("TYPE ERROR]");
								break;
						}
					}
			});
			if(!board.spaceIDArr.get(i).isOccupied()) {
				//If there is no piece, display the grid letter and number
				System.out.print("[" + board.letterSpaces(i/8) + i % 8 + "]");
			}
	}
}	



}	
	