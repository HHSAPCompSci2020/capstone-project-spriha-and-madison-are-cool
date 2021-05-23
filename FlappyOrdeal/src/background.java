/**
 * The Background class represnts the Background that will be drawn when the game starts
 * @author sprihapandey
 *
 */
public class background extends MovingImage{
	public background() {
		super(0, 0, FlappyBirdGame.DRAWING_WIDTH, FlappyBirdGame.DRAWING_HEIGHT);
	}
	private float x;
	private float y;
	/**
	 * Draws the background image on the given PApplet
	 * @param app the PApplet on which the background image is drawn
	 */
	public void draw(FlappyBirdGame app) {
		GameLevel l = new GameLevel();
		x -= 5;
		app.image(app.getBackgroundImage(), x, y, app.DRAWING_WIDTH, app.DRAWING_HEIGHT);
		app.image(app.getBackgroundImage(), x+app.DRAWING_WIDTH, y, app.DRAWING_WIDTH, app.DRAWING_HEIGHT);
		if(x <= -app.DRAWING_WIDTH) {
			x = 0 ;
		}
	}
}
