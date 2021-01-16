package game.entities;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Fighter {
	private String name = "Ryu";
	private String path = "/assets/graphics/character/"; 
	
	public Fighter(String _name) {
		name = _name;
		setPath(path);
	}
	
	
	public void setPath(String _name) {
		path= "/assets/graphics/character/"+_name;
	}
	
	public String getPath() {
		return path;
	}
	
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return this.name.toLowerCase();
	}
	
}
