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
	private PImage birdImage;
	private PImage obstacleImage;
	private PImage foodImage;

	public void settings() {
		size(DRAWING_WIDTH, DRAWING_HEIGHT);
	}

	public FlappyBirdGame() {	
		statusBar = new StatusBar(DRAWING_WIDTH,STATUS_HEIGHT) ;
		gameWorld = new GameWorld(STATUS_HEIGHT, DRAWING_WIDTH, DRAWING_HEIGHT - STATUS_HEIGHT);
		statusBar.setBird(gameWorld.getBird());
	}
	public void setup() {
		birdImage = loadImage("unnamed.png");
		obstacleImage = loadImage("obstacle.png");
		foodImage = loadImage("Food.png");
	}
	
	public PImage getBirdImage() {
		return this.birdImage;
	}
	
	public PImage getObstacleImage() {
		return this.obstacleImage;
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

	public PImage getFoodImage() {
		// TODO Auto-generated method stub
		return foodImage;
	}

}
