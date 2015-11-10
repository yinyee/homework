import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

public class WhackAMole {

	private int score;
	
	private JFrame frame;
	private JPanel gameStats;
	private JPanel base;
	private JPanel hole11, hole12, hole13, hole14,
				   hole21, hole22, hole23, hole24,
				   hole31, hole32, hole33, hole34,
				   hole41, hole42, hole43, hole44;
	private JButton button11, button12, button13, button14,
					button21, button22, button23, button24,
					button31, button32, button33, button34,
					button41, button42, button43, button44;
	private JLabel labelYourScore, labelScore;
	
	ImageIcon originalMole = new ImageIcon("/Users/yinyee/Documents/workspace/Homework/images/mole-color-page-3.gif");
	Image unscaledMole = originalMole.getImage();
	Image scaledMole = unscaledMole.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
	ImageIcon mole = new ImageIcon(scaledMole);
	
	private final Action action = new SwingAction();

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

		score = 0;
		
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		gameStats = new JPanel();
		gameStats.setBounds(10, 10, 630, 40);
		gameStats.setLayout(null);
		labelYourScore = new JLabel("Your score: ");
		labelYourScore.setBounds(10, 10, 150, 40);
		labelScore = new JLabel(Integer.toString(score));
		labelScore.setBounds(170, 10, 150, 40);
		gameStats.add(labelYourScore);
		gameStats.add(labelScore);
		frame.getContentPane().add(gameStats);

		base = new JPanel();
		base.setBounds(10, 60, 630, 680);
		base.setLayout(null);
		frame.getContentPane().add(base);
				
		hole11 = new JPanel();
		hole11.setBounds(0, 0, 150, 150);
		hole11.setLayout(null);
		base.add(hole11);
		
		button11 = new JButton();
		button11.setBounds(0, 0, 150, 150);
		button11.setIcon(mole);
		button11.addActionListener(action);
		hole11.add(button11);
		
		hole12 = new JPanel();
		hole12.setBounds(160, 0, 150, 150);
		hole12.setLayout(null);
		base.add(hole12);
		
		button12 = new JButton();
		button12.setBounds(0, 0, 150, 150);
		button12.setIcon(mole);
		button12.addActionListener(action);
		hole12.add(button12);
		
		hole13 = new JPanel();
		hole13.setBounds(320, 0, 150, 150);
		hole13.setLayout(null);
		base.add(hole13);
		
		button13 = new JButton();
		button13.setBounds(0, 0, 150, 150);
		button13.setIcon(mole);
		hole13.add(button13);
		
		hole14 = new JPanel();
		hole14.setBounds(480, 0, 150, 150);
		hole14.setLayout(null);
		base.add(hole14);
		
		button14 = new JButton();
		button14.setBounds(0, 0, 150, 150);
		button14.setIcon(mole);
		hole14.add(button14);
		
		hole21 = new JPanel();
		hole21.setBounds(0, 160, 150, 150);
		hole21.setLayout(null);
		base.add(hole21);
		
		button21 = new JButton();
		button21.setBounds(0, 0, 150, 150);
		button21.setIcon(mole);
		hole21.add(button21);
		
		hole22 = new JPanel();
		hole22.setBounds(160, 160, 150, 150);
		hole22.setLayout(null);
		base.add(hole22);
		
		button22 = new JButton();
		button22.setBounds(0, 0, 150, 150);
		button22.setIcon(mole);
		hole22.add(button22);
		
		hole23 = new JPanel();
		hole23.setBounds(320, 160, 150, 150);
		hole23.setLayout(null);
		base.add(hole23);
		
		button23 = new JButton();
		button23.setBounds(0, 0, 150, 150);
		button23.setIcon(mole);
		hole23.add(button23);
		
		hole24 = new JPanel();
		hole24.setBounds(480, 160, 150, 150);
		hole24.setLayout(null);
		base.add(hole24);
		
		button24 = new JButton();
		button24.setBounds(0, 0, 150, 150);
		button24.setIcon(mole);
		hole24.add(button24);
		
		hole31 = new JPanel();
		hole31.setBounds(0, 320, 150, 150);
		hole31.setLayout(null);
		base.add(hole31);
		
		button31 = new JButton();
		button31.setBounds(0, 0, 150, 150);
		button31.setIcon(mole);
		hole31.add(button31);
		
		hole32 = new JPanel();
		hole32.setBounds(160, 320, 150, 150);
		hole32.setLayout(null);
		base.add(hole32);
		
		button32 = new JButton();
		button32.setBounds(0, 0, 150, 150);
		button32.setIcon(mole);
		hole32.add(button32);
		
		hole33 = new JPanel();
		hole33.setBounds(320, 320, 150, 150);
		hole33.setLayout(null);
		base.add(hole33);
		
		button33 = new JButton();
		button33.setBounds(0, 0, 150, 150);
		button33.setIcon(mole);
		hole33.add(button33);
		
		hole34 = new JPanel();
		hole34.setBounds(480, 320, 150, 150);
		hole34.setLayout(null);
		base.add(hole34);

		button34 = new JButton();
		button34.setBounds(0, 0, 150, 150);
		button34.setIcon(mole);
		hole34.add(button34);
		
		hole41 = new JPanel();
		hole41.setBounds(0, 480, 150, 150);
		hole41.setLayout(null);
		base.add(hole41);
		
		button41 = new JButton();
		button41.setBounds(0, 0, 150, 150);
		button41.setIcon(mole);
		hole41.add(button41);
		
		hole42 = new JPanel();
		hole42.setBounds(160, 480, 150, 150);
		hole42.setLayout(null);
		base.add(hole42);
		
		button42 = new JButton();
		button42.setBounds(0, 0, 150, 150);
		button42.setIcon(mole);
		hole42.add(button42);
		
		hole43 = new JPanel();
		hole43.setBounds(320, 480, 150, 150);
		hole43.setLayout(null);
		base.add(hole43);
		
		button43 = new JButton();
		button43.setBounds(0, 0, 150, 150);
		button43.setIcon(mole);
		hole43.add(button43);
		
		hole44 = new JPanel();
		hole44.setBounds(480, 480, 150, 150);
		hole44.setLayout(null);
		base.add(hole44);

		button44 = new JButton();
		button44.setBounds(0, 0, 150, 150);
		button44.setIcon(mole);
		hole44.add(button44);
		
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			button11.setVisible(false);
			labelScore.setText(Integer.toString(score =+ 1));
		}
	}
}
