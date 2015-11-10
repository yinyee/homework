package listeners;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class BigBrother implements FocusListener {

	private JFrame frame;
	private JTextField textField;
	private JToggleButton toggle;
	private JComboBox<String> comboBox;
	private JSlider slider;
	private JRadioButton radioMaybe;
	private JRadioButton radioMaybeNot;
	private JCheckBox checkBox;
 	private String current;
 	private String previous;
	private JTextArea log;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BigBrother window = new BigBrother();
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
	public BigBrother() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton button = new JButton("Press this!");
		button.setName("button");
		button.setBounds(332, 181, 112, 78);
		button.addFocusListener(this);
		frame.getContentPane().add(button);
		
		textField = new JTextField();
		textField.setName("textField");
		textField.setBounds(102, 6, 342, 39);
		textField.addFocusListener(this);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		toggle = new JToggleButton("Try this!");
		toggle.setName("toggle");
		toggle.setBounds(6, 4, 93, 101);
		toggle.addFocusListener(this);
		frame.getContentPane().add(toggle);
		
		String[] contents = {"Alicia Keys", "Taylor Swift", "Ellie Goulding"};
		comboBox = new JComboBox<String>(contents);
		comboBox.setName("comboBox");
		comboBox.setBounds(112, 61, 209, 44);
		comboBox.addFocusListener(this);
		frame.getContentPane().add(comboBox);
		
		slider = new JSlider();
		slider.setName("slider");
		slider.setBounds(102, 41, 342, 29);
		slider.addFocusListener(this);
		frame.getContentPane().add(slider);
		
		radioMaybe = new JRadioButton("Maybe");
		radioMaybe.setName("radioMaybe");
		radioMaybe.setBounds(332, 112, 72, 23);
		radioMaybe.addFocusListener(this);
		frame.getContentPane().add(radioMaybe);
		
		checkBox = new JCheckBox("Call me?");
		checkBox.setName("checkBox");
		checkBox.setBounds(332, 82, 93, 23);
		checkBox.addFocusListener(this);
		frame.getContentPane().add(checkBox);
		
		log = new JTextArea();
		log.setWrapStyleWord(true); // Reference: http://stackoverflow.com/questions/26420428/how-to-word-wrap-text-in-jlabel
		log.setLineWrap(true);
		log.setBounds(16, 112, 304, 148);
		frame.getContentPane().add(log);
		
		radioMaybeNot = new JRadioButton("Maybe not");
		radioMaybeNot.setName("radioMaybeNot");
		radioMaybeNot.setBounds(332, 146, 97, 23);
		radioMaybeNot.addFocusListener(this);
		frame.getContentPane().add(radioMaybeNot);
	}

	@Override
	public void focusGained(FocusEvent e) {
		current = e.getComponent().getName();
		log.append(current + " has gained focus\n");
	}

	@Override
	public void focusLost(FocusEvent e) {
		log.setText(null);
		previous = e.getComponent().getName();
		log.append(previous + " has lost focus\n");
	}
}
