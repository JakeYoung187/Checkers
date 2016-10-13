package edu.gvsu.cis350.checkers;

import javax.swing.JOptionPane;

public class CheckerModel implements ICheckerModel {

	private IGamePiece[][] board;
	public IGamePiece currentPiece;
	private Player player;
	private int redPieces = 12;
	private int grayPieces = 12;
	
	//add stuff
	public CheckerModel() {
		
		//create the board
		board = new IGamePiece[8][8];
		
		//sets who goes first
		player = Player.RED;
		
		//add gray pieces to board
		board[0][0] = new NormalPiece(Player.GRAY);
		board[0][2] = new NormalPiece(Player.GRAY);
		board[0][4] = new NormalPiece(Player.GRAY);
		board[0][6] = new NormalPiece(Player.GRAY);
		
		board[1][1] = new NormalPiece(Player.GRAY);
		board[1][3] = new NormalPiece(Player.GRAY);
		board[1][5] = new NormalPiece(Player.GRAY);
		board[1][7] = new NormalPiece(Player.GRAY);
		
		board[2][0] = new NormalPiece(Player.GRAY);
		board[2][2] = new NormalPiece(Player.GRAY);
		board[2][4] = new NormalPiece(Player.GRAY);
		board[2][6] = new NormalPiece(Player.GRAY);
		
		//add red pieces to board
		board[7][1] = new NormalPiece(Player.RED);
		board[7][3] = new NormalPiece(Player.RED);
		board[7][5] = new NormalPiece(Player.RED);
		board[7][7] = new NormalPiece(Player.RED);
		
		board[6][0] = new NormalPiece(Player.RED);
		board[6][2] = new NormalPiece(Player.RED);
		board[6][4] = new NormalPiece(Player.RED);
		board[6][6] = new NormalPiece(Player.RED);
		
		board[5][1] = new NormalPiece(Player.RED);
		board[5][3] = new NormalPiece(Player.RED);
		board[5][5] = new NormalPiece(Player.RED);
		board[5][7] = new NormalPiece(Player.RED);
		
	}
	
	@Override
	public boolean isComplete() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isValidMove(Move move) {
		if(pieceAt(move.fromRow, move.fromColumn).isValidMove(move, board)) {
			return true;
		}
		else {
			return false;
		}
	}

	public void move(Move move) {
		if(pieceAt(move.fromRow, move.fromColumn) != null) {
			//if(pieceAt(move.fromRow, move.fromColumn).isValidMove(move, board)) {
			if(isValidMove(move)) {
				System.out.println("2");
				if(pieceAt(move.toRow, move.toColumn) == null) {
					board[move.toRow][move.toColumn] = board[move.fromRow][move.fromColumn];
					board[move.fromRow][move.fromColumn] = null;
					player = player.next();
					System.out.println(player);
				}
			//}
			}
			else {
				JOptionPane.showMessageDialog(null, "That is not a valid move. Please try another.");
				return;
			}
				//save array of pieces to save board, timer, load, save, speed mode, board change size,
				//maybe main menu, mayeb profiles
		}
//		player = player.next();
		System.out.println(player);
	}

	@Override
	public boolean gameOver(Player winner) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Player getCurrentPlayer() {
		return player;
	}
	
	public void setCurrentPlayer(Player p) {
		this.player = p;
	}
	
	public IGamePiece pieceAt(int row, int column) {
		return board[row][column];
	}
	
	public IGamePiece getCurrentPiece() {
		return currentPiece;
	}
	
	public void setCurrentPiece(IGamePiece p) {
		this.currentPiece = p;
	}
	
}
