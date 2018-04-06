import javax.swing.JTextArea;

@SuppressWarnings("serial")
/** An instance is a number display for a calculator. 
 * This is the "brains" of the calculator (i.e. where all the 
 * calculations happen). */
public class NumberDisplay extends JTextArea {
	private String state;	// state of the calculator i.e. what operation it is performing
	private double currentNum;	// current double being displayed
	private double totalNum;	// total double that is in memory to be calculated
	private boolean isDecimalized;	// "currentNum has a decimal place somewhere"
	
	public NumberDisplay() {
		super();
		state = "equals";
	}
	
	/** Process an integer depending on the state of the calculator. */
	public void processNumber(int number) {
		// TODO process the integers passed from Window
	}
	
	/** Change the state to String newState */
	public void changeState(String newState) {
		state = newState;
	}
	
	/** If currentNum does not have a decimal point, give it a decimal point
	 * 	at the right most place. */
	public void decimalize() {
		// TODO give currentNum a decimal place
	}
	
}
