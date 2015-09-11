package com.jbeic.db.Annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * TODO 简述   标识主键              .<br>
 *<p>TODO 详细描述：用于标识某个field字段为主键</p>
 *
 * <p>Copyright: 版权所有 (c) JBeic</p>
 *
 * @author JBeic
 * @version V1.0 2015年9月11日
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Inherited
public @interface TableField  {
	/**
	 * 要生成的字段名称，为空时采用字段名称为字段名
	 */
	String fieldName() default "";
	/**
	 * 是否为主键字段
	 */
	boolean isKey() default false;
	/**
	 *  字段大小
	 */
	int size() default 100;
	/**
	 *  是否可以为空
	 */
	boolean isNull() default true;

}
