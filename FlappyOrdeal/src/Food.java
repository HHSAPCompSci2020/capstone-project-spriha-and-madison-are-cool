import java.awt.geom.Rectangle2D;
/**
 * The Food Class represents a Food object that a bird can eat to gain stamina
 * @author sprihapandey
 *
 */
public class Food extends MovingImage {
	private static double foodWidth = 50 ;
	private static double foodHeight = 50 ;
	
	private int quantity ;
	
/**
 * Construct a Food object with given coordinates
 * @param x x-coordinate of the Food object
 * @param startY  y-coordinate of the Food object
 * @param height  height of the food object
 */
	public Food(int x, int startY, int height) {
		super(x,Math.random() * (height - 100) + startY + foodHeight , foodWidth,foodHeight);
		quantity = (int)(Math.random() * 20) ;
	}
	/**
	 * Moves the food object and returns true if the Food object is in the window
	 * @param speed
	 * @return returns true if the Food object is in the window, false otherwise
	 */
	public boolean move(int speed) {
		this.moveByAmount(-speed, 0);
		if(x < -foodWidth) {
			return false ;
		}
		return true ;
	}
	/**
	 * Draws the food object on the PAppletee
	 * @param app The PApplet on which the Food is drawn
	 */
	public void draw(FlappyBirdGame app) {
		app.pushStyle();

		app.fill(255,0,0);
		app.ellipse((float)x,(float)y,(float)width,(float)height);
		
		app.fill(0);
		app.stroke(0);
		app.textSize(15);
		app.strokeWeight(10);
		app.textAlign(FlappyBirdGame.CENTER);
		app.text(Integer.toString(quantity), (float)(x) , (float)(y+5));
		
		app.popStyle();
	}
	/**
	 * Returns the amount of stamina the food provides
	 * @return
	 */
	public int quantity() {
		// TODO Auto-generated method stub
		return quantity ;
	}
}
