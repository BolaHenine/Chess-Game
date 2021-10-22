package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MainDriver {

    public static void main(String[] args) throws IOException {
	Board.boardInit();
	Board.printBoard();
	boolean whiteTurn = true;
	Scanner sc = new Scanner(System.in);
	String move = "";
	Boolean whiteWon = false;
	Boolean blackWon = false;
	Boolean whiteDraw = false;
	Boolean blackDraw = false;
	String draw = "draw";

//	while (whiteWon != true || blackWon != true) {
//	    if (whiteWon == true) {
//		System.out.print("\n");
//		System.out.print("White wins");
//		break;
//	    }
//	    if (blackWon == true) {
//		System.out.print("\n");
//		System.out.print("Black wins");
//		break;
//	    }
//	    if (whiteDraw == true) {
//		whiteTurn = false;
//	    }
//	    if (blackDraw == true) {
//		whiteTurn = true;
//	    }
//	    if (whiteTurn) {
//
//		System.out.print("White Turn: ");
//		move = sc.nextLine();
//		if (move.length() == 5 || move.length() == 7) {
//
//		    while (!Board.isLegalMove(move, whiteTurn)) {
//			System.out.print("\n");
//			System.out.println("Illegal Move, try again");
//			System.out.print("White Turn: ");
//			move = sc.nextLine();
//		    }
//
//		    Board.move(move);
//		    System.out.print("\n");
//		    Board.printBoard();
//		    if (Board.isCheck(!whiteTurn)) {
//			if (Board.isCheckMate(!whiteTurn)) {
//			    System.out.println("Checkmate");
//			    whiteWon = true;
//			}
//		    }
//
//		    whiteTurn = !whiteTurn;
//		} else if (move.length() == 11 && move.contains("draw?") && move.indexOf("draw?") == 6) {
//		    System.out.print("\n");
//		    whiteDraw = true;
//
//		} else if (whiteDraw = true && move.contains(draw)) {
//		    System.out.print("\n");
//		    System.out.print(draw);
//		    break;
//		} else if (move.length() == 6 && move.contains("resign")) {
//		    blackWon = true;
//
//		}
//
//	    } else {
//
//		System.out.print("Black Turn: ");
//		move = sc.nextLine();
//		if (move.length() == 5 || move.length() == 7) {
//		    while (!Board.isLegalMove(move, whiteTurn)) {
//			System.out.print("\n");
//			System.out.println("Illegal Move, try again");
//			System.out.print("Black Turn: ");
//			move = sc.nextLine();
//		    }
//		    Board.move(move);
//		    System.out.print("\n");
//		    Board.printBoard();
//
//		    if (Board.isCheck(whiteTurn)) {
//			if (Board.isCheckMate(whiteTurn)) {
//			    System.out.println("Checkmate");
//			    blackWon = true;
//			}
//		    }
//
//		    whiteTurn = !whiteTurn;
//		} else if (move.length() == 11 && move.contains("draw?") && move.indexOf("draw?") == 6) {
//		    System.out.print("\n");
//		    blackDraw = true;
//
//		} else if (blackDraw = true && move.contains(draw)) {
//		    System.out.print("\n");
//		    System.out.print(draw);
//		    break;
//		}
//
//		else if (move.length() == 6 && move.contains("resign")) {
//		    whiteWon = true;
//
//		}
//	    }
//
//	}

	BufferedReader reader = new BufferedReader(
		new FileReader("/Users/bolahenine/eclipse-workspace/Random/Hello1.txt"));
	String line;

	String line2;
	int count = 0;
	while (whiteWon != true || blackWon != true) {
	    if (whiteWon == true) {
		System.out.print("\n");
		System.out.print("White wins");
		break;
	    }
	    if (blackWon == true) {
		System.out.print("\n");
		System.out.print("Black wins");
		break;
	    }
	    if (whiteTurn) {

		System.out.print("White Turn: ");
		line = reader.readLine();
		System.out.println(line);
		if (line.length() == 5 || line.length() == 7) {

//		    while (!Board.isLegalMove(line, whiteTurn)) {
//			System.out.print("\n");
//			System.out.println("Illegal Move, try again");
//			System.out.print("White Turn: ");
//		    }

		    Board.move(line);
		    System.out.print("\n");
		    Board.printBoard();

		    if (Board.isCheck(true)) {
			if (Board.isCheckMate(true)) {
			    System.out.println("Checkmate");
			    whiteWon = true;
			}
		    }
//
		    whiteTurn = false;
//
		}

	    } else {

		System.out.print("Black Turn: ");
		line2 = reader.readLine();
		System.out.println(line2);
		if (line2.length() == 5 || line2.length() == 7) {
//		    while (!Board.isLegalMove(line2, whiteTurn)) {
//			System.out.print("\n");
//			System.out.println("Illegal Move, try again");
//			System.out.print("Black Turn: ");
//		    }
		    Board.move(line2);
		    System.out.print("\n");
		    Board.printBoard();

		    if (Board.isCheck(false)) {
			if (Board.isCheckMate(false)) {
			    System.out.println("Checkmate");
			    blackWon = true;
			}
		    }

		    whiteTurn = true;
		}
	    }

	}
	reader.close();
////

	// while(!Board.isCheckMate(!whiteTurn) == true ||
	// !Board.isCheckMate(whiteTurn)==true) {
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
