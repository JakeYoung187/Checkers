package edu.gvsu.cis350.checkers;

/***********************************************************************
 * GamePiece implements the IGamePiece interface to create board pieces.
 * 
 * @author Nate Benson, Kaye Suarez, Jake Young
 * @version 1.0 
 ***********************************************************************/
public abstract class GamePiece implements IGamePiece {

	/** owner of piece. */
	private Player owner;
	
	/*********************************************
	 * Set the owner of the piece as given player.
	 * @param player owner of piece.
	 *********************************************/
	public final void setPlayer(final Player player) {
		this.owner = player;
	}
	
	public Player player() {
		return owner;
	}

	//Determines whether it is a king
	// or a normal piece
	public abstract String type();

	//public abstract boolean isValidMove(GamePiece game);
	
}
