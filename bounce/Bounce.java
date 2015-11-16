package bounce;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Bounce extends JPanel {
	
	private JFrame frame;
	private JPanel box;
	private Timer timer;
	private Ball hBall, vBall, rBall;
	private JLabel commentator;
	
	public Bounce() {
		initialise();
	}
	
	public static void main (String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bounce window = new Bounce();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void initialise() {
		
		frame = new JFrame();
		frame.setBounds(0, 0, 600, 400);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		box = new JPanel();
		box.setBounds(10, 50, 580, 380);
		frame.add(box);
		
		commentator = new JLabel("Test");
		commentator.setBounds(10, 10, 100, 30);
		frame.add(commentator);
		
		hBall = new Ball(0, 0, Color.green, "Horizontal");
		vBall = new Ball(0, 0, Color.blue, "Vertical");
		rBall = new Ball(0, 0, Color.red, "Random");
		
		repaint();
		
//		run();
		
		
	}
	
	private void run() {
		
		timer = new Timer();
		
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				
				hBall.move(box);
				vBall.move(box);
				rBall.move(box);
				
			}
		}, 0, 0);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		hBall.draw(g);
		vBall.draw(g);
		rBall.draw(g);
	}

}
