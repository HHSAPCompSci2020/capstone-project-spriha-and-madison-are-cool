import processing.core.PApplet;

public class FoodSurface extends PApplet {
	
	public void draw() {
		Food food = new Food(150, 100);
		food.draw(this);
	}
}
