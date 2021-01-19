package game.states;

import java.awt.Graphics2D;
import java.awt.event.KeyListener;
//implementacja KeyListenera
public abstract class State implements KeyListener{
	protected StateManager stateManager; // referencja do zmiany stanu
	public abstract void initialize();
	public abstract void draw(Graphics2D graphic);
	public abstract void update();
}
