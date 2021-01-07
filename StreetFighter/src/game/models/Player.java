package game.models;

import java.util.ArrayList;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Player {
	
	private int numer;
	private Player opponent;
	
	private int positionX;
	private int positionY;
	
	private int health;
	private int maxHealth;
	private int punchDamage;
	private int kickDamage;
	private int blockResist;
	private long timeInSky;
	private long timeStunned;
	private long timeFalling;
	private long timeKnockback;

	// akcje stanów gracza
	private boolean isJumping;
	private boolean isFalling;
	private boolean isWalking;
	private boolean isKnockback;
	private boolean isStunned;
	private boolean isKicking;
	private boolean isPunching;
	private boolean isBlocking;
	private boolean isDefeated;
	
	//przechowywanie i ustalenie rozmiaru grafik dla postaci
	private ArrayList<BufferedImage[]> spritesPlayer;
	private final int[] frameNumbers = {};
	private final int[] frameWidths = {};
	private final int[] frameHeights = {};
	
	
	public Player() {
		
	}
	
	public void hit(int damage) {
		health -= damage;
		if(health <= 0)
			isDefeated = true;
	}
}
