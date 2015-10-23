/**
 * @param cardNumber String containing the 16-digit credit card number with no spaces between digits
 * @param expiryMonth int containing the number corresponding to the expiry month with no zero-padding
 * @param expiryYear int containing the 4-digit number corresponding to the expiry year
 * @param firstName String containing the first name
 * @param lastName String containing the last name
 */

package creditcard;
import java.util.Calendar;
public class CreditCard {
	
	private String cardNumber;
	private String firstName;
	private String lastName;
	private int expiryMonth;
	private int expiryYear;
	private boolean isValid;
	
	public CreditCard (String cardNumber, int expiryMonth, int expiryYear, String firstName, String lastName){
		this.cardNumber = cardNumber;
		this.expiryMonth = expiryMonth;
		this.expiryYear = expiryYear;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	// Reference: David Kelly
	// Reference: http://docs.oracle.com/javase/7/docs/api/java/lang/StringBuilder.html
	public String toString(){
		StringBuilder strBuilder1 = new StringBuilder();
		strBuilder1.append("Card number: ");
		strBuilder1.append(getCardNumber());
		strBuilder1.append("\nExiry date: ");
		strBuilder1.append(getExpiryDate());
		strBuilder1.append("\nAccount holder: ");
		strBuilder1.append(getFullName());
		strBuilder1.append("\nValid card: ");
		strBuilder1.append(isValid());
		return strBuilder1.toString();
	}
	
	public String getExpiryDate(){
		return expiryMonth + "/" + expiryYear;
	}

	public String getFullName(){
		return firstName + " " + lastName;
	}
	
	public String getCardNumber(){
		StringBuilder strBuilder2 = new StringBuilder(cardNumber);
		strBuilder2.insert(4, ' ');
		strBuilder2.insert(9, ' ');
		strBuilder2.insert(14, ' ');
		String formattedCardNumber = strBuilder2.toString();
		return formattedCardNumber;
	}
	
	public boolean isValid(){
		Calendar calendar = Calendar.getInstance(); // Reference: http://docs.oracle.com/javase/7/docs/api/java/util/Calendar.html
		int currentMonth = calendar.get(Calendar.MONTH); // Reference: http://examples.javacodegeeks.com/java-basics/java-calendar-example/
		int currentYear = calendar.get(Calendar.YEAR);
		if (expiryYear > currentYear){
			isValid = true;
		} else if (expiryYear == currentYear && expiryMonth > currentMonth) {
			isValid = true;
		} else {
			isValid = false;
		}
		return isValid;
	}
}
