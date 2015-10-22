package creditcard;

public class CreditCardTester {
	
	public static void main (String[] args){
		
		CreditCard validCard = new CreditCard("1234123412341234", 7, 2017, "Yin Yee", "Kan");
		System.out.println(validCard.toString());
		System.out.println();
		
		CreditCard invalidCard1 = new CreditCard("2468246824682468", 2, 2015, "Secret", "Alterego");
		System.out.println(invalidCard1.toString());
		System.out.println();
		
		CreditCard invalidCard2 = new CreditCard("0000000000000000", 11, 2000, "Robot", "Overlord");
		System.out.println(invalidCard2.toString());
		System.out.println();
	}

}
