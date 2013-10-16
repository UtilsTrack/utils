package pub.utils.reflections.clone;

import java.lang.reflect.Field;

public class CloneUtils {

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
