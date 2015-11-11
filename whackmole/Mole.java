package whackmole;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Mole extends JButton implements ActionListener {

	ImageIcon originalMole = new ImageIcon("mole.gif");
	Image unscaledMole = originalMole.getImage();
	Image scaledMole = unscaledMole.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
	ImageIcon mole = new ImageIcon(scaledMole);

	public Mole () {
		this.setIcon(mole);
		this.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.setVisible(false);
	}

}
