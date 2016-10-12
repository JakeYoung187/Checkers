package Checkers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class CheckerPanel extends JPanel {
	
	//add more icons for kings, also not sure if i actually need another class for just normal pieces
	//seems like bad coding
	
	//instance variables
	private JButton[][] board;
	private CheckerModel model;
	public Move currentMove;
//	private JButton pauseButton;
//	private JPanel rightSide;
	//public JMenuBar topMenu;

	
	//images for icons
	private Image redPieces;
	private Image grayPieces;
	private Image grayPieceResize;
	private Image redPieceResize;
	//Icons
	private ImageIcon rPieces;
	private ImageIcon gPieces;
	
	
	public CheckerPanel() {
		
		addIcons();
		model = new CheckerModel();
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(8, 8));
		add(center, BorderLayout.CENTER);
		board = new JButton[8][8];
		
		
		
//		rightSide = new JPanel();
//		rightSide.setLayout(new GridLayout(0, 1));
//		add(rightSide, BorderLayout.EAST);
//		pauseButton = new JButton("Pause");
//		pauseButton.setBackground(new Color(255, 0, 0));
//		pauseButton.setForeground(Color.BLACK);
//		pauseButton.setPreferredSize(new Dimension(50, 50));
//		Font f = new Font("Dialog", Font.PLAIN, 24);
//		pauseButton.setFont(f);
//		pauseButton.addMouseListener(listener);
//		rightSide.add(pauseButton);
		//topMenu = new JMenuBar();
		
		for(int r = 0; r < 8; r++) {
			for(int c = 0; c < 8; c++) {
				board[r][c] = new JButton("");
				board[r][c].addMouseListener(listener);
				board[r][c].setPreferredSize(new Dimension(80, 80));
				center.add(board[r][c]);
			}
		}
		displayBoard();
	}
	
	private void displayBoard() {
		
		for(int a = 0; a < 8; a++) {
			for(int b = 0; b < 8; b++) {
				if(a % 2 == b % 2) {
					board[a][b].setBackground(Color.RED);
				}
				else {
					board[a][b].setBackground(Color.BLACK);
				}
				if(model.pieceAt(a, b) != null) {
					if(model.pieceAt(a, b).type().equals("Pawn")) {
						if(model.pieceAt(a, b).player() == Player.GRAY) {
							board[a][b].setIcon(gPieces);
						}
						if(model.pieceAt(a, b).player() == Player.RED) {
							board[a][b].setIcon(rPieces);
						}
					}
				}
				else {
					board[a][b].setIcon(null);
				}
			}
		}
	}
	
	private void addIcons() {
		//load graphics
		
		try {
			//load images
			redPieces = ImageIO.read(getClass().getResource("/Resources/beer-cap-icon-67249.png"));
			grayPieces = ImageIO.read(getClass().getResource("/Resources/ff-bottle-cap.png"));
			//resize images
			redPieceResize = redPieces.getScaledInstance(105, 105, 105);
			grayPieceResize = grayPieces.getScaledInstance(120, 120, 120);
			//set icons
			rPieces = new ImageIcon(redPieceResize);
			gPieces = new ImageIcon(grayPieceResize);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void reset() {
		model = new CheckerModel();
	}
	
	MouseListener listener = new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent a) {
			  if(a.getButton() == MouseEvent.BUTTON3) {
				Object[] options = {"Resume", "Restart", "Quit"};
				int n = JOptionPane.showOptionDialog(null, "The Game is Paused.", "Checkers",
						JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, 
						options, options[0]);
				if(n == 0) {
					displayBoard();
				}
				else if(n == 1) {
					reset();
					displayBoard();
				}
				else if(n == 2) {
					System.exit(0);
				}
			}
			for(int r = 0; r < 8; r++) {
				for(int c = 0; c < 8; c++) {
					if(a.getButton() == MouseEvent.BUTTON1) {
						if(a.getSource() == board[r][c]) {
							if(model.pieceAt(r, c) != null) {
								if(model.pieceAt(r, c) != null) {
									if(model.pieceAt(r, c).player() == model.getCurrentPlayer()) {
										if(model.getCurrentPiece() == null) {
											model.setCurrentPiece(model.pieceAt(r, c));
											System.out.println(r + " " + c);
											currentMove.fromRow = r;
											currentMove.fromColumn = c;
										}
										else {
											if(model.pieceAt(r, c).player() == model.getCurrentPlayer()) {
												model.setCurrentPiece(model.pieceAt(r, c));
												currentMove.fromRow = r;
												currentMove.fromColumn = c;
											}
										}
									}
								}
							}
							else {
								System.out.println(r + " " + c);
								currentMove.toRow = r;
								currentMove.toColumn = c;
								model.move(currentMove);
								model.currentPiece = null;
								displayBoard();
								//System.out.println(model.pieceAt(currentMove.toRow, currentMove.toColumn).type());
							}
						}
//						if(e.getButton() == MouseEvent.BUTTON3) {
//							displayBoard();
//							if(e.getSource() == board[a][b]) {
//								if(model.getCurrentPiece() == null) {
//									if(model.pieceAt(a, b) != null) {
//										if(model.pieceAt(a, b).player()
//												== model.currentPlayer()) {
//											currentMove.fromRow = a;
//											currentMove.fromColumn = b;
//											highlight(a, b);
//											model.currentPiece = null;
					}
				}
			}
		}

		@Override
		public void mouseEntered(MouseEvent a) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent a) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent a) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent a) {
			// TODO Auto-generated method stub
			
		}
		
	};
	
}
