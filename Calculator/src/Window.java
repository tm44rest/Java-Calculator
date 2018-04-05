import javax.swing.*;
import java.awt.BorderLayout;

@SuppressWarnings("serial")
/**	An instance is a calculator window. */
class Window extends JFrame {
	private static final String windowTitle = "Calculator";
	
	/**	Constructor: the main window of the calculator. */
	private Window() {
		super(windowTitle);
		setLayout(new BorderLayout());
		
		// Create number display
		JTextArea numberDisplay = setUpNumberDisplay();
		
		// Create Number buttons
		JPanel numberPanel = setUpNumberButtons();
		
		// Create Operation buttons
		JPanel operationsPanel = setUpOperations();
		
		// Add to window
		add(numberDisplay, BorderLayout.NORTH);
		add(numberPanel, BorderLayout.WEST);
		add(operationsPanel, BorderLayout.EAST);
		
		// Make window visible
		pack();
		setLocationRelativeTo(null);	// center the window on the screen
		setVisible(true);
	}

	/**	Create and return the number display. */
	private JTextArea setUpNumberDisplay() {
		// TODO Set up number display
		return null;
	}
	
	/**	Create and return the number buttons panel. */
	private JPanel setUpNumberButtons() {
		// TODO Set up number buttons
		return null;
	}
	
	/**	Create and return the operation buttons panel. */
	private JPanel setUpOperations() {
		// TODO Set up operation buttons
		return null;
	}
}
