package main;
import Pieces.Pawn;
import Pieces.King;
import Pieces.Knight;
import Pieces.Piece;
import Pieces.Rook;

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
//		board[5][2] = new King("bK", "black");
		board[4][2] = new King("wK", "white");
		
		board[7][0] = new Rook("wR", "white");
		board[4][0] = new Rook("wR", "white");
		board[7][3] = new Knight("wN", "white");
		
		board[1][6] = new Rook("bR", "black");
		board[3][5] = new Rook("bR", "black");
		board[2][3] = new Rook("bR", "black");
		board[7][1] = new Rook("bR", "black");
		board[5][0] = new Rook("bR", "black");
		board[2][2] = new Rook("bR", "black");
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
		else if(!Board.inBound(newLocRow, newLocCol)) {
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
		return false;
	}
	
	public static boolean isCheckMate(boolean whiteTurn) {
		int kingCol = 0;
		int kingRow = 0;
		int tempCol = 0;
		int tempRow = 0;
		
		
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
		
//		move +=  ((char) (kingCol + 97)) + "" + kingRow;
//		System.out.println(move);
		
		
		for(int i = 0; i < 4 ; i++ ) {
			String move = "";
			String moveBack = "";
			if(i == 0) {
				tempCol = kingCol + 1;
				tempRow = kingRow;
				move = ((char) (kingCol + 97)) + "" + (kingRow) + " " + ((char) (tempCol + 97)) + "" + (tempRow);
				moveBack = ((char) (tempCol + 97)) + "" + (tempRow) + " " + ((char) (kingCol + 97)) + "" + (kingRow);
				if(Board.isLegalMove(move, !whiteTurn)) {
					Board.move(move);
					if(!Board.isCheck(whiteTurn)) {
						Board.move(moveBack);
						return false;
					}
					Board.move(moveBack);
				}
			}
			else if(i == 1 ) {
				tempCol = kingCol;
				tempRow = kingRow + 1;
				move = ((char) (kingCol + 97)) + "" + (kingRow) + " " + ((char) (tempCol + 97)) + "" + (tempRow);
				moveBack = ((char) (tempCol + 97)) + "" + (tempRow) + " " + ((char) (kingCol + 97)) + "" + (kingRow);
				if(Board.isLegalMove(move, !whiteTurn)) {
					Board.move(move);
					if(!Board.isCheck(whiteTurn)) {
						Board.move(moveBack);
						return false;
					}
					Board.move(moveBack);
				}
			}
			else if(i == 2) {
				tempCol = kingCol - 1;
				tempRow = kingRow;
				move = ((char) (kingCol + 97)) + "" + (kingRow) + " " + ((char) (tempCol + 97)) + "" + (tempRow);
				moveBack = ((char) (tempCol + 97)) + "" + (tempRow) + " " + ((char) (kingCol + 97)) + "" + (kingRow);
				if(Board.isLegalMove(move, !whiteTurn)) {
					Board.move(move);
					if(!Board.isCheck(whiteTurn)) {
						Board.move(moveBack);
						return false;
					}
					Board.move(moveBack);
				}
			}
			else if(i == 3) {
				tempCol = kingCol;
				tempRow = kingRow - 1;
				move = ((char) (kingCol + 97)) + "" + (kingRow) + " " + ((char) (tempCol + 97)) + "" + (tempRow);
				moveBack = ((char) (tempCol + 97)) + "" + (tempRow) + " " + ((char) (kingCol + 97)) + "" + (kingRow);
				if(Board.isLegalMove(move, !whiteTurn)) {
					Board.move(move);
					if(!Board.isCheck(whiteTurn)) {
						Board.move(moveBack);
						return false;
					}
					Board.move(moveBack);
				}
			}
			
		}

		
			
		return true;
	}
	
}
