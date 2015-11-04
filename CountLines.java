import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;

/**
 * This class relies heavily on Java Tutorials on File I/O available at https://docs.oracle.com/javase/tutorial/essential/io/fileio.html
 * @author yinyekan
 *
 */

public class CountLines {

	private Path logPath;
	private String[] files;
	private StringBuilder str;
	
	public CountLines (String[] files, String logPath) {
		this.logPath = Paths.get(logPath);
		this.files = files;
	}
	
	public void run () {
			
		// Load input file path
		// Count lines in input file
		// Append result to str
		try {
			for (int i = 0; i < files.length; i++) {
				Path file = Paths.get(files[i].toString());
				List<String> fileContents = Files.readAllLines(file);
				str.append(file.toString() + " " + fileContents.size() + "lines\n");
				System.out.println(str.toString());
			}
		} catch (IOException e) {
			System.out.println("Exception occured while reading");
		}
		
		// Check if log.txt exists
		// If does not exist, create log.txt
		// Append str to log.txt
		// Clear str
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt"))) {
			Files.write(logPath, str.toString().getBytes(), StandardOpenOption.CREATE); // http://www.java-examples.com/stringbuffer-byte-array-java-example
		} catch (IOException e) {
			System.out.println("Exception occured while writing log");
		} finally {
			str = null;
		}
	}
}