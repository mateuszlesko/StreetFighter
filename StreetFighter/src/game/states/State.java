package game.states;

import java.awt.Graphics2D;

public abstract class State {
	protected StateManager stateManager; // referencja do zmiany stanu
	public abstract void initialize();
	public abstract void draw(Graphics2D graphic);
	public abstract void update();
	
	public abstract void keyPressed(int keyNumber);
	public abstract void keyReleased(int keyNumber);
}
