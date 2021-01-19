package game.states;


import java.util.List;
import java.util.ArrayList;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class StateManager {
	
	
	
	private ArrayList<State> gameStatesList;
	private int currentState = 1 ; // indeks w liscie biezacego stanu
	
	// deklaracja indeksow dla poszczegolnych stanow
	public static final int menuState = 0;
	public static final int arenaState= 1;
	public static final int helpState = 2;
	public static final int creditsState = 3; 
	//public static final int quitState = 4;
	public static final int dialogState = 4;
	
	public StateManager() {
		gameStatesList = new ArrayList<State>();
		currentState = menuState;
		gameStatesList.add(new MenuState(this));
		gameStatesList.add(new CharacterSelectionState(this));
		gameStatesList.add(new FightArenaState(this));
		gameStatesList.add(new CreditsState(this));
		gameStatesList.add(new DialogFightState(this));
		
		
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
	
	public void keyPressed(KeyEvent key) {
		if(gameStatesList.get(currentState) != null)
			gameStatesList.get(currentState).keyPressed(key);
	}
	
	public void keyReleased(KeyEvent key) {
		gameStatesList.get(currentState).keyReleased(key);
	}
	
	
	
	
}
