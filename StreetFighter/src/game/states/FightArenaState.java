package game.states;

import java.awt.Graphics2D;
import game.models.Player;
import TileMap.BackgroundTheme;

public class FightArenaState extends State {
	
	
	//private TileMap tileMap;
	private BackgroundTheme background;
	private Player player1;
	public FightArenaState(StateManager _stateManager) {
		System.out.println("FIGHT ARENA");
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
	public void keyPressed(int keyNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(int keyNumber) {
		// TODO Auto-generated method stub
		
	}

}
