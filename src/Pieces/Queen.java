package Pieces;

import main.Board;

public class Queen extends Piece {

	public Queen(String pieceName, String color) {
		super(pieceName, color);
		// TODO Auto-generated constructor stub
	}

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
				// (2,6) (4,8)
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
				// (2,6) (1,5) (0,4)
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
				// (4,4) (2,6) (3,5)
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
				// (2,6) (3,5) (4,4)
				if (((newLocCol == origLocCol - 1 && newLocRow == origLocRow + 1)
						|| (newLocCol == origLocCol - 2 && newLocRow == origLocRow + 2)
						|| (newLocCol == origLocCol - 3 && newLocRow == origLocRow + 3)
						|| (newLocCol == origLocCol - 4 && newLocRow == origLocRow + 4)
						|| (newLocCol == origLocCol - 5 && newLocRow == origLocRow + 5)
						|| (newLocCol == origLocCol - 6 && newLocRow == origLocRow + 6)
						|| (newLocCol == origLocCol - 7 && newLocRow == origLocRow + 7))) {
					System.out.print("true");
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
			} else {
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
				// (2,6) (4,8)
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
				// (2,6) (1,5) (0,4)
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
				// (4,4) (2,6) (3,5)
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
				// (2,6) (3,5) (4,4)
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
