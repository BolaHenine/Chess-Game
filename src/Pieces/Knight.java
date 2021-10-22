/**
 * @author Bola Henine
 *
 * @author Roshan Seth
 */

package Pieces;

import main.Board;

/**
 *
 * Knight is the subclass that extends the superclass Piece. This subclass
 * creates the legal moves that the Knight can make within the squares of the
 * board.
 */
public class Knight extends Piece {

    /**
     * Default constructor that calls the superclass Piece's constructor
     * <p>
     *
     * @param pieceName the name of the piece in the form of first initial of color
     *                  and first initial of piece name
     * @param color     the color of the piece, either white or black
     */
    public Knight(String pieceName, String color) {
	super(pieceName, color);
    }

    /**
     * Boolean method that checks to see if the move the Knight makes is legal by
     * making sure that the moves are within the board and they follow the moves the
     * Knight can make. The Knight can move over any other piece.
     * <p>
     * The boolean method contains nested if else statements that specify all the
     * rules the Knight can make.
     * <p>
     * The Knight can move up or down one square and over two squares horizontally
     * OR up or down two squares and over one square horizontally.
     * <p>
     * If the move the Knight makes is not legal then the output after the move is
     * made would be a string that says illegal move, try again:
     *
     * @param move the move the Knight makes inputed by the user
     * @return <code>true</code> if the move the Knight makes is legal;
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

		if ((newLocRow == origLocRow - 1 && newLocCol == origLocCol + 2)
			|| (newLocRow == origLocRow + 1 && newLocCol == origLocCol + 2)) {

		    return true;
		}

		if ((newLocRow == origLocRow + 2 && newLocCol == origLocCol + 1)
			|| (newLocRow == origLocRow - 2 && newLocCol == origLocCol + 1)) {

		    return true;
		}

		if ((newLocRow == origLocRow + 2 && newLocCol == origLocCol - 1)
			|| (newLocRow == origLocRow - 2 && newLocCol == origLocCol - 1)) {

		    return true;
		}

		if ((newLocRow == origLocRow - 1 && newLocCol == origLocCol - 2)
			|| (newLocRow == origLocRow + 1 && newLocCol == origLocCol - 2)) {

		    return true;
		}

	    }

	    else {

		if ((newLocRow == origLocRow - 1 && newLocCol == origLocCol - 2)
			|| (newLocRow == origLocRow + 1 && newLocCol == origLocCol - 2)) {

		    return true;
		}

		if ((newLocRow == origLocRow + 2 && newLocCol == origLocCol + 1)
			|| (newLocRow == origLocRow - 2 && newLocCol == origLocCol + 1)) {

		    return true;
		}

		if ((newLocRow == origLocRow + 2 && newLocCol == origLocCol - 1)
			|| (newLocRow == origLocRow - 2 && newLocCol == origLocCol - 1)) {

		    return true;
		}

		if ((newLocRow == origLocRow - 1 && newLocCol == origLocCol + 2)
			|| (newLocRow == origLocRow + 1 && newLocCol == origLocCol + 2)) {

		    return true;
		}

	    }
	}

	return false;
    }

}
