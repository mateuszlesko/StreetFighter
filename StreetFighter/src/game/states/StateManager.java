package game.states;


import java.util.List;
import java.util.ArrayList;
import java.awt.Graphics2D;

public class StateManager {
	
	
	
	private List<State> gameStatesList;
	private int currentState = 0 ; // indeks w liscie biezacego stanu
	
	// deklaracja indeksow dla poszczegolnych stanow
	public static final int menuState = 0;
	public static final int arena= 0;
	
	public StateManager() {
		gameStatesList = new ArrayList<State>();
		gameStatesList.add(new MenuState(this));
		
	}
	public void setState(int numberState) {
		currentState = numberState;
		gameStatesList.get(currentState).initialize();
	}
	public void update(){
		gameStatesList.get(currentState).update();
	}
	
	public void draw(Graphics2D _graphics) {
		gameStatesList.get(currentState).draw(_graphics);
	}
	
	public void keyPressed(int keyNumber) {
		gameStatesList.get(currentState).keyPressed(keyNumber);
	}
	
	public void keyReleased(int keyNumber) {
		gameStatesList.get(currentState).keyReleased(keyNumber);
	}
	
	
	
	
}
