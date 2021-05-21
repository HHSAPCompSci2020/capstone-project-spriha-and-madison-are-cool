
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

	public PowerUp(int x, int y, int height) {
		super(x, Math.random() * (height - 100) + y + powerUpHeight, powerUpWidth, powerUpHeight);
	}

	public boolean move(int velocity) {
		this.moveByAmount(-velocity, 0);
		if (x < -powerUpWidth) {
			return false;
		}
		return true;
	}

	public void typeOfPowerUp() {
		int x = (int) Math.random() * 40;
		if(x <= 10) {
			
		} else if (x > 10 && x <= 20) {
			
		} else if (x > 20 && x <= 30) {
			
		} else if (x > 30 && x <= 40) {
			
		}
	}

	public void draw(FlappyBirdGame app) {
		app.pushStyle();

//		if (purp() == true) {
//			app.fill(238, 130, 238);
//			app.ellipse((float) x, (float) y, (float) width, (float) height);
//		} else if (blue() == true) {
//			app.fill(0, 0, 255);
//			app.ellipse((float) x, (float) y, (float) width, (float) height);
//		} else if (orange() == true) {
//			app.fill(255, 153, 51);
//			app.ellipse((float) x, (float) y, (float) width, (float) height);
//		} else if (red() == true) {
//			app.fill(255, 0, 0);
//			app.ellipse((float) x, (float) y, (float) width, (float) height);
//		}
		
		app.fill(238, 130, 238);
		app.ellipse((float) x, (float) y, (float) width, (float) height);

		app.popStyle();
	}
}
