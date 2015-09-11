package annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyMain {

	public static void main(String[] args) {
		/*try {
			Class cls = Class.forName("annotation.App");
			for (Method method : cls.getMethods()) {
				MethodInfo methodInfo = method.getAnnotation(MethodInfo.class);
				if (methodInfo != null) {
					System.out.println("method name:" + method.getName());
					System.out.println("method author:" + methodInfo.author());
					System.out.println("method version:" + methodInfo.version());
					System.out.println("method date:" + methodInfo.date());
				}
			}
			// 收集所有注解的field
			SearchClassField(Class.forName("annotation.App"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}*/

		DeleteInvocationHandler timingInvocationHandler = new DeleteInvocationHandler(new App());
		MyDelete operate = (MyDelete) (Proxy.newProxyInstance(MyDelete.class.getClassLoader(), new Class[] { MyDelete.class }, timingInvocationHandler));
		operate.delete();

	}

	public static void SearchClassField(Class classes) {
		for (Field fields : classes.getFields()) {
			IsDeleteFiled filedInfo = fields.getAnnotation(IsDeleteFiled.class);
			if (filedInfo != null) {
				System.out.println("method name:" + filedInfo.isfiled());
			}
		}
	}

}
