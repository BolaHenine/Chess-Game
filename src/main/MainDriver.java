package main;
import main.Board;
import Pieces.Pawn;
import Pieces.Piece;
public class MainDriver {

	public static void main(String[] args) {

		boolean whiteTurn = false;
		String s = "b7 b6";
		s = s.replaceAll("\\s", "");
		int newLocRow = s.charAt(2) - 97;
		int newLocCol = Character.getNumericValue(s.charAt(3)) - 1;
		
		
		
		Board.boardInit();
		System.out.println(Board.isLegalMove(s, whiteTurn));
		System.out.println(Board.getPieceName(1, 6));
		Board.move(s);
		System.out.println(Board.getPieceName(1, 6));
		
		
		
		
//		Piece test = new Pawn("wp", "black");			
//		int y = s.charAt(2) - 97;
//		int x = Character.getNumericValue(s.charAt(3)) - 1;
		
//		System.out.println(y + " " + x);
//		
//		System.out.println(s.charAt(2) + "asd");
		
		//System.out.print(Board.getPieceName(0,1));

	}

}
