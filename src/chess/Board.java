/**
 * @author Bola Henine
 *
 * @author Roshan Seth
 */

package chess;

import Pieces.Bishop;
import Pieces.King;
import Pieces.Knight;
import Pieces.Pawn;
import Pieces.Piece;
import Pieces.Queen;
import Pieces.Rook;

public class Board {

    public static Piece[][] board = new Piece[8][8];
    private static int[] prevMove = new int[2];

    /**
     * @param row the row that will be checked if it is in bound
     * @param col the column that will be checked if it is in bound
     * @return return whether the row and column are inside the board
     */

    public static boolean inBound(int row, int col) {

	if ((row >= 0 && row < 8) && (col >= 0 && col < 8)) {
	    return true;
	} else {
	    return false;
	}
    }

    /**
     * @param row the row of the piece
     * @param col the column of the piece
     * @return return the piece at the given row and column
     */

    public static Piece getPiece(int row, int col) {
	return board[row][col];
    }

    /**
     * @param row the row that will be set to null
     * @param col the column that will be set to null
     */

    public static void setIndexNull(int row, int col) {
	board[row][col] = null;
    }

    /**
     * @param row the row of the piece
     * @param col the column of the piece
     * @return return whether there is a piece at the given row and column
     */

    public static boolean isEmpty(int row, int col) {
	if (board[row][col] == null) {
	    return true;
	} else {
	    return false;
	}

    }

    /**
     *
     * initializes the board
     */

    public static void boardInit() {
	for (int i = 0; i < 8; i++) {
	    Piece pawn = new Pawn("bp", "black");
	    board[1][i] = pawn;
	}

	board[0][0] = new Rook("bR", "black");
	board[0][1] = new Knight("bN", "black");
	board[0][2] = new Bishop("bB", "black");
	board[0][3] = new Queen("bQ", "black");
	board[0][4] = new King("bK", "black");
	board[0][5] = new Bishop("bB", "black");
	board[0][6] = new Knight("bN", "black");
	board[0][7] = new Rook("bR", "black");

	for (int i = 0; i < 8; i++) {
	    Piece pawn = new Pawn("wp", "white");
	    board[6][i] = pawn;
	}

	board[7][0] = new Rook("wR", "white");
	board[7][1] = new Knight("wN", "white");
	board[7][2] = new Bishop("wB", "white");
	board[7][3] = new Queen("wQ", "white");
	board[7][4] = new King("wK", "white");
	board[7][5] = new Bishop("wB", "white");
	board[7][6] = new Knight("wN", "white");
	board[7][7] = new Rook("wR", "white");

    }

    /**
     * @param row the row of the piece
     * @param col the column of the piece
     * @return return the piece name at the given row and column
     */

    public static String getPieceName(int row, int col) {

	if (!((row >= 0 && row < 8) && (col >= 0 && col < 8))) {

	    return null;
	}

	if (board[row][col] != null) {

	    return board[row][col].getName();

	}

	return null;
    }

    /**
     * @param row the row of the piece
     * @param col the column of the piece
     * @return return whether piece at the given row and column is black
     */

    public static boolean isBlack(int row, int col) {

	if (board[row][col].isBlack()) {
	    return true;

	} else {
	    return false;
	}

    }

    /**
     * @param move      the move that is inputed by the user
     * @param whiteTurn true if it is white turn else false
     * @return return whether the move is valid or not
     */

    public static boolean isLegalMove(String move, boolean whiteTurn) {
	move = move.replaceAll("\\s", "");
	int origLocRow = 8 - Character.getNumericValue(move.charAt(1));
	int origLocCol = Character.getNumericValue(move.charAt(0)) - 10;
	int newLocRow = 8 - Character.getNumericValue(move.charAt(3));
	int newLocCol = Character.getNumericValue(move.charAt(2)) - 10;

	if (Board.isEmpty(origLocRow, origLocCol) || Board.isBlack(origLocRow, origLocCol) == whiteTurn) {

	    return false;
	} else if (!Board.isEmpty(newLocRow, newLocCol) && Board.isBlack(newLocRow, newLocCol) != whiteTurn) {
	    return false;
	} else if (!Board.inBound(newLocRow, newLocCol)) {
	    return false;
	} else {
	    return board[origLocRow][origLocCol].isLegalMove(move);
	}

    }

    /**
     * @param move the move that is inputed by the user
     * @return return the board after the move is made
     */

    public static Piece[][] move(String move) {
	move = move.replaceAll("\\s", "");
	int origLocRow = 8 - Character.getNumericValue(move.charAt(1));
	int origLocCol = Character.getNumericValue(move.charAt(0)) - 10;
	int newLocRow = 8 - Character.getNumericValue(move.charAt(3));
	int newLocCol = Character.getNumericValue(move.charAt(2)) - 10;
	boolean isFirstMove;
	if (Board.isEmpty(newLocRow, newLocCol) && (newLocRow == origLocRow - 2 && newLocCol == origLocCol)) {
	    isFirstMove = true;
	} else {
	    isFirstMove = false;
	}

	Board.prevMove(newLocRow, newLocCol);

	if (move.length() > 4) {

	    char promPiece = move.charAt(4);

	    if (Board.getPieceName(origLocRow, origLocCol) == "wp" && Board.isEmpty(newLocRow, newLocCol)
		    && (newLocRow == 0 && newLocCol == origLocCol)) {
		if (promPiece == 'N') {
		    board[newLocRow][newLocCol] = new Knight("wN", "white");
		    board[origLocRow][origLocCol] = null;
		    return board;
		}
		if (promPiece == 'B') {
		    board[newLocRow][newLocCol] = new Bishop("wB", "white");
		    board[origLocRow][origLocCol] = null;
		    return board;
		}
		if (promPiece == 'R') {
		    board[newLocRow][newLocCol] = new Rook("wR", "white");
		    board[origLocRow][origLocCol] = null;
		    return board;
		}
		if (promPiece == 'Q') {
		    board[newLocRow][newLocCol] = new Queen("wQ", "white");
		    board[origLocRow][origLocCol] = null;
		    return board;
		}

	    } else if (Board.getPieceName(origLocRow, origLocCol) == "bp" && Board.isEmpty(newLocRow, newLocCol)
		    && (newLocRow == 7 && origLocCol == newLocCol)) {

		if (promPiece == 'N') {

		    board[newLocRow][newLocCol] = new Knight("bN", "black");
		    board[origLocRow][origLocCol] = null;
		    return board;
		}
		if (promPiece == 'B') {
		    board[newLocRow][newLocCol] = new Bishop("bB", "black");
		    board[origLocRow][origLocCol] = null;
		    return board;
		}
		if (promPiece == 'R') {
		    board[newLocRow][newLocCol] = new Rook("bR", "black");
		    board[origLocRow][origLocCol] = null;
		    return board;
		}
		if (promPiece == 'Q') {
		    board[newLocRow][newLocCol] = new Queen("bQ", "black");
		    board[origLocRow][origLocCol] = null;
		    return board;
		}

	    }

	}
	if (Board.getPieceName(origLocRow, origLocCol) == "bp" && newLocRow == 4) {
	    if (isFirstMove == true && Board.getPieceName(newLocRow, origLocCol - 1) == "wp") {
		board[newLocRow][newLocCol] = new Queen("bQ", "black");
		board[origLocRow][origLocCol] = null;

		return board;
	    }

	}
	if (Board.getPieceName(origLocRow, origLocCol) == "bp" && Board.isEmpty(newLocRow, newLocCol)
		&& (newLocRow == 7 && origLocCol == newLocCol)) {
	    board[newLocRow][newLocCol] = new Queen("bQ", "black");
	    board[origLocRow][origLocCol] = null;

	    return board;
	}

	else if (Board.getPieceName(origLocRow, origLocCol) == "wp" && Board.isEmpty(newLocRow, newLocCol)
		&& (newLocRow == 0 && newLocCol == origLocCol)) {
	    board[newLocRow][newLocCol] = new Queen("wQ", "white");
	    board[origLocRow][origLocCol] = null;

	    return board;
	}
	board[newLocRow][newLocCol] = board[origLocRow][origLocCol];

	board[origLocRow][origLocCol] = null;

	return board;
    }

    /**
     * Prints the board
     */

    public static void printBoard() {
	int rowCount = 8;

	boolean switchPrint = true;

	for (int i = 0; i < 8; i++) {
	    for (int j = 0; j < 8; j++) {
		if (board[i][j] != null) {
		    System.out.print(board[i][j].getName());
		} else if (switchPrint) {
		    if (i % 2 != 0) {
			System.out.print("##");
		    } else {
			System.out.print("  ");
		    }
		} else {
		    if (i % 2 == 0) {
			System.out.print("##");
		    } else {
			System.out.print("  ");
		    }
		}
		System.out.print(" ");
		switchPrint = !switchPrint;
	    }
	    System.out.print(rowCount);
	    rowCount--;
	    System.out.println();
	}

	System.out.print(" a");

	for (char i = 'b'; i < 105; i++) {

	    System.out.print("  " + i);

	}

	System.out.println();
	System.out.println();
    }

    /**
     * @param whiteTurn true if it is white turn else false
     * @return return whether the board is at check or not
     */
    public static boolean isCheck(boolean whiteTurn) {
	int kingCol = 0;
	int kingRow = 0;
	String move = "";

	if (whiteTurn) {
	    for (int i = 0; i < 8; i++) {
		for (int j = 0; j < 8; j++) {
		    if (Board.getPieceName(i, j) != null) {
			if (Board.getPieceName(i, j).equals("bK")) {
			    kingRow = 7 - i;
			    kingCol = j;
			}
		    }

		}
	    }
	} else {
	    for (int i = 0; i < 8; i++) {
		for (int j = 0; j < 8; j++) {
		    if (Board.getPieceName(i, j) != null) {
			if (Board.getPieceName(i, j).equals("wK")) {
			    kingRow = 7 - i;
			    kingCol = j;
			}
		    }

		}
	    }
	}

	for (int i = 0; i < 8; i++) {
	    for (int j = 0; j < 8; j++) {

		if (Board.getPieceName(i, j) != null && Board.isBlack(i, j) != whiteTurn
			&& Board.getPieceName(i, j).charAt(1) != 'K') {

		    move += ((char) (j + 97)) + "" + (8 - i) + " " + ((char) (kingCol + 97)) + "" + (kingRow + 1);
		    if (board[i][j].isLegalMove(move)) {

			move = "";
			return true;

		    } else {
			move = "";
		    }
		}
		move = "";
	    }
	}
	return false;
    }

    /**
     * @param whiteTurn true if it is white turn else false
     * @return return whether the board is at CheckMate or not
     */

    public static boolean isCheckMate(boolean whiteTurn) {

	int kingCol = 0;
	int kingRow = 0;
	int tempCol = 0;
	int tempRow = 0;
	Piece temp;

	if (whiteTurn) {
	    for (int i = 0; i < 8; i++) {
		for (int j = 0; j < 8; j++) {
		    if (Board.getPieceName(i, j) != null) {
			if (Board.getPieceName(i, j).equals("bK")) {
			    kingRow = 7 - i;
			    kingCol = j;
			}
		    }

		}
	    }
	} else {
	    for (int i = 0; i < 8; i++) {
		for (int j = 0; j < 8; j++) {
		    if (Board.getPieceName(i, j) != null) {
			if (Board.getPieceName(i, j).equals("wK")) {
			    kingRow = 7 - i;
			    kingCol = j;
			}
		    }

		}
	    }
	}

	if (!Board.isCheck(whiteTurn)) {
	    return false;
	}
	if (!Board.isCheck(whiteTurn)) {
	    return false;
	}

	for (int i = 0; i < 4; i++) {

	    String move = "";
	    String moveBack = "";
	    if (i == 0) {

		tempCol = kingCol + 1;
		tempRow = kingRow;
		move = ((char) (kingCol + 97)) + "" + (kingRow + 1) + " " + ((char) (tempCol + 97)) + ""
			+ (tempRow + 1);
		moveBack = ((char) (tempCol + 97)) + "" + (tempRow + 1) + " " + ((char) (kingCol + 97)) + ""
			+ (kingRow + 1);
		int origLocRow = 8 - Character.getNumericValue(moveBack.charAt(1));
		int origLocCol = Character.getNumericValue(moveBack.charAt(0)) - 10;

		if (Board.inBound(tempRow, tempCol)) {

		    if (Board.isLegalMove(move, !whiteTurn)) {
			temp = board[origLocRow][origLocCol];
			Board.move(move);
			if (!Board.isCheck(whiteTurn)) {
			    Board.move(moveBack);
			    board[tempRow][tempCol] = temp;
			    return false;
			}
			Board.move(moveBack);
			board[tempRow][tempCol] = temp;
		    }
		}

	    }

	    else if (i == 1) {

		tempCol = kingCol - 1;
		tempRow = kingRow;

		move = ((char) (kingCol + 97)) + "" + (kingRow + 1) + " " + ((char) (tempCol + 97)) + ""
			+ (tempRow + 1);
		moveBack = ((char) (tempCol + 97)) + "" + (tempRow + 1) + " " + ((char) (kingCol + 97)) + ""
			+ (kingRow + 1);
		int origLocRow = 8 - Character.getNumericValue(moveBack.charAt(1));
		int origLocCol = Character.getNumericValue(moveBack.charAt(0)) - 10;
		if (Board.inBound(tempRow, tempCol)) {

		    if (Board.isLegalMove(move, !whiteTurn)) {
			temp = board[origLocRow][origLocCol];
			Board.move(move);

			if (!Board.isCheck(whiteTurn)) {
			    Board.move(moveBack);
			    board[tempRow][tempCol] = temp;
			    return false;
			}
			Board.move(moveBack);
			board[tempRow][tempCol] = temp;
		    }
		}

	    } else if (i == 2) {

		tempCol = kingCol;
		tempRow = kingRow + 1;
		move = ((char) (kingCol + 97)) + "" + (kingRow + 1) + " " + ((char) (tempCol + 97)) + ""
			+ (tempRow + 1);
		moveBack = ((char) (tempCol + 97)) + "" + (tempRow + 1) + " " + ((char) (kingCol + 97)) + ""
			+ (kingRow + 1);

		int origLocRow = 8 - Character.getNumericValue(moveBack.charAt(1));
		int origLocCol = Character.getNumericValue(moveBack.charAt(0)) - 10;

		if (Board.inBound(tempRow, tempCol)) {

		    if (Board.isLegalMove(move, !whiteTurn)) {
			temp = board[origLocRow][origLocCol];

			Board.move(move);

			if (!Board.isCheck(whiteTurn)) {

			    Board.move(moveBack);
			    board[tempRow][tempCol] = temp;
			    return false;
			}
			Board.move(moveBack);
			board[tempRow][tempCol] = temp;
		    }
		}

	    } else if (i == 3) {
		tempCol = kingCol;
		tempRow = kingRow - 1;
		move = ((char) (kingCol + 97)) + "" + (kingRow + 1) + " " + ((char) (tempCol + 97)) + ""
			+ (tempRow + 1);
		moveBack = ((char) (tempCol + 97)) + "" + (tempRow + 1) + " " + ((char) (kingCol + 97)) + ""
			+ (kingRow + 1);
		int origLocRow = 8 - Character.getNumericValue(moveBack.charAt(1));
		int origLocCol = Character.getNumericValue(moveBack.charAt(0)) - 10;
		if (Board.inBound(tempRow, tempCol)) {
		    if (Board.isLegalMove(move, !whiteTurn)) {
			temp = board[origLocRow][origLocCol];
			Board.move(move);
			if (!Board.isCheck(whiteTurn)) {
			    Board.move(moveBack);
			    board[tempRow][tempCol] = temp;
			    return false;
			}
			Board.move(moveBack);
			board[tempRow][tempCol] = temp;
		    }
		}

	    }

	}

	return true;
    }

    /**
     * @param row the row of the last move that was made
     * @param col the column of the last move that was made
     */

    public static void prevMove(int row, int col) {
	prevMove[0] = row;
	prevMove[1] = col;

    }

    /**
     * @return return the previous move that was made
     */

    public static int[] getPrevMove() {
	return prevMove;
    }

}
