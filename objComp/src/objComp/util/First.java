package objComp.util;

/**
 * 
 * @author Anirudha
 * class to be deserialized
 */
public class First {

	/**
	 * {@link First} class default constructor
	 */
	public First(){
		MyLogger.singletonMyLogger().printToStdOut(2, "First class default constructor has been called");
	}
	
	private int IntValue;
	
	private String StringValue;
	
	/**
	 * setter method
	 * @param iIn
	 */
	public void setIntValue(int iIn) {
		MyLogger.singletonMyLogger().printToStdOut(3, "First class setIntValue(int iIn) method has been called");
		IntValue = iIn;
	}

	/**
	 * setter method
	 * @param sIn
	 */
	public void setStringValue(String sIn) {
		MyLogger.singletonMyLogger().printToStdOut(3, "First class setStringValue(String sIn) method has been called");
		StringValue = sIn;
	}

	/**
	 * hashCode() method
	 */
	@Override
	public int hashCode() {
		MyLogger.singletonMyLogger().printToStdOut(3, "First class hashCode() method has been called");
		final int prime = 31;
		int result = 1;
		result = prime * result + IntValue;
		result = prime * result
				+ ((StringValue == null) ? 0 : StringValue.hashCode());
		return result;
	}

	/**
	 * returns true if two objects are equal
	 */
	@Override
	public boolean equals(Object obj) {
		MyLogger.singletonMyLogger().printToStdOut(3, "First class equals(Object obj) method has been called");
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		First other = (First) obj;
		if (IntValue != other.IntValue)
			return false;
		if (StringValue == null) {
			if (other.StringValue != null)
				return false;
		} else if (!StringValue.equals(other.StringValue))
			return false;
		return true;
	}

	/**
	 * toString method
	 */
	@Override
	public String toString() {
		MyLogger.singletonMyLogger().printToStdOut(3, "First class toString() method has been called");
		return "First [IntValue=" + IntValue + ", StringValue=" + StringValue
				+ "]";
	}
	
}
