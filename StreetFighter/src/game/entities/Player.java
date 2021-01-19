package game.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import TileMap.TileMap;
import game.handlers.ConfigHandler;

public class Player extends MapObject{
	
	private ArrayList<BufferedImage[]> sprites;
	private int numer; // player nr 1 or player 2
	private Player opponent;
	private int score = 0;
	
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
	private long time;

	// akcje stanów gracza
	private boolean isIdle;
	private boolean isJumping;
	private boolean isFalling;
	private boolean isWalking;
	private boolean isKnockback;
	private boolean isStunned;
	private boolean isKicking;
	private boolean isPunching;
	private boolean isBlocking;
	private boolean isDefeated;
	private boolean isWinning;
	private boolean isCrounching;
	
	//animations actions
	private static final int IDLE = 0;
	private static final int WALK = 1;
	private static final int JUMP = 2;
	private static final int JUMP_FORWARD = 3;
	private static final int CROUNCH = 4; 
	private static final int BLOCK = 5;
	private static final int PUNCH = 6;
	private static final int KICK = 7;
	private static final int LOWPUNCH = 8;
	private static final int HIGHPUNCH = 9;
	private static final int HIGHKICK = 10;
	private static final int LOWKICK = 11;
	private static final int HIT = 12;
	private static final int KO = 13;
	private static final int VICTORY = 14;
	
	public static final int NONE = 0;
	private int emoji = 0;
	
	
	//storing frames number of each animation
	private final int [] frames = {
			4,5,7,7,2,2,3,3,3,3,2,3,4,3,5,3
	};
	//storing height of each animation frames
	private final int [] frameHeight = {
		94,94,94,146,72,94,94,94,94,72,146,146,72,94,48,94
	};
	//storing width of each animation frames
	private final int [] frameWidth = {
			72,72,72,72,72,72,72,72,72,72,72,72,94,72,72
	};
	//delay between each frame of animation sprites
	private final int[] spriteDelays = {
			-1, 3, 2, 6, 5, 2, 2, 2, 1, -1, 1
	};
	
	//Colision detection
	private RectangleColision ar;
	private RectangleColision aur;
	private RectangleColision cr;
	
	private HashMap<String, Fighter>configHashMap;
	public Player(TileMap _tileMap, int nr) {
		super(_tileMap);
		ar = new RectangleColision(0,0,0,0);
		ar.width = 30;
		ar.height = 20;
		aur = new RectangleColision((int)x -15, (int)y-45,30,30);
		cr.width = 50;
		cr.height = 40;
		
		width = 30;
		height = 30;
		colisionWidth = 16;
		colisionHeight = 40;
		
		moveSpeed = 1.6;
		maxSpeed = 1.6;
		stopSpeed = 1.6;
		gravity = 0.15;
		gravityMax = 4.0;
		jumpStartSpeed = -4.8;
		stopJumpSpeed = 0.3;
		
		punchDamage = 4;
		kickDamage = 6;
		leftSide = nr == 1 ? true : false; // player 1 on the left side; player 2 on the right side
		maxHealth = health = 64;
		
		configHashMap = new ConfigHandler().readConfig();
		
		try {
			BufferedImage spriteSheet;
			if(nr == 1)
				spriteSheet = ImageIO.read(getClass().getResourceAsStream(configHashMap.get("player1").GetPathToGraphics()+"movements.gif"));
			else
				spriteSheet = ImageIO.read(getClass().getResourceAsStream(configHashMap.get("player2").GetPathToGraphics()));
			
			int count = 0;
			sprites = new ArrayList<BufferedImage[]>();
			
			//animation loading
			for(int i = 0; i < frames.length; i++) {
				BufferedImage[] buffer = new BufferedImage[frames[i]];
				for(int j = 0; j < frames[i]; j++) {
					buffer[j] = spriteSheet.getSubimage(j*frameWidth[i], count, frameWidth[i], frameHeight[i]);
				}
				sprites.add(buffer);
				count += frameHeight[i];
			}
			
		}catch(Exception e) {
			
		}
	}
	
	public void initialize(Player p2) {
		opponent = p2;
	}
	
	public void kick() {
		isKicking = true;
		//wywolanie animacji kopniecia
	}
	
	public void block() {
		isBlocking = true;
		//wywolanie animacji bloku
	}
	
	public void punch() {
		isPunching = true;
		//wywolanie animacji bicia
	}
	
	public void hit(int damage) {
		//wywolanie animacji bólu
		health -= damage;
		if(health <= 0)
			isDefeated = true;
	}
	
	public int getScore() { 
		return score;
	}
	
	public int getHealth() {
		return health;
	}
	
	public int getMaxHealth() {
		return maxHealth;
	}
	
	public long getTime() {
		return time;
	}
	
	public String getTimeToString() {
		int minutes = (int) (time / 3600);
		int seconds = (int) ((time % 3600) / 60);
		
		return seconds < 10 ? minutes + ":0" + seconds : minutes + ":" + seconds;
	}
	
	public void setTime(long _time) {
		time = _time;
	}
	
	public void setHealth(int _health) {
		health = _health;
	}
	
	public void reset() {
		health = maxHealth;
		if(numer == 1)
			leftSide = true;
		else
			leftSide = false;
		currentAction = -1;
		stop();
	}
	
	public void stop() {
		isIdle = true;
		isWinning = isFalling = isJumping = isWalking = isKnockback = isStunned =isKicking = isPunching = isBlocking =isDefeated  =false;
	}
	public void setDeath() {
		health = 0;
		stop();
	}
	
	private void getNextPosition() {
		//movements
		if(leftMove) {
			dx -= moveSpeed;
			if(dx < -maxSpeed) {
				dx = -maxSpeed;
			}
		}
		else if(rightMove) {
			dx += moveSpeed;
			if(dx > maxSpeed) {
				dx += moveSpeed;
				if(dx > moveSpeed) {
					dx = moveSpeed;
				}
			}
		}
		else {
			if(dx > 0) {
				dx -= stopSpeed;
				if(dx < 0) {
					dx = 0;
				}
			}
			else if(dx < 0) {
				dx += stopSpeed;
				if(dx > 0) {
					dx = 0;
				}
			}
		}
		
		//can not move while player is attacking, hitted etc
		if((isKicking || isPunching || isBlocking || isDefeated || isWinning || isCrounching) && !(isJumping || isFalling)) {
			dx = 0;
		}
		if(isJumping && !isFalling) {
			dy = jumpStartSpeed;
			isFalling = true;
		}
		
		//when falling
		if(isFalling) {
			dy += gravity;
			if(dy < 0 && !isJumping) 
				dy += stopJumpSpeed;
			if(dy > gravityMax)
				dy = gravityMax;
		}
	}
	
	private void setAnimation(int i) {
		currentAction = i;
		animation.setFrames(sprites.get(currentAction));
		animation.setDelay(spriteDelays[currentAction]);
		width = frameWidth[currentAction];
		height = frameHeight [currentAction];
	}
	
	public void update() {
		
		time++;
		
		boolean falling = isFalling;
		getNextPosition();
		setPosition(xTemp,yTemp);
		
		if(dx == 0)
			x = (int)x;
		
		if(health == 0) {
			if(currentAction != KO) {
				setAnimation(KO);
			}
		}
		
		//check attack then finish it
		if(currentAction == PUNCH || currentAction == KICK) {
			if(animation.hasPlayedOnce()) {
				isPunching = false;
				isKicking = false;
			}
		}
		
		//attacking make rectangle colision bigger
		if(isPunching || isKicking) {
			if(currentAction != PUNCH || currentAction != KICK) {
				ar.y = (int)y - 6;
				if(leftSide)
					ar.x = (int)x+10;
				else
					ar.x = (int)x - 40;
			}
		}
		
		if(dy < 0 && currentAction != JUMP) {
			
		}
		if( (leftMove || rightMove) && currentAction != WALK) {
			setAnimation(WALK);
		}
		
		if(currentAction != IDLE) {
			setAnimation(IDLE);
		}
		
		animation.update();
		
		//setting director
		if(!isPunching && !isKicking) {
			if(rightMove)
				leftSide = true;
			if(leftMove)
				leftSide = false;
		}
		
	}
	
	public void draw(Graphics2D _graphic) {
		super.draw(_graphic);
	}
	
}
