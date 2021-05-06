import java.awt.Rectangle;
import java.awt.Shape;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class Obstacle extends MovingImage {

	public Obstacle(PImage img, int x, int y, int w, int h) {
		super(img, x, y, w, h);
		// TODO Auto-generated constructor stub
	}

	private ArrayList<Shape> pipes;

	public void draw(PApplet p) {
		pipes = new ArrayList<Shape>();
		pipes.add(new Rectangle(50, 0, 50, 100));
		pipes.add(new Rectangle(50, 350, 50, 500));
		pipes.add(new Rectangle(200, 0, 200, 200));
		pipes.add(new Rectangle(200, 0, 200, 400));

	}

}
