package Pieces;
import Pieces.Piece;
import main.Board;

public class Pawn extends Piece {
	
	private boolean isFirstMove = true;
	
	public Pawn(String pieceName, String color) {
		super(pieceName, color);
		// TODO Auto-generated constructor stub
	}
	// checks if legal move
	@Override
	public boolean isLegalMove(String move) {
		move = move.replaceAll("\\s", "");
		int origLocRow = 8 - Character.getNumericValue(move.charAt(1));
		int origLocCol = Character.getNumericValue(move.charAt(0)) - 10;
		int newLocRow = 8 - Character.getNumericValue(move.charAt(3));
		int newLocCol = Character.getNumericValue(move.charAt(2)) - 10;
		
		if(Board.inBound(newLocRow, newLocCol) && Board.inBound(origLocRow, origLocCol)) {
			if(!Board.isBlack(origLocRow, origLocCol)) {		
				
				if( Board.isEmpty(newLocRow, newLocCol) && (newLocRow == origLocRow - 1 && newLocCol == origLocCol )) {
					isFirstMove = false;
					return true;
				}
				
				if(isFirstMove && Board.isEmpty(newLocRow, newLocCol) && (newLocRow == origLocRow - 2 && newLocCol == origLocCol )) {
					isFirstMove = false;
					return true;
				}
				
				if(( (newLocRow == origLocRow - 1 && newLocCol == origLocCol + 1 ) || (newLocRow == origLocRow - 1 && newLocCol == origLocCol - 1 ) ) && !Board.isEmpty(newLocRow, newLocCol)) {
					if( (Board.isBlack(newLocRow, newLocCol) && !Board.isBlack(origLocRow, origLocCol)) ||  (!Board.isBlack(newLocRow, newLocCol) && Board.isBlack(origLocRow, origLocCol))) {
						return true;
					}
				}
			}
			else {				
				if( Board.isEmpty(newLocRow, newLocCol) && (newLocRow == origLocRow + 1 && newLocCol == origLocCol )) {
					isFirstMove = false;
					return true;
				}
				
				if(isFirstMove && Board.isEmpty(newLocRow, newLocCol) && (newLocRow == origLocRow + 2 && newLocCol == origLocCol )) {
					isFirstMove = false;
					return true;
				}
				
				if(( (newLocRow == origLocRow + 1 && newLocCol == origLocCol + 1 ) || (newLocRow == origLocRow + 1 && newLocCol == origLocCol - 1 ) ) && !Board.isEmpty(newLocRow, newLocCol)) {
					if( (Board.isBlack(newLocRow, newLocCol) && !Board.isBlack(origLocRow, origLocCol)) ||  (!Board.isBlack(newLocRow, newLocCol) && Board.isBlack(origLocRow, origLocCol))) {
						return true;
					}
				}
			}
		}
		
		return false;
	}

	@Override
	public boolean isCheck(String move) {
		// TODO Auto-generated method stub
		return false;
	}

}
