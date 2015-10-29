package currencyconverter;

public class Currency {
	
	private String currencyCode;
	private double exchangeRate;
	
	public Currency (String currencyCode, double exchangeRate) {
		this.currencyCode = currencyCode;
		this.exchangeRate = exchangeRate;
	}
	
	public double getExchangeRate () {
		return exchangeRate;
	}

}
