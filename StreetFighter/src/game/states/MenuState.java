package game.states;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import TileMap.BackgroundTheme;
import java.awt.Color;
import java.awt.Font;
public class MenuState extends State{
	
	private BackgroundTheme background;
	private static final String[] choiceOptions = {
			"Start Fight",
			"Credits",
			"Exit"
	};
	private int currentChoice = 0; //indeks obecnej opcji
	private Color regularColor;
	private Font regularFont;
	
	public MenuState(StateManager _stateManager) {
		System.out.println("CONSTRUCTOR MenuState; length of choices "+choiceOptions.length);
		stateManager = _stateManager; //refencja do tego samego obiektu zarzadcy stanu, ktory jest uzywany
		try {
			background = new BackgroundTheme("/assets/graphics/menu/menuTheme.png",1);
			background.setVector(-0.1, 0);
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
		System.out.println("draw from MenuState");
		// TODO Auto-generated method stub
		background.draw(graphic);
		
		//drawing menu choice options
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
		// TODO Auto-generated method stub
		System.out.println("update from menustate");
		background.update();
	}

	@Override
	public void keyPressed(int keyNumber) {
		// TODO Auto-generated method stub
		if(keyNumber == KeyEvent.VK_ENTER) {
			System.out.println(currentChoice);
			System.out.println("ENTER");
			selectOption();
		}
		if(keyNumber == KeyEvent.VK_UP) {
			if(currentChoice > 0)
				currentChoice--;
			else
				currentChoice = choiceOptions.length;
		}
		if(keyNumber == KeyEvent.VK_DOWN) {
			if(currentChoice <= 2)
				currentChoice++;
			else
				currentChoice = 0;
		}
	}

	@Override
	public void keyReleased(int keyNumber) {
		// TODO Auto-generated method stub
		
	}
	
	private void selectOption() {
		switch(currentChoice) {
			case 0:
				stateManager.setState(0);
				break;
			case 1:
				//stateManager.setState(1);
				break;
			case 2:
				//stateManager.setState(2);
				break;
			default:
				break;
		}
	}

}
