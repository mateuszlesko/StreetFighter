package game.models;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.io.File;
import java.util.Map;
import java.util.HashMap;

public class Scene extends JPanel {
	
	public static int x = 0;
	public static int y = 94;
	public static int width = 718;
	public static int height = 307;
	public String name;
	
	private JLabel backgroud;
	private ImageIcon backgroudImage;
	
	
	private static Map<String,String> backgroundAssets = new HashMap<String,String>();
	
	public Scene() {
		FillHashMap();
	}
	
	public Scene(String _name, String _keyHashMap) {
		FillHashMap();
		this.name = _name;
		this.backgroudImage = new ImageIcon(GetSceneBackground(_keyHashMap));
		SetBackground(new JLabel(backgroudImage));
		
	} 
	
	public void SetBackground(JLabel jlabel) {
		this.backgroud = jlabel;
		this.setBounds(x,y,width,height);
		this.add(backgroud);
	}
	
	public JLabel GetBackground() {
		return this.backgroud;
	}
	
	private static void FillHashMap() {
		backgroundAssets.put("ryustage",new File("assets/graphics/arena/ryustage/ryustage.jpg").getAbsolutePath());
	}
	
	private static String GetSceneBackground(String _name) {
		return backgroundAssets.get(_name);
	}
	
	public boolean Equals(Scene scene) {
		return this.name == scene.name;
	}
	
}
