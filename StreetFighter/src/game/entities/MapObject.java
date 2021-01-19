package game.entities;
import TileMap.TileMap;
import game.GamePanel;
import game.handlers.AnimationHandler;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Comparator;

public abstract class MapObject {
	
	//tile
	protected TileMap tileMap;
	protected int tileSize;
	protected double xMap;
	protected double yMap;
	
	//position and vectors
	protected double x;
	protected double y;
	protected double dx;
	protected double dy;
	
	protected int width;
	protected int height;
	
	//collision square box
	protected int colisionWidth;
	protected int colisionHeight;
	
	//collision
	protected int currentRow;
	protected int currentColumn;
	protected double xDestination;
	protected double yDestination;
	protected double xTemp;
	protected double yTemp;
	protected boolean leftSide;
	
	//colision detection
	protected boolean bottomLeft;
	protected boolean bottomRight;
	
	//animation
	
	protected AnimationHandler animation;
	protected int currentAction;
	protected int previousAction;
	
	//movements
	protected boolean leftMove;
	protected boolean rightMove;
	protected boolean jumpingMove;
	protected boolean crounchMove;
	protected boolean punchMove;
	protected boolean kickMove;
	protected boolean hurtMove;
	protected boolean blockMove;
	protected boolean victoryMove;
	protected boolean koMove;
	protected boolean stuneMove;
	
	//movements atributes
	protected double moveSpeed;
	protected double maxSpeed;
	protected double stopSpeed;
	protected double gravity;
	protected double gravityMax;
	protected double jumpStartSpeed;
	protected double stopJumpSpeed;
	

	public MapObject(TileMap tile) {
		tileMap = tile;
		tileSize = tile.getTileSize();
		animation = new AnimationHandler();
		leftSide = true;
	}
	
	public boolean itersects(MapObject obj) {
		Rectangle rectangle1 = getRectangle();
		Rectangle rectangle2 = obj.getRectangle();
		return rectangle1.intersects(rectangle2);
	}
	
	public boolean intersects(Rectangle _rectangle) {
		return getRectangle().intersects(_rectangle);
	}
	
	public boolean contains(Rectangle _rectangle) {
		return getRectangle().contains(_rectangle);
	}
	
	public Rectangle getRectangle() {
		return new Rectangle((int)x-(colisionWidth/2),(int)y-colisionHeight/2,colisionWidth,colisionHeight);
	}
	public int getX() {return (int) x;}
	public int getY() {return (int) y;}
	public int getWidth() {return (int) width;}
	public int getHeight() {return (int) height;}
	public boolean isLeftSide() {return leftSide;}
	
	public void setPosition(double _x, double _y) {
		x = _x;
		y = _y;
	}
	
	public void setMapPosition() {
		xMap = tileMap.getX();
		yMap = tileMap.getY();
	}
	
	public boolean notOnScreen() {
		return x + xMap + width < 0 || 
				x + xMap - width > GamePanel.width || 
				y + yMap + height < 0 ||
				y + yMap - height > GamePanel.height;
	}
	
	public void draw(Graphics2D _graphics) {
		setMapPosition();
		if(leftSide)
			_graphics.drawImage(animation.getImage(), (int)(x + xMap - width / 2 ), (int)(y + yMap - height / 2), null);
		else
			_graphics.drawImage(animation.getImage(), (int)(x + xMap - width / 2 + width),(int)(y + yMap - height / 2) , -width, height, null);
	}
		
	public boolean interacts(Rectangle _rectangle) {
		return this.getRectangle().intersects(_rectangle);
	}
	
	public void setJumping(boolean jump) {
		jumpingMove = jump;
	}
	
	public void setCrounching(boolean crounch) {
		crounchMove = crounch;
	}
	
	public void setLeftMove(boolean left) {
		leftMove = left;
	}
	public void setRightMove(boolean right) {
		rightMove =right;
	}
	public void setPunchMove(boolean punch) {
		punchMove = punch;
	}
	public void setKickMove(boolean kick) {
		kickMove = kick;
	}
	public void setHurtMove(boolean hurt) {
		hurtMove = hurt;
	}
	public void setBlockMove(boolean block) {
		blockMove = block;
	}
	public void setVictoryMove(boolean victory) {
		victoryMove = victory;
	}
	public void setKOMove(boolean ko) {
		koMove = ko;
	}
	public void setStuneMove(boolean stune) {
		stuneMove = stune;
	}
	
	public Rectangle geRectangle() {
		return new Rectangle((int)x - colisionWidth,(int)y - colisionHeight,colisionWidth,colisionHeight);
	}
	
//	public void calculateCorners(double x, double y) {
//		int leftTile = (int)(x-colisionWidth/2)/tileSize;
//		int rightTile = (int)(x+colisionWidth/2-1)/tileSize;
//		int topTile = (int) (y+colisionHeight/2)/tileSize;
//		int bottomTile = (int) (y+colisionHeight/2-1)/tileSize;
//		inf(topTile < 0 || bottomTile >= tileMap.getColumns() || leftTile < 0 || rightTile >= tileMap.getColumns())
//	}
}
