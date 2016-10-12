package Checkers;

import java.lang.*;

public interface IGamePiece {
	/**
	 * returns the player that owns this piece
	 * 
	 */
	Player player();
	
	/**
	 * Returns what color the piece is
	 * 
	 */
	String type();
	
	/**
	 * determines moves that can be made
	 */
	boolean isValidMove(Move move, IGamePiece[][] board);
	
	
	
}
