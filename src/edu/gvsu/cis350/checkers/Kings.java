package edu.gvsu.cis350.checkers;

/******************************************************
 * King class extends GamePiece for King functionality.
 * 
 * @author Nate Benson, Kaye Suarez, Jake Young
 * @version 1.0 
 ******************************************************/
public class Kings extends GamePiece {
	public Player owner;
	
	protected Kings(Player player) {
		this.owner = player;
	}
	
	public Player player() {
		return owner;
	}

	@Override
	public final String type() {
		return "King";
	}

	@Override
	public final boolean isValidMove(
			             final Move move, final IGamePiece[][] board) {
		
		if (Math.abs(move.fromRow - move.toRow) > 1) {
			return false;
		}
		
		if (Math.abs(move.fromColumn - move.toColumn) > 1) {
			return false;
		}
		
		if (move.fromRow == move.toRow || move.fromColumn == move.toColumn) {
			return false;
			
		} else {
			return true;
		}
	}
}
