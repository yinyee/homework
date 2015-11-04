
public class CountLinesTester {

	public static void main (String[] args) {
		
		String logPath = "/cs/student/msc3/cs/2015/yinyekan/workspace/Tutorials/io/CountLinesLog.txt";
		String[] files = new String[1];
		files[0] = "/cs/student/msc3/cs/2015/yinyekan/workspace/Tutorials/io/log.txt";
		// files[1] = "/cs/student/msc3/cs/2015/yinyekan/workspace/Tutorials/io/backup.txt";
		
		CountLines countLines = new CountLines (files, logPath);
		countLines.run();
	}
	
	
}
