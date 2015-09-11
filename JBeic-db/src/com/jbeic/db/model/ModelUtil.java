package com.jbeic.db.model;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.jbeic.db.Annotation.Table;
import com.jbeic.db.Annotation.TableField;
import com.jbeic.db.Info.FieldInfo;
import com.jbeic.db.exception.JBeicException;
import com.jbeic.db.log.JBeicLog;

public class ModelUtil {
	/**
	 * TODO 获取表名 .<br>
	 * 如果该类没有进行@Table注解的tableName值，默认采用类名
	 * 
	 * @param cls
	 * @return String
	 * @throws JBeicException
	 */
	public static String getTableName(Class<? extends Object> cls) {
		String tableName = cls.getName();// 默认为com.jbeic.db.test.MyTest
		Annotation[] classAnnos = cls.getAnnotations();
		boolean haveTableAnnotation = false;// 此类是否拥有@Table注解
		for (Annotation classAnno : classAnnos) {
			if (classAnno instanceof Table) {
				if (!((Table) classAnno).tableName().equals("")) {
					tableName = ((Table) classAnno).tableName();
					// 判断是否首字符为字母
					if ((tableName.charAt(0) < 'A' || tableName.charAt(0) > 'Z') && (tableName.charAt(0) < 'a' || tableName.charAt(0) > 'z')) {
						try {
							throw new JBeicException("表名的首字符必须为字母:" + tableName);
						} catch (JBeicException e) {
							e.printStackTrace();
						}
					}
					// 此类拥有@Table注解
					haveTableAnnotation = true;
					break;
				}
			}
		}
		// 获取它的类名，将com.jbeic.db.test.MyTest转为为MyTest
		tableName=getEndValue(tableName);
		// warning
		if (!haveTableAnnotation)
			JBeicLog.W(cls.getName() + "类没有进行@Table注解");
		return tableName;

	}

	/**
	 * TODO 获取所有字段属性       .<br>
	 *
	 * @param cls
	 * @return  List<FieldInfo> 
	 */
	public static List<FieldInfo> getFieldInfoList(Class<? extends Object> cls) {
		List<FieldInfo> fieldInfoList = new ArrayList<FieldInfo>();
		Field[] Fields = cls.getDeclaredFields();
		for (Field field : Fields) {
			Annotation annos[] = field.getDeclaredAnnotations();
			for (Annotation ann : annos) {
				if (ann instanceof TableField) {
					TableField tableField = (TableField) ann;
					String filedName = field.getName();
					if (!tableField.fieldName().equals("")) {
						filedName = tableField.fieldName();
						// 判断是否首字符为字母
						if ((filedName.charAt(0) < 'A' || filedName.charAt(0) > 'Z') && (filedName.charAt(0) < 'a' || filedName.charAt(0) > 'z')) {
							try {
								throw new JBeicException("字段名的首字符必须为字母:" + filedName);
							} catch (JBeicException e) {
								e.printStackTrace();
							}
						}
					}

					String fieldtype = field.getType().getName();
					// 将com.jbeic.db.test.String转为String
					fieldtype=getFieldType(fieldtype);
					
					if(fieldtype.equals("other")){
						continue;
					}
					
					boolean isNull = tableField.isNull();
					boolean isKey = tableField.isKey();
					if(isKey)isNull=false;//主键不能为空
					int size = tableField.size();
					FieldInfo fInfo = new FieldInfo.Builder().filedName(filedName).fieldtype(fieldtype).isKey(isKey).isNull(isNull).size(size).build();
					fieldInfoList.add(fInfo);
				}

			}
		}
		return fieldInfoList;
	}

	/**
	 * TODO 将com.jbeic.db.test.String转为String.<br>
	 * @param value
	 * @return String
	 */
	public static String getEndValue(String value) {
		String[] temp = value.split("\\.");
		value = temp[temp.length - 1];
		return value;
	}

	/**
	 * TODO 获取基本常用类型的字段类型，其他类型返回other .<br>
	 * @param fieldType
	 * @return  String 
	 */
	public static String getFieldType(String fieldType) {
		if (fieldType.equals(Byte.class.getName()) || fieldType.equals(byte.class.getName())) {
		} else if (fieldType.equals(Short.class.getName()) || fieldType.equals(short.class.getName())) {

		} else if (fieldType.equals(Integer.class.getName()) || fieldType.equals(int.class.getName())) {

		} else if (fieldType.equals(Long.class.getName()) || fieldType.equals(long.class.getName())) {

		} else if (fieldType.equals(Float.class.getName()) || fieldType.equals(float.class.getName())) {

		} else if (fieldType.equals(Double.class.getName()) || fieldType.equals(double.class.getName())) {

		} else if (fieldType.equals(Boolean.class.getName()) || fieldType.equals(boolean.class.getName())) {

		} else if (fieldType.equals(Character.class.getName()) || fieldType.equals(char.class.getName())) {

		} else if (fieldType.equals(String.class.getName())) {

		} else {
			JBeicLog.W("现阶段不支持"+fieldType+"字段类型，已自动过滤");
			return "other";
		}
		return getEndValue(fieldType);
	}

}
