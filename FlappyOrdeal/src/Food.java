import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import processing.core.PApplet;
/**
 * The Food class represents objects that the FlappyBird can collect to gain stamina
 * @author sprihapandey
 *
 */
public class Food  extends Rectangle2D.Double{
	private double energy;
	/**
	 * Constructs a Food object with the given coordinates 
	 * @param x The x - coordinate of the top left corner of the food
	 * @param y The y - coordinate of the top left corner of the food
	 */
	public Food(double x, double y) {
		super(x, y, 30, 30);
		energy = 5;
	}
	/**
	 * Returns the value of the energy that the food provides to the bird
	 * @return The value of the energy that the food provides to the bird
	 */
	public double getEnergy() {
		return energy;
	}
	/**
	 * Moves the Food to the left
	 */
	public void act() {
		super.x -= 1;
	}
	/**
	 * Draws the Food object on the given PApplet
	 * @param surface The PApplet on which the Food is drawn
	 */
	public void draw(PApplet surface) {
		surface.rect((float)x, (float)y, 30f, 30f);
	}
}
