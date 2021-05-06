import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class FlappyBird extends Rectangle2D.Double {
	private double stamina;
	
	public FlappyBird(double x, double y) {
		super(x,y,50.0, 20.0);
		stamina = 1001;	
	}
	
	public void flap() {
		y -= 5;
	}
	
	public void dive() {
		y += 5;
	}
	
	public void act(ArrayList <Food> food, ArrayList <Obstacle> obstacles) {
		stamina -= 0.4;
		for(int i = 0; i < food.size(); i++) {
			Food f = food.get(i);
			if(f.intersects(this)) {
				food.remove(i);
				if(stamina < 1001)
				stamina += f.getEnergy();
			}
				
		}
		if(stamina < 0) {
			y += 5;
		}
	}
	
	public void draw(PApplet p) {
		p.background(255);
		p.rect((float)x, (float)y, (float)width, (float)height);
		p.pushStyle();
		p.fill(0);
		p.textSize(50);
		if(stamina > 0)
			p.text((int) (stamina/100), 0, 50);
		p.popStyle();
	}
}
