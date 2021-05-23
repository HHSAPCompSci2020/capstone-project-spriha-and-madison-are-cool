import java.awt.geom.Rectangle2D;
import processing.core.PApplet;
import processing.core.PImage;

/* 
 * Represents a moving image
 * 
 * @author Madison Tippett
 */

public class MovingImage extends Rectangle2D.Double {
	private PImage image;

	/**
	 * Constructor for the MovingImage
	 * 
	 * @param x The x coordinate for the moving image
	 * @param y The y coordinate for the moving image
	 * @param w The width of the moving image
	 * @param h The height of the moving image
	 */
	public MovingImage(double x, double y, double w, double h) {
		super(x, y, w, h);
		//image = img;
	}

	/**
	 * Moves the image to (x, y)
	 * 
	 * @param x the new x coordinate of the image
	 * @param y the new y coordinate of the image
	 */
	
	public void moveToLocation(double x, double y) {
		super.x = x;
		super.y = y;
	}
	
	/**
	 * Moves the image by x, y amount
	 * 
	 * @param x the new x coordinate of the image
	 * @param y the new y coordinate of the image
	 */
	public void moveByAmount(double x, double y) {
		super.x += x;
		super.y += y;
	}

	/**
	 * Applies the window limits for the MovingImage
	 * 
	 * @param windowWidth the width of the window
	 * @param windowHeight the height of the window
	 */
	public void applyWindowLimits(int windowWidth, int windowHeight) {
		x = Math.min(x, windowWidth - width);
		y = Math.min(y, windowHeight - height);
		x = Math.max(0, x);
		y = Math.max(0, y);
	}

	/**
	 * Draws the moving image
	 * 
	 * @param p The PApplet which to draw on
	 */
	public void draw(FlappyBirdGame app) {
		//app.image(app.getMovingImage(), (int) x, (int) y, (int) width, (int) height);
	}
}
