package ch06;

import java.lang.reflect.Method;

public class PrintAnnotationExam {
	public static void main(String[] args) {
		Method[] declaredMethods = Service.class.getDeclaredMethods();
		// Method 객체 처리
		for (Method method : declaredMethods) {
			// PrintAnnotation 적용확인
			if (method.isAnnotationPresent(PrintAnnotation.class)) {
				// 객체얻기
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
