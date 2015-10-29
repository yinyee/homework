package currencyconverter;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.DecimalFormat;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CurrencyConverterGUI extends JFrame implements WindowListener, ActionListener {

	JComboBox<String> fromCurrency;
	JComboBox<String> toCurrency;
	JTextField userInput;
	JLabel answer;
	private String result;
	private HashMap<String, Double> currencies = new HashMap<String, Double>(); // Reference: https://docs.oracle.com/javase/7/docs/api/java/util/Hashtable.html
	
	public CurrencyConverterGUI (HashMap<String, Double> currencies) {
		
		this.currencies = currencies;
		
		// GUI hard code
		// Reference: http://stackoverflow.com/questions/14046837/positioning-components-in-swing-guis
		JFrame frame = new JFrame("Currency Converter");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		JPanel topPanel = new JPanel();
		topPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		JPanel topLeftPanel = new JPanel();
		topLeftPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		JPanel topCenterPanel = new JPanel();
		topCenterPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		JPanel topRightPanel = new JPanel();
		topRightPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		JLabel convertFromLabel = new JLabel("Convert from", JLabel.RIGHT);
		JLabel convertToLabel = new JLabel("Convert to", JLabel.RIGHT);
		
		String[] currencyList = currencies.keySet().toArray(new String[currencies.size()]); // Reference: http://stackoverflow.com/questions/12077769/converting-hashmap-to-stringarray
		fromCurrency = new JComboBox<String>(currencyList); // Reference: http://stackoverflow.com/questions/1090556/java-how-to-convert-hashmapstring-object-to-array
		toCurrency = new JComboBox<String>(currencyList);
		
		userInput = new JTextField(5);
		answer = new JLabel("     ");
		
		JButton button = new JButton("Convert");
		button.addActionListener(this);
		
		topLeftPanel.add(convertFromLabel, BorderLayout.NORTH);
		topLeftPanel.add(convertToLabel, BorderLayout.SOUTH);
		
		topCenterPanel.add(fromCurrency, BorderLayout.NORTH);
		topCenterPanel.add(toCurrency, BorderLayout.SOUTH);
		
		topRightPanel.add(userInput, BorderLayout.NORTH);
		topRightPanel.add(answer, BorderLayout.SOUTH);
		
		topPanel.add(topLeftPanel, BorderLayout.WEST);
		topPanel.add(topCenterPanel, BorderLayout.CENTER);
		topPanel.add(topRightPanel, BorderLayout.EAST);
		
		bottomPanel.add(button, BorderLayout.CENTER);
		
		panel.add(topPanel, BorderLayout.NORTH);
		panel.add(bottomPanel, BorderLayout.SOUTH);
		
		frame.setContentPane(panel);
		frame.pack();
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
		DecimalFormat df = new DecimalFormat("#.00"); // Reference: https://docs.oracle.com/javase/tutorial/i18n/format/decimalFormat.html
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
