package Pieces;

public abstract class Piece {
	
	private String name;
	private boolean isBlack;
	
	
	public Piece(String pieceName, String color) {
		this.name = pieceName;
		isBlack = color.equals("black");
	}
	
	public String getName() {
		return name;
	}
	
	public Boolean isBlack() {
		return isBlack;
	}
	
	public abstract boolean isLegalMove(String move);
	
	public abstract boolean isCheck(String move);
	
	
	
	
	

}
