import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

public class Main extends JFrame {
	DrawingSurface drawingSurface;
	
	public Main(String title) {
		super(title);
		drawingSurface = new DrawingSurface();
		PApplet.runSketch(new String[]{""}, drawingSurface);
		PSurfaceAWT surf = (PSurfaceAWT) drawingSurface.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		JFrame window = (JFrame)canvas.getFrame();

		window.setSize(900, 504);
		window.setMinimumSize(new Dimension(100,100));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		
		window.setVisible(true);

	}
	public static void main(String[] args)
	{
		Main w = new Main("AP Animation Demo");
	}
  

}
