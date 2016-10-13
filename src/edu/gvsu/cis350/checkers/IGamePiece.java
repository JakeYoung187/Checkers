package edu.gvsu.cis350.checkers;

import java.lang.*;

public interface IGamePiece {
	/** Returns the player that owns this piece. */
	Player player();
	
	/** Returns color of piece. */
	String type();
	
	/** Validates movement. */
	boolean isValidMove(Move move, IGamePiece[][] board);
	
	
	
}
