package objComp.driver;

import objComp.fileOperations.FileInterface;
import objComp.fileOperations.FileProcessor;
import objComp.util.DisplayInterface;
import objComp.util.MyLogger;
import objComp.util.PopulateObjects;
import objComp.util.ResultsInterface;


/**
 * 
 * @author Anirudha Kadam
 * Driver class
 */
public class Driver {
	
	/**
	 * method to validate arguments.
	 * @param arguments
	 */
	static void validateArguments(String arguments[]){
		if(arguments.length != 3){
			System.err.println("expected number of arguments are 4");
			System.exit(0);
		}	
		if(!arguments[0].endsWith(".txt")){
			System.err.println("file names should have .txt extension");
			System.exit(0);
		}
		try {
			Integer.parseInt(arguments[1]);
		} catch (NumberFormatException e) {
			System.err.println("Number of interations should be an integer: "+e.getMessage());
			System.exit(0);
		}finally{
			
		}
		try {
			Integer.parseInt(arguments[2]);
		} catch (NumberFormatException e) {
			System.err.println("debug value should be an integer: "+e.getMessage());
			System.exit(0);;
		}finally{
			
		}
	}
	
	public static void main(String[] args) {
		

			validateArguments(args);
			
			String inputFileName = args[0];
			int debugValue = Integer.parseInt(args[2]), numberOfInterations = Integer.parseInt(args[1]);
			MyLogger.setDEBUG_VALUE(debugValue);
			
			long startTime = System.currentTimeMillis();
			
			ResultsInterface populateObjects = null;
			FileInterface fileProcessor = new FileProcessor(inputFileName);;
			
			for(int i = 0; i < numberOfInterations; i++){
				populateObjects = new PopulateObjects(fileProcessor);
				populateObjects.populateObjects();
			}
			
			((DisplayInterface)populateObjects).printOutput();
			
			long finishTime = System.currentTimeMillis();
			float totalTime = (float)(finishTime-startTime)/(1000*numberOfInterations); 
			System.out.println("\nTotat Execution Time: "+totalTime +" Seconds");
			
	}

}
