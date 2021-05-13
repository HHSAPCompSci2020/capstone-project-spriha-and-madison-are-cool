import java.awt.Rectangle;
import java.awt.Shape;
import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * Obstacle is a class that represents all the possible obstacles (pipes, moving pipes, diving birds)
 * @author Madison Tippett
 */
public class Obstacle extends MovingImage {

	// private ArrayList<Shape> pipes;
	private double xVelocity;

	/**
	 * Creates a constructor for obstacle
	 * 
	 * @param img
	 * @param x The x coordinate for the obstacle
	 * @param y The y coordinate for the obstacle
	 * @param w The width of the obstacle
	 * @param h The height of the obstacle
	 */
	public Obstacle(double x, double y, double w, double h) {
		super(x, y, w, h);
		
		xVelocity = 1;
		
//		pipes.add(e);
	}
	
	public void act() {
		super.x -= xVelocity;
		
	}
	
	/**
	 * Draws the obstacle and displays the obstacles on the PApplet
	 * 
	 * @param p The PApplet on which the bird is drawn
	 */
	public void draw(PApplet p) {
		
		
		// work out the height of the remainder
		// y = 504 - height - 115
		float height2 = (float) (504 - height - 115);
		
		p.fill(0, 255, 0);
		p.rect((float) x, (float) y, (float) width, (float) height);
		p.rect((float) x, (float) (y + height + 115), (float) width, (float) height2);
		p.noFill();


	}

}
