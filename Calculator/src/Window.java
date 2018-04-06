import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
/**	An instance is a calculator window. */
class Window extends JFrame implements ActionListener {
	private static final String windowTitle = "Calculator";	// Title of the window
	
	// Number buttons
	private JButton number1;
	private JButton number2;
	private JButton number3;
	private JButton number4;
	private JButton number5;
	private JButton number6;
	private JButton number7;
	private JButton number8;
	private JButton number9;
	private JButton number0;
	private JButton negButton;	// Makes the number negative
	private JButton decimalPointButton;	// Makes future number inputs decimal points
	
	// Operation buttons
	private JButton additionButton;	// addition operation
	private JButton subtractionButton;	// subtraction operation
	private JButton multiplicationButton;	// multiplication operation
	private JButton divisionButton;	// division operation
	private JButton clearButton;	// clears memory of current entry
	private JButton clearAllButton;	// clears memory of all entries
	private JButton equalsButton;	// displays the result of all previous operations
	
	/**	Constructor: the main window of the calculator. */
	private Window() {
		super(windowTitle);
		setLayout(new BorderLayout());
		
		// Create number display
		JTextArea numberDisplay = setUpNumberDisplay();
		
		// Create Number buttons
		JPanel numberPanel = setUpNumberPanel();
		
		// Create Operation buttons
		JPanel operationsPanel = setUpOperationsPanel();
		
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
		return new JTextArea();
	}
	
	/** Creates and returns a formatted JButton with text from String s and adds
	 *  it to JPanel panel if panel is non-null. */
	private JButton createJButton(String s, JPanel panel) {
		JButton jb = new JButton(s);
		jb.setHorizontalTextPosition(SwingConstants.CENTER);
		jb.addActionListener(this);
		if (panel != null) panel.add(jb);
		return jb;
	}
	
	/**	Set up and return the number buttons panel. */
	private JPanel setUpNumberPanel() {
		JPanel numberPanel = new JPanel(new GridLayout(4,3));	// 4x3 panel
		numberPanel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		number9 = createJButton("9", numberPanel);
		number8 = createJButton("8", numberPanel);
		number7 = createJButton("7", numberPanel);
		number6 = createJButton("6", numberPanel);
		number5 = createJButton("5", numberPanel);
		number4 = createJButton("4", numberPanel);
		number3 = createJButton("3", numberPanel);
		number2 = createJButton("2", numberPanel);
		number1 = createJButton("1", numberPanel);
		negButton = createJButton("+/-", numberPanel);
		decimalPointButton = createJButton(".", numberPanel);
		number0 = createJButton("0", numberPanel);
		
		return numberPanel;
	}
	
	/**	Create and return the operation buttons panel. */
	private JPanel setUpOperationsPanel() {
		JPanel operationsPanel = new JPanel(new GridLayout(7,1)); // 7x1 panel
		clearAllButton = createJButton("CE", operationsPanel);
		clearButton = createJButton("C", operationsPanel);
		divisionButton = createJButton("/", operationsPanel);
		multiplicationButton = createJButton("*", operationsPanel);
		subtractionButton = createJButton("-", operationsPanel);
		additionButton = createJButton("+", operationsPanel);
		equalsButton = createJButton("=", operationsPanel);
		
		return operationsPanel;
	}

	/**	Process event e from the buttons */
	@Override public void actionPerformed(ActionEvent e) {
		// TODO Process button clicks
		
	}
	
	/** Start the GUI */
	public static void main (String args[]) {
		Window mainWindow = new Window();
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
