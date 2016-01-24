package objComp.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import objComp.util.MyLogger;
import objComp.util.PopulateObjects;

/**
 * 
 * @author Anirudha
 * provides method to create instance of a class runtime
 * implements {@link ReflectionInterface}
 */
public class Reflection implements ReflectionInterface{

	/**
	 * {@link Reflection} class default constructor
	 */
	public Reflection(){
		MyLogger.singletonMyLogger().printToStdOut(2, "Reflection class default constructor has been called");
	}
	
	/**
	 * creates instance of an object 
	 * @param className
	 * @param dataMember
	 * @param obj
	 * @return
	 */
	public Object createInstance(String className, String dataMember[], Object obj){
		MyLogger.singletonMyLogger().printToStdOut(3, "Reflection class createInstance(String className, String dataMember[], Object obj) method has been called");
	    
		Class<?> cls = null;
		try {
			
			cls = Class.forName(className);
			if(obj == null){
				obj = cls.newInstance(); 
			}
			Class<?>[] signature = new Class[1];  
		    signature[0] = PopulateObjects.dataTypeMap.get(dataMember[0]);	
		    String methodName = "set" + dataMember[1]; 	       
		    Method meth = cls.getMethod(methodName, signature); 
		    Object[] params = new Object[1]; 
		    params[0] = handleDataTypes(dataMember[0], dataMember[2]);	
		    meth.invoke(obj, params); 
		    
		} catch (ClassNotFoundException e) {
			System.err.println("Caught ClassNotFoundException exception: "+e.getMessage());
		} catch (InstantiationException e) {
			System.err.println("Caught InstantiationException exception: "+e.getMessage());
		} catch (IllegalAccessException e) {
			System.err.println("Caught IllegalAccessException exception: "+e.getMessage());
		} catch (NoSuchMethodException e) {
			System.err.println("Caught NoSuchMethodException exception: "+e.getMessage());
		} catch (SecurityException e) {
			System.err.println("Caught SecurityException exception: "+e.getMessage());
		} catch (IllegalArgumentException e) {
			System.err.println("Caught IllegalArgumentException exception: "+e.getMessage());
		} catch (InvocationTargetException e) {
			System.err.println("Caught InvocationTargetException exception: "+e.getMessage());
		}finally{
			
		} 
		
		return obj;
	}
	
	/**
	 * handle data types dynamically
	 * @param dataType
	 * @param data
	 * @return
	 */
	private Object handleDataTypes(String dataType, String data){
		MyLogger.singletonMyLogger().printToStdOut(3, "Reflection class handleDataTypes(String dataType, String data) method has been called");
		Object obj = null;
		if(dataType.equals("int") || dataType.equals("Integer")){
			obj = new Integer(data);
		}else if(dataType.equals("double") || dataType.equals("Double")){
			obj = new Double(data);
		}else if(dataType.equals("String")){
			obj = new String(data);
		}
		return obj;
	}
}
