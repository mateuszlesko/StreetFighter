package game.states;


import java.util.List;
import java.util.ArrayList;
import java.awt.Graphics2D;

public class StateManager {
	
	
	
	private ArrayList<State> gameStatesList;
	private int currentState = 1 ; // indeks w liscie biezacego stanu
	
	// deklaracja indeksow dla poszczegolnych stanow
	public static final int menuState = 0;
	public static final int arenaState= 1;
	public static final int helpState = 2;
	public static final int creditsState = 3; 
	public static final int quitState = 4;
	
	public StateManager() {
		gameStatesList = new ArrayList<State>();
		currentState = menuState;
		gameStatesList.add(new MenuState(this));
		gameStatesList.add(new CharacterSelectionState(this));
		//gameStatesList.add(new FightArenaState(this));
		gameStatesList.add(null);
		gameStatesList.add(new CreditsState(this));
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
		if(gameStatesList.get(currentState) != null)
			gameStatesList.get(currentState).keyPressed(keyNumber);
	}
	
	public void keyReleased(int keyNumber) {
		gameStatesList.get(currentState).keyReleased(keyNumber);
	}
	
	
	
	
}
