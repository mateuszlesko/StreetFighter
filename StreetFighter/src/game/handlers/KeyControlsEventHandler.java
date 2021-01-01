package game.handlers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.ArrayList;
import java.util.function.Consumer;

import game.GamePanel;

public class KeyControlsEventHandler implements KeyListener{

	public static List<Key> keysList = new ArrayList<Key>();
	
	class Key{
		public int presses, absorbs;
		public boolean down, clicked;
		
		public Key() 
		{
			keysList.add(this);
		}
		
		public void toggle(boolean pressed) {
			if(pressed != down)
				down = pressed;
			else
				clicked = false;
		}
		
		public void ticking() {
			if(absorbs < presses) {
				absorbs++;
				clicked = true;
			}
			else {
				clicked = false;
			}
		}
	}
	
	public Key up1 = new Key();
	public Key up2 = new Key();
	public Key down1 = new Key();
	public Key down2 = new Key();
	public Key right1 = new Key();
	public Key right2 = new Key();
	public Key left1 = new Key();
	public Key left2 = new Key();
	public Key kick1 = new Key();
	public Key kick2 = new Key();
	public Key punch1 = new Key();
	public Key punch2 = new Key();
	public Key block1 = new Key();
	public Key block2 = new Key();
	
	public KeyControlsEventHandler(GamePanel _gamePanel) {
		_gamePanel.addKeyListener(this);
	}
	
	public void realeseAll() {
		//zrob to jako customer
		Consumer<Key> realeseKeys = key -> {
			key.down = false;
		};
		keysList.forEach(realeseKeys);
	}
	
	public void ticking() {
		Consumer<Key> tickingKeys = key -> {
			key.ticking();
		};
		keysList.forEach(tickingKeys);
	}
	
	public void toggle(KeyEvent keyEvent, boolean pressed) {
		switch(keyEvent.getKeyCode()) {
		case KeyEvent.VK_W:
			up1.toggle(pressed);
			break;
		case KeyEvent.VK_S:
			down1.toggle(pressed);
			break;
		case KeyEvent.VK_A:
			left1.toggle(pressed);
			break;
		case KeyEvent.VK_D:
			right1.toggle(pressed);
			break;
		case KeyEvent.VK_H:
			kick1.toggle(pressed);
			break;
		case KeyEvent.VK_J:
			punch1.toggle(pressed);
			break;
		case KeyEvent.VK_K:
			block1.toggle(pressed);
			break;
		case KeyEvent.VK_KP_UP:
			up2.toggle(pressed); 
			break;
		case KeyEvent.VK_KP_DOWN:
			down2.toggle(pressed);
			break;
		case KeyEvent.VK_KP_LEFT:
			left2.toggle(pressed);
			break;
		case KeyEvent.VK_KP_RIGHT:
			right2.toggle(pressed);
			break;
		case KeyEvent.VK_1:
			kick2.toggle(pressed);
			break;
		case KeyEvent.VK_2:
			punch2.toggle(pressed);
			break;
		case KeyEvent.VK_3:
			block2.toggle(pressed);
			break;
		default:
			break;
		}
	}
	
	@Override
	public void keyPressed(KeyEvent keyEvent) {	
		toggle(keyEvent,true);
	}
	@Override
	public void keyTyped(KeyEvent keyEvent) {
		//nic
	}
	@Override
	public void keyReleased(KeyEvent keyEvent) {
		toggle(keyEvent,false);
	}
}
