package game.models;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Character {
	private String name = "Ryu";
	private String path;
	
	
	public Character(String _name) {
		name = _name;
		
	}
	public void setPath() {
		path = getClass().getResource("/assets/graphics/characters/"+name.toLowerCase()+"/portait.png").toString();
	}
	public String getName() {
		return name;
	}
	public String getPath() {
		return path;
	}
	
}
