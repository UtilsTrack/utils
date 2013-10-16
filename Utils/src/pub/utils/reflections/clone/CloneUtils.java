package pub.utils.reflections.clone;

import java.lang.reflect.Field;

/**
 * Class to clone any object
 * @author Eduardo
 *
 */
public class CloneUtils {

	/**
	 * Shallow clone any object
	 * @param Object
	 * @return new Object
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 */
	
	public synchronized static Object clone(Object obj) throws InstantiationException, IllegalAccessException, SecurityException, NoSuchFieldException  {
		
		Object newObj = obj.getClass().newInstance();
		
		Field[] fields = obj.getClass().getDeclaredFields();
		Field tmpField = null;
		for(Field f : fields){
			f.setAccessible(true);
			tmpField = newObj.getClass().getDeclaredField(f.getName());
			tmpField.setAccessible(true);
			tmpField.set(newObj, f.get(obj));
		}
			
		return newObj;
	}
}
