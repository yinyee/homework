import java.util.Scanner;
public class ProgramFlow {

	public static void main(String[] args) {
		Scanner robot = new Scanner(System.in);
		
		System.out.println("This program can check if any number you enter is an even number.\nPlease enter your number:");
		int number = robot.nextInt();

		if (isEven(number)) {
			System.out.println(number + " is even");
		} else {
			System.out.println(number + " is not even");
		}
		
		robot.close();
	}

	// Reference: https://moodle.ucl.ac.uk/pluginfile.php/3082019/mod_resource/content/1/Tutorial%202.pdf
	public static boolean isEven(int number){
		return (number % 2 == 0) ? true : false; // Can do away with "?" since (number % 2 == 0) evaluates to a boolean
	}
}
