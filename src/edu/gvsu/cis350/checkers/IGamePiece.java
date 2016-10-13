package edu.gvsu.cis350.checkers;

/***************************************
 * IGamePiece interface for game pieces.
 ***************************************/
public interface IGamePiece {
	
	/****************************************** 
	 * Returns the player that owns this piece.
	 * @return player of piece 
	 ******************************************/
	Player player();
	
	/****************************************** 
	 * Returns color of piece. 
	 * @return color
	 ******************************************/
	String type();
	
	/****************************************** 
	 * Validates movement.
	 * @param move current move
	 * @param board current board
	 * @return true of valid, false if not 
	 ******************************************/
	boolean isValidMove(Move move, IGamePiece[][] board);
	
	
	
}
