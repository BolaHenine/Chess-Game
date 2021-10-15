package Pieces;
import Pieces.Piece;
import main.Board;

public class Knight extends Piece{
private boolean isFirstMove = true;
	
	public Knight(String pieceName, String color) {
		super(pieceName, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isLegalMove(String move) {
		move = move.replaceAll("\\s", "");
		int origLocRow = 8 - Character.getNumericValue(move.charAt(1));
		int origLocCol = Character.getNumericValue(move.charAt(0)) - 10;
		int newLocRow = 8 - Character.getNumericValue(move.charAt(3));
		int newLocCol = Character.getNumericValue(move.charAt(2)) - 10;
		
		
		if(Board.inBound(newLocRow, newLocCol) && Board.inBound(origLocRow, origLocCol)) {
			if(!Board.isBlack(origLocRow, origLocCol)) {
				
				if((newLocRow == origLocRow - 1 && newLocCol == origLocCol + 2 ) || (newLocRow == origLocRow + 1 && newLocCol == origLocCol + 2 )) {
					isFirstMove = false;
					return true;
				}
				
				if((newLocRow == origLocRow + 2 && newLocCol == origLocCol + 1 ) || (newLocRow == origLocRow - 2 && newLocCol == origLocCol + 1 )) {
					isFirstMove = false;
					return true;
				}
				
				if((newLocRow == origLocRow + 2 && newLocCol == origLocCol - 1 ) || (newLocRow == origLocRow - 2 && newLocCol == origLocCol - 1 )) {
					isFirstMove = false;
					return true;
				}
				
				if((newLocRow == origLocRow - 1 && newLocCol == origLocCol - 2 ) || (newLocRow == origLocRow + 1 && newLocCol == origLocCol - 2 )) {
					isFirstMove = false;
					return true;
				}
				
				
			}
			else {				
				if ((newLocRow == origLocRow - 1 && newLocCol == origLocCol - 2 ) || (newLocRow == origLocRow + 1 && newLocCol == origLocCol - 2 )) {
					isFirstMove = false;
					return true;
				}
				
				if((newLocRow == origLocRow + 2 && newLocCol == origLocCol + 1 ) || (newLocRow == origLocRow - 2 && newLocCol == origLocCol + 1 )) {
					isFirstMove = false;
					return true;
				}
				
				if ((newLocRow == origLocRow + 2 && newLocCol == origLocCol - 1 ) || (newLocRow == origLocRow - 2 && newLocCol == origLocCol - 1 )) {
					isFirstMove = false;
					return true;
				}
				
				if ((newLocRow == origLocRow - 1 && newLocCol == origLocCol + 2 ) || (newLocRow == origLocRow + 1 && newLocCol == origLocCol + 2 )) {
					isFirstMove = false;
					return true;
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

