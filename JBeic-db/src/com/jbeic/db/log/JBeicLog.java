package com.jbeic.db.log;

/**
 * TODO ����     JBeic ��־������          .<br>
 *<p>TODO ��ϸ������
 *EΪerror������Ϣ��WΪwarning������Ϣ��IΪһ����ʾ�Ե�information��Ϣ
 *</p>
 *
 * <p>Copyright: ��Ȩ���� (c) JBeic</p>
 *
 * @author JBeic
 * @version V1.0 2015��9��11��
 */
public class JBeicLog {
	
	/**
	 * ���error������Ϣ        .<br>
	 */
	public static void E(String err){
		System.err.println("JBeic-Error:"+err);
	}
	/**
	 * warning������Ϣ        .<br>
	 */
	public static void W(String warning){
		System.out.println("JBeic-Warning:"+warning);
	}
	/**
	 * ���һ����ʾ�Ե�information��Ϣ       .<br>
	 */
	public static void I(String information){
		System.out.println("JBeic-Information:"+information);
	}

}
