package game.states;

import java.util.HashMap;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import TileMap.BackgroundTheme;
import java.awt.Color;
import java.awt.Font;

import game.models.Character;
import game.entities.Vector;

public class CharacterSelectionState extends State{

	private BackgroundTheme background;
	private BufferedImage imageBuffer;
	private BufferedImage characterP1;
	private BufferedImage characterP2;
	
	private Color regularColor;
	private Font regularFont;
	
	private static Character[][] characters = new Character[4][4];
	private static int column = 0;
	private static int row = 0;
	
	private static boolean player1Chose = false;
	private static boolean player2Chose = false;
	
	//przechowywanie wybranej postaci
	Vector<Integer,Integer> player1;
	Vector<Integer,Integer> player2;
	
	public CharacterSelectionState(StateManager _stateManager) {
		stateManager = _stateManager; //refencja do tego samego obiektu zarzadcy stanu, ktory jest uzywany
		fillTable();
		player1 = new Vector(column,row);
		player2 = new Vector(column,row);
		try {
			background = new BackgroundTheme("/assets/graphics/backgrounds/selectionTheme.png",1);
			background.setPosition(0,0);
			regularColor = new Color(252, 244, 5);
			regularFont = new Font("Arial",Font.PLAIN,24);
			
			characterP1 =setPortrait(characters[column][row]);
			characterP2 =setPortrait(characters[column][row]);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics2D graphic) {
		background.draw(graphic);
		
		graphic.drawString("P1:"+characters[player1.getY()][player1.getX()].getName(), 42, 40);
		graphic.drawString("P2:"+characters[player2.getY()][player2.getX()].getName(), 242, 40);
		
		try {	
		imageBuffer = ImageIO.read(getClass().getResourceAsStream("/assets/graphics/characters/portraits/portraits.png"));
		graphic.drawImage(imageBuffer,68, 0, null);
		
		graphic.drawImage(characterP1, 0, 80, null);
		graphic.drawImage(characterP2, 286, 80, null);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update() {
		//background.update();
	}

	@Override
	public void keyPressed( KeyEvent key) {
	
		if(player1Chose == false && player2Chose == false) {
			selectOptionPlayer1(key.getKeyCode());
		}
		
		if(player2Chose == false && player1Chose == true) {
			selectOptionPlayer2(key.getKeyCode());
		}

		if(player1Chose && player2Chose) {
			stateManager.setState(2);
		}
	}

	@Override
	public void keyReleased(KeyEvent key) {
		
	}
	
	@Override
	public void keyTyped(KeyEvent key) {
		
	}
	
	private void selectOptionPlayer1(int keyNumber) {
		
	
		if(keyNumber == KeyEvent.VK_W) {
			if(column > 0)
				column--;
			else
				column = 3;
		}
		
		if(keyNumber == KeyEvent.VK_S) {
			if(column < 3)
				column++;
			else
				column = 0;
		}
		
		if(keyNumber == KeyEvent.VK_A) {
			if(row > 0)
				row--;
			else
				row = 3;
		}
		
		if(keyNumber == KeyEvent.VK_D) {
			if(row < 3)
				row++;
			else
				row = 0;
		}
		
		if(keyNumber == KeyEvent.VK_G) {
			player1Chose = true;
			characterP1 = setPortrait(characters[column][row]);
			row = 0;
			column = 0;
			return;
		}
		player1.setX(row);
		player1.setY(column);
		characterP1 =setPortrait(characters[column][row]);
	}
	
	private void selectOptionPlayer2(int keyNumber) {
		if(keyNumber == KeyEvent.VK_UP) {
			if(column > 0)
				column--;
			else
				column = 3;
		}
		
		if(keyNumber == KeyEvent.VK_DOWN) {
			if(column < 3)
				column++;
			else
				column = 0;
		}
		
		if(keyNumber == KeyEvent.VK_LEFT) {
			if(row > 0)
				row--;
			else
				row = 3;
		}
		
		if(keyNumber == KeyEvent.VK_RIGHT) {
			if(row < 3)
				row++;
			else
				row = 0;
			
		}
		
		if(keyNumber == KeyEvent.VK_NUMPAD1) {
			player2Chose = true;
			row = 0;
			column = 0;
			return;
		}
		
		player2.setX(row);
		player2.setY(column);
		characterP2 =setPortrait(characters[column][row]);
	}
	
	private static void fillTable() {
		characters[0][0] = new Character("Ryu");
		characters[0][1] = new Character("Ehonda");
		characters[0][2] = new Character("Blanka");
		characters[0][3] = new Character("Guile");
		characters[1][0] = new Character("Thawk");
		characters[1][1] = new Character("FeiLong");
		characters[1][2] = new Character("DeeJay");
		characters[1][3] = new Character("Cammy");
		characters[2][0] = new Character("Balrog");
		characters[2][1] = new Character("Vega");
		characters[2][2] = new Character("Sagat");
		characters[2][3] = new Character("Mbilson");
		characters[3][0] = new Character("Ken");
		characters[3][1] = new Character("ChunLi");
		characters[3][2] = new Character("Zangief");
		characters[3][3] = new Character("Dhalsim");
	}
	
	private BufferedImage setPortrait(Character character) {
		BufferedImage portrait = null;
		try {
			portrait = ImageIO.read(getClass().getResourceAsStream("/assets/graphics/characters/"+character.toString()+"/portrait.png"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return portrait;
	}

}
