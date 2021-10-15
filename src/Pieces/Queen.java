package Pieces;
import Pieces.Piece;
import main.Board;

public class Queen extends Piece{

	
	public Queen(String pieceName, String color) {
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
				if( Board.isEmpty(newLocRow, newLocCol) && (newLocRow == origLocRow && ((newLocCol == origLocCol + 1)  || (newLocCol == origLocCol + 2) || (newLocCol == origLocCol + 3) || (newLocCol == origLocCol + 4) || (newLocCol == origLocCol + 5) || (newLocCol == origLocCol + 6) || (newLocCol == origLocCol + 7) ))) {
					
					return true;
				}
				
				if(Board.isEmpty(newLocRow, newLocCol) && (newLocRow == origLocRow && ((newLocCol == origLocCol - 1)  || (newLocCol == origLocCol - 2) || (newLocCol == origLocCol - 3) || (newLocCol == origLocCol - 4) || (newLocCol == origLocCol - 5) || (newLocCol == origLocCol - 6) || (newLocCol == origLocCol - 7) ))) {
					
					return true;
				}
				
				if( Board.isEmpty(newLocRow, newLocCol) && (newLocCol == origLocCol && ((newLocRow == origLocRow + 1)  || (newLocRow == origLocRow + 2) || (newLocRow == origLocRow + 3) || (newLocRow == origLocRow + 4) || (newLocRow == origLocRow + 5) || (newLocRow == origLocRow + 6) || (newLocRow == origLocRow + 7) ))) {
					
					return true;
				}
				
				if( Board.isEmpty(newLocRow, newLocCol) && (newLocCol == origLocCol && ((newLocRow == origLocRow - 1)  || (newLocRow == origLocRow - 2) || (newLocRow == origLocRow - 3) || (newLocRow == origLocRow - 4) || (newLocRow == origLocRow - 5) || (newLocRow == origLocRow - 6) || (newLocRow == origLocRow - 7) ))) {
					
					return true;
				}
				
				if( Board.isEmpty(newLocRow, newLocCol) && (newLocCol == origLocCol+1 && newLocRow == origLocRow + 1) || (newLocCol == origLocCol+2 && newLocRow == origLocRow + 2) || (newLocCol == origLocCol+3 && newLocRow == origLocRow + 3) || (newLocCol == origLocCol+4 && newLocRow == origLocRow + 4) || (newLocCol == origLocCol+5 && newLocRow == origLocRow + 5) || (newLocCol == origLocCol+6 && newLocRow == origLocRow + 6) || (newLocCol == origLocCol+7 && newLocRow == origLocRow + 7) ) {
					
					return true;
				}
				
				if( Board.isEmpty(newLocRow, newLocCol) && (newLocCol == origLocCol - 1 && newLocRow == origLocRow - 1) || (newLocCol == origLocCol-2 && newLocRow == origLocRow - 2) || (newLocCol == origLocCol-3 && newLocRow == origLocRow - 3) || (newLocCol == origLocCol-4 && newLocRow == origLocRow - 4) || (newLocCol == origLocCol-5 && newLocRow == origLocRow - 5) || (newLocCol == origLocCol-6 && newLocRow == origLocRow - 6) || (newLocCol == origLocCol-7 && newLocRow == origLocRow - 7) ) {
					
					return true;
				}
				
				if( Board.isEmpty(newLocRow, newLocCol) && (newLocCol == origLocCol+1 && newLocRow == origLocRow - 1) || (newLocCol == origLocCol+2 && newLocRow == origLocRow - 2) || (newLocCol == origLocCol+3 && newLocRow == origLocRow - 3) || (newLocCol == origLocCol+4 && newLocRow == origLocRow - 4) || (newLocCol == origLocCol+5 && newLocRow == origLocRow - 5) || (newLocCol == origLocCol+6 && newLocRow == origLocRow - 6) || (newLocCol == origLocCol+7 && newLocRow == origLocRow - 7) ) {
					
					return true;
				}
				
				if( Board.isEmpty(newLocRow, newLocCol) && (newLocCol == origLocCol-1 && newLocRow == origLocRow + 1) || (newLocCol == origLocCol-2 && newLocRow == origLocRow + 2) || (newLocCol == origLocCol-3 && newLocRow == origLocRow + 3) || (newLocCol == origLocCol-4 && newLocRow == origLocRow + 4) || (newLocCol == origLocCol-5 && newLocRow == origLocRow + 5) || (newLocCol == origLocCol-6 && newLocRow == origLocRow + 6) || (newLocCol == origLocCol-7 && newLocRow == origLocRow + 7) ) {
					
					return true;
				}
				
			}
			else {				
				if( Board.isEmpty(newLocRow, newLocCol) && (newLocRow == origLocRow && ((newLocCol == origLocCol + 1)  || (newLocCol == origLocCol + 2) || (newLocCol == origLocCol + 3) || (newLocCol == origLocCol + 4) || (newLocCol == origLocCol + 5) || (newLocCol == origLocCol + 6) || (newLocCol == origLocCol + 7) ))) {
					
					return true;
				}
				
				if(Board.isEmpty(newLocRow, newLocCol) && (newLocRow == origLocRow && ((newLocCol == origLocCol - 1)  || (newLocCol == origLocCol - 2) || (newLocCol == origLocCol - 3) || (newLocCol == origLocCol - 4) || (newLocCol == origLocCol - 5) || (newLocCol == origLocCol - 6) || (newLocCol == origLocCol - 7) ))) {
					
					return true;
				}
				
				if( Board.isEmpty(newLocRow, newLocCol) && (newLocCol == origLocCol && ((newLocRow == origLocRow + 1)  || (newLocRow == origLocRow + 2) || (newLocRow == origLocRow + 3) || (newLocRow == origLocRow + 4) || (newLocRow == origLocRow + 5) || (newLocRow == origLocRow + 6) || (newLocRow == origLocRow + 7) ))) {
					
					return true;
				}
				
				if( Board.isEmpty(newLocRow, newLocCol) && (newLocCol == origLocCol && ((newLocRow == origLocRow - 1)  || (newLocRow == origLocRow - 2) || (newLocRow == origLocRow - 3) || (newLocRow == origLocRow - 4) || (newLocRow == origLocRow - 5) || (newLocRow == origLocRow - 6) || (newLocRow == origLocRow - 7) ))) {
					
					return true;
				}
				
				if( Board.isEmpty(newLocRow, newLocCol) && (newLocCol == origLocCol+1 && newLocRow == origLocRow + 1) || (newLocCol == origLocCol+2 && newLocRow == origLocRow + 2) || (newLocCol == origLocCol+3 && newLocRow == origLocRow + 3) || (newLocCol == origLocCol+4 && newLocRow == origLocRow + 4) || (newLocCol == origLocCol+5 && newLocRow == origLocRow + 5) || (newLocCol == origLocCol+6 && newLocRow == origLocRow + 6) || (newLocCol == origLocCol+7 && newLocRow == origLocRow + 7) ) {
					
					return true;
				}
				
				if( Board.isEmpty(newLocRow, newLocCol) && (newLocCol == origLocCol - 1 && newLocRow == origLocRow - 1) || (newLocCol == origLocCol-2 && newLocRow == origLocRow - 2) || (newLocCol == origLocCol-3 && newLocRow == origLocRow - 3) || (newLocCol == origLocCol-4 && newLocRow == origLocRow - 4) || (newLocCol == origLocCol-5 && newLocRow == origLocRow - 5) || (newLocCol == origLocCol-6 && newLocRow == origLocRow - 6) || (newLocCol == origLocCol-7 && newLocRow == origLocRow - 7) ) {
					
					return true;
				}
				
				if( Board.isEmpty(newLocRow, newLocCol) && (newLocCol == origLocCol+1 && newLocRow == origLocRow - 1) || (newLocCol == origLocCol+2 && newLocRow == origLocRow - 2) || (newLocCol == origLocCol+3 && newLocRow == origLocRow - 3) || (newLocCol == origLocCol+4 && newLocRow == origLocRow - 4) || (newLocCol == origLocCol+5 && newLocRow == origLocRow - 5) || (newLocCol == origLocCol+6 && newLocRow == origLocRow - 6) || (newLocCol == origLocCol+7 && newLocRow == origLocRow - 7) ) {
					
					return true;
				}
				
				if( Board.isEmpty(newLocRow, newLocCol) && (newLocCol == origLocCol-1 && newLocRow == origLocRow + 1) || (newLocCol == origLocCol-2 && newLocRow == origLocRow + 2) || (newLocCol == origLocCol-3 && newLocRow == origLocRow + 3) || (newLocCol == origLocCol-4 && newLocRow == origLocRow + 4) || (newLocCol == origLocCol-5 && newLocRow == origLocRow + 5) || (newLocCol == origLocCol-6 && newLocRow == origLocRow + 6) || (newLocCol == origLocCol-7 && newLocRow == origLocRow + 7) ) {
					
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
