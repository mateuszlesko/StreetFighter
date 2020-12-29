package game.guiComponents;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class FighterDialog extends JPanel {

	/**
	 * Create the panel.
	 */
	public FighterDialog() {
		this.setLayout(null);
		
		JLabel lblPlayerPortrait = new JLabel("New label");
		lblPlayerPortrait.setBounds(10, 36, 89, 99);
		add(lblPlayerPortrait);
		
		JPanel quotePanel = new JPanel();
		quotePanel.setLayout(null);
		quotePanel.setBounds(119, 36, 412, 74);
		add(quotePanel);
		
		JLabel lblQuoteFighter = new JLabel("New label");
		lblQuoteFighter.setBounds(24, 11, 362, 52);
		quotePanel.add(lblQuoteFighter);
		
		JLabel lblFighterName = new JLabel("New label");
		lblFighterName.setFont(new Font("BankGothic Md BT", Font.PLAIN, 24));
		lblFighterName.setBounds(109, 11, 147, 14);
		add(lblFighterName);
		

	}
}
