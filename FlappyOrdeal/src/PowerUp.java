
public class PowerUp extends MovingImage {
	/*
	 * Different colours for different powerups
	 * 
	 * PowerUp 1: freezes stamina (purple) PowerUp 2: freezes movement of obstacles
	 * (blue) PowerUp 3: grants double points (orange) PowerUp 4: slows down bird
	 * (red)
	 */

	private static double powerUpWidth = 50;
	private static double powerUpHeight = 50;
	
	private FlappyBird bird;
	//public static double powerUp

	public PowerUp(int x, int y, int height) {
		super(x, Math.random() * (height - 100) + y + powerUpHeight, powerUpWidth, powerUpHeight);
		//bird.getBird();
	}

	public boolean move(int velocity) {
		this.moveByAmount(-velocity, 0);
		if (x < -powerUpWidth) {
			return false;
		}
		return true;
	}

	public void maxStamina() {
		
	}
	
	public void freezeObstacles() {
		
	}
	
	public void doublePoints() {
		
	}
	
	public void slowBird() {
		
	}
	
	public void typeOfPowerUp() {
		int x = (int) Math.random() * 40;
		if (x <= 10) {
			// freezes stamina 
		} else if (x > 10 && x <= 20) {
			// freezes obstacles
		} else if (x > 20 && x <= 30) {
			// grants double points
		} else if (x > 30 && x <= 40) {
			// slows down bird
		}
	}

	public void draw(FlappyBirdGame app) {
		typeOfPowerUp();
		app.pushStyle();

		app.fill(238, 130, 238);
		app.ellipse((float) x, (float) y, (float) width, (float) height);

		app.popStyle();
	}
}
