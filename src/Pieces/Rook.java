/**
 * @author Bola Henine
 *
 * @author Roshan Seth
 */

package Pieces;

import chess.Board;

/**
 *
 * Rook is the subclass that extends the superclass Piece. This subclass creates
 * the legal moves that the Rook can make within the squares of the board.
 */

public class Rook extends Piece {

    private boolean didMove = false;

    public Rook(String pieceName, String color) {
	super(pieceName, color);
	// TODO Auto-generated constructor stub
    }

    /**
     * @param move that is inputed by user
     * @return return true if Rook is making a legal move
     */

    @Override
    public boolean isLegalMove(String move) {
	move = move.replaceAll("\\s", "");
	int origLocRow = 8 - Character.getNumericValue(move.charAt(1));
	int origLocCol = Character.getNumericValue(move.charAt(0)) - 10;
	int newLocRow = 8 - Character.getNumericValue(move.charAt(3));
	int newLocCol = Character.getNumericValue(move.charAt(2)) - 10;

	if (Board.inBound(newLocRow, newLocCol) && Board.inBound(origLocRow, origLocCol)) {
	    if ((newLocRow == origLocRow) && ((newLocCol > origLocCol) || (newLocCol < origLocCol))) {
		if (newLocCol > origLocCol) {
		    for (int i = newLocCol - 1; i > origLocCol; i--) {
			if (!Board.isEmpty(newLocRow, i)) {
			    return false;
			}
		    }
		} else {
		    for (int i = origLocCol - 1; i > newLocCol; i--) {
			if (!Board.isEmpty(newLocRow, i)) {
			    return false;
			}
		    }
		}
		return true;
	    }
	    if ((newLocCol == origLocCol) && ((newLocRow > origLocRow) || (newLocRow < origLocRow))) {
		if (newLocRow > origLocRow) {
		    for (int i = newLocRow - 1; i > origLocRow; i--) {
			if (!Board.isEmpty(i, origLocCol)) {
			    return false;
			}
		    }
		} else {
		    for (int i = origLocRow - 1; i > newLocRow; i--) {
			if (!Board.isEmpty(i, newLocCol)) {
			    return false;
			}
		    }
		}
		didMove = true;
		return true;
	    }
	}

	return false;
    }

    /**
     * @return return true if the Rook moved from it's original location
     */

    public boolean didMove() {
	return didMove;
    }

}
