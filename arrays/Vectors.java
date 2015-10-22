package arrays;
import java.util.Collections;
import java.util.Vector;
import java.util.Scanner;
public class Vectors {

	public static void main(String[] args) {
		Vector<Integer> unsortedVector = new Vector<Integer>(); // Reference: http://stackoverflow.com/questions/11697366/java-vector-declaration
		System.out.println("Please enter only positive real numbers.  End with a '0' to indicate that input has concluded.");

		Scanner robot = new Scanner(System.in);
		int temp;
		
		// Reference : https://docs.oracle.com/javase/tutorial/java/nutsandbolts/while.html
		do {
			temp = robot.nextInt();
			if (temp != 0){
				unsortedVector.add(temp);	
			}			
		} while (temp != 0);
		
		for (int i = 0; i < unsortedVector.size(); i++){
			System.out.println("unsortedVector[" + i + "] = " + unsortedVector.get(i));
		}
		
		Collections.sort(unsortedVector);  // Reference: David Kelly
		
		for (int i = 0; i < unsortedVector.size(); i++){
			System.out.println("sortedVector[" + i + "] = " + unsortedVector.get(i));
		}
		
		robot.close();
	}

}
