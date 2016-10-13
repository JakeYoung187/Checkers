package edu.gvsu.cis350.checkers;

public class Kings extends GamePiece {

	@Override
	public String type() {
		return "King";
	}

	@Override
	public boolean isValidMove(Move move, IGamePiece[][] board) {
		if(Math.abs(move.fromRow-move.toRow) > 1) {
			return false;
		}
		if(Math.abs(move.fromColumn-move.toColumn) > 1) {
			return false;
		}
		if(move.fromRow == move.toRow || move.fromColumn == move.toColumn) {
			return false;
		}
		else {
			return true;
		}
	}


}
