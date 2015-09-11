package annotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DeleteInvocationHandler implements InvocationHandler {
	private Object target;

    public DeleteInvocationHandler() {}

    public DeleteInvocationHandler(Object target) {
        this.target = target;
    }
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
			Class cls =target.getClass();
			for (Field fields : cls.getFields()) {
				IsKeyFiled key = fields.getAnnotation(IsKeyFiled.class);
				IsDeleteFiled filedInfo = fields.getAnnotation(IsDeleteFiled.class);
				if (key != null) {
					System.out.println("����Ϊ:" + fields.getName()+" ���ͣ�"+fields.getType());
				}
				if(filedInfo!=null)System.out.println("�ֶ�Ϊ:" + fields.getName()+" ���ͣ�"+fields.getType());
			}
			
			for (Method method2 : cls.getMethods()) {
				MethodInfo methodInfo = method2.getAnnotation(MethodInfo.class);
				if (methodInfo != null) {
					if(method2.getName().equals("delete")){
						System.err.println("������֤ɾ������....");
						Thread.sleep(2000);
					}
						
				}
			}
			//��̬����ִ��
	        Object obj = method.invoke(target, args);
	        
	        
	        for (Method method2 : cls.getMethods()) {
				MethodInfo methodInfo = method2.getAnnotation(MethodInfo.class);
				if (methodInfo != null) {
					if(method2.getName().equals("delete")){
						
						Thread.sleep(2000);
						System.err.println("ɾ��������������");
					}
						
				}
			}

	     return obj;
	}

}
