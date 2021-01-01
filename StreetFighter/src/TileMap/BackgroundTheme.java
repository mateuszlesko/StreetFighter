package TileMap;

import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class BackgroundTheme {
	private BufferedImage bufferImage;
	private double x,dx,y,dy;
	private double moveScale;
	
	public BackgroundTheme(String source, double ms) {
		try {
			bufferImage = ImageIO.read(getClass().getResourceAsStream(source));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		///https://www.youtube.com/watch?v=9dzhgsVaiSo&t=658s&ab_channel=ForeignGuyMike
	}
}
