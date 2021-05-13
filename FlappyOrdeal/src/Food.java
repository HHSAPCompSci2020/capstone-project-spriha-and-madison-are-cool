import java.awt.geom.Rectangle2D;

public class Food extends MovingImage {
	private static double foodWidth = 50 ;
	private static double foodHeight = 50 ;
	
	private int quantity ;
	

	public Food(int x, int startY, int height) {
		super(x,Math.random() * (height - 100) + startY + foodHeight , foodWidth,foodHeight);
		quantity = (int)(Math.random() * 20) ;
	}
	
	public boolean move(int speed) {
		this.moveByAmount(-speed, 0);
		if(x < -foodWidth) {
			return false ;
		}
		return true ;
	}
	
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

	public int quantity() {
		// TODO Auto-generated method stub
		return quantity ;
	}
}
