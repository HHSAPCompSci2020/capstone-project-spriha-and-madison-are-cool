
public class background {
	private float x;
	private float y;
	public void draw(FlappyBirdGame app) {
		GameLevel l = new GameLevel(0);
		x -= 1;
		app.image(app.getBackgroundImage(), x, y, app.DRAWING_WIDTH, app.DRAWING_HEIGHT);
	}
}
