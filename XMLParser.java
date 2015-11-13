import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class XMLParser extends JFrame {
	
	final JFileChooser fileChooser = new JFileChooser();
	final File defaultDirectory = new File("/Users/yinyee/Documents/workspace/Homework/src");
	private int command;
	private static File input;
	private JFrame display;
	private JTextArea parseResult;
	private JScrollPane scrollableParseResult;
	private JTextArea wysiwyg;
	private JScrollPane scrollableWYSIWYG;
	private JButton parseButton;
	private JButton saveButton;
	private ParserListener listener = new ParserListener();
	private StringBuilder parserStringBuilder;
	
	public XMLParser() {
		fileChooser.setCurrentDirectory(defaultDirectory);
		this.add(fileChooser);
	}
	
	public static void main (String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					XMLParser window = new XMLParser();
					window.setVisible(true);
					window.command = window.fileChooser.showOpenDialog(window); // Reference: http://stackoverflow.com/questions/17034282/jfilechooser-regarding-the-open-and-cancel-buttons-java
					switch (window.command) {
					case JFileChooser.APPROVE_OPTION:
						input = new File(window.fileChooser.getSelectedFile().toString());
						window.open(input);
						break;
					case JFileChooser.CANCEL_OPTION:
						System.exit(0);
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void open(File input) {
		
		display = new JFrame();
		display.setBounds(0, 0, 800, 600);
		display.setLayout(null);
		display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel original = new JLabel();
		original.setBounds(10, 10, 100, 30);
		original.setText("Imported file:");
		display.add(original);
		
		JLabel parsed = new JLabel();
		parsed.setBounds(405, 10, 100, 30);
		parsed.setText("Parsed:");
		display.add(parsed);
		
		wysiwyg = new JTextArea();
		wysiwyg.setWrapStyleWord(true);
		wysiwyg.setLineWrap(true);
		wysiwyg.setEditable(true);
		
		scrollableWYSIWYG = new JScrollPane(wysiwyg);
		scrollableWYSIWYG.setBounds(10, 50, 385, 450);
		scrollableWYSIWYG.getViewport().setView(wysiwyg);
		scrollableWYSIWYG.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollableWYSIWYG.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		display.add(scrollableWYSIWYG);
		
		parseResult = new JTextArea();
		parseResult.setWrapStyleWord(true);
		parseResult.setLineWrap(true);
		parseResult.setEditable(false);
		
		scrollableParseResult = new JScrollPane(parseResult);
		scrollableParseResult.setBounds(405, 50, 385, 450);
		scrollableParseResult.getViewport().setView(parseResult);
		scrollableParseResult.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollableParseResult.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		display.add(scrollableParseResult);
		
		parseButton = new JButton("Parse");
		parseButton.setBounds(295, 520, 100, 30);
		parseButton.addActionListener(listener);
		parseButton.setActionCommand("Parse");
		display.add(parseButton);
		
		saveButton = new JButton("Save");
		saveButton.setBounds(690, 520, 100, 30);
		saveButton.addActionListener(listener);
		saveButton.setActionCommand("Save");
		display.add(saveButton);
		
		display.setVisible(true);
		
		// WYSIWYG
		// Reference: http://stackoverflow.com/questions/5868369/how-to-read-a-large-text-file-line-by-line-using-java
		try {
			BufferedReader reader = new BufferedReader(new FileReader(input));
			StringBuilder wysiwygStringBuilder = new StringBuilder();
			String readLine;
			while ((readLine = reader.readLine()) != null) {
				wysiwygStringBuilder.append(readLine + "\n");
			}
			wysiwyg.setText(wysiwygStringBuilder.toString());
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Reference: http://www.w3schools.com/Xml/xml_tree.asp
	private void outputDOMTree(Node node) {

		if (node.getNodeType() == Node.ELEMENT_NODE) {
			parserStringBuilder.append(node.getNodeName() + ": " + node.getFirstChild().getTextContent() + "\n");
			getAttributes((Element) node);
		}

		if (node.hasChildNodes()) {
			NodeList children = node.getChildNodes();
			for (int i = 1; i < children.getLength(); i++) {
				outputDOMTree(children.item(i));
			}
		}
	}
	
	private void getAttributes(Element element){
		// Check if current element has attributes
		if (element.hasAttributes()) {
		
			// Get attribute map
			NamedNodeMap attributes = element.getAttributes();
			
			// Iterate over node attributes
			for (int j = 0; j < attributes.getLength(); j++) {	
				// Output attributes
				if (attributes.item(j).getNodeType() == Node.ATTRIBUTE_NODE) {
					parserStringBuilder.append(attributes.item(j).getNodeName() + ": " + element.getAttribute(attributes.item(j).getNodeName()) + "\n");
				}
			}
		}
	}
	
	private class ParserListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case ("Parse"): 
				ActionThread parseThread = new ActionThread();
				parseThread.start();
				System.out.println(input.toString());
				parseThread.parse(input);
				break;
			case ("Save"): 
				ActionThread saveThread = new ActionThread();
				saveThread.start();
//				 create new file from edited
//				 parse new file
//				 ok ? save : display error
			}	
		}		
	}
	
	private class ActionThread extends Thread {
	
		private void parse(File input) {

			// PARSER
			// Reference: http://www.tutorialspoint.com/java_xml/java_dom_parse_document.htm
			try {
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder docBuilder = factory.newDocumentBuilder();
				Document doc = docBuilder.parse(input);
				doc.getDocumentElement().normalize();
				parserStringBuilder = new StringBuilder();
				parserStringBuilder.append("Root element: " + doc.getDocumentElement().getNodeName() + "\n");
				parserStringBuilder.append("-----------------------------------\n");
				outputDOMTree(doc.getDocumentElement());
			parseResult.setText(parserStringBuilder.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
