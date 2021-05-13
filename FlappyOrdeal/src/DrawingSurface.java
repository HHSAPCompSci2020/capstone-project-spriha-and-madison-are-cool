import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class DrawingSurface extends PApplet {
	private FlappyBird flappyBird;
	ArrayList<Food> foods = new ArrayList<Food>();
	ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
	private ArrayList<Integer> keys;
	private boolean start;
	private boolean end;
	private Rectangle screenRect;
	public static final int DRAWING_WIDTH = 900;
	public static final int DRAWING_HEIGHT = 504;
	private int wiggle = 5;

	public DrawingSurface() {
		flappyBird = new FlappyBird(150, 50);
		foods.add(new Food(150, 100));
		foods.add(new Food(500, 110)); // add a food to the world
		keys = new ArrayList<Integer>();
		screenRect = new Rectangle(0, 0, DRAWING_WIDTH, DRAWING_HEIGHT);

		obstacles.add(new Obstacle(825, 0, 75, Math.random() * 215 + 100, 0)); // add an obstacle to the world
		obstacles.add(new Obstacle(1075, 0, 75, Math.random() * 215 + 100, 0)); // add an obstacle to the world
		obstacles.add(new Obstacle(1325, 0, 75, Math.random() * 215 + 100, 0)); // add an obstacle to the world
		obstacles.add(new Obstacle(1575, 0, 75, Math.random() * 215 + 100, 0)); // add an obstacle to the world

	}

	private void newFood(Food f) {
		f = new Food(DRAWING_WIDTH, Math.random() * (DRAWING_HEIGHT - 100));
		foods.add(f);
	}

	private void newObstacle(Obstacle o) {
		o = new Obstacle(DRAWING_WIDTH, 0, 75, Math.random() * 215 + 100, wiggle++);
		obstacles.add(o);
	}

	public void settings() {
		size(DRAWING_WIDTH, DRAWING_HEIGHT);
	}

	public void draw() {
		if (foods.isEmpty()) {
			newFood(new Food(0, 0));
		}
		flappyBird.draw(this);

		for (int i = 0; i < obstacles.size(); i++) {
			Obstacle obstacle = obstacles.get(i); // this line is supposed to get i
			obstacle.draw(this);
			if (start) {
				obstacle.act();
			}
			if (obstacle.x < -80) {
				obstacles.remove(i);
				newObstacle(obstacle);
			}
		}
		for (int i = 0; i < foods.size(); i++) {
			Food food = foods.get(i); // get the food at index i from foods.
			food.draw(this);
			if (start)
				food.act();
			if (!food.intersects(screenRect)) {
				foods.remove(i);
				while (foods.size() < 4) {
					newFood(food);
				}
			}

		}

		if (isPressed(KeyEvent.VK_SPACE))
			start = true;
		if (isPressed(KeyEvent.VK_UP) && start)
			flappyBird.flap();
		if (isPressed(KeyEvent.VK_DOWN) && start)
			flappyBird.dive();
		if (start)
			flappyBird.act(foods, obstacles);
		// if flappyBird has no stamina, start equals false and game stops
		if (flappyBird.stamina <= 0) {
			start = false;
		}

	}

	public void keyPressed() {
		keys.add(keyCode);
	}

	public void keyReleased() {
		while (keys.contains(keyCode))
			keys.remove(new Integer(keyCode));
	}

	public boolean isPressed(Integer code) {
		return keys.contains(code);
	}
}
