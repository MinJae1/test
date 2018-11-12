package ch06;

import java.lang.reflect.Method;

public class PrintAnnotationExam {
	public static void main(String[] args) {
		Method[] declaredMethods = Service.class.getDeclaredMethods();
		// Method ��ü ó��
		for (Method method : declaredMethods) {
			// PrintAnnotation ����Ȯ��
			if (method.isAnnotationPresent(PrintAnnotation.class)) {
				// ��ü���
				PrintAnnotation printAnnotation = method.getAnnotation(PrintAnnotation.class);

				System.out.println("[" + method.getName() + "] ");

				for (int i = 0; i < printAnnotation.number(); i++) {
					System.out.print(printAnnotation.value());
				}
				System.out.println();

				try {
					method.invoke(new Service());
				} catch (Exception e) {
					// TODO: handle exception
				}
				System.out.println();
			}
		}
	}
}
