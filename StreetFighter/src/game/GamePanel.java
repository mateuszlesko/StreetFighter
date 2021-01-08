package game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import game.states.StateManager;

public class GamePanel extends JPanel implements Runnable, KeyListener {
	
	private static final long serialVersionUID = -678780521158129930L;
	public static final int width = 380;//320;
	public static final int height = 280;//240;
	public static final int scale = 2;
	
	//watek gry
	private Thread gameThread;
	//przechowuje stan gry
	private boolean running;
	private int fps = 60;
	private long targetTime = 1000/fps; // wyrazony w ms
	
	//obraz
	private BufferedImage buffer;
	private Graphics2D graphics2d;
	
	//zarzadzenie stanem gry
	
	private StateManager stateManager;
	
	public GamePanel() {
		super();
		setPreferredSize(new Dimension(width*scale,height*scale));
		setFocusable(true);
		requestFocus();
	}
	@Override
	public void addNotify() {
		super.addNotify();
			if(gameThread == null) {
					gameThread = new Thread(this);
			addKeyListener(this);
			gameThread.start();
			}
	}
	
	public void initialize() {
		buffer = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		graphics2d = (Graphics2D) buffer.getGraphics();
		running = true;
		
		stateManager = new StateManager();
	}
	@Override
	public void run() {
		initialize();
		long startTimer;
		long elapsedTimer;
		long waitTimer;
		
		//glowna petla gry:
		while(running) {
			
			startTimer = System.nanoTime(); //zwraca czas uruchomienia JVM
			update();
			draw();
			drawScreen();
			elapsedTimer = System.nanoTime() - startTimer;
			waitTimer = targetTime - elapsedTimer / 1000000; // w nano sekundach
			
			if(waitTimer < 0)
				waitTimer = 5;
			
			try {
				Thread.sleep(waitTimer);
			}catch(Exception e) {
				e.printStackTrace(); // wyswietla miejsce wystapienia wyjatku na stosie rozkazow 
			}
			
		}
	}
	

	public void keyPressed(KeyEvent keyEvent) {
		try {
		stateManager.keyPressed(keyEvent.getKeyCode());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	public void keyReleased(KeyEvent keyEvent) {
		stateManager.keyReleased(keyEvent.getKeyCode());
	}
	

	public void keyTyped(KeyEvent keyEvent) {
		
	}
	
	private void update() {
		stateManager.update();
	}
	private void draw() {
		stateManager.draw(graphics2d);
	}
	private void drawScreen() {
		Graphics graphics = getGraphics(); //metoda pochodza z klasy JComponent; dostepna dzieki dziedziczeniu
		graphics.drawImage(buffer, 0, 0, width*scale, height*scale, null);
		graphics.dispose();
	}
}
