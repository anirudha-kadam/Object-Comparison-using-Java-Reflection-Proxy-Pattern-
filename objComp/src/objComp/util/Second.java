package objComp.util;

/**
 * 
 * @author Anirudha
 * class to be deserialized
 */
public class Second {

	/**
	 * {@link Second} class default constructor
	 */
	public Second(){
		MyLogger.singletonMyLogger().printToStdOut(2, "Second class default constructor has been called");
	}
	
	private double DoubleValue;

	private int IntValue;
	
	/**
	 * setter method
	 * @param dIn
	 */
	public void setDoubleValue(double dIn) {
		MyLogger.singletonMyLogger().printToStdOut(3, "Second class setDoubleValue(double dIn) method has been called");
		DoubleValue = dIn;
	}

	/**
	 * setter method
	 * @param iIn
	 */
	public void setIntValue(int iIn) {
		MyLogger.singletonMyLogger().printToStdOut(3, "Second class setIntValue(int iIn) method has been called");
		IntValue = iIn;
	}

	/**
	 * hashCode method
	 */
	@Override
	public int hashCode() {
		MyLogger.singletonMyLogger().printToStdOut(3, "Second class hashCode() method has been called");
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(DoubleValue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + IntValue;
		return result;
	}

	/**
	 * returns true if two objects are equal
	 */
	@Override
	public boolean equals(Object obj) {
		MyLogger.singletonMyLogger().printToStdOut(3, "Second class equals(Object obj) method has been called");
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Second other = (Second) obj;
		if (Double.doubleToLongBits(DoubleValue) != Double
				.doubleToLongBits(other.DoubleValue))
			return false;
		if (IntValue != other.IntValue)
			return false;
		return true;
	}

	/**
	 * toString method
	 */
	@Override
	public String toString() {
		MyLogger.singletonMyLogger().printToStdOut(3, "Second class toString() method has been called");
		return "Second [DoubleValue=" + DoubleValue + ", IntValue=" + IntValue
				+ "]";
	}
	
}
