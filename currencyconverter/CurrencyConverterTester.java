package currencyconverter;

import java.util.HashMap;

// Reference: http://cs.lmu.edu/~ray/notes/javagraphics/
public class CurrencyConverterTester {

	public static void main (String[] args) {
		
		// Load currencies
		HashMap<String, Double> currencies = new HashMap<String, Double>();
		currencies.put("USD", 1.0000);
		currencies.put("GBP", 0.65154);
		currencies.put("JPY", 121.025);
		currencies.put("EUR", 0.90436);
		
		CurrencyConverterGUI converter = new CurrencyConverterGUI(currencies);
	}
}
