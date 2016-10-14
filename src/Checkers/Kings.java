package Checkers;

public class Kings extends GamePiece {
	public Player owner;
	
	protected Kings(Player player) { 
		this.owner = player;
		//sets player to piece
	}

	public Player player() {
		return owner;
	}
	
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
