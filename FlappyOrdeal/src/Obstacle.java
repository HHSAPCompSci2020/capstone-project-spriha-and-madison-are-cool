import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.Shape;
import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * Obstacle is a class that represents all the possible obstacles (pipes, moving
 * pipes, diving birds)
 * 
 * Note: obstacles only start moving after the first 4 obstacles are passed
 * 
 * @author Madison Tippett
 */
public class Obstacle extends MovingImage {

	// private ArrayList<Shape> pipes;
	private double xVelocity;
	private int direction;
	private double heightStart;
	private int wiggle;
	public boolean scored = false;

	/**
	 * Creates a constructor for obstacle
	 * 
	 * @param img
	 * @param x   The x coordinate for the obstacle
	 * @param y   The y coordinate for the obstacle
	 * @param w   The width of the obstacle
	 * @param h   The height of the obstacle
	 * @param wiggle How much the obstacle "wiggles" (moves up and down)
	 */
	public Obstacle(double x, double y, double h, int wiggle) {
		super(x, y, 80, h);

		xVelocity = 1;
		direction = 1;
		heightStart = height;
		this.wiggle = wiggle;

//		pipes.add(e);
	}

	/**
	 * Sets the velocity for movement and creates the wiggle
	 */
	public void act() {
		super.x -= xVelocity;

		if (wiggle > 0) {
			height += direction;

			if (height > (heightStart + wiggle)) { // obstacle moves up and down by 100 pixels
				direction = -1;
			} else if (height < (heightStart - wiggle)) {
				direction = 1;
			}
		}

	}

	/**
	 * Returns the dimensions of the bottom rectangle
	 * 
	 * @return bottom rectangle 
	 */
	public Double bottom() {
		return new Rectangle2D.Double(x, y + height + 115, width, 504 - height - 115);
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
