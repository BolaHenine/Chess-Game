package main;
import main.Board;

import java.util.Scanner;

import Pieces.Pawn;
import Pieces.Piece;
public class MainDriver {

	public static void main(String[] args) {
		Board.boardInit();
		Board.printBoard();
		boolean whiteTurn = true;
		Scanner sc = new Scanner(System.in);
		String move = "";
		while(!Board.isCheckMate(!whiteTurn) == true || !Board.isCheckMate(whiteTurn)==true) {
			if(whiteTurn) {
				System.out.println("White Turn: ");
				move = sc.nextLine();
				while(!Board.isLegalMove(move, whiteTurn)) {
					System.out.println("Illegal Move, Enter another move: ");
					move = sc.nextLine();
				}
				Board.move(move);
				Board.printBoard();
				whiteTurn = !whiteTurn;
				
			}
			else {
				System.out.print("Black Turn: ");
				move = sc.nextLine();
				while(!Board.isLegalMove(move, whiteTurn)) {
					System.out.println("Illegal Move, Enter another move: ");
					move = sc.nextLine();
				}
				Board.move(move);
				Board.printBoard();
				whiteTurn = !whiteTurn;
			}
		}
//		
		
		

		
//		System.out.println(Board.isLegalMove(move, whiteTurn));
//		s
//		
//		System.out.println(Board.getPieceName(0, 2));
//		
//		
//		System.out.println( origLocRow + " " + origLocCol + " " + newLocRow + " " + newLocCol);
//	
		
		
//		System.out.println(Board.getPieceName(7, 2).charAt(1));
//		System.out.println(Board.isBlack(7, 2));
		
	
//		Board.printBoard();
//		System.out.println("Black King Check: " + Board.isCheck(whiteTurn));
//		System.out.println("White King Check: " + Board.isCheck(!whiteTurn));
//		
//		System.out.println(Board.isCheckMate(!whiteTurn));
//		System.out.print("c5");
//		Board.isCheck(whiteTurn);
		
		
	
		
//		
//		Board.move(s);
//
//		Board.printBoard();
	}

}




// Board[Row][Column]
// User input [Col][Row] so it must be switched
// checkmate is checked after turn for example if black makes his moves it switches to white turn and then check
// for checkmate and then gives turn to white.

// for islegal we send the correct color.
// for checkmate and check we send the opposite color.

//to check for white check use isCheck(!white)
