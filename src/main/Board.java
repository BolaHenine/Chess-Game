package main;
import Pieces.Pawn;
import Pieces.King;
import Pieces.Knight;
import Pieces.Piece;

public class Board {
	
	
	public static Piece[][] board = new Piece[8][8];
	
	
	
	
	public static boolean inBound(int row, int col) {
		
		if(( row >= 0 && row < 8) && (col >= 0 && col < 8)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
	public static boolean isEmpty(int row, int col) {
		if(board[row][col] == null) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	
	
	public static void boardInit() {
//		board[4][1] = new Pawn("wp" , "black");
//		board[1][0] = new Knight("wN", "white" );
//		board[0][2] = new Knight("wN","black");
		board[4][2] = new King("wK", "white");
	}
	
	
	
	public static String getPieceName(int row, int col) {
		
		if(!((row >= 0 && row < 8) &&  (col >= 0 && col < 8))) {
			
			return null;
		}
		
		if(board[row][col] != null) { 
			
			return board[row][col].getName();
			
		} 
		
		return null;
	}
	
public static boolean isBlack(int row, int col) {
		
	
		if(board[row][col].isBlack()) { 	
			return true;
			
		}
		else {
			return false; 
		}
		
		
		
	}


public static boolean isLegalMove(String move, boolean whiteTurn) {
	move = move.replaceAll("\\s", "");
	int origLocRow = move.charAt(0) - 97;
	int origLocCol = Character.getNumericValue(move.charAt(1)) - 1;
	int newLocRow = move.charAt(2) - 97;
	int newLocCol = Character.getNumericValue(move.charAt(3)) - 1;
	
	if( Board.isEmpty(origLocRow, origLocCol)  ||  Board.isBlack(origLocRow, origLocCol) == whiteTurn) {
		return false;
	}
	else if(!Board.isEmpty(newLocRow, newLocCol) && Board.isBlack(newLocRow, newLocCol) != whiteTurn)
	{
		return false;
	}
	else {
		return board[origLocRow][origLocCol].isLegalMove(move);
	}
	
	
	
}
	
	
public static Piece[][] move(String move){
	move = move.replaceAll("\\s", "");
	int origLocRow = move.charAt(0) - 97;
	int origLocCol = Character.getNumericValue(move.charAt(1)) - 1;
	
	int newLocRow = move.charAt(2) - 97;
	int newLocCol = Character.getNumericValue(move.charAt(3)) - 1;
	
	board[newLocRow][newLocCol] = board[origLocRow][origLocCol];
	
	board[origLocRow][origLocCol] = null;
	
	return board;
}
	
	

	
	
	
//	public static void main(String args[]) {
//		
//		
//		
//	}
	
	

}
