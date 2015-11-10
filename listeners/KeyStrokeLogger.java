package listeners;

import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

// Reference: https://docs.oracle.com/javase/tutorial/uiswing/events/keylistener.html
public class KeyStrokeLogger extends JFrame {

	private JTextField input;
	private JLabel copycat;
	private StringBuilder str;
	private String log;
	private Spy spy;
	
	public KeyStrokeLogger() {
		str = new StringBuilder();
		this.setLayout(null);
		this.setBounds(0, 0, 400, 200);
		input = new JTextField();
		input.setBounds(100, 50, 200, 30);
		spy = new Spy();
		input.addKeyListener(spy);
		copycat = new JLabel();
		copycat.setBounds(100, 100, 200, 30);
		copycat.setText(log);
		this.add(input);
		this.add(copycat);
		this.setVisible(true);
	}
	
	
	public static void main (String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KeyStrokeLogger keylogger = new KeyStrokeLogger();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}



	private class Spy implements KeyListener {
		@Override
		public void keyTyped(KeyEvent e) {
			str.append(e.getKeyChar());
		}

		@Override
		public void keyPressed(KeyEvent e) {
			;
		}

		@Override
		public void keyReleased(KeyEvent e) {
			log = str.toString();
			copycat.setText(log);
		}	
	}
	
}
