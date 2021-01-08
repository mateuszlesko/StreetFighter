package game.entities;

public class Vector<X extends Object ,Y extends Object> {
	private X x;
	private Y y;
	
	public Vector( X _x, Y _y) {
		x = _x;
		y = _y;
	}
	
	public X getX() {
		return x;
	}
	
	public Y getY() {
		return y;
	}
	
	public void setX(X _x) {
		x = _x;
	}
	
	public void setY(Y _y) {
		y = _y;
	}
	
}
