import java.awt.Rectangle;
import java.awt.Shape;
import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PImage;

/*
 * Obstacle is a class that represents all the possible obstacles (pipes, moving pipes, diving birds)
 * @author Madison Tippett
 */
public class Obstacle extends MovingImage {

	private ArrayList<Shape> pipes;

	/*
	 * Creats a constructor for obstacle
	 * 
	 * @param img
	 * @param x The x coordinate for the obstacle
	 * @param y The y coordinate for the obstacle
	 * @param w The width of the obstacle
	 * @param h The height of the obstacle
	 */
	public Obstacle(PImage img, int x, int y, int w, int h) {
		super(img, x, y, w, h);
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * Draws the obstacle and displays the obstacles on the PApplet
	 * 
	 * @param p The PApplet on which the bird is drawn
	 */
	public void draw(PApplet p) {
		pipes = new ArrayList<Shape>();
		pipes.add(new Rectangle(50, 0, 50, 100));
		pipes.add(new Rectangle(50, 350, 50, 500));
		pipes.add(new Rectangle(200, 0, 200, 200));
		pipes.add(new Rectangle(200, 0, 200, 400));

	}

}
