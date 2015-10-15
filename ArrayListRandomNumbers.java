import java.util.ArrayList;
import java.util.Random;
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
		
		//Reference: http://stackoverflow.com/questions/409784/whats-the-simplest-way-to-print-a-java-array
		System.out.println(Arrays.toString(convertArrayList(randomNumbers)));
		
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
	
	// Reference: https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
	// Reference: Textbook, Chapter 15
	public static Integer[] convertArrayList (ArrayList<Integer> newArrayList){
		
		Integer[] newArray = new Integer[newArrayList.size()];
		
		newArray = newArrayList.toArray(newArray);
		
		return newArray;
		
	}

}
