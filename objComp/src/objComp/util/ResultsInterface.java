package objComp.util;

/**
 * 
 * @author Anirudha
 * provides methods related to processing of results
 */
public interface ResultsInterface {

	/**
	 * deserializes object from string
	 * @param objectString
	 * @return obj
	 */
	public Object deserObjects(String className);
	
	/**
	 * Populates objects into hashmap
	 */
	public void populateObjects();
	
	/**
	 * puts object into hashmap
	 * @param obj
	 */
	public void put(Object obj);
}
