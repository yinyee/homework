package chessgame;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

// Reference: http://www.vogella.com/tutorials/Logging/article.html
public class ChessLogger {
	
	private static FileHandler fileHandler;
	private static ChessLogFileFormatter logFormatter;
	
	public static void setup() throws IOException {
		
		// Create new instance of Logger
		Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
		
		// Set log level
//		logger.setLevel(Level.INFO);
		
		// Create new instance of formatter
		logFormatter = new ChessLogFileFormatter();
		
		// Create new instance of file handler and assign formatter to it
		fileHandler = new FileHandler("chesslog.txt");
		fileHandler.setFormatter(logFormatter);
		
		// Add file handler to logger
		logger.addHandler(fileHandler);
		
	}
}
