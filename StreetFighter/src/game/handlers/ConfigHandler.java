package game.handlers;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.*;
import java.util.HashMap;

import game.entities.Fighter;

public class ConfigHandler{
	
	
	//https://www.tutorialspoint.com/java_xml/java_dom_create_document.htm
	//https://www.w3schools.com/java/java_hashmap.asp
	
	private static boolean configCreated = false;
	private static DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	
	public void buildConfig(HashMap<String,Fighter> source) {
		try {
			System.out.println("tworze config");
			//creating structure of xml config file
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.newDocument();
			Element root = document.createElement("fight");
			document.appendChild(root);
			
			//player1
			Element player1 = document.createElement("player1");
			Attr playerAttr = document.createAttribute("type");
			playerAttr.setValue("fighter");
			player1.setAttributeNode(playerAttr);
			player1.appendChild(document.createTextNode(source.get("player1").getName()));
			root.appendChild(player1);
			
			//player2
			Element player2 = document.createElement("player2");
			player2.setAttributeNode(playerAttr);
			player2.appendChild(document.createTextNode(source.get("player2").getName()));
			root.appendChild(player2);
			
			//writing the content to xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			
			DOMSource domSource = new DOMSource(document);
			StreamResult streamResult = new StreamResult(new File(getClass().getResourceAsStream("assets/config/gameConfig.xml").toString()));
			transformer.transform(domSource, streamResult);
			
			configCreated = true;
			StreamResult consoleResult = new StreamResult(System.out);
	        transformer.transform(domSource, consoleResult);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean getConfigCreated() {
		return configCreated;
	}
	
	
	
}
