/**
 * @author Bola Henine
 *
 * @author Roshan Seth
 */

package Pieces;

import main.Board;

/**
 * 
 * Queen is the subclass that extends the superclass Piece. This subclass
 * creates the legal moves that the Queen can make within the squares of the
 * board.
 * 
 * @author Roshan Seth
 * @author Bola Henine
 */
public class Queen extends Piece {

    /**
     * Default constructor that calls the superclass Piece's constructor
     * <p>
     * 
     * @param pieceName the name of the piece in the form of first initial of color
     *                  and first initial of piece name
     * @param color     the color of the piece, either white or black
     */
    public Queen(String pieceName, String color) {
	super(pieceName, color);

    }

    /**
     * Boolean method that checks to see if the move the Queen makes is legal by
     * making sure that the moves are within the board and they follow the moves and
     * stipulations the Queen can make such as the Queen cannot move over another
     * piece.
     * <p>
     * The boolean method contains nested if else statements that specify all the
     * rules the Bishop can make.
     * <p>
     * The Queen can move horizontal, vertical, or diagonally in any direction as
     * many squares as possible within the board.
     * <p>
     * If the move the Queen makes is not legal then the output after the move is
     * made would be a string that says illegal move, try again:
     * 
     * @param move the move the Queen makes inputed by the user
     * @return <code>true</code> if the move the Queen makes is legal;
     *         <code>false</code> if the move is not legal
     */
    @Override
    public boolean isLegalMove(String move) {

	move = move.replaceAll("\\s", "");

	int origLocRow = 8 - Character.getNumericValue(move.charAt(1));
	int origLocCol = Character.getNumericValue(move.charAt(0)) - 10;
	int newLocRow = 8 - Character.getNumericValue(move.charAt(3));
	int newLocCol = Character.getNumericValue(move.charAt(2)) - 10;

	if (Board.inBound(newLocRow, newLocCol) && Board.inBound(origLocRow, origLocCol)) {

	    if (!Board.isBlack(origLocRow, origLocCol)) {

		if ((newLocRow == origLocRow && ((newLocCol == origLocCol + 1) || (newLocCol == origLocCol + 2)
			|| (newLocCol == origLocCol + 3) || (newLocCol == origLocCol + 4)
			|| (newLocCol == origLocCol + 5) || (newLocCol == origLocCol + 6)
			|| (newLocCol == origLocCol + 7)))) {

		    if (Math.abs(origLocCol - newLocCol) > 1) {
			for (int i = newLocCol - 1; i > origLocCol; i--) {
			    if (Board.isEmpty(newLocRow, i)) {
				return true;
			    }
			}
		    } else {
			return true;
		    }
		}

		if ((newLocRow == origLocRow && ((newLocCol == origLocCol - 1) || (newLocCol == origLocCol - 2)
			|| (newLocCol == origLocCol - 3) || (newLocCol == origLocCol - 4)
			|| (newLocCol == origLocCol - 5) || (newLocCol == origLocCol - 6)
			|| (newLocCol == origLocCol - 7)))) {
		    if (Math.abs(origLocCol - newLocCol) > 1) {
			for (int i = newLocCol + 1; i < origLocCol; i++) {
			    if (Board.isEmpty(newLocRow, i)) {
				return true;
			    }
			}
		    } else {
			return true;
		    }
		}

		if ((newLocCol == origLocCol && ((newLocRow == origLocRow + 1) || (newLocRow == origLocRow + 2)
			|| (newLocRow == origLocRow + 3) || (newLocRow == origLocRow + 4)
			|| (newLocRow == origLocRow + 5) || (newLocRow == origLocRow + 6)
			|| (newLocRow == origLocRow + 7)))) {

		    if (Math.abs(origLocRow - newLocRow) > 1) {
			for (int i = newLocRow - 1; i > origLocRow; i--) {
			    if (Board.isEmpty(i, newLocCol)) {
				return true;
			    }
			}
		    } else {
			return true;
		    }
		}

		if ((newLocCol == origLocCol && ((newLocRow == origLocRow - 1) || (newLocRow == origLocRow - 2)
			|| (newLocRow == origLocRow - 3) || (newLocRow == origLocRow - 4)
			|| (newLocRow == origLocRow - 5) || (newLocRow == origLocRow - 6)
			|| (newLocRow == origLocRow - 7)))) {

		    if (Math.abs(origLocRow - newLocRow) > 1) {
			for (int i = newLocRow + 1; i < origLocRow; i++) {
			    if (Board.isEmpty(i, newLocCol)) {
				return true;
			    }

			}
		    } else {
			return true;
		    }
		}

		if (((newLocCol == origLocCol + 1 && newLocRow == origLocRow + 1)
			|| (newLocCol == origLocCol + 2 && newLocRow == origLocRow + 2)
			|| (newLocCol == origLocCol + 3 && newLocRow == origLocRow + 3)
			|| (newLocCol == origLocCol + 4 && newLocRow == origLocRow + 4)
			|| (newLocCol == origLocCol + 5 && newLocRow == origLocRow + 5)
			|| (newLocCol == origLocCol + 6 && newLocRow == origLocRow + 6)
			|| (newLocCol == origLocCol + 7 && newLocRow == origLocRow + 7))) {

		    if (Math.abs(origLocRow - newLocRow) > 1 && Math.abs(origLocCol - newLocCol) > 1) {
			for (int i = newLocRow - 1, j = newLocCol - 1; i > origLocRow && j > origLocCol; i--, j--) {
			    if (Board.isEmpty(i, j)) {
				return true;
			    }
			}
		    } else {
			return true;
		    }
		}

		if (((newLocCol == origLocCol - 1 && newLocRow == origLocRow - 1)
			|| (newLocCol == origLocCol - 2 && newLocRow == origLocRow - 2)
			|| (newLocCol == origLocCol - 3 && newLocRow == origLocRow - 3)
			|| (newLocCol == origLocCol - 4 && newLocRow == origLocRow - 4)
			|| (newLocCol == origLocCol - 5 && newLocRow == origLocRow - 5)
			|| (newLocCol == origLocCol - 6 && newLocRow == origLocRow - 6)
			|| (newLocCol == origLocCol - 7 && newLocRow == origLocRow - 7))) {

		    if (Math.abs(origLocRow - newLocRow) > 1 && Math.abs(origLocCol - newLocCol) > 1) {
			for (int i = newLocRow + 1, j = newLocCol + 1; i < origLocRow && j < origLocCol; i++, j++) {
			    if (Board.isEmpty(i, j)) {
				return true;
			    }
			}
		    } else {
			return true;
		    }
		}

		if (((newLocCol == origLocCol + 1 && newLocRow == origLocRow - 1)
			|| (newLocCol == origLocCol + 2 && newLocRow == origLocRow - 2)
			|| (newLocCol == origLocCol + 3 && newLocRow == origLocRow - 3)
			|| (newLocCol == origLocCol + 4 && newLocRow == origLocRow - 4)
			|| (newLocCol == origLocCol + 5 && newLocRow == origLocRow - 5)
			|| (newLocCol == origLocCol + 6 && newLocRow == origLocRow - 6)
			|| (newLocCol == origLocCol + 7 && newLocRow == origLocRow - 7))) {

		    if (Math.abs(origLocRow - newLocRow) > 1 && Math.abs(origLocCol - newLocCol) > 1) {
			for (int i = newLocRow + 1, j = newLocCol - 1; i < origLocRow && j > origLocCol; i++, j--) {
			    if (Board.isEmpty(i, j)) {
				return true;
			    }
			}
		    } else {
			return true;
		    }
		}

		if (((newLocCol == origLocCol - 1 && newLocRow == origLocRow + 1)
			|| (newLocCol == origLocCol - 2 && newLocRow == origLocRow + 2)
			|| (newLocCol == origLocCol - 3 && newLocRow == origLocRow + 3)
			|| (newLocCol == origLocCol - 4 && newLocRow == origLocRow + 4)
			|| (newLocCol == origLocCol - 5 && newLocRow == origLocRow + 5)
			|| (newLocCol == origLocCol - 6 && newLocRow == origLocRow + 6)
			|| (newLocCol == origLocCol - 7 && newLocRow == origLocRow + 7))) {

		    if (Math.abs(origLocRow - newLocRow) > 1 && Math.abs(origLocCol - newLocCol) > 1) {
			for (int i = newLocRow - 1, j = newLocCol + 1; i > origLocRow && j < origLocCol; i--, j++) {
			    if (Board.isEmpty(i, j)) {
				return true;
			    }
			}
		    } else {
			return true;
		    }
		}
	    }

	    else {

		if ((newLocRow == origLocRow && ((newLocCol == origLocCol + 1) || (newLocCol == origLocCol + 2)
			|| (newLocCol == origLocCol + 3) || (newLocCol == origLocCol + 4)
			|| (newLocCol == origLocCol + 5) || (newLocCol == origLocCol + 6)
			|| (newLocCol == origLocCol + 7)))) {

		    if (Math.abs(origLocCol - newLocCol) > 1) {
			for (int i = newLocCol - 1; i > origLocCol; i--) {
			    if (Board.isEmpty(newLocRow, i)) {
				return true;
			    }
			}
		    } else {
			return true;
		    }
		}

		if ((newLocRow == origLocRow && ((newLocCol == origLocCol - 1) || (newLocCol == origLocCol - 2)
			|| (newLocCol == origLocCol - 3) || (newLocCol == origLocCol - 4)
			|| (newLocCol == origLocCol - 5) || (newLocCol == origLocCol - 6)
			|| (newLocCol == origLocCol - 7)))) {

		    if (Math.abs(origLocCol - newLocCol) > 1) {
			for (int i = newLocCol + 1; i < origLocCol; i++) {
			    if (Board.isEmpty(newLocRow, i)) {
				return true;
			    }
			}
		    } else {
			return true;
		    }
		}

		if ((newLocCol == origLocCol && ((newLocRow == origLocRow + 1) || (newLocRow == origLocRow + 2)
			|| (newLocRow == origLocRow + 3) || (newLocRow == origLocRow + 4)
			|| (newLocRow == origLocRow + 5) || (newLocRow == origLocRow + 6)
			|| (newLocRow == origLocRow + 7)))) {

		    if (Math.abs(origLocRow - newLocRow) > 1) {
			for (int i = newLocRow - 1; i > origLocRow; i--) {
			    if (Board.isEmpty(i, newLocCol)) {
				return true;
			    }
			}
		    } else {
			return true;
		    }
		}

		if ((newLocCol == origLocCol && ((newLocRow == origLocRow - 1) || (newLocRow == origLocRow - 2)
			|| (newLocRow == origLocRow - 3) || (newLocRow == origLocRow - 4)
			|| (newLocRow == origLocRow - 5) || (newLocRow == origLocRow - 6)
			|| (newLocRow == origLocRow - 7)))) {

		    if (Math.abs(origLocRow - newLocRow) > 1) {
			for (int i = newLocRow + 1; i < origLocRow; i++) {
			    if (Board.isEmpty(i, newLocCol)) {
				return true;
			    }
			}
		    } else {
			return true;
		    }
		}

		if (((newLocCol == origLocCol + 1 && newLocRow == origLocRow + 1)
			|| (newLocCol == origLocCol + 2 && newLocRow == origLocRow + 2)
			|| (newLocCol == origLocCol + 3 && newLocRow == origLocRow + 3)
			|| (newLocCol == origLocCol + 4 && newLocRow == origLocRow + 4)
			|| (newLocCol == origLocCol + 5 && newLocRow == origLocRow + 5)
			|| (newLocCol == origLocCol + 6 && newLocRow == origLocRow + 6)
			|| (newLocCol == origLocCol + 7 && newLocRow == origLocRow + 7))) {

		    if (Math.abs(origLocRow - newLocRow) > 1 && Math.abs(origLocCol - newLocCol) > 1) {
			for (int i = newLocRow - 1, j = newLocCol - 1; i > origLocRow && j > origLocCol; i--, j--) {
			    if (Board.isEmpty(i, j)) {
				return true;
			    }
			}
		    } else {
			return true;
		    }
		}

		if (((newLocCol == origLocCol - 1 && newLocRow == origLocRow - 1)
			|| (newLocCol == origLocCol - 2 && newLocRow == origLocRow - 2)
			|| (newLocCol == origLocCol - 3 && newLocRow == origLocRow - 3)
			|| (newLocCol == origLocCol - 4 && newLocRow == origLocRow - 4)
			|| (newLocCol == origLocCol - 5 && newLocRow == origLocRow - 5)
			|| (newLocCol == origLocCol - 6 && newLocRow == origLocRow - 6)
			|| (newLocCol == origLocCol - 7 && newLocRow == origLocRow - 7))) {

		    if (Math.abs(origLocRow - newLocRow) > 1 && Math.abs(origLocCol - newLocCol) > 1) {
			for (int i = newLocRow + 1, j = newLocCol + 1; i < origLocRow && j < origLocCol; i++, j++) {
			    if (Board.isEmpty(i, j)) {
				return true;
			    }
			}
		    } else {
			return true;
		    }
		}

		if (((newLocCol == origLocCol + 1 && newLocRow == origLocRow - 1)
			|| (newLocCol == origLocCol + 2 && newLocRow == origLocRow - 2)
			|| (newLocCol == origLocCol + 3 && newLocRow == origLocRow - 3)
			|| (newLocCol == origLocCol + 4 && newLocRow == origLocRow - 4)
			|| (newLocCol == origLocCol + 5 && newLocRow == origLocRow - 5)
			|| (newLocCol == origLocCol + 6 && newLocRow == origLocRow - 6)
			|| (newLocCol == origLocCol + 7 && newLocRow == origLocRow - 7))) {

		    if (Math.abs(origLocRow - newLocRow) > 1 && Math.abs(origLocCol - newLocCol) > 1) {
			for (int i = newLocRow + 1, j = newLocCol - 1; i < origLocRow && j > origLocCol; i++, j--) {
			    if (Board.isEmpty(i, j)) {
				return true;
			    }
			}
		    } else {
			return true;
		    }
		}

		if (((newLocCol == origLocCol - 1 && newLocRow == origLocRow + 1)
			|| (newLocCol == origLocCol - 2 && newLocRow == origLocRow + 2)
			|| (newLocCol == origLocCol - 3 && newLocRow == origLocRow + 3)
			|| (newLocCol == origLocCol - 4 && newLocRow == origLocRow + 4)
			|| (newLocCol == origLocCol - 5 && newLocRow == origLocRow + 5)
			|| (newLocCol == origLocCol - 6 && newLocRow == origLocRow + 6)
			|| (newLocCol == origLocCol - 7 && newLocRow == origLocRow + 7))) {

		    if (Math.abs(origLocRow - newLocRow) > 1 && Math.abs(origLocCol - newLocCol) > 1) {
			for (int i = newLocRow - 1, j = newLocCol + 1; i > origLocRow && j < origLocCol; i--, j++) {
			    if (Board.isEmpty(i, j)) {
				return true;
			    }
			}
		    } else {
			return true;
		    }
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
