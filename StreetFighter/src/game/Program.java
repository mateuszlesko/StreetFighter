package game;

import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Program{

	private JFrame frame;
	private static GamePanel gamePanel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		JFrame gameWindow = new JFrame("StreetFighter");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gameWindow.setContentPane(new GamePanel());
					gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					gameWindow.setResizable(false);
					gameWindow.pack();
					gameWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}	
}
