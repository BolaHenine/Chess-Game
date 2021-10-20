package Pieces;

import main.Board;

public class Pawn extends Piece {
    private boolean isFirstMove = true;
    private boolean doubleMove = false;

    public Pawn(String pieceName, String color) {
	super(pieceName, color);
	// TODO Auto-generated constructor stub
    }

    public boolean isDoubleMove() {
	return doubleMove;
    }

    // checks if legal move
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

    public boolean enPassant(String move) {

	int origLocRow = 8 - Character.getNumericValue(move.charAt(1));
	int origLocCol = Character.getNumericValue(move.charAt(0)) - 10;
	int newLocRow = 8 - Character.getNumericValue(move.charAt(3));
	int newLocCol = Character.getNumericValue(move.charAt(2)) - 10;
	// Pawn pawn = (Pawn)Board.getPiece(newLocRow, newLocCol)
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

    @Override
    public boolean isCheck(String move) {
	// TODO Auto-generated method stub
	return false;
    }

}
