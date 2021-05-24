import java.awt.geom.Rectangle2D;
import java.util.Random;
/**
 * Represents an obstacle, two pipes in the same horizontal position with a certain amount of space between them
 * @author Madison Tippett
 *
 */
public class Obstacle extends Rectangle2D.Double {
	private static int OBSTACLE_WIDTH = 100;
	private static int OBSTACLE_GAP = 115;

	private Rectangle2D.Double topRect;
	private Rectangle2D.Double bottomRect;
	private float shiftIncrement;
	private int minShiftExtent;
	private int maxShiftExtent;
	/**
	 * Boolean value representing whether or not the FlappyBird has dodged the obstacle and earned a point
	 */
	public boolean scored;
	private boolean move;

	public static int elevationInterval;
	/**
	 * Constructs an obstacle consisting of two images with a certain amount of space between them, one above the other. The images have the same x - coordinates and width. 
	 * The y - coordinates and height vary for each image.   
	 * @param x the x coordinate of the two images
	 * @param y the y coordinate of the image on top
	 * @param height the height of the image on top
	 */
	public Obstacle(int x, int y, int height) {
		super(x, y, OBSTACLE_WIDTH, height);
		double topHeight = Math.random() * (0.69 * height) + 0.01 * height;
		double space = OBSTACLE_GAP;
		double bottomY = y + topHeight + space;
		double bottomHeight = FlappyBirdGame.DRAWING_HEIGHT - (y + topHeight + space);
		topRect = new Rectangle2D.Double(x, y, width, topHeight);
		bottomRect = new Rectangle2D.Double(x, bottomY, width, bottomHeight);
		shiftIncrement = (float) -1.5;
		minShiftExtent = 50;
		maxShiftExtent = height - 50;
		Random r = new Random();
		move = r.nextBoolean();
	}
	/**
	 * Returns true if a given FlappyBird object collides with an obstacle, false otherwise
	 * @param b the FlappyBird collision is checked with
	 * @return true if bird object collides with an obstacle, false otherwise
	 */
	public boolean hit(FlappyBird b) {
		Rectangle2D.Double intersectRect = new Rectangle2D.Double((float) b.getX() + 15, (float) b.getY() + 10,
				(float) b.getWidth() - 35, (float) b.getHeight() - 20);
		if (topRect.intersects(intersectRect) || bottomRect.intersects(intersectRect)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Moves the obstacle in the horizontal direction with given speed
	 * @param speed the speed of the obstacle
	 * @return true if the obstacle is in the window, false otherwise
	 */
	public boolean move(int speed) {
		topRect.x -= speed;
		bottomRect.x -= speed;
		if (topRect.x < -OBSTACLE_WIDTH) {
			return false;
		}
		return true;
	}
	/**
	 * Moves the opening between the two images in the obstacle up and down
	 */
	public void shiftOpening() {
		double topHeight = topRect.height;
		double bottomY = bottomRect.y;

		if (shiftIncrement < 0 && topHeight >= minShiftExtent) {
			topRect.height += shiftIncrement;
			bottomRect.y += shiftIncrement;
			bottomRect.height -= shiftIncrement;
		} else if (shiftIncrement > 0 && bottomY <= maxShiftExtent) {
			topRect.height += shiftIncrement;
			bottomRect.y += shiftIncrement;
			bottomRect.height -= shiftIncrement;
		} else {
			shiftIncrement = -shiftIncrement;
		}
	}
	/**
	 * Returns the rectangle representing the opening between the two images
	 * @return
	 */
	public Rectangle2D.Double getEmptySpaceRectangle() {
		return new Rectangle2D.Double(topRect.x, topRect.y + topRect.height, OBSTACLE_WIDTH, OBSTACLE_GAP);
	}
	/**
	 * Draws the two images on the given FlappyBirdGame and moves them if necessary
	 * @param app the PApplet on which the Obstacle is drawn
	 */
	public void draw(FlappyBirdGame app) { // collision only works for first obstacle
		app.pushStyle();
		app.image(app.getObstacleTopImage(), (float) topRect.x, (float) topRect.y, (float) topRect.width,
				(float) topRect.height);
		app.image(app.getObstacleBottomImage(), (float) bottomRect.x, (float) bottomRect.y, (float) bottomRect.width,
				(float) bottomRect.height);

		int min = (int) (Math.random() * (0.4 * FlappyBirdGame.DRAWING_HEIGHT) + 0.1 * FlappyBirdGame.DRAWING_HEIGHT);
		if (move)
			shiftOpening();
		app.popStyle();
	}
}
