package game.states;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import TileMap.BackgroundTheme;
import game.entities.Player;

public class FightArenaState extends State {
	
	
	//private TileMap tileMap;
	private BackgroundTheme background;
	private Player player1;
	public FightArenaState(StateManager _stateManager) {
		stateManager = _stateManager;
		background = new BackgroundTheme("/assets/graphics/arena/ryustage/ryustage.jpg",1);
		background.setPosition(40/2,15/2);
		player1 = new Player();
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
		background.update();
		
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
