package chess;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.sound.sampled.AudioFileFormat.Type;


public class Chess {
	private Piece piece = new Piece(0, 0, null, null, false);
	private ArrayList<Piece> pieceArr = new ArrayList<>();
	public void start() {
		generatePieces();
	}
	private ArrayList<Piece> generatePieces(){
		for(int i = 0; i <32; i++) {
			if (i <= 15) {
				pieceArr.add(new Piece(0, 0, Piece.COLOR.BLACK, Piece.TYPE.PAWN, true));
				if (i < 7) {
					pieceArr.get(i).setColor(Piece.COLOR.WHITE);
				}
			}
			if(i > 15 && i <= 19) {
				pieceArr.add(new Piece(0, 0, Piece.COLOR.BLACK, Piece.TYPE.ROOK, true));
				if (i == 18 || i == 19){
					pieceArr.get(i).setColor(Piece.COLOR.WHITE);
				}
				}
			if(i>19 && i <= 23) {
				pieceArr.add(new Piece(0, 0, Piece.COLOR.BLACK, Piece.TYPE.BISHOP, true));
					if ( i == 22 || i == 23) {
						pieceArr.get(i).setColor(Piece.COLOR.WHITE);
						}
			
				}
			if(i > 23 && i <= 27) {
				pieceArr.add(new Piece(0, 0, Piece.COLOR.BLACK, Piece.TYPE.KNIGHT, true));
				if(i == 26 || i == 27) {
					pieceArr.get(i).setColor(Piece.COLOR.WHITE);
				}
			}
			if(i == 28 || i == 29) {
				pieceArr.add(new Piece(0, 0, Piece.COLOR.BLACK, Piece.TYPE.QUEEN, true));
				if( i == 29) {
					pieceArr.get(i).setColor(Piece.COLOR.WHITE);
				}
			}
			if(i == 30 ||  i == 29) {
				pieceArr.add(new Piece(0, 0, Piece.COLOR.BLACK, Piece.TYPE.KING, true));
				if( i == 29) {
					pieceArr.get(i).setColor(Piece.COLOR.WHITE);
				}
			}
		}
		for(int i = 0; i < pieceArr.size(); i++) {
			System.out.println(pieceArr.get(i).toString());
		}
		return pieceArr;
	}
}
