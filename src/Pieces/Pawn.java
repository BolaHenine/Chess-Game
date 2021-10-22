/**
 * @author Bola Henine
 *
 * @author Roshan Seth
 */

package Pieces;

import main.Board;

/**
 *
 * Pawn is the subclass that extends the superclass Piece. This subclass creates
 * the legal moves that the Pawn can make within the squares of the board.
 */

public class Pawn extends Piece {
    private boolean isFirstMove = true;
    private boolean doubleMove = false;

    public Pawn(String pieceName, String color) {
	super(pieceName, color);
	// TODO Auto-generated constructor stub
    }

    /**
     * @return return true if the pawn made a double move at the start
     */

    public boolean isDoubleMove() {
	return doubleMove;
    }

    /**
     * @param move that is inputed by user
     * @return return true if pawn is making a legal move
     */

    @Override
    public boolean isLegalMove(String move) {
	move = move.replaceAll("\\s", "");
	int origLocRow = 8 - Character.getNumericValue(move.charAt(1));
	int origLocCol = Character.getNumericValue(move.charAt(0)) - 10;
	int newLocRow = 8 - Character.getNumericValue(move.charAt(3));
	int newLocCol = Character.getNumericValue(move.charAt(2)) - 10;

	if (enPassant(move) == true) {
	    return true;
	}

	if (Board.inBound(newLocRow, newLocCol) && Board.inBound(origLocRow, origLocCol)) {
	    if (!Board.isBlack(origLocRow, origLocCol)) {

		if (Board.isEmpty(newLocRow, newLocCol) && (newLocRow == origLocRow - 1 && newLocCol == origLocCol)) {
		    isFirstMove = false;

		    return true;
		}

		if (isFirstMove && Board.isEmpty(newLocRow, newLocCol)
			&& (newLocRow == origLocRow - 2 && newLocCol == origLocCol)) {
		    doubleMove = true;
		    isFirstMove = false;

		    return true;
		}

		if (((newLocRow == origLocRow - 1 && newLocCol == origLocCol + 1)
			|| (newLocRow == origLocRow - 1 && newLocCol == origLocCol - 1))
			&& !Board.isEmpty(newLocRow, newLocCol)) {
		    if ((Board.isBlack(newLocRow, newLocCol) && !Board.isBlack(origLocRow, origLocCol))
			    || (!Board.isBlack(newLocRow, newLocCol) && Board.isBlack(origLocRow, origLocCol))) {

			return true;
		    }
		}

	    } else {
		if (Board.isEmpty(newLocRow, newLocCol) && (newLocRow == origLocRow + 1 && newLocCol == origLocCol)) {
		    isFirstMove = false;

		    return true;
		}

		if (isFirstMove && Board.isEmpty(newLocRow, newLocCol)
			&& (newLocRow == origLocRow + 2 && newLocCol == origLocCol)) {
		    doubleMove = true;
		    isFirstMove = false;

		    return true;
		}

		if (((newLocRow == origLocRow + 1 && newLocCol == origLocCol + 1)
			|| (newLocRow == origLocRow + 1 && newLocCol == origLocCol - 1))
			&& !Board.isEmpty(newLocRow, newLocCol)) {
		    if ((Board.isBlack(newLocRow, newLocCol) && !Board.isBlack(origLocRow, origLocCol))
			    || (!Board.isBlack(newLocRow, newLocCol) && Board.isBlack(origLocRow, origLocCol))) {

			return true;
		    }
		}
	    }
	}

	return false;
    }

    /**
     * @param move that is inputed by user
     * @return return true if pawn is making an en passant move
     */

    public boolean enPassant(String move) {

	int origLocRow = 8 - Character.getNumericValue(move.charAt(1));
	int origLocCol = Character.getNumericValue(move.charAt(0)) - 10;
	int newLocRow = 8 - Character.getNumericValue(move.charAt(3));
	int newLocCol = Character.getNumericValue(move.charAt(2)) - 10;
	int prevMoveRow = Board.getPrevMove()[0];
	int prevMoveCol = Board.getPrevMove()[1];

	if (prevMoveCol != newLocCol && ((prevMoveRow != newLocRow + 1) || (prevMoveRow != newLocRow - 1))) {
	    return false;

	}

	if (!Board.isBlack(origLocRow, origLocCol) && origLocRow == 3 && newLocRow == origLocRow - 1
		&& (newLocCol == origLocCol - 1 || newLocCol == origLocCol + 1)) {

	    if (Board.isEmpty(newLocRow, newLocCol) && Board.getPieceName(origLocRow, origLocCol + 1) == "bp") {

		Pawn pawn = (Pawn) Board.getPiece(origLocRow, origLocCol + 1);

		if (pawn.isDoubleMove()) {

		    Board.setIndexNull(origLocRow, origLocCol + 1);
		    return true;
		}

	    } else if (Board.isEmpty(newLocRow, newLocCol) && Board.getPieceName(origLocRow, origLocCol - 1) == "bp") {

		Pawn pawn = (Pawn) Board.getPiece(origLocRow, origLocCol - 1);

		if (pawn.isDoubleMove()) {

		    Board.setIndexNull(origLocRow, origLocCol - 1);
		    return true;
		}

	    }

	} else if (Board.isBlack(origLocRow, origLocCol) && origLocRow == 4 && newLocRow == origLocRow + 1
		&& (newLocCol == origLocCol - 1 || newLocCol == origLocCol + 1)) {

	    if (Board.isEmpty(newLocRow, newLocCol) && Board.getPieceName(origLocRow, origLocCol + 1) == "wp") {

		Pawn pawn = (Pawn) Board.getPiece(origLocRow, origLocCol + 1);

		if (pawn.isDoubleMove()) {

		    Board.setIndexNull(origLocRow, origLocCol + 1);
		    return true;
		}

	    } else if (Board.isEmpty(newLocRow, newLocCol) && Board.getPieceName(origLocRow, origLocCol - 1) == "wp") {

		Pawn pawn = (Pawn) Board.getPiece(origLocRow, origLocCol - 1);

		if (pawn.isDoubleMove()) {

		    Board.setIndexNull(origLocRow, origLocCol - 1);
		    return true;
		}

	    }

	}
	return false;

    }

}
