import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

public class Main extends JFrame {
	FoodSurface foodSurface;
	
	public Main(String title) {
		super(title);
		foodSurface = new FoodSurface();
		PApplet.runSketch(new String[]{""}, foodSurface);
		PSurfaceAWT surf = (PSurfaceAWT) foodSurface.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		JFrame window = (JFrame)canvas.getFrame();

		window.setSize(400, 300);
		window.setMinimumSize(new Dimension(100,100));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);
		
		window.setVisible(true);

	}
	public static void main(String[] args)
	{
		Main w = new Main("AP Animation Demo");
	}
  

}
