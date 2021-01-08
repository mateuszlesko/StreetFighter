package game.states;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

import TileMap.BackgroundTheme;
import java.awt.Color;
import java.awt.Font;
public class MenuState extends State{
	
	private BackgroundTheme background;
	private static final String[] choiceOptions = {
			"",
			"Start Fight",
			"Help",
			"Credits",
			"Exit"
	};
	private int currentChoice = 1; //indeks obecnej opcji
	private Color regularColor;
	private Font regularFont;
	
	public MenuState(StateManager _stateManager) {
		stateManager = _stateManager; //refencja do tego samego obiektu zarzadcy stanu, ktory jest uzywany
		try {
			background = new BackgroundTheme("/assets/graphics/backgrounds/menuTheme.png",1);
			background.setVector(-0.1, 0);
			background.setPosition(-20, 0);
			regularColor = new Color(252, 244, 5);
			regularFont = new Font("Arial",Font.PLAIN,16);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics2D graphic) {
		//graphic.drawImage(new Image(), currentChoice, currentChoice, regularColor, null);
		background.draw(graphic);
		
		graphic.setColor(regularColor);
		graphic.setFont(regularFont);
		
		for(int i = 0; i < choiceOptions.length;i++) {
			if(i == currentChoice) {
				graphic.setColor(new Color(245, 0, 0));
			}
			else {
				graphic.setColor(regularColor);
			}
			graphic.drawString(choiceOptions[i], 145, 140 + i * 15);
		}
		
	}

	@Override
	public void update() {
		background.update();
	}

	@Override
	public void keyPressed(int keyNumber) {
	
		if(keyNumber == KeyEvent.VK_ENTER) {
			selectOption();
		}
		if(keyNumber == KeyEvent.VK_UP) {
			if(currentChoice > 1)
				currentChoice--;
			else
				currentChoice = choiceOptions.length;
		}
		if(keyNumber == KeyEvent.VK_DOWN) {
			if(currentChoice <= 4)
				currentChoice++;
			else
				currentChoice = 1;
		}
	}

	@Override
	public void keyReleased(int keyNumber) {
		// TODO Auto-generated method stub
		
	}
	
	private void selectOption() {
		switch(currentChoice) {
			case 0:
				break;
			case 1:
				stateManager.setState(StateManager.arenaState);
				break;
			case 2:
				break;
			case 3:
				stateManager.setState(StateManager.creditsState);
				break;
			case 4:
				System.exit(0);
				break;
			default:
				break;
		}
	}

}
