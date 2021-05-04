import java.awt.Image;
import java.awt.Rectangle;

import processing.core.PApplet;

public class Food {
	private double x, y;
	private double energy;
	
	public Food(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public double getEnergy() {
		return energy;
	}
	
	public void draw(PApplet surface) {
		surface.rect((float)x, (float)y, 30f, 30f);
	}
}
