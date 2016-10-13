package edu.gvsu.cis350.checkers;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JMenuBar;

/*******************************************
 * Creates Checker GUI for user game play.
 *******************************************/
public class CheckerGUI { 
	
	/***************************************
	 * Main for creating checker GUI.
	 * @param args command arguments
	 ***************************************/
	private static void main(final String[] args) {
		
		JFrame frame = new JFrame("Checkers");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CheckerPanel panel = new CheckerPanel();
		frame.getContentPane().add(panel, BorderLayout.EAST);
		frame.setAlwaysOnTop(true);
		//frame.setJMenuBar(panel.topMenu);
		frame.pack();
		frame.setVisible(true);
		
	}
}
