package main;
import Pieces.Pawn;
import Pieces.King;
import Pieces.Knight;
import Pieces.Piece;
import Pieces.Rook;
import Pieces.Bishop;
import Pieces.Queen;

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
		board[6][2] = new Pawn("bp" , "black");
		board[1][0] = new Knight("wN", "white" );
		board[0][2] = new Knight("wN","white");
		board[5][2] = new King("bK", "black");
		board[3][2] = new King("wK", "white");
		board[1][4] = new Pawn("wp","white");
		
		board[7][0] = new Rook("wR", "white");
		board[4][0] = new Rook("wR", "white");
		board[7][3] = new Knight("wN", "white");
		board[2][6] = new Queen("bQ", "black");
		
		board[1][6] = new Rook("bR", "black");
		board[3][5] = new Rook("bR", "black");
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
		int origLocRow = 8 - Character.getNumericValue(move.charAt(1));
		int origLocCol = Character.getNumericValue(move.charAt(0)) - 10;
		int newLocRow = 8 - Character.getNumericValue(move.charAt(3));
		int newLocCol = Character.getNumericValue(move.charAt(2)) - 10;
		
		
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
		int origLocRow = 8 - Character.getNumericValue(move.charAt(1));
		int origLocCol = Character.getNumericValue(move.charAt(0)) - 10;
		int newLocRow = 8 - Character.getNumericValue(move.charAt(3));
		int newLocCol = Character.getNumericValue(move.charAt(2)) - 10;
		
		if(move.length()>4)
		{
		
			char promPiece = move.charAt(4);
			
			if(Board.getPieceName(origLocRow, origLocCol) == "wp" && Board.isEmpty(newLocRow, newLocCol) && (newLocRow == 0 && newLocCol == origLocCol)) {
				if (promPiece == 'N')
				{
					board[newLocRow][newLocCol] = new Knight("wN", "white");
					board[origLocRow][origLocCol] = null;
					return board;
				}
				if (promPiece == 'B')
				{
					board[newLocRow][newLocCol] = new Bishop("wB", "white");
					board[origLocRow][origLocCol] = null;
					return board;
				}
				if (promPiece == 'R')
				{
					board[newLocRow][newLocCol] = new Rook("wR", "white");
					board[origLocRow][origLocCol] = null;
					return board;
				}
				if (promPiece == 'Q')
				{
					board[newLocRow][newLocCol] = new Queen("wQ", "white");
					board[origLocRow][origLocCol] = null;
					return board;
				}
				
			}
			else if (Board.getPieceName(origLocRow, origLocCol) == "bp" && Board.isEmpty(newLocRow, newLocCol) && (newLocRow == 7 && origLocCol == newLocCol))
			{
				
				if (promPiece == 'N')
				{
					
					board[newLocRow][newLocCol] = new Knight("bN","black");
					board[origLocRow][origLocCol] = null;
					return board;
				}
				if (promPiece == 'B')
				{
					board[newLocRow][newLocCol] = new Bishop("bB", "black");
					board[origLocRow][origLocCol] = null;
					return board;
				}
				if (promPiece == 'R')
				{
					board[newLocRow][newLocCol] = new Rook("bR", "black");
					board[origLocRow][origLocCol] = null;
					return board;
				}
				if (promPiece == 'Q')
				{
					board[newLocRow][newLocCol] = new Queen("bQ", "black");
					board[origLocRow][origLocCol] = null;
					return board;
				}
				
			}
		}
		if(Board.getPieceName(origLocRow, origLocCol) == "bp" && Board.isEmpty(newLocRow, newLocCol) && (newLocRow == 7 && origLocCol == newLocCol))
		{
			board[newLocRow][newLocCol] = new Queen("bQ", "black");
			board[origLocRow][origLocCol] = null;
			
			return board;
		}
		else if (Board.getPieceName(origLocRow, origLocCol) == "wp" && Board.isEmpty(newLocRow, newLocCol) && (newLocRow == 0 && newLocCol == origLocCol))
		{
			board[newLocRow][newLocCol] = new Queen("wQ", "white");
			board[origLocRow][origLocCol] = null;
			
			return board;
		}
		board[newLocRow][newLocCol] = board[origLocRow][origLocCol];
		
		board[origLocRow][origLocCol] = null;
		
		return board;
	}

	public static void printBoard() {
		
		int rowCount = 8;  
		
		boolean switchPrint = true;  
		
		for(int i = 0; i < 8; i++) { 
			for(int j = 0; j < 8; j++) {  // loop through the array column
				if(board[i][j] != null) {  // if game piece exists at index, print it
					System.out.print(board[i][j].getName());
				} 
				else if(switchPrint) {  
						if(i % 2 != 0) {	
							System.out.print("##");
						} 
						else {
							System.out.print("  ");
						}		
				} 
				else {  // print black spaces
					if(i % 2 == 0) {	
						System.out.print("##");
					} 
					else { 
						System.out.print("  ");
					}
				}
				System.out.print(" ");
				switchPrint = !switchPrint;  // change print scheme for every other row
			}
			System.out.print(rowCount);  // print out row number at the end of each row
			rowCount--;
			System.out.println();
		}
		
		System.out.print(" a");
		
		for(char i = 'b'; i < 105; i++) {  // print the column letter at the bottom of each column
			
			System.out.print("  " + i);
			
		}
		
		System.out.println();
		System.out.println();
	}
	
	
	
	public static boolean isCheck(boolean whiteTurn) {
		int kingCol = 0;
		int kingRow = 0;
		String move = "";
		
			for(int i = 0; i < 8; i++) {
				for(int j = 0; j < 8; j++) {
					if(Board.getPieceName(i, j) != null) {
						if(Board.getPieceName(i, j).charAt(1) == 'K' && Board.isBlack(i, j) == whiteTurn ) {
							kingRow = 8 - i;
							kingCol = j;
						}
					}
					
				}
			}
			
			for(int i = 0; i < 8; i++) {
				for(int j = 0; j < 8; j++) {
					if(Board.getPieceName(i, j) != null && Board.isBlack(i, j) != whiteTurn) {
						move += ((char) (j + 97)) + "" + (8- i) + " " + ((char) (kingCol + 97)) + "" + kingRow;
						if(board[i][j].isLegalMove(move)){
							move = "";
							return true;
							
						}
						else {
							move = "";
						}
					}
					move = "";
				}
			}
//		}
//		else {
//			for(int i = 0; i < 8; i++) {
//				for(int j = 0; j < 8; j++) {
//					if(Board.getPieceName(i, j) != null) {
//						if(Board.getPieceName(i, j).charAt(1) == 'K' && Board.isBlack(i, j) == whiteTurn ) {
//							kingRow = 8 - i;
//							kingCol = j;
//						}
//					}
//					
//				}
//			}
//			
//			for(int i = 0; i < 8; i++) {
//				for(int j = 0; j < 8; j++) {
//					if(Board.getPieceName(i, j) != null && Board.isBlack(i, j) != whiteTurn) {
//						move += ((char) (j + 97)) + "" + (8- i) + " " + ((char) (kingCol + 97)) + "" + kingRow;
//						System.out.println(move);
//						if(board[i][j].isLegalMove(move)){
//							move = "";
//							return true;
//							
//						}
//						else {
//							move = "";
//						}
//					}
//					move = "";
//				}
//			}
//		}
		return false;
	}
			
}
