/**
 * @author Bola Henine
 *
 * @author Roshan Seth
 */

package Pieces;

import main.Board;

public class King extends Piece {

    private boolean didMove = false;

    public King(String pieceName, String color) {
	super(pieceName, color);
	// TODO Auto-generated constructor stub
    }

    /**
     * @param move that is inputed by user
     * @return return true if King is making a legal move
     */

    @Override
    public boolean isLegalMove(String move) {
	move = move.replaceAll("\\s", "");
	int origLocRow = 8 - Character.getNumericValue(move.charAt(1));
	int origLocCol = Character.getNumericValue(move.charAt(0)) - 10;
	int newLocRow = 8 - Character.getNumericValue(move.charAt(3));
	int newLocCol = Character.getNumericValue(move.charAt(2)) - 10;

	if (isCastle(move)) {
	    return true;
	}

	if (Board.inBound(newLocRow, newLocCol) && Board.inBound(origLocRow, origLocCol)) {
	    if ((newLocRow == origLocRow) && ((newLocCol == origLocCol + 1) || (newLocCol == origLocCol - 1))) {
		didMove = true;
		return true;
	    }
	    if (((newLocCol == origLocCol) && ((newLocRow == origLocRow - 1) || (newLocRow == origLocRow + 1)))) {
		didMove = true;
		return true;
	    }

	    if (((newLocCol == origLocCol + 1) || (newLocCol == origLocCol - 1))
		    && ((newLocRow == origLocRow + 1) || (newLocRow == origLocRow - 1))) {
		didMove = true;
		return true;
	    }

	}

	return false;
    }

    /**
     *
     * @return return true if King moved from it's original location
     */

    public boolean didMove() {
	return didMove;
    }

    /**
     * @param move that is inputed by user
     * @return return true if King is making a castling move
     */
    public boolean isCastle(String move) {
	int origLocRow = 8 - Character.getNumericValue(move.charAt(1));
	int origLocCol = Character.getNumericValue(move.charAt(0)) - 10;
	int newLocRow = 8 - Character.getNumericValue(move.charAt(3));
	int newLocCol = Character.getNumericValue(move.charAt(2)) - 10;
	String kingOriMove;
	String kingNewMove;
	String rookOrigMove;
	String rookNewMove;
	boolean whiteTurn = !Board.isBlack(origLocRow, origLocCol);

	if (whiteTurn) {
	    if (!Board.isCheck(!whiteTurn)) {
		if (newLocRow == origLocRow) {
		    if (newLocCol == origLocCol + 2 && Board.isEmpty(7, 6) && Board.isEmpty(7, 5)
			    && Board.getPieceName(7, 7).equals("wR")) {
			Rook rook = (Rook) Board.getPiece(7, 7);
			if (!didMove() && !rook.didMove()) {
			    rookNewMove = "h1 f1";
			    kingOriMove = "g1 e1";
			    kingNewMove = "e1 g1";
			    rookOrigMove = "f1 h1";
			    Board.move(rookNewMove);
			    Board.move(kingNewMove);

			    if (!Board.isCheck(!whiteTurn)) {
				Board.move(kingOriMove);
				return true;
			    } else {
				Board.move(kingOriMove);
				Board.move(rookOrigMove);
				return false;
			    }
			}
		    } else if (newLocCol == origLocCol - 2 && Board.isEmpty(7, 1) && Board.isEmpty(7, 2)
			    && Board.isEmpty(7, 3) && Board.getPieceName(7, 0).equals("wR")) {
			Rook rook = (Rook) Board.getPiece(7, 0);
			if (!didMove() && !rook.didMove()) {
			    rookNewMove = "a1 d1";
			    kingOriMove = "c1 e1";
			    kingNewMove = "e1 c1";
			    rookOrigMove = "d1 a1";
			    Board.move(rookNewMove);
			    Board.move(kingNewMove);

			    if (!Board.isCheck(!whiteTurn)) {
				Board.move(kingOriMove);
				return true;
			    } else {
				Board.move(kingOriMove);
				Board.move(rookOrigMove);
				return false;
			    }
			}
		    }
		}
	    }
	} else {
	    if (!Board.isCheck(whiteTurn)) {
		if (newLocRow == origLocRow) {
		    if (newLocCol == origLocCol + 2 && Board.isEmpty(0, 6) && Board.isEmpty(0, 5)
			    && Board.getPieceName(0, 7).equals("bR")) {
			Rook rook = (Rook) Board.getPiece(0, 7);
			if (!didMove() && !rook.didMove()) {
			    rookNewMove = "h8 f8";
			    kingOriMove = "g8 e8";
			    kingNewMove = "e8 g8";
			    rookOrigMove = "f8 h8";
			    Board.move(rookNewMove);
			    Board.move(kingNewMove);

			    if (!Board.isCheck(!whiteTurn)) {
				Board.move(kingOriMove);
				return true;
			    } else {
				Board.move(kingOriMove);
				Board.move(rookOrigMove);
				return false;
			    }
			}
		    } else if (newLocCol == origLocCol - 2 && Board.isEmpty(0, 1) && Board.isEmpty(0, 2)
			    && Board.isEmpty(0, 3) && Board.getPieceName(0, 0).equals("bR")) {
			Rook rook = (Rook) Board.getPiece(0, 0);

			if (!didMove() && !rook.didMove()) {
			    rookNewMove = "a8 d8";
			    kingOriMove = "c8 e8";
			    kingNewMove = "e8 c8";
			    rookOrigMove = "d8 a8";
			    Board.move(rookNewMove);
			    Board.move(kingNewMove);

			    if (!Board.isCheck(!whiteTurn)) {
				Board.move(kingOriMove);
				return true;
			    } else {
				Board.move(kingOriMove);
				Board.move(rookOrigMove);
				return false;
			    }
			}
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
