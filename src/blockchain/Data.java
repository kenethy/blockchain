package blockchain;

/**
 * Info about all transactions
 * 
 * @author Kenedy and Ikaro
 *
 */
public class Data {

	/**
	 * 	Data Transaction
	 *  Attributes
	 *  1 - Who do the transaction
	 *  2 - Value of the transaction
	 *  3 - Who receive values
	 */
	private String source;
	private double value;
	private String receiver;

	public Data(String source, double value, String receiver) {
		super();
		this.source = source;
		this.value = value;
		this.receiver = receiver;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}	
}
