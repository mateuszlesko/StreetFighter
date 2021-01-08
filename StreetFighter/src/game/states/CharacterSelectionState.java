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
	
	private BufferedImage portraitPlayer1,portraitPlayer2;
	private Character character1, character2;
	
	private Color regularColor;
	private Font regularFont;
	
	private static Character[][] characters = new Character[4][4];
	private static int column = 0;
	private static int row = 0;
	
	private boolean player1Chose = false;
	private boolean player2Chose = false;
	
	//przechowywanie wybranej postaci
	Vector<Integer,Integer> player1;
	Vector<Integer,Integer> player2;
	
	public CharacterSelectionState(StateManager _stateManager) {
		stateManager = _stateManager; //refencja do tego samego obiektu zarzadcy stanu, ktory jest uzywany
		fillTable() ;
		player1 = new Vector(column,row);
		player2 = new Vector(column,row);
		try {
			background = new BackgroundTheme("/assets/graphics/backgrounds/selectionTheme.png",1);
			background.setPosition(0,0);
			regularColor = new Color(252, 244, 5);
			regularFont = new Font("Arial",Font.PLAIN,24);
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
		
		character1 = characters[player1.getY()][player1.getX()]; 
		//character1.setPath();
		character2 = characters[player2.getY()][player2.getX()];
		//character2.setPath();
		//portraitPlayer1 = ImageIO.read(getClass().getResourceAsStream(character1.getPath()));
	//	portraitPlayer1 = ImageIO.read(getClass().getResourceAsStream(character2.getPath()));
//		
		//graphic.drawImage(portraitPlayer1, 20, 10,null);
//		graphic.drawImage(portraitPlayer2, 0, 0,null);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update() {
		//background.update();
	}

	@Override
	public void keyPressed(int keyNumber) {
	
		if(player1Chose == false && player2Chose == false) {
			selectOptionPlayer1(keyNumber);
		}
		
		player2Chose = false;
		
		if(player1Chose == true && player2Chose == false) {
			selectOptionPlayer2(keyNumber);
		}
		
		if(player1Chose && player2Chose) {
			//stateManager.setState(2);
		}
	}

	@Override
	public void keyReleased(int keyNumber) {
		// TODO Auto-generated method stub
		
	}
	
	private void selectOptionPlayer1(int keyNumber) {
		
	
		if(keyNumber == KeyEvent.VK_W) {
			if(column > 0)
				column--;
			else
				column = 3;
		}
		
		if(keyNumber == KeyEvent.VK_S) {
			if(column < 4)
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
			if(row < 4)
				row++;
			else
				row = 0;
		}
		
		if(keyNumber == KeyEvent.VK_ENTER) {
			
			player1Chose = true;
			row = 0;
			column = 0;
			return;
		}
		
		player1.setX(row);
		player1.setY(column);
	}
	
	private void selectOptionPlayer2(int keyNumber) {
		if(keyNumber == KeyEvent.VK_UP) {
			if(column > 0)
				column--;
			else
				column = 3;
		}
		
		if(keyNumber == KeyEvent.VK_DOWN) {
			if(column < 4)
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
			if(row < 4)
				row++;
			else
				row = 0;
			
		}
		
		if(keyNumber == KeyEvent.VK_ENTER) {
			player2Chose = true;
			row = 0;
			column = 0;
			return;
		
		}
		player2.setX(row);
		player2.setY(column);
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

}
