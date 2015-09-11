package com.jbeic.db.Info;

import java.util.List;

import com.jbeic.db.Info.FieldInfo.Builder;

/**
 * TODO 简述                 .<br>
 *<p>TODO 详细描述</p>
 *
 * <p>Copyright: 版权所有 (c) JBeic</p>
 *
 * @author JBeic
 * @version V1.0 2015年9月11日
 */
public class TableInfo {
	public final static int TABLE_NAME_MAX_LENGTH=30;//数据库表名最长字符
	
	private final String tableName;//表名称
	private final List<FieldInfo> fieldInfoList;//是否主键
	
	TableInfo(Builder builder){
		tableName=builder.tableName;
		fieldInfoList=builder.fieldInfoList;
	}
	
	public static class Builder {
		private  String tableName;
		private  List<FieldInfo> fieldInfoList;
		public Builder tableName(String tableName){
			this.tableName=tableName;
			return this;
		}
		
		public Builder fieldInfoList(List<FieldInfo> fieldInfoList){
			this.fieldInfoList=fieldInfoList;
			return this;
		}
		
		public TableInfo build(){
			return new TableInfo(this);
		}
	}
	
	

	public String getTableName() {
		return tableName;
	}



	public List<FieldInfo> getFieldInfoList() {
		return fieldInfoList;
	}



	@Override
	public String toString() {
		StringBuilder sBuilder= new StringBuilder();
		sBuilder.append("表名称：");
		sBuilder.append(tableName);
		for(FieldInfo info:fieldInfoList){
			sBuilder.append("\n字段名:").append(info.getFiledName()).append("\t字段类型:").append(info.getFieldtype()).append("\t主键:").append(info.isKey()).append("\t为空:").append(info.isNull()).append("\t大小:").append(info.getSize());
		}
		return sBuilder.toString();
	}
}
