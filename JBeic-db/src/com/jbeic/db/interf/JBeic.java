package com.jbeic.db.interf;

import com.jbeic.db.model.BaseModel;


/**
 * TODO ����                 .<br>
 *<p>TODO ��ϸ����</p>
 *
 * <p>Copyright: ��Ȩ���� (c) JBeic</p>
 *
 * @author JBeic
 * @version V1.0 2015��9��11��
 */
public class JBeic extends BaseModel {
	
	private static JBeic jBeic;
	
	private static JBeic getjBeic() {
		if(jBeic==null)
			jBeic=new JBeic();
		return jBeic;
	}
	/**
	 * �Ƿ���ʾִ��SQL��
	 */
	public static boolean showSQL=false;
	
	/**
	 * �Ƿ����ǿ���޸ġ�
	 */
	public static boolean forceAlter=false;
	
	
	public  static boolean create(Object object) {
		return getjBeic().createDB(object);	
		
	}
	
	

}
