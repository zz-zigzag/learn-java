package demo1;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParseAnn {

	private Logger logger = LoggerFactory.getLogger(getClass());
	@Test
	public void test() {
		try {
			Class<?> c = Class.forName("org.zz.annotation.Person");
			Class<Person> c1 = Person.class;
			if (c.isAnnotationPresent(Description.class)) {
				Description description = (Description) c.getAnnotation(Description.class);
				logger.info(description.value());
			}

			Method[] ms = c.getMethods();
			for (Method m : ms) {
				if (m.isAnnotationPresent(Description.class)) {
					logger.info(m.getAnnotation(Description.class).value());
				}
			}

			for (Method m : ms) {
				Annotation[] as = m.getAnnotations();
				for (Annotation annotation : as) {
					if (annotation instanceof Description) {
						logger.info(((Description) annotation).value());

					}
				}
			}

			Field[] fs = c1.getDeclaredFields();
			for (Field field : fs) {
				if (field.isAnnotationPresent(Description.class)) {
					logger.info(field.getAnnotation(Description.class).value());
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
