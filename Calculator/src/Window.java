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
	private JButton subtractionButtion;	// subtraction operation
	private JButton multiplicationButton;	// multiplication operation
	private JButton divisionButton;	// division operation
	private JButton clear;	// clears memory of current entry
	private JButton clearAll;	// clears memory of all entries
	
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
	
	/** Creates and returns a formatted JButton with text from String s and
	 * 	adds it to ButtonGroup group. */
	private JButton createJButton(String s, ButtonGroup group) {
		JButton jb = new JButton(s);
		group.add(jb);
		jb.setHorizontalTextPosition(SwingConstants.CENTER);
		jb.addActionListener(this);
		return jb;
	}
	
	/**	Set up and return the number buttons panel. */
	private JPanel setUpNumberPanel() {
		// Set up number buttons
		ButtonGroup numbers = new ButtonGroup();
		number1 = createJButton("1", numbers);
		number2 = createJButton("2", numbers);
		number3 = createJButton("3", numbers);
		number4 = createJButton("4", numbers);
		number5 = createJButton("5", numbers);
		number6 = createJButton("6", numbers);
		number7 = createJButton("7", numbers);
		number8 = createJButton("8", numbers);
		number9 = createJButton("9", numbers);
		number0 = createJButton("0", numbers);
		negButton = createJButton("-", numbers);
		decimalPointButton = createJButton(".", numbers);
		
		// Create number panel
		JPanel numberPanel = new JPanel(new GridLayout(4,3));
		numberPanel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		numberPanel.add(number9);
		numberPanel.add(number8);
		numberPanel.add(number7);
		numberPanel.add(number6);
		numberPanel.add(number5);
		numberPanel.add(number4);
		numberPanel.add(number3);
		numberPanel.add(number2);
		numberPanel.add(number1);
		numberPanel.add(negButton);
		numberPanel.add(decimalPointButton);
		numberPanel.add(number0);
		
		return numberPanel;
	}
	
	/**	Create and return the operation buttons panel. */
	private JPanel setUpOperationsPanel() {
		// TODO Set up operation buttons
		return new JPanel();
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
