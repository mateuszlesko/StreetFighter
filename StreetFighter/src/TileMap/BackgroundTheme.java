package TileMap;

//import java.awt.image.BufferStrategy;
//import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


import game.GamePanel;

public class BackgroundTheme {
	private BufferedImage bufferImage;
	private double x,dx,y,dy;
	private double moveScale;
	
	public BackgroundTheme(String source, int ms) {
		try {
			bufferImage = ImageIO.read(getClass().getResourceAsStream(source));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		moveScale = ms;
		///https://www.youtube.com/watch?v=9dzhgsVaiSo&t=658s&ab_channel=ForeignGuyMike
	}
	public void setPosition(double _x, double _y) {
		x = (_x * moveScale) % GamePanel.width;
		y = (_y * moveScale) % GamePanel.height;
	}
	
	public void setVector(double _dx, double _dy) {
		dx = (_dx * moveScale) % GamePanel.width;
		dy = (_dy * moveScale) % GamePanel.height;
	}
	
	public void update() {
		System.out.println("update from BackgroundTheme");
		x+=dx;
		y+=dy;
	}
	public void draw(Graphics2D _graphic) {
		_graphic.drawImage(bufferImage, (int)x, (int)y, null);
		if(x < 0) {
			_graphic.drawImage(bufferImage,(int)x + GamePanel.width,(int)y,null);
		}
		if(x > 0) {
			_graphic.drawImage(bufferImage, (int)x - GamePanel.width, (int)y, null);
		}
	}
}
