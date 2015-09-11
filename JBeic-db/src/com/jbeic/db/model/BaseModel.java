package com.jbeic.db.model;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.jbeic.db.Annotation.Table;
import com.jbeic.db.Annotation.TableField;
import com.jbeic.db.Info.FieldInfo;
import com.jbeic.db.Info.FieldInfo.Builder;
import com.jbeic.db.Info.TableInfo;
import com.jbeic.db.exception.JBeicException;
import com.jbeic.db.log.JBeicLog;
import com.jbeic.db.model.ModelUtil;

public class BaseModel implements Mode {

	

	@Override
	public boolean createDB(Object object) {
		Class<? extends Object> cls = object.getClass();
		//解析类生成表信息
		TableInfo tableInfo = new TableInfo.Builder().tableName(ModelUtil.getTableName(cls)).fieldInfoList(ModelUtil.getFieldInfoList(cls)).build();
		new SQLModel().createDB(tableInfo);
		System.err.println(tableInfo.toString());
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
