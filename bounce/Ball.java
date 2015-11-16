package bounce;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

public class Ball {

	private int xCoordinate, yCoordinate;
	private Color colour;
	private String movement;
	private String xDirection, yDirection;
	
	public Ball(int xStart, int yStart, Color colour, String movement) {
		this.xCoordinate = xStart;
		this.yCoordinate = yStart;
		this.colour = colour;
		this.movement = movement;
		switch (movement) {
		case "Horizontal": xDirection = "Eastward";
		case "Vertical": yDirection = "Southward";
		}
	}
	
	public void draw(Graphics g) {
		
		Graphics2D g2D = (Graphics2D) g;
		g2D.draw(new Ellipse2D.Double(xCoordinate, yCoordinate, 100, 100));
//		g2D.fillOval(xCoordinate, yCoordinate, 100, 100);
		g2D.setColor(colour);
		g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
	}
	
	public void move(JPanel box) {
		switch (movement) {
		case "Horizontal":
			if (xDirection == "Eastward") {
				if (xCoordinate < box.getWidth()) {
					xCoordinate++;
					xDirection = "Eastward";
				} else {
					xCoordinate--;
					xDirection = "Westward";
				}
			} else if (xDirection == "Westward") {
				if (xCoordinate > 0) {
					xCoordinate--;
					xDirection = "Westward";
				} else {
					xCoordinate++;
					xDirection = "Eastward";
				}
			}
			break;
		case "Vertical":
			if (yDirection == "Southward") {
				if (yCoordinate < box.getHeight()) {
					yCoordinate++;
					yDirection = "Southward";
				} else {
					yCoordinate--;
					yDirection = "Northward";
				}
			} else if (yDirection == "Northward") {
				if (yCoordinate > 0) {
					yCoordinate--;
					yDirection = "Northward";
				} else {
					yCoordinate++;
					yDirection = "Southward";
				}
			}
			break;
		case "Random":
			; // update XCoordinate and yCoordinate
			break;
		}
	}
}
