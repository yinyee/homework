import java.awt.EventQueue;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;

public class WhackAMole {

	private JFrame frame;

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
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel gameStats = new JPanel();
		gameStats.setBounds(10, 10, 630, 40);
		frame.getContentPane().add(gameStats);

		JPanel base = new JPanel();
		base.setBounds(10, 60, 630, 680);
		frame.getContentPane().add(base);
		base.setLayout(null);
		
		JPanel hole11 = new JPanel();
		hole11.setBounds(0, 0, 150, 150);
		base.add(hole11);
		hole11.setLayout(null);
		
		JLabel label11 = new JLabel();
		label11.setBounds(0, 0, 150, 150);
		ImageIcon mole = new ImageIcon("mole-color-page-3.jpg");
		label11.setIcon(mole);
		hole11.add(label11);
		
		JPanel hole12 = new JPanel();
		hole12.setBounds(160, 0, 150, 150);
		base.add(hole12);
		
		JPanel hole13 = new JPanel();
		hole13.setBounds(320, 0, 150, 150);
		base.add(hole13);
		
		JPanel hole14 = new JPanel();
		hole14.setBounds(480, 0, 150, 150);
		base.add(hole14);
		
		JPanel hole21 = new JPanel();
		hole21.setBounds(0, 160, 150, 150);
		base.add(hole21);
		
		JPanel hole22 = new JPanel();
		hole22.setBounds(160, 160, 150, 150);
		base.add(hole22);
		
		JPanel hole23 = new JPanel();
		hole23.setBounds(320, 160, 150, 150);
		base.add(hole23);
		
		JPanel hole24 = new JPanel();
		hole24.setBounds(480, 160, 150, 150);
		base.add(hole24);
		
		JPanel hole31 = new JPanel();
		hole31.setBounds(0, 320, 150, 150);
		base.add(hole31);
		
		JPanel hole32 = new JPanel();
		hole32.setBounds(160, 320, 150, 150);
		base.add(hole32);
		
		JPanel hole33 = new JPanel();
		hole33.setBounds(320, 320, 150, 150);
		base.add(hole33);
		
		JPanel hole34 = new JPanel();
		hole34.setBounds(480, 320, 150, 150);
		base.add(hole34);

		JPanel hole41 = new JPanel();
		hole41.setBounds(0, 480, 150, 150);
		base.add(hole41);
		
		JPanel hole42 = new JPanel();
		hole42.setBounds(160, 480, 150, 150);
		base.add(hole42);
		
		JPanel hole43 = new JPanel();
		hole43.setBounds(320, 480, 150, 150);
		base.add(hole43);
		
		JPanel hole44 = new JPanel();
		hole44.setBounds(480, 480, 150, 150);
		base.add(hole44);

	}

}
