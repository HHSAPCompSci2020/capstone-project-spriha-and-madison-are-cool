import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import processing.core.PApplet;

public class Food  extends Rectangle2D.Double{
	private double energy;
	
	public Food(double x, double y) {
		super(x, y, 30, 30);
		energy = 100;
	}
	
	public double getEnergy() {
		return energy;
	}
	
	public void act() {
		super.x -= 1;
	}
	
	public void draw(PApplet surface) {
		surface.rect((float)x, (float)y, 30f, 30f);
	}
}
