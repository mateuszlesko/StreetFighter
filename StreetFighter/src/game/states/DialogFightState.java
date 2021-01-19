package game.states;

import game.entities.Fighter;
import game.handlers.ConfigHandler;

import java.util.HashMap;

import javax.imageio.ImageIO;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import TileMap.BackgroundTheme;

public class DialogFightState extends State {
	private BackgroundTheme background;
	private Color regularColor;
	private Font regularFont;
	private HashMap<String,Fighter> chosenFighters;
	private BufferedImage imageBuffer;
	private BufferedImage characterP1;
	private BufferedImage characterP2;
	private int dx1 = 10;
	private int dx2 = 10;
	
	public DialogFightState(StateManager _stateManager) {
		stateManager = _stateManager; //refencja do tego samego obiektu zarzadcy stanu, ktory jest uzywany
		try {
			background = new BackgroundTheme("/assets/graphics/backgrounds/selectionTheme.png",1);
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
		chosenFighters = new ConfigHandler().readConfig();
		try {
			characterP1 = setPortrait(chosenFighters.get("player1"));
			graphic.drawImage(characterP1, 0, 80, null);
			characterP2 = setPortrait(chosenFighters.get("player2"));
			graphic.drawImage(characterP2, 280, 80, null);
		}
		catch(java.lang.IllegalArgumentException illegalException) {
			return;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
		graphic.setColor(regularColor);
		graphic.setFont(regularFont);
		graphic.drawString(chosenFighters.get("player1").sayQuote(), 65, 140);
		graphic.drawString(chosenFighters.get("player2").sayQuote(), 165, 180);
		
		graphic.drawString("VS",200, 100);
		
		graphic.drawString("Click ENTER to continue",120, 240);
		
	}

	@Override
	public void update() {
		background.update();
	}

	@Override
	public void keyPressed(KeyEvent key) {
	
		if(key.getKeyCode() == KeyEvent.VK_ENTER) {
			stateManager.setState(2);
			
		}
	}
	
	@Override
	public void keyTyped(KeyEvent key) {
		
	}

	@Override
	public void keyReleased(KeyEvent key) {
		// TODO Auto-generated method stub
	}
	
	private BufferedImage setPortrait(Fighter character) {
		BufferedImage portrait = null;
		try {
			portrait = ImageIO.read(getClass().getResourceAsStream(character.GetPathToGraphics()+"/portrait.png"));
		}
		catch(NullPointerException e) {
			e.printStackTrace();
		}
		catch(java.lang.IllegalArgumentException illegalException) {
			illegalException.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return portrait;
	}
}
