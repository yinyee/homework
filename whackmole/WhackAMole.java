package whackmole;

import java.awt.EventQueue;
import java.util.ArrayList;

public class WhackAMole {
	
	private int score;
	
	public static void main (String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameSpace game = new GameSpace();
					game.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	public void initialise() {
		score = 0;
	}

	private void populateMoles() {
		ArrayList<Mole> moles = new ArrayList<Mole>();
	}
}
