package com.jbeic.db.model;

import java.util.List;

import com.jbeic.db.Info.FieldInfo;
import com.jbeic.db.Info.TableInfo;

public class SQLModel implements Mode {

	@Override
	public boolean createDB(Object object) {
		StringBuilder sbBuilder=new StringBuilder();
		TableInfo tableinfo=(TableInfo)object;
		sbBuilder.append("create table ").append(tableinfo.getTableName()).append("(\n");
		List<FieldInfo>  fieldInfos= tableinfo.getFieldInfoList();
		for(FieldInfo info:fieldInfos){
			sbBuilder.append(info.getFiledName()).append(" ");
			if(info.getFieldtype().equals("String"))
				sbBuilder.append("TEXT");
			else if(info.getFieldtype().equals("int"))
				sbBuilder.append("INTEGER");
			else if(info.getFieldtype().equals("double"))
				sbBuilder.append("NUMERIC");
			if(info.isNull())sbBuilder.append(" null ");
			else sbBuilder.append(" not null ");
			if(info.isKey())sbBuilder.append(" PRIMARY KEY ");
			sbBuilder.append(",\n");
		}
		sbBuilder.append(")");
		System.err.println(sbBuilder.toString());
		
		return false;
	}

	@Override
	public boolean addDB(Object object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int deleteDB(Object object) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateDB(Object object) {
		// TODO Auto-generated method stub
		return 0;
	}

}
