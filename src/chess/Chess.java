package chess;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

import javax.sound.sampled.AudioFileFormat.Type;


public class Chess {

	protected ArrayList<Piece> pieceArr = new ArrayList<>();
	public void start() {
		generatePieces();
		generateBoard();
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
					switch(pieceArr.get(j).getType()) {
					case PAWN:
						System.out.print("[P]");
						break;
					case BISHOP:
						System.out.print("[B]");
						break;
					case KNIGHT:
						//H for horsie so it doesn't conflict with king
						System.out.print("[H]");
						break;
					case ROOK:
						System.out.print("[R]");
						break;
					case KING:
						System.out.print("[K]");
						break;
					case QUEEN:
						System.out.print("[Q]");
						break;
					default:
						System.out.println("Error, please let me know what's up");
					}
				}
				if(found) {
					//If a piece is found, end the loop and refuse an empty square
					j = pieceArr.size();
					empty = false;
				}else {
					//If nothing is found, assume square is empty
					empty = true;
				}
				
			}
			if(empty) {
				System.out.print("[ ]");
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
