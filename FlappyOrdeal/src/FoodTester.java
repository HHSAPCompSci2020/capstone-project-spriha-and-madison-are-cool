import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class FoodTester extends PApplet {
	private FlappyBird flappyBird;
	ArrayList <Food> foods = new ArrayList<Food>() ;
	private ArrayList<Integer> keys;
	private boolean start;
	private Rectangle screenRect;
	public static final int DRAWING_WIDTH = 900;
	public static final int DRAWING_HEIGHT = 504;

	
	public FoodTester() {
		flappyBird = new FlappyBird(150, 50);
		foods.add(new Food(150, 100));
		foods.add(new Food(500, 110));
		keys = new ArrayList <Integer>();
		screenRect = new Rectangle(0, 0, DRAWING_WIDTH,DRAWING_HEIGHT);
	}
	
	private void newFood(Food f) {
		f = new Food(DRAWING_WIDTH, Math.random() * (DRAWING_HEIGHT - 100));
		foods.add(f);
	}
	public void settings() {
		  size(DRAWING_WIDTH, DRAWING_HEIGHT);
	}
	
	public void draw() {
		if(foods.isEmpty()) {
			newFood(new Food(0, 0));
		}
		flappyBird.draw(this);
		for(int i = 0; i < foods.size(); i++) {
			Food food = foods.get(i);
			food.draw(this);
			if(start)
			food.act();
			if(!food.intersects(screenRect)) {
				while(foods.size() < 3) {
					newFood(food);
				}
			}
			
		}
		
		
		if(isPressed(KeyEvent.VK_SPACE))
			start = true;
		if (isPressed(KeyEvent.VK_UP) && start)
			flappyBird.flap();
		if(isPressed(KeyEvent.VK_DOWN) && start)
			flappyBird.dive();
		if(start)
		flappyBird.act(foods, new ArrayList <Obstacle>());
		//flappyBird.act(foods, new ArrayList <Obstacle>());
		
		
	}
	
	
	public void keyPressed() {
		keys.add(keyCode);
	}

	public void keyReleased() {
		while(keys.contains(keyCode))
			keys.remove(new Integer(keyCode));
	}

	public boolean isPressed(Integer code) {
		return keys.contains(code);
	}
}
