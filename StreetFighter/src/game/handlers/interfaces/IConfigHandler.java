package game.handlers.interfaces;

import java.util.HashMap;

import game.entities.Fighter;

public interface IConfigHandler {
	HashMap<String, Fighter> readConfig();
	void writeToConfig(HashMap<String,Fighter> source);
}
