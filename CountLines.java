import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;

/**
 * Talked through lots of logic with David Kelly
 */
public class CountLines {
	
	public static void main (String[] args) { // String[] args is the command line input!!
		
		for (String arg: args) {
			Path file = Paths.get(arg);
			try (BufferedReader reader = Files.newBufferedReader(file)) {
				long lines = reader.lines().count();
				System.out.println(file.toString() + " contains " + lines + " lines");
			} catch (IOException e){
				System.out.println("Error while reading file: " + file.toString());
			}
		}
	}
}
