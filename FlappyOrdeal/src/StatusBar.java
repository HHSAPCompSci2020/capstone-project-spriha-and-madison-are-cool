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
	private JLabel staminaLabel;
	
	private int staminaX ;
	private int staminaY ;
	private int staminaWidth ;
	private int staminaHeight ;

	
	public StatusBar(int width, int height) {
		this.width = width ;
		this.height = height ;
		this.staminaX = width - (width / 4 + 5) ;
		this.staminaY = 5 ;
		this.staminaWidth = width / 4 ;
		this.staminaHeight = 40 ;
		this.bird = null ;
		this.level = 1 ;
	}
	
	public void setBird(FlappyBird bird) {
		this.bird = bird ;		
	}
	
	public int getHeight() {
		return height ;
	}
	
	public void draw(FlappyBirdGame app) {
		app.pushStyle();
		app.fill(233,235,61);
		
		app.rect(0, 0, (float)width-1, (float) height);
		
		app.fill(0);
		app.stroke(0);
		app.textSize(30);
		app.text("Stamina", (float)(width - width * 0.4) , height - 15);

		app.textSize(40);
		app.text("Level : " + level , 5 , height - 15);

		int stamina = bird.getStamina() ;

		app.fill(0,255,0);
		app.noStroke();
		app.rect(staminaX, staminaY, (float)(staminaWidth * stamina / 1000.0) ,  staminaHeight);
		
		if(stamina < 100) {
			app.noFill();
			app.rect((float)(staminaX+staminaWidth * stamina / 100.0), staminaY, (float)(staminaWidth * (1000 - stamina) / 1000.0) , staminaHeight);			
		}

		app.noFill();
		app.stroke(0);
		app.rect(staminaX, staminaY, staminaWidth ,  staminaHeight, 5);
		
		app.popStyle();
	}

}
