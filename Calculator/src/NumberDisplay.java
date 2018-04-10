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
		state = "add";
		displayedNum = new Double(0);
		currentNum = new Double(0);
		totalNum = new Double(0);
	}
	
	/** Add number to the rightmost part of currentNum. */
	public void processNumber(int number) {
		if (isDecimalized) {	// Has a decimal point
			String currentNumber = currentNum.toString();
			if (hasTensPlace) currentNum = Double.parseDouble(currentNumber + 
					number);
			else {
				currentNum = Double.parseDouble(currentNumber.substring(0, 
						currentNumber.length()-1) + number);
				hasTensPlace = true;
			}
			this.setText(currentNum.toString());	// displays a double
		}
		else {	// Does not have a decimal point
			if (currentNum == 0) currentNum = Double.parseDouble("" + number);
			else currentNum = Double.parseDouble("" + currentNum.intValue() + number);
			this.setText("" + currentNum.intValue());	// displays an integer
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
		if (!isDecimalized) {
			this.setText(this.getText() + ".");
		isDecimalized = true;
		}
	}
	
	/** Change currentNum to the opposite sign. */
	public void changeSign() {
		currentNum = currentNum*-1;
	}
	
	/** Change currentNum and displayedNum to 0. */
	public void clear() {
		currentNum = 0.0;
		displayedNum = 0.0;
		this.setText("" + currentNum.intValue());	// displays integer 0
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
		
		currentNum = 0.0;
		displayedNum = totalNum;
		this.setText(displayedNum.toString());
	}
	
	/** Set this JLabel text to n, either as an integer if n ends in .0 or a 
	 * 	double otherwise, and update field displayedNum. */
	private void displayNumber(double n) {
		// TODO Implement displayNumber(double)
	}
}
