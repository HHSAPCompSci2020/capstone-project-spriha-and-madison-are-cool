import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * FlappyBird is moving image that represents the flappy bird, which can move up
 * or down, lose stamina over a period of time, and gain stamina by eating food
 * 
 * @author sprihapandey
 *
 */
public class FlappyBird extends MovingImage {
	public double stamina;

	/**
	 * Constructs a flappy bird with given coordinates and a stamina of 10
	 * 
	 * @param x The x - coordinate of the top left corner of the bird
	 * @param y The y - coordinate of the top left corner of the bird
	 */
	public FlappyBird(double x, double y) {
		super(x, y, 50.0, 20.0);
		stamina = 10;
	}

	/**
	 * Moves the bird 5 units up
	 */
	public void flap() {
		y -= 5;
	}

	/**
	 * Moves the bird 5 units down
	 */
	public void dive() {
		y += 5;
	}

	/**
	 * Decreases the stamina of the bird, and increases it if the bird collides with
	 * a food object. Moves the bird out of the screen if it loses all of its
	 * stamina or if it intersects the bottom edge of the screen
	 * 
	 * @param food      The list of food objects on the screen
	 * @param obstacles The list of obstacles on the screen
	 * @post Any Food objects the bird collides with are removed from the list
	 */
	public void act(ArrayList<Food> food, ArrayList<Obstacle> obstacles) {
		stamina -= 0.001;
		if (y < 0 || y >= DrawingSurface.DRAWING_HEIGHT || stamina < 0) {
			y += 5;
		}

		// detect when flappy is over some food.
		for (int i = 0; i < food.size(); i++) {
			Food f = food.get(i); // look at each piece of food
			if (f.intersects(this)) { // have we hit it
				food.remove(i); // if yes, removeit
				if (stamina < 1001) // add stamina
					stamina += f.getEnergy();
			}

		}

		// detect if flappy has hit a wall

		for (int i = 0; i < obstacles.size(); i++) {
			Obstacle o = obstacles.get(i); // look at each obstacle
			if (o.intersects(this) || o.bottom().intersects(this)) { // see if we've hit it (?) // or the bottom half
				stamina = 0; // if yes, stop game
			} else { // if not (?) add points
			}
		}

	}

	/**
	 * Draws the bird and displays its stamina on the given PApplet
	 * 
	 * @param p The PApplet on which the bird is drawn
	 * @post The background of the PApplet is set to white
	 */
	public void draw(PApplet p) {
		p.background(255);
		p.rect((float) x, (float) y, (float) width, (float) height);
		p.pushStyle();
		p.fill(0);
		p.textSize(50);
		if (stamina > 0)
			p.text((int) (stamina), 0, 50);
		p.popStyle();
	}
}
