package com.jbeic.db.test;

import com.jbeic.db.Annotation.Table;
import com.jbeic.db.Annotation.TableField;

@Table(tableName = "Mt")
public class MyTest  {
	@TableField(isKey=true,isNull=true)
	private String id;
	@TableField(isKey=false,isNull=true)
	private String filed1;
	@TableField(isKey=false,isNull=true)
	private String filed2;
	@TableField(isKey=false,isNull=false)
	private String filed3;
	@TableField
	private StudenBean sdsada;
	
	
	public String getFiled1() {
		return filed1;
	}
	public void setFiled1(String filed1) {
		this.filed1 = filed1;
	}
	public String getFiled2() {
		return filed2;
	}
	public void setFiled2(String filed2) {
		this.filed2 = filed2;
	}
	

}
