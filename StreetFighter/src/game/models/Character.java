package game.models;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Character {
	private String name = "Ryu";
	
	
	public Character(String _name) {
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
