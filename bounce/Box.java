package bounce;

import javax.swing.JPanel;

public class Box extends JPanel {

	private int x, y;
	
	public Box(int width, int height) {
		this.x = width;
		this.y = height;
		this.setLayout(null);
	}
	
	public int getWidth() {
		return x;
	}
	
	public int getHeight() {
		return y;
	}
}
