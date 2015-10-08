import java.util.Scanner;
public class ByteConversion {

	public static void main(String[] args) {
		
		final String[] UNITS = {"B", "KB", "MB", "GB"}; // Reference: https://moodle.ucl.ac.uk/pluginfile.php/3058331/mod_resource/content/1/Tutorial%201.pdf
		float inputBytes;
		
		Scanner robot = new Scanner(System.in);
		System.out.println("Please enter number of bytes:");
		inputBytes = robot.nextFloat();
		
		float[] results = new float[UNITS.length];
		for (int i = 0; i < results.length; i++){
			results[i] = inputBytes / (float) Math.pow(Math.pow(2, 10), i); // Reference: http://stackoverflow.com/questions/4377842/how-can-i-convert-integer-into-float-in-java
			System.out.println(results[i] + UNITS[i]);
		}
		robot.close();
	}

}
