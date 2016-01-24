package objComp.fileOperations;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import objComp.util.MyLogger;


/**
 * 
 * @author Anirudha Kadam
 * provides implementation of openFile(), readFromFile(), 
 * closeFile() methods
 * implements {@link FileInterface}
 */
public class FileProcessor implements FileInterface {
	
	private String inputFileName;
	
	private BufferedReader br = null;
	
	/**
	 * {@link FileProcessor} class default constructor
	 */
	public FileProcessor(){
		MyLogger.singletonMyLogger().printToStdOut(2, "FileProcessor class default constructor has been called");
	}
	
	/**
	 * {@link FileProcessor} class parameterized constructor
	 * @param inputFileNameIn
	 * @param outputFileNameIn
	 */
	public FileProcessor(String inputFileNameIn){
		MyLogger.singletonMyLogger().printToStdOut(2, "FileProcessor class parameterized constructor has been called");
		inputFileName = inputFileNameIn;
	}
	
	/**
	 * reads line from file
	 */
	public String readFromFile() {
		MyLogger.singletonMyLogger().printToStdOut(3, "FileProcessor class readFromFile() method has been called");
		String currentLine = null;
		try {
			currentLine = br.readLine();
		} catch (IOException e) {
			System.err.println("Caught IOException: "+e.getMessage());
			System.exit(0);
		}finally{
			
		}
		return currentLine;
	}

	

	/**
	 * {@link FileProcessor} class toString() method
	 */
	@Override
	public String toString() {
		MyLogger.singletonMyLogger().printToStdOut(3, "FileProcessor class toString() method has been called");
		return "FileProcessor [inputFileName=" + inputFileName+"]";
	}


	/**
	 * opens file to be read from
	 * @param br
	 */
	public void openInputFile() {
		MyLogger.singletonMyLogger().printToStdOut(3, "FileProcessor class openFile(BufferedReader br) method has been called");
		try {
			File file = new File(inputFileName);
			if(file.exists() && file.length() == 0){
				System.err.println("File is empty!");
				System.exit(0);
			}
			br = new BufferedReader(new InputStreamReader(new FileInputStream(inputFileName), "UTF-8"));
		} catch (FileNotFoundException e) {
			System.err.println("Caught FileNotFoundException: "+e.getMessage());
			System.exit(0);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}finally{
			
		}	
	}

	

	/**
	 * closes file currently reading from
	 * @param br
	 */
	public void closeInputFile() {
		MyLogger.singletonMyLogger().printToStdOut(3, "FileProcessor class closeFile(BufferedReader br) method has been called");
		try {
			br.close();
		} catch (IOException e) {
			System.err.println("Caught IOException: "+e.getMessage());
		}finally{
			
		}
	}

}
