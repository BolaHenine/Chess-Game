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
		int origLocRow = move.charAt(0) - 97;
		int origLocCol = Character.getNumericValue(move.charAt(1)) - 1;
		
		int newLocRow = move.charAt(2) - 97;
		int newLocCol = Character.getNumericValue(move.charAt(3)) - 1;
		
		
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
	
//	
//	public static void main(String[] args) {
//		Piece test = new Pawn("wp", "black");
//		
//		Board.boardInit();
//		
//		
//		String s = "b7 e4";
//		
//		s.trim();
//		int y = s.charAt(0) - 97;
//		int x = Character.getNumericValue(s.charAt(1)) - 1;
//		
//		System.out.print(y + " " + x);
//		
//		//System.out.print(Board.getPieceName(0,1));
//	
//		
//
//	}

}

