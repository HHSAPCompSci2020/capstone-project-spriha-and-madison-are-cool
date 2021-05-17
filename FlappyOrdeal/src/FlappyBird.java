import java.awt.geom.Rectangle2D;

/**
 * FlappyBird is moving image that represents the flappy bird, which can move up
 * or down, lose stamina over a period of time, and gain stamina by eating food
 * 
 * @author sprihapandey
 *
 */
public class FlappyBird extends MovingImage{
	private double stamina ;
	private int score;
	/**
	 * Constructs a flappy bird with given coordinates and a stamina of 10
	 * 
	 * @param x The x - coordinate of the top left corner of the bird
	 * @param y The y - coordinate of the top left corner of the bird
	 */
	public FlappyBird(int x, int y){
		super(x, y, 50 , 50);
		stamina = 1000 ;
	}
	/**
	 * Returns the value of the stamina of the bird
	 * @return the stamina of the bird
	 */
	public int getStamina() {
		return (int)stamina ;
	}
	/**
	 * Returns true and updates the stamina of the bird if it collides with the given Food object
	 * @param f The Food object the bird is checking collisions with
	 * @return true if the bird collides with the food, false otherwise
	 */
	public boolean ate(Food f) {
		if(this.intersects(f)) {
			updateStamina(f.quantity());
			return true ;
		}
		return false ;
	}
/**
 * Updates the stamina of the bird by the given amount
 * @param incr the amount by which the stamina is increased
 */
	public void updateStamina(int incr) {
		stamina += incr ;
		if(stamina > 1000) {
			stamina = 1000 ;
		}
		if(stamina < 0) {
			stamina = 0 ;
		}
	}
/**
 * Draws the rectangle representing the bird, moves it up or down if necessary, decreases the stamina of the bird, and makes sure the bird does not go out of the window
 * @param app The game that uses the FlappyBird object
 * @param flapOn true if the bird needs to move up, false otherwise
 * @param diveOn true if the bird needs to move down, false otherwise
 * @param minHeight the minimum height the bird can dive down to
 * @param maxHeight the maximum height the bird can flap up to
 */
	public void draw(FlappyBirdGame app, boolean flapOn, boolean diveOn, int minHeight, int maxHeight) {
		stamina -= 0.05;
		app.pushStyle();
		app.fill(0,255,255);
		app.stroke(0);
		app.rect((float)getX(), (float)getY() , (float)getWidth(), (float)getHeight());
		
		handleMovement(flapOn, diveOn, minHeight, maxHeight);
		
		app.popStyle();
	}

	private void handleMovement(boolean flapOn, boolean diveOn, int minHeight, int maxHeight) {
		if(flapOn && diveOn) {
			return ;
		}
		
		if(flapOn) {
			moveByAmount(0,-5);
			if(y < minHeight) {
				moveByAmount(0,5);
				stamina -= 1 ;
			}
		}
		
		if(diveOn) {
			moveByAmount(0,5);
			if(y >= maxHeight - getHeight() / 2) {
				moveByAmount(0,-5);
				stamina -= 1 ;
			}
		}
	}
	
	public boolean incrementScore(Obstacle o, int amt) {
		Rectangle2D.Double empty = o.getEmptySpaceRectangle();
		if (this.intersects(empty)) {
			if(!o.scored)
			score += amt;
			o.scored = true;
			return true;
		}
		return false;
	}
	
	public int getScore() {
		return score;
	}

}
