import java.util.Scanner;
public class Calculator{

	public static void main(String[] args) {
		
		System.out.println("Simple calculator.  Please choose an operation:\n1. Add\n2. Subtract\n3. Multiply\n4. Divide\n5. Factorial\n6. Exit");
		Scanner robot = new Scanner(System.in);
		int userSelection = robot.nextInt();
		float num1, num2;
		
		switch (userSelection){
			case 1:
				System.out.println("num1 + num2\nPlease enter num1:");
				num1 = robot.nextFloat();
				System.out.println("Please enter num2:");
				num2 = robot.nextFloat();
				System.out.println("The sum of " + num1 + " and " + num2 + " is " + add(num1, num2));
				break;
			case 2:
				System.out.println("num1 - num2\nPlease enter num1:");
				num1 = robot.nextFloat();
				System.out.println("Please enter num2:");
				num2 = robot.nextFloat();
				System.out.println(num2 + " subtracted from " + num1 + " is " + subtract(num1, num2));
				break;
			case 3:
				System.out.println("num1 x num2\nPlease enter num1:");
				num1 = robot.nextFloat();
				System.out.println("Please enter num2:");
				num2 = robot.nextFloat();
				System.out.println("Multiplying " + num1 + " and " + num2 + " gives " + multiply(num1, num2));
				break;
			case 4:
				System.out.println("num1 / num2\nPlease enter num1:");
				num1 = robot.nextFloat();
				System.out.println("Please enter num2:");
				num2 = robot.nextFloat();
				System.out.println(num1 + " divided by " + num2 + " gives " + divide(num1, num2));
				break;
			case 5:
				System.out.println("num!\nPlease enter num:");
				int num = robot.nextInt();
				if (num >= 0){
					System.out.println("The factorial of " + num + " is " + factorial(num));
				} else {
					System.out.println("Unable to compute factorial for negative numbers");
				}
				break;
			default: 
				System.out.println("You have exited the calculator.");
				exit();
				break;
		}
		
		robot.close();

	}
	
	public static float add(float num1, float num2){
		float result = num1 + num2;
		return result;
	}
	
	public static float subtract(float num1, float num2){
		float result = num1 - num2;
		return result;
	}
	
	public static float multiply(float num1, float num2){
		float result = num1 * num2;
		return result;
	}

	public static float divide(float num1, float num2){
		float result = num1 / num2;
		return result;
	}
	
	public static int factorial(int num){
		int result = 1;
		while (num > 0){
			result = result * num--;
		}
		return result;
	}
	
	public static void exit(){
		System.exit(0);
	}
}
