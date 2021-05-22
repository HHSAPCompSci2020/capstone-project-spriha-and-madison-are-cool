import java.awt.Event;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import processing.core.PApplet;
import processing.core.PImage;

public class GameWorld {
	private GameLevel gameLevel ;
	
	private int startY ;
	private int width ;
	private int height ;
	
	private FlappyBird bird ;
	private boolean flapOn ;
	private boolean diveOn ;
	
	private ArrayList<Food> foods ;
	private ArrayList<Food> removedFoods ;

	private ArrayList<Obstacle> obstacles ;
	private ArrayList<Obstacle> removedObstacles ;
	private background back;
	private ArrayList<PowerUp> powerUps;
	private ArrayList<PowerUp> removedPowerUps;

	private int generateCounter ;
	private int generatedCount ;
	private boolean levelUp ;
	private boolean gameOver ;
	
	public int counter = 0;

	

	public GameWorld(int y, int width, int height) {
		back = new background();
		gameLevel = new GameLevel(1);		
		this.startY = y ;
		this.width = width ;
		this.height = height ;
		this.bird = new FlappyBird(width / 2 , height / 2);
		flapOn = false ;
		diveOn = false ;
		
		foods = new ArrayList<Food>();
		removedFoods = new ArrayList<Food>();
		generateCounter = GameLevel.GENERATE_AFTER ;
		generatedCount = 0 ;
		levelUp = false ;
		gameOver = false ;

		obstacles = new ArrayList<Obstacle>();
		removedObstacles = new ArrayList<Obstacle>();
		
		powerUps = new ArrayList<PowerUp>();
		removedPowerUps = new ArrayList<PowerUp>();
}

	public FlappyBird getBird() {
		return bird ;
	}
	
	private void updateFoods() {
		for(Food f: removedFoods) {
			foods.remove(f);
		}
	}
	
	public void draw(FlappyBirdGame app) {
		if(checkForLevel(app)) {
			return ;
		}
		
		if(bird.getStamina() == 0) {
			gameOver = true;
		}
		app.pushStyle();
		app.rect(0, startY, width, height);
		app.background(app.getBackgroundImage());
		//back.draw(app);
		for(Food f: foods) {
			f.draw(app);
			if(bird.ate(f)) {
				removedFoods.add(f);
			} else if(!f.move(gameLevel.getSpeed())) {
				removedFoods.add(f);
			}
		}

		for(Obstacle o: obstacles) {
			o.draw(app);
			if(o.hit(bird)) {
				removedObstacles.add(o);
				gameOver = true ;
			} else if(!o.move(gameLevel.getSpeed())) {
				removedObstacles.add(o);
			}
			
			bird.incrementScore(o, 1);
		}
		
		for(PowerUp p: powerUps) {
			p.draw(app);
			if(bird.poweredUp(p)) {
				removedPowerUps.add(p);
			} else if(!p.move(gameLevel.getSpeed())) {
				removedPowerUps.add(p);
			}
		}
		

		if(generateCounter <= 0) { // need to add powerups after finishing code
			//Generate Obstacle
			generateCounter = GameLevel.GENERATE_AFTER ;
			generatedCount++ ;
			obstacles.add(new Obstacle(width, startY, height));
			//obstacles.add(new Obstacle(width + 450, startY, height));
		} else if(generateCounter % (GameLevel.GENERATE_AFTER / gameLevel.getFoodFrequency()) == 0) {
			//Generate Food
			foods.add(new Food(width, startY, height));
		}

		generateCounter-- ;
		bird.draw(app, flapOn, diveOn, startY, height);
		
		app.popStyle();
		this.updateFoods();
	}

	private boolean checkForLevel(FlappyBirdGame app) {
		if(gameOver /*|| this.generatedCount == gameLevel.getMaxObstacleCount()*/) {
				app.pushStyle();

				//app.fill(0);
				//app.stroke(0);
				//app.rect(0, startY, width, height);
				levelUp = true ;
				gameOver = true ;
				int answer = JOptionPane.showConfirmDialog(null, "Play Again?", "GAME OVER", JOptionPane.YES_NO_OPTION);
				if (answer == JOptionPane.YES_OPTION) {
					if(gameOver) {
						bird.setScore(0);
						gameOver = false ;
						levelUp = false ;
						bird.updateStamina(1000);
						gameLevel.init();
						this.removedFoods.clear();
						this.removedObstacles.clear();
						this.foods.clear();
						this.obstacles.clear();
					} else if(levelUp) {
						levelUp = false ;
						gameLevel.nextLevel();
					}
				}
				
				else if (answer == JOptionPane.NO_OPTION || answer == JOptionPane.CLOSED_OPTION) {
					System.exit(0);
				}
				
				
				return true ;
			}
		return false ;
	}

	public boolean isGameUp() {
		return levelUp ;
	}
	
	public boolean nextLevel() {
		levelUp = false ;
		return gameLevel.nextLevel();
	}

	public void keyPressed(int keyCode) {
		if(keyCode == KeyEvent.VK_UP) {
			flapOn = true ;
			diveOn = false ;
		} else if(keyCode == KeyEvent.VK_DOWN) {
			diveOn = true ;
			flapOn = false ;
		} else if(keyCode == KeyEvent.VK_SPACE) {
			if(gameOver) {
				bird.setScore(0);
				gameOver = false ;
				levelUp = false ;
				bird.updateStamina(1000);
				gameLevel.init();
				this.removedFoods.clear();
				this.removedObstacles.clear();
				this.foods.clear();
				this.obstacles.clear();
			} else if(levelUp) {
				levelUp = false ;
				gameLevel.nextLevel();
			}
		}
	}

	public void keyReleased(int keyCode) {
		if(keyCode == KeyEvent.VK_UP) {
			flapOn = false ;
		} else if(keyCode == KeyEvent.VK_DOWN) {
			diveOn = false ;
		}		
	}

}
