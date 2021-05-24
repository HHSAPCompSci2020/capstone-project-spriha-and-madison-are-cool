
public class PowerUp extends MovingImage {
	/*
	 * Different colours for different powerups
	 * 
	 * PowerUp 1: freezes stamina (purple) PowerUp 2: freezes movement of obstacles
	 * (blue) PowerUp 3: grants double points (orange)
	 */

	private static double powerUpWidth = 50;
	private static double powerUpHeight = 50;

	private FlappyBird bird;
	// public static double powerUp

	public PowerUp(int x, int y, int height) {
		super(x, Math.random() * (height - 100) + y + powerUpHeight, powerUpWidth, powerUpHeight);
		// bird.getBird();
	}

	public boolean move(int velocity) {
		this.moveByAmount(-velocity, 0);
		if (x < -powerUpWidth) {
			return false;
		}
		return true;
	}

//	public void maxStamina() {
//		// get GameWorld Flappy Bird
//
//		// get stamina
//		FlappyBird.getStamina();
//
//		// add 500 to stamina
//		stamina += 500;
//	}
//
//	public void freezeObstacles() {
//		// turn off shiftOpening
//	}
//
//	public void doublePoints() {
//		// set incrementScore amt to 2
//		GameWorld.setIncrement(2);
//	}
	

	public static int typeOfPowerUp() {
		int x = (int) Math.random() * 30;
		if (x <= 10) {
			// freezes stamina
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
	
	public void endPowerUp() {
		new java.util.Timer().schedule(new java.util.TimerTask() {
			@Override
			public void run() {
				// your code here
			}
		}, 5000);
	}

	public void draw(FlappyBirdGame app) {
		app.pushStyle();

		if (typeOfPowerUp() == 1) {
		//	maxStamina();
			app.fill(255, 0, 0);
			app.ellipse((float) x, (float) y, (float) width, (float) height);
		} else if (typeOfPowerUp() == 2) {
			//freezeObstacles();
			app.fill(0, 255, 0);
			app.ellipse((float) x, (float) y, (float) width, (float) height);
		} else if (typeOfPowerUp() == 3) {
			//doublePoints();
			app.fill(0, 0, 255);
			app.ellipse((float) x, (float) y, (float) width, (float) height);
		}

		app.popStyle();
	}
}
