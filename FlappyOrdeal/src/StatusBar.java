import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * The Status Bar represents a bar that displays the stamina and points of the bird
 * @author sprihapandey
 *
 */
public class StatusBar {
	private int width ;
	private int height ;
	private int level ;
	
	private FlappyBird bird ;
	private Obstacle obstacle;
	private JLabel staminaLabel;
	
	private int staminaX ;
	private int staminaY ;
	private int staminaWidth ;
	private int staminaHeight ;

	/**
	 * Constructs a StatusBar with given width and height
	 * @param width width of the bar
	 * @param height height of the bar
	 */
	public StatusBar(int width, int height) {
		this.width = width ;
		this.height = height ;
		this.staminaX = width - (width / 4 + 5) ;
		this.staminaY = 5 ;
		this.staminaWidth = width / 4 ;
		this.staminaHeight = 40 ;
		this.bird = null ;
		this.obstacle = null;
		this.level = 1 ;
	}
	/**
	 * Sets the Flappy Bird to the given bird object
	 * @param bird the new Flappy Bird
	 */
	public void setBird(FlappyBird bird) {
		this.bird = bird ;		
	}
	/**
	 * Returns the height of the bar
	 * @return the height of the bar
	 */
	public int getHeight() {
		return height ;
	}
	/**
	 * Draws the StatusBar on the given PApplet
	 * @param app the PApplet on which the Bar is drawn
	 */
	public void draw(FlappyBirdGame app) {
		app.pushStyle();
		app.fill(233,235,61);
		
		app.rect(0, 0, (float)width-1, (float) height);
		
		app.fill(0);
		app.stroke(0);
		app.textSize(30);
		app.text("Stamina", (float)(width - width * 0.4) , height - 15);

		app.textSize(40);
		app.text("Score : " + bird.getScore() , 5 , height - 15);

		int stamina = bird.getStamina() ;

		app.fill(0,255,0);
		app.noStroke();
		app.rect(staminaX, staminaY, (float)(staminaWidth * stamina / bird.getMaxStamina()) ,  staminaHeight);
		
		if(stamina < 100) {
			app.noFill();
			app.rect((float)(staminaX+staminaWidth * stamina / 100.0), staminaY, (float)(staminaWidth * (1000 - stamina) / 1000.0) , staminaHeight);
			app.fill(255,0,0);
			app.noStroke();
			app.rect(staminaX, staminaY, (float)(staminaWidth * stamina / bird.getMaxStamina()) ,  staminaHeight);
		}

		app.noFill();
		app.stroke(0);
		app.rect(staminaX, staminaY, staminaWidth ,  staminaHeight, 5);
		
		app.popStyle();
	}

}
