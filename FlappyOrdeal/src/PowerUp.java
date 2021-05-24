
public class PowerUp extends MovingImage {
	/**
	 * Different colours for different powerups
	 * 
	 * PowerUp 1: freezes stamina 
	 * PowerUp 2: freezes movement of obstacles
	 * PowerUp 3: grants double points
	 * 
	 * @author Madison Tippett
	 * 
	 */

	private static double powerUpWidth = 50;
	private static double powerUpHeight = 50;
	private int powerUpType = (int) (Math.random() * 30);
	private int timeRemaining = 5;

	/**
	 * Constructor for the PowerUp
	 * 
	 * @param x sets the x coordinate of the power up
	 * @param y sets the y coordinate of the power up
	 * @param height sets the height of the power up
	 */
	public PowerUp(int x, int y, int height) {
		super(x, Math.random() * (height - 100) + y + powerUpHeight, powerUpWidth, powerUpHeight);
	}

	/**
	 * Moves the PowerUp object and returns true if the PowerUp object is in the window
	 * 
	 * @param velocity how fast the object moves
	 * @return returns true if the PowerUp object is in the window, false otherwise
	 */
	public boolean move(int velocity) {
		this.moveByAmount(-velocity, 0);
		if (x < -powerUpWidth) {
			return false;
		}
		return true;
	}

	/**
	 * Measures time by tick
	 * 
	 * @return returns time remaining (the tick)
	 */
	public int tick() {
		timeRemaining--;
		return timeRemaining;
	}

	/**
	 * Determines the type of power up
	 * 
	 * @return returns 1, 2, or 3 depending on the power up
	 */
	public int typeOfPowerUp() {
		int x = powerUpType;
		if (x <= 10) {
			// max stamina
			return 1;
		} else if (x > 10 && x <= 20) {
			// freezes obstacles
			return 2;
		} else if (x > 20 && x <= 30) {
			// grants double points
			return 3;
		}

		return 0;
	}

	/**
	 * Draws the Power Up object on the PApplet
	 * 
	 * @param app The PApplet on which the Power Up is drawn
	 */
	public void draw(FlappyBirdGame app) {
		app.pushStyle();
		if (typeOfPowerUp() == 1) {
			// maxStamina();
			app.image(app.getPowerUpImage1(), (float) x, (float) y, (float) width, (float) height);
		} else if (typeOfPowerUp() == 2) {
			// freezeObstacles();
			app.image(app.getPowerUpImage2(), (float) x, (float) y, (float) width, (float) height);
		} else if (typeOfPowerUp() == 3) {
			// doublePoints();
			app.image(app.getPowerUpImage3(), (float) x, (float) y, (float) width, (float) height);
		}

		app.popStyle();
	}
}
