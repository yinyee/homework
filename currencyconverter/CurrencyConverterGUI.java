package currencyconverter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CurrencyConverterGUI extends JFrame implements ActionListener {

	private double convertToAmount;
	private ArrayList<Currency> currencies;
	
	JPanel panel;
	JLabel label;
	JButton button;
	JTextField convertFromAmount;
	
	public CurrencyConverterGUI (ArrayList<Currency> currencies) {
		
		this.currencies = currencies;
		
		panel = new JPanel();
		label = new JLabel("Amount to convert:");
		button = new JButton("Convert!");
		button.addActionListener(this);
		panel.add(label);
		panel.add(button);
		add(panel);
	}

	public double convert(Currency convertFromCurrency, double convertFromAmount, 
			Currency convertToCurrency) {
		Currency convertFrom = currencies.get(currencies.indexOf(convertFromCurrency));
		Currency convertTo = currencies.get(currencies.indexOf(convertToCurrency));
		convertToAmount = convertFromAmount / convertFrom.getExchangeRate() * convertTo.getExchangeRate();
		return convertToAmount;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
}
