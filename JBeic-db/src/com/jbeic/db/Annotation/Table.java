package com.jbeic.db.Annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * TODO ����   ��ʶ����              .<br>
 *<p>TODO ��ϸ����������ĳ��ģ��Ҫ���ɵı���</p>
 *
 * <p>Copyright: ��Ȩ���� (c) JBeic</p>
 *
 * @author JBeic
 * @version V1.0 2015��9��11��
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface Table {
	/**
	 * Ҫ���ɵı����ƣ�Ϊ��ʱ����������Ϊ����
	 */
	String tableName() default "";
}
