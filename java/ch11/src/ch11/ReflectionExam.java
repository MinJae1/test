package ch11;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Class cl = null;
		try {
			cl = Class.forName("ch11.Reflection_Car");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Constructor[] cons = cl.getDeclaredConstructors();
		for (Constructor constructor : cons) {
			System.out.print(constructor.getName() + "(");
			Class[] para = constructor.getParameterTypes();
			printParameters(para);
			System.out.println(")");
		}
		System.out.println();

		Field[] fields = cl.getDeclaredFields();
		for (Field field : fields) {
			System.out.println(field.getType().getSimpleName() + " " + field.getName());
		}
		System.out.println();

		Method[] methods = cl.getDeclaredMethods();

		for (Method method : methods) {
			System.out.print(method.getName() + "(");
			Class[] para = method.getParameterTypes();
			printParameters(para);
			System.out.println(")");
		}
	}

	private static void printParameters(Class[] para) {
		// TODO Auto-generated method stub
		for (int i = 0; i < para.length; i++) {
			System.out.print(para[i].getName());
			if (i < (para.length - 1)) {
				System.out.println(",");
			}
		}
	}

}
