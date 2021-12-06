package chess;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.sound.sampled.AudioFileFormat.Type;

import chess.Piece.COLOR;
import chess.Piece.TYPE;


public class Chess {
	@SuppressWarnings("rawtypes")
	//Determines grid letters for horizontal A, B,C etc.
	protected ArrayList<String>gridSpacesY = new ArrayList<>();
	//Holds all pieces in an array with their positions, color, etc.
	protected ArrayList<Piece> pieceArr = new ArrayList<>();
	//Determines potential spaces a piece can move to
	ArrayList<ArrayList> spaceArr = new ArrayList<>();
	ArrayList<Integer> spaceArrX = new ArrayList<>();
	ArrayList<Integer> spaceArrY = new ArrayList<>();
	//Monitors which spaces are empty, the position in the array will coordinate to ID so it can check the XY coordinates in pieceArr
	ArrayList<Boolean> isEmpty = new ArrayList<>();

	public void start() {
		generatePieces();
		generateSpaces();
		generateBoard();	
		processInput(gameLogic());
		//Closing a scanner so it doesn't throw null in any methods
		Scanner sc = new Scanner(System.in);
		sc.close();
	}
	
	@SuppressWarnings("unchecked")
	private void generateSpaces() {
		//Generate Spaces like A1, A2, B1, B2, etc.
		
		int x = 0;
		
		for(int i = 0; i < 64; i++) {
			//Generating all 64 so it doesn't clash with the rest of the board despite the redundancy
			//I see how this can be optimized but it is far too late
			if(x % 8 == 0) {
				x = 0;
				
			}
			switch(x) {
			case 0: 
				gridSpacesY.add("A");
				break;
			case 1: 
				gridSpacesY.add("B");
				break;
			case 2: 
				gridSpacesY.add("C");
				break;
			case 3: 
				gridSpacesY.add("D");
				break;
			case 4: 
				gridSpacesY.add("E");
				break;
			case 5: 
				gridSpacesY.add("F");
				break;
			case 6: 
				gridSpacesY.add("G");
				break;
			case 7: 
				gridSpacesY.add("H");
				break;
			default:
				System.out.println("error");
			}
			
			x++;
			
		}
		
	}
	private void processInput(String input){

		switch(input.toLowerCase()) {
		case "p":
		case "pawn":
			System.out.println("You have selected pawn");
			//Find potential spaces the player can move to
			potentialMove(TYPE.PAWN);
			break;
		case "b":
		case "bishop":
			System.out.println("Bishop");
			potentialMove(TYPE.BISHOP);
			break;
		case "r":
		case "rook":
			System.out.println("Rook");
			potentialMove(TYPE.ROOK);
			break;
		case "h":
		case "knight":
			System.out.println("Knight");
			potentialMove(TYPE.KNIGHT);
			break;
		case"q":
		case "queen":
			System.out.println("Queen");
			potentialMove(TYPE.QUEEN);
			break;
		case "k":
		case "king":
			System.out.println("King");
			potentialMove(TYPE.KING);
			break;
		default:
			System.out.println("Sorry there is no " + input +", please input a valid piece");
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private ArrayList<ArrayList> potentialMove(TYPE type){
		spaceArr.add(spaceArrX);
		spaceArr.add(spaceArrY);

		//Create a 2D Array List
		//0 for X, 1 for Y
		//-------------
		boolean correctInput = false;
		switch(type) {
		//Check which pieces the player wishes to select.
		case PAWN: 
			System.out.println("Which " + type.toString().toLowerCase() + " are we selecting?");
			
			for(int i = 0; i < pieceArr.size(); i++) {
					if(pieceArr.get(i).getType().equals(type)) {
						//Add possible pieces to an array
						spaceArr.get(0).add(pieceArr.get(i).getPosY());
						spaceArr.get(1).add(pieceArr.get(i).getPosX());
						System.out.print("[" + gridSpacesY.get(pieceArr.get(i).getPosY()) + pieceArr.get(i).getPosX() +"] ");
				}
			}
			
			break;
		case BISHOP:
			for(int i = 0; i < pieceArr.size(); i++) {
				if(pieceArr.get(i).getType().equals(type)) {
					//Add possible pieces to an array
					spaceArr.get(0).add(pieceArr.get(i).getPosY());
					spaceArr.get(1).add(pieceArr.get(i).getPosX());
					System.out.print("[" + gridSpacesY.get(pieceArr.get(i).getPosY()) + pieceArr.get(i).getPosX() +"] ");
				}
			}
			break;
		default:
			System.out.println("Not implemented");
			break;
			
		}
		
		Scanner sc = new Scanner(System.in);
		String choice = sc.nextLine();
		//Find the ID of the piece using these finders
		int pieceFinderX = 0;
		int pieceFinderY= 0;
		for(int i = 0; i < spaceArr.get(0).size();i++) {
			//If the user tries to sub a letter for a number like 36 for [C6] boot them out because we're not doing that.
			try {
			if(Integer.parseInt(choice.substring(0, 1)) == i) {
				correctInput = false;
				break;
			}
			}catch(NumberFormatException e) {
				
			}
			if(spaceArr.get(1).get(i).equals(Integer.parseInt((String) choice.subSequence(1, 2))) & spaceArr.get(0).get(i).equals(letterToNumber(choice))){
					correctInput = true;
					pieceFinderY = (int) spaceArr.get(0).get(i);
					pieceFinderX = (int) spaceArr.get(1).get(i);
					break;
			}
			
		}
		while (!correctInput) {
			System.out.println("Invalid input, please try again");
			choice = sc.nextLine();
			processInput(choice);
		}
		//If correct, calculate which spaces would be available from the current position.
		int iD = 0;
		for(int i = 0; i < pieceArr.size(); i++) {
			if (pieceArr.get(i).getPosX() == pieceFinderX && pieceArr.get(i).getPosY() == pieceFinderY) {
				iD = pieceArr.get(i).getId();
				displaySpaces(iD);
				break;
			}
		}
		
		spaceArr.clear();
		return spaceArr;
	}
	@SuppressWarnings("unchecked")
	private String displaySpaces (int ID) {
		ArrayList<ArrayList> stringSpaceArr = new ArrayList<>();
		ArrayList<Integer> arrX = new ArrayList<>();
		ArrayList<Integer> arrY = new ArrayList<>();
		stringSpaceArr.add(arrX);
		stringSpaceArr.add(arrY);
		int x = pieceArr.get(ID).getPosX();
		int y = pieceArr.get(ID).getPosY();
		int increment = 0;
		//XY factors out to an ID which can pin to a spot on the board,
		//I don't know why I didn't do this instead of this crazy math
		//You can find the current ID (and by extension the coordinates) of the isEmpty array by
		//using X to count to 8 and resetting by then, which increments Y by 1. Then to offset the array, subtract 1
		//so 0,0 would equal 0,
		//0, 4 should be 3 ((0 * 8 + 4) - 1
		//4,2 should equal 19 ((2 * 8 + 4) - 1)
		//5,6 should equal 52 ((5 * 8 + 6) - 1)
		//This means I could refactor earlier code but mannn.....
		//Let's try this
		int pieceID = (((y * 8) + x));
		//Not to get to a spot on the board I just have to alter the variables to make it fit which I will detail
		//In each type
		if(pieceArr.get(ID).getType().equals(TYPE.PAWN)) {
			//Pawns only move forward once (except on first move
			//So the Y coordinate only has to move once forward (for white) or backward (for black)
			//Which means the ID has to be incremented or decremented by 8 once.
			if(pieceArr.get(ID).getColor().equals(COLOR.WHITE)){
				{	
					for(int i = 0; i < isEmpty.size();i++) {
						if(isEmpty.get(i).equals(true) && i == pieceID - 8) {
							//This space is empty and can be occupied
							//if ID is above 8, divide by 8 for Y
							//Use remainder for X
							if(pieceID > 8) {
								//8 Gives us the exact spot, so we only have to decrement by Y once to move a space
								if(pieceArr.get(ID).isFirstMove()) {
									//First time movement a pawn gets two spaces.
									stringSpaceArr.get(1).add((pieceID/8) - 2);
									stringSpaceArr.get(0).add((pieceID % 8));
								}
								stringSpaceArr.get(1).add((pieceID/8) - 1);
								stringSpaceArr.get(0).add((pieceID % 8));
							}else {
								stringSpaceArr.get(1).add(0);
								stringSpaceArr.get(0).add(pieceID % 8);
							}
							System.out.println(i + " not taken");
						}else {
							
						}
					}
				}
			}
			if(pieceArr.get(ID).getColor().equals(COLOR.BLACK)){
				for(int i = 0; i < isEmpty.size();i++) {
					if(isEmpty.get(i).equals(true) && i == pieceID + 8) {
						//This space is empty and can be occupied
						//if ID is above 8, divide by 8 for Y
						//Use remainder for X
						if(pieceID > 8) {
							//8 Gives us the exact spot, so we only have to decrement by Y once to move a space
							if(pieceArr.get(ID).isFirstMove()) {
								//First time movement a pawn gets two spaces.
								stringSpaceArr.get(1).add((pieceID/8) + 2);
								stringSpaceArr.get(0).add((pieceID % 8));
							}
							stringSpaceArr.get(1).add((pieceID/8) + 1);
							stringSpaceArr.get(0).add((pieceID % 8));
						}else {
							stringSpaceArr.get(1).add(0);
							stringSpaceArr.get(0).add(pieceID % 8);
						}
						System.out.println(i + " not taken");
					}else {
						
					}
				}
			}
		}
		if(pieceArr.get(ID).getType().equals(TYPE.ROOK)) {
			if(pieceArr.get(ID).getColor().equals(COLOR.WHITE)){
				
			}
			if(pieceArr.get(ID).getColor().equals(COLOR.BLACK)){
				
			}
		}
		if(pieceArr.get(ID).getType().equals(TYPE.BISHOP)) {
			if(pieceArr.get(ID).getColor().equals(COLOR.WHITE)){
				
			}
			if(pieceArr.get(ID).getColor().equals(COLOR.BLACK)){
				
			}
		}
		if(pieceArr.get(ID).getType().equals(TYPE.KNIGHT)) {
			if(pieceArr.get(ID).getColor().equals(COLOR.WHITE)){
				
			}
			if(pieceArr.get(ID).getColor().equals(COLOR.BLACK)){
				
			}
		}
		if(pieceArr.get(ID).getType().equals(TYPE.QUEEN)) {
			if(pieceArr.get(ID).getColor().equals(COLOR.WHITE)){
				
			}
			if(pieceArr.get(ID).getColor().equals(COLOR.BLACK)){
				
			}
		}
		if(pieceArr.get(ID).getType().equals(TYPE.KING)) {
			if(pieceArr.get(ID).getColor().equals(COLOR.WHITE)){
				
			}
			if(pieceArr.get(ID).getColor().equals(COLOR.BLACK)){
				
			}
		}
		
		String fullString = " ";
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i < stringSpaceArr.get(0).size();i++) {
			//Append available spaces to string builder and toss it into fullstring
			sb.append("[" + gridSpacesY.get((int) stringSpaceArr.get(1).get(i)) + "" + stringSpaceArr.get(0).get(i) + "] "
					);
		}
		fullString = "The available spaces for this " + pieceArr.get(ID).getType().toString().toLowerCase() + " is " + sb.toString();
		System.out.println(fullString);
		return fullString;
	}
	private int letterToNumber(String input) {
		for(int i = 0; i < gridSpacesY.size(); i++) {
			
			
			String upper = input.toUpperCase();
			if(upper.subSequence(0, 1).equals(gridSpacesY.get(i))){
				return i;
			}
		}
		return 0;
	}
	private String gameLogic() {
		
		System.out.println();
		System.out.println();
		System.out.println("Which piece would you like to move?");
		 Scanner sc = new Scanner(System.in);
		 String choice = sc.nextLine();
		
		return choice;
	}
	
	private void generateBoard() {
		int x = 0;
		int y= 0;
		boolean empty = true;
		
		System.out.println("Generating Board");
		for(int i = 0; i < 64; i++) {
			empty = false;
			//After the grid goes over 8, break a new line so it resembles a chessboard
			if(i %  8 == 0 && i > 0) {
				System.out.println();
			}
			//Go into loop assuming no piece exists on this square
			empty = false;
			//Go through the existing pieces to see where they currently are
			for(int j = 0; j < pieceArr.size(); j++) {
				boolean found = false;
				
				
				//If a piece exists, print it on the board
				//If no piece, set empty to true which will print an empty space
				if(pieceArr.get(j).getPosX() == x && pieceArr.get(j).getPosY() == y) {
					found = true;
					switch (pieceArr.get(j).getColor()) {
						case WHITE:
							System.out.print("[W");
							break;
						default:
							System.out.print("[B");
							break;							
					}
					
					switch(pieceArr.get(j).getType()) {
					case PAWN:
						System.out.print("P]");
						break;
					case BISHOP:
						System.out.print("B]");
						break;
					case KNIGHT:
						//H for horsie so it doesn't conflict with king
						System.out.print("H]");
						break;
					case ROOK:
						System.out.print("R]");
						break;
					case KING:
						System.out.print("K]");
						break;
					case QUEEN:
						System.out.print("Q]");
						break;
					default:
						System.out.println("Error, please let me know what's up");
					}
				}
				if(found) {
					//If a piece is found, end the loop and refuse an empty square
					j = pieceArr.size();
					empty = false;
					isEmpty.add(false);
				}else {
					//If nothing is found, assume square is empty
					empty = true;
					
				}
				
			}
			if(empty) {
				System.out.print("[" + gridSpacesY.get(y) + x +"]");
				isEmpty.add(true);
			}
		
			x++;
			if(x % 8 ==0) {
				y++;
				x = 0;
			}
		}
	}

	private ArrayList<Piece> generatePieces(){
		for(int i = 0; i <32; i++) {
			if (i <= 15) {
				pieceArr.add(new Piece(i, i % 8, 1, Piece.COLOR.BLACK, Piece.TYPE.PAWN, true));
				if (i <= 7) {
					pieceArr.get(i).setColor(Piece.COLOR.WHITE);
					pieceArr.get(i).setPosY(6);
				}
			}
			if(i > 15 && i <= 19) {
				pieceArr.add(new Piece(i, 0, 0, Piece.COLOR.BLACK, Piece.TYPE.ROOK, true));
				if (i == 18 || i == 19){
					pieceArr.get(i).setColor(Piece.COLOR.WHITE);
					pieceArr.get(i).setPosY(7);
				}
				switch (i) {
					case 16:
						pieceArr.get(i).setPosX(0);
						break;
					case 18:
						pieceArr.get(i).setPosX(0);
						break;
					case 17:
						pieceArr.get(i).setPosX(7);
						break;
					case 19:
						pieceArr.get(i).setPosX(7);
						break;
				}
						
				}
			if(i>19 && i <= 23) {
				pieceArr.add(new Piece(i, 0, 0, Piece.COLOR.BLACK, Piece.TYPE.BISHOP, true));
					if ( i == 22 || i == 23) {
						pieceArr.get(i).setColor(Piece.COLOR.WHITE);
						pieceArr.get(i).setPosY(7);
						}
					switch(i) {
					case 20:
						pieceArr.get(i).setPosX(2);
						break;
					case 22:
						pieceArr.get(i).setPosX(2);
						break;
					case 21:
						pieceArr.get(i).setPosX(5);
						break;
					case 23:
						pieceArr.get(i).setPosX(5);
						break;

					}
				}
			if(i > 23 && i <= 27) {
				pieceArr.add(new Piece(i, 0, 0, Piece.COLOR.BLACK, Piece.TYPE.KNIGHT, true));
				if(i == 26 || i == 27) {
					pieceArr.get(i).setColor(Piece.COLOR.WHITE);
					pieceArr.get(i).setPosY(7);
				}
				switch(i) {
				case 24:
					pieceArr.get(i).setPosX(1);
					break;
				case 26:
					pieceArr.get(i).setPosX(1);
					break;
				case 25:
					pieceArr.get(i).setPosX(6);
					break;
				case 27:
					pieceArr.get(i).setPosX(6);
					break;

				}

			}
			if(i == 28 || i == 29) {
				pieceArr.add(new Piece(i, 0, 0, Piece.COLOR.BLACK, Piece.TYPE.QUEEN, true));
				pieceArr.get(i).setPosX(3);
				if( i == 29) {
					pieceArr.get(i).setColor(Piece.COLOR.WHITE);
					pieceArr.get(i).setPosY(7);
					pieceArr.get(i).setPosX(3);
				}
				
			}
			if(i == 30 ||  i == 31) {
				pieceArr.add(new Piece(i, 0, 0, Piece.COLOR.BLACK, Piece.TYPE.KING, true));
				pieceArr.get(i).setPosX(4);
			
				if( i == 30) {
					pieceArr.get(i).setColor(Piece.COLOR.WHITE);
					pieceArr.get(i).setPosY(7);
					pieceArr.get(i).setPosX(4);
				}
				
				
			}
		}
		for (int i = 0; i < pieceArr.size(); i++) {
			
					
			System.out.println(pieceArr.get(i).toString());
		}
		return pieceArr;
	}
}
