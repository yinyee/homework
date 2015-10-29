package currencyconverter;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CurrencyConverter {

	private double convertToAmount;
	private ArrayList<Currency> currencies;
	private JTextField convertFromAmount;
	
	public CurrencyConverter (ArrayList<Currency> currencies) {
		this.currencies = currencies;
	}

	public double convert(Currency convertFromCurrency, double convertFromAmount, 
			Currency convertToCurrency) {
//		JPanel panel = new JPanel();
//		JPanel.add(new JLabel("Convert this amount: "));
//		panel.add(convertFromAmount);
		Currency convertFrom = currencies.get(currencies.indexOf(convertFromCurrency));
		Currency convertTo = currencies.get(currencies.indexOf(convertToCurrency));
		convertToAmount = convertFromAmount / convertFrom.getExchangeRate() * convertTo.getExchangeRate();
		return convertToAmount;
	}
}
