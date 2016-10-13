package edu.gvsu.cis350.checkers;

public class NormalPiece extends GamePiece {
	
	public Player owner;
	
	protected NormalPiece(Player player) {
		this.owner = player;
		//sets player to piece
	}

	public Player player() {
		return owner;
	}
	
	@Override
	public String type() {
		return "Pawn";
	}
	
	@Override
	public boolean isValidMove(Move move, IGamePiece[][] board) {
		//top left is 0-0, and GRAY
		if(board[move.fromRow][move.fromColumn].player() == Player.GRAY) {
			if(!(move.fromRow == move.toRow) && !(move.fromColumn == move.toColumn)) {
				if(move.toRow - move.fromRow == 1) {
					if(Math.abs(move.toColumn - move.fromColumn) == 1) {
						//normal move
						return true;
					}
					//checks for jump?
					//seperate the to locaions to prevent moving to the wrong one.
					//try for loop in notepad
					if(move.toRow == move.fromRow + 2 && (move.toColumn == move.fromColumn +- 2)) {
						if(board[move.fromRow + 1][move.fromColumn + 1] != null || 
								board[move.fromRow + 1][move.fromColumn - 1] != null) {
							if(board[move.fromRow+1][move.fromColumn+-1].player() != player()) {
								return true;
							}
						}
						
						
						//taking a piece
						return true;
					}
				}
				else if(Math.abs(move.toRow - move.fromRow) == 3){
					//taking pieces
					return true;
				}
			}
		}
		else if(board[move.fromRow][move.fromColumn].player() == Player.RED) {
			if(!(move.toRow == move.fromRow) && !(move.toColumn == move.fromColumn)) {
				if(move.fromRow - move.toRow == 1) {
					if(Math.abs(move.toColumn - move.fromColumn) == 1) {
						return true;
					}
					else if(Math.abs(move.toColumn - move.fromColumn) == 3) {
						//taking a piece
						return true;
					}
				}
				else if(Math.abs(move.toRow - move.fromRow) == 3) {
					//taking a piece
					return true;
				}
			}
		}
		
		return false;
		
		
		
		
		
		
		
		//set true cases, else false
//		if(board[move.fromRow][move.fromColumn].player() == Player.GRAY) {
//			//for gray players (Starting at the top)
//			if(move.fromRow == move.toRow || move.fromColumn == move.toColumn) {
//				return false;
//			}
//			if(Math.abs(move.fromColumn-move.toColumn) > 1) {
//				return false;
//			}
//			if(move.fromRow - move.toRow != 1) {
//				return false;
//			}
//			return true;
//		}
//		else {
			//for red players (Starting at the bottom)
//			if(move.fromRow == move.toRow || move.fromColumn == move.toColumn) {
//				return false;
//			}
//			if(Math.abs(move.fromColumn - move.toColumn) > 1) {
//				return false;
//			}
//			if(move.fromRow - move.toRow != -1) {
//				return false;
//			}
//			return true;
//		}
	}
}
