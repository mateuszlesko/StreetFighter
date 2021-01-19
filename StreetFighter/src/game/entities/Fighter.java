package game.entities;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import game.handlers.interfaces.IFileHandler;

public class Fighter {
	
	private String name = "Ryu"; 
	private String pathToGraphics = "/assets/graphics/characters/";
	private String pathToText = "/assets/text/quotes/characters/";
	
	public IFileHandler fileHandler;
	
	public Fighter(String _name) {
		name = _name;
		pathToGraphics += name.toLowerCase();
		pathToText += name.toLowerCase();
	}
		
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return this.name.toLowerCase();
	}
	
	public String GetPathToGraphics() {
		return pathToGraphics;
	}
	
	public String GetPathToTextQuotes() {
		return pathToText;
	}
	
	public String sayQuote() {
		
		fileHandler = new IFileHandler() {
			@Override
			public String readContent() {
				
				String quotes [] = new String[4];
				try {
					int index = 0;
					File configFile = new File(getClass().getResource(pathToText+"/welcome.txt").toString());
					Scanner reader = new Scanner(configFile);
					while(reader.hasNextLine() && index < quotes.length) {
						quotes[index] = reader.nextLine();
						index++;
					}
					reader.close();
				}
				catch(Exception e) {
					return "I am destroing you !";
				}
				int min = 0;
				int max = 4;
				String quote = quotes[min + (int)(Math.random() * ((max - min) + 1))];
				return quote;
			}
		};
		
		return fileHandler.readContent();
	}
	
}
