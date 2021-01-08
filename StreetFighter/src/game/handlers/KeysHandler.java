package game.handlers;

import java.awt.event.KeyEvent;

public class KeysHandler {
	
	public static final int numKeys = 12;
	// 2 tablice do przechowywania stanow dla obu graczy
	public static boolean keyStates1[], keyStates2[] = new boolean[numKeys];
	public static boolean previousKeyStates1[], previousKeyStates2[] = new boolean[numKeys];
	
	//dla gracza nr 1 i 2; przechowywanie numerow klawiszy:
	public static int up = 0; //w ; strza³ka w góre
	public static int down = 1; //s ; strza³ka w dó³
	public static int right = 2; //d ; strza³ka w prawo
	public static int left = 3; //a ; strza³ka w lewo
	public static int kick = 4; //h ; 1
	public static int block = 5;//j ; 2
	public static int punch = 6; //k ; 3
	


	public static void keySet(int keyNumber, boolean b, boolean isPlayer1) {
		if(isPlayer1)
			keySetForPlayer1(keyNumber,b);
		else
			keySetForPlayer2(keyNumber,b);
	}
	
	private static void keySetForPlayer1(int keyNumber, boolean b) {
		switch(keyNumber) {
			case KeyEvent.VK_W:
				keyStates1[up] = b;
				break;
			case KeyEvent.VK_S:
				keyStates1[down] = b;
				break;
			case KeyEvent.VK_D:
				keyStates1[right] = b;
				break;
			case KeyEvent.VK_A:
				keyStates1[left] = b;
				break;
			case KeyEvent.VK_H:
				keyStates1[kick] = b;
				break;
			case KeyEvent.VK_J:
				keyStates1[block] = b;
				break;
			case KeyEvent.VK_K:
				keyStates1[punch] = b;
				break;
			default:
				break;
		}
	}
	
	private static void keySetForPlayer2(int keyNumber, boolean b) {
		switch(keyNumber) {
			case KeyEvent.VK_UP:
				keyStates1[up] = b;
				break;
			case KeyEvent.VK_DOWN:
				keyStates1[down] = b;
				break;
			case KeyEvent.VK_RIGHT:
				keyStates1[right] = b;
				break;
			case KeyEvent.VK_LEFT:
				keyStates1[left] = b;
				break;
			case KeyEvent.VK_NUMPAD1:
				keyStates1[kick] = b;
				break;
			case KeyEvent.VK_NUMPAD2:
				keyStates1[block] = b;
				break;
			case KeyEvent.VK_NUMPAD3:
				keyStates1[punch] = b;
				break;
			default:
				break;
		}
	}
}
