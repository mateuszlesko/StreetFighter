package game.handlers;

import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;


import game.entities.Fighter;
import game.handlers.interfaces.IConfigHandler;

public class ConfigHandler implements  IConfigHandler{
	
	private final static String path = "gameConfig.txt";
	private static boolean exist = false;
	private void buildConfig() {
		try {
			File configFile = new File(path);
			configFile.createNewFile();
			exist = true;
		}catch(IOException ioException) {
			ioException.printStackTrace();
		}
		
	}
	
	public HashMap<String, Fighter> readConfig(){
		HashMap<String,Fighter> hashMap = new HashMap<String,Fighter>();
		Fighter fighters [] = new Fighter[3];
		try {
			if(exist != true)
				throw new FileNotFoundException();
			
			int index = 0;
			File configFile = new File(path);
			Scanner reader = new Scanner(configFile);
			while(reader.hasNextLine()) {
				fighters[index] = new Fighter(reader.nextLine());
				index++;
			}
			reader.close();
			hashMap.put("player1", fighters[0]);
			hashMap.put("player2", fighters[1]);
		}
		catch(FileNotFoundException e) {
			buildConfig();
			readConfig();
			
		}
		catch(Exception e) {
			System.out.println("WYJATEK");
			return null;
		}
		
		return hashMap;
	}
	
	public void writeToConfig(HashMap<String,Fighter> source) {
		try {
			if(exist != true)
				throw new IOException();
			
			if(isEmpty()) {
				FileWriter fileWriter = new FileWriter(path);
				fileWriter.write(source.get("player1")+"\n");
				fileWriter.write(source.get("player2")+"\n");
				fileWriter.close();
			}
			else {
				clearConfig();
				writeToConfig(source);
			}
		}catch(IOException ioException) {
			buildConfig();
			writeToConfig(source);
		}
	}
	
	private boolean isEmpty() throws FileNotFoundException {
		File configFile = new File(path);
		Scanner reader = new Scanner(configFile);
		return reader.hasNext();
	}
	
	private void clearConfig() {
		try {
			FileWriter fileWriter = new FileWriter(path);
			fileWriter.write("");
			fileWriter.close();		
		}catch(Exception ioException) {
			ioException.printStackTrace();
		}
	}
	
}
