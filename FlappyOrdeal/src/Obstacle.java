import java.awt.geom.Rectangle2D;
import java.util.Random;

public class Obstacle extends MovingImage {
	private static int OBSTACLE_WIDTH = 80;
	private static int OBSTACLE_GAP = 150;

	private Rectangle2D.Double topRect;
	private Rectangle2D.Double bottomRect;
	private float shiftIncrement;
	private int minShiftExtent;
	private int maxShiftExtent;

	public static int elevationInterval;

	public Obstacle(int x, int y, int height) {
		super(x, y, OBSTACLE_WIDTH, height);
		double topHeight = Math.random() * (0.69 * height) + 0.01 * height;
		double space = OBSTACLE_GAP;
		double bottomY = y + topHeight + space;
		double bottomHeight = FlappyBirdGame.DRAWING_HEIGHT - (y + topHeight + space);
		topRect = new Rectangle2D.Double(x, y, width, topHeight);
		bottomRect = new Rectangle2D.Double(x, bottomY, width, bottomHeight);
		shiftIncrement = (float) -1;
		minShiftExtent = 50;
		maxShiftExtent = height - 50;
	}

	public boolean hit(FlappyBird b) {
		if (topRect.intersects(b) || bottomRect.intersects(b)) {
			return true;
		}
		return false;
	}

	public boolean move(int speed) {
		topRect.x -= speed;
		bottomRect.x -= speed;
		if (topRect.x < -OBSTACLE_WIDTH) {
			return false;
		}
		return true;
	}

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

	public void draw(FlappyBirdGame app) {
		app.pushStyle();

		app.fill(255);
		app.rect((float) topRect.x, (float) topRect.y, (float) topRect.width, (float) topRect.height);
		app.rect((float) bottomRect.x, (float) bottomRect.y, (float) bottomRect.width, (float) bottomRect.height);
		int min = (int) (Math.random() * (0.4 * FlappyBirdGame.DRAWING_HEIGHT) + 0.1 * FlappyBirdGame.DRAWING_HEIGHT);
		// shiftOpening(1.5, (int) (Math.random() * (0.4*FlappyBirdGame.DRAWING_HEIGHT)
		// + 0.1*FlappyBirdGame.DRAWING_HEIGHT), min + 300/*(int)(Math.random() *
		// (0.4*FlappyBirdGame.DRAWING_HEIGHT) + 0.5)*/);
		shiftOpening();
		app.popStyle();
	}
}
