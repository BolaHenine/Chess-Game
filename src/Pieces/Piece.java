/**
 * @author Bola Henine
 *
 * @author Roshan Seth
 */

package Pieces;

public abstract class Piece {

    private String name;
    private boolean isBlack;

    public Piece(String pieceName, String color) {
	this.name = pieceName;
	isBlack = color.equals("black");
    }

    /**
     * @return return the piece name
     */

    public String getName() {
	return name;
    }

    /**
     * @return return the piece color
     */

    public Boolean isBlack() {
	return isBlack;
    }

    /**
     * @param move that is inputed by the user
     * @return return whether the move is legal or not
     */

    public abstract boolean isLegalMove(String move);

}
