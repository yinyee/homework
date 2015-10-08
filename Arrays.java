
public class Arrays {

	public static void main(String[] args) {
		
		int numbers [] = new int[20];
		numbers [0] = 1;
		System.out.println("numbers[0] = " + numbers[0]);
		for (int i = 1; i < 20; i++){
			numbers [i] = 2 * numbers [i-1];
			System.out.println("numbers[" + i + "] = " + numbers[i]);
		}
		
		System.out.println();
		
		float means [] = new float [20];
		means [0] = numbers [0];
		means [19] = numbers [19];
		System.out.println("means[0] = " + means[0]);
		for (int i = 1; i < 19; i++){
			means [i] = (float) (numbers[i-1] + numbers[i+1])/2; // Reference: http://stackoverflow.com/questions/4377842/how-can-i-convert-integer-into-float-in-java
			System.out.println("means[" + i + "] = " + means[i]);
		}
		System.out.println("means[19] = " + means[19]);

	}

}
