import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class FlappyBirdGame extends PApplet {
	public static final int DRAWING_WIDTH = 900;
	public static final int DRAWING_HEIGHT = 500;
	public static final int STATUS_HEIGHT = 50;
	
	private StatusBar statusBar ;
	private GameWorld gameWorld ;

	public void settings() {
		size(DRAWING_WIDTH, DRAWING_HEIGHT);
	}

	public FlappyBirdGame() {		
		statusBar = new StatusBar(DRAWING_WIDTH,STATUS_HEIGHT) ;
		gameWorld = new GameWorld(STATUS_HEIGHT, DRAWING_WIDTH, DRAWING_HEIGHT - STATUS_HEIGHT);
		statusBar.setBird(gameWorld.getBird());
	}

	public void draw() {
		this.background(255);
		gameWorld.draw(this);
		statusBar.draw(this);
	}
	
	public void keyPressed() {
		gameWorld.keyPressed(keyCode);
	}

	public void keyReleased() {
		gameWorld.keyReleased(keyCode);
	}

}
