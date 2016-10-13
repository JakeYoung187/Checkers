package edu.gvsu.cis350.checkers;

import javax.swing.JOptionPane;

/**********************************************************************
 * CheckerModel class implements ICheckerModel interface for game play.
 **********************************************************************/
public class CheckerModel implements ICheckerModel {

	/** board. */
	private IGamePiece[][] board;
	
	/** current piece. */
	public IGamePiece currentPiece;
	
	/** player value. */
	private Player player;
	
	/** board size. */
	private static final int BOARDSIZE = 8;
	
	/** total number of red pieces. */
	private static final int REDTOTAL = 12;
	
	/** total number of gray pieces. */
	private static final int GRAYTOTAL = 12;
	
	
	/************************************************ 
	 * Constructor adds red and gray pieces to board.
	 ************************************************/
	public CheckerModel() {
		
		//create the board
		board = new IGamePiece[BOARDSIZE][BOARDSIZE];
		
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
	public final boolean isComplete() {
		// TODO Auto-generated method stub
		return false;
	}

	/***********************************************
	 * isValidMove checks if provided move is valid.
	 * @param move current move
	 * @return true if valid, false if not
	 ***********************************************/
	public final boolean isValidMove(final Move move) {
		if (pieceAt(move.fromRow, move.fromColumn).isValidMove(move, board)) {
			return true;
			
		} else {
			return false;
		}
	}

	public final void move(final Move move) {
		if (pieceAt(move.fromRow, move.fromColumn) != null) {
			//if(pieceAt(move.fromRow, move.fromColumn).isValidMove(
			//											move, board)) {
			if (isValidMove(move)) {
				System.out.println("2");
				
				if (pieceAt(move.toRow, move.toColumn) == null) {
					
					board[move.toRow][move.toColumn] 
							= board[move.fromRow][move.fromColumn];
					
					board[move.fromRow][move.fromColumn] = null;
					player = player.next();
					System.out.println(player);
				}
			//}
			} else {
				JOptionPane.showMessageDialog(null, 
						"That is not a valid move. Please try another.");
				return;
			}
				//save array of pieces to save board, 
				//timer, load, save, speed mode, board change size,
				//maybe main menu, maybe profiles
		}
//		player = player.next();
		System.out.println(player);
	}

	@Override
	public final boolean gameOver(final Player winner) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public final Player getCurrentPlayer() {
		return player;
	}
	
	/*************************************
	 * setCurrentPlayer sets player value.
	 * @param p player
	 *************************************/
	public final void setCurrentPlayer(final Player p) {
		this.player = p;
	}
	
	/**********************************************
	 * pieceAt returns the piece at given position.
	 * @param row given row
	 * @param column given column
	 * @return piece value
	 **********************************************/
	public final IGamePiece pieceAt(final int row, final int column) {
		return board[row][column];
	}
	
	/********************************************
	 * getCurrentPiece returns the current piece.
	 * @return piece value
	 ********************************************/
	public final IGamePiece getCurrentPiece() {
		return currentPiece;
	}
	
	/****************************************************
	 * setCurrentPiece sets given piece as current piece.
	 * @param p new current piece
	 ****************************************************/
	public final void setCurrentPiece(final IGamePiece p) {
		this.currentPiece = p;
	}
	
}
