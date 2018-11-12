package ch11;

public class ClassExam {
	public static void main(String[] args) {
		new_Car car = new new_Car();
		Class clazz1 = car.getClass();

		System.out.println(clazz1.getName());
		System.out.println(clazz1.getSimpleName());
		System.out.println(clazz1.getPackage().getName());
		System.out.println();

		
		try {
			Class clazz2 = Class.forName("exPack.new_Car");

			System.out.println(clazz1.getName());
			System.out.println(clazz1.getSimpleName());
			System.out.println(clazz1.getPackage().getName());
			System.out.println();

		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
