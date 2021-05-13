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
	private Rectangle2D.Double topRect ;
	private Rectangle2D.Double bottomRect ;
	private float shiftIncrement ;
	private int minShiftExtent ;
	private int maxShiftExtent ;

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
<<<<<<< HEAD
	public Obstacle(double x, double y, double h) {
		super(x, y, 80, h);
		double topHeight = Math.random() * (0.69 * height) + 0.01 * height;
		double space = 100 ;
		double bottomY = y + topHeight + space;
		double bottomHeight = FlappyBirdGame.DRAWING_HEIGHT - (y + topHeight + space);
		topRect = new Rectangle2D.Double(x, y, width, topHeight);
		bottomRect = new Rectangle2D.Double(x, bottomY, width, bottomHeight);
		shiftIncrement = (float) -1 ;
		minShiftExtent = 50 ;
		maxShiftExtent = (int)height - 50 ;
=======
	public Obstacle(double x, double y, double w, double h, int wiggle) {
		super(x, y, w, h);

>>>>>>> parent of ccc30bc (Update)
		xVelocity = 1;
		direction = 1;
		heightStart = height;
		this.wiggle = wiggle;

//		pipes.add(e);
	}

	/**
	 * Sets the velocity for movement and creates the wiggle
	 */
	public boolean hit(FlappyBird b) {
		if(topRect.intersects(b) || bottomRect.intersects(b)) {
			return true ;
		}
		return false ;
	}


	public boolean move(int speed) {
		topRect.x -= speed ;
		bottomRect.x -= speed ;
		if(topRect.x < -80) {
			return false ;
		}
		return true ;
	}
	
	public void shiftOpening() {
		double topHeight = topRect.height;
		double bottomY = bottomRect.y;
		
		if(shiftIncrement < 0 && topHeight >= minShiftExtent) {
			topRect.height += shiftIncrement ;
			bottomRect.y += shiftIncrement ;
			bottomRect.height -= shiftIncrement ;
		} else if(shiftIncrement > 0 && bottomY <= maxShiftExtent) {
				topRect.height += shiftIncrement ;
				bottomRect.y += shiftIncrement ;
				bottomRect.height -= shiftIncrement ;
		} else {
			shiftIncrement = -shiftIncrement ;
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
