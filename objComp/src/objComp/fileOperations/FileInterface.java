package objComp.fileOperations;

/**
 * 
 * @author Anirudha
 * provides interface for methods related to file operations
 */
public interface FileInterface {
	
	/**
	 * reads a line from file
	 * @return
	 */
	public String readFromFile();
	
	
	/**
	 * opens file to be read from
	 * @param br
	 */
	public void openInputFile();
	
	
	/**
	 * closes file currently reading from
	 * @param br
	 */
	public void closeInputFile();
	
}
