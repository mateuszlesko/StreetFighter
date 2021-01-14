package TileMap;

import java.awt.image.BufferedImage;

public class Tile {
	private BufferedImage image;
	
	public Tile(BufferedImage _image) {
		image = _image;
	}
	
	public BufferedImage getImage() {
		return image;
	}
}
