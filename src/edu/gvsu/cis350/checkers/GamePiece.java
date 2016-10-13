package edu.gvsu.cis350.checkers;

public abstract class GamePiece implements IGamePiece{

	private Player owner;
	
	public void GamePiece(Player player) {
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
