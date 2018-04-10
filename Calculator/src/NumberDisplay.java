import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
/** An instance is a number display for a calculator. 
 * This is the "brains" of the calculator (i.e. where all the 
 * calculations happen). */
public class NumberDisplay extends JLabel {
	private String state;	// state of the calculator i.e. what operation it is performing
	
	private Double displayedNum;	// current double being displayed
	private Double currentNum;	// current double in memory. if != 0, equal to displayedNum
	private Double totalNum;	// total double that is in memory to be calculated
	
	private boolean isDecimalized;	// "currentNum has a decimal place somewhere"
	private boolean hasTensPlace;	// "isDecimalized and the tens place has been given"
	
	public NumberDisplay() {
		super("0", SwingConstants.RIGHT);
		state = "equals";
		displayedNum = new Double(0);
		currentNum = new Double(0);
		totalNum = new Double(0);
	}
	
	/** Process an integer depending on the state of the calculator. */
	public void processNumber(int number) {
		// Add number to the right of currentNum
		if (isDecimalized) {	// Has a decimal point
			String currentNumber = currentNum.toString();
			if (hasTensPlace) currentNum = Double.parseDouble(currentNumber + 
					number);
			else {
				currentNum = Double.parseDouble(currentNumber.substring(0, 
						currentNumber.length()-1) + number);
				hasTensPlace = true;
			}
			this.setText(currentNum.toString());
		}
		else {	// Does not have a decimal point
			if (currentNum == 0) currentNum = Double.parseDouble("" + number);
			else currentNum = Double.parseDouble("" + currentNum.intValue() + number);
			this.setText("" + currentNum.intValue());
		}
		displayedNum = currentNum;
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
		if (!isDecimalized) this.setText(this.getText() + ".");
		isDecimalized = true;
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
