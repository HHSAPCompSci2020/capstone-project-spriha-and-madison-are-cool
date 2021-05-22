import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class FlappyBirdGame extends PApplet {
	public static final int DRAWING_WIDTH = 900;
	public static final int DRAWING_HEIGHT = 504;
	public static final int STATUS_HEIGHT = 50;
	
	private StatusBar statusBar ;
	private GameWorld gameWorld ;
	private PImage birdImage;
	private PImage obstacleTopImage;
	private PImage obstacleBottomImage;
	private PImage foodImage;
	private PImage backgroundImage;

	public void settings() {
		size(DRAWING_WIDTH, DRAWING_HEIGHT);
	}

	public FlappyBirdGame() {	
		statusBar = new StatusBar(DRAWING_WIDTH,STATUS_HEIGHT) ;
		gameWorld = new GameWorld(STATUS_HEIGHT, DRAWING_WIDTH, DRAWING_HEIGHT - STATUS_HEIGHT);
		statusBar.setBird(gameWorld.getBird());
	}
	public void setup() {
		birdImage = loadImage("FlappyBird.png");
		obstacleTopImage = loadImage("obstacle-top.png");
		obstacleBottomImage = loadImage("obstacle-bottom.png");
		foodImage = loadImage("Food.png");
		backgroundImage = loadImage("background.png");
	}
	
	public PImage getBirdImage() {
		return this.birdImage;
	}
	
	public PImage getObstacleTopImage() {
		return this.obstacleTopImage;
	}
	
	public PImage getObstacleBottomImage() {
		return this.obstacleBottomImage;
	}

	public PImage getBackgroundImage() {
		return this.backgroundImage;
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
