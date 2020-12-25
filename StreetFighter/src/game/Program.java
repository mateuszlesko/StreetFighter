package game;

import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JProgressBar;
import javax.swing.JPanel;
import java.awt.Font;
import java.io.File;
import java.awt.Color;

public class Program {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Program window = new Program();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Program() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 722, 440);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPlayerName = new JLabel("Player:");
		lblPlayerName.setBounds(10, 11, 59, 14);
		frame.getContentPane().add(lblPlayerName);
		
		JLabel lblCPUName = new JLabel(":CPU");
		lblCPUName.setBounds(606, 11, 46, 14);
		frame.getContentPane().add(lblCPUName);
		
		JProgressBar playerHealth = new JProgressBar();
		playerHealth.setValue(100);
		playerHealth.setBounds(60, 58, 146, 14);
		frame.getContentPane().add(playerHealth);
		
		JProgressBar cpuHealth = new JProgressBar();
		cpuHealth.setValue(100);
		cpuHealth.setBounds(457, 58, 146, 14);
		frame.getContentPane().add(cpuHealth);
		
		JLabel lblTime = new JLabel("99");
		lblTime.setForeground(new Color(255, 215, 0));
		lblTime.setFont(new Font("BankGothic Md BT", Font.BOLD, 26));
		lblTime.setBounds(305, 46, 46, 26);
		frame.getContentPane().add(lblTime);
		
		JPanel scenePanel = new JPanel();
		//scenePanel.setBackground(new Color(100, 149, 237));
		scenePanel.setBounds(0, 94, 718, 307);
		
		ImageIcon backgroudScenePanel = new ImageIcon(new File("assets/graphics/arena/ryustage/ryustage.jpg").getAbsolutePath());
		JLabel backgroundScene = new JLabel(backgroudScenePanel);
		backgroundScene.setBounds(0,94,738,307);
		
		scenePanel.add(backgroundScene);
		frame.getContentPane().add(scenePanel);
		
		JLabel lblRound = new JLabel("Round:");
		lblRound.setFont(new Font("BankGothic Md BT", Font.BOLD, 16));
		lblRound.setBounds(295, 21, 77, 14);
		frame.getContentPane().add(lblRound);
		
		ImageIcon icon = new ImageIcon(new File("assets/graphics/ryu/sml_portrait__left.jpg").getAbsolutePath());
		JLabel fighterMiniature = new JLabel(icon);
		fighterMiniature.setBounds(100, 48, 96, 64);
		frame.getContentPane().add(fighterMiniature);
		
		
		JLabel opponentMiniature = new JLabel(icon);
		opponentMiniature.setBounds(628, 48, 46, 44);
		frame.getContentPane().add(opponentMiniature);
		frame.setVisible(true);
		
	}
}