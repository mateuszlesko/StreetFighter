package game.states;

import java.util.HashMap;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import TileMap.BackgroundTheme;
import game.entities.Player;
import game.entities.Fighter;
import game.handlers.ConfigHandler;

public class FightArenaState extends State {
	
	
	//private TileMap tileMap;
	private BackgroundTheme background;
	//private Player player1;
	private BufferedImage characterP1;
	private BufferedImage characterP2;
	
	private static boolean loaded = false;
	public FightArenaState(StateManager _stateManager) {
		stateManager = _stateManager;
		background = new BackgroundTheme("/assets/graphics/arena/ryustage/ryustage.jpg",1);
		background.setPosition(40/2,15/2);
		loaded = true;
	}
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	public void draw(Graphics2D graphic) {
		// TODO Auto-generated method stub
		
		background.draw(graphic);
		
	}

	@Override
	public void update() {
		HashMap<String,Fighter> hash = new ConfigHandler().readConfig();
		background.update();
		loaded = false;
	}

	@Override
	public void keyPressed(KeyEvent key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent key) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void keyTyped(KeyEvent key) {
		
	}

}
