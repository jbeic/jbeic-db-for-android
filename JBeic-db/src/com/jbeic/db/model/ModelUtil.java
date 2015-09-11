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
	 * TODO ��ȡ���� .<br>
	 * �������û�н���@Tableע���tableNameֵ��Ĭ�ϲ�������
	 * 
	 * @param cls
	 * @return String
	 * @throws JBeicException
	 */
	public static String getTableName(Class<? extends Object> cls) {
		String tableName = cls.getName();// Ĭ��Ϊcom.jbeic.db.test.MyTest
		Annotation[] classAnnos = cls.getAnnotations();
		boolean haveTableAnnotation = false;// �����Ƿ�ӵ��@Tableע��
		for (Annotation classAnno : classAnnos) {
			if (classAnno instanceof Table) {
				if (!((Table) classAnno).tableName().equals("")) {
					tableName = ((Table) classAnno).tableName();
					// �ж��Ƿ����ַ�Ϊ��ĸ
					if ((tableName.charAt(0) < 'A' || tableName.charAt(0) > 'Z') && (tableName.charAt(0) < 'a' || tableName.charAt(0) > 'z')) {
						try {
							throw new JBeicException("���������ַ�����Ϊ��ĸ:" + tableName);
						} catch (JBeicException e) {
							e.printStackTrace();
						}
					}
					// ����ӵ��@Tableע��
					haveTableAnnotation = true;
					break;
				}
			}
		}
		// ��ȡ������������com.jbeic.db.test.MyTestתΪΪMyTest
		tableName=getEndValue(tableName);
		// warning
		if (!haveTableAnnotation)
			JBeicLog.W(cls.getName() + "��û�н���@Tableע��");
		return tableName;

	}

	/**
	 * TODO ��ȡ�����ֶ�����       .<br>
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
						// �ж��Ƿ����ַ�Ϊ��ĸ
						if ((filedName.charAt(0) < 'A' || filedName.charAt(0) > 'Z') && (filedName.charAt(0) < 'a' || filedName.charAt(0) > 'z')) {
							try {
								throw new JBeicException("�ֶ��������ַ�����Ϊ��ĸ:" + filedName);
							} catch (JBeicException e) {
								e.printStackTrace();
							}
						}
					}

					String fieldtype = field.getType().getName();
					// ��com.jbeic.db.test.StringתΪString
					fieldtype=getFieldType(fieldtype);
					
					if(fieldtype.equals("other")){
						continue;
					}
					
					boolean isNull = tableField.isNull();
					boolean isKey = tableField.isKey();
					if(isKey)isNull=false;//��������Ϊ��
					int size = tableField.size();
					FieldInfo fInfo = new FieldInfo.Builder().filedName(filedName).fieldtype(fieldtype).isKey(isKey).isNull(isNull).size(size).build();
					fieldInfoList.add(fInfo);
				}

			}
		}
		return fieldInfoList;
	}

	/**
	 * TODO ��com.jbeic.db.test.StringתΪString.<br>
	 * @param value
	 * @return String
	 */
	public static String getEndValue(String value) {
		String[] temp = value.split("\\.");
		value = temp[temp.length - 1];
		return value;
	}

	/**
	 * TODO ��ȡ�����������͵��ֶ����ͣ��������ͷ���other .<br>
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
			JBeicLog.W("�ֽ׶β�֧��"+fieldType+"�ֶ����ͣ����Զ�����");
			return "other";
		}
		return getEndValue(fieldType);
	}

}
