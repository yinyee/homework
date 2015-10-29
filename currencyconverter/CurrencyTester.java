package currencyconverter;

public class CurrencyTester {
	
	public static void main (String[] args) {
		
		// All currency pairs are quoted with respect to the US Dollar, as per convention
		Currency USDollar = new Currency ("USD", 1.0000);
		Currency BritishPound = new Currency ("GBP", 0.65154);
		Currency JapaneseYen = new Currency ("JPY", 121.025);
		Currency Euro = new Currency ("EUR", 0.90436);
		
		System.out.println(USDollar.getExchangeRate());
		System.out.println(BritishPound.getExchangeRate());
		System.out.println(JapaneseYen.getExchangeRate());
		System.out.println(Euro.getExchangeRate());
		
	}

}
