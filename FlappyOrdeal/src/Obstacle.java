import java.awt.Rectangle;
import java.awt.Shape;
import java.util.ArrayList;

public class Obstacle extends MovingImage {

	private ArrayList<Shape> pipes;

	public void draw() {
		pipes = new ArrayList<Shape>();
		pipe.add(new Rectangle(50, 0, 50, 100));
		pipe.add(new Rectangle(50, 350, 50, 500));
		pipe.add(new Rectangle(200, 0, 200, 200));
		pipe.add(new Rectangle(200, 0, 200, 400));

	}

}
