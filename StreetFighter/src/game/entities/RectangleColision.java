package game.entities;

import java.awt.Rectangle;

public class RectangleColision extends Rectangle {
	private Point bottomLeft;
	private Point topRight;
	
	public boolean isOverlapping(RectangleColision rectangle) {
		if(this.topRight.getY() < rectangle.bottomLeft.getY() || this.bottomLeft.getY() > rectangle.topRight.getY())
			return false;
		if(this.topRight.getX() < rectangle.bottomLeft.getX() || this.bottomLeft.getX() > rectangle.topRight.getX())
			return false;
		
		return true;
	}
}
