package com.jbeic.db.Info;

import java.util.List;

import com.jbeic.db.Info.FieldInfo.Builder;

/**
 * TODO ����                 .<br>
 *<p>TODO ��ϸ����</p>
 *
 * <p>Copyright: ��Ȩ���� (c) JBeic</p>
 *
 * @author JBeic
 * @version V1.0 2015��9��11��
 */
public class TableInfo {
	public final static int TABLE_NAME_MAX_LENGTH=30;//���ݿ������ַ�
	
	private final String tableName;//������
	private final List<FieldInfo> fieldInfoList;//�Ƿ�����
	
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
		sBuilder.append("�����ƣ�");
		sBuilder.append(tableName);
		for(FieldInfo info:fieldInfoList){
			sBuilder.append("\n�ֶ���:").append(info.getFiledName()).append("\t�ֶ�����:").append(info.getFieldtype()).append("\t����:").append(info.isKey()).append("\tΪ��:").append(info.isNull()).append("\t��С:").append(info.getSize());
		}
		return sBuilder.toString();
	}
}
