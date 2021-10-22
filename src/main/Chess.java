/**
 * @author Bola Henine
 *
 * @author Roshan Seth
 */

package main;

import java.util.Scanner;

public class Chess {

    public static void main(String[] args) {
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
	    if (whiteDraw == true) {
		whiteTurn = false;
	    }
	    if (blackDraw == true) {
		whiteTurn = true;
	    }
	    if (whiteTurn) {

		System.out.print("White Turn: ");
		move = sc.nextLine();
		if (move.length() == 5 || move.length() == 7) {
		    while (!Board.isLegalMove(move, whiteTurn)) {
			System.out.println("Illegal Move, try again");
			System.out.print("White Turn: ");
			move = sc.nextLine();
		    }

		    Board.move(move);
		    System.out.print("\n");
		    Board.printBoard();
		    if (Board.isCheck(true)) {
			System.out.println("Check");
			if (Board.isCheckMate(true)) {
			    System.out.println("Checkmate");
			    whiteWon = true;
			}
		    }

		    whiteTurn = false;
		} else if (move.length() == 11 && move.contains("draw?") && move.indexOf("draw?") == 6) {
		    System.out.print("\n");
		    whiteDraw = true;

		} else if (whiteDraw = true && move.contains(draw)) {
		    System.out.print("\n");
		    System.out.print(draw);
		    break;
		} else if (move.length() == 6 && move.contains("resign")) {
		    blackWon = true;

		}

	    } else {

		System.out.print("Black Turn: ");
		move = sc.nextLine();
		if (move.length() == 5 || move.length() == 7) {
		    while (!Board.isLegalMove(move, whiteTurn)) {
			System.out.println("Illegal Move, try again");
			System.out.print("Black Turn: ");
			move = sc.nextLine();
		    }
		    Board.move(move);
		    System.out.print("\n");
		    Board.printBoard();

		    if (Board.isCheck(false)) {
			System.out.println("Check");
			if (Board.isCheckMate(false)) {
			    System.out.println("Checkmate");
			    blackWon = true;
			}
		    }

		    whiteTurn = true;
		} else if (move.length() == 11 && move.contains("draw?") && move.indexOf("draw?") == 6) {
		    System.out.print("\n");
		    blackDraw = true;

		} else if (blackDraw = true && move.contains(draw)) {
		    System.out.print("\n");
		    System.out.print(draw);
		    break;
		}

		else if (move.length() == 6 && move.contains("resign")) {
		    whiteWon = true;

		}
	    }

	}
    }

}
