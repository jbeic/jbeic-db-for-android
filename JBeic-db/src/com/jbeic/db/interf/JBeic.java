package com.jbeic.db.interf;

import com.jbeic.db.model.BaseModel;


/**
 * TODO 简述                 .<br>
 *<p>TODO 详细描述</p>
 *
 * <p>Copyright: 版权所有 (c) JBeic</p>
 *
 * @author JBeic
 * @version V1.0 2015年9月11日
 */
public class JBeic extends BaseModel {
	
	private static JBeic jBeic;
	
	private static JBeic getjBeic() {
		if(jBeic==null)
			jBeic=new JBeic();
		return jBeic;
	}
	/**
	 * 是否显示执行SQL。
	 */
	public static boolean showSQL=false;
	
	/**
	 * 是否进行强制修改。
	 */
	public static boolean forceAlter=false;
	
	
	public  static boolean create(Object object) {
		return getjBeic().createDB(object);	
		
	}
	
	

}
