import javax.swing.JLabel;
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
		state = "add";
		displayedNum = new Double(0);
		currentNum = new Double(0);
		totalNum = new Double(0);
		displayNumber(0.0);
	}
	
	/** Add number to the rightmost part of currentNum. */
	public void processNumber(int number) {
		if (isDecimalized) {	// Has a decimal point, displays a double
			// If currentNum does not have a digit in the tens place, need to
			// add number to the tens place.
			String currentNumber = currentNum.toString();
			if (hasTensPlace) currentNum = Double.parseDouble(currentNumber + 
					number);
			else {	
				// replaces the .0 with .number
				currentNum = Double.parseDouble(currentNumber.substring(0, 
						currentNumber.length()-1) + number);
				hasTensPlace = true;
			}
		}
		else {	// Does not have a decimal point, displays an integer
			if (currentNum == 0) currentNum = Double.parseDouble("" + number);
			else currentNum = Double.parseDouble("" + currentNum.intValue() + number);
		}
		displayNumber(currentNum);
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
		if (!isDecimalized) this.setText(currentNum.intValue() + ".");
		isDecimalized = true;
	}
	
	/** Change currentNum to the opposite sign. */
	public void changeSign() {
		currentNum = currentNum*-1;
		
		displayNumber(currentNum);
	}
	
	/** Change currentNum and displayedNum to 0. */
	public void clear() {
		currentNum = 0.0;
		displayedNum = 0.0;
		isDecimalized = false;
		hasTensPlace = false;
		
		displayNumber(0.0);
	}
	
	/** Call clear() and then change totalNum to 0. */
	public void clearAll() {
		clear();
		totalNum = 0.0;
	}
	
	/** Return the totalNum and currentNum calculated together depending on
	 * 	field state. */
	public void calculateEquals() {
		if (state == "add") {
			totalNum = currentNum + totalNum;
		}
		else if (state == "subtract") {
			totalNum = totalNum - currentNum;
		}
		else if (state == "multiply") {
			totalNum = currentNum * totalNum;
		}
		else if (state == "divide") {
			totalNum = totalNum / currentNum;
		}
		else System.err.println(state);
		
		// Keep field invariants true
		currentNum = 0.0;
		isDecimalized = false;
		hasTensPlace = false;
		
		displayNumber(totalNum);
	}
	
	/** Set this JLabel text to n represented as a double if n has any digits
	 * 	in the tens place or beyond, or an integer otherwise. */
	private void displayNumber(Double n) {
		boolean displayAsInt = false;
		
		// Determine if n has any digits in the tens place and beyond
		if (n == currentNum)	displayAsInt = !hasTensPlace;
		else {
			String nString = n.toString();
			if (nString.substring(nString.lastIndexOf('.') + 1).equals("0"))
				displayAsInt = true;
		}
		
		// Integer display
		if (displayAsInt) this.setText(n.intValue() + "");
		// Double display
		else this.setText(n.toString());
		displayedNum = n;
	}
}
