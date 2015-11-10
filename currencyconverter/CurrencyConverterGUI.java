package currencyconverter;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.DecimalFormat;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class CurrencyConverterGUI extends JFrame implements WindowListener, ActionListener {

	JFrame frame;
	JComboBox<String> fromCurrency;
	JComboBox<String> toCurrency;
	JTextField userInput;
	JLabel answer;
	private String result;
	private HashMap<String, Double> currencies = new HashMap<String, Double>(); // Reference: https://docs.oracle.com/javase/7/docs/api/java/util/Hashtable.html
	
	public CurrencyConverterGUI (HashMap<String, Double> currencies) {
		this.currencies = currencies;
		initialise();
	}
	
	private void initialise () {
		// GUI hard code
		// Reference: http://stackoverflow.com/questions/14046837/positioning-components-in-swing-guis
		JFrame.setDefaultLookAndFeelDecorated(true); // What difference does this make??
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setLayout(null);
		
		JLabel convertLabel = new JLabel("Convert");
		JLabel toLabel = new JLabel("To");
		
		String[] currencyList = currencies.keySet().toArray(new String[currencies.size()]); // Reference: http://stackoverflow.com/questions/12077769/converting-hashmap-to-stringarray
		fromCurrency = new JComboBox<String>(currencyList); // Reference: http://stackoverflow.com/questions/1090556/java-how-to-convert-hashmapstring-object-to-array
		toCurrency = new JComboBox<String>(currencyList);
		
		userInput = new JTextField(5);
		answer = new JLabel("     ");
		
		JButton button = new JButton("Convert");
		button.addActionListener(this);
		
		// LHS
		convertLabel.setBounds	(50, 100, 50, 30); // pos-x: 50, length-x: 50, total-x: 100
		toLabel.setBounds		(50, 150, 50, 30); // total-y: 120, 170
		frame.add(convertLabel);
		frame.add(toLabel);
		
		// Center
		fromCurrency.setBounds	(120, 100, 100, 30); // pos-x: 120, length-x: 100, total-x: 220
		toCurrency.setBounds	(120, 150, 100, 30);
		button.setBounds		(150, 230, 100, 30);
		frame.add(fromCurrency);
		frame.add(toCurrency);
		frame.add(button);
		
		// RHS
		userInput.setBounds		(240, 100, 100, 30); // pos-x: 240, length-x: 100, total-x: 340
		answer.setBounds		(240, 150, 100, 30);
		frame.add(userInput);
		frame.add(answer);
		
		frame.setSize			(400, 400);
		frame.setVisible(true);
	}
		
	// Reference: http://stackoverflow.com/questions/10072335/get-input-values-from-jcombobox
	public void convert() {
		String fromAmountString = userInput.getText();
		double fromAmount = Double.parseDouble(fromAmountString);
		String fromCurrencyString = (String)fromCurrency.getSelectedItem();
		double convertToUSD = currencies.get(fromCurrencyString);
		String toCurrencyString = (String)toCurrency.getSelectedItem();
		double convertFromUSD = currencies.get(toCurrencyString);
		DecimalFormat df = new DecimalFormat("###,###,###.00"); // Reference: https://docs.oracle.com/javase/tutorial/i18n/format/decimalFormat.html
		result = df.format(fromAmount / convertToUSD * convertFromUSD);
	}

	// Reference: https://docs.oracle.com/javase/tutorial/uiswing/events/actionlistener.html
	@Override
	public void actionPerformed(ActionEvent e) {
		convert();
		answer.setText(result); // Reference: http://docs.oracle.com/javase/7/docs/api/java/lang/Integer.html
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		System.exit(0);
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
