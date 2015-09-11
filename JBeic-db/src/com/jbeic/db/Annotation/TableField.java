package com.jbeic.db.Annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * TODO ����   ��ʶ����              .<br>
 *<p>TODO ��ϸ���������ڱ�ʶĳ��field�ֶ�Ϊ����</p>
 *
 * <p>Copyright: ��Ȩ���� (c) JBeic</p>
 *
 * @author JBeic
 * @version V1.0 2015��9��11��
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Inherited
public @interface TableField  {
	/**
	 * Ҫ���ɵ��ֶ����ƣ�Ϊ��ʱ�����ֶ�����Ϊ�ֶ���
	 */
	String fieldName() default "";
	/**
	 * �Ƿ�Ϊ�����ֶ�
	 */
	boolean isKey() default false;
	/**
	 *  �ֶδ�С
	 */
	int size() default 100;
	/**
	 *  �Ƿ����Ϊ��
	 */
	boolean isNull() default true;

}
