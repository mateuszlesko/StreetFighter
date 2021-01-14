package game.entities;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Fighter {
	private String name = "Ryu";
	
	
	public Fighter(String _name) {
		name = _name;
	
	}
	
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return this.name.toLowerCase();
	}
	
}
