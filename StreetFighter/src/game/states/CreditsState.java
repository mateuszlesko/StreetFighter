package game.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import TileMap.BackgroundTheme;

public class CreditsState extends State{
	private BackgroundTheme background;
	private Color regularColor;
	private Font regularFont;
	
	public CreditsState(StateManager _stateManager) {
		stateManager = _stateManager; //refencja do tego samego obiektu zarzadcy stanu, ktory jest uzywany
		try {
			background = new BackgroundTheme("/assets/graphics/backgrounds/menuTheme.png",1);
			background.setVector(-0.1,0);
			regularColor = new Color(252, 244, 5);
			regularFont = new Font("Arial",Font.PLAIN,12);
			
			
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

		background.draw(graphic);
		
		graphic.setColor(regularColor);
		graphic.setFont(regularFont);
		graphic.drawString("All rights for logos, graphics,", 45, 140);
		graphic.drawString("characters have owned by Capcome Company", 45, 160);
		graphic.drawString("Credits: Mateusz Leœko", 45, 180);
		graphic.drawString("link to source: ", 45, 200);
		graphic.drawString("github.com/mateuszlesko/StreetFighter", 45, 220);
	}

	@Override
	public void update() {
		background.update();
	}

	@Override
	public void keyPressed(int keyNumber) {
	
		if(keyNumber == KeyEvent.VK_ENTER) {
			stateManager.setState(0);
			
		}
	}

	@Override
	public void keyReleased(int keyNumber) {
		// TODO Auto-generated method stub
	}
	
}
