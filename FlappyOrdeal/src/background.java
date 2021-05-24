/**
 * The Background class represents the Background that will be drawn when the game starts
 * @author sprihapandey
 *
 */
public class background extends MovingImage{
	
	/**
	 * Constructs a MovingImage with the given coordinates
	 * @param x the x - coordinate of the image
	 * @param y the y - coordinate of the image
	 */
	public background(double x, double y) {
		super(x, y, FlappyBirdGame.DRAWING_WIDTH, FlappyBirdGame.DRAWING_HEIGHT);
	}
	/**
	 * Draws the background image on the given PApplet
	 * @param app the PApplet on which the background image is drawn
	 */
	public void draw(FlappyBirdGame app, int speed) {
		this.moveByAmount(-speed, 0);;
		app.image(app.getBackgroundImage(), (float)x, (float)y, app.DRAWING_WIDTH, app.DRAWING_HEIGHT);
		app.image(app.getBackgroundImage(), (float)(x+app.DRAWING_WIDTH), (float)y, app.DRAWING_WIDTH, app.DRAWING_HEIGHT);
		if(x <= -app.DRAWING_WIDTH) {
			x = 0 ;
		}
	}
}
