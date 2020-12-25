package game.helpers;

import game.models.Scene;
import java.util.ArrayList;

public class SceneHelper {
	
	private static Scene scene;
	public static ArrayList<Scene> sceneList = new ArrayList<Scene>();
	
	public SceneHelper(int sceneNr) {
		FillSceneList();
		scene = sceneList.get(sceneNr);
	}
	
	public Scene GetScene() {
		System.out.println(scene.name);
		return scene;
	}
	
	public void SetScene(Scene _scene) {	
		sceneList.add(_scene);
		scene = _scene; 
	}
	
	private static void FillSceneList() {
	 sceneList.add(new Scene("Ryu Stage","ryustage"));	
	}
	
}
