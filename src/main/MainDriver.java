package main;
import main.Board;
import Pieces.Pawn;
import Pieces.Piece;
public class MainDriver {

	public static void main(String[] args) {

		boolean whiteTurn = true;
		String s = "a1 c1";
		s = s.replaceAll("\\s", "");
		int origLocRow = 8 - Character.getNumericValue(s.charAt(1));
		int origLocCol = Character.getNumericValue(s.charAt(0)) - 10;
		int newLocRow = 8 - Character.getNumericValue(s.charAt(3));
		int newLocCol = Character.getNumericValue(s.charAt(2)) - 10;
		
		
		
		if(whiteTurn) {
			System.out.println("White turn");
		}
		else {
			System.out.println("Black turn");
		}
		
		Board.boardInit();
		System.out.println(Board.isLegalMove(s, whiteTurn));
//		
//		
//		System.out.println(Board.getPieceName(0, 2));
//		
//		
//		System.out.println( origLocRow + " " + origLocCol + " " + newLocRow + " " + newLocCol);
//	
		
		
		
		
		Board.printBoard();
		
		Board.move(s);

		Board.printBoard();
	}

}
