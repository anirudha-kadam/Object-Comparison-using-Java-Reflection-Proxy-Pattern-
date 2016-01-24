package objComp.reflection;

/**
 * 
 * @author Anirudha
 * provides method to create instance of a class runtime
 */
public interface ReflectionInterface {
	
	/**
	 * creates instance of an object 
	 * @param className
	 * @param dataMember
	 * @param obj
	 * @return
	 */
	public Object createInstance(String className, String dataMember[], Object obj);
	
}
