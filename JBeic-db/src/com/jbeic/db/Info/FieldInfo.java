package com.jbeic.db.Info;

public class FieldInfo {
	private final String filedName;//�ֶ�����
	private final boolean isKey;//�Ƿ�����
	private final String fieldtype;//�ֶ�����
	private final boolean isNull;//�Ƿ�Ϊ��
	private final int size;//�ֶδ�С
	public FieldInfo(Builder builder){
		filedName=builder.filedName;
		isKey=builder.isKey;
		fieldtype=builder.fieldtype;
		isNull=builder.isNull;
		size=builder.size;
	} 
	public static class Builder {
		private  String filedName;
		private  boolean isKey;
		private  String fieldtype;
		private  boolean isNull;
		private  int size;
		public Builder filedName(String filedName){
			this.filedName=filedName;
			return this;
		}
		public Builder isKey(boolean isKey){
			this.isKey=isKey;
			return this;
		}
		public Builder fieldtype(String fieldtype){
			this.fieldtype=fieldtype;
			return this;
		}
		public Builder isNull(boolean isNull){
			this.isNull=isNull;
			return this;
		}
		public Builder size(int size){
			this.size=size;
			return this;
		}
		public FieldInfo build(){
			return new FieldInfo(this);
		}
		
	}
	public String getFiledName() {
		return filedName;
	}
	public boolean isKey() {
		return isKey;
	}
	public String getFieldtype() {
		return fieldtype;
	}
	public boolean isNull() {
		return isNull;
	}
	public int getSize() {
		return size;
	}
	
	
	

}
