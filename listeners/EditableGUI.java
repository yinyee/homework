package listeners;

import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class EditableGUI implements MouseListener, MouseMotionListener {

	private JFrame frame;
	private JButton button1;
	private JButton button2;
	private JTextArea output;
	private int xCoordinate, yCoordinate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditableGUI window = new EditableGUI();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EditableGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		output = new JTextArea();
		output.setBounds(6, 241, 438, 31);
		frame.getContentPane().add(output);
		
		button1 = new JButton("Oh la la!");
		button1.setName("Oh lal la!");
		button1.addMouseListener(this);
		button1.addMouseMotionListener(this);
		button1.setBounds(73, 72, 85, 73);
		frame.getContentPane().add(button1);
		
		button2 = new JButton("Mama mia!");
		button2.setName("Mama mia!");
		button2.addMouseListener(this);
		button2.addMouseMotionListener(this);
		button2.setBounds(273, 72, 92, 73);
		frame.getContentPane().add(button2);
	}

	/**
	 * Implement methods
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		xCoordinate = e.getComponent().getX() + e.getX();
		yCoordinate = e.getComponent().getY() + e.getY();
		e.getComponent().setBounds(xCoordinate, yCoordinate, e.getComponent().getWidth(), e.getComponent().getHeight());
		output.setText(e.getComponent().getName() + " moved to " + "(" + xCoordinate + ", " + yCoordinate + ")\n");
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseMoved(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}
	
	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
	
}
