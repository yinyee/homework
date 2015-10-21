package creditcard;

import java.util.Calendar;

public class CreditCard {
	
	private String cardNumber;
	private String firstName;
	private String lastName;
	private int expiryMonth;
	private int expiryYear;
	
	public CreditCard (String cardNumber, int expiryMonth, int expiryYear, String firstName, String lastName){
		this.cardNumber = cardNumber;
		this.expiryMonth = expiryMonth;
		this.expiryYear = expiryYear;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String formatExpiryDate(){
		String formattedExpiryDate = "expiryMonth" + "/" + "expiryYear";
		return formattedExpiryDate;
	}

	public String formatFullName(){
		String fullName = firstName + lastName;
		return fullName;
	}
	
	public String formatCardNumber(){
		String formattedCardNumber;
		return formattedCardNumber;
	}
	
	public boolean isValid(){
		Calendar calendar = new Calendar(); // Reference: http://docs.oracle.com/javase/7/docs/api/java/util/Calendar.html
		
	}
}
