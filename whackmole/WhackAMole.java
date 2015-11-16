package whackmole;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WhackAMole {

	private Timer timer;
	private int seconds;
	private JLabel countdown;
	private final String[] level = {"Easy", "Medium", "Tough Mudder"};
	private final JComboBox<String> nowPlaying = new JComboBox<String>(level);
	private int frequency;
	private JButton startButton;
	private int score;
	private JLabel scoreDisplay;
	private JFrame frame;
	private JPanel gameStats;
	private JPanel gameArea;
	private ArrayList<Object> screen;
	private ArrayList<Object> resetScreen = new ArrayList<Object>();
	private GameEvent actionEvent = new GameEvent();

//	ImageIcon originalMole = new ImageIcon("/Users/yinyee/Documents/workspace/Homework/src/whackmole/mole.png");
	ImageIcon originalMole = new ImageIcon("/cs/student/msc3/cs/2015/yinyekan/workspace/Tutorials/src/whackmole/mole.png");
	Image unscaledMole = originalMole.getImage();
	Image scaledMole = unscaledMole.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
	ImageIcon mole = new ImageIcon(scaledMole);
	
//	ImageIcon originalX = new ImageIcon("/Users/yinyee/Documents/workspace/Homework/src/whackmole/red-x.png");
	ImageIcon originalX = new ImageIcon("/cs/student/msc3/cs/2015/yinyekan/workspace/Tutorials/src/whackmole/red-x.png");
	Image unscaledX = originalX.getImage();
	Image scaledX = unscaledX.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
	ImageIcon x = new ImageIcon(scaledX);
	
//	ImageIcon originalHole = new ImageIcon("/Users/yinyee/Documents/workspace/Homework/src/whackmole/hole.png");
	ImageIcon originalHole = new ImageIcon("/cs/student/msc3/cs/2015/yinyekan/workspace/Tutorials/src/whackmole/hole.png");
	Image unscaledHole = originalHole.getImage();
	Image scaledHole = unscaledHole.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
	ImageIcon hole = new ImageIcon(scaledHole);
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WhackAMole window = new WhackAMole();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WhackAMole() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
				
		frame = new JFrame("Whack A Mole");
		frame.setBounds(100, 100, 640, 750);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		gameStats = new JPanel();
		gameStats.setBounds(20, 0, 600, 100);
		gameStats.setLayout(null);
		countdown = new JLabel();
		countdown.setBounds(10, 20, 200, 30);
		gameStats.add(countdown);
		scoreDisplay = new JLabel();
		scoreDisplay.setText("Your score: " + Integer.toString(score));
		scoreDisplay.setBounds(10, 50, 200, 30);
		gameStats.add(scoreDisplay);
		nowPlaying.setBounds(440, 20, 150, 20);
		gameStats.add(nowPlaying);
		startButton = new JButton("Start");
		startButton.setBounds(440, 50, 150, 30);
		startButton.addActionListener(actionEvent);
		startButton.setActionCommand("Start");
		gameStats.add(startButton);
		frame.add(gameStats);
		
		gameArea = new JPanel();
		gameArea.setBounds(20, 100, 600, 600);
		frame.add(gameArea);
		gameArea.setLayout(new GridLayout(4, 4)); // Reference: https://docs.oracle.com/javase/tutorial/uiswing/layout/grid.html
		for (int i = 0; i < 16; i++){
			resetScreen.add(new Hole());
		}
		screen = resetScreen;
		for (int i = 0; i < 16; i++) {
			gameArea.add((Component) screen.get(i));
		}
	}
	
	// Reference: http://docs.oracle.com/javase/7/docs/api/java/util/Timer.html
	private void run(int frequency) {
		
		timer = new Timer();
		
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				countdown.setText("Time remaning: " + seconds--); // Reference: https://docs.oracle.com/javase/7/docs/technotes/guides/lang/Countdown.java
				if (seconds < 0) {
					screen = resetScreen;
					gameArea.removeAll();
					for (int i = 0; i < 16; i++) {
						gameArea.add((Component) screen.get(i));
					}
					timer.cancel();
				}
			}
		}, 0, 1000);
		
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				screen = new ArrayList<Object>();
				Random random = new Random();
				int numberOfMoles = random.nextInt(16);
				numberOfMoles = Math.max(2, numberOfMoles);
				for (int i = 0; i < 16; i++) {
					if (i < numberOfMoles) {
						screen.add(new Mole());
					} else {
					screen.add(new Hole());
					}
				}
				Collections.shuffle(screen); // Reference: http://www.vogella.com/tutorials/JavaAlgorithmsShuffle/article.html
				gameArea.removeAll();
				for (int i = 0; i < 16; i++) {
					gameArea.add((Component) screen.get(i));
				}
			}
		}, 0, 1000 * frequency--);
	}
	
	private class Mole extends JButton {
		private Mole () {
			this.setIcon(mole);
			this.setBounds(0, 0, 100, 100);
			this.addActionListener(actionEvent);
			this.setActionCommand("Whack");
		}
	}
	
	private class Hole extends JLabel {
		private Hole () {
			this.setIcon(hole);
			this.setBounds(0, 0, 150, 150);
		}
	}
	
	// Reference: http://stackoverflow.com/questions/14443259/one-action-listener-two-jbuttons
	private class GameEvent implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			switch (command) {
			case ("Start"):
				seconds = 30;
				score = 0;
				switch(nowPlaying.getSelectedItem().toString()) {
					case "Easy": 
						frequency = 7;
						break;
					case "Medium": 
						frequency = 5;
						break;
					case "Tough Mudder": 
						frequency = 3;
						break;
					}
				run(frequency);
				break;
			case ("Whack"):
				((JButton)e.getSource()).setIcon(x);
				scoreDisplay.setText("Your score: " + Integer.toString(++score));
				break;
			default:
				break;
			}
		}
		
	}
	
}
