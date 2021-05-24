import java.awt.Event;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import processing.core.PApplet;
import processing.core.PImage;

public class GameWorld {
	private GameLevel gameLevel;

	private int startY;
	private int width;
	private int height;

	public int scoreIncrement = 1;

	private FlappyBird bird;
	private boolean flapOn;
	private boolean diveOn;

	private ArrayList<Food> foods;
	private ArrayList<Food> removedFoods;

	private ArrayList<Obstacle> obstacles;
	private ArrayList<Obstacle> removedObstacles;

	private background back;

	private ArrayList<PowerUp> powerUps;
	private ArrayList<PowerUp> removedPowerUps;
	private ArrayList<PowerUp> activePowerUps;
	private ArrayList<PowerUp> removeActivePowerUps;

	private int generateCounter;
	private int generatedCount;
	private boolean levelUp;
	private boolean gameOver;
	private boolean start;
	public int counter = 0;

	public GameWorld(int y, int width, int height) {
		back = new background(0, 0);
		gameLevel = new GameLevel();
		this.startY = y;
		this.width = width;
		this.height = height;
		this.bird = new FlappyBird(width / 2, height / 2);
		flapOn = false;
		diveOn = false;

		foods = new ArrayList<Food>();
		removedFoods = new ArrayList<Food>();
		generateCounter = GameLevel.GENERATE_AFTER;
		generatedCount = 0;
		levelUp = false;
		gameOver = false;

		obstacles = new ArrayList<Obstacle>();
		removedObstacles = new ArrayList<Obstacle>();

		powerUps = new ArrayList<PowerUp>();
		removedPowerUps = new ArrayList<PowerUp>();
		activePowerUps = new ArrayList<PowerUp>();
		removeActivePowerUps = new ArrayList<PowerUp>();

	}

	public FlappyBird getBird() {
		return bird;
	}

	private void updateFoods() {
		for (Food f : removedFoods) {
			foods.remove(f);
		}
	}

	private void updatePowerUps() {
		for (PowerUp p : removedPowerUps) {
			powerUps.remove(p);
		}
	}

	private void updateActivePowerUps() {
		for (PowerUp p : removeActivePowerUps) {
			activePowerUps.remove(p);
		}
	}

	public void draw(FlappyBirdGame app) {
		if (start) {
			if (checkForLevel(app)) {
				return;
			}

			if (bird.getStamina() == 0) {
				gameOver = true;
			}
			app.pushStyle();
			app.rect(0, startY, width, height);
			back.draw(app, gameLevel.getSpeed());
			for (Food f : foods) {
				f.draw(app);
				if (bird.ate(f)) {
					removedFoods.add(f);
				} else if (!f.move(gameLevel.getSpeed())) {
					removedFoods.add(f);
				}
			}

			for (Obstacle o : obstacles) {
				o.draw(app);
				if (o.hit(bird)) {
					removedObstacles.add(o);
					gameOver = true;
				} else if (!o.move(gameLevel.getSpeed())) {
					removedObstacles.add(o);
				}

				bird.incrementScore(o, scoreIncrement); // checks to see if got a score powerup, adds 2 if yes
			}

			for (PowerUp p : powerUps) {
				p.draw(app);
				if (bird.poweredUp(p)) {
					removedPowerUps.add(p);
					activePowerUps.add(p);
					if (p.typeOfPowerUp() == 1) {
						bird.updateStamina(1000);
					} else if (p.typeOfPowerUp() == 2) {
						
					} else if (p.typeOfPowerUp() == 3) {
						scoreIncrement = 2;
					}
				} else if (!p.move(gameLevel.getSpeed())) {
					removedPowerUps.add(p);

				}
			}

			if (generateCounter <= 0) { // need to add powerups after finishing code
				// Generate Obstacle
				generateCounter = GameLevel.GENERATE_AFTER;
				generatedCount++;

				// System.out.println(activePowerUps);
				for (PowerUp p : activePowerUps) {
					// p.tick(); // get how much time is left
					int timeRemaining = p.tick();

					if (timeRemaining == 0) {
						// System.out.println("removed p");
						removeActivePowerUps.add(p);
						if (p.typeOfPowerUp() == 3) {
							scoreIncrement = 1;
						}
					}
				}
				obstacles.add(new Obstacle(width, startY, height));
			} else if (generateCounter % (GameLevel.GENERATE_AFTER / gameLevel.getFoodFrequency()) == 0) {
				// Generate Food
				foods.add(new Food(width, startY, height));
			} else if (generateCounter == 30) {
				powerUps.add(new PowerUp(width, startY, height));
			}

			generateCounter--;

			bird.draw(app, flapOn, diveOn, startY, height);

			app.popStyle();
			this.updateFoods();
			this.updatePowerUps();
			this.updateActivePowerUps();

		} else {
			int answer = JOptionPane.showConfirmDialog(null, "Play?", "FLAPPY ORDEAL", JOptionPane.YES_OPTION);
			if (answer == JOptionPane.YES_OPTION)
				start = true;
			else {
				start = false;
				System.exit(0);
			}
		}

	}

	private boolean checkForLevel(FlappyBirdGame app) {
		if (gameOver) {
			app.pushStyle();
			levelUp = true;
			gameOver = true;
			int answer = JOptionPane.showConfirmDialog(null, "Play Again?", "GAME OVER", JOptionPane.YES_NO_OPTION);
			if (answer == JOptionPane.YES_OPTION) {
				if (gameOver) {
					bird.setScore(0);
					gameOver = false;
					levelUp = false;
					bird.updateStamina(1000);
					this.removedFoods.clear();
					this.removedObstacles.clear();
					this.foods.clear();
					this.obstacles.clear();

					this.powerUps.clear();
					this.removedPowerUps.clear();
					this.activePowerUps.clear();
					this.removeActivePowerUps.clear();
				}
			}

			else if (answer == JOptionPane.NO_OPTION || answer == JOptionPane.CLOSED_OPTION) {
				System.exit(0);
			}

			return true;
		}
		return false;
	}

	public void keyPressed(int keyCode) {
		if (keyCode == KeyEvent.VK_UP) {
			flapOn = true;
			diveOn = false;
		} else if (keyCode == KeyEvent.VK_DOWN) {
			diveOn = true;
			flapOn = false;
		}
	}

	public void keyReleased(int keyCode) {
		if (keyCode == KeyEvent.VK_UP) {
			flapOn = false;
		} else if (keyCode == KeyEvent.VK_DOWN) {
			diveOn = false;
		}
	}

}
