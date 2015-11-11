package chessgame;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class ChessLogFileFormatter extends Formatter {

	@Override
	public String format(LogRecord record) {
		
		// Reference: http://www.tutorialspoint.com/java/java_string_buffer.htm
		StringBuffer stringBuffer = new StringBuffer();
		
		// Add information to the log entry
		stringBuffer.append("\n");
		stringBuffer.append(formatDate(record.getMillis()));
//		stringBuffer.append(">>");
		stringBuffer.append(record.getSourceClassName());
//		stringBuffer.append(">>");
		stringBuffer.append(record.getSourceMethodName());
//		stringBuffer.append(">>");
		stringBuffer.append(record.getLevel());
//		stringBuffer.append(">>");
		stringBuffer.append(record.getMessage());
		stringBuffer.append("\n");
		
		return stringBuffer.toString();
	}

	private String formatDate(long millis) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy HH:mm");
		return dateFormat.format(new Date(millis));
	}
	
}
