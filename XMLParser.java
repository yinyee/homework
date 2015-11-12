import java.awt.EventQueue;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class XMLParser extends JFrame {
	
	final static JFileChooser fileChooser = new JFileChooser();
	final File defaultDirectory = new File("/Users/yinyee/Documents/workspace/Homework/src");
	private static int command;
	private static File input;
	
	public XMLParser() {
		fileChooser.setCurrentDirectory(defaultDirectory);
		this.add(fileChooser);
		this.setBounds(0, 0, 600, 400);
	}
	
	public static void main (String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					XMLParser window = new XMLParser();
					window.setVisible(true);
					command = fileChooser.showOpenDialog(window); // Reference: http://stackoverflow.com/questions/17034282/jfilechooser-regarding-the-open-and-cancel-buttons-java
					switch (command) {
					case JFileChooser.APPROVE_OPTION:
						input = new File(fileChooser.getSelectedFile().toString());
						parse(input);
						break;
					case JFileChooser.CANCEL_OPTION:
						// something
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	// Reference: http://www.tutorialspoint.com/java_xml/java_dom_parse_document.htm
	private static void parse(File input) {
		try {
			JFrame display = new JFrame();
			display.setLayout(null);
			display.setBounds(0, 0, 800, 600);
			JTextArea wysiwyg = new JTextArea();
			wysiwyg.setBounds(10, 10, 385, 580);
			display.add(wysiwyg);
			JTextArea parseResult = new JTextArea();
			parseResult.setBounds(405, 10, 385, 580);
			display.add(parseResult);
			
			// WYSIWYG
			// Reference: http://stackoverflow.com/questions/5868369/how-to-read-a-large-text-file-line-by-line-using-java
			BufferedReader reader = new BufferedReader(new FileReader(input));
			StringBuilder wysiwygStringBuilder = new StringBuilder();
			String readLine;
			while ((readLine = reader.readLine()) != null) {
				wysiwygStringBuilder.append(readLine + "\n");
			}
			wysiwyg.setText(wysiwygStringBuilder.toString());
			reader.close();
			
			// PARSER
			// Reference: http://www.tutorialspoint.com/java_xml/java_dom_parse_document.htm
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = factory.newDocumentBuilder();
			Document doc = docBuilder.parse(input);
			doc.getDocumentElement().normalize();
			StringBuilder parserStringBuilder = new StringBuilder();
			parserStringBuilder.append("Root element: " + doc.getDocumentElement().getNodeName() + "\n");
			parserStringBuilder.append("-----------------------------------\n");
			NodeList nodeList = doc.getElementsByTagName("book");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				parserStringBuilder.append("Current element: " + node.getNodeName() + "\n");
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					parserStringBuilder.append("Book ID: " + element.getAttribute("id") + "\n");
					parserStringBuilder.append("Author: " + element.getElementsByTagName("author").item(0).getTextContent() + "\n");
					parserStringBuilder.append("Title: " + element.getElementsByTagName("title").item(0).getTextContent() + "\n");
					parserStringBuilder.append("Genre: " + element.getElementsByTagName("genre").item(0).getTextContent() + "\n");
					parserStringBuilder.append("Price: " + element.getElementsByTagName("price").item(0).getTextContent() + "\n");
					parserStringBuilder.append("Date published: " + element.getElementsByTagName("publish_date").item(0).getTextContent() + "\n");
					parserStringBuilder.append("Description: " + element.getElementsByTagName("description").item(0).getTextContent() + "\n");
					parserStringBuilder.append("\n");
				}
			}
			parseResult.setText(parserStringBuilder.toString());
			
			
			
			
			display.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
