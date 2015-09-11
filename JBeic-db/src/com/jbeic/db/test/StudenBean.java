package com.jbeic.db.test;

import com.jbeic.db.Annotation.TableField;

public class StudenBean {
	@TableField
	private int age;
	@TableField
	private String name;
	@TableField
	private int num;
	private int nums;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	

}
