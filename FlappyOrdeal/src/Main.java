import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

public class Main extends JFrame {
	FlappyBirdGame flappyBirdGame;
	
	public Main(String title) {
		super(title);
		flappyBirdGame = new FlappyBirdGame();
		PApplet.runSketch(new String[]{""}, flappyBirdGame);
		PSurfaceAWT surf = (PSurfaceAWT) flappyBirdGame.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		JFrame window = (JFrame)canvas.getFrame();

		window.setSize(FlappyBirdGame.DRAWING_WIDTH, FlappyBirdGame.DRAWING_HEIGHT);
		window.setMinimumSize(new Dimension(FlappyBirdGame.DRAWING_WIDTH,FlappyBirdGame.DRAWING_HEIGHT));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		
		window.setVisible(true);

	}
	public static void main(String[] args)
	{
		Main w = new Main("AP Animation Demo");
	}
  

}
