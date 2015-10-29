package currencyconverter;

import java.util.ArrayList;
import javax.swing.JOptionPane;

// Reference: http://cs.lmu.edu/~ray/notes/javagraphics/
public class CurrencyConverterTester {

	public static void main (String[] args) {
		
		// Load currencies
		Currency USDollar = new Currency ("USD", 1.0000);
		Currency BritishPound = new Currency ("GBP", 0.65154);
		Currency JapaneseYen = new Currency ("JPY", 121.025);
		Currency Euro = new Currency ("EUR", 0.90436);
		
		ArrayList<Currency> currencies = new ArrayList<Currency>();
		currencies.add(USDollar);
		currencies.add(BritishPound);
		currencies.add(JapaneseYen);
		currencies.add(Euro);
		
		CurrencyConverter converter = new CurrencyConverter(currencies);
		double result = converter.convert(BritishPound, 2, JapaneseYen);
		JOptionPane.showMessageDialog(null, result);
		System.out.println();
		
	}
}
