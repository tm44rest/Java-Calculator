import javax.swing.JTextArea;

@SuppressWarnings("serial")
/** An instance is a number display for a calculator. 
 * This is the "brains" of the calculator (i.e. where all the 
 * calculations happen). */
public class NumberDisplay extends JTextArea {
	private String state;	// state of the calculator i.e. what operation it is performing
	private double displayedNum;	// current double being displayed
	private double currentNum;	// current double in memory. if != 0, equal to displayedNum
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
	
	/** Change the state to String newState. If currentNum != 0, 
	 * 	process the numbers in memory before the state change. */
	public void changeState(String newState) {
		if (currentNum != 0) calculateEquals();
		state = newState;
	}
	
	/** If currentNum does not have a decimal point, give it a decimal point
	 * 	at the right most place. */
	public void decimalize() {
		// TODO give currentNum a decimal place
	}
	
	/** Change currentNum to the opposite sign. */
	public void changeSign() {
		currentNum = currentNum*-1;
	}
	
	public void clear() {
		// TODO perform the clear operation
	}
	
	public void clearAll() {
		// TODO perform the clear all operation
	}
	
	public void calculateEquals() {
		// TODO perform the equals operation
	}
}
