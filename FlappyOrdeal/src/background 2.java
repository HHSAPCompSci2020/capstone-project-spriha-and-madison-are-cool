
public class background {
	private float x;
	private float y;
	public void draw(FlappyBirdGame app) {
		GameLevel l = new GameLevel(0);
		x -= 5;
		app.image(app.getBackgroundImage(), x, y, app.DRAWING_WIDTH, app.DRAWING_HEIGHT);
		app.image(app.getBackgroundImage(), x+app.DRAWING_WIDTH, y, app.DRAWING_WIDTH, app.DRAWING_HEIGHT);
		if(x <= -app.DRAWING_WIDTH) {
			x = 0 ;
		}
	}
}
