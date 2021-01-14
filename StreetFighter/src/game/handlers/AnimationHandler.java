package game.handlers;

import java.awt.Image;
import java.awt.image.BufferedImage;

public class AnimationHandler {
	private BufferedImage[] frames;
	private int currentFrame;
	private int numberOfFrames;
	private int count;
	private int delay;
	private int timesPlayed;
	
	public AnimationHandler() {
		timesPlayed = 0;
	}
	
	public void setFrames(BufferedImage [] _frames) {
		frames = _frames;
		currentFrame = 0;
		count = 0;
		timesPlayed = 0;
		delay = 2;
		numberOfFrames = _frames.length;
	}
	
	public boolean hasPlayedOnce() { return timesPlayed > 0;}
	public boolean hasPlayed(int times) {return timesPlayed == times;}
	
	public int getCurrentFrame() { return currentFrame;}
	public int getCount() {return count;}
	public Image getImage() {return frames[currentFrame];}
	
	public void setDelay(int _delay) {delay = _delay;}
	public void setFrame(int _frame) {currentFrame = _frame;}
	public void setNumberOfFrames( int _number) {numberOfFrames = _number;}
	
	public void update() {
		if(delay == -1)
			return;
		
		count++;
		
		if(count == delay) {
			currentFrame++;
			count++;
		}
		if(currentFrame == numberOfFrames) {
			currentFrame = 0;
			timesPlayed++;
		}
	}
}
