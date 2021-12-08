package chess;

import java.util.ArrayList;

import javax.sound.sampled.FloatControl.Type;

import chess.Piece.COLOR;
import chess.Piece.TYPE;

public class Chess {
	//Standard 8x8 board
	Board board = new Board(8, 8);
	//Array to hold pieces
	ArrayList<Piece> pieceArr = new ArrayList<>();
	public void start() {	
		generatePieces();
		
		updateBoard(board.getHorizontalLength(), board.getVerticalLength());
		
	}
	public void generatePieces() {
		for(int i = 0; i < 64; i++) {
			//There probably is a way to do this via an algorithm which will infuriate me at day's end but
			//I'm gonna hard code these values for now
			if(i >= 8 && i <= 15) {
				pieceArr.add(new Piece(i, Piece.COLOR.WHITE, Piece.TYPE.PAWN, true));
			}
			if(i >= 48 && i <= 55) {
				pieceArr.add(new Piece(i, Piece.COLOR.BLACK, Piece.TYPE.PAWN, true));
			}
			if(i == 0 || i ==7) {
				pieceArr.add(new Piece(i, Piece.COLOR.WHITE, Piece.TYPE.ROOK, true));
			}
			if(i == 56 || i ==63) {
				pieceArr.add(new Piece(i, Piece.COLOR.BLACK, Piece.TYPE.ROOK, true));
			}
			if(i == 1 || i == 6) {
				pieceArr.add(new Piece(i, Piece.COLOR.WHITE, Piece.TYPE.KNIGHT, true));
			}
			if(i == 57 || i == 62) {
				pieceArr.add(new Piece(i, Piece.COLOR.BLACK, Piece.TYPE.KNIGHT, true));
			}
			if(i == 2 || i == 5) {
				pieceArr.add(new Piece(i, Piece.COLOR.WHITE, Piece.TYPE.BISHOP, true));
			}
			if(i == 58 || i == 61) {
				pieceArr.add(new Piece(i, Piece.COLOR.BLACK, Piece.TYPE.BISHOP, true));
			}

			if(i ==3) {
				pieceArr.add(new Piece(i, Piece.COLOR.WHITE, Piece.TYPE.QUEEN, true));
			}
			if(i ==4) {
				pieceArr.add(new Piece(i, Piece.COLOR.WHITE, Piece.TYPE.KING, true));
			}
			if(i ==59) {
				pieceArr.add(new Piece(i, Piece.COLOR.BLACK, Piece.TYPE.QUEEN, true));
			}
			if(i ==60) {
				pieceArr.add(new Piece(i, Piece.COLOR.BLACK, Piece.TYPE.KING, true));
			}

		}

	}
	public void updateBoard (int length, int width) {
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
