package Pieces;

import main.Board;

public class King extends Piece {

	public King(String pieceName, String color) {
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
			if( (newLocRow == origLocRow) &&  ( (newLocCol ==  origLocCol + 1) || (newLocCol ==  origLocCol - 1) ) ) { // Left and Right movements
				return true;
			}
			if(((newLocCol == origLocCol) && (  (newLocRow == origLocRow - 1) || (newLocRow == origLocRow + 1)))) {  //Up and Down Move
				return true;
			}
			
			if( ( (newLocCol == origLocCol + 1) ||  (newLocCol == origLocCol - 1))  &&  ( (newLocRow == origLocRow + 1) || (newLocRow == origLocRow - 1) )  ) { 
				return true;
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
