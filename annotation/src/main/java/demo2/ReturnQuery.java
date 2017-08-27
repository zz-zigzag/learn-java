package demo2;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReturnQuery {
	public static String Query(Object u) {
		Class<? extends Object> c = u.getClass();
		if (!c.isAnnotationPresent(Table.class))
			return null;

		Table t = (Table) c.getAnnotation(Table.class);
		String tableName = t.value();
		StringBuilder sqlString = new StringBuilder();
		sqlString.append("select * from ").append(tableName).append(" where 1=1 ");
		Field[] fArray = c.getDeclaredFields();
		for (Field field : fArray) {
			if (!field.isAnnotationPresent(Column.class))
				continue;
			Column column = (Column) field.getAnnotation(Column.class);
			String columnName = column.value();
			String fieldName = field.getName();
			String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
			Object fieldValue = null;
			try {
				Method getMethod = c.getMethod(getMethodName);
				fieldValue = getMethod.invoke(u);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (fieldValue == null || (fieldValue instanceof Integer && (Integer)fieldValue == 0)) {
				continue;
			}
			sqlString.append(" and ").append(columnName);
			if (fieldValue instanceof String) {
				if(((String) fieldValue).contains(",")) {
					fieldValue = ((String) fieldValue).replaceAll(",", "', '");
					sqlString.append(" in ('").append(fieldValue).append("')");
				} else {
					sqlString.append(" = '").append(fieldValue).append("'");
				}
			} else if (fieldValue instanceof Integer) {
				sqlString.append(" = ").append(fieldValue);
			}
		}
		return sqlString.toString();
	}
}
