import java.util.Date;
import java.util.Scanner;

// Exercise 1: Javadoc

/**
 * This is a simple interactive application that will ask for
 * the user's name and birthday, and sing a personalised
 * version of the Happy Birthday song.
 * 
 * It is also able to handle the simple error of a user not
 * providing any input when asked.
 * 
 * @author yinyekan
 * @version $Date: 02/10/2015 $
 */

public class HappyBirthdaySong {

	public static void main(String[] args) {
		
		Scanner robot = new Scanner(System.in);
		Date todayDate = new Date(); // Learnt to import this object on the Stack Overflow forum
		
		System.out.println("Hello, World!\nToday's date is " + todayDate.toString()); // Exercise 2: Multiline print
		
		System.out.println("What is your name?");
		String userName = robot.nextLine(); // Exercise 3: User input
		
		// Exercise 4: Conditionals
		while (userName.isEmpty()){
			System.out.println("I'm sorry I didn't get that. What is your name?");
			userName = robot.nextLine();
		}
		
		if (userName.length() < 2){
			System.out.println("Madonna made the first name fashionable, so go on and blaze a trail!");
		}
		
		System.out.println("Nice to meet you, " + userName + ". When is your birthday?");
		
		String userBirthday = robot.nextLine(); // Variable not used as input format not specified for user
		System.out.println("Oh dear, I won't be around then so let me wish you a 'Happy Birthday' now");
		
		// Exercise 5: Loops
		int count = 1;
		while (count < 3){
			System.out.println("Happy birthday to you");
			count++;
		}
		
		/*
		for (int count = 1; count < 3; count++){
			System.out.println("Happy birthday to you");
		}*/
		
		System.out.println("Happy birthday, dear " + userName);
		System.out.println("Happy birthday to you!");
		
		robot.close(); // Learnt to resolve this error on the Stack Overflow forum
	}

}
