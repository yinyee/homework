package listeners;

import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class KnowItAll extends JFrame {

	private JComboBox<String> input;
	private Recorder recorder;
	private JLabel message;
	private String previous;
	private String current;
	
	public KnowItAll() {
		
		String [] contents = {"A", "B", "C"}; 
		
		this.setLayout(null);
		this.setBounds(0, 0, 400, 400);
		input = new JComboBox<String>(contents);
		input.setBounds(50, 100, 300, 50);
		recorder = new Recorder();
		input.addItemListener(recorder);
		this.add(input);
		message = new JLabel();
		message.setBounds(50, 200, 300, 50);
		message.setVisible(false);
		this.add(message);
		this.setVisible(true);
		
	}
	
	public static void main (String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KnowItAll knowitall = new KnowItAll();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	// Reference: http://docs.oracle.com/javase/tutorial/uiswing/events/itemlistener.html
	private class Recorder implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			switch (e.getStateChange()){
			case (ItemEvent.DESELECTED): previous = e.getItem().toString();
			case (ItemEvent.SELECTED): current = e.getItem().toString();
			}
			message.setText("You have changed from " + previous + " to " + current);
			message.setVisible(true);
		}
		
	}

}
