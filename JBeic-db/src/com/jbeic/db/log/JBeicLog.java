package com.jbeic.db.log;

/**
 * TODO 简述     JBeic 日志输入类          .<br>
 *<p>TODO 详细描述：
 *E为error错误信息，W为warning警告信息，I为一般提示性的information消息
 *</p>
 *
 * <p>Copyright: 版权所有 (c) JBeic</p>
 *
 * @author JBeic
 * @version V1.0 2015年9月11日
 */
public class JBeicLog {
	
	/**
	 * 输出error错误信息        .<br>
	 */
	public static void E(String err){
		System.err.println("JBeic-Error:"+err);
	}
	/**
	 * warning警告信息        .<br>
	 */
	public static void W(String warning){
		System.out.println("JBeic-Warning:"+warning);
	}
	/**
	 * 输出一般提示性的information消息       .<br>
	 */
	public static void I(String information){
		System.out.println("JBeic-Information:"+information);
	}

}
