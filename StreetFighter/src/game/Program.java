package game;

import java.awt.image.BufferedImage;
import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JPanel;
import java.io.File;
import game.helpers.SceneHelper;
import game.guiComponents.FighterDialog;


public class Program{

	private JFrame frame;
	private static GamePanel gamePanel;
	
	private SceneHelper sceneHelper;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		JFrame gameWindow = new JFrame("StreetFighter");
		gamePanel = new GamePanel();
		
		gameWindow.setContentPane(gamePanel);
		gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameWindow.setResizable(false);
		gameWindow.pack();
		gameWindow.setVisible(true);
		
		
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//				
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	}

	/**
	 * Create the application.
	 */
	

	/**
	 * Initialize the contents of the frame.
	 */
	
	
}
