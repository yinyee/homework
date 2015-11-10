package whackmole;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JWindow;

public class GameSpace extends JWindow {
	
	JPanel gameStats; 
	JPanel gameArea;
	
	public GameSpace() {
		
		setBounds(0,0,1000,1000);
		
		gameStats.setBounds(0, 0, 400, 200);
		// gameStats.setLayout(new GridLayout());
		add(gameStats);
		
		gameArea.setBounds(0, 0, 400, 400);
		// gameArea.setLayout(new GridLayout(4, 4, 10, 10));
		add(gameArea);
		
	}
	

}
