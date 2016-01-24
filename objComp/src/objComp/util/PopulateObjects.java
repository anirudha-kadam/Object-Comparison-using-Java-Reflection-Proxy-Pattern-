package objComp.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import objComp.fileOperations.FileInterface;
import objComp.reflection.Reflection;
import objComp.reflection.ReflectionInterface;

/**
 * 
 * @author Anirudha Kadam
 * provides populateObjcts and deserObjects methods
 * implements {@link ResultsInterface}, {@link DisplayInterface}
 */
public class PopulateObjects implements ResultsInterface, DisplayInterface{
	
	/**
	 * hashMap to store deserialized objects
	 */
	private Map<Object, Integer> deserObjMap = null;
	
	/**
	 * hashMap to store dataTypes
	 */
	public static Map<String, Class<?>> dataTypeMap = null;
	
	private FileInterface fileProcessor = null;
	
	private ReflectionInterface reflection = null;
	
	/**
	 * {@link PopulateObjects} class default constructor
	 */
	public PopulateObjects(){
		MyLogger.singletonMyLogger().printToStdOut(2, "PopulateObjects class default constructor has been called");
	} 
	
	/**
	 * {@link PopulateObjects} class parameterized constructor
	 * @param fileProcessorIn
	 */
	public PopulateObjects(FileInterface fileProcessorIn){
		MyLogger.singletonMyLogger().printToStdOut(2, "PopulateObjects class parameterized constructor has been called");
		deserObjMap = new HashMap<Object, Integer>();
		dataTypeMap = new HashMap<String, Class<?>>();
		fileProcessor = fileProcessorIn;
		reflection = new Reflection();
		populateDataTypes();
	}
	
	/**
	 * deserializes object from string
	 * @param objectString
	 * @return obj
	 */
	public Object deserObjects(String className){
		MyLogger.singletonMyLogger().printToStdOut(2, "PopulateObjects class parameterized constructor has been called");
		int dataMemberCount = 0;
		String dataMember = null;
		Object obj = null;
		while(dataMemberCount < 2){
			dataMember = fileProcessor.readFromFile();
			obj = reflection.createInstance(className, parseInputString(dataMember), obj);
			dataMemberCount++;
		}
		return obj;
	}
	
	/**
	 * Populates objects into hashmap
	 */
	public void populateObjects(){
		MyLogger.singletonMyLogger().printToStdOut(3, "PopulateObjects class populateObjects() method has been called");
		String inputString = null;
		String processedInput[] = null;
		fileProcessor.openInputFile();
		while((inputString = fileProcessor.readFromFile()) != null){
			processedInput = parseInputString(inputString);
			Object currentObj = deserObjects(processedInput[1]);
			put(currentObj);
		}
		fileProcessor.closeInputFile();
	}
	
	/**
	 * puts object into hashmap
	 * @param obj
	 */
	public void put(Object obj){
		MyLogger.singletonMyLogger().printToStdOut(3, "PopulateObjects class put(Object obj) method has been called");
		Integer count = deserObjMap.get(obj);
		if(count == null){
			deserObjMap.put(obj, 1);
		}else{
			deserObjMap.put(obj, count + 1);
		}
		MyLogger.singletonMyLogger().printToStdOut(1, "Object has been added to HashMap");
	}
	
	/**
	 * parse input
	 * @param inputString
	 * @return
	 */
	private String[] parseInputString(String inputString){
		MyLogger.singletonMyLogger().printToStdOut(3, "PopulateObjects class parseInputString(String inputString) method has been called");
		String processedInput[] = null;
		String intermediateInput[];
		if(inputString.startsWith("fqn")){
			processedInput = inputString.split(":");
		}else{
			intermediateInput = inputString.split(", ");
			processedInput = new String[intermediateInput.length];
			for(int i = 0; i < intermediateInput.length; i++){
				processedInput[i] = intermediateInput[i].split("=")[1];
			}
		}
		return processedInput;
	}
	
	/**
	 * populates dataTypeMao with default dataType classes
	 */
	private void populateDataTypes(){
		MyLogger.singletonMyLogger().printToStdOut(3, "PopulateObjects class populateDataTypes() method has been called");
		dataTypeMap.put("int", Integer.TYPE);
		dataTypeMap.put("double", Double.TYPE);
		dataTypeMap.put("String", String.class);
		dataTypeMap.put("Integer", Integer.class);
		dataTypeMap.put("Double", Double.class);
	}
	
	/**
	 * prints output to console
	 */
	public void printOutput(){
		MyLogger.singletonMyLogger().printToStdOut(3, "PopulateObjects class printOutput() method has been called");
		int nonDupFirst = 0, nonDupSecond = 0, totalFirst = 0, totalSecond = 0;
		for(Entry<Object, Integer> entry : deserObjMap.entrySet()) {
			Object key = entry.getKey();
			int value = entry.getValue();
			if(key instanceof First){
				nonDupFirst++;
				totalFirst += value;
			}else if(key instanceof Second){
				nonDupSecond++;
				totalSecond += value;
			}
		}
		MyLogger.singletonMyLogger().printToStdOut(0, "Number of non-duplidate First objects: "+ nonDupFirst +
													  "\nTotal Number of First objects: "+ totalFirst +
													  "\nNumber of non-duplidate Second objects: "+ nonDupSecond +
													  "\nTotal Number of Second objects: "+ totalSecond);
	}

	/**
	 * toString method
	 */
	@Override
	public String toString() {
		MyLogger.singletonMyLogger().printToStdOut(3, "PopulateObjects class toString() method has been called");
		return "PopulateObjects [deserObjMap=" + deserObjMap + "]";
	}
	
}
