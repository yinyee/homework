package arrays;
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;
public class ArrayListRandomNumbers {

	public static void main(String[] args) {
		
		ArrayList<Integer> randomNumbers = new ArrayList<>(); // Reference: http://www.dotnetperls.com/arraylist-java
		Random generator = new Random(); // Reference: http://docs.oracle.com/javase/7/docs/api/java/util/Random.html
		int size = 100;
		
		// Reference: http://www.dotnetperls.com/arraylist-java
		// Reference: http://docs.oracle.com/javase/7/docs/api/java/util/Random.html
		for (int i = 0; i < size; i++){
			randomNumbers.add(generator.nextInt(101)); 
			System.out.println("randomNumbers[" + i + "] = " + randomNumbers.get(i));
		} 

		System.out.println("The sum of all even numbers in the ArrayList = " + sumEven(randomNumbers));
		
		randomNumbers = moveNegativeBack(randomNumbers);
		
		Integer[] printArray = new Integer[size];
		printArray = randomNumbers.toArray(printArray);
		System.out.println(Arrays.toString(printArray)); // Reference: http://stackoverflow.com/questions/27495525/why-is-this-printing-the-memory-address-of-array
		
	}
	
	public static int sumEven(ArrayList<Integer> randomNumbers){
		int sum = 0;
		
		for (int i = 0; i < 100; i++){
			if (randomNumbers.get(i) % 2 == 0) {
				sum = sum + randomNumbers.get(i);
			}
		}		
		
		return sum; 
	}
	
	public static ArrayList<Integer> moveNegativeBack(ArrayList<Integer> randomNumbers){
		
		ArrayList<Integer> oddRandomNumbers = new ArrayList<>();
		ArrayList<Integer> newArrayList = new ArrayList<>();
		
		for (int i = 0; i < randomNumbers.size(); i++){
			if (randomNumbers.get(i) % 2 == 0){
				newArrayList.add(randomNumbers.get(i));
			} else {
				oddRandomNumbers.add(randomNumbers.get(i));
			}
		}
		
		for (int i = 0; i < oddRandomNumbers.size(); i++){
			newArrayList.add(oddRandomNumbers.get(i));
		}
		
		return newArrayList;
	}

}
